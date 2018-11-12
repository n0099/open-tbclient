package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c iga;
    private final r ihV;
    private final s ihW;
    private final r ihX;
    private final r ihY;
    private final s ihZ;
    private final r iia;
    private final s iib;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.ihV == null) {
            rVar = e.bWl();
        } else {
            rVar = aVar.ihV;
        }
        this.ihV = rVar;
        if (aVar.ihW == null) {
            sVar = n.bWq();
        } else {
            sVar = aVar.ihW;
        }
        this.ihW = sVar;
        if (aVar.ihX == null) {
            rVar2 = g.bWl();
        } else {
            rVar2 = aVar.ihX;
        }
        this.ihX = rVar2;
        if (aVar.iga == null) {
            cVar = com.facebook.common.memory.d.bQZ();
        } else {
            cVar = aVar.iga;
        }
        this.iga = cVar;
        if (aVar.ihY == null) {
            rVar3 = h.bWl();
        } else {
            rVar3 = aVar.ihY;
        }
        this.ihY = rVar3;
        if (aVar.ihZ == null) {
            sVar2 = n.bWq();
        } else {
            sVar2 = aVar.ihZ;
        }
        this.ihZ = sVar2;
        if (aVar.iia == null) {
            rVar4 = f.bWl();
        } else {
            rVar4 = aVar.iia;
        }
        this.iia = rVar4;
        if (aVar.iib == null) {
            sVar3 = n.bWq();
        } else {
            sVar3 = aVar.iib;
        }
        this.iib = sVar3;
    }

    public r bWt() {
        return this.ihV;
    }

    public s bWu() {
        return this.ihW;
    }

    public com.facebook.common.memory.c bUF() {
        return this.iga;
    }

    public r bWv() {
        return this.ihY;
    }

    public s bWw() {
        return this.ihZ;
    }

    public r bWx() {
        return this.ihX;
    }

    public r bWy() {
        return this.iia;
    }

    public s bWz() {
        return this.iib;
    }

    public static a bWA() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c iga;
        private r ihV;
        private s ihW;
        private r ihX;
        private r ihY;
        private s ihZ;
        private r iia;
        private s iib;

        private a() {
        }

        public p bWB() {
            return new p(this);
        }
    }
}
