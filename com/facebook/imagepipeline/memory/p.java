package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c jGQ;
    private final r jIN;
    private final s jIO;
    private final r jIP;
    private final r jIQ;
    private final s jIR;
    private final r jIS;
    private final s jIT;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.jIN == null) {
            rVar = e.cza();
        } else {
            rVar = aVar.jIN;
        }
        this.jIN = rVar;
        if (aVar.jIO == null) {
            sVar = n.czf();
        } else {
            sVar = aVar.jIO;
        }
        this.jIO = sVar;
        if (aVar.jIP == null) {
            rVar2 = g.cza();
        } else {
            rVar2 = aVar.jIP;
        }
        this.jIP = rVar2;
        if (aVar.jGQ == null) {
            cVar = com.facebook.common.memory.d.ctH();
        } else {
            cVar = aVar.jGQ;
        }
        this.jGQ = cVar;
        if (aVar.jIQ == null) {
            rVar3 = h.cza();
        } else {
            rVar3 = aVar.jIQ;
        }
        this.jIQ = rVar3;
        if (aVar.jIR == null) {
            sVar2 = n.czf();
        } else {
            sVar2 = aVar.jIR;
        }
        this.jIR = sVar2;
        if (aVar.jIS == null) {
            rVar4 = f.cza();
        } else {
            rVar4 = aVar.jIS;
        }
        this.jIS = rVar4;
        if (aVar.jIT == null) {
            sVar3 = n.czf();
        } else {
            sVar3 = aVar.jIT;
        }
        this.jIT = sVar3;
    }

    public r czi() {
        return this.jIN;
    }

    public s czj() {
        return this.jIO;
    }

    public com.facebook.common.memory.c cxq() {
        return this.jGQ;
    }

    public r czk() {
        return this.jIQ;
    }

    public s czl() {
        return this.jIR;
    }

    public r czm() {
        return this.jIP;
    }

    public r czn() {
        return this.jIS;
    }

    public s czo() {
        return this.jIT;
    }

    public static a czp() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c jGQ;
        private r jIN;
        private s jIO;
        private r jIP;
        private r jIQ;
        private s jIR;
        private r jIS;
        private s jIT;

        private a() {
        }

        public p czq() {
            return new p(this);
        }
    }
}
