package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c irD;
    private final r itA;
    private final r itB;
    private final s itC;
    private final r itD;
    private final s itE;
    private final r ity;
    private final s itz;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.ity == null) {
            rVar = e.bZP();
        } else {
            rVar = aVar.ity;
        }
        this.ity = rVar;
        if (aVar.itz == null) {
            sVar = n.bZU();
        } else {
            sVar = aVar.itz;
        }
        this.itz = sVar;
        if (aVar.itA == null) {
            rVar2 = g.bZP();
        } else {
            rVar2 = aVar.itA;
        }
        this.itA = rVar2;
        if (aVar.irD == null) {
            cVar = com.facebook.common.memory.d.bUD();
        } else {
            cVar = aVar.irD;
        }
        this.irD = cVar;
        if (aVar.itB == null) {
            rVar3 = h.bZP();
        } else {
            rVar3 = aVar.itB;
        }
        this.itB = rVar3;
        if (aVar.itC == null) {
            sVar2 = n.bZU();
        } else {
            sVar2 = aVar.itC;
        }
        this.itC = sVar2;
        if (aVar.itD == null) {
            rVar4 = f.bZP();
        } else {
            rVar4 = aVar.itD;
        }
        this.itD = rVar4;
        if (aVar.itE == null) {
            sVar3 = n.bZU();
        } else {
            sVar3 = aVar.itE;
        }
        this.itE = sVar3;
    }

    public r bZX() {
        return this.ity;
    }

    public s bZY() {
        return this.itz;
    }

    public com.facebook.common.memory.c bYj() {
        return this.irD;
    }

    public r bZZ() {
        return this.itB;
    }

    public s caa() {
        return this.itC;
    }

    public r cab() {
        return this.itA;
    }

    public r cac() {
        return this.itD;
    }

    public s cad() {
        return this.itE;
    }

    public static a cae() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c irD;
        private r itA;
        private r itB;
        private s itC;
        private r itD;
        private s itE;
        private r ity;
        private s itz;

        private a() {
        }

        public p caf() {
            return new p(this);
        }
    }
}
