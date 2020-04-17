package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class p {
    private final com.facebook.common.memory.c mbT;
    private final r mec;
    private final s med;
    private final r mee;
    private final r mef;
    private final s meg;
    private final r meh;
    private final s mei;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.mec == null) {
            rVar = e.dts();
        } else {
            rVar = aVar.mec;
        }
        this.mec = rVar;
        if (aVar.med == null) {
            sVar = n.dtx();
        } else {
            sVar = aVar.med;
        }
        this.med = sVar;
        if (aVar.mee == null) {
            rVar2 = g.dts();
        } else {
            rVar2 = aVar.mee;
        }
        this.mee = rVar2;
        if (aVar.mbT == null) {
            cVar = com.facebook.common.memory.d.dnd();
        } else {
            cVar = aVar.mbT;
        }
        this.mbT = cVar;
        if (aVar.mef == null) {
            rVar3 = h.dts();
        } else {
            rVar3 = aVar.mef;
        }
        this.mef = rVar3;
        if (aVar.meg == null) {
            sVar2 = n.dtx();
        } else {
            sVar2 = aVar.meg;
        }
        this.meg = sVar2;
        if (aVar.meh == null) {
            rVar4 = f.dts();
        } else {
            rVar4 = aVar.meh;
        }
        this.meh = rVar4;
        if (aVar.mei == null) {
            sVar3 = n.dtx();
        } else {
            sVar3 = aVar.mei;
        }
        this.mei = sVar3;
    }

    public r dtA() {
        return this.mec;
    }

    public s dtB() {
        return this.med;
    }

    public com.facebook.common.memory.c dru() {
        return this.mbT;
    }

    public r dtC() {
        return this.mef;
    }

    public s dtD() {
        return this.meg;
    }

    public r dtE() {
        return this.mee;
    }

    public r dtF() {
        return this.meh;
    }

    public s dtG() {
        return this.mei;
    }

    public static a dtH() {
        return new a();
    }

    /* loaded from: classes12.dex */
    public static class a {
        private com.facebook.common.memory.c mbT;
        private r mec;
        private s med;
        private r mee;
        private r mef;
        private s meg;
        private r meh;
        private s mei;

        private a() {
        }

        public p dtI() {
            return new p(this);
        }
    }
}
