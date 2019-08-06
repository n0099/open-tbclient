package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c khT;
    private final r kjR;
    private final s kjS;
    private final r kjT;
    private final r kjU;
    private final s kjV;
    private final r kjW;
    private final s kjX;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.kjR == null) {
            rVar = e.cKw();
        } else {
            rVar = aVar.kjR;
        }
        this.kjR = rVar;
        if (aVar.kjS == null) {
            sVar = n.cKB();
        } else {
            sVar = aVar.kjS;
        }
        this.kjS = sVar;
        if (aVar.kjT == null) {
            rVar2 = g.cKw();
        } else {
            rVar2 = aVar.kjT;
        }
        this.kjT = rVar2;
        if (aVar.khT == null) {
            cVar = com.facebook.common.memory.d.cFb();
        } else {
            cVar = aVar.khT;
        }
        this.khT = cVar;
        if (aVar.kjU == null) {
            rVar3 = h.cKw();
        } else {
            rVar3 = aVar.kjU;
        }
        this.kjU = rVar3;
        if (aVar.kjV == null) {
            sVar2 = n.cKB();
        } else {
            sVar2 = aVar.kjV;
        }
        this.kjV = sVar2;
        if (aVar.kjW == null) {
            rVar4 = f.cKw();
        } else {
            rVar4 = aVar.kjW;
        }
        this.kjW = rVar4;
        if (aVar.kjX == null) {
            sVar3 = n.cKB();
        } else {
            sVar3 = aVar.kjX;
        }
        this.kjX = sVar3;
    }

    public r cKE() {
        return this.kjR;
    }

    public s cKF() {
        return this.kjS;
    }

    public com.facebook.common.memory.c cIL() {
        return this.khT;
    }

    public r cKG() {
        return this.kjU;
    }

    public s cKH() {
        return this.kjV;
    }

    public r cKI() {
        return this.kjT;
    }

    public r cKJ() {
        return this.kjW;
    }

    public s cKK() {
        return this.kjX;
    }

    public static a cKL() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c khT;
        private r kjR;
        private s kjS;
        private r kjT;
        private r kjU;
        private s kjV;
        private r kjW;
        private s kjX;

        private a() {
        }

        public p cKM() {
            return new p(this);
        }
    }
}
