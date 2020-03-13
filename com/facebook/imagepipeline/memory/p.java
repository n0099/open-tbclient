package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c lSA;
    private final r lUL;
    private final s lUM;
    private final r lUN;
    private final r lUO;
    private final s lUP;
    private final r lUQ;
    private final s lUR;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.lUL == null) {
            rVar = e.dqX();
        } else {
            rVar = aVar.lUL;
        }
        this.lUL = rVar;
        if (aVar.lUM == null) {
            sVar = n.drc();
        } else {
            sVar = aVar.lUM;
        }
        this.lUM = sVar;
        if (aVar.lUN == null) {
            rVar2 = g.dqX();
        } else {
            rVar2 = aVar.lUN;
        }
        this.lUN = rVar2;
        if (aVar.lSA == null) {
            cVar = com.facebook.common.memory.d.dkN();
        } else {
            cVar = aVar.lSA;
        }
        this.lSA = cVar;
        if (aVar.lUO == null) {
            rVar3 = h.dqX();
        } else {
            rVar3 = aVar.lUO;
        }
        this.lUO = rVar3;
        if (aVar.lUP == null) {
            sVar2 = n.drc();
        } else {
            sVar2 = aVar.lUP;
        }
        this.lUP = sVar2;
        if (aVar.lUQ == null) {
            rVar4 = f.dqX();
        } else {
            rVar4 = aVar.lUQ;
        }
        this.lUQ = rVar4;
        if (aVar.lUR == null) {
            sVar3 = n.drc();
        } else {
            sVar3 = aVar.lUR;
        }
        this.lUR = sVar3;
    }

    public r drf() {
        return this.lUL;
    }

    public s drg() {
        return this.lUM;
    }

    public com.facebook.common.memory.c doZ() {
        return this.lSA;
    }

    public r drh() {
        return this.lUO;
    }

    public s dri() {
        return this.lUP;
    }

    public r drj() {
        return this.lUN;
    }

    public r drk() {
        return this.lUQ;
    }

    public s drl() {
        return this.lUR;
    }

    public static a drm() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c lSA;
        private r lUL;
        private s lUM;
        private r lUN;
        private r lUO;
        private s lUP;
        private r lUQ;
        private s lUR;

        private a() {
        }

        public p drn() {
            return new p(this);
        }
    }
}
