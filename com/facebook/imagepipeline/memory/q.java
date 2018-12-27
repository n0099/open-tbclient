package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private com.facebook.common.memory.j ioG;
    private c ion;
    private com.facebook.common.memory.g ioq;
    private i ios;
    private com.facebook.common.memory.a isA;
    private final p isy;
    private k isz;

    public q(p pVar) {
        this.isy = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c bZy() {
        if (this.ion == null) {
            this.ion = new c(this.isy.bXB(), this.isy.bZp(), this.isy.bZq());
        }
        return this.ion;
    }

    public i bZz() {
        if (this.ios == null) {
            this.ios = new i(this.isy.bXB(), this.isy.bZt());
        }
        return this.ios;
    }

    public int bZA() {
        return this.isy.bZt().isG;
    }

    public k bZB() {
        if (this.isz == null) {
            this.isz = new k(this.isy.bXB(), this.isy.bZr(), this.isy.bZs());
        }
        return this.isz;
    }

    public com.facebook.common.memory.g bZC() {
        if (this.ioq == null) {
            this.ioq = new m(bZB(), bZD());
        }
        return this.ioq;
    }

    public com.facebook.common.memory.j bZD() {
        if (this.ioG == null) {
            this.ioG = new com.facebook.common.memory.j(bZE());
        }
        return this.ioG;
    }

    public com.facebook.common.memory.a bZE() {
        if (this.isA == null) {
            this.isA = new j(this.isy.bXB(), this.isy.bZu(), this.isy.bZv());
        }
        return this.isA;
    }
}
