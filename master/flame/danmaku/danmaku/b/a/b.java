package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d nWx = null;
    private d nWy = null;
    private d nWz = null;
    private d nWA = null;

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
        xz(z);
    }

    public void xz(boolean z) {
        this.nWx = z ? new a() : new C0906b();
        this.nWy = z ? new a() : new C0906b();
        if (this.nWz == null) {
            this.nWz = new c();
        }
        if (this.nWA == null) {
            this.nWA = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nWx.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nWA.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nWz.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nWy.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nWx != null) {
            this.nWx.clear();
        }
        if (this.nWy != null) {
            this.nWy.clear();
        }
        if (this.nWz != null) {
            this.nWz.clear();
        }
        if (this.nWA != null) {
            this.nWA.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int jrb;
        public master.flame.danmaku.danmaku.model.d nWD;
        public master.flame.danmaku.danmaku.model.d nWE;
        public boolean nWG;
        public master.flame.danmaku.danmaku.model.d nWL;
        public master.flame.danmaku.danmaku.model.d nWM;
        public boolean nWN;
        public boolean nWO;
        public master.flame.danmaku.danmaku.model.d nWt;

        private e() {
            this.jrb = 0;
            this.nWL = null;
            this.nWE = null;
            this.nWt = null;
            this.nWM = null;
            this.nWD = null;
            this.nWN = false;
            this.nWO = false;
            this.nWG = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0906b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nWC;
        protected boolean nWJ;
        protected a nWK;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nWu;
            int jrb = 0;
            public master.flame.danmaku.danmaku.model.d nWL = null;
            public master.flame.danmaku.danmaku.model.d nWE = null;
            public master.flame.danmaku.danmaku.model.d nWt = null;
            public master.flame.danmaku.danmaku.model.d nWM = null;
            public master.flame.danmaku.danmaku.model.d nWF = null;
            boolean nWN = false;
            boolean nWO = false;
            boolean nWG = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dSo() {
                this.jrb = 0;
                this.nWM = null;
                this.nWt = null;
                this.nWE = null;
                this.nWL = null;
                this.nWG = false;
                this.nWO = false;
                this.nWN = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0906b.this.nWJ) {
                    return 1;
                }
                this.jrb++;
                if (dVar == this.nWF) {
                    this.nWL = dVar;
                    this.nWt = null;
                    this.nWO = true;
                    this.nWG = false;
                    return 1;
                }
                if (this.nWE == null) {
                    this.nWE = dVar;
                }
                if (this.nWF.nTd + dVar.dSa() > this.nWu.getHeight()) {
                    this.nWN = true;
                    return 1;
                }
                if (this.nWM == null) {
                    this.nWM = dVar;
                } else if (this.nWM.dSb() >= dVar.dSb()) {
                    this.nWM = dVar;
                }
                this.nWG = master.flame.danmaku.danmaku.c.b.a(this.nWu, dVar, this.nWF, this.nWF.getDuration(), this.nWF.dSd().nTt);
                if (!this.nWG) {
                    this.nWL = dVar;
                    return 1;
                }
                this.nWt = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dTa */
            public e dRo() {
                e eVar = new e();
                eVar.jrb = this.jrb;
                eVar.nWE = this.nWE;
                eVar.nWL = this.nWL;
                eVar.nWt = this.nWt;
                eVar.nWM = this.nWM;
                eVar.nWN = this.nWN;
                eVar.nWO = this.nWO;
                eVar.nWG = this.nWG;
                return eVar;
            }
        }

        private C0906b() {
            this.nWC = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nWJ = false;
            this.nWK = new a();
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
            float dSu;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dRV()) {
                float dSu2 = mVar.dSu();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nWC.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nWJ = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nWK.nWu = mVar;
                    this.nWK.nWF = dVar;
                    this.nWC.a(this.nWK);
                    e dRo = this.nWK.dRo();
                    if (dRo == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dRo.jrb;
                        dVar6 = dRo.nWL;
                        dVar3 = dRo.nWE;
                        dVar5 = dRo.nWt;
                        master.flame.danmaku.danmaku.model.d dVar7 = dRo.nWM;
                        z5 = dRo.nWN;
                        z4 = dRo.nWO;
                        z6 = dRo.nWG;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dSu = dVar5.dSc() + margin;
                        } else {
                            dSu = dVar6.dSa();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dSu = dVar4.dSa();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dSu = dVar5.dSc() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dSu = dVar3.dSa();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dSu = mVar.dSu();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dSu, dVar3, dVar5);
                    }
                    if (z7) {
                        dSu = mVar.dSu();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dSu == mVar.dSu()) {
                        z2 = false;
                        dSu2 = dSu;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dSu2 = dSu;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dSu2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dRZ(), dSu2);
                    if (!z2) {
                        this.nWC.l(dVar2);
                        this.nWC.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dSu()) || (dVar2 != null && dVar2.dSa() > 0.0f) || dVar.nTd + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nWJ = true;
            this.nWC.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c extends C0906b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0906b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.nTd + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0905a nWB;
        protected master.flame.danmaku.danmaku.model.android.d nWC;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0905a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            int jrb = 0;
            public master.flame.danmaku.danmaku.model.d nWD = null;
            public master.flame.danmaku.danmaku.model.d nWE = null;
            public master.flame.danmaku.danmaku.model.d nWF = null;
            boolean nWG = false;
            float nWH;
            public m nWu;

            protected C0905a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dSo() {
                this.jrb = 0;
                this.nWE = null;
                this.nWD = null;
                this.nWG = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nWJ) {
                    return 1;
                }
                this.jrb++;
                if (dVar == this.nWF) {
                    this.nWD = null;
                    this.nWG = false;
                    return 1;
                }
                if (this.nWE == null) {
                    this.nWE = dVar;
                    if (this.nWE.dSc() != this.nWu.getHeight()) {
                        return 1;
                    }
                }
                if (this.nWH < this.nWu.dSu()) {
                    this.nWD = null;
                    return 1;
                }
                this.nWG = master.flame.danmaku.danmaku.c.b.a(this.nWu, dVar, this.nWF, this.nWF.getDuration(), this.nWF.dSd().nTt);
                if (!this.nWG) {
                    this.nWD = dVar;
                    return 1;
                }
                this.nWH = (dVar.dSa() - this.nWu.getMargin()) - this.nWF.nTd;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dTa */
            public e dRo() {
                e eVar = new e();
                eVar.jrb = this.jrb;
                eVar.nWE = this.nWE;
                eVar.nWD = this.nWD;
                eVar.nWG = this.nWG;
                return eVar;
            }
        }

        private a() {
            super();
            this.nWB = new C0905a();
            this.nWC = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0906b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dRV()) {
                boolean isShown = dVar.isShown();
                float dSa = isShown ? dVar.dSa() : -1.0f;
                boolean z5 = (isShown || this.nWC.isEmpty()) ? false : true;
                if (dSa < mVar.dSu()) {
                    dSa = mVar.getHeight() - dVar.nTd;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nWJ = false;
                    this.nWB.nWH = dSa;
                    this.nWB.nWu = mVar;
                    this.nWB.nWF = dVar;
                    this.nWC.a(this.nWB);
                    e dRo = this.nWB.dRo();
                    dSa = this.nWB.nWH;
                    if (dRo != null) {
                        int i2 = dRo.jrb;
                        dVar3 = dRo.nWE;
                        master.flame.danmaku.danmaku.model.d dVar4 = dRo.nWD;
                        boolean z6 = dRo.nWO;
                        z2 = dRo.nWG;
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
                    boolean a = a(false, dVar, mVar, dSa, dVar3, null);
                    if (a) {
                        dSa = mVar.getHeight() - dVar.nTd;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dSa >= ((float) mVar.dSu()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dSa, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dRZ(), dSa);
                    if (!z) {
                        this.nWC.l(dVar2);
                        this.nWC.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0906b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dSu()) || !(dVar2 == null || dVar2.dSc() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0906b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nWJ = true;
            this.nWC.clear();
        }
    }
}
