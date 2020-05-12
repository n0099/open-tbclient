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

    public c dtH() {
        if (this.lZT == null) {
            this.lZT = new c(this.men.drs(), this.men.dty(), this.men.dtz());
        }
        return this.lZT;
    }

    public i dtI() {
        if (this.lZY == null) {
            this.lZY = new i(this.men.drs(), this.men.dtC());
        }
        return this.lZY;
    }

    public int dtJ() {
        return this.men.dtC().mew;
    }

    public k dtK() {
        if (this.meo == null) {
            this.meo = new k(this.men.drs(), this.men.dtA(), this.men.dtB());
        }
        return this.meo;
    }

    public com.facebook.common.memory.g dtL() {
        if (this.lZW == null) {
            this.lZW = new m(dtK(), dtM());
        }
        return this.lZW;
    }

    public com.facebook.common.memory.j dtM() {
        if (this.man == null) {
            this.man = new com.facebook.common.memory.j(dtN());
        }
        return this.man;
    }

    public com.facebook.common.memory.a dtN() {
        if (this.mep == null) {
            this.mep = new j(this.men.drs(), this.men.dtD(), this.men.dtE());
        }
        return this.mep;
    }
}
