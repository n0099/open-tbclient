package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class q {
    private c kfA;
    private com.facebook.common.memory.g kfD;
    private i kfF;
    private com.facebook.common.memory.j kfT;
    private final p kjQ;
    private k kjR;
    private com.facebook.common.memory.a kjS;

    public q(p pVar) {
        this.kjQ = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c cIw() {
        if (this.kfA == null) {
            this.kfA = new c(this.kjQ.cGu(), this.kjQ.cIn(), this.kjQ.cIo());
        }
        return this.kfA;
    }

    public i cIx() {
        if (this.kfF == null) {
            this.kfF = new i(this.kjQ.cGu(), this.kjQ.cIr());
        }
        return this.kfF;
    }

    public int cIy() {
        return this.kjQ.cIr().kjY;
    }

    public k cIz() {
        if (this.kjR == null) {
            this.kjR = new k(this.kjQ.cGu(), this.kjQ.cIp(), this.kjQ.cIq());
        }
        return this.kjR;
    }

    public com.facebook.common.memory.g cIA() {
        if (this.kfD == null) {
            this.kfD = new m(cIz(), cIB());
        }
        return this.kfD;
    }

    public com.facebook.common.memory.j cIB() {
        if (this.kfT == null) {
            this.kfT = new com.facebook.common.memory.j(cIC());
        }
        return this.kfT;
    }

    public com.facebook.common.memory.a cIC() {
        if (this.kjS == null) {
            this.kjS = new j(this.kjQ.cGu(), this.kjQ.cIs(), this.kjQ.cIt());
        }
        return this.kjS;
    }
}
