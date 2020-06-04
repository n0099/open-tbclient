package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c mwY;
    private final r mzh;
    private final s mzi;
    private final r mzj;
    private final r mzk;
    private final s mzl;
    private final r mzm;
    private final s mzn;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.mzh == null) {
            rVar = e.dAV();
        } else {
            rVar = aVar.mzh;
        }
        this.mzh = rVar;
        if (aVar.mzi == null) {
            sVar = n.dBa();
        } else {
            sVar = aVar.mzi;
        }
        this.mzi = sVar;
        if (aVar.mzj == null) {
            rVar2 = g.dAV();
        } else {
            rVar2 = aVar.mzj;
        }
        this.mzj = rVar2;
        if (aVar.mwY == null) {
            cVar = com.facebook.common.memory.d.duI();
        } else {
            cVar = aVar.mwY;
        }
        this.mwY = cVar;
        if (aVar.mzk == null) {
            rVar3 = h.dAV();
        } else {
            rVar3 = aVar.mzk;
        }
        this.mzk = rVar3;
        if (aVar.mzl == null) {
            sVar2 = n.dBa();
        } else {
            sVar2 = aVar.mzl;
        }
        this.mzl = sVar2;
        if (aVar.mzm == null) {
            rVar4 = f.dAV();
        } else {
            rVar4 = aVar.mzm;
        }
        this.mzm = rVar4;
        if (aVar.mzn == null) {
            sVar3 = n.dBa();
        } else {
            sVar3 = aVar.mzn;
        }
        this.mzn = sVar3;
    }

    public r dBd() {
        return this.mzh;
    }

    public s dBe() {
        return this.mzi;
    }

    public com.facebook.common.memory.c dyY() {
        return this.mwY;
    }

    public r dBf() {
        return this.mzk;
    }

    public s dBg() {
        return this.mzl;
    }

    public r dBh() {
        return this.mzj;
    }

    public r dBi() {
        return this.mzm;
    }

    public s dBj() {
        return this.mzn;
    }

    public static a dBk() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c mwY;
        private r mzh;
        private s mzi;
        private r mzj;
        private r mzk;
        private s mzl;
        private r mzm;
        private s mzn;

        private a() {
        }

        public p dBl() {
            return new p(this);
        }
    }
}
