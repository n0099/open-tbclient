package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.memory.c kkr;
    private final r kmo;
    private final s kmp;
    private final r kmq;
    private final r kmr;
    private final s kms;
    private final r kmt;
    private final s kmu;

    private p(a aVar) {
        r rVar;
        s sVar;
        r rVar2;
        com.facebook.common.memory.c cVar;
        r rVar3;
        s sVar2;
        r rVar4;
        s sVar3;
        if (aVar.kmo == null) {
            rVar = e.cLk();
        } else {
            rVar = aVar.kmo;
        }
        this.kmo = rVar;
        if (aVar.kmp == null) {
            sVar = n.cLp();
        } else {
            sVar = aVar.kmp;
        }
        this.kmp = sVar;
        if (aVar.kmq == null) {
            rVar2 = g.cLk();
        } else {
            rVar2 = aVar.kmq;
        }
        this.kmq = rVar2;
        if (aVar.kkr == null) {
            cVar = com.facebook.common.memory.d.cFP();
        } else {
            cVar = aVar.kkr;
        }
        this.kkr = cVar;
        if (aVar.kmr == null) {
            rVar3 = h.cLk();
        } else {
            rVar3 = aVar.kmr;
        }
        this.kmr = rVar3;
        if (aVar.kms == null) {
            sVar2 = n.cLp();
        } else {
            sVar2 = aVar.kms;
        }
        this.kms = sVar2;
        if (aVar.kmt == null) {
            rVar4 = f.cLk();
        } else {
            rVar4 = aVar.kmt;
        }
        this.kmt = rVar4;
        if (aVar.kmu == null) {
            sVar3 = n.cLp();
        } else {
            sVar3 = aVar.kmu;
        }
        this.kmu = sVar3;
    }

    public r cLs() {
        return this.kmo;
    }

    public s cLt() {
        return this.kmp;
    }

    public com.facebook.common.memory.c cJz() {
        return this.kkr;
    }

    public r cLu() {
        return this.kmr;
    }

    public s cLv() {
        return this.kms;
    }

    public r cLw() {
        return this.kmq;
    }

    public r cLx() {
        return this.kmt;
    }

    public s cLy() {
        return this.kmu;
    }

    public static a cLz() {
        return new a();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.memory.c kkr;
        private r kmo;
        private s kmp;
        private r kmq;
        private r kmr;
        private s kms;
        private r kmt;
        private s kmu;

        private a() {
        }

        public p cLA() {
            return new p(this);
        }
    }
}
