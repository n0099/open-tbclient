package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
public class q {
    private c pjL;
    private com.facebook.common.memory.g pjO;
    private i pjQ;
    private com.facebook.common.memory.j pkc;
    private final p poa;
    private k pob;
    private com.facebook.common.memory.a poc;

    public q(p pVar) {
        this.poa = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c ewl() {
        if (this.pjL == null) {
            this.pjL = new c(this.poa.eua(), this.poa.ewc(), this.poa.ewd());
        }
        return this.pjL;
    }

    public i ewm() {
        if (this.pjQ == null) {
            this.pjQ = new i(this.poa.eua(), this.poa.ewg());
        }
        return this.pjQ;
    }

    public int ewn() {
        return this.poa.ewg().pok;
    }

    public k ewo() {
        if (this.pob == null) {
            this.pob = new k(this.poa.eua(), this.poa.ewe(), this.poa.ewf());
        }
        return this.pob;
    }

    public com.facebook.common.memory.g ewp() {
        if (this.pjO == null) {
            this.pjO = new m(ewo(), ewq());
        }
        return this.pjO;
    }

    public com.facebook.common.memory.j ewq() {
        if (this.pkc == null) {
            this.pkc = new com.facebook.common.memory.j(ewr());
        }
        return this.pkc;
    }

    public com.facebook.common.memory.a ewr() {
        if (this.poc == null) {
            this.poc = new j(this.poa.eua(), this.poa.ewh(), this.poa.ewi());
        }
        return this.poc;
    }
}
