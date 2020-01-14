package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes10.dex */
public class p {
    private final com.facebook.common.memory.c lRG;
    private final r lTR;
    private final s lTS;
    private final r lTT;
    private final r lTU;
    private final s lTV;
    private final r lTW;
    private final s lTX;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.lTR == null) {
            rVar = e.dpI();
        } else {
            rVar = aVar.lTR;
        }
        this.lTR = rVar;
        if (aVar.lTS == null) {
            sVar = n.dpN();
        } else {
            sVar = aVar.lTS;
        }
        this.lTS = sVar;
        if (aVar.lTT == null) {
            rVar2 = g.dpI();
        } else {
            rVar2 = aVar.lTT;
        }
        this.lTT = rVar2;
        if (aVar.lRG == null) {
            cVar = com.facebook.common.memory.d.djx();
        } else {
            cVar = aVar.lRG;
        }
        this.lRG = cVar;
        if (aVar.lTU == null) {
            rVar3 = h.dpI();
        } else {
            rVar3 = aVar.lTU;
        }
        this.lTU = rVar3;
        if (aVar.lTV == null) {
            sVar2 = n.dpN();
        } else {
            sVar2 = aVar.lTV;
        }
        this.lTV = sVar2;
        if (aVar.lTW == null) {
            rVar4 = f.dpI();
        } else {
            rVar4 = aVar.lTW;
        }
        this.lTW = rVar4;
        if (aVar.lTX == null) {
            sVar3 = n.dpN();
        } else {
            sVar3 = aVar.lTX;
        }
        this.lTX = sVar3;
    }

    public r dpQ() {
        return this.lTR;
    }

    public s dpR() {
        return this.lTS;
    }

    public com.facebook.common.memory.c dnK() {
        return this.lRG;
    }

    public r dpS() {
        return this.lTU;
    }

    public s dpT() {
        return this.lTV;
    }

    public r dpU() {
        return this.lTT;
    }

    public r dpV() {
        return this.lTW;
    }

    public s dpW() {
        return this.lTX;
    }

    public static a dpX() {
        return new a();
    }

    /* loaded from: classes10.dex */
    public static class a {
        private com.facebook.common.memory.c lRG;
        private r lTR;
        private s lTS;
        private r lTT;
        private r lTU;
        private s lTV;
        private r lTW;
        private s lTX;

        private a() {
        }

        public p dpY() {
            return new p(this);
        }
    }
}
