package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes18.dex */
public class p {
    private final com.facebook.common.memory.c oVs;
    private final r oXB;
    private final s oXC;
    private final r oXD;
    private final r oXE;
    private final s oXF;
    private final r oXG;
    private final s oXH;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.oXB == null) {
            rVar = e.equ();
        } else {
            rVar = aVar.oXB;
        }
        this.oXB = rVar;
        if (aVar.oXC == null) {
            sVar = n.eqz();
        } else {
            sVar = aVar.oXC;
        }
        this.oXC = sVar;
        if (aVar.oXD == null) {
            rVar2 = g.equ();
        } else {
            rVar2 = aVar.oXD;
        }
        this.oXD = rVar2;
        if (aVar.oVs == null) {
            cVar = com.facebook.common.memory.d.ekh();
        } else {
            cVar = aVar.oVs;
        }
        this.oVs = cVar;
        if (aVar.oXE == null) {
            rVar3 = h.equ();
        } else {
            rVar3 = aVar.oXE;
        }
        this.oXE = rVar3;
        if (aVar.oXF == null) {
            sVar2 = n.eqz();
        } else {
            sVar2 = aVar.oXF;
        }
        this.oXF = sVar2;
        if (aVar.oXG == null) {
            rVar4 = f.equ();
        } else {
            rVar4 = aVar.oXG;
        }
        this.oXG = rVar4;
        if (aVar.oXH == null) {
            sVar3 = n.eqz();
        } else {
            sVar3 = aVar.oXH;
        }
        this.oXH = sVar3;
    }

    public r eqC() {
        return this.oXB;
    }

    public s eqD() {
        return this.oXC;
    }

    public com.facebook.common.memory.c eox() {
        return this.oVs;
    }

    public r eqE() {
        return this.oXE;
    }

    public s eqF() {
        return this.oXF;
    }

    public r eqG() {
        return this.oXD;
    }

    public r eqH() {
        return this.oXG;
    }

    public s eqI() {
        return this.oXH;
    }

    public static a eqJ() {
        return new a();
    }

    /* loaded from: classes18.dex */
    public static class a {
        private com.facebook.common.memory.c oVs;
        private r oXB;
        private s oXC;
        private r oXD;
        private r oXE;
        private s oXF;
        private r oXG;
        private s oXH;

        private a() {
        }

        public p eqK() {
            return new p(this);
        }
    }
}
