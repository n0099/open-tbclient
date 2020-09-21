package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes25.dex */
public class q {
    private com.facebook.common.memory.j nDG;
    private c nDo;
    private com.facebook.common.memory.g nDr;
    private i nDt;
    private final p nHG;
    private k nHH;
    private com.facebook.common.memory.a nHI;

    public q(p pVar) {
        this.nHG = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dZl() {
        if (this.nDo == null) {
            this.nDo = new c(this.nHG.dWX(), this.nHG.dZc(), this.nHG.dZd());
        }
        return this.nDo;
    }

    public i dZm() {
        if (this.nDt == null) {
            this.nDt = new i(this.nHG.dWX(), this.nHG.dZg());
        }
        return this.nDt;
    }

    public int dZn() {
        return this.nHG.dZg().nHP;
    }

    public k dZo() {
        if (this.nHH == null) {
            this.nHH = new k(this.nHG.dWX(), this.nHG.dZe(), this.nHG.dZf());
        }
        return this.nHH;
    }

    public com.facebook.common.memory.g dZp() {
        if (this.nDr == null) {
            this.nDr = new m(dZo(), dZq());
        }
        return this.nDr;
    }

    public com.facebook.common.memory.j dZq() {
        if (this.nDG == null) {
            this.nDG = new com.facebook.common.memory.j(dZr());
        }
        return this.nDG;
    }

    public com.facebook.common.memory.a dZr() {
        if (this.nHI == null) {
            this.nHI = new j(this.nHG.dWX(), this.nHG.dZh(), this.nHG.dZi());
        }
        return this.nHI;
    }
}
