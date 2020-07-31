package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes4.dex */
public class q {
    private c mZh;
    private com.facebook.common.memory.g mZk;
    private i mZm;
    private com.facebook.common.memory.j mZz;
    private k ndA;
    private com.facebook.common.memory.a ndB;
    private final p ndz;

    public q(p pVar) {
        this.ndz = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dJe() {
        if (this.mZh == null) {
            this.mZh = new c(this.ndz.dGQ(), this.ndz.dIV(), this.ndz.dIW());
        }
        return this.mZh;
    }

    public i dJf() {
        if (this.mZm == null) {
            this.mZm = new i(this.ndz.dGQ(), this.ndz.dIZ());
        }
        return this.mZm;
    }

    public int dJg() {
        return this.ndz.dIZ().ndI;
    }

    public k dJh() {
        if (this.ndA == null) {
            this.ndA = new k(this.ndz.dGQ(), this.ndz.dIX(), this.ndz.dIY());
        }
        return this.ndA;
    }

    public com.facebook.common.memory.g dJi() {
        if (this.mZk == null) {
            this.mZk = new m(dJh(), dJj());
        }
        return this.mZk;
    }

    public com.facebook.common.memory.j dJj() {
        if (this.mZz == null) {
            this.mZz = new com.facebook.common.memory.j(dJk());
        }
        return this.mZz;
    }

    public com.facebook.common.memory.a dJk() {
        if (this.ndB == null) {
            this.ndB = new j(this.ndz.dGQ(), this.ndz.dJa(), this.ndz.dJb());
        }
        return this.ndB;
    }
}
