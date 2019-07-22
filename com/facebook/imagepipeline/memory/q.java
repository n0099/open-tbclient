package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c keD;
    private com.facebook.common.memory.g keG;
    private i keI;
    private com.facebook.common.memory.j keW;
    private final p kiS;
    private k kiT;
    private com.facebook.common.memory.a kiU;

    public q(p pVar) {
        this.kiS = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cKs() {
        if (this.keD == null) {
            this.keD = new c(this.kiS.cIq(), this.kiS.cKj(), this.kiS.cKk());
        }
        return this.keD;
    }

    public i cKt() {
        if (this.keI == null) {
            this.keI = new i(this.kiS.cIq(), this.kiS.cKn());
        }
        return this.keI;
    }

    public int cKu() {
        return this.kiS.cKn().kja;
    }

    public k cKv() {
        if (this.kiT == null) {
            this.kiT = new k(this.kiS.cIq(), this.kiS.cKl(), this.kiS.cKm());
        }
        return this.kiT;
    }

    public com.facebook.common.memory.g cKw() {
        if (this.keG == null) {
            this.keG = new m(cKv(), cKx());
        }
        return this.keG;
    }

    public com.facebook.common.memory.j cKx() {
        if (this.keW == null) {
            this.keW = new com.facebook.common.memory.j(cKy());
        }
        return this.keW;
    }

    public com.facebook.common.memory.a cKy() {
        if (this.kiU == null) {
            this.kiU = new j(this.kiS.cIq(), this.kiS.cKo(), this.kiS.cKp());
        }
        return this.kiU;
    }
}
