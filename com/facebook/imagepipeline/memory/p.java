package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes25.dex */
public class p {
    private final com.facebook.common.memory.c nFo;
    private final s nHA;
    private final r nHB;
    private final r nHC;
    private final s nHD;
    private final r nHE;
    private final s nHF;
    private final r nHz;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.nHz == null) {
            rVar = e.dYU();
        } else {
            rVar = aVar.nHz;
        }
        this.nHz = rVar;
        if (aVar.nHA == null) {
            sVar = n.dYZ();
        } else {
            sVar = aVar.nHA;
        }
        this.nHA = sVar;
        if (aVar.nHB == null) {
            rVar2 = g.dYU();
        } else {
            rVar2 = aVar.nHB;
        }
        this.nHB = rVar2;
        if (aVar.nFo == null) {
            cVar = com.facebook.common.memory.d.dSJ();
        } else {
            cVar = aVar.nFo;
        }
        this.nFo = cVar;
        if (aVar.nHC == null) {
            rVar3 = h.dYU();
        } else {
            rVar3 = aVar.nHC;
        }
        this.nHC = rVar3;
        if (aVar.nHD == null) {
            sVar2 = n.dYZ();
        } else {
            sVar2 = aVar.nHD;
        }
        this.nHD = sVar2;
        if (aVar.nHE == null) {
            rVar4 = f.dYU();
        } else {
            rVar4 = aVar.nHE;
        }
        this.nHE = rVar4;
        if (aVar.nHF == null) {
            sVar3 = n.dYZ();
        } else {
            sVar3 = aVar.nHF;
        }
        this.nHF = sVar3;
    }

    public r dZc() {
        return this.nHz;
    }

    public s dZd() {
        return this.nHA;
    }

    public com.facebook.common.memory.c dWX() {
        return this.nFo;
    }

    public r dZe() {
        return this.nHC;
    }

    public s dZf() {
        return this.nHD;
    }

    public r dZg() {
        return this.nHB;
    }

    public r dZh() {
        return this.nHE;
    }

    public s dZi() {
        return this.nHF;
    }

    public static a dZj() {
        return new a();
    }

    /* loaded from: classes25.dex */
    public static class a {
        private com.facebook.common.memory.c nFo;
        private s nHA;
        private r nHB;
        private r nHC;
        private s nHD;
        private r nHE;
        private s nHF;
        private r nHz;

        private a() {
        }

        public p dZk() {
            return new p(this);
        }
    }
}
