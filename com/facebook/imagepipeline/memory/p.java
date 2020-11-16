package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes15.dex */
public class p {
    private final com.facebook.common.memory.c oWV;
    private final r oZe;
    private final s oZf;
    private final r oZg;
    private final r oZh;
    private final s oZi;
    private final r oZj;
    private final s oZk;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.oZe == null) {
            rVar = e.eqs();
        } else {
            rVar = aVar.oZe;
        }
        this.oZe = rVar;
        if (aVar.oZf == null) {
            sVar = n.eqx();
        } else {
            sVar = aVar.oZf;
        }
        this.oZf = sVar;
        if (aVar.oZg == null) {
            rVar2 = g.eqs();
        } else {
            rVar2 = aVar.oZg;
        }
        this.oZg = rVar2;
        if (aVar.oWV == null) {
            cVar = com.facebook.common.memory.d.ekf();
        } else {
            cVar = aVar.oWV;
        }
        this.oWV = cVar;
        if (aVar.oZh == null) {
            rVar3 = h.eqs();
        } else {
            rVar3 = aVar.oZh;
        }
        this.oZh = rVar3;
        if (aVar.oZi == null) {
            sVar2 = n.eqx();
        } else {
            sVar2 = aVar.oZi;
        }
        this.oZi = sVar2;
        if (aVar.oZj == null) {
            rVar4 = f.eqs();
        } else {
            rVar4 = aVar.oZj;
        }
        this.oZj = rVar4;
        if (aVar.oZk == null) {
            sVar3 = n.eqx();
        } else {
            sVar3 = aVar.oZk;
        }
        this.oZk = sVar3;
    }

    public r eqA() {
        return this.oZe;
    }

    public s eqB() {
        return this.oZf;
    }

    public com.facebook.common.memory.c eov() {
        return this.oWV;
    }

    public r eqC() {
        return this.oZh;
    }

    public s eqD() {
        return this.oZi;
    }

    public r eqE() {
        return this.oZg;
    }

    public r eqF() {
        return this.oZj;
    }

    public s eqG() {
        return this.oZk;
    }

    public static a eqH() {
        return new a();
    }

    /* loaded from: classes15.dex */
    public static class a {
        private com.facebook.common.memory.c oWV;
        private r oZe;
        private s oZf;
        private r oZg;
        private r oZh;
        private s oZi;
        private r oZj;
        private s oZk;

        private a() {
        }

        public p eqI() {
            return new p(this);
        }
    }
}
