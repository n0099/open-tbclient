package com.google.android.exoplayer2.extractor.c;

import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
/* loaded from: classes5.dex */
final class l {
    public c mjU;
    public long mjV;
    public long mjW;
    public long mjX;
    public int mjY;
    public long[] mjZ;
    public int[] mka;
    public int[] mkb;
    public int[] mkc;
    public long[] mkd;
    public boolean[] mke;
    public boolean mkf;
    public boolean[] mkg;
    public k mkh;
    public int mki;
    public com.google.android.exoplayer2.util.l mkj;
    public boolean mkk;
    public long mkl;
    public int sampleCount;

    public void reset() {
        this.mjY = 0;
        this.mkl = 0L;
        this.mkf = false;
        this.mkk = false;
        this.mkh = null;
    }

    public void dI(int i, int i2) {
        this.mjY = i;
        this.sampleCount = i2;
        if (this.mka == null || this.mka.length < i) {
            this.mjZ = new long[i];
            this.mka = new int[i];
        }
        if (this.mkb == null || this.mkb.length < i2) {
            int i3 = (i2 * Constants.METHOD_IM_FRIEND_GROUP_ASSIGN) / 100;
            this.mkb = new int[i3];
            this.mkc = new int[i3];
            this.mkd = new long[i3];
            this.mke = new boolean[i3];
            this.mkg = new boolean[i3];
        }
    }

    public void JM(int i) {
        if (this.mkj == null || this.mkj.dyg() < i) {
            this.mkj = new com.google.android.exoplayer2.util.l(i);
        }
        this.mki = i;
        this.mkf = true;
        this.mkk = true;
    }

    public void t(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.readFully(this.mkj.data, 0, this.mki);
        this.mkj.setPosition(0);
        this.mkk = false;
    }

    public void z(com.google.android.exoplayer2.util.l lVar) {
        lVar.C(this.mkj.data, 0, this.mki);
        this.mkj.setPosition(0);
        this.mkk = false;
    }

    public long JN(int i) {
        return this.mkd[i] + this.mkc[i];
    }
}
