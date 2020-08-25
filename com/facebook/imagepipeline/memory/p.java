package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes8.dex */
public class p {
    private final com.facebook.common.memory.c nuZ;
    private final r nxk;
    private final s nxl;
    private final r nxm;
    private final r nxn;
    private final s nxo;
    private final r nxp;
    private final s nxq;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.nxk == null) {
            rVar = e.dUN();
        } else {
            rVar = aVar.nxk;
        }
        this.nxk = rVar;
        if (aVar.nxl == null) {
            sVar = n.dUS();
        } else {
            sVar = aVar.nxl;
        }
        this.nxl = sVar;
        if (aVar.nxm == null) {
            rVar2 = g.dUN();
        } else {
            rVar2 = aVar.nxm;
        }
        this.nxm = rVar2;
        if (aVar.nuZ == null) {
            cVar = com.facebook.common.memory.d.dOC();
        } else {
            cVar = aVar.nuZ;
        }
        this.nuZ = cVar;
        if (aVar.nxn == null) {
            rVar3 = h.dUN();
        } else {
            rVar3 = aVar.nxn;
        }
        this.nxn = rVar3;
        if (aVar.nxo == null) {
            sVar2 = n.dUS();
        } else {
            sVar2 = aVar.nxo;
        }
        this.nxo = sVar2;
        if (aVar.nxp == null) {
            rVar4 = f.dUN();
        } else {
            rVar4 = aVar.nxp;
        }
        this.nxp = rVar4;
        if (aVar.nxq == null) {
            sVar3 = n.dUS();
        } else {
            sVar3 = aVar.nxq;
        }
        this.nxq = sVar3;
    }

    public r dUV() {
        return this.nxk;
    }

    public s dUW() {
        return this.nxl;
    }

    public com.facebook.common.memory.c dSQ() {
        return this.nuZ;
    }

    public r dUX() {
        return this.nxn;
    }

    public s dUY() {
        return this.nxo;
    }

    public r dUZ() {
        return this.nxm;
    }

    public r dVa() {
        return this.nxp;
    }

    public s dVb() {
        return this.nxq;
    }

    public static a dVc() {
        return new a();
    }

    /* loaded from: classes8.dex */
    public static class a {
        private com.facebook.common.memory.c nuZ;
        private r nxk;
        private s nxl;
        private r nxm;
        private r nxn;
        private s nxo;
        private r nxp;
        private s nxq;

        private a() {
        }

        public p dVd() {
            return new p(this);
        }
    }
}
