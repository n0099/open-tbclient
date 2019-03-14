package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private com.facebook.common.memory.j jFF;
    private c jFm;
    private com.facebook.common.memory.g jFp;
    private i jFr;
    private k jJA;
    private com.facebook.common.memory.a jJB;
    private final p jJz;

    public q(p pVar) {
        this.jJz = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c czy() {
        if (this.jFm == null) {
            this.jFm = new c(this.jJz.cxx(), this.jJz.czp(), this.jJz.czq());
        }
        return this.jFm;
    }

    public i czz() {
        if (this.jFr == null) {
            this.jFr = new i(this.jJz.cxx(), this.jJz.czt());
        }
        return this.jFr;
    }

    public int czA() {
        return this.jJz.czt().jJH;
    }

    public k czB() {
        if (this.jJA == null) {
            this.jJA = new k(this.jJz.cxx(), this.jJz.czr(), this.jJz.czs());
        }
        return this.jJA;
    }

    public com.facebook.common.memory.g czC() {
        if (this.jFp == null) {
            this.jFp = new m(czB(), czD());
        }
        return this.jFp;
    }

    public com.facebook.common.memory.j czD() {
        if (this.jFF == null) {
            this.jFF = new com.facebook.common.memory.j(czE());
        }
        return this.jFF;
    }

    public com.facebook.common.memory.a czE() {
        if (this.jJB == null) {
            this.jJB = new j(this.jJz.cxx(), this.jJz.czu(), this.jJz.czv());
        }
        return this.jJB;
    }
}
