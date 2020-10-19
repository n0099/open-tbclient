package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes18.dex */
public class p {
    private final com.facebook.common.memory.c nUH;
    private final r nWQ;
    private final s nWR;
    private final r nWS;
    private final r nWT;
    private final s nWU;
    private final r nWV;
    private final s nWW;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.nWQ == null) {
            rVar = e.ecF();
        } else {
            rVar = aVar.nWQ;
        }
        this.nWQ = rVar;
        if (aVar.nWR == null) {
            sVar = n.ecK();
        } else {
            sVar = aVar.nWR;
        }
        this.nWR = sVar;
        if (aVar.nWS == null) {
            rVar2 = g.ecF();
        } else {
            rVar2 = aVar.nWS;
        }
        this.nWS = rVar2;
        if (aVar.nUH == null) {
            cVar = com.facebook.common.memory.d.dWu();
        } else {
            cVar = aVar.nUH;
        }
        this.nUH = cVar;
        if (aVar.nWT == null) {
            rVar3 = h.ecF();
        } else {
            rVar3 = aVar.nWT;
        }
        this.nWT = rVar3;
        if (aVar.nWU == null) {
            sVar2 = n.ecK();
        } else {
            sVar2 = aVar.nWU;
        }
        this.nWU = sVar2;
        if (aVar.nWV == null) {
            rVar4 = f.ecF();
        } else {
            rVar4 = aVar.nWV;
        }
        this.nWV = rVar4;
        if (aVar.nWW == null) {
            sVar3 = n.ecK();
        } else {
            sVar3 = aVar.nWW;
        }
        this.nWW = sVar3;
    }

    public r ecN() {
        return this.nWQ;
    }

    public s ecO() {
        return this.nWR;
    }

    public com.facebook.common.memory.c eaI() {
        return this.nUH;
    }

    public r ecP() {
        return this.nWT;
    }

    public s ecQ() {
        return this.nWU;
    }

    public r ecR() {
        return this.nWS;
    }

    public r ecS() {
        return this.nWV;
    }

    public s ecT() {
        return this.nWW;
    }

    public static a ecU() {
        return new a();
    }

    /* loaded from: classes18.dex */
    public static class a {
        private com.facebook.common.memory.c nUH;
        private r nWQ;
        private s nWR;
        private r nWS;
        private r nWT;
        private s nWU;
        private r nWV;
        private s nWW;

        private a() {
        }

        public p ecV() {
            return new p(this);
        }
    }
}
