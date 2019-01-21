package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private i ipA;
    private com.facebook.common.memory.j ipO;
    private c ipv;
    private com.facebook.common.memory.g ipy;
    private final p itG;
    private k itH;
    private com.facebook.common.memory.a itI;

    public q(p pVar) {
        this.itG = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cag() {
        if (this.ipv == null) {
            this.ipv = new c(this.itG.bYj(), this.itG.bZX(), this.itG.bZY());
        }
        return this.ipv;
    }

    public i cah() {
        if (this.ipA == null) {
            this.ipA = new i(this.itG.bYj(), this.itG.cab());
        }
        return this.ipA;
    }

    public int cai() {
        return this.itG.cab().itO;
    }

    public k caj() {
        if (this.itH == null) {
            this.itH = new k(this.itG.bYj(), this.itG.bZZ(), this.itG.caa());
        }
        return this.itH;
    }

    public com.facebook.common.memory.g cak() {
        if (this.ipy == null) {
            this.ipy = new m(caj(), cal());
        }
        return this.ipy;
    }

    public com.facebook.common.memory.j cal() {
        if (this.ipO == null) {
            this.ipO = new com.facebook.common.memory.j(cam());
        }
        return this.ipO;
    }

    public com.facebook.common.memory.a cam() {
        if (this.itI == null) {
            this.itI = new j(this.itG.bYj(), this.itG.cac(), this.itG.cad());
        }
        return this.itI;
    }
}
