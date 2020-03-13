package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private c lQA;
    private com.facebook.common.memory.g lQD;
    private i lQF;
    private com.facebook.common.memory.j lQT;
    private final p lUS;
    private k lUT;
    private com.facebook.common.memory.a lUU;

    public q(p pVar) {
        this.lUS = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dro() {
        if (this.lQA == null) {
            this.lQA = new c(this.lUS.doZ(), this.lUS.drf(), this.lUS.drg());
        }
        return this.lQA;
    }

    public i drp() {
        if (this.lQF == null) {
            this.lQF = new i(this.lUS.doZ(), this.lUS.drj());
        }
        return this.lQF;
    }

    public int drq() {
        return this.lUS.drj().lVb;
    }

    public k drr() {
        if (this.lUT == null) {
            this.lUT = new k(this.lUS.doZ(), this.lUS.drh(), this.lUS.dri());
        }
        return this.lUT;
    }

    public com.facebook.common.memory.g drs() {
        if (this.lQD == null) {
            this.lQD = new m(drr(), drt());
        }
        return this.lQD;
    }

    public com.facebook.common.memory.j drt() {
        if (this.lQT == null) {
            this.lQT = new com.facebook.common.memory.j(dru());
        }
        return this.lQT;
    }

    public com.facebook.common.memory.a dru() {
        if (this.lUU == null) {
            this.lUU = new j(this.lUS.doZ(), this.lUS.drk(), this.lUS.drl());
        }
        return this.lUU;
    }
}
