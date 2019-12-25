package com.google.android.exoplayer2.extractor.c;

import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
/* loaded from: classes4.dex */
final class l {
    public c mgd;
    public long mge;
    public long mgf;
    public long mgg;
    public int mgh;
    public long[] mgi;
    public int[] mgj;
    public int[] mgk;
    public int[] mgl;
    public long[] mgm;
    public boolean[] mgn;
    public boolean mgo;
    public boolean[] mgp;
    public k mgq;
    public int mgr;
    public com.google.android.exoplayer2.util.l mgs;
    public boolean mgt;
    public long mgu;
    public int sampleCount;

    public void reset() {
        this.mgh = 0;
        this.mgu = 0L;
        this.mgo = false;
        this.mgt = false;
        this.mgq = null;
    }

    public void dK(int i, int i2) {
        this.mgh = i;
        this.sampleCount = i2;
        if (this.mgj == null || this.mgj.length < i) {
            this.mgi = new long[i];
            this.mgj = new int[i];
        }
        if (this.mgk == null || this.mgk.length < i2) {
            int i3 = (i2 * Constants.METHOD_IM_FRIEND_GROUP_ASSIGN) / 100;
            this.mgk = new int[i3];
            this.mgl = new int[i3];
            this.mgm = new long[i3];
            this.mgn = new boolean[i3];
            this.mgp = new boolean[i3];
        }
    }

    public void JD(int i) {
        if (this.mgs == null || this.mgs.dwW() < i) {
            this.mgs = new com.google.android.exoplayer2.util.l(i);
        }
        this.mgr = i;
        this.mgo = true;
        this.mgt = true;
    }

    public void t(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        fVar.readFully(this.mgs.data, 0, this.mgr);
        this.mgs.setPosition(0);
        this.mgt = false;
    }

    public void z(com.google.android.exoplayer2.util.l lVar) {
        lVar.D(this.mgs.data, 0, this.mgr);
        this.mgs.setPosition(0);
        this.mgt = false;
    }

    public long JE(int i) {
        return this.mgm[i] + this.mgl[i];
    }
}
