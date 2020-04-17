package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class q {
    private c lZP;
    private com.facebook.common.memory.g lZS;
    private i lZU;
    private com.facebook.common.memory.j maj;
    private final p mej;
    private k mek;
    private com.facebook.common.memory.a mel;

    public q(p pVar) {
        this.mej = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dtJ() {
        if (this.lZP == null) {
            this.lZP = new c(this.mej.dru(), this.mej.dtA(), this.mej.dtB());
        }
        return this.lZP;
    }

    public i dtK() {
        if (this.lZU == null) {
            this.lZU = new i(this.mej.dru(), this.mej.dtE());
        }
        return this.lZU;
    }

    public int dtL() {
        return this.mej.dtE().mes;
    }

    public k dtM() {
        if (this.mek == null) {
            this.mek = new k(this.mej.dru(), this.mej.dtC(), this.mej.dtD());
        }
        return this.mek;
    }

    public com.facebook.common.memory.g dtN() {
        if (this.lZS == null) {
            this.lZS = new m(dtM(), dtO());
        }
        return this.lZS;
    }

    public com.facebook.common.memory.j dtO() {
        if (this.maj == null) {
            this.maj = new com.facebook.common.memory.j(dtP());
        }
        return this.maj;
    }

    public com.facebook.common.memory.a dtP() {
        if (this.mel == null) {
            this.mel = new j(this.mej.dru(), this.mej.dtF(), this.mej.dtG());
        }
        return this.mel;
    }
}
