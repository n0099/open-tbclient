package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes18.dex */
public class p {
    private final com.facebook.common.memory.c oLZ;
    private final r oOi;
    private final s oOj;
    private final r oOk;
    private final r oOl;
    private final s oOm;
    private final r oOn;
    private final s oOo;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.oOi == null) {
            rVar = e.emD();
        } else {
            rVar = aVar.oOi;
        }
        this.oOi = rVar;
        if (aVar.oOj == null) {
            sVar = n.emI();
        } else {
            sVar = aVar.oOj;
        }
        this.oOj = sVar;
        if (aVar.oOk == null) {
            rVar2 = g.emD();
        } else {
            rVar2 = aVar.oOk;
        }
        this.oOk = rVar2;
        if (aVar.oLZ == null) {
            cVar = com.facebook.common.memory.d.egs();
        } else {
            cVar = aVar.oLZ;
        }
        this.oLZ = cVar;
        if (aVar.oOl == null) {
            rVar3 = h.emD();
        } else {
            rVar3 = aVar.oOl;
        }
        this.oOl = rVar3;
        if (aVar.oOm == null) {
            sVar2 = n.emI();
        } else {
            sVar2 = aVar.oOm;
        }
        this.oOm = sVar2;
        if (aVar.oOn == null) {
            rVar4 = f.emD();
        } else {
            rVar4 = aVar.oOn;
        }
        this.oOn = rVar4;
        if (aVar.oOo == null) {
            sVar3 = n.emI();
        } else {
            sVar3 = aVar.oOo;
        }
        this.oOo = sVar3;
    }

    public r emL() {
        return this.oOi;
    }

    public s emM() {
        return this.oOj;
    }

    public com.facebook.common.memory.c ekG() {
        return this.oLZ;
    }

    public r emN() {
        return this.oOl;
    }

    public s emO() {
        return this.oOm;
    }

    public r emP() {
        return this.oOk;
    }

    public r emQ() {
        return this.oOn;
    }

    public s emR() {
        return this.oOo;
    }

    public static a emS() {
        return new a();
    }

    /* loaded from: classes18.dex */
    public static class a {
        private com.facebook.common.memory.c oLZ;
        private r oOi;
        private s oOj;
        private r oOk;
        private r oOl;
        private s oOm;
        private r oOn;
        private s oOo;

        private a() {
        }

        public p emT() {
            return new p(this);
        }
    }
}
