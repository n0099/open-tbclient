package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes4.dex */
public class q {
    private com.facebook.common.memory.j mZB;
    private c mZj;
    private com.facebook.common.memory.g mZm;
    private i mZo;
    private final p ndB;
    private k ndC;
    private com.facebook.common.memory.a ndD;

    public q(p pVar) {
        this.ndB = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dJf() {
        if (this.mZj == null) {
            this.mZj = new c(this.ndB.dGR(), this.ndB.dIW(), this.ndB.dIX());
        }
        return this.mZj;
    }

    public i dJg() {
        if (this.mZo == null) {
            this.mZo = new i(this.ndB.dGR(), this.ndB.dJa());
        }
        return this.mZo;
    }

    public int dJh() {
        return this.ndB.dJa().ndK;
    }

    public k dJi() {
        if (this.ndC == null) {
            this.ndC = new k(this.ndB.dGR(), this.ndB.dIY(), this.ndB.dIZ());
        }
        return this.ndC;
    }

    public com.facebook.common.memory.g dJj() {
        if (this.mZm == null) {
            this.mZm = new m(dJi(), dJk());
        }
        return this.mZm;
    }

    public com.facebook.common.memory.j dJk() {
        if (this.mZB == null) {
            this.mZB = new com.facebook.common.memory.j(dJl());
        }
        return this.mZB;
    }

    public com.facebook.common.memory.a dJl() {
        if (this.ndD == null) {
            this.ndD = new j(this.ndB.dGR(), this.ndB.dJb(), this.ndB.dJc());
        }
        return this.ndD;
    }
}
