package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c kiD;
    private final r kkA;
    private final s kkB;
    private final r kkC;
    private final r kkD;
    private final s kkE;
    private final r kkF;
    private final s kkG;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.kkA == null) {
            rVar = e.cIh();
        } else {
            rVar = aVar.kkA;
        }
        this.kkA = rVar;
        if (aVar.kkB == null) {
            sVar = n.cIm();
        } else {
            sVar = aVar.kkB;
        }
        this.kkB = sVar;
        if (aVar.kkC == null) {
            rVar2 = g.cIh();
        } else {
            rVar2 = aVar.kkC;
        }
        this.kkC = rVar2;
        if (aVar.kiD == null) {
            cVar = com.facebook.common.memory.d.cCN();
        } else {
            cVar = aVar.kiD;
        }
        this.kiD = cVar;
        if (aVar.kkD == null) {
            rVar3 = h.cIh();
        } else {
            rVar3 = aVar.kkD;
        }
        this.kkD = rVar3;
        if (aVar.kkE == null) {
            sVar2 = n.cIm();
        } else {
            sVar2 = aVar.kkE;
        }
        this.kkE = sVar2;
        if (aVar.kkF == null) {
            rVar4 = f.cIh();
        } else {
            rVar4 = aVar.kkF;
        }
        this.kkF = rVar4;
        if (aVar.kkG == null) {
            sVar3 = n.cIm();
        } else {
            sVar3 = aVar.kkG;
        }
        this.kkG = sVar3;
    }

    public r cIp() {
        return this.kkA;
    }

    public s cIq() {
        return this.kkB;
    }

    public com.facebook.common.memory.c cGw() {
        return this.kiD;
    }

    public r cIr() {
        return this.kkD;
    }

    public s cIs() {
        return this.kkE;
    }

    public r cIt() {
        return this.kkC;
    }

    public r cIu() {
        return this.kkF;
    }

    public s cIv() {
        return this.kkG;
    }

    public static a cIw() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c kiD;
        private r kkA;
        private s kkB;
        private r kkC;
        private r kkD;
        private s kkE;
        private r kkF;
        private s kkG;

        private a() {
        }

        public p cIx() {
            return new p(this);
        }
    }
}
