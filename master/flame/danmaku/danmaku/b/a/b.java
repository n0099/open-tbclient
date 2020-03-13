package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d nJh = null;
    private d nJi = null;
    private d nJj = null;
    private d nJk = null;

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
        this.nJh = z ? new a() : new C0779b();
        this.nJi = z ? new a() : new C0779b();
        if (this.nJj == null) {
            this.nJj = new c();
        }
        if (this.nJk == null) {
            this.nJk = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nJh.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nJk.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nJj.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nJi.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nJh != null) {
            this.nJh.clear();
        }
        if (this.nJi != null) {
            this.nJi.clear();
        }
        if (this.nJj != null) {
            this.nJj.clear();
        }
        if (this.nJk != null) {
            this.nJk.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int hYG;
        public master.flame.danmaku.danmaku.model.d nJd;
        public master.flame.danmaku.danmaku.model.d nJn;
        public master.flame.danmaku.danmaku.model.d nJo;
        public boolean nJq;
        public master.flame.danmaku.danmaku.model.d nJv;
        public master.flame.danmaku.danmaku.model.d nJw;
        public boolean nJx;
        public boolean nJy;

        private e() {
            this.hYG = 0;
            this.nJv = null;
            this.nJo = null;
            this.nJd = null;
            this.nJw = null;
            this.nJn = null;
            this.nJx = false;
            this.nJy = false;
            this.nJq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0779b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nJm;
        protected boolean nJt;
        protected a nJu;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nJe;
            int hYG = 0;
            public master.flame.danmaku.danmaku.model.d nJv = null;
            public master.flame.danmaku.danmaku.model.d nJo = null;
            public master.flame.danmaku.danmaku.model.d nJd = null;
            public master.flame.danmaku.danmaku.model.d nJw = null;
            public master.flame.danmaku.danmaku.model.d nJp = null;
            boolean nJx = false;
            boolean nJy = false;
            boolean nJq = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dMd() {
                this.hYG = 0;
                this.nJw = null;
                this.nJd = null;
                this.nJo = null;
                this.nJv = null;
                this.nJq = false;
                this.nJy = false;
                this.nJx = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0779b.this.nJt) {
                    return 1;
                }
                this.hYG++;
                if (dVar == this.nJp) {
                    this.nJv = dVar;
                    this.nJd = null;
                    this.nJy = true;
                    this.nJq = false;
                    return 1;
                }
                if (this.nJo == null) {
                    this.nJo = dVar;
                }
                if (this.nJp.nFO + dVar.dLP() > this.nJe.getHeight()) {
                    this.nJx = true;
                    return 1;
                }
                if (this.nJw == null) {
                    this.nJw = dVar;
                } else if (this.nJw.dLQ() >= dVar.dLQ()) {
                    this.nJw = dVar;
                }
                this.nJq = master.flame.danmaku.danmaku.c.b.a(this.nJe, dVar, this.nJp, this.nJp.getDuration(), this.nJp.dLS().nGe);
                if (!this.nJq) {
                    this.nJv = dVar;
                    return 1;
                }
                this.nJd = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dMP */
            public e dLd() {
                e eVar = new e();
                eVar.hYG = this.hYG;
                eVar.nJo = this.nJo;
                eVar.nJv = this.nJv;
                eVar.nJd = this.nJd;
                eVar.nJw = this.nJw;
                eVar.nJx = this.nJx;
                eVar.nJy = this.nJy;
                eVar.nJq = this.nJq;
                return eVar;
            }
        }

        private C0779b() {
            this.nJm = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nJt = false;
            this.nJu = new a();
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
            float dMj;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dLK()) {
                float dMj2 = mVar.dMj();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nJm.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nJt = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nJu.nJe = mVar;
                    this.nJu.nJp = dVar;
                    this.nJm.a(this.nJu);
                    e dLd = this.nJu.dLd();
                    if (dLd == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dLd.hYG;
                        dVar6 = dLd.nJv;
                        dVar3 = dLd.nJo;
                        dVar5 = dLd.nJd;
                        master.flame.danmaku.danmaku.model.d dVar7 = dLd.nJw;
                        z5 = dLd.nJx;
                        z4 = dLd.nJy;
                        z6 = dLd.nJq;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dMj = dVar5.dLR() + margin;
                        } else {
                            dMj = dVar6.dLP();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dMj = dVar4.dLP();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dMj = dVar5.dLR() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dMj = dVar3.dLP();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dMj = mVar.dMj();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dMj, dVar3, dVar5);
                    }
                    if (z7) {
                        dMj = mVar.dMj();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dMj == mVar.dMj()) {
                        z2 = false;
                        dMj2 = dMj;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dMj2 = dMj;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dMj2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dLO(), dMj2);
                    if (!z2) {
                        this.nJm.l(dVar2);
                        this.nJm.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dMj()) || (dVar2 != null && dVar2.dLP() > 0.0f) || dVar.nFO + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nJt = true;
            this.nJm.clear();
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
            return dVar.nFO + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0778a nJl;
        protected master.flame.danmaku.danmaku.model.android.d nJm;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0778a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nJe;
            float nJr;
            int hYG = 0;
            public master.flame.danmaku.danmaku.model.d nJn = null;
            public master.flame.danmaku.danmaku.model.d nJo = null;
            public master.flame.danmaku.danmaku.model.d nJp = null;
            boolean nJq = false;

            protected C0778a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dMd() {
                this.hYG = 0;
                this.nJo = null;
                this.nJn = null;
                this.nJq = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nJt) {
                    return 1;
                }
                this.hYG++;
                if (dVar == this.nJp) {
                    this.nJn = null;
                    this.nJq = false;
                    return 1;
                }
                if (this.nJo == null) {
                    this.nJo = dVar;
                    if (this.nJo.dLR() != this.nJe.getHeight()) {
                        return 1;
                    }
                }
                if (this.nJr < this.nJe.dMj()) {
                    this.nJn = null;
                    return 1;
                }
                this.nJq = master.flame.danmaku.danmaku.c.b.a(this.nJe, dVar, this.nJp, this.nJp.getDuration(), this.nJp.dLS().nGe);
                if (!this.nJq) {
                    this.nJn = dVar;
                    return 1;
                }
                this.nJr = (dVar.dLP() - this.nJe.getMargin()) - this.nJp.nFO;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dMP */
            public e dLd() {
                e eVar = new e();
                eVar.hYG = this.hYG;
                eVar.nJo = this.nJo;
                eVar.nJn = this.nJn;
                eVar.nJq = this.nJq;
                return eVar;
            }
        }

        private a() {
            super();
            this.nJl = new C0778a();
            this.nJm = new master.flame.danmaku.danmaku.model.android.d(2);
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
            if (!dVar.dLK()) {
                boolean isShown = dVar.isShown();
                float dLP = isShown ? dVar.dLP() : -1.0f;
                boolean z5 = (isShown || this.nJm.isEmpty()) ? false : true;
                if (dLP < mVar.dMj()) {
                    dLP = mVar.getHeight() - dVar.nFO;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nJt = false;
                    this.nJl.nJr = dLP;
                    this.nJl.nJe = mVar;
                    this.nJl.nJp = dVar;
                    this.nJm.a(this.nJl);
                    e dLd = this.nJl.dLd();
                    dLP = this.nJl.nJr;
                    if (dLd != null) {
                        int i2 = dLd.hYG;
                        dVar3 = dLd.nJo;
                        master.flame.danmaku.danmaku.model.d dVar4 = dLd.nJn;
                        boolean z6 = dLd.nJy;
                        z2 = dLd.nJq;
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
                    boolean a = a(false, dVar, mVar, dLP, dVar3, null);
                    if (a) {
                        dLP = mVar.getHeight() - dVar.nFO;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dLP >= ((float) mVar.dMj()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dLP, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dLO(), dLP);
                    if (!z) {
                        this.nJm.l(dVar2);
                        this.nJm.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0779b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dMj()) || !(dVar2 == null || dVar2.dLR() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0779b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nJt = true;
            this.nJm.clear();
        }
    }
}
