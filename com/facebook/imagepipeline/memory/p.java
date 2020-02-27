package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c lSn;
    private final r lUA;
    private final r lUB;
    private final s lUC;
    private final r lUD;
    private final s lUE;
    private final r lUy;
    private final s lUz;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.lUy == null) {
            rVar = e.dqU();
        } else {
            rVar = aVar.lUy;
        }
        this.lUy = rVar;
        if (aVar.lUz == null) {
            sVar = n.dqZ();
        } else {
            sVar = aVar.lUz;
        }
        this.lUz = sVar;
        if (aVar.lUA == null) {
            rVar2 = g.dqU();
        } else {
            rVar2 = aVar.lUA;
        }
        this.lUA = rVar2;
        if (aVar.lSn == null) {
            cVar = com.facebook.common.memory.d.dkK();
        } else {
            cVar = aVar.lSn;
        }
        this.lSn = cVar;
        if (aVar.lUB == null) {
            rVar3 = h.dqU();
        } else {
            rVar3 = aVar.lUB;
        }
        this.lUB = rVar3;
        if (aVar.lUC == null) {
            sVar2 = n.dqZ();
        } else {
            sVar2 = aVar.lUC;
        }
        this.lUC = sVar2;
        if (aVar.lUD == null) {
            rVar4 = f.dqU();
        } else {
            rVar4 = aVar.lUD;
        }
        this.lUD = rVar4;
        if (aVar.lUE == null) {
            sVar3 = n.dqZ();
        } else {
            sVar3 = aVar.lUE;
        }
        this.lUE = sVar3;
    }

    public r drc() {
        return this.lUy;
    }

    public s drd() {
        return this.lUz;
    }

    public com.facebook.common.memory.c doW() {
        return this.lSn;
    }

    public r dre() {
        return this.lUB;
    }

    public s drf() {
        return this.lUC;
    }

    public r drg() {
        return this.lUA;
    }

    public r drh() {
        return this.lUD;
    }

    public s dri() {
        return this.lUE;
    }

    public static a drj() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c lSn;
        private r lUA;
        private r lUB;
        private s lUC;
        private r lUD;
        private s lUE;
        private r lUy;
        private s lUz;

        private a() {
        }

        public p drk() {
            return new p(this);
        }
    }
}
