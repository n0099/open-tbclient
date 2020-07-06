package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private c mQZ;
    private com.facebook.common.memory.g mRd;
    private i mRf;
    private com.facebook.common.memory.j mRs;
    private com.facebook.common.memory.a mVA;
    private final p mVy;
    private k mVz;

    public q(p pVar) {
        this.mVy = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dFS() {
        if (this.mQZ == null) {
            this.mQZ = new c(this.mVy.dDE(), this.mVy.dFJ(), this.mVy.dFK());
        }
        return this.mQZ;
    }

    public i dFT() {
        if (this.mRf == null) {
            this.mRf = new i(this.mVy.dDE(), this.mVy.dFN());
        }
        return this.mRf;
    }

    public int dFU() {
        return this.mVy.dFN().mVH;
    }

    public k dFV() {
        if (this.mVz == null) {
            this.mVz = new k(this.mVy.dDE(), this.mVy.dFL(), this.mVy.dFM());
        }
        return this.mVz;
    }

    public com.facebook.common.memory.g dFW() {
        if (this.mRd == null) {
            this.mRd = new m(dFV(), dFX());
        }
        return this.mRd;
    }

    public com.facebook.common.memory.j dFX() {
        if (this.mRs == null) {
            this.mRs = new com.facebook.common.memory.j(dFY());
        }
        return this.mRs;
    }

    public com.facebook.common.memory.a dFY() {
        if (this.mVA == null) {
            this.mVA = new j(this.mVy.dDE(), this.mVy.dFO(), this.mVy.dFP());
        }
        return this.mVA;
    }
}
