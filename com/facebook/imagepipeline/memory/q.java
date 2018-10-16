package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c icd;
    private com.facebook.common.memory.g icg;
    private i ici;
    private com.facebook.common.memory.j icw;
    private final p igr;
    private k igs;
    private com.facebook.common.memory.a igt;

    public q(p pVar) {
        this.igr = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c bXh() {
        if (this.icd == null) {
            this.icd = new c(this.igr.bVk(), this.igr.bWY(), this.igr.bWZ());
        }
        return this.icd;
    }

    public i bXi() {
        if (this.ici == null) {
            this.ici = new i(this.igr.bVk(), this.igr.bXc());
        }
        return this.ici;
    }

    public int bXj() {
        return this.igr.bXc().igz;
    }

    public k bXk() {
        if (this.igs == null) {
            this.igs = new k(this.igr.bVk(), this.igr.bXa(), this.igr.bXb());
        }
        return this.igs;
    }

    public com.facebook.common.memory.g bXl() {
        if (this.icg == null) {
            this.icg = new m(bXk(), bXm());
        }
        return this.icg;
    }

    public com.facebook.common.memory.j bXm() {
        if (this.icw == null) {
            this.icw = new com.facebook.common.memory.j(bXn());
        }
        return this.icw;
    }

    public com.facebook.common.memory.a bXn() {
        if (this.igt == null) {
            this.igt = new j(this.igr.bVk(), this.igr.bXd(), this.igr.bXe());
        }
        return this.igt;
    }
}
