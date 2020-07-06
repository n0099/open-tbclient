package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d nWA = null;
    private d nWB = null;
    private d nWC = null;
    private d nWD = null;

    /* loaded from: classes5.dex */
    public interface d {
        void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar);

        void clear();
    }

    /* loaded from: classes5.dex */
    public interface f {
        boolean a(master.flame.danmaku.danmaku.model.d dVar, float f, int i, boolean z);
    }

    public b(boolean z) {
        xz(z);
    }

    public void xz(boolean z) {
        this.nWA = z ? new a() : new C0907b();
        this.nWB = z ? new a() : new C0907b();
        if (this.nWC == null) {
            this.nWC = new c();
        }
        if (this.nWD == null) {
            this.nWD = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nWA.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nWD.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nWC.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nWB.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nWA != null) {
            this.nWA.clear();
        }
        if (this.nWB != null) {
            this.nWB.clear();
        }
        if (this.nWC != null) {
            this.nWC.clear();
        }
        if (this.nWD != null) {
            this.nWD.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int jrb;
        public master.flame.danmaku.danmaku.model.d nWG;
        public master.flame.danmaku.danmaku.model.d nWH;
        public boolean nWJ;
        public master.flame.danmaku.danmaku.model.d nWO;
        public master.flame.danmaku.danmaku.model.d nWP;
        public boolean nWQ;
        public boolean nWR;
        public master.flame.danmaku.danmaku.model.d nWw;

        private e() {
            this.jrb = 0;
            this.nWO = null;
            this.nWH = null;
            this.nWw = null;
            this.nWP = null;
            this.nWG = null;
            this.nWQ = false;
            this.nWR = false;
            this.nWJ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0907b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nWF;
        protected boolean nWM;
        protected a nWN;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nWx;
            int jrb = 0;
            public master.flame.danmaku.danmaku.model.d nWO = null;
            public master.flame.danmaku.danmaku.model.d nWH = null;
            public master.flame.danmaku.danmaku.model.d nWw = null;
            public master.flame.danmaku.danmaku.model.d nWP = null;
            public master.flame.danmaku.danmaku.model.d nWI = null;
            boolean nWQ = false;
            boolean nWR = false;
            boolean nWJ = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dSs() {
                this.jrb = 0;
                this.nWP = null;
                this.nWw = null;
                this.nWH = null;
                this.nWO = null;
                this.nWJ = false;
                this.nWR = false;
                this.nWQ = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0907b.this.nWM) {
                    return 1;
                }
                this.jrb++;
                if (dVar == this.nWI) {
                    this.nWO = dVar;
                    this.nWw = null;
                    this.nWR = true;
                    this.nWJ = false;
                    return 1;
                }
                if (this.nWH == null) {
                    this.nWH = dVar;
                }
                if (this.nWI.nTg + dVar.dSe() > this.nWx.getHeight()) {
                    this.nWQ = true;
                    return 1;
                }
                if (this.nWP == null) {
                    this.nWP = dVar;
                } else if (this.nWP.dSf() >= dVar.dSf()) {
                    this.nWP = dVar;
                }
                this.nWJ = master.flame.danmaku.danmaku.c.b.a(this.nWx, dVar, this.nWI, this.nWI.getDuration(), this.nWI.dSh().nTw);
                if (!this.nWJ) {
                    this.nWO = dVar;
                    return 1;
                }
                this.nWw = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dTe */
            public e dRs() {
                e eVar = new e();
                eVar.jrb = this.jrb;
                eVar.nWH = this.nWH;
                eVar.nWO = this.nWO;
                eVar.nWw = this.nWw;
                eVar.nWP = this.nWP;
                eVar.nWQ = this.nWQ;
                eVar.nWR = this.nWR;
                eVar.nWJ = this.nWJ;
                return eVar;
            }
        }

        private C0907b() {
            this.nWF = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nWM = false;
            this.nWN = new a();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar2;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            master.flame.danmaku.danmaku.model.d dVar3;
            int i;
            master.flame.danmaku.danmaku.model.d dVar4;
            master.flame.danmaku.danmaku.model.d dVar5;
            boolean z6;
            float dSy;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dRZ()) {
                float dSy2 = mVar.dSy();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nWF.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nWM = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nWN.nWx = mVar;
                    this.nWN.nWI = dVar;
                    this.nWF.a(this.nWN);
                    e dRs = this.nWN.dRs();
                    if (dRs == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dRs.jrb;
                        dVar6 = dRs.nWO;
                        dVar3 = dRs.nWH;
                        dVar5 = dRs.nWw;
                        master.flame.danmaku.danmaku.model.d dVar7 = dRs.nWP;
                        z5 = dRs.nWQ;
                        z4 = dRs.nWR;
                        z6 = dRs.nWJ;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dSy = dVar5.dSg() + margin;
                        } else {
                            dSy = dVar6.dSe();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dSy = dVar4.dSe();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dSy = dVar5.dSg() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dSy = dVar3.dSe();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dSy = mVar.dSy();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dSy, dVar3, dVar5);
                    }
                    if (z7) {
                        dSy = mVar.dSy();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dSy == mVar.dSy()) {
                        z2 = false;
                        dSy2 = dSy;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dSy2 = dSy;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dSy2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dSd(), dSy2);
                    if (!z2) {
                        this.nWF.l(dVar2);
                        this.nWF.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dSy()) || (dVar2 != null && dVar2.dSe() > 0.0f) || dVar.nTg + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nWM = true;
            this.nWF.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c extends C0907b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0907b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.nTg + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0906a nWE;
        protected master.flame.danmaku.danmaku.model.android.d nWF;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0906a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            int jrb = 0;
            public master.flame.danmaku.danmaku.model.d nWG = null;
            public master.flame.danmaku.danmaku.model.d nWH = null;
            public master.flame.danmaku.danmaku.model.d nWI = null;
            boolean nWJ = false;
            float nWK;
            public m nWx;

            protected C0906a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dSs() {
                this.jrb = 0;
                this.nWH = null;
                this.nWG = null;
                this.nWJ = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nWM) {
                    return 1;
                }
                this.jrb++;
                if (dVar == this.nWI) {
                    this.nWG = null;
                    this.nWJ = false;
                    return 1;
                }
                if (this.nWH == null) {
                    this.nWH = dVar;
                    if (this.nWH.dSg() != this.nWx.getHeight()) {
                        return 1;
                    }
                }
                if (this.nWK < this.nWx.dSy()) {
                    this.nWG = null;
                    return 1;
                }
                this.nWJ = master.flame.danmaku.danmaku.c.b.a(this.nWx, dVar, this.nWI, this.nWI.getDuration(), this.nWI.dSh().nTw);
                if (!this.nWJ) {
                    this.nWG = dVar;
                    return 1;
                }
                this.nWK = (dVar.dSe() - this.nWx.getMargin()) - this.nWI.nTg;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dTe */
            public e dRs() {
                e eVar = new e();
                eVar.jrb = this.jrb;
                eVar.nWH = this.nWH;
                eVar.nWG = this.nWG;
                eVar.nWJ = this.nWJ;
                return eVar;
            }
        }

        private a() {
            super();
            this.nWE = new C0906a();
            this.nWF = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0907b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dRZ()) {
                boolean isShown = dVar.isShown();
                float dSe = isShown ? dVar.dSe() : -1.0f;
                boolean z5 = (isShown || this.nWF.isEmpty()) ? false : true;
                if (dSe < mVar.dSy()) {
                    dSe = mVar.getHeight() - dVar.nTg;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nWM = false;
                    this.nWE.nWK = dSe;
                    this.nWE.nWx = mVar;
                    this.nWE.nWI = dVar;
                    this.nWF.a(this.nWE);
                    e dRs = this.nWE.dRs();
                    dSe = this.nWE.nWK;
                    if (dRs != null) {
                        int i2 = dRs.jrb;
                        dVar3 = dRs.nWH;
                        master.flame.danmaku.danmaku.model.d dVar4 = dRs.nWG;
                        boolean z6 = dRs.nWR;
                        z2 = dRs.nWJ;
                        i = i2;
                        z = z6;
                        dVar2 = dVar4;
                    } else {
                        dVar3 = null;
                        dVar2 = null;
                        z2 = z5;
                        i = 0;
                        z = isShown;
                    }
                    boolean a = a(false, dVar, mVar, dSe, dVar3, null);
                    if (a) {
                        dSe = mVar.getHeight() - dVar.nTg;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dSe >= ((float) mVar.dSy()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dSe, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dSd(), dSe);
                    if (!z) {
                        this.nWF.l(dVar2);
                        this.nWF.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0907b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dSy()) || !(dVar2 == null || dVar2.dSg() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0907b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nWM = true;
            this.nWF.clear();
        }
    }
}
