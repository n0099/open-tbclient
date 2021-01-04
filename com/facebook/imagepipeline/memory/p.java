package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class p {
    private final com.facebook.common.memory.c pBp;
    private final r pDA;
    private final r pDB;
    private final s pDC;
    private final r pDD;
    private final s pDE;
    private final r pDy;
    private final s pDz;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.pDy == null) {
            rVar = e.ezC();
        } else {
            rVar = aVar.pDy;
        }
        this.pDy = rVar;
        if (aVar.pDz == null) {
            sVar = n.ezH();
        } else {
            sVar = aVar.pDz;
        }
        this.pDz = sVar;
        if (aVar.pDA == null) {
            rVar2 = g.ezC();
        } else {
            rVar2 = aVar.pDA;
        }
        this.pDA = rVar2;
        if (aVar.pBp == null) {
            cVar = com.facebook.common.memory.d.etY();
        } else {
            cVar = aVar.pBp;
        }
        this.pBp = cVar;
        if (aVar.pDB == null) {
            rVar3 = h.ezC();
        } else {
            rVar3 = aVar.pDB;
        }
        this.pDB = rVar3;
        if (aVar.pDC == null) {
            sVar2 = n.ezH();
        } else {
            sVar2 = aVar.pDC;
        }
        this.pDC = sVar2;
        if (aVar.pDD == null) {
            rVar4 = f.ezC();
        } else {
            rVar4 = aVar.pDD;
        }
        this.pDD = rVar4;
        if (aVar.pDE == null) {
            sVar3 = n.ezH();
        } else {
            sVar3 = aVar.pDE;
        }
        this.pDE = sVar3;
    }

    public r ezK() {
        return this.pDy;
    }

    public s ezL() {
        return this.pDz;
    }

    public com.facebook.common.memory.c exK() {
        return this.pBp;
    }

    public r ezM() {
        return this.pDB;
    }

    public s ezN() {
        return this.pDC;
    }

    public r ezO() {
        return this.pDA;
    }

    public r ezP() {
        return this.pDD;
    }

    public s ezQ() {
        return this.pDE;
    }

    public static a ezR() {
        return new a();
    }

    /* loaded from: classes5.dex */
    public static class a {
        private com.facebook.common.memory.c pBp;
        private r pDA;
        private r pDB;
        private s pDC;
        private r pDD;
        private s pDE;
        private r pDy;
        private s pDz;

        private a() {
        }

        public p ezS() {
            return new p(this);
        }
    }
}
