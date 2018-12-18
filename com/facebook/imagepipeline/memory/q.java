package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c ilb;
    private com.facebook.common.memory.g ile;
    private i ilg;
    private com.facebook.common.memory.j ilu;
    private final p ipo;
    private k ipp;
    private com.facebook.common.memory.a ipq;

    public q(p pVar) {
        this.ipo = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c bYH() {
        if (this.ilb == null) {
            this.ilb = new c(this.ipo.bWK(), this.ipo.bYy(), this.ipo.bYz());
        }
        return this.ilb;
    }

    public i bYI() {
        if (this.ilg == null) {
            this.ilg = new i(this.ipo.bWK(), this.ipo.bYC());
        }
        return this.ilg;
    }

    public int bYJ() {
        return this.ipo.bYC().ipw;
    }

    public k bYK() {
        if (this.ipp == null) {
            this.ipp = new k(this.ipo.bWK(), this.ipo.bYA(), this.ipo.bYB());
        }
        return this.ipp;
    }

    public com.facebook.common.memory.g bYL() {
        if (this.ile == null) {
            this.ile = new m(bYK(), bYM());
        }
        return this.ile;
    }

    public com.facebook.common.memory.j bYM() {
        if (this.ilu == null) {
            this.ilu = new com.facebook.common.memory.j(bYN());
        }
        return this.ilu;
    }

    public com.facebook.common.memory.a bYN() {
        if (this.ipq == null) {
            this.ipq = new j(this.ipo.bWK(), this.ipo.bYD(), this.ipo.bYE());
        }
        return this.ipq;
    }
}
