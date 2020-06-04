package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private c muY;
    private com.facebook.common.memory.g mvb;
    private i mvd;
    private com.facebook.common.memory.j mvq;
    private final p mzo;
    private k mzp;
    private com.facebook.common.memory.a mzq;

    public q(p pVar) {
        this.mzo = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dBm() {
        if (this.muY == null) {
            this.muY = new c(this.mzo.dyY(), this.mzo.dBd(), this.mzo.dBe());
        }
        return this.muY;
    }

    public i dBn() {
        if (this.mvd == null) {
            this.mvd = new i(this.mzo.dyY(), this.mzo.dBh());
        }
        return this.mvd;
    }

    public int dBo() {
        return this.mzo.dBh().mzx;
    }

    public k dBp() {
        if (this.mzp == null) {
            this.mzp = new k(this.mzo.dyY(), this.mzo.dBf(), this.mzo.dBg());
        }
        return this.mzp;
    }

    public com.facebook.common.memory.g dBq() {
        if (this.mvb == null) {
            this.mvb = new m(dBp(), dBr());
        }
        return this.mvb;
    }

    public com.facebook.common.memory.j dBr() {
        if (this.mvq == null) {
            this.mvq = new com.facebook.common.memory.j(dBs());
        }
        return this.mvq;
    }

    public com.facebook.common.memory.a dBs() {
        if (this.mzq == null) {
            this.mzq = new j(this.mzo.dyY(), this.mzo.dBi(), this.mzo.dBj());
        }
        return this.mzq;
    }
}
