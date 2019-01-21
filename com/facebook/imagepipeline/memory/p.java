package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c irE;
    private final s itA;
    private final r itB;
    private final r itC;
    private final s itD;
    private final r itE;
    private final s itF;
    private final r itz;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.itz == null) {
            rVar = e.bZP();
        } else {
            rVar = aVar.itz;
        }
        this.itz = rVar;
        if (aVar.itA == null) {
            sVar = n.bZU();
        } else {
            sVar = aVar.itA;
        }
        this.itA = sVar;
        if (aVar.itB == null) {
            rVar2 = g.bZP();
        } else {
            rVar2 = aVar.itB;
        }
        this.itB = rVar2;
        if (aVar.irE == null) {
            cVar = com.facebook.common.memory.d.bUD();
        } else {
            cVar = aVar.irE;
        }
        this.irE = cVar;
        if (aVar.itC == null) {
            rVar3 = h.bZP();
        } else {
            rVar3 = aVar.itC;
        }
        this.itC = rVar3;
        if (aVar.itD == null) {
            sVar2 = n.bZU();
        } else {
            sVar2 = aVar.itD;
        }
        this.itD = sVar2;
        if (aVar.itE == null) {
            rVar4 = f.bZP();
        } else {
            rVar4 = aVar.itE;
        }
        this.itE = rVar4;
        if (aVar.itF == null) {
            sVar3 = n.bZU();
        } else {
            sVar3 = aVar.itF;
        }
        this.itF = sVar3;
    }

    public r bZX() {
        return this.itz;
    }

    public s bZY() {
        return this.itA;
    }

    public com.facebook.common.memory.c bYj() {
        return this.irE;
    }

    public r bZZ() {
        return this.itC;
    }

    public s caa() {
        return this.itD;
    }

    public r cab() {
        return this.itB;
    }

    public r cac() {
        return this.itE;
    }

    public s cad() {
        return this.itF;
    }

    public static a cae() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c irE;
        private s itA;
        private r itB;
        private r itC;
        private s itD;
        private r itE;
        private s itF;
        private r itz;

        private a() {
        }

        public p caf() {
            return new p(this);
        }
    }
}
