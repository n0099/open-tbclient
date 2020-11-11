package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public class b {
    private d pZk = null;
    private d pZl = null;
    private d pZm = null;
    private d pZn = null;

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
        Bg(z);
    }

    public void Bg(boolean z) {
        this.pZk = z ? new a() : new C1087b();
        this.pZl = z ? new a() : new C1087b();
        if (this.pZm == null) {
            this.pZm = new c();
        }
        if (this.pZn == null) {
            this.pZn = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.pZk.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.pZn.a(dVar, mVar, fVar);
                return;
            case 5:
                this.pZm.a(dVar, mVar, fVar);
                return;
            case 6:
                this.pZl.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.pZk != null) {
            this.pZk.clear();
        }
        if (this.pZl != null) {
            this.pZl.clear();
        }
        if (this.pZm != null) {
            this.pZm.clear();
        }
        if (this.pZn != null) {
            this.pZn.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int kFq;
        public boolean pZA;
        public boolean pZB;
        public master.flame.danmaku.danmaku.model.d pZg;
        public master.flame.danmaku.danmaku.model.d pZq;
        public master.flame.danmaku.danmaku.model.d pZr;
        public boolean pZt;
        public master.flame.danmaku.danmaku.model.d pZy;
        public master.flame.danmaku.danmaku.model.d pZz;

        private e() {
            this.kFq = 0;
            this.pZy = null;
            this.pZr = null;
            this.pZg = null;
            this.pZz = null;
            this.pZq = null;
            this.pZA = false;
            this.pZB = false;
            this.pZt = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1087b implements d {
        protected master.flame.danmaku.danmaku.model.android.d pZp;
        protected boolean pZw;
        protected a pZx;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes6.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m pZh;
            int kFq = 0;
            public master.flame.danmaku.danmaku.model.d pZy = null;
            public master.flame.danmaku.danmaku.model.d pZr = null;
            public master.flame.danmaku.danmaku.model.d pZg = null;
            public master.flame.danmaku.danmaku.model.d pZz = null;
            public master.flame.danmaku.danmaku.model.d pZs = null;
            boolean pZA = false;
            boolean pZB = false;
            boolean pZt = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void eDy() {
                this.kFq = 0;
                this.pZz = null;
                this.pZg = null;
                this.pZr = null;
                this.pZy = null;
                this.pZt = false;
                this.pZB = false;
                this.pZA = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                if (C1087b.this.pZw) {
                    return 1;
                }
                this.kFq++;
                if (dVar == this.pZs) {
                    this.pZy = dVar;
                    this.pZg = null;
                    this.pZB = true;
                    this.pZt = false;
                    return 1;
                }
                if (this.pZr == null) {
                    this.pZr = dVar;
                }
                if (this.pZs.pVS + dVar.eDk() > this.pZh.getHeight()) {
                    this.pZA = true;
                    return 1;
                }
                if (this.pZz == null) {
                    this.pZz = dVar;
                } else if (this.pZz.eDl() >= dVar.eDl()) {
                    this.pZz = dVar;
                }
                this.pZt = master.flame.danmaku.danmaku.c.b.a(this.pZh, dVar, this.pZs, this.pZs.getDuration(), this.pZs.eDn().pWi);
                if (!this.pZt) {
                    this.pZy = dVar;
                    return 1;
                }
                this.pZg = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eEk */
            public e eCx() {
                e eVar = new e();
                eVar.kFq = this.kFq;
                eVar.pZr = this.pZr;
                eVar.pZy = this.pZy;
                eVar.pZg = this.pZg;
                eVar.pZz = this.pZz;
                eVar.pZA = this.pZA;
                eVar.pZB = this.pZB;
                eVar.pZt = this.pZt;
                return eVar;
            }
        }

        private C1087b() {
            this.pZp = new master.flame.danmaku.danmaku.model.android.d(1);
            this.pZw = false;
            this.pZx = new a();
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
            float eDE;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.eDf()) {
                float eDE2 = mVar.eDE();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.pZp.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.pZw = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.pZx.pZh = mVar;
                    this.pZx.pZs = dVar;
                    this.pZp.a(this.pZx);
                    e eCx = this.pZx.eCx();
                    if (eCx == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = eCx.kFq;
                        dVar6 = eCx.pZy;
                        dVar3 = eCx.pZr;
                        dVar5 = eCx.pZg;
                        master.flame.danmaku.danmaku.model.d dVar7 = eCx.pZz;
                        z5 = eCx.pZA;
                        z4 = eCx.pZB;
                        z6 = eCx.pZt;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            eDE = dVar5.eDm() + margin;
                        } else {
                            eDE = dVar6.eDk();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        eDE = dVar4.eDk();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        eDE = dVar5.eDm() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        eDE = dVar3.eDk();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        eDE = mVar.eDE();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, eDE, dVar3, dVar5);
                    }
                    if (z7) {
                        eDE = mVar.eDE();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (eDE == mVar.eDE()) {
                        z2 = false;
                        eDE2 = eDE;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        eDE2 = eDE;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, eDE2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.eDj(), eDE2);
                    if (!z2) {
                        this.pZp.l(dVar2);
                        this.pZp.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.eDE()) || (dVar2 != null && dVar2.eDk() > 0.0f) || dVar.pVS + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.pZw = true;
            this.pZp.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c extends C1087b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C1087b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.pVS + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends c {
        protected C1086a pZo;
        protected master.flame.danmaku.danmaku.model.android.d pZp;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        protected class C1086a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m pZh;
            float pZu;
            int kFq = 0;
            public master.flame.danmaku.danmaku.model.d pZq = null;
            public master.flame.danmaku.danmaku.model.d pZr = null;
            public master.flame.danmaku.danmaku.model.d pZs = null;
            boolean pZt = false;

            protected C1086a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void eDy() {
                this.kFq = 0;
                this.pZr = null;
                this.pZq = null;
                this.pZt = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.pZw) {
                    return 1;
                }
                this.kFq++;
                if (dVar == this.pZs) {
                    this.pZq = null;
                    this.pZt = false;
                    return 1;
                }
                if (this.pZr == null) {
                    this.pZr = dVar;
                    if (this.pZr.eDm() != this.pZh.getHeight()) {
                        return 1;
                    }
                }
                if (this.pZu < this.pZh.eDE()) {
                    this.pZq = null;
                    return 1;
                }
                this.pZt = master.flame.danmaku.danmaku.c.b.a(this.pZh, dVar, this.pZs, this.pZs.getDuration(), this.pZs.eDn().pWi);
                if (!this.pZt) {
                    this.pZq = dVar;
                    return 1;
                }
                this.pZu = (dVar.eDk() - this.pZh.getMargin()) - this.pZs.pVS;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eEk */
            public e eCx() {
                e eVar = new e();
                eVar.kFq = this.kFq;
                eVar.pZr = this.pZr;
                eVar.pZq = this.pZq;
                eVar.pZt = this.pZt;
                return eVar;
            }
        }

        private a() {
            super();
            this.pZo = new C1086a();
            this.pZp = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C1087b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.eDf()) {
                boolean isShown = dVar.isShown();
                float eDk = isShown ? dVar.eDk() : -1.0f;
                boolean z5 = (isShown || this.pZp.isEmpty()) ? false : true;
                if (eDk < mVar.eDE()) {
                    eDk = mVar.getHeight() - dVar.pVS;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.pZw = false;
                    this.pZo.pZu = eDk;
                    this.pZo.pZh = mVar;
                    this.pZo.pZs = dVar;
                    this.pZp.a(this.pZo);
                    e eCx = this.pZo.eCx();
                    eDk = this.pZo.pZu;
                    if (eCx != null) {
                        int i2 = eCx.kFq;
                        dVar3 = eCx.pZr;
                        master.flame.danmaku.danmaku.model.d dVar4 = eCx.pZq;
                        boolean z6 = eCx.pZB;
                        z2 = eCx.pZt;
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
                    boolean a2 = a(false, dVar, mVar, eDk, dVar3, null);
                    if (a2) {
                        eDk = mVar.getHeight() - dVar.pVS;
                        z4 = a2;
                        i = 1;
                    } else {
                        z3 = eDk >= ((float) mVar.eDE()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a2;
                        } else {
                            z4 = a2;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, eDk, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.eDj(), eDk);
                    if (!z) {
                        this.pZp.l(dVar2);
                        this.pZp.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C1087b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.eDE()) || !(dVar2 == null || dVar2.eDm() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C1087b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.pZw = true;
            this.pZp.clear();
        }
    }
}
