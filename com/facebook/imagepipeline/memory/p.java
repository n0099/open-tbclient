package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class p {
    private final com.facebook.common.memory.c pJe;
    private final r pLn;
    private final s pLo;
    private final r pLp;
    private final r pLq;
    private final s pLr;
    private final r pLs;
    private final s pLt;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.pLn == null) {
            rVar = e.eyO();
        } else {
            rVar = aVar.pLn;
        }
        this.pLn = rVar;
        if (aVar.pLo == null) {
            sVar = n.eyT();
        } else {
            sVar = aVar.pLo;
        }
        this.pLo = sVar;
        if (aVar.pLp == null) {
            rVar2 = g.eyO();
        } else {
            rVar2 = aVar.pLp;
        }
        this.pLp = rVar2;
        if (aVar.pJe == null) {
            cVar = com.facebook.common.memory.d.esL();
        } else {
            cVar = aVar.pJe;
        }
        this.pJe = cVar;
        if (aVar.pLq == null) {
            rVar3 = h.eyO();
        } else {
            rVar3 = aVar.pLq;
        }
        this.pLq = rVar3;
        if (aVar.pLr == null) {
            sVar2 = n.eyT();
        } else {
            sVar2 = aVar.pLr;
        }
        this.pLr = sVar2;
        if (aVar.pLs == null) {
            rVar4 = f.eyO();
        } else {
            rVar4 = aVar.pLs;
        }
        this.pLs = rVar4;
        if (aVar.pLt == null) {
            sVar3 = n.eyT();
        } else {
            sVar3 = aVar.pLt;
        }
        this.pLt = sVar3;
    }

    public r eyW() {
        return this.pLn;
    }

    public s eyX() {
        return this.pLo;
    }

    public com.facebook.common.memory.c ewV() {
        return this.pJe;
    }

    public r eyY() {
        return this.pLq;
    }

    public s eyZ() {
        return this.pLr;
    }

    public r eza() {
        return this.pLp;
    }

    public r ezb() {
        return this.pLs;
    }

    public s ezc() {
        return this.pLt;
    }

    public static a ezd() {
        return new a();
    }

    /* loaded from: classes5.dex */
    public static class a {
        private com.facebook.common.memory.c pJe;
        private r pLn;
        private s pLo;
        private r pLp;
        private r pLq;
        private s pLr;
        private r pLs;
        private s pLt;

        private a() {
        }

        public p eze() {
            return new p(this);
        }
    }
}
