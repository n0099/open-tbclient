package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c idR;
    private com.facebook.common.memory.g idU;
    private i idW;
    private com.facebook.common.memory.j iek;
    private final p iic;
    private k iid;
    private com.facebook.common.memory.a iie;

    public q(p pVar) {
        this.iic = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c bWC() {
        if (this.idR == null) {
            this.idR = new c(this.iic.bUF(), this.iic.bWt(), this.iic.bWu());
        }
        return this.idR;
    }

    public i bWD() {
        if (this.idW == null) {
            this.idW = new i(this.iic.bUF(), this.iic.bWx());
        }
        return this.idW;
    }

    public int bWE() {
        return this.iic.bWx().iik;
    }

    public k bWF() {
        if (this.iid == null) {
            this.iid = new k(this.iic.bUF(), this.iic.bWv(), this.iic.bWw());
        }
        return this.iid;
    }

    public com.facebook.common.memory.g bWG() {
        if (this.idU == null) {
            this.idU = new m(bWF(), bWH());
        }
        return this.idU;
    }

    public com.facebook.common.memory.j bWH() {
        if (this.iek == null) {
            this.iek = new com.facebook.common.memory.j(bWI());
        }
        return this.iek;
    }

    public com.facebook.common.memory.a bWI() {
        if (this.iie == null) {
            this.iie = new j(this.iic.bUF(), this.iic.bWy(), this.iic.bWz());
        }
        return this.iie;
    }
}
