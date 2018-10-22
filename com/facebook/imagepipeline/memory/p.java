package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c ieq;
    private final r igl;
    private final s igm;
    private final r ign;
    private final r igo;
    private final s igp;
    private final r igq;
    private final s igr;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.igl == null) {
            rVar = e.bWQ();
        } else {
            rVar = aVar.igl;
        }
        this.igl = rVar;
        if (aVar.igm == null) {
            sVar = n.bWV();
        } else {
            sVar = aVar.igm;
        }
        this.igm = sVar;
        if (aVar.ign == null) {
            rVar2 = g.bWQ();
        } else {
            rVar2 = aVar.ign;
        }
        this.ign = rVar2;
        if (aVar.ieq == null) {
            cVar = com.facebook.common.memory.d.bRE();
        } else {
            cVar = aVar.ieq;
        }
        this.ieq = cVar;
        if (aVar.igo == null) {
            rVar3 = h.bWQ();
        } else {
            rVar3 = aVar.igo;
        }
        this.igo = rVar3;
        if (aVar.igp == null) {
            sVar2 = n.bWV();
        } else {
            sVar2 = aVar.igp;
        }
        this.igp = sVar2;
        if (aVar.igq == null) {
            rVar4 = f.bWQ();
        } else {
            rVar4 = aVar.igq;
        }
        this.igq = rVar4;
        if (aVar.igr == null) {
            sVar3 = n.bWV();
        } else {
            sVar3 = aVar.igr;
        }
        this.igr = sVar3;
    }

    public r bWY() {
        return this.igl;
    }

    public s bWZ() {
        return this.igm;
    }

    public com.facebook.common.memory.c bVk() {
        return this.ieq;
    }

    public r bXa() {
        return this.igo;
    }

    public s bXb() {
        return this.igp;
    }

    public r bXc() {
        return this.ign;
    }

    public r bXd() {
        return this.igq;
    }

    public s bXe() {
        return this.igr;
    }

    public static a bXf() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c ieq;
        private r igl;
        private s igm;
        private r ign;
        private r igo;
        private s igp;
        private r igq;
        private s igr;

        private a() {
        }

        public p bXg() {
            return new p(this);
        }
    }
}
