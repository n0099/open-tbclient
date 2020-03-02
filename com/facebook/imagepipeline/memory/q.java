package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private com.facebook.common.memory.j lQI;
    private c lQp;
    private com.facebook.common.memory.g lQs;
    private i lQu;
    private final p lUH;
    private k lUI;
    private com.facebook.common.memory.a lUJ;

    public q(p pVar) {
        this.lUH = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c drn() {
        if (this.lQp == null) {
            this.lQp = new c(this.lUH.doY(), this.lUH.dre(), this.lUH.drf());
        }
        return this.lQp;
    }

    public i dro() {
        if (this.lQu == null) {
            this.lQu = new i(this.lUH.doY(), this.lUH.dri());
        }
        return this.lQu;
    }

    public int drp() {
        return this.lUH.dri().lUQ;
    }

    public k drq() {
        if (this.lUI == null) {
            this.lUI = new k(this.lUH.doY(), this.lUH.drg(), this.lUH.drh());
        }
        return this.lUI;
    }

    public com.facebook.common.memory.g drr() {
        if (this.lQs == null) {
            this.lQs = new m(drq(), drs());
        }
        return this.lQs;
    }

    public com.facebook.common.memory.j drs() {
        if (this.lQI == null) {
            this.lQI = new com.facebook.common.memory.j(drt());
        }
        return this.lQI;
    }

    public com.facebook.common.memory.a drt() {
        if (this.lUJ == null) {
            this.lUJ = new j(this.lUH.doY(), this.lUH.drj(), this.lUH.drk());
        }
        return this.lUJ;
    }
}
