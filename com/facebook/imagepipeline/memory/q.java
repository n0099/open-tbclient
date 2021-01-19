package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
public class q {
    private final p pAM;
    private k pAN;
    private com.facebook.common.memory.a pAO;
    private com.facebook.common.memory.g pwC;
    private i pwE;
    private com.facebook.common.memory.j pwQ;
    private c pwz;

    public q(p pVar) {
        this.pAM = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c ewF() {
        if (this.pwz == null) {
            this.pwz = new c(this.pAM.euu(), this.pAM.eww(), this.pAM.ewx());
        }
        return this.pwz;
    }

    public i ewG() {
        if (this.pwE == null) {
            this.pwE = new i(this.pAM.euu(), this.pAM.ewA());
        }
        return this.pwE;
    }

    public int ewH() {
        return this.pAM.ewA().pAV;
    }

    public k ewI() {
        if (this.pAN == null) {
            this.pAN = new k(this.pAM.euu(), this.pAM.ewy(), this.pAM.ewz());
        }
        return this.pAN;
    }

    public com.facebook.common.memory.g ewJ() {
        if (this.pwC == null) {
            this.pwC = new m(ewI(), ewK());
        }
        return this.pwC;
    }

    public com.facebook.common.memory.j ewK() {
        if (this.pwQ == null) {
            this.pwQ = new com.facebook.common.memory.j(ewL());
        }
        return this.pwQ;
    }

    public com.facebook.common.memory.a ewL() {
        if (this.pAO == null) {
            this.pAO = new j(this.pAM.euu(), this.pAM.ewB(), this.pAM.ewC());
        }
        return this.pAO;
    }
}
