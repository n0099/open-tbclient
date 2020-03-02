package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c lSp;
    private final r lUA;
    private final s lUB;
    private final r lUC;
    private final r lUD;
    private final s lUE;
    private final r lUF;
    private final s lUG;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.lUA == null) {
            rVar = e.dqW();
        } else {
            rVar = aVar.lUA;
        }
        this.lUA = rVar;
        if (aVar.lUB == null) {
            sVar = n.drb();
        } else {
            sVar = aVar.lUB;
        }
        this.lUB = sVar;
        if (aVar.lUC == null) {
            rVar2 = g.dqW();
        } else {
            rVar2 = aVar.lUC;
        }
        this.lUC = rVar2;
        if (aVar.lSp == null) {
            cVar = com.facebook.common.memory.d.dkM();
        } else {
            cVar = aVar.lSp;
        }
        this.lSp = cVar;
        if (aVar.lUD == null) {
            rVar3 = h.dqW();
        } else {
            rVar3 = aVar.lUD;
        }
        this.lUD = rVar3;
        if (aVar.lUE == null) {
            sVar2 = n.drb();
        } else {
            sVar2 = aVar.lUE;
        }
        this.lUE = sVar2;
        if (aVar.lUF == null) {
            rVar4 = f.dqW();
        } else {
            rVar4 = aVar.lUF;
        }
        this.lUF = rVar4;
        if (aVar.lUG == null) {
            sVar3 = n.drb();
        } else {
            sVar3 = aVar.lUG;
        }
        this.lUG = sVar3;
    }

    public r dre() {
        return this.lUA;
    }

    public s drf() {
        return this.lUB;
    }

    public com.facebook.common.memory.c doY() {
        return this.lSp;
    }

    public r drg() {
        return this.lUD;
    }

    public s drh() {
        return this.lUE;
    }

    public r dri() {
        return this.lUC;
    }

    public r drj() {
        return this.lUF;
    }

    public s drk() {
        return this.lUG;
    }

    public static a drl() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c lSp;
        private r lUA;
        private s lUB;
        private r lUC;
        private r lUD;
        private s lUE;
        private r lUF;
        private s lUG;

        private a() {
        }

        public p drm() {
            return new p(this);
        }
    }
}
