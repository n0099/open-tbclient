package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c jFb;
    private com.facebook.common.memory.g jFe;
    private i jFg;
    private com.facebook.common.memory.j jFu;
    private final p jJo;
    private k jJp;
    private com.facebook.common.memory.a jJq;

    public q(p pVar) {
        this.jJo = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c czl() {
        if (this.jFb == null) {
            this.jFb = new c(this.jJo.cxk(), this.jJo.czc(), this.jJo.czd());
        }
        return this.jFb;
    }

    public i czm() {
        if (this.jFg == null) {
            this.jFg = new i(this.jJo.cxk(), this.jJo.czg());
        }
        return this.jFg;
    }

    public int czn() {
        return this.jJo.czg().jJw;
    }

    public k czo() {
        if (this.jJp == null) {
            this.jJp = new k(this.jJo.cxk(), this.jJo.cze(), this.jJo.czf());
        }
        return this.jJp;
    }

    public com.facebook.common.memory.g czp() {
        if (this.jFe == null) {
            this.jFe = new m(czo(), czq());
        }
        return this.jFe;
    }

    public com.facebook.common.memory.j czq() {
        if (this.jFu == null) {
            this.jFu = new com.facebook.common.memory.j(czr());
        }
        return this.jFu;
    }

    public com.facebook.common.memory.a czr() {
        if (this.jJq == null) {
            this.jJq = new j(this.jJo.cxk(), this.jJo.czh(), this.jJo.czi());
        }
        return this.jJq;
    }
}
