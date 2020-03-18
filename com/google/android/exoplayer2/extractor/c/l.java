package com.google.android.exoplayer2.extractor.c;

import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
/* loaded from: classes6.dex */
final class l {
    public long mmA;
    public long mmB;
    public int mmC;
    public long[] mmD;
    public int[] mmE;
    public int[] mmF;
    public int[] mmG;
    public long[] mmH;
    public boolean[] mmI;
    public boolean mmJ;
    public boolean[] mmK;
    public k mmL;
    public int mmM;
    public com.google.android.exoplayer2.util.l mmN;
    public boolean mmO;
    public long mmP;
    public c mmy;
    public long mmz;
    public int sampleCount;

    public void reset() {
        this.mmC = 0;
        this.mmP = 0L;
        this.mmJ = false;
        this.mmO = false;
        this.mmL = null;
    }

    public void dM(int i, int i2) {
        this.mmC = i;
        this.sampleCount = i2;
        if (this.mmE == null || this.mmE.length < i) {
            this.mmD = new long[i];
            this.mmE = new int[i];
        }
        if (this.mmF == null || this.mmF.length < i2) {
            int i3 = (i2 * Constants.METHOD_IM_FRIEND_GROUP_ASSIGN) / 100;
            this.mmF = new int[i3];
            this.mmG = new int[i3];
            this.mmH = new long[i3];
            this.mmI = new boolean[i3];
            this.mmK = new boolean[i3];
        }
    }

    public void JX(int i) {
        if (this.mmN == null || this.mmN.dzS() < i) {
            this.mmN = new com.google.android.exoplayer2.util.l(i);
        }
        this.mmM = i;
        this.mmJ = true;
        this.mmO = true;
    }

    public void t(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.readFully(this.mmN.data, 0, this.mmM);
        this.mmN.setPosition(0);
        this.mmO = false;
    }

    public void z(com.google.android.exoplayer2.util.l lVar) {
        lVar.G(this.mmN.data, 0, this.mmM);
        this.mmN.setPosition(0);
        this.mmO = false;
    }

    public long JY(int i) {
        return this.mmH[i] + this.mmG[i];
    }
}
