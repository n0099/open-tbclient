package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes8.dex */
public class q {
    private com.facebook.common.memory.j ntI;
    private c ntq;
    private com.facebook.common.memory.g ntt;
    private i ntv;
    private final p nxJ;
    private k nxK;
    private com.facebook.common.memory.a nxL;

    public q(p pVar) {
        this.nxJ = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dVn() {
        if (this.ntq == null) {
            this.ntq = new c(this.nxJ.dSZ(), this.nxJ.dVe(), this.nxJ.dVf());
        }
        return this.ntq;
    }

    public i dVo() {
        if (this.ntv == null) {
            this.ntv = new i(this.nxJ.dSZ(), this.nxJ.dVi());
        }
        return this.ntv;
    }

    public int dVp() {
        return this.nxJ.dVi().nxS;
    }

    public k dVq() {
        if (this.nxK == null) {
            this.nxK = new k(this.nxJ.dSZ(), this.nxJ.dVg(), this.nxJ.dVh());
        }
        return this.nxK;
    }

    public com.facebook.common.memory.g dVr() {
        if (this.ntt == null) {
            this.ntt = new m(dVq(), dVs());
        }
        return this.ntt;
    }

    public com.facebook.common.memory.j dVs() {
        if (this.ntI == null) {
            this.ntI = new com.facebook.common.memory.j(dVt());
        }
        return this.ntI;
    }

    public com.facebook.common.memory.a dVt() {
        if (this.nxL == null) {
            this.nxL = new j(this.nxJ.dSZ(), this.nxJ.dVj(), this.nxJ.dVk());
        }
        return this.nxL;
    }
}
