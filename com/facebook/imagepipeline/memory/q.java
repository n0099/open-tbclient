package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private com.facebook.common.memory.j jXN;
    private c jXu;
    private com.facebook.common.memory.g jXx;
    private i jXz;
    private final p kbH;
    private k kbI;
    private com.facebook.common.memory.a kbJ;

    public q(p pVar) {
        this.kbH = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cHn() {
        if (this.jXu == null) {
            this.jXu = new c(this.kbH.cFm(), this.kbH.cHe(), this.kbH.cHf());
        }
        return this.jXu;
    }

    public i cHo() {
        if (this.jXz == null) {
            this.jXz = new i(this.kbH.cFm(), this.kbH.cHi());
        }
        return this.jXz;
    }

    public int cHp() {
        return this.kbH.cHi().kbP;
    }

    public k cHq() {
        if (this.kbI == null) {
            this.kbI = new k(this.kbH.cFm(), this.kbH.cHg(), this.kbH.cHh());
        }
        return this.kbI;
    }

    public com.facebook.common.memory.g cHr() {
        if (this.jXx == null) {
            this.jXx = new m(cHq(), cHs());
        }
        return this.jXx;
    }

    public com.facebook.common.memory.j cHs() {
        if (this.jXN == null) {
            this.jXN = new com.facebook.common.memory.j(cHt());
        }
        return this.jXN;
    }

    public com.facebook.common.memory.a cHt() {
        if (this.kbJ == null) {
            this.kbJ = new j(this.kbH.cFm(), this.kbH.cHj(), this.kbH.cHk());
        }
        return this.kbJ;
    }
}
