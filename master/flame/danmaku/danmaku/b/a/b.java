package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d neB = null;
    private d neC = null;
    private d neD = null;
    private d neE = null;

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
        wE(z);
    }

    public void wE(boolean z) {
        this.neB = z ? new a() : new C0824b();
        this.neC = z ? new a() : new C0824b();
        if (this.neD == null) {
            this.neD = new c();
        }
        if (this.neE == null) {
            this.neE = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.neB.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.neE.a(dVar, mVar, fVar);
                return;
            case 5:
                this.neD.a(dVar, mVar, fVar);
                return;
            case 6:
                this.neC.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.neB != null) {
            this.neB.clear();
        }
        if (this.neC != null) {
            this.neC.clear();
        }
        if (this.neD != null) {
            this.neD.clear();
        }
        if (this.neE != null) {
            this.neE.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int iKe;
        public master.flame.danmaku.danmaku.model.d neH;
        public master.flame.danmaku.danmaku.model.d neI;
        public boolean neK;
        public master.flame.danmaku.danmaku.model.d neP;
        public master.flame.danmaku.danmaku.model.d neQ;
        public boolean neR;
        public boolean neS;
        public master.flame.danmaku.danmaku.model.d nex;

        private e() {
            this.iKe = 0;
            this.neP = null;
            this.neI = null;
            this.nex = null;
            this.neQ = null;
            this.neH = null;
            this.neR = false;
            this.neS = false;
            this.neK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0824b implements d {
        protected master.flame.danmaku.danmaku.model.android.d neG;
        protected boolean neN;
        protected a neO;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m ney;
            int iKe = 0;
            public master.flame.danmaku.danmaku.model.d neP = null;
            public master.flame.danmaku.danmaku.model.d neI = null;
            public master.flame.danmaku.danmaku.model.d nex = null;
            public master.flame.danmaku.danmaku.model.d neQ = null;
            public master.flame.danmaku.danmaku.model.d neJ = null;
            boolean neR = false;
            boolean neS = false;
            boolean neK = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dFA() {
                this.iKe = 0;
                this.neQ = null;
                this.nex = null;
                this.neI = null;
                this.neP = null;
                this.neK = false;
                this.neS = false;
                this.neR = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bF(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0824b.this.neN) {
                    return 1;
                }
                this.iKe++;
                if (dVar == this.neJ) {
                    this.neP = dVar;
                    this.nex = null;
                    this.neS = true;
                    this.neK = false;
                    return 1;
                }
                if (this.neI == null) {
                    this.neI = dVar;
                }
                if (this.neJ.nbe + dVar.dFm() > this.ney.getHeight()) {
                    this.neR = true;
                    return 1;
                }
                if (this.neQ == null) {
                    this.neQ = dVar;
                } else if (this.neQ.dFn() >= dVar.dFn()) {
                    this.neQ = dVar;
                }
                this.neK = master.flame.danmaku.danmaku.c.b.a(this.ney, dVar, this.neJ, this.neJ.getDuration(), this.neJ.dFp().nbv);
                if (!this.neK) {
                    this.neP = dVar;
                    return 1;
                }
                this.nex = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dGm */
            public e dEA() {
                e eVar = new e();
                eVar.iKe = this.iKe;
                eVar.neI = this.neI;
                eVar.neP = this.neP;
                eVar.nex = this.nex;
                eVar.neQ = this.neQ;
                eVar.neR = this.neR;
                eVar.neS = this.neS;
                eVar.neK = this.neK;
                return eVar;
            }
        }

        private C0824b() {
            this.neG = new master.flame.danmaku.danmaku.model.android.d(1);
            this.neN = false;
            this.neO = new a();
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
            float dFG;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dFh()) {
                float dFG2 = mVar.dFG();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.neG.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.neN = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.neO.ney = mVar;
                    this.neO.neJ = dVar;
                    this.neG.a(this.neO);
                    e dEA = this.neO.dEA();
                    if (dEA == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dEA.iKe;
                        dVar6 = dEA.neP;
                        dVar3 = dEA.neI;
                        dVar5 = dEA.nex;
                        master.flame.danmaku.danmaku.model.d dVar7 = dEA.neQ;
                        z5 = dEA.neR;
                        z4 = dEA.neS;
                        z6 = dEA.neK;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dFG = dVar5.dFo() + margin;
                        } else {
                            dFG = dVar6.dFm();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dFG = dVar4.dFm();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dFG = dVar5.dFo() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dFG = dVar3.dFm();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dFG = mVar.dFG();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dFG, dVar3, dVar5);
                    }
                    if (z7) {
                        dFG = mVar.dFG();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dFG == mVar.dFG()) {
                        z2 = false;
                        dFG2 = dFG;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dFG2 = dFG;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dFG2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dFl(), dFG2);
                    if (!z2) {
                        this.neG.l(dVar2);
                        this.neG.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dFG()) || (dVar2 != null && dVar2.dFm() > 0.0f) || dVar.nbe + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.neN = true;
            this.neG.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c extends C0824b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0824b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.nbe + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0823a neF;
        protected master.flame.danmaku.danmaku.model.android.d neG;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0823a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            int iKe = 0;
            public master.flame.danmaku.danmaku.model.d neH = null;
            public master.flame.danmaku.danmaku.model.d neI = null;
            public master.flame.danmaku.danmaku.model.d neJ = null;
            boolean neK = false;
            float neL;
            public m ney;

            protected C0823a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dFA() {
                this.iKe = 0;
                this.neI = null;
                this.neH = null;
                this.neK = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bF(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.neN) {
                    return 1;
                }
                this.iKe++;
                if (dVar == this.neJ) {
                    this.neH = null;
                    this.neK = false;
                    return 1;
                }
                if (this.neI == null) {
                    this.neI = dVar;
                    if (this.neI.dFo() != this.ney.getHeight()) {
                        return 1;
                    }
                }
                if (this.neL < this.ney.dFG()) {
                    this.neH = null;
                    return 1;
                }
                this.neK = master.flame.danmaku.danmaku.c.b.a(this.ney, dVar, this.neJ, this.neJ.getDuration(), this.neJ.dFp().nbv);
                if (!this.neK) {
                    this.neH = dVar;
                    return 1;
                }
                this.neL = (dVar.dFm() - this.ney.getMargin()) - this.neJ.nbe;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dGm */
            public e dEA() {
                e eVar = new e();
                eVar.iKe = this.iKe;
                eVar.neI = this.neI;
                eVar.neH = this.neH;
                eVar.neK = this.neK;
                return eVar;
            }
        }

        private a() {
            super();
            this.neF = new C0823a();
            this.neG = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0824b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dFh()) {
                boolean isShown = dVar.isShown();
                float dFm = isShown ? dVar.dFm() : -1.0f;
                boolean z5 = (isShown || this.neG.isEmpty()) ? false : true;
                if (dFm < mVar.dFG()) {
                    dFm = mVar.getHeight() - dVar.nbe;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.neN = false;
                    this.neF.neL = dFm;
                    this.neF.ney = mVar;
                    this.neF.neJ = dVar;
                    this.neG.a(this.neF);
                    e dEA = this.neF.dEA();
                    dFm = this.neF.neL;
                    if (dEA != null) {
                        int i2 = dEA.iKe;
                        dVar3 = dEA.neI;
                        master.flame.danmaku.danmaku.model.d dVar4 = dEA.neH;
                        boolean z6 = dEA.neS;
                        z2 = dEA.neK;
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
                    boolean a = a(false, dVar, mVar, dFm, dVar3, null);
                    if (a) {
                        dFm = mVar.getHeight() - dVar.nbe;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dFm >= ((float) mVar.dFG()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dFm, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dFl(), dFm);
                    if (!z) {
                        this.neG.l(dVar2);
                        this.neG.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0824b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dFG()) || !(dVar2 == null || dVar2.dFo() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0824b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.neN = true;
            this.neG.clear();
        }
    }
}
