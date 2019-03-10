package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c jHD;
    private final r jJA;
    private final s jJB;
    private final r jJC;
    private final r jJD;
    private final s jJE;
    private final r jJF;
    private final s jJG;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.jJA == null) {
            rVar = e.cze();
        } else {
            rVar = aVar.jJA;
        }
        this.jJA = rVar;
        if (aVar.jJB == null) {
            sVar = n.czj();
        } else {
            sVar = aVar.jJB;
        }
        this.jJB = sVar;
        if (aVar.jJC == null) {
            rVar2 = g.cze();
        } else {
            rVar2 = aVar.jJC;
        }
        this.jJC = rVar2;
        if (aVar.jHD == null) {
            cVar = com.facebook.common.memory.d.ctL();
        } else {
            cVar = aVar.jHD;
        }
        this.jHD = cVar;
        if (aVar.jJD == null) {
            rVar3 = h.cze();
        } else {
            rVar3 = aVar.jJD;
        }
        this.jJD = rVar3;
        if (aVar.jJE == null) {
            sVar2 = n.czj();
        } else {
            sVar2 = aVar.jJE;
        }
        this.jJE = sVar2;
        if (aVar.jJF == null) {
            rVar4 = f.cze();
        } else {
            rVar4 = aVar.jJF;
        }
        this.jJF = rVar4;
        if (aVar.jJG == null) {
            sVar3 = n.czj();
        } else {
            sVar3 = aVar.jJG;
        }
        this.jJG = sVar3;
    }

    public r czm() {
        return this.jJA;
    }

    public s czn() {
        return this.jJB;
    }

    public com.facebook.common.memory.c cxu() {
        return this.jHD;
    }

    public r czo() {
        return this.jJD;
    }

    public s czp() {
        return this.jJE;
    }

    public r czq() {
        return this.jJC;
    }

    public r czr() {
        return this.jJF;
    }

    public s czs() {
        return this.jJG;
    }

    public static a czt() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c jHD;
        private r jJA;
        private s jJB;
        private r jJC;
        private r jJD;
        private s jJE;
        private r jJF;
        private s jJG;

        private a() {
        }

        public p czu() {
            return new p(this);
        }
    }
}
