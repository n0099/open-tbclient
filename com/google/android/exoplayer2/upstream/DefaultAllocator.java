package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class DefaultAllocator implements Allocator {
    public static final int AVAILABLE_EXTRA_CAPACITY = 100;
    public int allocatedCount;
    public Allocation[] availableAllocations;
    public int availableCount;
    public final int individualAllocationSize;
    public final byte[] initialAllocationBlock;
    public final Allocation[] singleAllocationReleaseHolder;
    public int targetBufferSize;
    public final boolean trimOnReset;

    public DefaultAllocator(boolean z, int i) {
        this(z, i, 0);
    }

    public DefaultAllocator(boolean z, int i, int i2) {
        boolean z2;
        boolean z3;
        if (i > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        if (i2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.checkArgument(z3);
        this.trimOnReset = z;
        this.individualAllocationSize = i;
        this.availableCount = i2;
        this.availableAllocations = new Allocation[i2 + 100];
        if (i2 > 0) {
            this.initialAllocationBlock = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.availableAllocations[i3] = new Allocation(this.initialAllocationBlock, i3 * i);
            }
        } else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new Allocation[1];
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized Allocation allocate() {
        Allocation allocation;
        this.allocatedCount++;
        if (this.availableCount > 0) {
            Allocation[] allocationArr = this.availableAllocations;
            int i = this.availableCount - 1;
            this.availableCount = i;
            allocation = allocationArr[i];
            this.availableAllocations[i] = null;
        } else {
            allocation = new Allocation(new byte[this.individualAllocationSize], 0);
        }
        return allocation;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public int getIndividualAllocationLength() {
        return this.individualAllocationSize;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized int getTotalBytesAllocated() {
        return this.allocatedCount * this.individualAllocationSize;
    }

    public synchronized void reset() {
        if (this.trimOnReset) {
            setTargetBufferSize(0);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation allocation) {
        this.singleAllocationReleaseHolder[0] = allocation;
        release(this.singleAllocationReleaseHolder);
    }

    public synchronized void setTargetBufferSize(int i) {
        boolean z;
        if (i < this.targetBufferSize) {
            z = true;
        } else {
            z = false;
        }
        this.targetBufferSize = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation[] allocationArr) {
        boolean z;
        if (this.availableCount + allocationArr.length >= this.availableAllocations.length) {
            this.availableAllocations = (Allocation[]) Arrays.copyOf(this.availableAllocations, Math.max(this.availableAllocations.length * 2, this.availableCount + allocationArr.length));
        }
        for (Allocation allocation : allocationArr) {
            if (allocation.data != this.initialAllocationBlock && allocation.data.length != this.individualAllocationSize) {
                z = false;
                Assertions.checkArgument(z);
                Allocation[] allocationArr2 = this.availableAllocations;
                int i = this.availableCount;
                this.availableCount = i + 1;
                allocationArr2[i] = allocation;
            }
            z = true;
            Assertions.checkArgument(z);
            Allocation[] allocationArr22 = this.availableAllocations;
            int i2 = this.availableCount;
            this.availableCount = i2 + 1;
            allocationArr22[i2] = allocation;
        }
        this.allocatedCount -= allocationArr.length;
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void trim() {
        int i = 0;
        int max = Math.max(0, Util.ceilDivide(this.targetBufferSize, this.individualAllocationSize) - this.allocatedCount);
        if (max >= this.availableCount) {
            return;
        }
        if (this.initialAllocationBlock != null) {
            int i2 = this.availableCount - 1;
            while (i <= i2) {
                Allocation allocation = this.availableAllocations[i];
                if (allocation.data == this.initialAllocationBlock) {
                    i++;
                } else {
                    Allocation allocation2 = this.availableAllocations[i2];
                    if (allocation2.data != this.initialAllocationBlock) {
                        i2--;
                    } else {
                        this.availableAllocations[i] = allocation2;
                        this.availableAllocations[i2] = allocation;
                        i2--;
                        i++;
                    }
                }
            }
            max = Math.max(max, i);
            if (max >= this.availableCount) {
                return;
            }
        }
        Arrays.fill(this.availableAllocations, max, this.availableCount, (Object) null);
        this.availableCount = max;
    }
}
