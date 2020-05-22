package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private c mtO;
    private com.facebook.common.memory.g mtR;
    private i mtT;
    private com.facebook.common.memory.j mug;
    private final p mye;
    private k myf;
    private com.facebook.common.memory.a myg;

    public q(p pVar) {
        this.mye = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dAY() {
        if (this.mtO == null) {
            this.mtO = new c(this.mye.dyK(), this.mye.dAP(), this.mye.dAQ());
        }
        return this.mtO;
    }

    public i dAZ() {
        if (this.mtT == null) {
            this.mtT = new i(this.mye.dyK(), this.mye.dAT());
        }
        return this.mtT;
    }

    public int dBa() {
        return this.mye.dAT().myn;
    }

    public k dBb() {
        if (this.myf == null) {
            this.myf = new k(this.mye.dyK(), this.mye.dAR(), this.mye.dAS());
        }
        return this.myf;
    }

    public com.facebook.common.memory.g dBc() {
        if (this.mtR == null) {
            this.mtR = new m(dBb(), dBd());
        }
        return this.mtR;
    }

    public com.facebook.common.memory.j dBd() {
        if (this.mug == null) {
            this.mug = new com.facebook.common.memory.j(dBe());
        }
        return this.mug;
    }

    public com.facebook.common.memory.a dBe() {
        if (this.myg == null) {
            this.myg = new j(this.mye.dyK(), this.mye.dAU(), this.mye.dAV());
        }
        return this.myg;
    }
}
