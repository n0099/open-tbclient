package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c jGP;
    private final r jIM;
    private final s jIN;
    private final r jIO;
    private final r jIP;
    private final s jIQ;
    private final r jIR;
    private final s jIS;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.jIM == null) {
            rVar = e.cza();
        } else {
            rVar = aVar.jIM;
        }
        this.jIM = rVar;
        if (aVar.jIN == null) {
            sVar = n.czf();
        } else {
            sVar = aVar.jIN;
        }
        this.jIN = sVar;
        if (aVar.jIO == null) {
            rVar2 = g.cza();
        } else {
            rVar2 = aVar.jIO;
        }
        this.jIO = rVar2;
        if (aVar.jGP == null) {
            cVar = com.facebook.common.memory.d.ctH();
        } else {
            cVar = aVar.jGP;
        }
        this.jGP = cVar;
        if (aVar.jIP == null) {
            rVar3 = h.cza();
        } else {
            rVar3 = aVar.jIP;
        }
        this.jIP = rVar3;
        if (aVar.jIQ == null) {
            sVar2 = n.czf();
        } else {
            sVar2 = aVar.jIQ;
        }
        this.jIQ = sVar2;
        if (aVar.jIR == null) {
            rVar4 = f.cza();
        } else {
            rVar4 = aVar.jIR;
        }
        this.jIR = rVar4;
        if (aVar.jIS == null) {
            sVar3 = n.czf();
        } else {
            sVar3 = aVar.jIS;
        }
        this.jIS = sVar3;
    }

    public r czi() {
        return this.jIM;
    }

    public s czj() {
        return this.jIN;
    }

    public com.facebook.common.memory.c cxq() {
        return this.jGP;
    }

    public r czk() {
        return this.jIP;
    }

    public s czl() {
        return this.jIQ;
    }

    public r czm() {
        return this.jIO;
    }

    public r czn() {
        return this.jIR;
    }

    public s czo() {
        return this.jIS;
    }

    public static a czp() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c jGP;
        private r jIM;
        private s jIN;
        private r jIO;
        private r jIP;
        private s jIQ;
        private r jIR;
        private s jIS;

        private a() {
        }

        public p czq() {
            return new p(this);
        }
    }
}
