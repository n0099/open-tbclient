package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes4.dex */
public class p {
    private final com.facebook.common.memory.c nbj;
    private final s ndA;
    private final r ndu;
    private final s ndv;
    private final r ndw;
    private final r ndx;
    private final s ndy;
    private final r ndz;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.ndu == null) {
            rVar = e.dIO();
        } else {
            rVar = aVar.ndu;
        }
        this.ndu = rVar;
        if (aVar.ndv == null) {
            sVar = n.dIT();
        } else {
            sVar = aVar.ndv;
        }
        this.ndv = sVar;
        if (aVar.ndw == null) {
            rVar2 = g.dIO();
        } else {
            rVar2 = aVar.ndw;
        }
        this.ndw = rVar2;
        if (aVar.nbj == null) {
            cVar = com.facebook.common.memory.d.dCC();
        } else {
            cVar = aVar.nbj;
        }
        this.nbj = cVar;
        if (aVar.ndx == null) {
            rVar3 = h.dIO();
        } else {
            rVar3 = aVar.ndx;
        }
        this.ndx = rVar3;
        if (aVar.ndy == null) {
            sVar2 = n.dIT();
        } else {
            sVar2 = aVar.ndy;
        }
        this.ndy = sVar2;
        if (aVar.ndz == null) {
            rVar4 = f.dIO();
        } else {
            rVar4 = aVar.ndz;
        }
        this.ndz = rVar4;
        if (aVar.ndA == null) {
            sVar3 = n.dIT();
        } else {
            sVar3 = aVar.ndA;
        }
        this.ndA = sVar3;
    }

    public r dIW() {
        return this.ndu;
    }

    public s dIX() {
        return this.ndv;
    }

    public com.facebook.common.memory.c dGR() {
        return this.nbj;
    }

    public r dIY() {
        return this.ndx;
    }

    public s dIZ() {
        return this.ndy;
    }

    public r dJa() {
        return this.ndw;
    }

    public r dJb() {
        return this.ndz;
    }

    public s dJc() {
        return this.ndA;
    }

    public static a dJd() {
        return new a();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private com.facebook.common.memory.c nbj;
        private s ndA;
        private r ndu;
        private s ndv;
        private r ndw;
        private r ndx;
        private s ndy;
        private r ndz;

        private a() {
        }

        public p dJe() {
            return new p(this);
        }
    }
}
