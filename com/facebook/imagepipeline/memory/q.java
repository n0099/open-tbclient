package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes9.dex */
public class q {
    private c lLQ;
    private com.facebook.common.memory.g lLT;
    private i lLV;
    private com.facebook.common.memory.j lMi;
    private final p lQh;
    private k lQi;
    private com.facebook.common.memory.a lQj;

    public q(p pVar) {
        this.lQh = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c doO() {
        if (this.lLQ == null) {
            this.lLQ = new c(this.lQh.dmB(), this.lQh.doF(), this.lQh.doG());
        }
        return this.lLQ;
    }

    public i doP() {
        if (this.lLV == null) {
            this.lLV = new i(this.lQh.dmB(), this.lQh.doJ());
        }
        return this.lLV;
    }

    public int doQ() {
        return this.lQh.doJ().lQq;
    }

    public k doR() {
        if (this.lQi == null) {
            this.lQi = new k(this.lQh.dmB(), this.lQh.doH(), this.lQh.doI());
        }
        return this.lQi;
    }

    public com.facebook.common.memory.g doS() {
        if (this.lLT == null) {
            this.lLT = new m(doR(), doT());
        }
        return this.lLT;
    }

    public com.facebook.common.memory.j doT() {
        if (this.lMi == null) {
            this.lMi = new com.facebook.common.memory.j(doU());
        }
        return this.lMi;
    }

    public com.facebook.common.memory.a doU() {
        if (this.lQj == null) {
            this.lQj = new j(this.lQh.dmB(), this.lQh.doK(), this.lQh.doL());
        }
        return this.lQj;
    }
}
