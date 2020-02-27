package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class h implements b {
    private int lYo;
    private final boolean mFP;
    private final int mFQ;
    private final byte[] mFR;
    private final a[] mFS;
    private int mFT;
    private int mFU;
    private a[] mFV;

    public h(boolean z, int i) {
        this(z, i, 0);
    }

    public h(boolean z, int i, int i2) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        com.google.android.exoplayer2.util.a.checkArgument(i2 >= 0);
        this.mFP = z;
        this.mFQ = i;
        this.mFU = i2;
        this.mFV = new a[i2 + 100];
        if (i2 > 0) {
            this.mFR = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.mFV[i3] = new a(this.mFR, i3 * i);
            }
        } else {
            this.mFR = null;
        }
        this.mFS = new a[1];
    }

    public synchronized void reset() {
        if (this.mFP) {
            LR(0);
        }
    }

    public synchronized void LR(int i) {
        boolean z = i < this.lYo;
        this.lYo = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized a dyQ() {
        a aVar;
        this.mFT++;
        if (this.mFU > 0) {
            a[] aVarArr = this.mFV;
            int i = this.mFU - 1;
            this.mFU = i;
            aVar = aVarArr[i];
            this.mFV[this.mFU] = null;
        } else {
            aVar = new a(new byte[this.mFQ], 0);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a aVar) {
        this.mFS[0] = aVar;
        a(this.mFS);
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a[] aVarArr) {
        if (this.mFU + aVarArr.length >= this.mFV.length) {
            this.mFV = (a[]) Arrays.copyOf(this.mFV, Math.max(this.mFV.length * 2, this.mFU + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            com.google.android.exoplayer2.util.a.checkArgument(aVar.data == this.mFR || aVar.data.length == this.mFQ);
            a[] aVarArr2 = this.mFV;
            int i = this.mFU;
            this.mFU = i + 1;
            aVarArr2[i] = aVar;
        }
        this.mFT -= aVarArr.length;
        notifyAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 < r7.mFU) goto L31;
     */
    @Override // com.google.android.exoplayer2.upstream.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void trim() {
        int i;
        int i2 = 0;
        synchronized (this) {
            int max = Math.max(0, v.dZ(this.lYo, this.mFQ) - this.mFT);
            if (max < this.mFU) {
                if (this.mFR != null) {
                    int i3 = this.mFU - 1;
                    while (i2 <= i3) {
                        a aVar = this.mFV[i2];
                        if (aVar.data == this.mFR) {
                            i2++;
                        } else {
                            a aVar2 = this.mFV[i3];
                            if (aVar2.data != this.mFR) {
                                i3--;
                            } else {
                                this.mFV[i2] = aVar2;
                                this.mFV[i3] = aVar;
                                i3--;
                                i2++;
                            }
                        }
                    }
                    i = Math.max(max, i2);
                } else {
                    i = max;
                }
                Arrays.fill(this.mFV, i, this.mFU, (Object) null);
                this.mFU = i;
            }
        }
    }

    public synchronized int dyW() {
        return this.mFT * this.mFQ;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public int dyR() {
        return this.mFQ;
    }
}
