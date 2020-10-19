package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes18.dex */
public class q {
    private c nSH;
    private com.facebook.common.memory.g nSK;
    private i nSM;
    private com.facebook.common.memory.j nSZ;
    private final p nWX;
    private k nWY;
    private com.facebook.common.memory.a nWZ;

    public q(p pVar) {
        this.nWX = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c ecW() {
        if (this.nSH == null) {
            this.nSH = new c(this.nWX.eaI(), this.nWX.ecN(), this.nWX.ecO());
        }
        return this.nSH;
    }

    public i ecX() {
        if (this.nSM == null) {
            this.nSM = new i(this.nWX.eaI(), this.nWX.ecR());
        }
        return this.nSM;
    }

    public int ecY() {
        return this.nWX.ecR().nXg;
    }

    public k ecZ() {
        if (this.nWY == null) {
            this.nWY = new k(this.nWX.eaI(), this.nWX.ecP(), this.nWX.ecQ());
        }
        return this.nWY;
    }

    public com.facebook.common.memory.g eda() {
        if (this.nSK == null) {
            this.nSK = new m(ecZ(), edb());
        }
        return this.nSK;
    }

    public com.facebook.common.memory.j edb() {
        if (this.nSZ == null) {
            this.nSZ = new com.facebook.common.memory.j(edc());
        }
        return this.nSZ;
    }

    public com.facebook.common.memory.a edc() {
        if (this.nWZ == null) {
            this.nWZ = new j(this.nWX.eaI(), this.nWX.ecS(), this.nWX.ecT());
        }
        return this.nWZ;
    }
}
