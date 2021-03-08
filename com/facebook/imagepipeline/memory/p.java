package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class p {
    private final com.facebook.common.memory.c pLj;
    private final r pNs;
    private final s pNt;
    private final r pNu;
    private final r pNv;
    private final s pNw;
    private final r pNx;
    private final s pNy;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.pNs == null) {
            rVar = e.eyX();
        } else {
            rVar = aVar.pNs;
        }
        this.pNs = rVar;
        if (aVar.pNt == null) {
            sVar = n.ezc();
        } else {
            sVar = aVar.pNt;
        }
        this.pNt = sVar;
        if (aVar.pNu == null) {
            rVar2 = g.eyX();
        } else {
            rVar2 = aVar.pNu;
        }
        this.pNu = rVar2;
        if (aVar.pLj == null) {
            cVar = com.facebook.common.memory.d.esU();
        } else {
            cVar = aVar.pLj;
        }
        this.pLj = cVar;
        if (aVar.pNv == null) {
            rVar3 = h.eyX();
        } else {
            rVar3 = aVar.pNv;
        }
        this.pNv = rVar3;
        if (aVar.pNw == null) {
            sVar2 = n.ezc();
        } else {
            sVar2 = aVar.pNw;
        }
        this.pNw = sVar2;
        if (aVar.pNx == null) {
            rVar4 = f.eyX();
        } else {
            rVar4 = aVar.pNx;
        }
        this.pNx = rVar4;
        if (aVar.pNy == null) {
            sVar3 = n.ezc();
        } else {
            sVar3 = aVar.pNy;
        }
        this.pNy = sVar3;
    }

    public r ezf() {
        return this.pNs;
    }

    public s ezg() {
        return this.pNt;
    }

    public com.facebook.common.memory.c exe() {
        return this.pLj;
    }

    public r ezh() {
        return this.pNv;
    }

    public s ezi() {
        return this.pNw;
    }

    public r ezj() {
        return this.pNu;
    }

    public r ezk() {
        return this.pNx;
    }

    public s ezl() {
        return this.pNy;
    }

    public static a ezm() {
        return new a();
    }

    /* loaded from: classes5.dex */
    public static class a {
        private com.facebook.common.memory.c pLj;
        private r pNs;
        private s pNt;
        private r pNu;
        private r pNv;
        private s pNw;
        private r pNx;
        private s pNy;

        private a() {
        }

        public p ezn() {
            return new p(this);
        }
    }
}
