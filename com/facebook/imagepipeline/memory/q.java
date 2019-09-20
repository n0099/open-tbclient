package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private com.facebook.common.memory.j kiA;
    private c kih;
    private com.facebook.common.memory.g kik;
    private i kim;
    private final p kmv;
    private k kmw;
    private com.facebook.common.memory.a kmx;

    public q(p pVar) {
        this.kmv = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cLB() {
        if (this.kih == null) {
            this.kih = new c(this.kmv.cJz(), this.kmv.cLs(), this.kmv.cLt());
        }
        return this.kih;
    }

    public i cLC() {
        if (this.kim == null) {
            this.kim = new i(this.kmv.cJz(), this.kmv.cLw());
        }
        return this.kim;
    }

    public int cLD() {
        return this.kmv.cLw().kmD;
    }

    public k cLE() {
        if (this.kmw == null) {
            this.kmw = new k(this.kmv.cJz(), this.kmv.cLu(), this.kmv.cLv());
        }
        return this.kmw;
    }

    public com.facebook.common.memory.g cLF() {
        if (this.kik == null) {
            this.kik = new m(cLE(), cLG());
        }
        return this.kik;
    }

    public com.facebook.common.memory.j cLG() {
        if (this.kiA == null) {
            this.kiA = new com.facebook.common.memory.j(cLH());
        }
        return this.kiA;
    }

    public com.facebook.common.memory.a cLH() {
        if (this.kmx == null) {
            this.kmx = new j(this.kmv.cJz(), this.kmv.cLx(), this.kmv.cLy());
        }
        return this.kmx;
    }
}
