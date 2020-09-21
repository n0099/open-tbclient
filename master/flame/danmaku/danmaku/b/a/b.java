package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public class b {
    private d oJg = null;
    private d oJh = null;
    private d oJi = null;
    private d oJj = null;

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
        zg(z);
    }

    public void zg(boolean z) {
        this.oJg = z ? new a() : new C0977b();
        this.oJh = z ? new a() : new C0977b();
        if (this.oJi == null) {
            this.oJi = new c();
        }
        if (this.oJj == null) {
            this.oJj = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.oJg.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.oJj.a(dVar, mVar, fVar);
                return;
            case 5:
                this.oJi.a(dVar, mVar, fVar);
                return;
            case 6:
                this.oJh.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.oJg != null) {
            this.oJg.clear();
        }
        if (this.oJh != null) {
            this.oJh.clear();
        }
        if (this.oJi != null) {
            this.oJi.clear();
        }
        if (this.oJj != null) {
            this.oJj.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int jXJ;
        public master.flame.danmaku.danmaku.model.d oJc;
        public master.flame.danmaku.danmaku.model.d oJm;
        public master.flame.danmaku.danmaku.model.d oJn;
        public boolean oJp;
        public master.flame.danmaku.danmaku.model.d oJu;
        public master.flame.danmaku.danmaku.model.d oJv;
        public boolean oJw;
        public boolean oJx;

        private e() {
            this.jXJ = 0;
            this.oJu = null;
            this.oJn = null;
            this.oJc = null;
            this.oJv = null;
            this.oJm = null;
            this.oJw = false;
            this.oJx = false;
            this.oJp = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0977b implements d {
        protected master.flame.danmaku.danmaku.model.android.d oJl;
        protected boolean oJs;
        protected a oJt;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes6.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m oJd;
            int jXJ = 0;
            public master.flame.danmaku.danmaku.model.d oJu = null;
            public master.flame.danmaku.danmaku.model.d oJn = null;
            public master.flame.danmaku.danmaku.model.d oJc = null;
            public master.flame.danmaku.danmaku.model.d oJv = null;
            public master.flame.danmaku.danmaku.model.d oJo = null;
            boolean oJw = false;
            boolean oJx = false;
            boolean oJp = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void elY() {
                this.jXJ = 0;
                this.oJv = null;
                this.oJc = null;
                this.oJn = null;
                this.oJu = null;
                this.oJp = false;
                this.oJx = false;
                this.oJw = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0977b.this.oJs) {
                    return 1;
                }
                this.jXJ++;
                if (dVar == this.oJo) {
                    this.oJu = dVar;
                    this.oJc = null;
                    this.oJx = true;
                    this.oJp = false;
                    return 1;
                }
                if (this.oJn == null) {
                    this.oJn = dVar;
                }
                if (this.oJo.oFN + dVar.elK() > this.oJd.getHeight()) {
                    this.oJw = true;
                    return 1;
                }
                if (this.oJv == null) {
                    this.oJv = dVar;
                } else if (this.oJv.elL() >= dVar.elL()) {
                    this.oJv = dVar;
                }
                this.oJp = master.flame.danmaku.danmaku.c.b.a(this.oJd, dVar, this.oJo, this.oJo.getDuration(), this.oJo.elN().oGd);
                if (!this.oJp) {
                    this.oJu = dVar;
                    return 1;
                }
                this.oJc = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: emK */
            public e ekX() {
                e eVar = new e();
                eVar.jXJ = this.jXJ;
                eVar.oJn = this.oJn;
                eVar.oJu = this.oJu;
                eVar.oJc = this.oJc;
                eVar.oJv = this.oJv;
                eVar.oJw = this.oJw;
                eVar.oJx = this.oJx;
                eVar.oJp = this.oJp;
                return eVar;
            }
        }

        private C0977b() {
            this.oJl = new master.flame.danmaku.danmaku.model.android.d(1);
            this.oJs = false;
            this.oJt = new a();
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
            float eme;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.elF()) {
                float eme2 = mVar.eme();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.oJl.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.oJs = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.oJt.oJd = mVar;
                    this.oJt.oJo = dVar;
                    this.oJl.a(this.oJt);
                    e ekX = this.oJt.ekX();
                    if (ekX == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = ekX.jXJ;
                        dVar6 = ekX.oJu;
                        dVar3 = ekX.oJn;
                        dVar5 = ekX.oJc;
                        master.flame.danmaku.danmaku.model.d dVar7 = ekX.oJv;
                        z5 = ekX.oJw;
                        z4 = ekX.oJx;
                        z6 = ekX.oJp;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            eme = dVar5.elM() + margin;
                        } else {
                            eme = dVar6.elK();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        eme = dVar4.elK();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        eme = dVar5.elM() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        eme = dVar3.elK();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        eme = mVar.eme();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, eme, dVar3, dVar5);
                    }
                    if (z7) {
                        eme = mVar.eme();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (eme == mVar.eme()) {
                        z2 = false;
                        eme2 = eme;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        eme2 = eme;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, eme2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.elJ(), eme2);
                    if (!z2) {
                        this.oJl.l(dVar2);
                        this.oJl.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.eme()) || (dVar2 != null && dVar2.elK() > 0.0f) || dVar.oFN + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.oJs = true;
            this.oJl.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c extends C0977b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0977b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.oFN + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends c {
        protected C0976a oJk;
        protected master.flame.danmaku.danmaku.model.android.d oJl;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        protected class C0976a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m oJd;
            float oJq;
            int jXJ = 0;
            public master.flame.danmaku.danmaku.model.d oJm = null;
            public master.flame.danmaku.danmaku.model.d oJn = null;
            public master.flame.danmaku.danmaku.model.d oJo = null;
            boolean oJp = false;

            protected C0976a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void elY() {
                this.jXJ = 0;
                this.oJn = null;
                this.oJm = null;
                this.oJp = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.oJs) {
                    return 1;
                }
                this.jXJ++;
                if (dVar == this.oJo) {
                    this.oJm = null;
                    this.oJp = false;
                    return 1;
                }
                if (this.oJn == null) {
                    this.oJn = dVar;
                    if (this.oJn.elM() != this.oJd.getHeight()) {
                        return 1;
                    }
                }
                if (this.oJq < this.oJd.eme()) {
                    this.oJm = null;
                    return 1;
                }
                this.oJp = master.flame.danmaku.danmaku.c.b.a(this.oJd, dVar, this.oJo, this.oJo.getDuration(), this.oJo.elN().oGd);
                if (!this.oJp) {
                    this.oJm = dVar;
                    return 1;
                }
                this.oJq = (dVar.elK() - this.oJd.getMargin()) - this.oJo.oFN;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: emK */
            public e ekX() {
                e eVar = new e();
                eVar.jXJ = this.jXJ;
                eVar.oJn = this.oJn;
                eVar.oJm = this.oJm;
                eVar.oJp = this.oJp;
                return eVar;
            }
        }

        private a() {
            super();
            this.oJk = new C0976a();
            this.oJl = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0977b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.elF()) {
                boolean isShown = dVar.isShown();
                float elK = isShown ? dVar.elK() : -1.0f;
                boolean z5 = (isShown || this.oJl.isEmpty()) ? false : true;
                if (elK < mVar.eme()) {
                    elK = mVar.getHeight() - dVar.oFN;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.oJs = false;
                    this.oJk.oJq = elK;
                    this.oJk.oJd = mVar;
                    this.oJk.oJo = dVar;
                    this.oJl.a(this.oJk);
                    e ekX = this.oJk.ekX();
                    elK = this.oJk.oJq;
                    if (ekX != null) {
                        int i2 = ekX.jXJ;
                        dVar3 = ekX.oJn;
                        master.flame.danmaku.danmaku.model.d dVar4 = ekX.oJm;
                        boolean z6 = ekX.oJx;
                        z2 = ekX.oJp;
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
                    boolean a = a(false, dVar, mVar, elK, dVar3, null);
                    if (a) {
                        elK = mVar.getHeight() - dVar.oFN;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = elK >= ((float) mVar.eme()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, elK, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.elJ(), elK);
                    if (!z) {
                        this.oJl.l(dVar2);
                        this.oJl.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0977b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.eme()) || !(dVar2 == null || dVar2.elM() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0977b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.oJs = true;
            this.oJl.clear();
        }
    }
}
