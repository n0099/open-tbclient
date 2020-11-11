package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes18.dex */
public class q {
    private com.facebook.common.memory.j oTK;
    private c oTs;
    private com.facebook.common.memory.g oTv;
    private i oTx;
    private final p oXI;
    private k oXJ;
    private com.facebook.common.memory.a oXK;

    public q(p pVar) {
        this.oXI = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c eqL() {
        if (this.oTs == null) {
            this.oTs = new c(this.oXI.eox(), this.oXI.eqC(), this.oXI.eqD());
        }
        return this.oTs;
    }

    public i eqM() {
        if (this.oTx == null) {
            this.oTx = new i(this.oXI.eox(), this.oXI.eqG());
        }
        return this.oTx;
    }

    public int eqN() {
        return this.oXI.eqG().oXR;
    }

    public k eqO() {
        if (this.oXJ == null) {
            this.oXJ = new k(this.oXI.eox(), this.oXI.eqE(), this.oXI.eqF());
        }
        return this.oXJ;
    }

    public com.facebook.common.memory.g eqP() {
        if (this.oTv == null) {
            this.oTv = new m(eqO(), eqQ());
        }
        return this.oTv;
    }

    public com.facebook.common.memory.j eqQ() {
        if (this.oTK == null) {
            this.oTK = new com.facebook.common.memory.j(eqR());
        }
        return this.oTK;
    }

    public com.facebook.common.memory.a eqR() {
        if (this.oXK == null) {
            this.oXK = new j(this.oXI.eox(), this.oXI.eqH(), this.oXI.eqI());
        }
        return this.oXK;
    }
}
