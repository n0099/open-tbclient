package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private com.facebook.common.memory.j lQG;
    private c lQn;
    private com.facebook.common.memory.g lQq;
    private i lQs;
    private final p lUF;
    private k lUG;
    private com.facebook.common.memory.a lUH;

    public q(p pVar) {
        this.lUF = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c drl() {
        if (this.lQn == null) {
            this.lQn = new c(this.lUF.doW(), this.lUF.drc(), this.lUF.drd());
        }
        return this.lQn;
    }

    public i drm() {
        if (this.lQs == null) {
            this.lQs = new i(this.lUF.doW(), this.lUF.drg());
        }
        return this.lQs;
    }

    public int drn() {
        return this.lUF.drg().lUO;
    }

    public k dro() {
        if (this.lUG == null) {
            this.lUG = new k(this.lUF.doW(), this.lUF.dre(), this.lUF.drf());
        }
        return this.lUG;
    }

    public com.facebook.common.memory.g drp() {
        if (this.lQq == null) {
            this.lQq = new m(dro(), drq());
        }
        return this.lQq;
    }

    public com.facebook.common.memory.j drq() {
        if (this.lQG == null) {
            this.lQG = new com.facebook.common.memory.j(drr());
        }
        return this.lQG;
    }

    public com.facebook.common.memory.a drr() {
        if (this.lUH == null) {
            this.lUH = new j(this.lUF.doW(), this.lUF.drh(), this.lUF.dri());
        }
        return this.lUH;
    }
}
