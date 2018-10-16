package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c iep;
    private final r igk;
    private final s igl;
    private final r igm;
    private final r ign;
    private final s igo;
    private final r igp;
    private final s igq;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.igk == null) {
            rVar = e.bWQ();
        } else {
            rVar = aVar.igk;
        }
        this.igk = rVar;
        if (aVar.igl == null) {
            sVar = n.bWV();
        } else {
            sVar = aVar.igl;
        }
        this.igl = sVar;
        if (aVar.igm == null) {
            rVar2 = g.bWQ();
        } else {
            rVar2 = aVar.igm;
        }
        this.igm = rVar2;
        if (aVar.iep == null) {
            cVar = com.facebook.common.memory.d.bRE();
        } else {
            cVar = aVar.iep;
        }
        this.iep = cVar;
        if (aVar.ign == null) {
            rVar3 = h.bWQ();
        } else {
            rVar3 = aVar.ign;
        }
        this.ign = rVar3;
        if (aVar.igo == null) {
            sVar2 = n.bWV();
        } else {
            sVar2 = aVar.igo;
        }
        this.igo = sVar2;
        if (aVar.igp == null) {
            rVar4 = f.bWQ();
        } else {
            rVar4 = aVar.igp;
        }
        this.igp = rVar4;
        if (aVar.igq == null) {
            sVar3 = n.bWV();
        } else {
            sVar3 = aVar.igq;
        }
        this.igq = sVar3;
    }

    public r bWY() {
        return this.igk;
    }

    public s bWZ() {
        return this.igl;
    }

    public com.facebook.common.memory.c bVk() {
        return this.iep;
    }

    public r bXa() {
        return this.ign;
    }

    public s bXb() {
        return this.igo;
    }

    public r bXc() {
        return this.igm;
    }

    public r bXd() {
        return this.igp;
    }

    public s bXe() {
        return this.igq;
    }

    public static a bXf() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c iep;
        private r igk;
        private s igl;
        private r igm;
        private r ign;
        private s igo;
        private r igp;
        private s igq;

        private a() {
        }

        public p bXg() {
            return new p(this);
        }
    }
}
