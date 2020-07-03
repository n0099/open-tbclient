package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c mTa;
    private final r mVo;
    private final s mVp;
    private final r mVq;
    private final r mVr;
    private final s mVs;
    private final r mVt;
    private final s mVu;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.mVo == null) {
            rVar = e.dFx();
        } else {
            rVar = aVar.mVo;
        }
        this.mVo = rVar;
        if (aVar.mVp == null) {
            sVar = n.dFC();
        } else {
            sVar = aVar.mVp;
        }
        this.mVp = sVar;
        if (aVar.mVq == null) {
            rVar2 = g.dFx();
        } else {
            rVar2 = aVar.mVq;
        }
        this.mVq = rVar2;
        if (aVar.mTa == null) {
            cVar = com.facebook.common.memory.d.dzl();
        } else {
            cVar = aVar.mTa;
        }
        this.mTa = cVar;
        if (aVar.mVr == null) {
            rVar3 = h.dFx();
        } else {
            rVar3 = aVar.mVr;
        }
        this.mVr = rVar3;
        if (aVar.mVs == null) {
            sVar2 = n.dFC();
        } else {
            sVar2 = aVar.mVs;
        }
        this.mVs = sVar2;
        if (aVar.mVt == null) {
            rVar4 = f.dFx();
        } else {
            rVar4 = aVar.mVt;
        }
        this.mVt = rVar4;
        if (aVar.mVu == null) {
            sVar3 = n.dFC();
        } else {
            sVar3 = aVar.mVu;
        }
        this.mVu = sVar3;
    }

    public r dFF() {
        return this.mVo;
    }

    public s dFG() {
        return this.mVp;
    }

    public com.facebook.common.memory.c dDA() {
        return this.mTa;
    }

    public r dFH() {
        return this.mVr;
    }

    public s dFI() {
        return this.mVs;
    }

    public r dFJ() {
        return this.mVq;
    }

    public r dFK() {
        return this.mVt;
    }

    public s dFL() {
        return this.mVu;
    }

    public static a dFM() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c mTa;
        private r mVo;
        private s mVp;
        private r mVq;
        private r mVr;
        private s mVs;
        private r mVt;
        private s mVu;

        private a() {
        }

        public p dFN() {
            return new p(this);
        }
    }
}
