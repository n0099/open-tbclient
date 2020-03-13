package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class h implements b {
    private int lYB;
    private final boolean mGc;
    private final int mGd;
    private final byte[] mGe;
    private final a[] mGf;
    private int mGg;
    private int mGh;
    private a[] mGi;

    public h(boolean z, int i) {
        this(z, i, 0);
    }

    public h(boolean z, int i, int i2) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        com.google.android.exoplayer2.util.a.checkArgument(i2 >= 0);
        this.mGc = z;
        this.mGd = i;
        this.mGh = i2;
        this.mGi = new a[i2 + 100];
        if (i2 > 0) {
            this.mGe = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.mGi[i3] = new a(this.mGe, i3 * i);
            }
        } else {
            this.mGe = null;
        }
        this.mGf = new a[1];
    }

    public synchronized void reset() {
        if (this.mGc) {
            LR(0);
        }
    }

    public synchronized void LR(int i) {
        boolean z = i < this.lYB;
        this.lYB = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized a dyT() {
        a aVar;
        this.mGg++;
        if (this.mGh > 0) {
            a[] aVarArr = this.mGi;
            int i = this.mGh - 1;
            this.mGh = i;
            aVar = aVarArr[i];
            this.mGi[this.mGh] = null;
        } else {
            aVar = new a(new byte[this.mGd], 0);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a aVar) {
        this.mGf[0] = aVar;
        a(this.mGf);
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a[] aVarArr) {
        if (this.mGh + aVarArr.length >= this.mGi.length) {
            this.mGi = (a[]) Arrays.copyOf(this.mGi, Math.max(this.mGi.length * 2, this.mGh + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            com.google.android.exoplayer2.util.a.checkArgument(aVar.data == this.mGe || aVar.data.length == this.mGd);
            a[] aVarArr2 = this.mGi;
            int i = this.mGh;
            this.mGh = i + 1;
            aVarArr2[i] = aVar;
        }
        this.mGg -= aVarArr.length;
        notifyAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 < r7.mGh) goto L31;
     */
    @Override // com.google.android.exoplayer2.upstream.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void trim() {
        int i;
        int i2 = 0;
        synchronized (this) {
            int max = Math.max(0, v.dZ(this.lYB, this.mGd) - this.mGg);
            if (max < this.mGh) {
                if (this.mGe != null) {
                    int i3 = this.mGh - 1;
                    while (i2 <= i3) {
                        a aVar = this.mGi[i2];
                        if (aVar.data == this.mGe) {
                            i2++;
                        } else {
                            a aVar2 = this.mGi[i3];
                            if (aVar2.data != this.mGe) {
                                i3--;
                            } else {
                                this.mGi[i2] = aVar2;
                                this.mGi[i3] = aVar;
                                i3--;
                                i2++;
                            }
                        }
                    }
                    i = Math.max(max, i2);
                } else {
                    i = max;
                }
                Arrays.fill(this.mGi, i, this.mGh, (Object) null);
                this.mGh = i;
            }
        }
    }

    public synchronized int dyZ() {
        return this.mGg * this.mGd;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public int dyU() {
        return this.mGd;
    }
}
