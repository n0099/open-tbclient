package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c jZE;
    private final r kbB;
    private final s kbC;
    private final r kbD;
    private final r kbE;
    private final s kbF;
    private final r kbG;
    private final s kbH;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.kbB == null) {
            rVar = e.cGY();
        } else {
            rVar = aVar.kbB;
        }
        this.kbB = rVar;
        if (aVar.kbC == null) {
            sVar = n.cHd();
        } else {
            sVar = aVar.kbC;
        }
        this.kbC = sVar;
        if (aVar.kbD == null) {
            rVar2 = g.cGY();
        } else {
            rVar2 = aVar.kbD;
        }
        this.kbD = rVar2;
        if (aVar.jZE == null) {
            cVar = com.facebook.common.memory.d.cBG();
        } else {
            cVar = aVar.jZE;
        }
        this.jZE = cVar;
        if (aVar.kbE == null) {
            rVar3 = h.cGY();
        } else {
            rVar3 = aVar.kbE;
        }
        this.kbE = rVar3;
        if (aVar.kbF == null) {
            sVar2 = n.cHd();
        } else {
            sVar2 = aVar.kbF;
        }
        this.kbF = sVar2;
        if (aVar.kbG == null) {
            rVar4 = f.cGY();
        } else {
            rVar4 = aVar.kbG;
        }
        this.kbG = rVar4;
        if (aVar.kbH == null) {
            sVar3 = n.cHd();
        } else {
            sVar3 = aVar.kbH;
        }
        this.kbH = sVar3;
    }

    public r cHg() {
        return this.kbB;
    }

    public s cHh() {
        return this.kbC;
    }

    public com.facebook.common.memory.c cFo() {
        return this.jZE;
    }

    public r cHi() {
        return this.kbE;
    }

    public s cHj() {
        return this.kbF;
    }

    public r cHk() {
        return this.kbD;
    }

    public r cHl() {
        return this.kbG;
    }

    public s cHm() {
        return this.kbH;
    }

    public static a cHn() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c jZE;
        private r kbB;
        private s kbC;
        private r kbD;
        private r kbE;
        private s kbF;
        private r kbG;
        private s kbH;

        private a() {
        }

        public p cHo() {
            return new p(this);
        }
    }
}
