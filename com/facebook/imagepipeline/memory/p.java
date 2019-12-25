package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes9.dex */
public class p {
    private final com.facebook.common.memory.c lNP;
    private final r lQa;
    private final s lQb;
    private final r lQc;
    private final r lQd;
    private final s lQe;
    private final r lQf;
    private final s lQg;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.lQa == null) {
            rVar = e.dox();
        } else {
            rVar = aVar.lQa;
        }
        this.lQa = rVar;
        if (aVar.lQb == null) {
            sVar = n.doC();
        } else {
            sVar = aVar.lQb;
        }
        this.lQb = sVar;
        if (aVar.lQc == null) {
            rVar2 = g.dox();
        } else {
            rVar2 = aVar.lQc;
        }
        this.lQc = rVar2;
        if (aVar.lNP == null) {
            cVar = com.facebook.common.memory.d.diu();
        } else {
            cVar = aVar.lNP;
        }
        this.lNP = cVar;
        if (aVar.lQd == null) {
            rVar3 = h.dox();
        } else {
            rVar3 = aVar.lQd;
        }
        this.lQd = rVar3;
        if (aVar.lQe == null) {
            sVar2 = n.doC();
        } else {
            sVar2 = aVar.lQe;
        }
        this.lQe = sVar2;
        if (aVar.lQf == null) {
            rVar4 = f.dox();
        } else {
            rVar4 = aVar.lQf;
        }
        this.lQf = rVar4;
        if (aVar.lQg == null) {
            sVar3 = n.doC();
        } else {
            sVar3 = aVar.lQg;
        }
        this.lQg = sVar3;
    }

    public r doF() {
        return this.lQa;
    }

    public s doG() {
        return this.lQb;
    }

    public com.facebook.common.memory.c dmB() {
        return this.lNP;
    }

    public r doH() {
        return this.lQd;
    }

    public s doI() {
        return this.lQe;
    }

    public r doJ() {
        return this.lQc;
    }

    public r doK() {
        return this.lQf;
    }

    public s doL() {
        return this.lQg;
    }

    public static a doM() {
        return new a();
    }

    /* loaded from: classes9.dex */
    public static class a {
        private com.facebook.common.memory.c lNP;
        private r lQa;
        private s lQb;
        private r lQc;
        private r lQd;
        private s lQe;
        private r lQf;
        private s lQg;

        private a() {
        }

        public p doN() {
            return new p(this);
        }
    }
}
