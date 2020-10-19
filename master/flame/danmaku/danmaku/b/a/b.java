package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public class b {
    private d oYu = null;
    private d oYv = null;
    private d oYw = null;
    private d oYx = null;

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
        zN(z);
    }

    public void zN(boolean z) {
        this.oYu = z ? new a() : new C0995b();
        this.oYv = z ? new a() : new C0995b();
        if (this.oYw == null) {
            this.oYw = new c();
        }
        if (this.oYx == null) {
            this.oYx = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.oYu.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.oYx.a(dVar, mVar, fVar);
                return;
            case 5:
                this.oYw.a(dVar, mVar, fVar);
                return;
            case 6:
                this.oYv.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.oYu != null) {
            this.oYu.clear();
        }
        if (this.oYv != null) {
            this.oYv.clear();
        }
        if (this.oYw != null) {
            this.oYw.clear();
        }
        if (this.oYx != null) {
            this.oYx.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int kmZ;
        public master.flame.danmaku.danmaku.model.d oYA;
        public master.flame.danmaku.danmaku.model.d oYB;
        public boolean oYD;
        public master.flame.danmaku.danmaku.model.d oYI;
        public master.flame.danmaku.danmaku.model.d oYJ;
        public boolean oYK;
        public boolean oYL;
        public master.flame.danmaku.danmaku.model.d oYq;

        private e() {
            this.kmZ = 0;
            this.oYI = null;
            this.oYB = null;
            this.oYq = null;
            this.oYJ = null;
            this.oYA = null;
            this.oYK = false;
            this.oYL = false;
            this.oYD = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0995b implements d {
        protected boolean oYG;
        protected a oYH;
        protected master.flame.danmaku.danmaku.model.android.d oYz;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes6.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m oYr;
            int kmZ = 0;
            public master.flame.danmaku.danmaku.model.d oYI = null;
            public master.flame.danmaku.danmaku.model.d oYB = null;
            public master.flame.danmaku.danmaku.model.d oYq = null;
            public master.flame.danmaku.danmaku.model.d oYJ = null;
            public master.flame.danmaku.danmaku.model.d oYC = null;
            boolean oYK = false;
            boolean oYL = false;
            boolean oYD = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void epL() {
                this.kmZ = 0;
                this.oYJ = null;
                this.oYq = null;
                this.oYB = null;
                this.oYI = null;
                this.oYD = false;
                this.oYL = false;
                this.oYK = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0995b.this.oYG) {
                    return 1;
                }
                this.kmZ++;
                if (dVar == this.oYC) {
                    this.oYI = dVar;
                    this.oYq = null;
                    this.oYL = true;
                    this.oYD = false;
                    return 1;
                }
                if (this.oYB == null) {
                    this.oYB = dVar;
                }
                if (this.oYC.oVc + dVar.epx() > this.oYr.getHeight()) {
                    this.oYK = true;
                    return 1;
                }
                if (this.oYJ == null) {
                    this.oYJ = dVar;
                } else if (this.oYJ.epy() >= dVar.epy()) {
                    this.oYJ = dVar;
                }
                this.oYD = master.flame.danmaku.danmaku.c.b.a(this.oYr, dVar, this.oYC, this.oYC.getDuration(), this.oYC.epA().oVs);
                if (!this.oYD) {
                    this.oYI = dVar;
                    return 1;
                }
                this.oYq = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eqx */
            public e eoK() {
                e eVar = new e();
                eVar.kmZ = this.kmZ;
                eVar.oYB = this.oYB;
                eVar.oYI = this.oYI;
                eVar.oYq = this.oYq;
                eVar.oYJ = this.oYJ;
                eVar.oYK = this.oYK;
                eVar.oYL = this.oYL;
                eVar.oYD = this.oYD;
                return eVar;
            }
        }

        private C0995b() {
            this.oYz = new master.flame.danmaku.danmaku.model.android.d(1);
            this.oYG = false;
            this.oYH = new a();
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
            float epR;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.eps()) {
                float epR2 = mVar.epR();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.oYz.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.oYG = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.oYH.oYr = mVar;
                    this.oYH.oYC = dVar;
                    this.oYz.a(this.oYH);
                    e eoK = this.oYH.eoK();
                    if (eoK == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = eoK.kmZ;
                        dVar6 = eoK.oYI;
                        dVar3 = eoK.oYB;
                        dVar5 = eoK.oYq;
                        master.flame.danmaku.danmaku.model.d dVar7 = eoK.oYJ;
                        z5 = eoK.oYK;
                        z4 = eoK.oYL;
                        z6 = eoK.oYD;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            epR = dVar5.epz() + margin;
                        } else {
                            epR = dVar6.epx();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        epR = dVar4.epx();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        epR = dVar5.epz() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        epR = dVar3.epx();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        epR = mVar.epR();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, epR, dVar3, dVar5);
                    }
                    if (z7) {
                        epR = mVar.epR();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (epR == mVar.epR()) {
                        z2 = false;
                        epR2 = epR;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        epR2 = epR;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, epR2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.epw(), epR2);
                    if (!z2) {
                        this.oYz.l(dVar2);
                        this.oYz.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.epR()) || (dVar2 != null && dVar2.epx() > 0.0f) || dVar.oVc + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.oYG = true;
            this.oYz.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c extends C0995b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0995b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.oVc + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends c {
        protected C0994a oYy;
        protected master.flame.danmaku.danmaku.model.android.d oYz;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        protected class C0994a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            int kmZ = 0;
            public master.flame.danmaku.danmaku.model.d oYA = null;
            public master.flame.danmaku.danmaku.model.d oYB = null;
            public master.flame.danmaku.danmaku.model.d oYC = null;
            boolean oYD = false;
            float oYE;
            public m oYr;

            protected C0994a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void epL() {
                this.kmZ = 0;
                this.oYB = null;
                this.oYA = null;
                this.oYD = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.oYG) {
                    return 1;
                }
                this.kmZ++;
                if (dVar == this.oYC) {
                    this.oYA = null;
                    this.oYD = false;
                    return 1;
                }
                if (this.oYB == null) {
                    this.oYB = dVar;
                    if (this.oYB.epz() != this.oYr.getHeight()) {
                        return 1;
                    }
                }
                if (this.oYE < this.oYr.epR()) {
                    this.oYA = null;
                    return 1;
                }
                this.oYD = master.flame.danmaku.danmaku.c.b.a(this.oYr, dVar, this.oYC, this.oYC.getDuration(), this.oYC.epA().oVs);
                if (!this.oYD) {
                    this.oYA = dVar;
                    return 1;
                }
                this.oYE = (dVar.epx() - this.oYr.getMargin()) - this.oYC.oVc;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eqx */
            public e eoK() {
                e eVar = new e();
                eVar.kmZ = this.kmZ;
                eVar.oYB = this.oYB;
                eVar.oYA = this.oYA;
                eVar.oYD = this.oYD;
                return eVar;
            }
        }

        private a() {
            super();
            this.oYy = new C0994a();
            this.oYz = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0995b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.eps()) {
                boolean isShown = dVar.isShown();
                float epx = isShown ? dVar.epx() : -1.0f;
                boolean z5 = (isShown || this.oYz.isEmpty()) ? false : true;
                if (epx < mVar.epR()) {
                    epx = mVar.getHeight() - dVar.oVc;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.oYG = false;
                    this.oYy.oYE = epx;
                    this.oYy.oYr = mVar;
                    this.oYy.oYC = dVar;
                    this.oYz.a(this.oYy);
                    e eoK = this.oYy.eoK();
                    epx = this.oYy.oYE;
                    if (eoK != null) {
                        int i2 = eoK.kmZ;
                        dVar3 = eoK.oYB;
                        master.flame.danmaku.danmaku.model.d dVar4 = eoK.oYA;
                        boolean z6 = eoK.oYL;
                        z2 = eoK.oYD;
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
                    boolean a2 = a(false, dVar, mVar, epx, dVar3, null);
                    if (a2) {
                        epx = mVar.getHeight() - dVar.oVc;
                        z4 = a2;
                        i = 1;
                    } else {
                        z3 = epx >= ((float) mVar.epR()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a2;
                        } else {
                            z4 = a2;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, epx, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.epw(), epx);
                    if (!z) {
                        this.oYz.l(dVar2);
                        this.oYz.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0995b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.epR()) || !(dVar2 == null || dVar2.epz() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0995b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.oYG = true;
            this.oYz.clear();
        }
    }
}
