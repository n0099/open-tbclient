package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c khL;
    private final r kjJ;
    private final s kjK;
    private final r kjL;
    private final r kjM;
    private final s kjN;
    private final r kjO;
    private final s kjP;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.kjJ == null) {
            rVar = e.cIf();
        } else {
            rVar = aVar.kjJ;
        }
        this.kjJ = rVar;
        if (aVar.kjK == null) {
            sVar = n.cIk();
        } else {
            sVar = aVar.kjK;
        }
        this.kjK = sVar;
        if (aVar.kjL == null) {
            rVar2 = g.cIf();
        } else {
            rVar2 = aVar.kjL;
        }
        this.kjL = rVar2;
        if (aVar.khL == null) {
            cVar = com.facebook.common.memory.d.cCL();
        } else {
            cVar = aVar.khL;
        }
        this.khL = cVar;
        if (aVar.kjM == null) {
            rVar3 = h.cIf();
        } else {
            rVar3 = aVar.kjM;
        }
        this.kjM = rVar3;
        if (aVar.kjN == null) {
            sVar2 = n.cIk();
        } else {
            sVar2 = aVar.kjN;
        }
        this.kjN = sVar2;
        if (aVar.kjO == null) {
            rVar4 = f.cIf();
        } else {
            rVar4 = aVar.kjO;
        }
        this.kjO = rVar4;
        if (aVar.kjP == null) {
            sVar3 = n.cIk();
        } else {
            sVar3 = aVar.kjP;
        }
        this.kjP = sVar3;
    }

    public r cIn() {
        return this.kjJ;
    }

    public s cIo() {
        return this.kjK;
    }

    public com.facebook.common.memory.c cGu() {
        return this.khL;
    }

    public r cIp() {
        return this.kjM;
    }

    public s cIq() {
        return this.kjN;
    }

    public r cIr() {
        return this.kjL;
    }

    public r cIs() {
        return this.kjO;
    }

    public s cIt() {
        return this.kjP;
    }

    public static a cIu() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c khL;
        private r kjJ;
        private s kjK;
        private r kjL;
        private r kjM;
        private s kjN;
        private r kjO;
        private s kjP;

        private a() {
        }

        public p cIv() {
            return new p(this);
        }
    }
}
