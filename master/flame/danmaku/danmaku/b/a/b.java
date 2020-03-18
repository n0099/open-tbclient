package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d nKU = null;
    private d nKV = null;
    private d nKW = null;
    private d nKX = null;

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
        wZ(z);
    }

    public void wZ(boolean z) {
        this.nKU = z ? new a() : new C0780b();
        this.nKV = z ? new a() : new C0780b();
        if (this.nKW == null) {
            this.nKW = new c();
        }
        if (this.nKX == null) {
            this.nKX = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nKU.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nKX.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nKW.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nKV.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nKU != null) {
            this.nKU.clear();
        }
        if (this.nKV != null) {
            this.nKV.clear();
        }
        if (this.nKW != null) {
            this.nKW.clear();
        }
        if (this.nKX != null) {
            this.nKX.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int iag;
        public master.flame.danmaku.danmaku.model.d nKQ;
        public master.flame.danmaku.danmaku.model.d nLa;
        public master.flame.danmaku.danmaku.model.d nLb;
        public boolean nLd;
        public master.flame.danmaku.danmaku.model.d nLi;
        public master.flame.danmaku.danmaku.model.d nLj;
        public boolean nLk;
        public boolean nLl;

        private e() {
            this.iag = 0;
            this.nLi = null;
            this.nLb = null;
            this.nKQ = null;
            this.nLj = null;
            this.nLa = null;
            this.nLk = false;
            this.nLl = false;
            this.nLd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0780b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nKZ;
        protected boolean nLg;
        protected a nLh;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nKR;
            int iag = 0;
            public master.flame.danmaku.danmaku.model.d nLi = null;
            public master.flame.danmaku.danmaku.model.d nLb = null;
            public master.flame.danmaku.danmaku.model.d nKQ = null;
            public master.flame.danmaku.danmaku.model.d nLj = null;
            public master.flame.danmaku.danmaku.model.d nLc = null;
            boolean nLk = false;
            boolean nLl = false;
            boolean nLd = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dMD() {
                this.iag = 0;
                this.nLj = null;
                this.nKQ = null;
                this.nLb = null;
                this.nLi = null;
                this.nLd = false;
                this.nLl = false;
                this.nLk = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0780b.this.nLg) {
                    return 1;
                }
                this.iag++;
                if (dVar == this.nLc) {
                    this.nLi = dVar;
                    this.nKQ = null;
                    this.nLl = true;
                    this.nLd = false;
                    return 1;
                }
                if (this.nLb == null) {
                    this.nLb = dVar;
                }
                if (this.nLc.nHB + dVar.dMp() > this.nKR.getHeight()) {
                    this.nLk = true;
                    return 1;
                }
                if (this.nLj == null) {
                    this.nLj = dVar;
                } else if (this.nLj.dMq() >= dVar.dMq()) {
                    this.nLj = dVar;
                }
                this.nLd = master.flame.danmaku.danmaku.c.b.a(this.nKR, dVar, this.nLc, this.nLc.getDuration(), this.nLc.dMs().nHR);
                if (!this.nLd) {
                    this.nLi = dVar;
                    return 1;
                }
                this.nKQ = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dNp */
            public e dLD() {
                e eVar = new e();
                eVar.iag = this.iag;
                eVar.nLb = this.nLb;
                eVar.nLi = this.nLi;
                eVar.nKQ = this.nKQ;
                eVar.nLj = this.nLj;
                eVar.nLk = this.nLk;
                eVar.nLl = this.nLl;
                eVar.nLd = this.nLd;
                return eVar;
            }
        }

        private C0780b() {
            this.nKZ = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nLg = false;
            this.nLh = new a();
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
            float dMJ;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dMk()) {
                float dMJ2 = mVar.dMJ();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nKZ.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nLg = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nLh.nKR = mVar;
                    this.nLh.nLc = dVar;
                    this.nKZ.a(this.nLh);
                    e dLD = this.nLh.dLD();
                    if (dLD == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dLD.iag;
                        dVar6 = dLD.nLi;
                        dVar3 = dLD.nLb;
                        dVar5 = dLD.nKQ;
                        master.flame.danmaku.danmaku.model.d dVar7 = dLD.nLj;
                        z5 = dLD.nLk;
                        z4 = dLD.nLl;
                        z6 = dLD.nLd;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dMJ = dVar5.dMr() + margin;
                        } else {
                            dMJ = dVar6.dMp();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dMJ = dVar4.dMp();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dMJ = dVar5.dMr() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dMJ = dVar3.dMp();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dMJ = mVar.dMJ();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dMJ, dVar3, dVar5);
                    }
                    if (z7) {
                        dMJ = mVar.dMJ();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dMJ == mVar.dMJ()) {
                        z2 = false;
                        dMJ2 = dMJ;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dMJ2 = dMJ;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dMJ2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dMo(), dMJ2);
                    if (!z2) {
                        this.nKZ.l(dVar2);
                        this.nKZ.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dMJ()) || (dVar2 != null && dVar2.dMp() > 0.0f) || dVar.nHB + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nLg = true;
            this.nKZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c extends C0780b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0780b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.nHB + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0779a nKY;
        protected master.flame.danmaku.danmaku.model.android.d nKZ;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0779a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nKR;
            float nLe;
            int iag = 0;
            public master.flame.danmaku.danmaku.model.d nLa = null;
            public master.flame.danmaku.danmaku.model.d nLb = null;
            public master.flame.danmaku.danmaku.model.d nLc = null;
            boolean nLd = false;

            protected C0779a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dMD() {
                this.iag = 0;
                this.nLb = null;
                this.nLa = null;
                this.nLd = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nLg) {
                    return 1;
                }
                this.iag++;
                if (dVar == this.nLc) {
                    this.nLa = null;
                    this.nLd = false;
                    return 1;
                }
                if (this.nLb == null) {
                    this.nLb = dVar;
                    if (this.nLb.dMr() != this.nKR.getHeight()) {
                        return 1;
                    }
                }
                if (this.nLe < this.nKR.dMJ()) {
                    this.nLa = null;
                    return 1;
                }
                this.nLd = master.flame.danmaku.danmaku.c.b.a(this.nKR, dVar, this.nLc, this.nLc.getDuration(), this.nLc.dMs().nHR);
                if (!this.nLd) {
                    this.nLa = dVar;
                    return 1;
                }
                this.nLe = (dVar.dMp() - this.nKR.getMargin()) - this.nLc.nHB;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dNp */
            public e dLD() {
                e eVar = new e();
                eVar.iag = this.iag;
                eVar.nLb = this.nLb;
                eVar.nLa = this.nLa;
                eVar.nLd = this.nLd;
                return eVar;
            }
        }

        private a() {
            super();
            this.nKY = new C0779a();
            this.nKZ = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0780b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dMk()) {
                boolean isShown = dVar.isShown();
                float dMp = isShown ? dVar.dMp() : -1.0f;
                boolean z5 = (isShown || this.nKZ.isEmpty()) ? false : true;
                if (dMp < mVar.dMJ()) {
                    dMp = mVar.getHeight() - dVar.nHB;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nLg = false;
                    this.nKY.nLe = dMp;
                    this.nKY.nKR = mVar;
                    this.nKY.nLc = dVar;
                    this.nKZ.a(this.nKY);
                    e dLD = this.nKY.dLD();
                    dMp = this.nKY.nLe;
                    if (dLD != null) {
                        int i2 = dLD.iag;
                        dVar3 = dLD.nLb;
                        master.flame.danmaku.danmaku.model.d dVar4 = dLD.nLa;
                        boolean z6 = dLD.nLl;
                        z2 = dLD.nLd;
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
                    boolean a = a(false, dVar, mVar, dMp, dVar3, null);
                    if (a) {
                        dMp = mVar.getHeight() - dVar.nHB;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dMp >= ((float) mVar.dMJ()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dMp, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dMo(), dMp);
                    if (!z) {
                        this.nKZ.l(dVar2);
                        this.nKZ.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0780b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dMJ()) || !(dVar2 == null || dVar2.dMr() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0780b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nLg = true;
            this.nKZ.clear();
        }
    }
}
