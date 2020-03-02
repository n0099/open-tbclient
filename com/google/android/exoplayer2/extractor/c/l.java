package com.google.android.exoplayer2.extractor.c;

import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
/* loaded from: classes6.dex */
final class l {
    public c mkH;
    public long mkI;
    public long mkJ;
    public long mkK;
    public int mkL;
    public long[] mkM;
    public int[] mkN;
    public int[] mkO;
    public int[] mkP;
    public long[] mkQ;
    public boolean[] mkR;
    public boolean mkS;
    public boolean[] mkT;
    public k mkU;
    public int mkV;
    public com.google.android.exoplayer2.util.l mkW;
    public boolean mkX;
    public long mkY;
    public int sampleCount;

    public void reset() {
        this.mkL = 0;
        this.mkY = 0L;
        this.mkS = false;
        this.mkX = false;
        this.mkU = null;
    }

    public void dL(int i, int i2) {
        this.mkL = i;
        this.sampleCount = i2;
        if (this.mkN == null || this.mkN.length < i) {
            this.mkM = new long[i];
            this.mkN = new int[i];
        }
        if (this.mkO == null || this.mkO.length < i2) {
            int i3 = (i2 * Constants.METHOD_IM_FRIEND_GROUP_ASSIGN) / 100;
            this.mkO = new int[i3];
            this.mkP = new int[i3];
            this.mkQ = new long[i3];
            this.mkR = new boolean[i3];
            this.mkT = new boolean[i3];
        }
    }

    public void JR(int i) {
        if (this.mkW == null || this.mkW.dzu() < i) {
            this.mkW = new com.google.android.exoplayer2.util.l(i);
        }
        this.mkV = i;
        this.mkS = true;
        this.mkX = true;
    }

    public void t(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.readFully(this.mkW.data, 0, this.mkV);
        this.mkW.setPosition(0);
        this.mkX = false;
    }

    public void z(com.google.android.exoplayer2.util.l lVar) {
        lVar.G(this.mkW.data, 0, this.mkV);
        this.mkW.setPosition(0);
        this.mkX = false;
    }

    public long JS(int i) {
        return this.mkQ[i] + this.mkP[i];
    }
}
