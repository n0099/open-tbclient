package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c kfJ;
    private com.facebook.common.memory.g kfM;
    private i kfO;
    private com.facebook.common.memory.j kgc;
    private final p kjY;
    private k kjZ;
    private com.facebook.common.memory.a kka;

    public q(p pVar) {
        this.kjY = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cKN() {
        if (this.kfJ == null) {
            this.kfJ = new c(this.kjY.cIL(), this.kjY.cKE(), this.kjY.cKF());
        }
        return this.kfJ;
    }

    public i cKO() {
        if (this.kfO == null) {
            this.kfO = new i(this.kjY.cIL(), this.kjY.cKI());
        }
        return this.kfO;
    }

    public int cKP() {
        return this.kjY.cKI().kkg;
    }

    public k cKQ() {
        if (this.kjZ == null) {
            this.kjZ = new k(this.kjY.cIL(), this.kjY.cKG(), this.kjY.cKH());
        }
        return this.kjZ;
    }

    public com.facebook.common.memory.g cKR() {
        if (this.kfM == null) {
            this.kfM = new m(cKQ(), cKS());
        }
        return this.kfM;
    }

    public com.facebook.common.memory.j cKS() {
        if (this.kgc == null) {
            this.kgc = new com.facebook.common.memory.j(cKT());
        }
        return this.kgc;
    }

    public com.facebook.common.memory.a cKT() {
        if (this.kka == null) {
            this.kka = new j(this.kjY.cIL(), this.kjY.cKJ(), this.kjY.cKK());
        }
        return this.kka;
    }
}
