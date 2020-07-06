package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c mTd;
    private final r mVr;
    private final s mVs;
    private final r mVt;
    private final r mVu;
    private final s mVv;
    private final r mVw;
    private final s mVx;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.mVr == null) {
            rVar = e.dFB();
        } else {
            rVar = aVar.mVr;
        }
        this.mVr = rVar;
        if (aVar.mVs == null) {
            sVar = n.dFG();
        } else {
            sVar = aVar.mVs;
        }
        this.mVs = sVar;
        if (aVar.mVt == null) {
            rVar2 = g.dFB();
        } else {
            rVar2 = aVar.mVt;
        }
        this.mVt = rVar2;
        if (aVar.mTd == null) {
            cVar = com.facebook.common.memory.d.dzp();
        } else {
            cVar = aVar.mTd;
        }
        this.mTd = cVar;
        if (aVar.mVu == null) {
            rVar3 = h.dFB();
        } else {
            rVar3 = aVar.mVu;
        }
        this.mVu = rVar3;
        if (aVar.mVv == null) {
            sVar2 = n.dFG();
        } else {
            sVar2 = aVar.mVv;
        }
        this.mVv = sVar2;
        if (aVar.mVw == null) {
            rVar4 = f.dFB();
        } else {
            rVar4 = aVar.mVw;
        }
        this.mVw = rVar4;
        if (aVar.mVx == null) {
            sVar3 = n.dFG();
        } else {
            sVar3 = aVar.mVx;
        }
        this.mVx = sVar3;
    }

    public r dFJ() {
        return this.mVr;
    }

    public s dFK() {
        return this.mVs;
    }

    public com.facebook.common.memory.c dDE() {
        return this.mTd;
    }

    public r dFL() {
        return this.mVu;
    }

    public s dFM() {
        return this.mVv;
    }

    public r dFN() {
        return this.mVt;
    }

    public r dFO() {
        return this.mVw;
    }

    public s dFP() {
        return this.mVx;
    }

    public static a dFQ() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c mTd;
        private r mVr;
        private s mVs;
        private r mVt;
        private r mVu;
        private s mVv;
        private r mVw;
        private s mVx;

        private a() {
        }

        public p dFR() {
            return new p(this);
        }
    }
}
