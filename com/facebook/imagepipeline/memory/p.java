package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes15.dex */
public class p {
    private final com.facebook.common.memory.c plK;
    private final r pnT;
    private final s pnU;
    private final r pnV;
    private final r pnW;
    private final s pnX;
    private final r pnY;
    private final s pnZ;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.pnT == null) {
            rVar = e.evU();
        } else {
            rVar = aVar.pnT;
        }
        this.pnT = rVar;
        if (aVar.pnU == null) {
            sVar = n.evZ();
        } else {
            sVar = aVar.pnU;
        }
        this.pnU = sVar;
        if (aVar.pnV == null) {
            rVar2 = g.evU();
        } else {
            rVar2 = aVar.pnV;
        }
        this.pnV = rVar2;
        if (aVar.plK == null) {
            cVar = com.facebook.common.memory.d.epU();
        } else {
            cVar = aVar.plK;
        }
        this.plK = cVar;
        if (aVar.pnW == null) {
            rVar3 = h.evU();
        } else {
            rVar3 = aVar.pnW;
        }
        this.pnW = rVar3;
        if (aVar.pnX == null) {
            sVar2 = n.evZ();
        } else {
            sVar2 = aVar.pnX;
        }
        this.pnX = sVar2;
        if (aVar.pnY == null) {
            rVar4 = f.evU();
        } else {
            rVar4 = aVar.pnY;
        }
        this.pnY = rVar4;
        if (aVar.pnZ == null) {
            sVar3 = n.evZ();
        } else {
            sVar3 = aVar.pnZ;
        }
        this.pnZ = sVar3;
    }

    public r ewc() {
        return this.pnT;
    }

    public s ewd() {
        return this.pnU;
    }

    public com.facebook.common.memory.c eua() {
        return this.plK;
    }

    public r ewe() {
        return this.pnW;
    }

    public s ewf() {
        return this.pnX;
    }

    public r ewg() {
        return this.pnV;
    }

    public r ewh() {
        return this.pnY;
    }

    public s ewi() {
        return this.pnZ;
    }

    public static a ewj() {
        return new a();
    }

    /* loaded from: classes15.dex */
    public static class a {
        private com.facebook.common.memory.c plK;
        private r pnT;
        private s pnU;
        private r pnV;
        private r pnW;
        private s pnX;
        private r pnY;
        private s pnZ;

        private a() {
        }

        public p ewk() {
            return new p(this);
        }
    }
}
