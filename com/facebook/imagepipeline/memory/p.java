package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes10.dex */
public class p {
    private final com.facebook.common.memory.c lRB;
    private final r lTM;
    private final s lTN;
    private final r lTO;
    private final r lTP;
    private final s lTQ;
    private final r lTR;
    private final s lTS;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.lTM == null) {
            rVar = e.dpG();
        } else {
            rVar = aVar.lTM;
        }
        this.lTM = rVar;
        if (aVar.lTN == null) {
            sVar = n.dpL();
        } else {
            sVar = aVar.lTN;
        }
        this.lTN = sVar;
        if (aVar.lTO == null) {
            rVar2 = g.dpG();
        } else {
            rVar2 = aVar.lTO;
        }
        this.lTO = rVar2;
        if (aVar.lRB == null) {
            cVar = com.facebook.common.memory.d.djv();
        } else {
            cVar = aVar.lRB;
        }
        this.lRB = cVar;
        if (aVar.lTP == null) {
            rVar3 = h.dpG();
        } else {
            rVar3 = aVar.lTP;
        }
        this.lTP = rVar3;
        if (aVar.lTQ == null) {
            sVar2 = n.dpL();
        } else {
            sVar2 = aVar.lTQ;
        }
        this.lTQ = sVar2;
        if (aVar.lTR == null) {
            rVar4 = f.dpG();
        } else {
            rVar4 = aVar.lTR;
        }
        this.lTR = rVar4;
        if (aVar.lTS == null) {
            sVar3 = n.dpL();
        } else {
            sVar3 = aVar.lTS;
        }
        this.lTS = sVar3;
    }

    public r dpO() {
        return this.lTM;
    }

    public s dpP() {
        return this.lTN;
    }

    public com.facebook.common.memory.c dnI() {
        return this.lRB;
    }

    public r dpQ() {
        return this.lTP;
    }

    public s dpR() {
        return this.lTQ;
    }

    public r dpS() {
        return this.lTO;
    }

    public r dpT() {
        return this.lTR;
    }

    public s dpU() {
        return this.lTS;
    }

    public static a dpV() {
        return new a();
    }

    /* loaded from: classes10.dex */
    public static class a {
        private com.facebook.common.memory.c lRB;
        private r lTM;
        private s lTN;
        private r lTO;
        private r lTP;
        private s lTQ;
        private r lTR;
        private s lTS;

        private a() {
        }

        public p dpW() {
            return new p(this);
        }
    }
}
