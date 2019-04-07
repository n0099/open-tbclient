package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c jEG;
    private com.facebook.common.memory.g jEJ;
    private i jEL;
    private com.facebook.common.memory.j jEZ;
    private final p jIT;
    private k jIU;
    private com.facebook.common.memory.a jIV;

    public q(p pVar) {
        this.jIT = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c czr() {
        if (this.jEG == null) {
            this.jEG = new c(this.jIT.cxq(), this.jIT.czi(), this.jIT.czj());
        }
        return this.jEG;
    }

    public i czs() {
        if (this.jEL == null) {
            this.jEL = new i(this.jIT.cxq(), this.jIT.czm());
        }
        return this.jEL;
    }

    public int czt() {
        return this.jIT.czm().jJb;
    }

    public k czu() {
        if (this.jIU == null) {
            this.jIU = new k(this.jIT.cxq(), this.jIT.czk(), this.jIT.czl());
        }
        return this.jIU;
    }

    public com.facebook.common.memory.g czv() {
        if (this.jEJ == null) {
            this.jEJ = new m(czu(), czw());
        }
        return this.jEJ;
    }

    public com.facebook.common.memory.j czw() {
        if (this.jEZ == null) {
            this.jEZ = new com.facebook.common.memory.j(czx());
        }
        return this.jEZ;
    }

    public com.facebook.common.memory.a czx() {
        if (this.jIV == null) {
            this.jIV = new j(this.jIT.cxq(), this.jIT.czn(), this.jIT.czo());
        }
        return this.jIV;
    }
}
