package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c inl;
    private final r iph;
    private final s ipi;
    private final r ipj;
    private final r ipk;
    private final s ipl;
    private final r ipm;
    private final s ipn;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.iph == null) {
            rVar = e.bYq();
        } else {
            rVar = aVar.iph;
        }
        this.iph = rVar;
        if (aVar.ipi == null) {
            sVar = n.bYv();
        } else {
            sVar = aVar.ipi;
        }
        this.ipi = sVar;
        if (aVar.ipj == null) {
            rVar2 = g.bYq();
        } else {
            rVar2 = aVar.ipj;
        }
        this.ipj = rVar2;
        if (aVar.inl == null) {
            cVar = com.facebook.common.memory.d.bTe();
        } else {
            cVar = aVar.inl;
        }
        this.inl = cVar;
        if (aVar.ipk == null) {
            rVar3 = h.bYq();
        } else {
            rVar3 = aVar.ipk;
        }
        this.ipk = rVar3;
        if (aVar.ipl == null) {
            sVar2 = n.bYv();
        } else {
            sVar2 = aVar.ipl;
        }
        this.ipl = sVar2;
        if (aVar.ipm == null) {
            rVar4 = f.bYq();
        } else {
            rVar4 = aVar.ipm;
        }
        this.ipm = rVar4;
        if (aVar.ipn == null) {
            sVar3 = n.bYv();
        } else {
            sVar3 = aVar.ipn;
        }
        this.ipn = sVar3;
    }

    public r bYy() {
        return this.iph;
    }

    public s bYz() {
        return this.ipi;
    }

    public com.facebook.common.memory.c bWK() {
        return this.inl;
    }

    public r bYA() {
        return this.ipk;
    }

    public s bYB() {
        return this.ipl;
    }

    public r bYC() {
        return this.ipj;
    }

    public r bYD() {
        return this.ipm;
    }

    public s bYE() {
        return this.ipn;
    }

    public static a bYF() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c inl;
        private r iph;
        private s ipi;
        private r ipj;
        private r ipk;
        private s ipl;
        private r ipm;
        private s ipn;

        private a() {
        }

        public p bYG() {
            return new p(this);
        }
    }
}
