package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c jZD;
    private final r kbA;
    private final s kbB;
    private final r kbC;
    private final r kbD;
    private final s kbE;
    private final r kbF;
    private final s kbG;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.kbA == null) {
            rVar = e.cGW();
        } else {
            rVar = aVar.kbA;
        }
        this.kbA = rVar;
        if (aVar.kbB == null) {
            sVar = n.cHb();
        } else {
            sVar = aVar.kbB;
        }
        this.kbB = sVar;
        if (aVar.kbC == null) {
            rVar2 = g.cGW();
        } else {
            rVar2 = aVar.kbC;
        }
        this.kbC = rVar2;
        if (aVar.jZD == null) {
            cVar = com.facebook.common.memory.d.cBE();
        } else {
            cVar = aVar.jZD;
        }
        this.jZD = cVar;
        if (aVar.kbD == null) {
            rVar3 = h.cGW();
        } else {
            rVar3 = aVar.kbD;
        }
        this.kbD = rVar3;
        if (aVar.kbE == null) {
            sVar2 = n.cHb();
        } else {
            sVar2 = aVar.kbE;
        }
        this.kbE = sVar2;
        if (aVar.kbF == null) {
            rVar4 = f.cGW();
        } else {
            rVar4 = aVar.kbF;
        }
        this.kbF = rVar4;
        if (aVar.kbG == null) {
            sVar3 = n.cHb();
        } else {
            sVar3 = aVar.kbG;
        }
        this.kbG = sVar3;
    }

    public r cHe() {
        return this.kbA;
    }

    public s cHf() {
        return this.kbB;
    }

    public com.facebook.common.memory.c cFm() {
        return this.jZD;
    }

    public r cHg() {
        return this.kbD;
    }

    public s cHh() {
        return this.kbE;
    }

    public r cHi() {
        return this.kbC;
    }

    public r cHj() {
        return this.kbF;
    }

    public s cHk() {
        return this.kbG;
    }

    public static a cHl() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c jZD;
        private r kbA;
        private s kbB;
        private r kbC;
        private r kbD;
        private s kbE;
        private r kbF;
        private s kbG;

        private a() {
        }

        public p cHm() {
            return new p(this);
        }
    }
}
