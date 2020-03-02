package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class h implements b {
    private int lYq;
    private final boolean mFR;
    private final int mFS;
    private final byte[] mFT;
    private final a[] mFU;
    private int mFV;
    private int mFW;
    private a[] mFX;

    public h(boolean z, int i) {
        this(z, i, 0);
    }

    public h(boolean z, int i, int i2) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        com.google.android.exoplayer2.util.a.checkArgument(i2 >= 0);
        this.mFR = z;
        this.mFS = i;
        this.mFW = i2;
        this.mFX = new a[i2 + 100];
        if (i2 > 0) {
            this.mFT = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.mFX[i3] = new a(this.mFT, i3 * i);
            }
        } else {
            this.mFT = null;
        }
        this.mFU = new a[1];
    }

    public synchronized void reset() {
        if (this.mFR) {
            LR(0);
        }
    }

    public synchronized void LR(int i) {
        boolean z = i < this.lYq;
        this.lYq = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized a dyS() {
        a aVar;
        this.mFV++;
        if (this.mFW > 0) {
            a[] aVarArr = this.mFX;
            int i = this.mFW - 1;
            this.mFW = i;
            aVar = aVarArr[i];
            this.mFX[this.mFW] = null;
        } else {
            aVar = new a(new byte[this.mFS], 0);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a aVar) {
        this.mFU[0] = aVar;
        a(this.mFU);
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a[] aVarArr) {
        if (this.mFW + aVarArr.length >= this.mFX.length) {
            this.mFX = (a[]) Arrays.copyOf(this.mFX, Math.max(this.mFX.length * 2, this.mFW + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            com.google.android.exoplayer2.util.a.checkArgument(aVar.data == this.mFT || aVar.data.length == this.mFS);
            a[] aVarArr2 = this.mFX;
            int i = this.mFW;
            this.mFW = i + 1;
            aVarArr2[i] = aVar;
        }
        this.mFV -= aVarArr.length;
        notifyAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 < r7.mFW) goto L31;
     */
    @Override // com.google.android.exoplayer2.upstream.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void trim() {
        int i;
        int i2 = 0;
        synchronized (this) {
            int max = Math.max(0, v.dZ(this.lYq, this.mFS) - this.mFV);
            if (max < this.mFW) {
                if (this.mFT != null) {
                    int i3 = this.mFW - 1;
                    while (i2 <= i3) {
                        a aVar = this.mFX[i2];
                        if (aVar.data == this.mFT) {
                            i2++;
                        } else {
                            a aVar2 = this.mFX[i3];
                            if (aVar2.data != this.mFT) {
                                i3--;
                            } else {
                                this.mFX[i2] = aVar2;
                                this.mFX[i3] = aVar;
                                i3--;
                                i2++;
                            }
                        }
                    }
                    i = Math.max(max, i2);
                } else {
                    i = max;
                }
                Arrays.fill(this.mFX, i, this.mFW, (Object) null);
                this.mFW = i;
            }
        }
    }

    public synchronized int dyY() {
        return this.mFV * this.mFS;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public int dyT() {
        return this.mFS;
    }
}
