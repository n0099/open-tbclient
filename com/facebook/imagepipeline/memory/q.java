package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
public class q {
    private final p pAL;
    private k pAM;
    private com.facebook.common.memory.a pAN;
    private com.facebook.common.memory.g pwB;
    private i pwD;
    private com.facebook.common.memory.j pwP;
    private c pwy;

    public q(p pVar) {
        this.pAL = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c ewF() {
        if (this.pwy == null) {
            this.pwy = new c(this.pAL.euu(), this.pAL.eww(), this.pAL.ewx());
        }
        return this.pwy;
    }

    public i ewG() {
        if (this.pwD == null) {
            this.pwD = new i(this.pAL.euu(), this.pAL.ewA());
        }
        return this.pwD;
    }

    public int ewH() {
        return this.pAL.ewA().pAU;
    }

    public k ewI() {
        if (this.pAM == null) {
            this.pAM = new k(this.pAL.euu(), this.pAL.ewy(), this.pAL.ewz());
        }
        return this.pAM;
    }

    public com.facebook.common.memory.g ewJ() {
        if (this.pwB == null) {
            this.pwB = new m(ewI(), ewK());
        }
        return this.pwB;
    }

    public com.facebook.common.memory.j ewK() {
        if (this.pwP == null) {
            this.pwP = new com.facebook.common.memory.j(ewL());
        }
        return this.pwP;
    }

    public com.facebook.common.memory.a ewL() {
        if (this.pAN == null) {
            this.pAN = new j(this.pAL.euu(), this.pAL.ewB(), this.pAL.ewC());
        }
        return this.pAN;
    }
}
