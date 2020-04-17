package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d ney = null;
    private d nez = null;
    private d neA = null;
    private d neB = null;

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
        this.ney = z ? new a() : new C0803b();
        this.nez = z ? new a() : new C0803b();
        if (this.neA == null) {
            this.neA = new c();
        }
        if (this.neB == null) {
            this.neB = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.ney.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.neB.a(dVar, mVar, fVar);
                return;
            case 5:
                this.neA.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nez.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.ney != null) {
            this.ney.clear();
        }
        if (this.nez != null) {
            this.nez.clear();
        }
        if (this.neA != null) {
            this.neA.clear();
        }
        if (this.neB != null) {
            this.neB.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int iKa;
        public master.flame.danmaku.danmaku.model.d neE;
        public master.flame.danmaku.danmaku.model.d neF;
        public boolean neH;
        public master.flame.danmaku.danmaku.model.d neM;
        public master.flame.danmaku.danmaku.model.d neN;
        public boolean neO;
        public boolean neP;
        public master.flame.danmaku.danmaku.model.d neu;

        private e() {
            this.iKa = 0;
            this.neM = null;
            this.neF = null;
            this.neu = null;
            this.neN = null;
            this.neE = null;
            this.neO = false;
            this.neP = false;
            this.neH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0803b implements d {
        protected master.flame.danmaku.danmaku.model.android.d neD;
        protected boolean neK;
        protected a neL;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nev;
            int iKa = 0;
            public master.flame.danmaku.danmaku.model.d neM = null;
            public master.flame.danmaku.danmaku.model.d neF = null;
            public master.flame.danmaku.danmaku.model.d neu = null;
            public master.flame.danmaku.danmaku.model.d neN = null;
            public master.flame.danmaku.danmaku.model.d neG = null;
            boolean neO = false;
            boolean neP = false;
            boolean neH = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dFD() {
                this.iKa = 0;
                this.neN = null;
                this.neu = null;
                this.neF = null;
                this.neM = null;
                this.neH = false;
                this.neP = false;
                this.neO = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0803b.this.neK) {
                    return 1;
                }
                this.iKa++;
                if (dVar == this.neG) {
                    this.neM = dVar;
                    this.neu = null;
                    this.neP = true;
                    this.neH = false;
                    return 1;
                }
                if (this.neF == null) {
                    this.neF = dVar;
                }
                if (this.neG.nbb + dVar.dFp() > this.nev.getHeight()) {
                    this.neO = true;
                    return 1;
                }
                if (this.neN == null) {
                    this.neN = dVar;
                } else if (this.neN.dFq() >= dVar.dFq()) {
                    this.neN = dVar;
                }
                this.neH = master.flame.danmaku.danmaku.c.b.a(this.nev, dVar, this.neG, this.neG.getDuration(), this.neG.dFs().nbs);
                if (!this.neH) {
                    this.neM = dVar;
                    return 1;
                }
                this.neu = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dGp */
            public e dED() {
                e eVar = new e();
                eVar.iKa = this.iKa;
                eVar.neF = this.neF;
                eVar.neM = this.neM;
                eVar.neu = this.neu;
                eVar.neN = this.neN;
                eVar.neO = this.neO;
                eVar.neP = this.neP;
                eVar.neH = this.neH;
                return eVar;
            }
        }

        private C0803b() {
            this.neD = new master.flame.danmaku.danmaku.model.android.d(1);
            this.neK = false;
            this.neL = new a();
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
            float dFJ;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dFk()) {
                float dFJ2 = mVar.dFJ();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.neD.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.neK = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.neL.nev = mVar;
                    this.neL.neG = dVar;
                    this.neD.a(this.neL);
                    e dED = this.neL.dED();
                    if (dED == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dED.iKa;
                        dVar6 = dED.neM;
                        dVar3 = dED.neF;
                        dVar5 = dED.neu;
                        master.flame.danmaku.danmaku.model.d dVar7 = dED.neN;
                        z5 = dED.neO;
                        z4 = dED.neP;
                        z6 = dED.neH;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dFJ = dVar5.dFr() + margin;
                        } else {
                            dFJ = dVar6.dFp();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dFJ = dVar4.dFp();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dFJ = dVar5.dFr() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dFJ = dVar3.dFp();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dFJ = mVar.dFJ();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dFJ, dVar3, dVar5);
                    }
                    if (z7) {
                        dFJ = mVar.dFJ();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dFJ == mVar.dFJ()) {
                        z2 = false;
                        dFJ2 = dFJ;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dFJ2 = dFJ;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dFJ2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dFo(), dFJ2);
                    if (!z2) {
                        this.neD.l(dVar2);
                        this.neD.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dFJ()) || (dVar2 != null && dVar2.dFp() > 0.0f) || dVar.nbb + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.neK = true;
            this.neD.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c extends C0803b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0803b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.nbb + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0802a neC;
        protected master.flame.danmaku.danmaku.model.android.d neD;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0802a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            int iKa = 0;
            public master.flame.danmaku.danmaku.model.d neE = null;
            public master.flame.danmaku.danmaku.model.d neF = null;
            public master.flame.danmaku.danmaku.model.d neG = null;
            boolean neH = false;
            float neI;
            public m nev;

            protected C0802a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dFD() {
                this.iKa = 0;
                this.neF = null;
                this.neE = null;
                this.neH = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.neK) {
                    return 1;
                }
                this.iKa++;
                if (dVar == this.neG) {
                    this.neE = null;
                    this.neH = false;
                    return 1;
                }
                if (this.neF == null) {
                    this.neF = dVar;
                    if (this.neF.dFr() != this.nev.getHeight()) {
                        return 1;
                    }
                }
                if (this.neI < this.nev.dFJ()) {
                    this.neE = null;
                    return 1;
                }
                this.neH = master.flame.danmaku.danmaku.c.b.a(this.nev, dVar, this.neG, this.neG.getDuration(), this.neG.dFs().nbs);
                if (!this.neH) {
                    this.neE = dVar;
                    return 1;
                }
                this.neI = (dVar.dFp() - this.nev.getMargin()) - this.neG.nbb;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dGp */
            public e dED() {
                e eVar = new e();
                eVar.iKa = this.iKa;
                eVar.neF = this.neF;
                eVar.neE = this.neE;
                eVar.neH = this.neH;
                return eVar;
            }
        }

        private a() {
            super();
            this.neC = new C0802a();
            this.neD = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0803b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dFk()) {
                boolean isShown = dVar.isShown();
                float dFp = isShown ? dVar.dFp() : -1.0f;
                boolean z5 = (isShown || this.neD.isEmpty()) ? false : true;
                if (dFp < mVar.dFJ()) {
                    dFp = mVar.getHeight() - dVar.nbb;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.neK = false;
                    this.neC.neI = dFp;
                    this.neC.nev = mVar;
                    this.neC.neG = dVar;
                    this.neD.a(this.neC);
                    e dED = this.neC.dED();
                    dFp = this.neC.neI;
                    if (dED != null) {
                        int i2 = dED.iKa;
                        dVar3 = dED.neF;
                        master.flame.danmaku.danmaku.model.d dVar4 = dED.neE;
                        boolean z6 = dED.neP;
                        z2 = dED.neH;
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
                    boolean a = a(false, dVar, mVar, dFp, dVar3, null);
                    if (a) {
                        dFp = mVar.getHeight() - dVar.nbb;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dFp >= ((float) mVar.dFJ()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dFp, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dFo(), dFp);
                    if (!z) {
                        this.neD.l(dVar2);
                        this.neD.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0803b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dFJ()) || !(dVar2 == null || dVar2.dFr() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0803b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.neK = true;
            this.neD.clear();
        }
    }
}
