package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private c mQW;
    private com.facebook.common.memory.g mQZ;
    private i mRb;
    private com.facebook.common.memory.j mRp;
    private final p mVv;
    private k mVw;
    private com.facebook.common.memory.a mVx;

    public q(p pVar) {
        this.mVv = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dFO() {
        if (this.mQW == null) {
            this.mQW = new c(this.mVv.dDA(), this.mVv.dFF(), this.mVv.dFG());
        }
        return this.mQW;
    }

    public i dFP() {
        if (this.mRb == null) {
            this.mRb = new i(this.mVv.dDA(), this.mVv.dFJ());
        }
        return this.mRb;
    }

    public int dFQ() {
        return this.mVv.dFJ().mVE;
    }

    public k dFR() {
        if (this.mVw == null) {
            this.mVw = new k(this.mVv.dDA(), this.mVv.dFH(), this.mVv.dFI());
        }
        return this.mVw;
    }

    public com.facebook.common.memory.g dFS() {
        if (this.mQZ == null) {
            this.mQZ = new m(dFR(), dFT());
        }
        return this.mQZ;
    }

    public com.facebook.common.memory.j dFT() {
        if (this.mRp == null) {
            this.mRp = new com.facebook.common.memory.j(dFU());
        }
        return this.mRp;
    }

    public com.facebook.common.memory.a dFU() {
        if (this.mVx == null) {
            this.mVx = new j(this.mVv.dDA(), this.mVv.dFK(), this.mVv.dFL());
        }
        return this.mVx;
    }
}
