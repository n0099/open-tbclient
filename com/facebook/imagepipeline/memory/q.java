package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class q {
    private c pGH;
    private com.facebook.common.memory.g pGK;
    private i pGM;
    private com.facebook.common.memory.j pGY;
    private final p pKU;
    private k pKV;
    private com.facebook.common.memory.a pKW;

    public q(p pVar) {
        this.pKU = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c eyX() {
        if (this.pGH == null) {
            this.pGH = new c(this.pKU.ewN(), this.pKU.eyO(), this.pKU.eyP());
        }
        return this.pGH;
    }

    public i eyY() {
        if (this.pGM == null) {
            this.pGM = new i(this.pKU.ewN(), this.pKU.eyS());
        }
        return this.pGM;
    }

    public int eyZ() {
        return this.pKU.eyS().pLd;
    }

    public k eza() {
        if (this.pKV == null) {
            this.pKV = new k(this.pKU.ewN(), this.pKU.eyQ(), this.pKU.eyR());
        }
        return this.pKV;
    }

    public com.facebook.common.memory.g ezb() {
        if (this.pGK == null) {
            this.pGK = new m(eza(), ezc());
        }
        return this.pGK;
    }

    public com.facebook.common.memory.j ezc() {
        if (this.pGY == null) {
            this.pGY = new com.facebook.common.memory.j(ezd());
        }
        return this.pGY;
    }

    public com.facebook.common.memory.a ezd() {
        if (this.pKW == null) {
            this.pKW = new j(this.pKU.ewN(), this.pKU.eyT(), this.pKU.eyU());
        }
        return this.pKW;
    }
}
