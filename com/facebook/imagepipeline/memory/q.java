package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private c lSg;
    private com.facebook.common.memory.g lSj;
    private i lSl;
    private com.facebook.common.memory.j lSz;
    private com.facebook.common.memory.a lWA;
    private final p lWy;
    private k lWz;

    public q(p pVar) {
        this.lWy = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c drL() {
        if (this.lSg == null) {
            this.lSg = new c(this.lWy.dpw(), this.lWy.drC(), this.lWy.drD());
        }
        return this.lSg;
    }

    public i drM() {
        if (this.lSl == null) {
            this.lSl = new i(this.lWy.dpw(), this.lWy.drG());
        }
        return this.lSl;
    }

    public int drN() {
        return this.lWy.drG().lWH;
    }

    public k drO() {
        if (this.lWz == null) {
            this.lWz = new k(this.lWy.dpw(), this.lWy.drE(), this.lWy.drF());
        }
        return this.lWz;
    }

    public com.facebook.common.memory.g drP() {
        if (this.lSj == null) {
            this.lSj = new m(drO(), drQ());
        }
        return this.lSj;
    }

    public com.facebook.common.memory.j drQ() {
        if (this.lSz == null) {
            this.lSz = new com.facebook.common.memory.j(drR());
        }
        return this.lSz;
    }

    public com.facebook.common.memory.a drR() {
        if (this.lWA == null) {
            this.lWA = new j(this.lWy.dpw(), this.lWy.drH(), this.lWy.drI());
        }
        return this.lWA;
    }
}
