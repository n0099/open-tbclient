package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes8.dex */
public class p {
    private final com.facebook.common.memory.c nvr;
    private final r nxC;
    private final s nxD;
    private final r nxE;
    private final r nxF;
    private final s nxG;
    private final r nxH;
    private final s nxI;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.nxC == null) {
            rVar = e.dUW();
        } else {
            rVar = aVar.nxC;
        }
        this.nxC = rVar;
        if (aVar.nxD == null) {
            sVar = n.dVb();
        } else {
            sVar = aVar.nxD;
        }
        this.nxD = sVar;
        if (aVar.nxE == null) {
            rVar2 = g.dUW();
        } else {
            rVar2 = aVar.nxE;
        }
        this.nxE = rVar2;
        if (aVar.nvr == null) {
            cVar = com.facebook.common.memory.d.dOL();
        } else {
            cVar = aVar.nvr;
        }
        this.nvr = cVar;
        if (aVar.nxF == null) {
            rVar3 = h.dUW();
        } else {
            rVar3 = aVar.nxF;
        }
        this.nxF = rVar3;
        if (aVar.nxG == null) {
            sVar2 = n.dVb();
        } else {
            sVar2 = aVar.nxG;
        }
        this.nxG = sVar2;
        if (aVar.nxH == null) {
            rVar4 = f.dUW();
        } else {
            rVar4 = aVar.nxH;
        }
        this.nxH = rVar4;
        if (aVar.nxI == null) {
            sVar3 = n.dVb();
        } else {
            sVar3 = aVar.nxI;
        }
        this.nxI = sVar3;
    }

    public r dVe() {
        return this.nxC;
    }

    public s dVf() {
        return this.nxD;
    }

    public com.facebook.common.memory.c dSZ() {
        return this.nvr;
    }

    public r dVg() {
        return this.nxF;
    }

    public s dVh() {
        return this.nxG;
    }

    public r dVi() {
        return this.nxE;
    }

    public r dVj() {
        return this.nxH;
    }

    public s dVk() {
        return this.nxI;
    }

    public static a dVl() {
        return new a();
    }

    /* loaded from: classes8.dex */
    public static class a {
        private com.facebook.common.memory.c nvr;
        private r nxC;
        private s nxD;
        private r nxE;
        private r nxF;
        private s nxG;
        private r nxH;
        private s nxI;

        private a() {
        }

        public p dVm() {
            return new p(this);
        }
    }
}
