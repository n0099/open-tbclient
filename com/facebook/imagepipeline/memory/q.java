package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c jEH;
    private com.facebook.common.memory.g jEK;
    private i jEM;
    private com.facebook.common.memory.j jFa;
    private final p jIU;
    private k jIV;
    private com.facebook.common.memory.a jIW;

    public q(p pVar) {
        this.jIU = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c czr() {
        if (this.jEH == null) {
            this.jEH = new c(this.jIU.cxq(), this.jIU.czi(), this.jIU.czj());
        }
        return this.jEH;
    }

    public i czs() {
        if (this.jEM == null) {
            this.jEM = new i(this.jIU.cxq(), this.jIU.czm());
        }
        return this.jEM;
    }

    public int czt() {
        return this.jIU.czm().jJc;
    }

    public k czu() {
        if (this.jIV == null) {
            this.jIV = new k(this.jIU.cxq(), this.jIU.czk(), this.jIU.czl());
        }
        return this.jIV;
    }

    public com.facebook.common.memory.g czv() {
        if (this.jEK == null) {
            this.jEK = new m(czu(), czw());
        }
        return this.jEK;
    }

    public com.facebook.common.memory.j czw() {
        if (this.jFa == null) {
            this.jFa = new com.facebook.common.memory.j(czx());
        }
        return this.jFa;
    }

    public com.facebook.common.memory.a czx() {
        if (this.jIW == null) {
            this.jIW = new j(this.jIU.cxq(), this.jIU.czn(), this.jIU.czo());
        }
        return this.jIW;
    }
}
