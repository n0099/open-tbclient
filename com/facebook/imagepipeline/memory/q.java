package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
public class q {
    private c pjN;
    private com.facebook.common.memory.g pjQ;
    private i pjS;
    private com.facebook.common.memory.j pke;
    private final p poc;
    private k pod;
    private com.facebook.common.memory.a poe;

    public q(p pVar) {
        this.poc = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c ewm() {
        if (this.pjN == null) {
            this.pjN = new c(this.poc.eub(), this.poc.ewd(), this.poc.ewe());
        }
        return this.pjN;
    }

    public i ewn() {
        if (this.pjS == null) {
            this.pjS = new i(this.poc.eub(), this.poc.ewh());
        }
        return this.pjS;
    }

    public int ewo() {
        return this.poc.ewh().pom;
    }

    public k ewp() {
        if (this.pod == null) {
            this.pod = new k(this.poc.eub(), this.poc.ewf(), this.poc.ewg());
        }
        return this.pod;
    }

    public com.facebook.common.memory.g ewq() {
        if (this.pjQ == null) {
            this.pjQ = new m(ewp(), ewr());
        }
        return this.pjQ;
    }

    public com.facebook.common.memory.j ewr() {
        if (this.pke == null) {
            this.pke = new com.facebook.common.memory.j(ews());
        }
        return this.pke;
    }

    public com.facebook.common.memory.a ews() {
        if (this.poe == null) {
            this.poe = new j(this.poc.eub(), this.poc.ewi(), this.poc.ewj());
        }
        return this.poe;
    }
}
