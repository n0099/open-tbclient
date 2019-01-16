package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private com.facebook.common.memory.j ipN;
    private c ipu;
    private com.facebook.common.memory.g ipx;
    private i ipz;
    private final p itF;
    private k itG;
    private com.facebook.common.memory.a itH;

    public q(p pVar) {
        this.itF = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cag() {
        if (this.ipu == null) {
            this.ipu = new c(this.itF.bYj(), this.itF.bZX(), this.itF.bZY());
        }
        return this.ipu;
    }

    public i cah() {
        if (this.ipz == null) {
            this.ipz = new i(this.itF.bYj(), this.itF.cab());
        }
        return this.ipz;
    }

    public int cai() {
        return this.itF.cab().itN;
    }

    public k caj() {
        if (this.itG == null) {
            this.itG = new k(this.itF.bYj(), this.itF.bZZ(), this.itF.caa());
        }
        return this.itG;
    }

    public com.facebook.common.memory.g cak() {
        if (this.ipx == null) {
            this.ipx = new m(caj(), cal());
        }
        return this.ipx;
    }

    public com.facebook.common.memory.j cal() {
        if (this.ipN == null) {
            this.ipN = new com.facebook.common.memory.j(cam());
        }
        return this.ipN;
    }

    public com.facebook.common.memory.a cam() {
        if (this.itH == null) {
            this.itH = new j(this.itF.bYj(), this.itF.cac(), this.itF.cad());
        }
        return this.itH;
    }
}
