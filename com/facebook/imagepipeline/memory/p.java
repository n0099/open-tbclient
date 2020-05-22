package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c mvO;
    private final r mxX;
    private final s mxY;
    private final r mxZ;
    private final r mya;
    private final s myb;
    private final r myc;
    private final s myd;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.mxX == null) {
            rVar = e.dAH();
        } else {
            rVar = aVar.mxX;
        }
        this.mxX = rVar;
        if (aVar.mxY == null) {
            sVar = n.dAM();
        } else {
            sVar = aVar.mxY;
        }
        this.mxY = sVar;
        if (aVar.mxZ == null) {
            rVar2 = g.dAH();
        } else {
            rVar2 = aVar.mxZ;
        }
        this.mxZ = rVar2;
        if (aVar.mvO == null) {
            cVar = com.facebook.common.memory.d.duu();
        } else {
            cVar = aVar.mvO;
        }
        this.mvO = cVar;
        if (aVar.mya == null) {
            rVar3 = h.dAH();
        } else {
            rVar3 = aVar.mya;
        }
        this.mya = rVar3;
        if (aVar.myb == null) {
            sVar2 = n.dAM();
        } else {
            sVar2 = aVar.myb;
        }
        this.myb = sVar2;
        if (aVar.myc == null) {
            rVar4 = f.dAH();
        } else {
            rVar4 = aVar.myc;
        }
        this.myc = rVar4;
        if (aVar.myd == null) {
            sVar3 = n.dAM();
        } else {
            sVar3 = aVar.myd;
        }
        this.myd = sVar3;
    }

    public r dAP() {
        return this.mxX;
    }

    public s dAQ() {
        return this.mxY;
    }

    public com.facebook.common.memory.c dyK() {
        return this.mvO;
    }

    public r dAR() {
        return this.mya;
    }

    public s dAS() {
        return this.myb;
    }

    public r dAT() {
        return this.mxZ;
    }

    public r dAU() {
        return this.myc;
    }

    public s dAV() {
        return this.myd;
    }

    public static a dAW() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c mvO;
        private r mxX;
        private s mxY;
        private r mxZ;
        private r mya;
        private s myb;
        private r myc;
        private s myd;

        private a() {
        }

        public p dAX() {
            return new p(this);
        }
    }
}
