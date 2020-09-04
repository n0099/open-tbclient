package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public class b {
    private d ozB = null;
    private d ozC = null;
    private d ozD = null;
    private d ozE = null;

    /* loaded from: classes6.dex */
    public interface d {
        void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar);

        void clear();
    }

    /* loaded from: classes6.dex */
    public interface f {
        boolean a(master.flame.danmaku.danmaku.model.d dVar, float f, int i, boolean z);
    }

    public b(boolean z) {
        yY(z);
    }

    public void yY(boolean z) {
        this.ozB = z ? new a() : new C0980b();
        this.ozC = z ? new a() : new C0980b();
        if (this.ozD == null) {
            this.ozD = new c();
        }
        if (this.ozE == null) {
            this.ozE = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.ozB.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.ozE.a(dVar, mVar, fVar);
                return;
            case 5:
                this.ozD.a(dVar, mVar, fVar);
                return;
            case 6:
                this.ozC.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.ozB != null) {
            this.ozB.clear();
        }
        if (this.ozC != null) {
            this.ozC.clear();
        }
        if (this.ozD != null) {
            this.ozD.clear();
        }
        if (this.ozE != null) {
            this.ozE.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int jPg;
        public master.flame.danmaku.danmaku.model.d ozH;
        public master.flame.danmaku.danmaku.model.d ozI;
        public boolean ozK;
        public master.flame.danmaku.danmaku.model.d ozP;
        public master.flame.danmaku.danmaku.model.d ozQ;
        public boolean ozR;
        public boolean ozS;
        public master.flame.danmaku.danmaku.model.d ozx;

        private e() {
            this.jPg = 0;
            this.ozP = null;
            this.ozI = null;
            this.ozx = null;
            this.ozQ = null;
            this.ozH = null;
            this.ozR = false;
            this.ozS = false;
            this.ozK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0980b implements d {
        protected master.flame.danmaku.danmaku.model.android.d ozG;
        protected boolean ozN;
        protected a ozO;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes6.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m ozy;
            int jPg = 0;
            public master.flame.danmaku.danmaku.model.d ozP = null;
            public master.flame.danmaku.danmaku.model.d ozI = null;
            public master.flame.danmaku.danmaku.model.d ozx = null;
            public master.flame.danmaku.danmaku.model.d ozQ = null;
            public master.flame.danmaku.danmaku.model.d ozJ = null;
            boolean ozR = false;
            boolean ozS = false;
            boolean ozK = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void eib() {
                this.jPg = 0;
                this.ozQ = null;
                this.ozx = null;
                this.ozI = null;
                this.ozP = null;
                this.ozK = false;
                this.ozS = false;
                this.ozR = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0980b.this.ozN) {
                    return 1;
                }
                this.jPg++;
                if (dVar == this.ozJ) {
                    this.ozP = dVar;
                    this.ozx = null;
                    this.ozS = true;
                    this.ozK = false;
                    return 1;
                }
                if (this.ozI == null) {
                    this.ozI = dVar;
                }
                if (this.ozJ.owh + dVar.ehN() > this.ozy.getHeight()) {
                    this.ozR = true;
                    return 1;
                }
                if (this.ozQ == null) {
                    this.ozQ = dVar;
                } else if (this.ozQ.ehO() >= dVar.ehO()) {
                    this.ozQ = dVar;
                }
                this.ozK = master.flame.danmaku.danmaku.c.b.a(this.ozy, dVar, this.ozJ, this.ozJ.getDuration(), this.ozJ.ehQ().owx);
                if (!this.ozK) {
                    this.ozP = dVar;
                    return 1;
                }
                this.ozx = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eiN */
            public e eha() {
                e eVar = new e();
                eVar.jPg = this.jPg;
                eVar.ozI = this.ozI;
                eVar.ozP = this.ozP;
                eVar.ozx = this.ozx;
                eVar.ozQ = this.ozQ;
                eVar.ozR = this.ozR;
                eVar.ozS = this.ozS;
                eVar.ozK = this.ozK;
                return eVar;
            }
        }

        private C0980b() {
            this.ozG = new master.flame.danmaku.danmaku.model.android.d(1);
            this.ozN = false;
            this.ozO = new a();
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
            float eih;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.ehI()) {
                float eih2 = mVar.eih();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.ozG.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.ozN = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.ozO.ozy = mVar;
                    this.ozO.ozJ = dVar;
                    this.ozG.a(this.ozO);
                    e eha = this.ozO.eha();
                    if (eha == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = eha.jPg;
                        dVar6 = eha.ozP;
                        dVar3 = eha.ozI;
                        dVar5 = eha.ozx;
                        master.flame.danmaku.danmaku.model.d dVar7 = eha.ozQ;
                        z5 = eha.ozR;
                        z4 = eha.ozS;
                        z6 = eha.ozK;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            eih = dVar5.ehP() + margin;
                        } else {
                            eih = dVar6.ehN();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        eih = dVar4.ehN();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        eih = dVar5.ehP() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        eih = dVar3.ehN();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        eih = mVar.eih();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, eih, dVar3, dVar5);
                    }
                    if (z7) {
                        eih = mVar.eih();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (eih == mVar.eih()) {
                        z2 = false;
                        eih2 = eih;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        eih2 = eih;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, eih2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.ehM(), eih2);
                    if (!z2) {
                        this.ozG.l(dVar2);
                        this.ozG.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.eih()) || (dVar2 != null && dVar2.ehN() > 0.0f) || dVar.owh + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.ozN = true;
            this.ozG.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c extends C0980b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0980b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.owh + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends c {
        protected C0979a ozF;
        protected master.flame.danmaku.danmaku.model.android.d ozG;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        protected class C0979a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            int jPg = 0;
            public master.flame.danmaku.danmaku.model.d ozH = null;
            public master.flame.danmaku.danmaku.model.d ozI = null;
            public master.flame.danmaku.danmaku.model.d ozJ = null;
            boolean ozK = false;
            float ozL;
            public m ozy;

            protected C0979a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void eib() {
                this.jPg = 0;
                this.ozI = null;
                this.ozH = null;
                this.ozK = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.ozN) {
                    return 1;
                }
                this.jPg++;
                if (dVar == this.ozJ) {
                    this.ozH = null;
                    this.ozK = false;
                    return 1;
                }
                if (this.ozI == null) {
                    this.ozI = dVar;
                    if (this.ozI.ehP() != this.ozy.getHeight()) {
                        return 1;
                    }
                }
                if (this.ozL < this.ozy.eih()) {
                    this.ozH = null;
                    return 1;
                }
                this.ozK = master.flame.danmaku.danmaku.c.b.a(this.ozy, dVar, this.ozJ, this.ozJ.getDuration(), this.ozJ.ehQ().owx);
                if (!this.ozK) {
                    this.ozH = dVar;
                    return 1;
                }
                this.ozL = (dVar.ehN() - this.ozy.getMargin()) - this.ozJ.owh;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eiN */
            public e eha() {
                e eVar = new e();
                eVar.jPg = this.jPg;
                eVar.ozI = this.ozI;
                eVar.ozH = this.ozH;
                eVar.ozK = this.ozK;
                return eVar;
            }
        }

        private a() {
            super();
            this.ozF = new C0979a();
            this.ozG = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0980b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.ehI()) {
                boolean isShown = dVar.isShown();
                float ehN = isShown ? dVar.ehN() : -1.0f;
                boolean z5 = (isShown || this.ozG.isEmpty()) ? false : true;
                if (ehN < mVar.eih()) {
                    ehN = mVar.getHeight() - dVar.owh;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.ozN = false;
                    this.ozF.ozL = ehN;
                    this.ozF.ozy = mVar;
                    this.ozF.ozJ = dVar;
                    this.ozG.a(this.ozF);
                    e eha = this.ozF.eha();
                    ehN = this.ozF.ozL;
                    if (eha != null) {
                        int i2 = eha.jPg;
                        dVar3 = eha.ozI;
                        master.flame.danmaku.danmaku.model.d dVar4 = eha.ozH;
                        boolean z6 = eha.ozS;
                        z2 = eha.ozK;
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
                    boolean a = a(false, dVar, mVar, ehN, dVar3, null);
                    if (a) {
                        ehN = mVar.getHeight() - dVar.owh;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = ehN >= ((float) mVar.eih()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, ehN, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.ehM(), ehN);
                    if (!z) {
                        this.ozG.l(dVar2);
                        this.ozG.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0980b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.eih()) || !(dVar2 == null || dVar2.ehP() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0980b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.ozN = true;
            this.ozG.clear();
        }
    }
}
