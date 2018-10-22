package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c ice;
    private com.facebook.common.memory.g ich;
    private i icj;
    private com.facebook.common.memory.j icx;
    private final p igs;
    private k igt;
    private com.facebook.common.memory.a igu;

    public q(p pVar) {
        this.igs = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c bXh() {
        if (this.ice == null) {
            this.ice = new c(this.igs.bVk(), this.igs.bWY(), this.igs.bWZ());
        }
        return this.ice;
    }

    public i bXi() {
        if (this.icj == null) {
            this.icj = new i(this.igs.bVk(), this.igs.bXc());
        }
        return this.icj;
    }

    public int bXj() {
        return this.igs.bXc().igA;
    }

    public k bXk() {
        if (this.igt == null) {
            this.igt = new k(this.igs.bVk(), this.igs.bXa(), this.igs.bXb());
        }
        return this.igt;
    }

    public com.facebook.common.memory.g bXl() {
        if (this.ich == null) {
            this.ich = new m(bXk(), bXm());
        }
        return this.ich;
    }

    public com.facebook.common.memory.j bXm() {
        if (this.icx == null) {
            this.icx = new com.facebook.common.memory.j(bXn());
        }
        return this.icx;
    }

    public com.facebook.common.memory.a bXn() {
        if (this.igu == null) {
            this.igu = new j(this.igs.bVk(), this.igs.bXd(), this.igs.bXe());
        }
        return this.igu;
    }
}
