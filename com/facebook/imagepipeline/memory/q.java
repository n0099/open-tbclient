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

    public c bYI() {
        if (this.ilb == null) {
            this.ilb = new c(this.ipo.bWL(), this.ipo.bYz(), this.ipo.bYA());
        }
        return this.ilb;
    }

    public i bYJ() {
        if (this.ilg == null) {
            this.ilg = new i(this.ipo.bWL(), this.ipo.bYD());
        }
        return this.ilg;
    }

    public int bYK() {
        return this.ipo.bYD().ipw;
    }

    public k bYL() {
        if (this.ipp == null) {
            this.ipp = new k(this.ipo.bWL(), this.ipo.bYB(), this.ipo.bYC());
        }
        return this.ipp;
    }

    public com.facebook.common.memory.g bYM() {
        if (this.ile == null) {
            this.ile = new m(bYL(), bYN());
        }
        return this.ile;
    }

    public com.facebook.common.memory.j bYN() {
        if (this.ilu == null) {
            this.ilu = new com.facebook.common.memory.j(bYO());
        }
        return this.ilu;
    }

    public com.facebook.common.memory.a bYO() {
        if (this.ipq == null) {
            this.ipq = new j(this.ipo.bWL(), this.ipo.bYE(), this.ipo.bYF());
        }
        return this.ipq;
    }
}
