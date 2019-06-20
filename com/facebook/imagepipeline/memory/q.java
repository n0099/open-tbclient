package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private com.facebook.common.memory.g jXB;
    private i jXD;
    private com.facebook.common.memory.j jXR;
    private c jXy;
    private final p kbL;
    private k kbM;
    private com.facebook.common.memory.a kbN;

    public q(p pVar) {
        this.kbL = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cHo() {
        if (this.jXy == null) {
            this.jXy = new c(this.kbL.cFn(), this.kbL.cHf(), this.kbL.cHg());
        }
        return this.jXy;
    }

    public i cHp() {
        if (this.jXD == null) {
            this.jXD = new i(this.kbL.cFn(), this.kbL.cHj());
        }
        return this.jXD;
    }

    public int cHq() {
        return this.kbL.cHj().kbT;
    }

    public k cHr() {
        if (this.kbM == null) {
            this.kbM = new k(this.kbL.cFn(), this.kbL.cHh(), this.kbL.cHi());
        }
        return this.kbM;
    }

    public com.facebook.common.memory.g cHs() {
        if (this.jXB == null) {
            this.jXB = new m(cHr(), cHt());
        }
        return this.jXB;
    }

    public com.facebook.common.memory.j cHt() {
        if (this.jXR == null) {
            this.jXR = new com.facebook.common.memory.j(cHu());
        }
        return this.jXR;
    }

    public com.facebook.common.memory.a cHu() {
        if (this.kbN == null) {
            this.kbN = new j(this.kbL.cFn(), this.kbL.cHk(), this.kbL.cHl());
        }
        return this.kbN;
    }
}
