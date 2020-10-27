package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes18.dex */
public class q {
    private c oJZ;
    private com.facebook.common.memory.g oKc;
    private i oKe;
    private com.facebook.common.memory.j oKr;
    private final p oOp;
    private k oOq;
    private com.facebook.common.memory.a oOr;

    public q(p pVar) {
        this.oOp = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c emU() {
        if (this.oJZ == null) {
            this.oJZ = new c(this.oOp.ekG(), this.oOp.emL(), this.oOp.emM());
        }
        return this.oJZ;
    }

    public i emV() {
        if (this.oKe == null) {
            this.oKe = new i(this.oOp.ekG(), this.oOp.emP());
        }
        return this.oKe;
    }

    public int emW() {
        return this.oOp.emP().oOy;
    }

    public k emX() {
        if (this.oOq == null) {
            this.oOq = new k(this.oOp.ekG(), this.oOp.emN(), this.oOp.emO());
        }
        return this.oOq;
    }

    public com.facebook.common.memory.g emY() {
        if (this.oKc == null) {
            this.oKc = new m(emX(), emZ());
        }
        return this.oKc;
    }

    public com.facebook.common.memory.j emZ() {
        if (this.oKr == null) {
            this.oKr = new com.facebook.common.memory.j(ena());
        }
        return this.oKr;
    }

    public com.facebook.common.memory.a ena() {
        if (this.oOr == null) {
            this.oOr = new j(this.oOp.ekG(), this.oOp.emQ(), this.oOp.emR());
        }
        return this.oOr;
    }
}
