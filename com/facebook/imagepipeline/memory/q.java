package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes10.dex */
public class q {
    private c lPG;
    private com.facebook.common.memory.g lPJ;
    private i lPL;
    private com.facebook.common.memory.j lPZ;
    private final p lTY;
    private k lTZ;
    private com.facebook.common.memory.a lUa;

    public q(p pVar) {
        this.lTY = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dpZ() {
        if (this.lPG == null) {
            this.lPG = new c(this.lTY.dnK(), this.lTY.dpQ(), this.lTY.dpR());
        }
        return this.lPG;
    }

    public i dqa() {
        if (this.lPL == null) {
            this.lPL = new i(this.lTY.dnK(), this.lTY.dpU());
        }
        return this.lPL;
    }

    public int dqb() {
        return this.lTY.dpU().lUh;
    }

    public k dqc() {
        if (this.lTZ == null) {
            this.lTZ = new k(this.lTY.dnK(), this.lTY.dpS(), this.lTY.dpT());
        }
        return this.lTZ;
    }

    public com.facebook.common.memory.g dqd() {
        if (this.lPJ == null) {
            this.lPJ = new m(dqc(), dqe());
        }
        return this.lPJ;
    }

    public com.facebook.common.memory.j dqe() {
        if (this.lPZ == null) {
            this.lPZ = new com.facebook.common.memory.j(dqf());
        }
        return this.lPZ;
    }

    public com.facebook.common.memory.a dqf() {
        if (this.lUa == null) {
            this.lUa = new j(this.lTY.dnK(), this.lTY.dpV(), this.lTY.dpW());
        }
        return this.lUa;
    }
}
