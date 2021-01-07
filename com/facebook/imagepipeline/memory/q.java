package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
public class q {
    private c pAZ;
    private com.facebook.common.memory.g pBc;
    private i pBe;
    private com.facebook.common.memory.j pBq;
    private final p pFm;
    private k pFn;
    private com.facebook.common.memory.a pFo;

    public q(p pVar) {
        this.pFm = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c eAx() {
        if (this.pAZ == null) {
            this.pAZ = new c(this.pFm.eym(), this.pFm.eAo(), this.pFm.eAp());
        }
        return this.pAZ;
    }

    public i eAy() {
        if (this.pBe == null) {
            this.pBe = new i(this.pFm.eym(), this.pFm.eAs());
        }
        return this.pBe;
    }

    public int eAz() {
        return this.pFm.eAs().pFv;
    }

    public k eAA() {
        if (this.pFn == null) {
            this.pFn = new k(this.pFm.eym(), this.pFm.eAq(), this.pFm.eAr());
        }
        return this.pFn;
    }

    public com.facebook.common.memory.g eAB() {
        if (this.pBc == null) {
            this.pBc = new m(eAA(), eAC());
        }
        return this.pBc;
    }

    public com.facebook.common.memory.j eAC() {
        if (this.pBq == null) {
            this.pBq = new com.facebook.common.memory.j(eAD());
        }
        return this.pBq;
    }

    public com.facebook.common.memory.a eAD() {
        if (this.pFo == null) {
            this.pFo = new j(this.pFm.eym(), this.pFm.eAt(), this.pFm.eAu());
        }
        return this.pFo;
    }
}
