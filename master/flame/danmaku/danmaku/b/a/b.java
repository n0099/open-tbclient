package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d nIW = null;
    private d nIX = null;
    private d nIY = null;
    private d nIZ = null;

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
        this.nIW = z ? new a() : new C0779b();
        this.nIX = z ? new a() : new C0779b();
        if (this.nIY == null) {
            this.nIY = new c();
        }
        if (this.nIZ == null) {
            this.nIZ = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nIW.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nIZ.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nIY.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nIX.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nIW != null) {
            this.nIW.clear();
        }
        if (this.nIX != null) {
            this.nIX.clear();
        }
        if (this.nIY != null) {
            this.nIY.clear();
        }
        if (this.nIZ != null) {
            this.nIZ.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int hYu;
        public master.flame.danmaku.danmaku.model.d nIS;
        public master.flame.danmaku.danmaku.model.d nJc;
        public master.flame.danmaku.danmaku.model.d nJd;
        public boolean nJf;
        public master.flame.danmaku.danmaku.model.d nJk;
        public master.flame.danmaku.danmaku.model.d nJl;
        public boolean nJm;
        public boolean nJn;

        private e() {
            this.hYu = 0;
            this.nJk = null;
            this.nJd = null;
            this.nIS = null;
            this.nJl = null;
            this.nJc = null;
            this.nJm = false;
            this.nJn = false;
            this.nJf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0779b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nJb;
        protected boolean nJi;
        protected a nJj;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nIT;
            int hYu = 0;
            public master.flame.danmaku.danmaku.model.d nJk = null;
            public master.flame.danmaku.danmaku.model.d nJd = null;
            public master.flame.danmaku.danmaku.model.d nIS = null;
            public master.flame.danmaku.danmaku.model.d nJl = null;
            public master.flame.danmaku.danmaku.model.d nJe = null;
            boolean nJm = false;
            boolean nJn = false;
            boolean nJf = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dMc() {
                this.hYu = 0;
                this.nJl = null;
                this.nIS = null;
                this.nJd = null;
                this.nJk = null;
                this.nJf = false;
                this.nJn = false;
                this.nJm = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0779b.this.nJi) {
                    return 1;
                }
                this.hYu++;
                if (dVar == this.nJe) {
                    this.nJk = dVar;
                    this.nIS = null;
                    this.nJn = true;
                    this.nJf = false;
                    return 1;
                }
                if (this.nJd == null) {
                    this.nJd = dVar;
                }
                if (this.nJe.nFD + dVar.dLO() > this.nIT.getHeight()) {
                    this.nJm = true;
                    return 1;
                }
                if (this.nJl == null) {
                    this.nJl = dVar;
                } else if (this.nJl.dLP() >= dVar.dLP()) {
                    this.nJl = dVar;
                }
                this.nJf = master.flame.danmaku.danmaku.c.b.a(this.nIT, dVar, this.nJe, this.nJe.getDuration(), this.nJe.dLR().nFT);
                if (!this.nJf) {
                    this.nJk = dVar;
                    return 1;
                }
                this.nIS = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dMO */
            public e dLc() {
                e eVar = new e();
                eVar.hYu = this.hYu;
                eVar.nJd = this.nJd;
                eVar.nJk = this.nJk;
                eVar.nIS = this.nIS;
                eVar.nJl = this.nJl;
                eVar.nJm = this.nJm;
                eVar.nJn = this.nJn;
                eVar.nJf = this.nJf;
                return eVar;
            }
        }

        private C0779b() {
            this.nJb = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nJi = false;
            this.nJj = new a();
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
            float dMi;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dLJ()) {
                float dMi2 = mVar.dMi();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nJb.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nJi = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nJj.nIT = mVar;
                    this.nJj.nJe = dVar;
                    this.nJb.a(this.nJj);
                    e dLc = this.nJj.dLc();
                    if (dLc == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dLc.hYu;
                        dVar6 = dLc.nJk;
                        dVar3 = dLc.nJd;
                        dVar5 = dLc.nIS;
                        master.flame.danmaku.danmaku.model.d dVar7 = dLc.nJl;
                        z5 = dLc.nJm;
                        z4 = dLc.nJn;
                        z6 = dLc.nJf;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dMi = dVar5.dLQ() + margin;
                        } else {
                            dMi = dVar6.dLO();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dMi = dVar4.dLO();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dMi = dVar5.dLQ() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dMi = dVar3.dLO();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dMi = mVar.dMi();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dMi, dVar3, dVar5);
                    }
                    if (z7) {
                        dMi = mVar.dMi();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dMi == mVar.dMi()) {
                        z2 = false;
                        dMi2 = dMi;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dMi2 = dMi;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dMi2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dLN(), dMi2);
                    if (!z2) {
                        this.nJb.l(dVar2);
                        this.nJb.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dMi()) || (dVar2 != null && dVar2.dLO() > 0.0f) || dVar.nFD + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nJi = true;
            this.nJb.clear();
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
            return dVar.nFD + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0778a nJa;
        protected master.flame.danmaku.danmaku.model.android.d nJb;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0778a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nIT;
            float nJg;
            int hYu = 0;
            public master.flame.danmaku.danmaku.model.d nJc = null;
            public master.flame.danmaku.danmaku.model.d nJd = null;
            public master.flame.danmaku.danmaku.model.d nJe = null;
            boolean nJf = false;

            protected C0778a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dMc() {
                this.hYu = 0;
                this.nJd = null;
                this.nJc = null;
                this.nJf = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nJi) {
                    return 1;
                }
                this.hYu++;
                if (dVar == this.nJe) {
                    this.nJc = null;
                    this.nJf = false;
                    return 1;
                }
                if (this.nJd == null) {
                    this.nJd = dVar;
                    if (this.nJd.dLQ() != this.nIT.getHeight()) {
                        return 1;
                    }
                }
                if (this.nJg < this.nIT.dMi()) {
                    this.nJc = null;
                    return 1;
                }
                this.nJf = master.flame.danmaku.danmaku.c.b.a(this.nIT, dVar, this.nJe, this.nJe.getDuration(), this.nJe.dLR().nFT);
                if (!this.nJf) {
                    this.nJc = dVar;
                    return 1;
                }
                this.nJg = (dVar.dLO() - this.nIT.getMargin()) - this.nJe.nFD;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dMO */
            public e dLc() {
                e eVar = new e();
                eVar.hYu = this.hYu;
                eVar.nJd = this.nJd;
                eVar.nJc = this.nJc;
                eVar.nJf = this.nJf;
                return eVar;
            }
        }

        private a() {
            super();
            this.nJa = new C0778a();
            this.nJb = new master.flame.danmaku.danmaku.model.android.d(2);
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
            if (!dVar.dLJ()) {
                boolean isShown = dVar.isShown();
                float dLO = isShown ? dVar.dLO() : -1.0f;
                boolean z5 = (isShown || this.nJb.isEmpty()) ? false : true;
                if (dLO < mVar.dMi()) {
                    dLO = mVar.getHeight() - dVar.nFD;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nJi = false;
                    this.nJa.nJg = dLO;
                    this.nJa.nIT = mVar;
                    this.nJa.nJe = dVar;
                    this.nJb.a(this.nJa);
                    e dLc = this.nJa.dLc();
                    dLO = this.nJa.nJg;
                    if (dLc != null) {
                        int i2 = dLc.hYu;
                        dVar3 = dLc.nJd;
                        master.flame.danmaku.danmaku.model.d dVar4 = dLc.nJc;
                        boolean z6 = dLc.nJn;
                        z2 = dLc.nJf;
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
                    boolean a = a(false, dVar, mVar, dLO, dVar3, null);
                    if (a) {
                        dLO = mVar.getHeight() - dVar.nFD;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dLO >= ((float) mVar.dMi()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dLO, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dLN(), dLO);
                    if (!z) {
                        this.nJb.l(dVar2);
                        this.nJb.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0779b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dMi()) || !(dVar2 == null || dVar2.dLQ() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0779b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nJi = true;
            this.nJb.clear();
        }
    }
}
