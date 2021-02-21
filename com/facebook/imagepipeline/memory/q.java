package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class q {
    private c pHh;
    private com.facebook.common.memory.g pHk;
    private i pHm;
    private com.facebook.common.memory.j pHy;
    private final p pLu;
    private k pLv;
    private com.facebook.common.memory.a pLw;

    public q(p pVar) {
        this.pLu = (p) com.facebook.common.internal.g.checkNotNull(pVar);
    }

    public c ezf() {
        if (this.pHh == null) {
            this.pHh = new c(this.pLu.ewV(), this.pLu.eyW(), this.pLu.eyX());
        }
        return this.pHh;
    }

    public i ezg() {
        if (this.pHm == null) {
            this.pHm = new i(this.pLu.ewV(), this.pLu.eza());
        }
        return this.pHm;
    }

    public int ezh() {
        return this.pLu.eza().pLD;
    }

    public k ezi() {
        if (this.pLv == null) {
            this.pLv = new k(this.pLu.ewV(), this.pLu.eyY(), this.pLu.eyZ());
        }
        return this.pLv;
    }

    public com.facebook.common.memory.g ezj() {
        if (this.pHk == null) {
            this.pHk = new m(ezi(), ezk());
        }
        return this.pHk;
    }

    public com.facebook.common.memory.j ezk() {
        if (this.pHy == null) {
            this.pHy = new com.facebook.common.memory.j(ezl());
        }
        return this.pHy;
    }

    public com.facebook.common.memory.a ezl() {
        if (this.pLw == null) {
            this.pLw = new j(this.pLu.ewV(), this.pLu.ezb(), this.pLu.ezc());
        }
        return this.pLw;
    }
}
