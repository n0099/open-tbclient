package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c jHv;
    private final r jJs;
    private final s jJt;
    private final r jJu;
    private final r jJv;
    private final s jJw;
    private final r jJx;
    private final s jJy;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.jJs == null) {
            rVar = e.czh();
        } else {
            rVar = aVar.jJs;
        }
        this.jJs = rVar;
        if (aVar.jJt == null) {
            sVar = n.czm();
        } else {
            sVar = aVar.jJt;
        }
        this.jJt = sVar;
        if (aVar.jJu == null) {
            rVar2 = g.czh();
        } else {
            rVar2 = aVar.jJu;
        }
        this.jJu = rVar2;
        if (aVar.jHv == null) {
            cVar = com.facebook.common.memory.d.ctO();
        } else {
            cVar = aVar.jHv;
        }
        this.jHv = cVar;
        if (aVar.jJv == null) {
            rVar3 = h.czh();
        } else {
            rVar3 = aVar.jJv;
        }
        this.jJv = rVar3;
        if (aVar.jJw == null) {
            sVar2 = n.czm();
        } else {
            sVar2 = aVar.jJw;
        }
        this.jJw = sVar2;
        if (aVar.jJx == null) {
            rVar4 = f.czh();
        } else {
            rVar4 = aVar.jJx;
        }
        this.jJx = rVar4;
        if (aVar.jJy == null) {
            sVar3 = n.czm();
        } else {
            sVar3 = aVar.jJy;
        }
        this.jJy = sVar3;
    }

    public r czp() {
        return this.jJs;
    }

    public s czq() {
        return this.jJt;
    }

    public com.facebook.common.memory.c cxx() {
        return this.jHv;
    }

    public r czr() {
        return this.jJv;
    }

    public s czs() {
        return this.jJw;
    }

    public r czt() {
        return this.jJu;
    }

    public r czu() {
        return this.jJx;
    }

    public s czv() {
        return this.jJy;
    }

    public static a czw() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c jHv;
        private r jJs;
        private s jJt;
        private r jJu;
        private r jJv;
        private s jJw;
        private r jJx;
        private s jJy;

        private a() {
        }

        public p czx() {
            return new p(this);
        }
    }
}
