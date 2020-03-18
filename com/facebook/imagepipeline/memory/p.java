package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c lUg;
    private final r lWr;
    private final s lWs;
    private final r lWt;
    private final r lWu;
    private final s lWv;
    private final r lWw;
    private final s lWx;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.lWr == null) {
            rVar = e.dru();
        } else {
            rVar = aVar.lWr;
        }
        this.lWr = rVar;
        if (aVar.lWs == null) {
            sVar = n.drz();
        } else {
            sVar = aVar.lWs;
        }
        this.lWs = sVar;
        if (aVar.lWt == null) {
            rVar2 = g.dru();
        } else {
            rVar2 = aVar.lWt;
        }
        this.lWt = rVar2;
        if (aVar.lUg == null) {
            cVar = com.facebook.common.memory.d.dlk();
        } else {
            cVar = aVar.lUg;
        }
        this.lUg = cVar;
        if (aVar.lWu == null) {
            rVar3 = h.dru();
        } else {
            rVar3 = aVar.lWu;
        }
        this.lWu = rVar3;
        if (aVar.lWv == null) {
            sVar2 = n.drz();
        } else {
            sVar2 = aVar.lWv;
        }
        this.lWv = sVar2;
        if (aVar.lWw == null) {
            rVar4 = f.dru();
        } else {
            rVar4 = aVar.lWw;
        }
        this.lWw = rVar4;
        if (aVar.lWx == null) {
            sVar3 = n.drz();
        } else {
            sVar3 = aVar.lWx;
        }
        this.lWx = sVar3;
    }

    public r drC() {
        return this.lWr;
    }

    public s drD() {
        return this.lWs;
    }

    public com.facebook.common.memory.c dpw() {
        return this.lUg;
    }

    public r drE() {
        return this.lWu;
    }

    public s drF() {
        return this.lWv;
    }

    public r drG() {
        return this.lWt;
    }

    public r drH() {
        return this.lWw;
    }

    public s drI() {
        return this.lWx;
    }

    public static a drJ() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c lUg;
        private r lWr;
        private s lWs;
        private r lWt;
        private r lWu;
        private s lWv;
        private r lWw;
        private s lWx;

        private a() {
        }

        public p drK() {
            return new p(this);
        }
    }
}
