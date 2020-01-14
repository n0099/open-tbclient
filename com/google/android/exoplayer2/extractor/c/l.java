package com.google.android.exoplayer2.extractor.c;

import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
/* loaded from: classes5.dex */
final class l {
    public c mjZ;
    public long mka;
    public long mkb;
    public long mkc;
    public int mkd;
    public long[] mke;
    public int[] mkf;
    public int[] mkg;
    public int[] mkh;
    public long[] mki;
    public boolean[] mkj;
    public boolean mkk;
    public boolean[] mkl;
    public k mkm;
    public int mkn;
    public com.google.android.exoplayer2.util.l mko;
    public boolean mkp;
    public long mkq;
    public int sampleCount;

    public void reset() {
        this.mkd = 0;
        this.mkq = 0L;
        this.mkk = false;
        this.mkp = false;
        this.mkm = null;
    }

    public void dI(int i, int i2) {
        this.mkd = i;
        this.sampleCount = i2;
        if (this.mkf == null || this.mkf.length < i) {
            this.mke = new long[i];
            this.mkf = new int[i];
        }
        if (this.mkg == null || this.mkg.length < i2) {
            int i3 = (i2 * Constants.METHOD_IM_FRIEND_GROUP_ASSIGN) / 100;
            this.mkg = new int[i3];
            this.mkh = new int[i3];
            this.mki = new long[i3];
            this.mkj = new boolean[i3];
            this.mkl = new boolean[i3];
        }
    }

    public void JM(int i) {
        if (this.mko == null || this.mko.dyi() < i) {
            this.mko = new com.google.android.exoplayer2.util.l(i);
        }
        this.mkn = i;
        this.mkk = true;
        this.mkp = true;
    }

    public void t(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.readFully(this.mko.data, 0, this.mkn);
        this.mko.setPosition(0);
        this.mkp = false;
    }

    public void z(com.google.android.exoplayer2.util.l lVar) {
        lVar.C(this.mko.data, 0, this.mkn);
        this.mko.setPosition(0);
        this.mkp = false;
    }

    public long JN(int i) {
        return this.mki[i] + this.mkh[i];
    }
}
