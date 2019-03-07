package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c jHk;
    private final r jJh;
    private final s jJi;
    private final r jJj;
    private final r jJk;
    private final s jJl;
    private final r jJm;
    private final s jJn;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.jJh == null) {
            rVar = e.cyU();
        } else {
            rVar = aVar.jJh;
        }
        this.jJh = rVar;
        if (aVar.jJi == null) {
            sVar = n.cyZ();
        } else {
            sVar = aVar.jJi;
        }
        this.jJi = sVar;
        if (aVar.jJj == null) {
            rVar2 = g.cyU();
        } else {
            rVar2 = aVar.jJj;
        }
        this.jJj = rVar2;
        if (aVar.jHk == null) {
            cVar = com.facebook.common.memory.d.ctB();
        } else {
            cVar = aVar.jHk;
        }
        this.jHk = cVar;
        if (aVar.jJk == null) {
            rVar3 = h.cyU();
        } else {
            rVar3 = aVar.jJk;
        }
        this.jJk = rVar3;
        if (aVar.jJl == null) {
            sVar2 = n.cyZ();
        } else {
            sVar2 = aVar.jJl;
        }
        this.jJl = sVar2;
        if (aVar.jJm == null) {
            rVar4 = f.cyU();
        } else {
            rVar4 = aVar.jJm;
        }
        this.jJm = rVar4;
        if (aVar.jJn == null) {
            sVar3 = n.cyZ();
        } else {
            sVar3 = aVar.jJn;
        }
        this.jJn = sVar3;
    }

    public r czc() {
        return this.jJh;
    }

    public s czd() {
        return this.jJi;
    }

    public com.facebook.common.memory.c cxk() {
        return this.jHk;
    }

    public r cze() {
        return this.jJk;
    }

    public s czf() {
        return this.jJl;
    }

    public r czg() {
        return this.jJj;
    }

    public r czh() {
        return this.jJm;
    }

    public s czi() {
        return this.jJn;
    }

    public static a czj() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c jHk;
        private r jJh;
        private s jJi;
        private r jJj;
        private r jJk;
        private s jJl;
        private r jJm;
        private s jJn;

        private a() {
        }

        public p czk() {
            return new p(this);
        }
    }
}
