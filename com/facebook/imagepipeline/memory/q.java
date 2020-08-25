package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes8.dex */
public class q {
    private c nsY;
    private com.facebook.common.memory.g ntb;
    private i ntd;
    private com.facebook.common.memory.j ntq;
    private final p nxr;
    private k nxs;
    private com.facebook.common.memory.a nxt;

    public q(p pVar) {
        this.nxr = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dVe() {
        if (this.nsY == null) {
            this.nsY = new c(this.nxr.dSQ(), this.nxr.dUV(), this.nxr.dUW());
        }
        return this.nsY;
    }

    public i dVf() {
        if (this.ntd == null) {
            this.ntd = new i(this.nxr.dSQ(), this.nxr.dUZ());
        }
        return this.ntd;
    }

    public int dVg() {
        return this.nxr.dUZ().nxA;
    }

    public k dVh() {
        if (this.nxs == null) {
            this.nxs = new k(this.nxr.dSQ(), this.nxr.dUX(), this.nxr.dUY());
        }
        return this.nxs;
    }

    public com.facebook.common.memory.g dVi() {
        if (this.ntb == null) {
            this.ntb = new m(dVh(), dVj());
        }
        return this.ntb;
    }

    public com.facebook.common.memory.j dVj() {
        if (this.ntq == null) {
            this.ntq = new com.facebook.common.memory.j(dVk());
        }
        return this.ntq;
    }

    public com.facebook.common.memory.a dVk() {
        if (this.nxt == null) {
            this.nxt = new j(this.nxr.dSQ(), this.nxr.dVa(), this.nxr.dVb());
        }
        return this.nxt;
    }
}
