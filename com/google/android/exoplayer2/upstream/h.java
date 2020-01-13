package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class h implements b {
    private int lXD;
    private final boolean mFe;
    private final int mFf;
    private final byte[] mFg;
    private final a[] mFh;
    private int mFi;
    private int mFj;
    private a[] mFk;

    public h(boolean z, int i) {
        this(z, i, 0);
    }

    public h(boolean z, int i, int i2) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        com.google.android.exoplayer2.util.a.checkArgument(i2 >= 0);
        this.mFe = z;
        this.mFf = i;
        this.mFj = i2;
        this.mFk = new a[i2 + 100];
        if (i2 > 0) {
            this.mFg = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.mFk[i3] = new a(this.mFg, i3 * i);
            }
        } else {
            this.mFg = null;
        }
        this.mFh = new a[1];
    }

    public synchronized void reset() {
        if (this.mFe) {
            LM(0);
        }
    }

    public synchronized void LM(int i) {
        boolean z = i < this.lXD;
        this.lXD = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized a dxE() {
        a aVar;
        this.mFi++;
        if (this.mFj > 0) {
            a[] aVarArr = this.mFk;
            int i = this.mFj - 1;
            this.mFj = i;
            aVar = aVarArr[i];
            this.mFk[this.mFj] = null;
        } else {
            aVar = new a(new byte[this.mFf], 0);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a aVar) {
        this.mFh[0] = aVar;
        a(this.mFh);
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a[] aVarArr) {
        if (this.mFj + aVarArr.length >= this.mFk.length) {
            this.mFk = (a[]) Arrays.copyOf(this.mFk, Math.max(this.mFk.length * 2, this.mFj + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            com.google.android.exoplayer2.util.a.checkArgument(aVar.data == this.mFg || aVar.data.length == this.mFf);
            a[] aVarArr2 = this.mFk;
            int i = this.mFj;
            this.mFj = i + 1;
            aVarArr2[i] = aVar;
        }
        this.mFi -= aVarArr.length;
        notifyAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 < r7.mFj) goto L31;
     */
    @Override // com.google.android.exoplayer2.upstream.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void trim() {
        int i;
        int i2 = 0;
        synchronized (this) {
            int max = Math.max(0, v.dW(this.lXD, this.mFf) - this.mFi);
            if (max < this.mFj) {
                if (this.mFg != null) {
                    int i3 = this.mFj - 1;
                    while (i2 <= i3) {
                        a aVar = this.mFk[i2];
                        if (aVar.data == this.mFg) {
                            i2++;
                        } else {
                            a aVar2 = this.mFk[i3];
                            if (aVar2.data != this.mFg) {
                                i3--;
                            } else {
                                this.mFk[i2] = aVar2;
                                this.mFk[i3] = aVar;
                                i3--;
                                i2++;
                            }
                        }
                    }
                    i = Math.max(max, i2);
                } else {
                    i = max;
                }
                Arrays.fill(this.mFk, i, this.mFj, (Object) null);
                this.mFj = i;
            }
        }
    }

    public synchronized int dxK() {
        return this.mFi * this.mFf;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public int dxF() {
        return this.mFf;
    }
}
