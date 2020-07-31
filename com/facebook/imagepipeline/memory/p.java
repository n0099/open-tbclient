package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes4.dex */
public class p {
    private final com.facebook.common.memory.c nbh;
    private final r nds;
    private final s ndt;
    private final r ndu;
    private final r ndv;
    private final s ndw;
    private final r ndx;
    private final s ndy;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.nds == null) {
            rVar = e.dIN();
        } else {
            rVar = aVar.nds;
        }
        this.nds = rVar;
        if (aVar.ndt == null) {
            sVar = n.dIS();
        } else {
            sVar = aVar.ndt;
        }
        this.ndt = sVar;
        if (aVar.ndu == null) {
            rVar2 = g.dIN();
        } else {
            rVar2 = aVar.ndu;
        }
        this.ndu = rVar2;
        if (aVar.nbh == null) {
            cVar = com.facebook.common.memory.d.dCB();
        } else {
            cVar = aVar.nbh;
        }
        this.nbh = cVar;
        if (aVar.ndv == null) {
            rVar3 = h.dIN();
        } else {
            rVar3 = aVar.ndv;
        }
        this.ndv = rVar3;
        if (aVar.ndw == null) {
            sVar2 = n.dIS();
        } else {
            sVar2 = aVar.ndw;
        }
        this.ndw = sVar2;
        if (aVar.ndx == null) {
            rVar4 = f.dIN();
        } else {
            rVar4 = aVar.ndx;
        }
        this.ndx = rVar4;
        if (aVar.ndy == null) {
            sVar3 = n.dIS();
        } else {
            sVar3 = aVar.ndy;
        }
        this.ndy = sVar3;
    }

    public r dIV() {
        return this.nds;
    }

    public s dIW() {
        return this.ndt;
    }

    public com.facebook.common.memory.c dGQ() {
        return this.nbh;
    }

    public r dIX() {
        return this.ndv;
    }

    public s dIY() {
        return this.ndw;
    }

    public r dIZ() {
        return this.ndu;
    }

    public r dJa() {
        return this.ndx;
    }

    public s dJb() {
        return this.ndy;
    }

    public static a dJc() {
        return new a();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private com.facebook.common.memory.c nbh;
        private r nds;
        private s ndt;
        private r ndu;
        private r ndv;
        private s ndw;
        private r ndx;
        private s ndy;

        private a() {
        }

        public p dJd() {
            return new p(this);
        }
    }
}
