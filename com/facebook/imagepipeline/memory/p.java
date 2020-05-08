package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c mbX;
    private final r meg;
    private final s meh;
    private final r mei;
    private final r mej;
    private final s mek;
    private final r mel;
    private final s mem;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.meg == null) {
            rVar = e.dtp();
        } else {
            rVar = aVar.meg;
        }
        this.meg = rVar;
        if (aVar.meh == null) {
            sVar = n.dtu();
        } else {
            sVar = aVar.meh;
        }
        this.meh = sVar;
        if (aVar.mei == null) {
            rVar2 = g.dtp();
        } else {
            rVar2 = aVar.mei;
        }
        this.mei = rVar2;
        if (aVar.mbX == null) {
            cVar = com.facebook.common.memory.d.dna();
        } else {
            cVar = aVar.mbX;
        }
        this.mbX = cVar;
        if (aVar.mej == null) {
            rVar3 = h.dtp();
        } else {
            rVar3 = aVar.mej;
        }
        this.mej = rVar3;
        if (aVar.mek == null) {
            sVar2 = n.dtu();
        } else {
            sVar2 = aVar.mek;
        }
        this.mek = sVar2;
        if (aVar.mel == null) {
            rVar4 = f.dtp();
        } else {
            rVar4 = aVar.mel;
        }
        this.mel = rVar4;
        if (aVar.mem == null) {
            sVar3 = n.dtu();
        } else {
            sVar3 = aVar.mem;
        }
        this.mem = sVar3;
    }

    public r dtx() {
        return this.meg;
    }

    public s dty() {
        return this.meh;
    }

    public com.facebook.common.memory.c drr() {
        return this.mbX;
    }

    public r dtz() {
        return this.mej;
    }

    public s dtA() {
        return this.mek;
    }

    public r dtB() {
        return this.mei;
    }

    public r dtC() {
        return this.mel;
    }

    public s dtD() {
        return this.mem;
    }

    public static a dtE() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c mbX;
        private r meg;
        private s meh;
        private r mei;
        private r mej;
        private s mek;
        private r mel;
        private s mem;

        private a() {
        }

        public p dtF() {
            return new p(this);
        }
    }
}
