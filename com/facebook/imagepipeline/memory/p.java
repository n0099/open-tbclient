package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c kgN;
    private final r kiL;
    private final s kiM;
    private final r kiN;
    private final r kiO;
    private final s kiP;
    private final r kiQ;
    private final s kiR;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.kiL == null) {
            rVar = e.cKb();
        } else {
            rVar = aVar.kiL;
        }
        this.kiL = rVar;
        if (aVar.kiM == null) {
            sVar = n.cKg();
        } else {
            sVar = aVar.kiM;
        }
        this.kiM = sVar;
        if (aVar.kiN == null) {
            rVar2 = g.cKb();
        } else {
            rVar2 = aVar.kiN;
        }
        this.kiN = rVar2;
        if (aVar.kgN == null) {
            cVar = com.facebook.common.memory.d.cEG();
        } else {
            cVar = aVar.kgN;
        }
        this.kgN = cVar;
        if (aVar.kiO == null) {
            rVar3 = h.cKb();
        } else {
            rVar3 = aVar.kiO;
        }
        this.kiO = rVar3;
        if (aVar.kiP == null) {
            sVar2 = n.cKg();
        } else {
            sVar2 = aVar.kiP;
        }
        this.kiP = sVar2;
        if (aVar.kiQ == null) {
            rVar4 = f.cKb();
        } else {
            rVar4 = aVar.kiQ;
        }
        this.kiQ = rVar4;
        if (aVar.kiR == null) {
            sVar3 = n.cKg();
        } else {
            sVar3 = aVar.kiR;
        }
        this.kiR = sVar3;
    }

    public r cKj() {
        return this.kiL;
    }

    public s cKk() {
        return this.kiM;
    }

    public com.facebook.common.memory.c cIq() {
        return this.kgN;
    }

    public r cKl() {
        return this.kiO;
    }

    public s cKm() {
        return this.kiP;
    }

    public r cKn() {
        return this.kiN;
    }

    public r cKo() {
        return this.kiQ;
    }

    public s cKp() {
        return this.kiR;
    }

    public static a cKq() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c kgN;
        private r kiL;
        private s kiM;
        private r kiN;
        private r kiO;
        private s kiP;
        private r kiQ;
        private s kiR;

        private a() {
        }

        public p cKr() {
            return new p(this);
        }
    }
}
