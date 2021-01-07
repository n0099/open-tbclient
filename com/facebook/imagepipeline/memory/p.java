package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes3.dex */
public class p {
    private final com.facebook.common.memory.c pCW;
    private final r pFf;
    private final s pFg;
    private final r pFh;
    private final r pFi;
    private final s pFj;
    private final r pFk;
    private final s pFl;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.pFf == null) {
            rVar = e.eAg();
        } else {
            rVar = aVar.pFf;
        }
        this.pFf = rVar;
        if (aVar.pFg == null) {
            sVar = n.eAl();
        } else {
            sVar = aVar.pFg;
        }
        this.pFg = sVar;
        if (aVar.pFh == null) {
            rVar2 = g.eAg();
        } else {
            rVar2 = aVar.pFh;
        }
        this.pFh = rVar2;
        if (aVar.pCW == null) {
            cVar = com.facebook.common.memory.d.eue();
        } else {
            cVar = aVar.pCW;
        }
        this.pCW = cVar;
        if (aVar.pFi == null) {
            rVar3 = h.eAg();
        } else {
            rVar3 = aVar.pFi;
        }
        this.pFi = rVar3;
        if (aVar.pFj == null) {
            sVar2 = n.eAl();
        } else {
            sVar2 = aVar.pFj;
        }
        this.pFj = sVar2;
        if (aVar.pFk == null) {
            rVar4 = f.eAg();
        } else {
            rVar4 = aVar.pFk;
        }
        this.pFk = rVar4;
        if (aVar.pFl == null) {
            sVar3 = n.eAl();
        } else {
            sVar3 = aVar.pFl;
        }
        this.pFl = sVar3;
    }

    public r eAo() {
        return this.pFf;
    }

    public s eAp() {
        return this.pFg;
    }

    public com.facebook.common.memory.c eym() {
        return this.pCW;
    }

    public r eAq() {
        return this.pFi;
    }

    public s eAr() {
        return this.pFj;
    }

    public r eAs() {
        return this.pFh;
    }

    public r eAt() {
        return this.pFk;
    }

    public s eAu() {
        return this.pFl;
    }

    public static a eAv() {
        return new a();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private com.facebook.common.memory.c pCW;
        private r pFf;
        private s pFg;
        private r pFh;
        private r pFi;
        private s pFj;
        private r pFk;
        private s pFl;

        private a() {
        }

        public p eAw() {
            return new p(this);
        }
    }
}
