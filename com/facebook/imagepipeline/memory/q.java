package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class q {
    private final p pDF;
    private k pDG;
    private com.facebook.common.memory.a pDH;
    private com.facebook.common.memory.j pzJ;
    private c pzs;
    private com.facebook.common.memory.g pzv;
    private i pzx;

    public q(p pVar) {
        this.pDF = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c ezT() {
        if (this.pzs == null) {
            this.pzs = new c(this.pDF.exK(), this.pDF.ezK(), this.pDF.ezL());
        }
        return this.pzs;
    }

    public i ezU() {
        if (this.pzx == null) {
            this.pzx = new i(this.pDF.exK(), this.pDF.ezO());
        }
        return this.pzx;
    }

    public int ezV() {
        return this.pDF.ezO().pDO;
    }

    public k ezW() {
        if (this.pDG == null) {
            this.pDG = new k(this.pDF.exK(), this.pDF.ezM(), this.pDF.ezN());
        }
        return this.pDG;
    }

    public com.facebook.common.memory.g ezX() {
        if (this.pzv == null) {
            this.pzv = new m(ezW(), ezY());
        }
        return this.pzv;
    }

    public com.facebook.common.memory.j ezY() {
        if (this.pzJ == null) {
            this.pzJ = new com.facebook.common.memory.j(ezZ());
        }
        return this.pzJ;
    }

    public com.facebook.common.memory.a ezZ() {
        if (this.pDH == null) {
            this.pDH = new j(this.pDF.exK(), this.pDF.ezP(), this.pDF.ezQ());
        }
        return this.pDH;
    }
}
