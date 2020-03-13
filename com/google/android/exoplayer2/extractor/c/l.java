package com.google.android.exoplayer2.extractor.c;

import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
/* loaded from: classes6.dex */
final class l {
    public c mkS;
    public long mkT;
    public long mkU;
    public long mkV;
    public int mkW;
    public long[] mkX;
    public int[] mkY;
    public int[] mkZ;
    public int[] mla;
    public long[] mlb;
    public boolean[] mlc;
    public boolean mld;
    public boolean[] mle;
    public k mlf;
    public int mlg;
    public com.google.android.exoplayer2.util.l mlh;
    public boolean mli;
    public long mlj;
    public int sampleCount;

    public void reset() {
        this.mkW = 0;
        this.mlj = 0L;
        this.mld = false;
        this.mli = false;
        this.mlf = null;
    }

    public void dL(int i, int i2) {
        this.mkW = i;
        this.sampleCount = i2;
        if (this.mkY == null || this.mkY.length < i) {
            this.mkX = new long[i];
            this.mkY = new int[i];
        }
        if (this.mkZ == null || this.mkZ.length < i2) {
            int i3 = (i2 * Constants.METHOD_IM_FRIEND_GROUP_ASSIGN) / 100;
            this.mkZ = new int[i3];
            this.mla = new int[i3];
            this.mlb = new long[i3];
            this.mlc = new boolean[i3];
            this.mle = new boolean[i3];
        }
    }

    public void JR(int i) {
        if (this.mlh == null || this.mlh.dzv() < i) {
            this.mlh = new com.google.android.exoplayer2.util.l(i);
        }
        this.mlg = i;
        this.mld = true;
        this.mli = true;
    }

    public void t(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.readFully(this.mlh.data, 0, this.mlg);
        this.mlh.setPosition(0);
        this.mli = false;
    }

    public void z(com.google.android.exoplayer2.util.l lVar) {
        lVar.G(this.mlh.data, 0, this.mlg);
        this.mlh.setPosition(0);
        this.mli = false;
    }

    public long JS(int i) {
        return this.mlb[i] + this.mla[i];
    }
}
