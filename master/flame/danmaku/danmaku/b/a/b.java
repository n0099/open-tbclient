package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d nzC = null;
    private d nzD = null;
    private d nzE = null;
    private d nzF = null;

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
        xc(z);
    }

    public void xc(boolean z) {
        this.nzC = z ? new a() : new C0886b();
        this.nzD = z ? new a() : new C0886b();
        if (this.nzE == null) {
            this.nzE = new c();
        }
        if (this.nzF == null) {
            this.nzF = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nzC.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nzF.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nzE.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nzD.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nzC != null) {
            this.nzC.clear();
        }
        if (this.nzD != null) {
            this.nzD.clear();
        }
        if (this.nzE != null) {
            this.nzE.clear();
        }
        if (this.nzF != null) {
            this.nzF.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int iZe;
        public master.flame.danmaku.danmaku.model.d nzI;
        public master.flame.danmaku.danmaku.model.d nzJ;
        public boolean nzL;
        public master.flame.danmaku.danmaku.model.d nzQ;
        public master.flame.danmaku.danmaku.model.d nzR;
        public boolean nzS;
        public boolean nzT;
        public master.flame.danmaku.danmaku.model.d nzy;

        private e() {
            this.iZe = 0;
            this.nzQ = null;
            this.nzJ = null;
            this.nzy = null;
            this.nzR = null;
            this.nzI = null;
            this.nzS = false;
            this.nzT = false;
            this.nzL = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0886b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nzH;
        protected boolean nzO;
        protected a nzP;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nzz;
            int iZe = 0;
            public master.flame.danmaku.danmaku.model.d nzQ = null;
            public master.flame.danmaku.danmaku.model.d nzJ = null;
            public master.flame.danmaku.danmaku.model.d nzy = null;
            public master.flame.danmaku.danmaku.model.d nzR = null;
            public master.flame.danmaku.danmaku.model.d nzK = null;
            boolean nzS = false;
            boolean nzT = false;
            boolean nzL = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dNu() {
                this.iZe = 0;
                this.nzR = null;
                this.nzy = null;
                this.nzJ = null;
                this.nzQ = null;
                this.nzL = false;
                this.nzT = false;
                this.nzS = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0886b.this.nzO) {
                    return 1;
                }
                this.iZe++;
                if (dVar == this.nzK) {
                    this.nzQ = dVar;
                    this.nzy = null;
                    this.nzT = true;
                    this.nzL = false;
                    return 1;
                }
                if (this.nzJ == null) {
                    this.nzJ = dVar;
                }
                if (this.nzK.nwh + dVar.dNg() > this.nzz.getHeight()) {
                    this.nzS = true;
                    return 1;
                }
                if (this.nzR == null) {
                    this.nzR = dVar;
                } else if (this.nzR.dNh() >= dVar.dNh()) {
                    this.nzR = dVar;
                }
                this.nzL = master.flame.danmaku.danmaku.c.b.a(this.nzz, dVar, this.nzK, this.nzK.getDuration(), this.nzK.dNj().nwy);
                if (!this.nzL) {
                    this.nzQ = dVar;
                    return 1;
                }
                this.nzy = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dOg */
            public e dMu() {
                e eVar = new e();
                eVar.iZe = this.iZe;
                eVar.nzJ = this.nzJ;
                eVar.nzQ = this.nzQ;
                eVar.nzy = this.nzy;
                eVar.nzR = this.nzR;
                eVar.nzS = this.nzS;
                eVar.nzT = this.nzT;
                eVar.nzL = this.nzL;
                return eVar;
            }
        }

        private C0886b() {
            this.nzH = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nzO = false;
            this.nzP = new a();
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
            float dNA;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dNb()) {
                float dNA2 = mVar.dNA();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nzH.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nzO = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nzP.nzz = mVar;
                    this.nzP.nzK = dVar;
                    this.nzH.a(this.nzP);
                    e dMu = this.nzP.dMu();
                    if (dMu == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dMu.iZe;
                        dVar6 = dMu.nzQ;
                        dVar3 = dMu.nzJ;
                        dVar5 = dMu.nzy;
                        master.flame.danmaku.danmaku.model.d dVar7 = dMu.nzR;
                        z5 = dMu.nzS;
                        z4 = dMu.nzT;
                        z6 = dMu.nzL;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dNA = dVar5.dNi() + margin;
                        } else {
                            dNA = dVar6.dNg();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dNA = dVar4.dNg();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dNA = dVar5.dNi() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dNA = dVar3.dNg();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dNA = mVar.dNA();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dNA, dVar3, dVar5);
                    }
                    if (z7) {
                        dNA = mVar.dNA();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dNA == mVar.dNA()) {
                        z2 = false;
                        dNA2 = dNA;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dNA2 = dNA;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dNA2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dNf(), dNA2);
                    if (!z2) {
                        this.nzH.l(dVar2);
                        this.nzH.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dNA()) || (dVar2 != null && dVar2.dNg() > 0.0f) || dVar.nwh + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nzO = true;
            this.nzH.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c extends C0886b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0886b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.nwh + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0885a nzG;
        protected master.flame.danmaku.danmaku.model.android.d nzH;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0885a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            int iZe = 0;
            public master.flame.danmaku.danmaku.model.d nzI = null;
            public master.flame.danmaku.danmaku.model.d nzJ = null;
            public master.flame.danmaku.danmaku.model.d nzK = null;
            boolean nzL = false;
            float nzM;
            public m nzz;

            protected C0885a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dNu() {
                this.iZe = 0;
                this.nzJ = null;
                this.nzI = null;
                this.nzL = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nzO) {
                    return 1;
                }
                this.iZe++;
                if (dVar == this.nzK) {
                    this.nzI = null;
                    this.nzL = false;
                    return 1;
                }
                if (this.nzJ == null) {
                    this.nzJ = dVar;
                    if (this.nzJ.dNi() != this.nzz.getHeight()) {
                        return 1;
                    }
                }
                if (this.nzM < this.nzz.dNA()) {
                    this.nzI = null;
                    return 1;
                }
                this.nzL = master.flame.danmaku.danmaku.c.b.a(this.nzz, dVar, this.nzK, this.nzK.getDuration(), this.nzK.dNj().nwy);
                if (!this.nzL) {
                    this.nzI = dVar;
                    return 1;
                }
                this.nzM = (dVar.dNg() - this.nzz.getMargin()) - this.nzK.nwh;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dOg */
            public e dMu() {
                e eVar = new e();
                eVar.iZe = this.iZe;
                eVar.nzJ = this.nzJ;
                eVar.nzI = this.nzI;
                eVar.nzL = this.nzL;
                return eVar;
            }
        }

        private a() {
            super();
            this.nzG = new C0885a();
            this.nzH = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0886b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dNb()) {
                boolean isShown = dVar.isShown();
                float dNg = isShown ? dVar.dNg() : -1.0f;
                boolean z5 = (isShown || this.nzH.isEmpty()) ? false : true;
                if (dNg < mVar.dNA()) {
                    dNg = mVar.getHeight() - dVar.nwh;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nzO = false;
                    this.nzG.nzM = dNg;
                    this.nzG.nzz = mVar;
                    this.nzG.nzK = dVar;
                    this.nzH.a(this.nzG);
                    e dMu = this.nzG.dMu();
                    dNg = this.nzG.nzM;
                    if (dMu != null) {
                        int i2 = dMu.iZe;
                        dVar3 = dMu.nzJ;
                        master.flame.danmaku.danmaku.model.d dVar4 = dMu.nzI;
                        boolean z6 = dMu.nzT;
                        z2 = dMu.nzL;
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
                    boolean a = a(false, dVar, mVar, dNg, dVar3, null);
                    if (a) {
                        dNg = mVar.getHeight() - dVar.nwh;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dNg >= ((float) mVar.dNA()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dNg, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dNf(), dNg);
                    if (!z) {
                        this.nzH.l(dVar2);
                        this.nzH.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0886b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dNA()) || !(dVar2 == null || dVar2.dNi() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0886b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nzO = true;
            this.nzH.clear();
        }
    }
}
