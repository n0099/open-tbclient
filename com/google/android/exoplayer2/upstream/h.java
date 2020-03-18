package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class h implements b {
    private final boolean mHI;
    private final int mHJ;
    private final byte[] mHK;
    private final a[] mHL;
    private int mHM;
    private int mHN;
    private a[] mHO;
    private int mai;

    public h(boolean z, int i) {
        this(z, i, 0);
    }

    public h(boolean z, int i, int i2) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        com.google.android.exoplayer2.util.a.checkArgument(i2 >= 0);
        this.mHI = z;
        this.mHJ = i;
        this.mHN = i2;
        this.mHO = new a[i2 + 100];
        if (i2 > 0) {
            this.mHK = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.mHO[i3] = new a(this.mHK, i3 * i);
            }
        } else {
            this.mHK = null;
        }
        this.mHL = new a[1];
    }

    public synchronized void reset() {
        if (this.mHI) {
            LX(0);
        }
    }

    public synchronized void LX(int i) {
        boolean z = i < this.mai;
        this.mai = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized a dzq() {
        a aVar;
        this.mHM++;
        if (this.mHN > 0) {
            a[] aVarArr = this.mHO;
            int i = this.mHN - 1;
            this.mHN = i;
            aVar = aVarArr[i];
            this.mHO[this.mHN] = null;
        } else {
            aVar = new a(new byte[this.mHJ], 0);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a aVar) {
        this.mHL[0] = aVar;
        a(this.mHL);
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a[] aVarArr) {
        if (this.mHN + aVarArr.length >= this.mHO.length) {
            this.mHO = (a[]) Arrays.copyOf(this.mHO, Math.max(this.mHO.length * 2, this.mHN + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            com.google.android.exoplayer2.util.a.checkArgument(aVar.data == this.mHK || aVar.data.length == this.mHJ);
            a[] aVarArr2 = this.mHO;
            int i = this.mHN;
            this.mHN = i + 1;
            aVarArr2[i] = aVar;
        }
        this.mHM -= aVarArr.length;
        notifyAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 < r7.mHN) goto L31;
     */
    @Override // com.google.android.exoplayer2.upstream.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void trim() {
        int i;
        int i2 = 0;
        synchronized (this) {
            int max = Math.max(0, v.ea(this.mai, this.mHJ) - this.mHM);
            if (max < this.mHN) {
                if (this.mHK != null) {
                    int i3 = this.mHN - 1;
                    while (i2 <= i3) {
                        a aVar = this.mHO[i2];
                        if (aVar.data == this.mHK) {
                            i2++;
                        } else {
                            a aVar2 = this.mHO[i3];
                            if (aVar2.data != this.mHK) {
                                i3--;
                            } else {
                                this.mHO[i2] = aVar2;
                                this.mHO[i3] = aVar;
                                i3--;
                                i2++;
                            }
                        }
                    }
                    i = Math.max(max, i2);
                } else {
                    i = max;
                }
                Arrays.fill(this.mHO, i, this.mHN, (Object) null);
                this.mHN = i;
            }
        }
    }

    public synchronized int dzw() {
        return this.mHM * this.mHJ;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public int dzr() {
        return this.mHJ;
    }
}
