package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes3.dex */
public class p {
    private final r pAF;
    private final s pAG;
    private final r pAH;
    private final r pAI;
    private final s pAJ;
    private final r pAK;
    private final s pAL;
    private final com.facebook.common.memory.c pyw;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.pAF == null) {
            rVar = e.ewo();
        } else {
            rVar = aVar.pAF;
        }
        this.pAF = rVar;
        if (aVar.pAG == null) {
            sVar = n.ewt();
        } else {
            sVar = aVar.pAG;
        }
        this.pAG = sVar;
        if (aVar.pAH == null) {
            rVar2 = g.ewo();
        } else {
            rVar2 = aVar.pAH;
        }
        this.pAH = rVar2;
        if (aVar.pyw == null) {
            cVar = com.facebook.common.memory.d.eqk();
        } else {
            cVar = aVar.pyw;
        }
        this.pyw = cVar;
        if (aVar.pAI == null) {
            rVar3 = h.ewo();
        } else {
            rVar3 = aVar.pAI;
        }
        this.pAI = rVar3;
        if (aVar.pAJ == null) {
            sVar2 = n.ewt();
        } else {
            sVar2 = aVar.pAJ;
        }
        this.pAJ = sVar2;
        if (aVar.pAK == null) {
            rVar4 = f.ewo();
        } else {
            rVar4 = aVar.pAK;
        }
        this.pAK = rVar4;
        if (aVar.pAL == null) {
            sVar3 = n.ewt();
        } else {
            sVar3 = aVar.pAL;
        }
        this.pAL = sVar3;
    }

    public r eww() {
        return this.pAF;
    }

    public s ewx() {
        return this.pAG;
    }

    public com.facebook.common.memory.c euu() {
        return this.pyw;
    }

    public r ewy() {
        return this.pAI;
    }

    public s ewz() {
        return this.pAJ;
    }

    public r ewA() {
        return this.pAH;
    }

    public r ewB() {
        return this.pAK;
    }

    public s ewC() {
        return this.pAL;
    }

    public static a ewD() {
        return new a();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private r pAF;
        private s pAG;
        private r pAH;
        private r pAI;
        private s pAJ;
        private r pAK;
        private s pAL;
        private com.facebook.common.memory.c pyw;

        private a() {
        }

        public p ewE() {
            return new p(this);
        }
    }
}
