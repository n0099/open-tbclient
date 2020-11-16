package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
public class q {
    private c oUV;
    private com.facebook.common.memory.g oUY;
    private i oVa;
    private com.facebook.common.memory.j oVn;
    private final p oZl;
    private k oZm;
    private com.facebook.common.memory.a oZn;

    public q(p pVar) {
        this.oZl = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c eqJ() {
        if (this.oUV == null) {
            this.oUV = new c(this.oZl.eov(), this.oZl.eqA(), this.oZl.eqB());
        }
        return this.oUV;
    }

    public i eqK() {
        if (this.oVa == null) {
            this.oVa = new i(this.oZl.eov(), this.oZl.eqE());
        }
        return this.oVa;
    }

    public int eqL() {
        return this.oZl.eqE().oZu;
    }

    public k eqM() {
        if (this.oZm == null) {
            this.oZm = new k(this.oZl.eov(), this.oZl.eqC(), this.oZl.eqD());
        }
        return this.oZm;
    }

    public com.facebook.common.memory.g eqN() {
        if (this.oUY == null) {
            this.oUY = new m(eqM(), eqO());
        }
        return this.oUY;
    }

    public com.facebook.common.memory.j eqO() {
        if (this.oVn == null) {
            this.oVn = new com.facebook.common.memory.j(eqP());
        }
        return this.oVn;
    }

    public com.facebook.common.memory.a eqP() {
        if (this.oZn == null) {
            this.oZn = new j(this.oZl.eov(), this.oZl.eqF(), this.oZl.eqG());
        }
        return this.oZn;
    }
}
