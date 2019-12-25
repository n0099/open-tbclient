package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class h implements b {
    private int lTM;
    private final boolean mBm;
    private final int mBn;
    private final byte[] mBo;
    private final a[] mBp;
    private int mBq;
    private int mBr;
    private a[] mBs;

    public h(boolean z, int i) {
        this(z, i, 0);
    }

    public h(boolean z, int i, int i2) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        com.google.android.exoplayer2.util.a.checkArgument(i2 >= 0);
        this.mBm = z;
        this.mBn = i;
        this.mBr = i2;
        this.mBs = new a[i2 + 100];
        if (i2 > 0) {
            this.mBo = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.mBs[i3] = new a(this.mBo, i3 * i);
            }
        } else {
            this.mBo = null;
        }
        this.mBp = new a[1];
    }

    public synchronized void reset() {
        if (this.mBm) {
            LD(0);
        }
    }

    public synchronized void LD(int i) {
        boolean z = i < this.lTM;
        this.lTM = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized a dwt() {
        a aVar;
        this.mBq++;
        if (this.mBr > 0) {
            a[] aVarArr = this.mBs;
            int i = this.mBr - 1;
            this.mBr = i;
            aVar = aVarArr[i];
            this.mBs[this.mBr] = null;
        } else {
            aVar = new a(new byte[this.mBn], 0);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a aVar) {
        this.mBp[0] = aVar;
        a(this.mBp);
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(a[] aVarArr) {
        if (this.mBr + aVarArr.length >= this.mBs.length) {
            this.mBs = (a[]) Arrays.copyOf(this.mBs, Math.max(this.mBs.length * 2, this.mBr + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            com.google.android.exoplayer2.util.a.checkArgument(aVar.data == this.mBo || aVar.data.length == this.mBn);
            a[] aVarArr2 = this.mBs;
            int i = this.mBr;
            this.mBr = i + 1;
            aVarArr2[i] = aVar;
        }
        this.mBq -= aVarArr.length;
        notifyAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 < r7.mBr) goto L31;
     */
    @Override // com.google.android.exoplayer2.upstream.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void trim() {
        int i;
        int i2 = 0;
        synchronized (this) {
            int max = Math.max(0, v.dY(this.lTM, this.mBn) - this.mBq);
            if (max < this.mBr) {
                if (this.mBo != null) {
                    int i3 = this.mBr - 1;
                    while (i2 <= i3) {
                        a aVar = this.mBs[i2];
                        if (aVar.data == this.mBo) {
                            i2++;
                        } else {
                            a aVar2 = this.mBs[i3];
                            if (aVar2.data != this.mBo) {
                                i3--;
                            } else {
                                this.mBs[i2] = aVar2;
                                this.mBs[i3] = aVar;
                                i3--;
                                i2++;
                            }
                        }
                    }
                    i = Math.max(max, i2);
                } else {
                    i = max;
                }
                Arrays.fill(this.mBs, i, this.mBr, (Object) null);
                this.mBr = i;
            }
        }
    }

    public synchronized int dwz() {
        return this.mBq * this.mBn;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public int dwu() {
        return this.mBn;
    }
}
