package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class p {
    private final com.facebook.common.memory.c pIE;
    private final r pKN;
    private final s pKO;
    private final r pKP;
    private final r pKQ;
    private final s pKR;
    private final r pKS;
    private final s pKT;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.pKN == null) {
            rVar = e.eyG();
        } else {
            rVar = aVar.pKN;
        }
        this.pKN = rVar;
        if (aVar.pKO == null) {
            sVar = n.eyL();
        } else {
            sVar = aVar.pKO;
        }
        this.pKO = sVar;
        if (aVar.pKP == null) {
            rVar2 = g.eyG();
        } else {
            rVar2 = aVar.pKP;
        }
        this.pKP = rVar2;
        if (aVar.pIE == null) {
            cVar = com.facebook.common.memory.d.esD();
        } else {
            cVar = aVar.pIE;
        }
        this.pIE = cVar;
        if (aVar.pKQ == null) {
            rVar3 = h.eyG();
        } else {
            rVar3 = aVar.pKQ;
        }
        this.pKQ = rVar3;
        if (aVar.pKR == null) {
            sVar2 = n.eyL();
        } else {
            sVar2 = aVar.pKR;
        }
        this.pKR = sVar2;
        if (aVar.pKS == null) {
            rVar4 = f.eyG();
        } else {
            rVar4 = aVar.pKS;
        }
        this.pKS = rVar4;
        if (aVar.pKT == null) {
            sVar3 = n.eyL();
        } else {
            sVar3 = aVar.pKT;
        }
        this.pKT = sVar3;
    }

    public r eyO() {
        return this.pKN;
    }

    public s eyP() {
        return this.pKO;
    }

    public com.facebook.common.memory.c ewN() {
        return this.pIE;
    }

    public r eyQ() {
        return this.pKQ;
    }

    public s eyR() {
        return this.pKR;
    }

    public r eyS() {
        return this.pKP;
    }

    public r eyT() {
        return this.pKS;
    }

    public s eyU() {
        return this.pKT;
    }

    public static a eyV() {
        return new a();
    }

    /* loaded from: classes5.dex */
    public static class a {
        private com.facebook.common.memory.c pIE;
        private r pKN;
        private s pKO;
        private r pKP;
        private r pKQ;
        private s pKR;
        private r pKS;
        private s pKT;

        private a() {
        }

        public p eyW() {
            return new p(this);
        }
    }
}
