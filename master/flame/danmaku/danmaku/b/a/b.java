package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public class b {
    private d ozj = null;
    private d ozk = null;
    private d ozl = null;
    private d ozm = null;

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
        yW(z);
    }

    public void yW(boolean z) {
        this.ozj = z ? new a() : new C0980b();
        this.ozk = z ? new a() : new C0980b();
        if (this.ozl == null) {
            this.ozl = new c();
        }
        if (this.ozm == null) {
            this.ozm = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.ozj.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.ozm.a(dVar, mVar, fVar);
                return;
            case 5:
                this.ozl.a(dVar, mVar, fVar);
                return;
            case 6:
                this.ozk.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.ozj != null) {
            this.ozj.clear();
        }
        if (this.ozk != null) {
            this.ozk.clear();
        }
        if (this.ozl != null) {
            this.ozl.clear();
        }
        if (this.ozm != null) {
            this.ozm.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int jPa;
        public boolean ozA;
        public master.flame.danmaku.danmaku.model.d ozf;
        public master.flame.danmaku.danmaku.model.d ozp;
        public master.flame.danmaku.danmaku.model.d ozq;
        public boolean ozs;
        public master.flame.danmaku.danmaku.model.d ozx;
        public master.flame.danmaku.danmaku.model.d ozy;
        public boolean ozz;

        private e() {
            this.jPa = 0;
            this.ozx = null;
            this.ozq = null;
            this.ozf = null;
            this.ozy = null;
            this.ozp = null;
            this.ozz = false;
            this.ozA = false;
            this.ozs = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0980b implements d {
        protected master.flame.danmaku.danmaku.model.android.d ozo;
        protected boolean ozv;
        protected a ozw;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes6.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m ozg;
            int jPa = 0;
            public master.flame.danmaku.danmaku.model.d ozx = null;
            public master.flame.danmaku.danmaku.model.d ozq = null;
            public master.flame.danmaku.danmaku.model.d ozf = null;
            public master.flame.danmaku.danmaku.model.d ozy = null;
            public master.flame.danmaku.danmaku.model.d ozr = null;
            boolean ozz = false;
            boolean ozA = false;
            boolean ozs = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void ehS() {
                this.jPa = 0;
                this.ozy = null;
                this.ozf = null;
                this.ozq = null;
                this.ozx = null;
                this.ozs = false;
                this.ozA = false;
                this.ozz = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0980b.this.ozv) {
                    return 1;
                }
                this.jPa++;
                if (dVar == this.ozr) {
                    this.ozx = dVar;
                    this.ozf = null;
                    this.ozA = true;
                    this.ozs = false;
                    return 1;
                }
                if (this.ozq == null) {
                    this.ozq = dVar;
                }
                if (this.ozr.ovP + dVar.ehE() > this.ozg.getHeight()) {
                    this.ozz = true;
                    return 1;
                }
                if (this.ozy == null) {
                    this.ozy = dVar;
                } else if (this.ozy.ehF() >= dVar.ehF()) {
                    this.ozy = dVar;
                }
                this.ozs = master.flame.danmaku.danmaku.c.b.a(this.ozg, dVar, this.ozr, this.ozr.getDuration(), this.ozr.ehH().owf);
                if (!this.ozs) {
                    this.ozx = dVar;
                    return 1;
                }
                this.ozf = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eiE */
            public e egR() {
                e eVar = new e();
                eVar.jPa = this.jPa;
                eVar.ozq = this.ozq;
                eVar.ozx = this.ozx;
                eVar.ozf = this.ozf;
                eVar.ozy = this.ozy;
                eVar.ozz = this.ozz;
                eVar.ozA = this.ozA;
                eVar.ozs = this.ozs;
                return eVar;
            }
        }

        private C0980b() {
            this.ozo = new master.flame.danmaku.danmaku.model.android.d(1);
            this.ozv = false;
            this.ozw = new a();
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
            float ehY;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.ehz()) {
                float ehY2 = mVar.ehY();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.ozo.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.ozv = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.ozw.ozg = mVar;
                    this.ozw.ozr = dVar;
                    this.ozo.a(this.ozw);
                    e egR = this.ozw.egR();
                    if (egR == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = egR.jPa;
                        dVar6 = egR.ozx;
                        dVar3 = egR.ozq;
                        dVar5 = egR.ozf;
                        master.flame.danmaku.danmaku.model.d dVar7 = egR.ozy;
                        z5 = egR.ozz;
                        z4 = egR.ozA;
                        z6 = egR.ozs;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            ehY = dVar5.ehG() + margin;
                        } else {
                            ehY = dVar6.ehE();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        ehY = dVar4.ehE();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        ehY = dVar5.ehG() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        ehY = dVar3.ehE();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        ehY = mVar.ehY();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, ehY, dVar3, dVar5);
                    }
                    if (z7) {
                        ehY = mVar.ehY();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (ehY == mVar.ehY()) {
                        z2 = false;
                        ehY2 = ehY;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        ehY2 = ehY;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, ehY2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.ehD(), ehY2);
                    if (!z2) {
                        this.ozo.l(dVar2);
                        this.ozo.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.ehY()) || (dVar2 != null && dVar2.ehE() > 0.0f) || dVar.ovP + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.ozv = true;
            this.ozo.clear();
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
            return dVar.ovP + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends c {
        protected C0979a ozn;
        protected master.flame.danmaku.danmaku.model.android.d ozo;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        protected class C0979a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m ozg;
            float ozt;
            int jPa = 0;
            public master.flame.danmaku.danmaku.model.d ozp = null;
            public master.flame.danmaku.danmaku.model.d ozq = null;
            public master.flame.danmaku.danmaku.model.d ozr = null;
            boolean ozs = false;

            protected C0979a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void ehS() {
                this.jPa = 0;
                this.ozq = null;
                this.ozp = null;
                this.ozs = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.ozv) {
                    return 1;
                }
                this.jPa++;
                if (dVar == this.ozr) {
                    this.ozp = null;
                    this.ozs = false;
                    return 1;
                }
                if (this.ozq == null) {
                    this.ozq = dVar;
                    if (this.ozq.ehG() != this.ozg.getHeight()) {
                        return 1;
                    }
                }
                if (this.ozt < this.ozg.ehY()) {
                    this.ozp = null;
                    return 1;
                }
                this.ozs = master.flame.danmaku.danmaku.c.b.a(this.ozg, dVar, this.ozr, this.ozr.getDuration(), this.ozr.ehH().owf);
                if (!this.ozs) {
                    this.ozp = dVar;
                    return 1;
                }
                this.ozt = (dVar.ehE() - this.ozg.getMargin()) - this.ozr.ovP;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eiE */
            public e egR() {
                e eVar = new e();
                eVar.jPa = this.jPa;
                eVar.ozq = this.ozq;
                eVar.ozp = this.ozp;
                eVar.ozs = this.ozs;
                return eVar;
            }
        }

        private a() {
            super();
            this.ozn = new C0979a();
            this.ozo = new master.flame.danmaku.danmaku.model.android.d(2);
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
            if (!dVar.ehz()) {
                boolean isShown = dVar.isShown();
                float ehE = isShown ? dVar.ehE() : -1.0f;
                boolean z5 = (isShown || this.ozo.isEmpty()) ? false : true;
                if (ehE < mVar.ehY()) {
                    ehE = mVar.getHeight() - dVar.ovP;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.ozv = false;
                    this.ozn.ozt = ehE;
                    this.ozn.ozg = mVar;
                    this.ozn.ozr = dVar;
                    this.ozo.a(this.ozn);
                    e egR = this.ozn.egR();
                    ehE = this.ozn.ozt;
                    if (egR != null) {
                        int i2 = egR.jPa;
                        dVar3 = egR.ozq;
                        master.flame.danmaku.danmaku.model.d dVar4 = egR.ozp;
                        boolean z6 = egR.ozA;
                        z2 = egR.ozs;
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
                    boolean a = a(false, dVar, mVar, ehE, dVar3, null);
                    if (a) {
                        ehE = mVar.getHeight() - dVar.ovP;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = ehE >= ((float) mVar.ehY()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, ehE, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.ehD(), ehE);
                    if (!z) {
                        this.ozo.l(dVar2);
                        this.ozo.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0980b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.ehY()) || !(dVar2 == null || dVar2.ehG() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0980b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.ozv = true;
            this.ozo.clear();
        }
    }
}
