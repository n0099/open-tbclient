package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private i jXA;
    private com.facebook.common.memory.j jXO;
    private c jXv;
    private com.facebook.common.memory.g jXy;
    private final p kbI;
    private k kbJ;
    private com.facebook.common.memory.a kbK;

    public q(p pVar) {
        this.kbI = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cHp() {
        if (this.jXv == null) {
            this.jXv = new c(this.kbI.cFo(), this.kbI.cHg(), this.kbI.cHh());
        }
        return this.jXv;
    }

    public i cHq() {
        if (this.jXA == null) {
            this.jXA = new i(this.kbI.cFo(), this.kbI.cHk());
        }
        return this.jXA;
    }

    public int cHr() {
        return this.kbI.cHk().kbQ;
    }

    public k cHs() {
        if (this.kbJ == null) {
            this.kbJ = new k(this.kbI.cFo(), this.kbI.cHi(), this.kbI.cHj());
        }
        return this.kbJ;
    }

    public com.facebook.common.memory.g cHt() {
        if (this.jXy == null) {
            this.jXy = new m(cHs(), cHu());
        }
        return this.jXy;
    }

    public com.facebook.common.memory.j cHu() {
        if (this.jXO == null) {
            this.jXO = new com.facebook.common.memory.j(cHv());
        }
        return this.jXO;
    }

    public com.facebook.common.memory.a cHv() {
        if (this.kbK == null) {
            this.kbK = new j(this.kbI.cFo(), this.kbI.cHl(), this.kbI.cHm());
        }
        return this.kbK;
    }
}
