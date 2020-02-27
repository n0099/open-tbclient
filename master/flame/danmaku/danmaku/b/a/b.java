package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d nIU = null;
    private d nIV = null;
    private d nIW = null;
    private d nIX = null;

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
        wR(z);
    }

    public void wR(boolean z) {
        this.nIU = z ? new a() : new C0779b();
        this.nIV = z ? new a() : new C0779b();
        if (this.nIW == null) {
            this.nIW = new c();
        }
        if (this.nIX == null) {
            this.nIX = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nIU.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nIX.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nIW.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nIV.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nIU != null) {
            this.nIU.clear();
        }
        if (this.nIV != null) {
            this.nIV.clear();
        }
        if (this.nIW != null) {
            this.nIW.clear();
        }
        if (this.nIX != null) {
            this.nIX.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int hYs;
        public master.flame.danmaku.danmaku.model.d nIQ;
        public master.flame.danmaku.danmaku.model.d nJa;
        public master.flame.danmaku.danmaku.model.d nJb;
        public boolean nJd;
        public master.flame.danmaku.danmaku.model.d nJi;
        public master.flame.danmaku.danmaku.model.d nJj;
        public boolean nJk;
        public boolean nJl;

        private e() {
            this.hYs = 0;
            this.nJi = null;
            this.nJb = null;
            this.nIQ = null;
            this.nJj = null;
            this.nJa = null;
            this.nJk = false;
            this.nJl = false;
            this.nJd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0779b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nIZ;
        protected boolean nJg;
        protected a nJh;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nIR;
            int hYs = 0;
            public master.flame.danmaku.danmaku.model.d nJi = null;
            public master.flame.danmaku.danmaku.model.d nJb = null;
            public master.flame.danmaku.danmaku.model.d nIQ = null;
            public master.flame.danmaku.danmaku.model.d nJj = null;
            public master.flame.danmaku.danmaku.model.d nJc = null;
            boolean nJk = false;
            boolean nJl = false;
            boolean nJd = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dMa() {
                this.hYs = 0;
                this.nJj = null;
                this.nIQ = null;
                this.nJb = null;
                this.nJi = null;
                this.nJd = false;
                this.nJl = false;
                this.nJk = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0779b.this.nJg) {
                    return 1;
                }
                this.hYs++;
                if (dVar == this.nJc) {
                    this.nJi = dVar;
                    this.nIQ = null;
                    this.nJl = true;
                    this.nJd = false;
                    return 1;
                }
                if (this.nJb == null) {
                    this.nJb = dVar;
                }
                if (this.nJc.nFB + dVar.dLM() > this.nIR.getHeight()) {
                    this.nJk = true;
                    return 1;
                }
                if (this.nJj == null) {
                    this.nJj = dVar;
                } else if (this.nJj.dLN() >= dVar.dLN()) {
                    this.nJj = dVar;
                }
                this.nJd = master.flame.danmaku.danmaku.c.b.a(this.nIR, dVar, this.nJc, this.nJc.getDuration(), this.nJc.dLP().nFR);
                if (!this.nJd) {
                    this.nJi = dVar;
                    return 1;
                }
                this.nIQ = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dMM */
            public e dLa() {
                e eVar = new e();
                eVar.hYs = this.hYs;
                eVar.nJb = this.nJb;
                eVar.nJi = this.nJi;
                eVar.nIQ = this.nIQ;
                eVar.nJj = this.nJj;
                eVar.nJk = this.nJk;
                eVar.nJl = this.nJl;
                eVar.nJd = this.nJd;
                return eVar;
            }
        }

        private C0779b() {
            this.nIZ = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nJg = false;
            this.nJh = new a();
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
            float dMg;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dLH()) {
                float dMg2 = mVar.dMg();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nIZ.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nJg = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nJh.nIR = mVar;
                    this.nJh.nJc = dVar;
                    this.nIZ.a(this.nJh);
                    e dLa = this.nJh.dLa();
                    if (dLa == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dLa.hYs;
                        dVar6 = dLa.nJi;
                        dVar3 = dLa.nJb;
                        dVar5 = dLa.nIQ;
                        master.flame.danmaku.danmaku.model.d dVar7 = dLa.nJj;
                        z5 = dLa.nJk;
                        z4 = dLa.nJl;
                        z6 = dLa.nJd;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dMg = dVar5.dLO() + margin;
                        } else {
                            dMg = dVar6.dLM();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dMg = dVar4.dLM();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dMg = dVar5.dLO() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dMg = dVar3.dLM();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dMg = mVar.dMg();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dMg, dVar3, dVar5);
                    }
                    if (z7) {
                        dMg = mVar.dMg();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dMg == mVar.dMg()) {
                        z2 = false;
                        dMg2 = dMg;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dMg2 = dMg;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dMg2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dLL(), dMg2);
                    if (!z2) {
                        this.nIZ.l(dVar2);
                        this.nIZ.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dMg()) || (dVar2 != null && dVar2.dLM() > 0.0f) || dVar.nFB + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nJg = true;
            this.nIZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c extends C0779b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0779b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.nFB + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0778a nIY;
        protected master.flame.danmaku.danmaku.model.android.d nIZ;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0778a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nIR;
            float nJe;
            int hYs = 0;
            public master.flame.danmaku.danmaku.model.d nJa = null;
            public master.flame.danmaku.danmaku.model.d nJb = null;
            public master.flame.danmaku.danmaku.model.d nJc = null;
            boolean nJd = false;

            protected C0778a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dMa() {
                this.hYs = 0;
                this.nJb = null;
                this.nJa = null;
                this.nJd = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nJg) {
                    return 1;
                }
                this.hYs++;
                if (dVar == this.nJc) {
                    this.nJa = null;
                    this.nJd = false;
                    return 1;
                }
                if (this.nJb == null) {
                    this.nJb = dVar;
                    if (this.nJb.dLO() != this.nIR.getHeight()) {
                        return 1;
                    }
                }
                if (this.nJe < this.nIR.dMg()) {
                    this.nJa = null;
                    return 1;
                }
                this.nJd = master.flame.danmaku.danmaku.c.b.a(this.nIR, dVar, this.nJc, this.nJc.getDuration(), this.nJc.dLP().nFR);
                if (!this.nJd) {
                    this.nJa = dVar;
                    return 1;
                }
                this.nJe = (dVar.dLM() - this.nIR.getMargin()) - this.nJc.nFB;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dMM */
            public e dLa() {
                e eVar = new e();
                eVar.hYs = this.hYs;
                eVar.nJb = this.nJb;
                eVar.nJa = this.nJa;
                eVar.nJd = this.nJd;
                return eVar;
            }
        }

        private a() {
            super();
            this.nIY = new C0778a();
            this.nIZ = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0779b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dLH()) {
                boolean isShown = dVar.isShown();
                float dLM = isShown ? dVar.dLM() : -1.0f;
                boolean z5 = (isShown || this.nIZ.isEmpty()) ? false : true;
                if (dLM < mVar.dMg()) {
                    dLM = mVar.getHeight() - dVar.nFB;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nJg = false;
                    this.nIY.nJe = dLM;
                    this.nIY.nIR = mVar;
                    this.nIY.nJc = dVar;
                    this.nIZ.a(this.nIY);
                    e dLa = this.nIY.dLa();
                    dLM = this.nIY.nJe;
                    if (dLa != null) {
                        int i2 = dLa.hYs;
                        dVar3 = dLa.nJb;
                        master.flame.danmaku.danmaku.model.d dVar4 = dLa.nJa;
                        boolean z6 = dLa.nJl;
                        z2 = dLa.nJd;
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
                    boolean a = a(false, dVar, mVar, dLM, dVar3, null);
                    if (a) {
                        dLM = mVar.getHeight() - dVar.nFB;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dLM >= ((float) mVar.dMg()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dLM, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dLL(), dLM);
                    if (!z) {
                        this.nIZ.l(dVar2);
                        this.nIZ.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0779b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dMg()) || !(dVar2 == null || dVar2.dLO() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0779b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nJg = true;
            this.nIZ.clear();
        }
    }
}
