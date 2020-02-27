package com.google.android.exoplayer2.extractor.c;

import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
/* loaded from: classes6.dex */
final class l {
    public c mkF;
    public long mkG;
    public long mkH;
    public long mkI;
    public int mkJ;
    public long[] mkK;
    public int[] mkL;
    public int[] mkM;
    public int[] mkN;
    public long[] mkO;
    public boolean[] mkP;
    public boolean mkQ;
    public boolean[] mkR;
    public k mkS;
    public int mkT;
    public com.google.android.exoplayer2.util.l mkU;
    public boolean mkV;
    public long mkW;
    public int sampleCount;

    public void reset() {
        this.mkJ = 0;
        this.mkW = 0L;
        this.mkQ = false;
        this.mkV = false;
        this.mkS = null;
    }

    public void dL(int i, int i2) {
        this.mkJ = i;
        this.sampleCount = i2;
        if (this.mkL == null || this.mkL.length < i) {
            this.mkK = new long[i];
            this.mkL = new int[i];
        }
        if (this.mkM == null || this.mkM.length < i2) {
            int i3 = (i2 * Constants.METHOD_IM_FRIEND_GROUP_ASSIGN) / 100;
            this.mkM = new int[i3];
            this.mkN = new int[i3];
            this.mkO = new long[i3];
            this.mkP = new boolean[i3];
            this.mkR = new boolean[i3];
        }
    }

    public void JR(int i) {
        if (this.mkU == null || this.mkU.dzs() < i) {
            this.mkU = new com.google.android.exoplayer2.util.l(i);
        }
        this.mkT = i;
        this.mkQ = true;
        this.mkV = true;
    }

    public void t(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.readFully(this.mkU.data, 0, this.mkT);
        this.mkU.setPosition(0);
        this.mkV = false;
    }

    public void z(com.google.android.exoplayer2.util.l lVar) {
        lVar.G(this.mkU.data, 0, this.mkT);
        this.mkU.setPosition(0);
        this.mkV = false;
    }

    public long JS(int i) {
        return this.mkO[i] + this.mkN[i];
    }
}
