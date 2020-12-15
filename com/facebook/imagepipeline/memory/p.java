package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes15.dex */
public class p {
    private final com.facebook.common.memory.c plM;
    private final r pnV;
    private final s pnW;
    private final r pnX;
    private final r pnY;
    private final s pnZ;
    private final r poa;
    private final s pob;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.pnV == null) {
            rVar = e.evV();
        } else {
            rVar = aVar.pnV;
        }
        this.pnV = rVar;
        if (aVar.pnW == null) {
            sVar = n.ewa();
        } else {
            sVar = aVar.pnW;
        }
        this.pnW = sVar;
        if (aVar.pnX == null) {
            rVar2 = g.evV();
        } else {
            rVar2 = aVar.pnX;
        }
        this.pnX = rVar2;
        if (aVar.plM == null) {
            cVar = com.facebook.common.memory.d.epV();
        } else {
            cVar = aVar.plM;
        }
        this.plM = cVar;
        if (aVar.pnY == null) {
            rVar3 = h.evV();
        } else {
            rVar3 = aVar.pnY;
        }
        this.pnY = rVar3;
        if (aVar.pnZ == null) {
            sVar2 = n.ewa();
        } else {
            sVar2 = aVar.pnZ;
        }
        this.pnZ = sVar2;
        if (aVar.poa == null) {
            rVar4 = f.evV();
        } else {
            rVar4 = aVar.poa;
        }
        this.poa = rVar4;
        if (aVar.pob == null) {
            sVar3 = n.ewa();
        } else {
            sVar3 = aVar.pob;
        }
        this.pob = sVar3;
    }

    public r ewd() {
        return this.pnV;
    }

    public s ewe() {
        return this.pnW;
    }

    public com.facebook.common.memory.c eub() {
        return this.plM;
    }

    public r ewf() {
        return this.pnY;
    }

    public s ewg() {
        return this.pnZ;
    }

    public r ewh() {
        return this.pnX;
    }

    public r ewi() {
        return this.poa;
    }

    public s ewj() {
        return this.pob;
    }

    public static a ewk() {
        return new a();
    }

    /* loaded from: classes15.dex */
    public static class a {
        private com.facebook.common.memory.c plM;
        private r pnV;
        private s pnW;
        private r pnX;
        private r pnY;
        private s pnZ;
        private r poa;
        private s pob;

        private a() {
        }

        public p ewl() {
            return new p(this);
        }
    }
}
