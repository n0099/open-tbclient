package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c jZH;
    private final r kbE;
    private final s kbF;
    private final r kbG;
    private final r kbH;
    private final s kbI;
    private final r kbJ;
    private final s kbK;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.kbE == null) {
            rVar = e.cGX();
        } else {
            rVar = aVar.kbE;
        }
        this.kbE = rVar;
        if (aVar.kbF == null) {
            sVar = n.cHc();
        } else {
            sVar = aVar.kbF;
        }
        this.kbF = sVar;
        if (aVar.kbG == null) {
            rVar2 = g.cGX();
        } else {
            rVar2 = aVar.kbG;
        }
        this.kbG = rVar2;
        if (aVar.jZH == null) {
            cVar = com.facebook.common.memory.d.cBF();
        } else {
            cVar = aVar.jZH;
        }
        this.jZH = cVar;
        if (aVar.kbH == null) {
            rVar3 = h.cGX();
        } else {
            rVar3 = aVar.kbH;
        }
        this.kbH = rVar3;
        if (aVar.kbI == null) {
            sVar2 = n.cHc();
        } else {
            sVar2 = aVar.kbI;
        }
        this.kbI = sVar2;
        if (aVar.kbJ == null) {
            rVar4 = f.cGX();
        } else {
            rVar4 = aVar.kbJ;
        }
        this.kbJ = rVar4;
        if (aVar.kbK == null) {
            sVar3 = n.cHc();
        } else {
            sVar3 = aVar.kbK;
        }
        this.kbK = sVar3;
    }

    public r cHf() {
        return this.kbE;
    }

    public s cHg() {
        return this.kbF;
    }

    public com.facebook.common.memory.c cFn() {
        return this.jZH;
    }

    public r cHh() {
        return this.kbH;
    }

    public s cHi() {
        return this.kbI;
    }

    public r cHj() {
        return this.kbG;
    }

    public r cHk() {
        return this.kbJ;
    }

    public s cHl() {
        return this.kbK;
    }

    public static a cHm() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c jZH;
        private r kbE;
        private s kbF;
        private r kbG;
        private r kbH;
        private s kbI;
        private r kbJ;
        private s kbK;

        private a() {
        }

        public p cHn() {
            return new p(this);
        }
    }
}
