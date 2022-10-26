package com.google.android.exoplayer2.upstream;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class DefaultAllocator implements Allocator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AVAILABLE_EXTRA_CAPACITY = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public int allocatedCount;
    public Allocation[] availableAllocations;
    public int availableCount;
    public final int individualAllocationSize;
    public final byte[] initialAllocationBlock;
    public final Allocation[] singleAllocationReleaseHolder;
    public int targetBufferSize;
    public final boolean trimOnReset;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultAllocator(boolean z, int i) {
        this(z, i, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public DefaultAllocator(boolean z, int i, int i2) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
            for (int i5 = 0; i5 < i2; i5++) {
                this.availableAllocations[i5] = new Allocation(this.initialAllocationBlock, i5 * i);
            }
        } else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new Allocation[1];
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized Allocation allocate() {
        InterceptResult invokeV;
        Allocation allocation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
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
            }
            return allocation;
        }
        return (Allocation) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public int getIndividualAllocationLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.individualAllocationSize;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized int getTotalBytesAllocated() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                i = this.allocatedCount * this.individualAllocationSize;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.trimOnReset) {
                    setTargetBufferSize(0);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation allocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, allocation) == null) {
            synchronized (this) {
                this.singleAllocationReleaseHolder[0] = allocation;
                release(this.singleAllocationReleaseHolder);
            }
        }
    }

    public synchronized void setTargetBufferSize(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            synchronized (this) {
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
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation[] allocationArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, allocationArr) == null) {
            synchronized (this) {
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
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void trim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
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
    }
}
