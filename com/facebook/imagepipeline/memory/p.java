package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes3.dex */
public class p {
    private final r pAE;
    private final s pAF;
    private final r pAG;
    private final r pAH;
    private final s pAI;
    private final r pAJ;
    private final s pAK;
    private final com.facebook.common.memory.c pyv;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.pAE == null) {
            rVar = e.ewo();
        } else {
            rVar = aVar.pAE;
        }
        this.pAE = rVar;
        if (aVar.pAF == null) {
            sVar = n.ewt();
        } else {
            sVar = aVar.pAF;
        }
        this.pAF = sVar;
        if (aVar.pAG == null) {
            rVar2 = g.ewo();
        } else {
            rVar2 = aVar.pAG;
        }
        this.pAG = rVar2;
        if (aVar.pyv == null) {
            cVar = com.facebook.common.memory.d.eqk();
        } else {
            cVar = aVar.pyv;
        }
        this.pyv = cVar;
        if (aVar.pAH == null) {
            rVar3 = h.ewo();
        } else {
            rVar3 = aVar.pAH;
        }
        this.pAH = rVar3;
        if (aVar.pAI == null) {
            sVar2 = n.ewt();
        } else {
            sVar2 = aVar.pAI;
        }
        this.pAI = sVar2;
        if (aVar.pAJ == null) {
            rVar4 = f.ewo();
        } else {
            rVar4 = aVar.pAJ;
        }
        this.pAJ = rVar4;
        if (aVar.pAK == null) {
            sVar3 = n.ewt();
        } else {
            sVar3 = aVar.pAK;
        }
        this.pAK = sVar3;
    }

    public r eww() {
        return this.pAE;
    }

    public s ewx() {
        return this.pAF;
    }

    public com.facebook.common.memory.c euu() {
        return this.pyv;
    }

    public r ewy() {
        return this.pAH;
    }

    public s ewz() {
        return this.pAI;
    }

    public r ewA() {
        return this.pAG;
    }

    public r ewB() {
        return this.pAJ;
    }

    public s ewC() {
        return this.pAK;
    }

    public static a ewD() {
        return new a();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private r pAE;
        private s pAF;
        private r pAG;
        private r pAH;
        private s pAI;
        private r pAJ;
        private s pAK;
        private com.facebook.common.memory.c pyv;

        private a() {
        }

        public p ewE() {
            return new p(this);
        }
    }
}
