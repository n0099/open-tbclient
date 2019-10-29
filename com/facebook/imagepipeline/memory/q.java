package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private com.facebook.common.memory.j kgK;
    private c kgr;
    private com.facebook.common.memory.g kgu;
    private i kgw;
    private final p kkH;
    private k kkI;
    private com.facebook.common.memory.a kkJ;

    public q(p pVar) {
        this.kkH = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cIy() {
        if (this.kgr == null) {
            this.kgr = new c(this.kkH.cGw(), this.kkH.cIp(), this.kkH.cIq());
        }
        return this.kgr;
    }

    public i cIz() {
        if (this.kgw == null) {
            this.kgw = new i(this.kkH.cGw(), this.kkH.cIt());
        }
        return this.kgw;
    }

    public int cIA() {
        return this.kkH.cIt().kkP;
    }

    public k cIB() {
        if (this.kkI == null) {
            this.kkI = new k(this.kkH.cGw(), this.kkH.cIr(), this.kkH.cIs());
        }
        return this.kkI;
    }

    public com.facebook.common.memory.g cIC() {
        if (this.kgu == null) {
            this.kgu = new m(cIB(), cID());
        }
        return this.kgu;
    }

    public com.facebook.common.memory.j cID() {
        if (this.kgK == null) {
            this.kgK = new com.facebook.common.memory.j(cIE());
        }
        return this.kgK;
    }

    public com.facebook.common.memory.a cIE() {
        if (this.kkJ == null) {
            this.kkJ = new j(this.kkH.cGw(), this.kkH.cIu(), this.kkH.cIv());
        }
        return this.kkJ;
    }
}
