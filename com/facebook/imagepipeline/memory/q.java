package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private c lZT;
    private com.facebook.common.memory.g lZW;
    private i lZY;
    private com.facebook.common.memory.j man;
    private final p men;
    private k meo;
    private com.facebook.common.memory.a mep;

    public q(p pVar) {
        this.men = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dtG() {
        if (this.lZT == null) {
            this.lZT = new c(this.men.drr(), this.men.dtx(), this.men.dty());
        }
        return this.lZT;
    }

    public i dtH() {
        if (this.lZY == null) {
            this.lZY = new i(this.men.drr(), this.men.dtB());
        }
        return this.lZY;
    }

    public int dtI() {
        return this.men.dtB().mew;
    }

    public k dtJ() {
        if (this.meo == null) {
            this.meo = new k(this.men.drr(), this.men.dtz(), this.men.dtA());
        }
        return this.meo;
    }

    public com.facebook.common.memory.g dtK() {
        if (this.lZW == null) {
            this.lZW = new m(dtJ(), dtL());
        }
        return this.lZW;
    }

    public com.facebook.common.memory.j dtL() {
        if (this.man == null) {
            this.man = new com.facebook.common.memory.j(dtM());
        }
        return this.man;
    }

    public com.facebook.common.memory.a dtM() {
        if (this.mep == null) {
            this.mep = new j(this.men.drr(), this.men.dtC(), this.men.dtD());
        }
        return this.mep;
    }
}
