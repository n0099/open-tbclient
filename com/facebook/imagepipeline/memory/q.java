package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes10.dex */
public class q {
    private c lPB;
    private com.facebook.common.memory.g lPE;
    private i lPG;
    private com.facebook.common.memory.j lPU;
    private final p lTT;
    private k lTU;
    private com.facebook.common.memory.a lTV;

    public q(p pVar) {
        this.lTT = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c dpX() {
        if (this.lPB == null) {
            this.lPB = new c(this.lTT.dnI(), this.lTT.dpO(), this.lTT.dpP());
        }
        return this.lPB;
    }

    public i dpY() {
        if (this.lPG == null) {
            this.lPG = new i(this.lTT.dnI(), this.lTT.dpS());
        }
        return this.lPG;
    }

    public int dpZ() {
        return this.lTT.dpS().lUc;
    }

    public k dqa() {
        if (this.lTU == null) {
            this.lTU = new k(this.lTT.dnI(), this.lTT.dpQ(), this.lTT.dpR());
        }
        return this.lTU;
    }

    public com.facebook.common.memory.g dqb() {
        if (this.lPE == null) {
            this.lPE = new m(dqa(), dqc());
        }
        return this.lPE;
    }

    public com.facebook.common.memory.j dqc() {
        if (this.lPU == null) {
            this.lPU = new com.facebook.common.memory.j(dqd());
        }
        return this.lPU;
    }

    public com.facebook.common.memory.a dqd() {
        if (this.lTV == null) {
            this.lTV = new j(this.lTT.dnI(), this.lTT.dpT(), this.lTT.dpU());
        }
        return this.lTV;
    }
}
