package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class q {
    private com.facebook.common.memory.j pJD;
    private c pJm;
    private com.facebook.common.memory.g pJp;
    private i pJr;
    private k pNA;
    private com.facebook.common.memory.a pNB;
    private final p pNz;

    public q(p pVar) {
        this.pNz = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c ezo() {
        if (this.pJm == null) {
            this.pJm = new c(this.pNz.exe(), this.pNz.ezf(), this.pNz.ezg());
        }
        return this.pJm;
    }

    public i ezp() {
        if (this.pJr == null) {
            this.pJr = new i(this.pNz.exe(), this.pNz.ezj());
        }
        return this.pJr;
    }

    public int ezq() {
        return this.pNz.ezj().pNI;
    }

    public k ezr() {
        if (this.pNA == null) {
            this.pNA = new k(this.pNz.exe(), this.pNz.ezh(), this.pNz.ezi());
        }
        return this.pNA;
    }

    public com.facebook.common.memory.g ezs() {
        if (this.pJp == null) {
            this.pJp = new m(ezr(), ezt());
        }
        return this.pJp;
    }

    public com.facebook.common.memory.j ezt() {
        if (this.pJD == null) {
            this.pJD = new com.facebook.common.memory.j(ezu());
        }
        return this.pJD;
    }

    public com.facebook.common.memory.a ezu() {
        if (this.pNB == null) {
            this.pNB = new j(this.pNz.exe(), this.pNz.ezk(), this.pNz.ezl());
        }
        return this.pNB;
    }
}
