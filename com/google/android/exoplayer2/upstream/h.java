package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class h implements b {
    private int lXI;
    private final boolean mFj;
    private final int mFk;
    private final byte[] mFl;
    private final a[] mFm;
    private int mFn;
    private int mFo;
    private a[] mFp;

    public h(boolean z, int i) {
        this(z, i, 0);
    }

    public h(boolean z, int i, int i2) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        com.google.android.exoplayer2.util.a.checkArgument(i2 >= 0);
        this.mFj = z;
        this.mFk = i;
        this.mFo = i2;
        this.mFp = new a[i2 + 100];
        if (i2 > 0) {
            this.mFl = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.mFp[i3] = new a(this.mFl, i3 * i);
            }
        } else {
            this.mFl = null;
        }
        this.mFm = new a[1];
    }

    public synchronized void reset() {
        if (this.mFj) {
            LM(0);
        }
    }

    public synchronized void LM(int i) {
        boolean z = i < this.lXI;
        this.lXI = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized a dxG() {
        a aVar;
        this.mFn++;
        if (this.mFo > 0) {
            a[] aVarArr = this.mFp;
            int i = this.mFo - 1;
            this.mFo = i;
            aVar = aVarArr[i];
            this.mFp[this.mFo] = null;
        } else {
            aVar = new a(new byte[this.mFk], 0);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a aVar) {
        this.mFm[0] = aVar;
        a(this.mFm);
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a[] aVarArr) {
        if (this.mFo + aVarArr.length >= this.mFp.length) {
            this.mFp = (a[]) Arrays.copyOf(this.mFp, Math.max(this.mFp.length * 2, this.mFo + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            com.google.android.exoplayer2.util.a.checkArgument(aVar.data == this.mFl || aVar.data.length == this.mFk);
            a[] aVarArr2 = this.mFp;
            int i = this.mFo;
            this.mFo = i + 1;
            aVarArr2[i] = aVar;
        }
        this.mFn -= aVarArr.length;
        notifyAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 < r7.mFo) goto L31;
     */
    @Override // com.google.android.exoplayer2.upstream.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void trim() {
        int i;
        int i2 = 0;
        synchronized (this) {
            int max = Math.max(0, v.dW(this.lXI, this.mFk) - this.mFn);
            if (max < this.mFo) {
                if (this.mFl != null) {
                    int i3 = this.mFo - 1;
                    while (i2 <= i3) {
                        a aVar = this.mFp[i2];
                        if (aVar.data == this.mFl) {
                            i2++;
                        } else {
                            a aVar2 = this.mFp[i3];
                            if (aVar2.data != this.mFl) {
                                i3--;
                            } else {
                                this.mFp[i2] = aVar2;
                                this.mFp[i3] = aVar;
                                i3--;
                                i2++;
                            }
                        }
                    }
                    i = Math.max(max, i2);
                } else {
                    i = max;
                }
                Arrays.fill(this.mFp, i, this.mFo, (Object) null);
                this.mFo = i;
            }
        }
    }

    public synchronized int dxM() {
        return this.mFn * this.mFk;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public int dxH() {
        return this.mFk;
    }
}
