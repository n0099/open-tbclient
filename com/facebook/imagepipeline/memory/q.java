package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private com.facebook.common.memory.j jFN;
    private c jFu;
    private com.facebook.common.memory.g jFx;
    private i jFz;
    private final p jJH;
    private k jJI;
    private com.facebook.common.memory.a jJJ;

    public q(p pVar) {
        this.jJH = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c czv() {
        if (this.jFu == null) {
            this.jFu = new c(this.jJH.cxu(), this.jJH.czm(), this.jJH.czn());
        }
        return this.jFu;
    }

    public i czw() {
        if (this.jFz == null) {
            this.jFz = new i(this.jJH.cxu(), this.jJH.czq());
        }
        return this.jFz;
    }

    public int czx() {
        return this.jJH.czq().jJP;
    }

    public k czy() {
        if (this.jJI == null) {
            this.jJI = new k(this.jJH.cxu(), this.jJH.czo(), this.jJH.czp());
        }
        return this.jJI;
    }

    public com.facebook.common.memory.g czz() {
        if (this.jFx == null) {
            this.jFx = new m(czy(), czA());
        }
        return this.jFx;
    }

    public com.facebook.common.memory.j czA() {
        if (this.jFN == null) {
            this.jFN = new com.facebook.common.memory.j(czB());
        }
        return this.jFN;
    }

    public com.facebook.common.memory.a czB() {
        if (this.jJJ == null) {
            this.jJJ = new j(this.jJH.cxu(), this.jJH.czr(), this.jJH.czs());
        }
        return this.jJJ;
    }
}
