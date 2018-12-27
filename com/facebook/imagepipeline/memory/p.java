package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c iqw;
    private final r isr;
    private final s iss;
    private final r ist;
    private final r isu;
    private final s isv;
    private final r isw;
    private final s isx;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.isr == null) {
            rVar = e.bZh();
        } else {
            rVar = aVar.isr;
        }
        this.isr = rVar;
        if (aVar.iss == null) {
            sVar = n.bZm();
        } else {
            sVar = aVar.iss;
        }
        this.iss = sVar;
        if (aVar.ist == null) {
            rVar2 = g.bZh();
        } else {
            rVar2 = aVar.ist;
        }
        this.ist = rVar2;
        if (aVar.iqw == null) {
            cVar = com.facebook.common.memory.d.bTV();
        } else {
            cVar = aVar.iqw;
        }
        this.iqw = cVar;
        if (aVar.isu == null) {
            rVar3 = h.bZh();
        } else {
            rVar3 = aVar.isu;
        }
        this.isu = rVar3;
        if (aVar.isv == null) {
            sVar2 = n.bZm();
        } else {
            sVar2 = aVar.isv;
        }
        this.isv = sVar2;
        if (aVar.isw == null) {
            rVar4 = f.bZh();
        } else {
            rVar4 = aVar.isw;
        }
        this.isw = rVar4;
        if (aVar.isx == null) {
            sVar3 = n.bZm();
        } else {
            sVar3 = aVar.isx;
        }
        this.isx = sVar3;
    }

    public r bZp() {
        return this.isr;
    }

    public s bZq() {
        return this.iss;
    }

    public com.facebook.common.memory.c bXB() {
        return this.iqw;
    }

    public r bZr() {
        return this.isu;
    }

    public s bZs() {
        return this.isv;
    }

    public r bZt() {
        return this.ist;
    }

    public r bZu() {
        return this.isw;
    }

    public s bZv() {
        return this.isx;
    }

    public static a bZw() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c iqw;
        private r isr;
        private s iss;
        private r ist;
        private r isu;
        private s isv;
        private r isw;
        private s isx;

        private a() {
        }

        public p bZx() {
            return new p(this);
        }
    }
}
