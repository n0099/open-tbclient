package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public class b {
    private d qaN = null;
    private d qaO = null;
    private d qaP = null;
    private d qaQ = null;

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
        Bn(z);
    }

    public void Bn(boolean z) {
        this.qaN = z ? new a() : new C1090b();
        this.qaO = z ? new a() : new C1090b();
        if (this.qaP == null) {
            this.qaP = new c();
        }
        if (this.qaQ == null) {
            this.qaQ = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.qaN.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.qaQ.a(dVar, mVar, fVar);
                return;
            case 5:
                this.qaP.a(dVar, mVar, fVar);
                return;
            case 6:
                this.qaO.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.qaN != null) {
            this.qaN.clear();
        }
        if (this.qaO != null) {
            this.qaO.clear();
        }
        if (this.qaP != null) {
            this.qaP.clear();
        }
        if (this.qaQ != null) {
            this.qaQ.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int kFF;
        public master.flame.danmaku.danmaku.model.d qaJ;
        public master.flame.danmaku.danmaku.model.d qaT;
        public master.flame.danmaku.danmaku.model.d qaU;
        public boolean qaW;
        public master.flame.danmaku.danmaku.model.d qbb;
        public master.flame.danmaku.danmaku.model.d qbc;
        public boolean qbd;
        public boolean qbe;

        private e() {
            this.kFF = 0;
            this.qbb = null;
            this.qaU = null;
            this.qaJ = null;
            this.qbc = null;
            this.qaT = null;
            this.qbd = false;
            this.qbe = false;
            this.qaW = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1090b implements d {
        protected master.flame.danmaku.danmaku.model.android.d qaS;
        protected boolean qaZ;
        protected a qba;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes6.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m qaK;
            int kFF = 0;
            public master.flame.danmaku.danmaku.model.d qbb = null;
            public master.flame.danmaku.danmaku.model.d qaU = null;
            public master.flame.danmaku.danmaku.model.d qaJ = null;
            public master.flame.danmaku.danmaku.model.d qbc = null;
            public master.flame.danmaku.danmaku.model.d qaV = null;
            boolean qbd = false;
            boolean qbe = false;
            boolean qaW = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void eDz() {
                this.kFF = 0;
                this.qbc = null;
                this.qaJ = null;
                this.qaU = null;
                this.qbb = null;
                this.qaW = false;
                this.qbe = false;
                this.qbd = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                if (C1090b.this.qaZ) {
                    return 1;
                }
                this.kFF++;
                if (dVar == this.qaV) {
                    this.qbb = dVar;
                    this.qaJ = null;
                    this.qbe = true;
                    this.qaW = false;
                    return 1;
                }
                if (this.qaU == null) {
                    this.qaU = dVar;
                }
                if (this.qaV.pXv + dVar.eDl() > this.qaK.getHeight()) {
                    this.qbd = true;
                    return 1;
                }
                if (this.qbc == null) {
                    this.qbc = dVar;
                } else if (this.qbc.eDm() >= dVar.eDm()) {
                    this.qbc = dVar;
                }
                this.qaW = master.flame.danmaku.danmaku.c.b.a(this.qaK, dVar, this.qaV, this.qaV.getDuration(), this.qaV.eDo().pXL);
                if (!this.qaW) {
                    this.qbb = dVar;
                    return 1;
                }
                this.qaJ = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eEl */
            public e eCy() {
                e eVar = new e();
                eVar.kFF = this.kFF;
                eVar.qaU = this.qaU;
                eVar.qbb = this.qbb;
                eVar.qaJ = this.qaJ;
                eVar.qbc = this.qbc;
                eVar.qbd = this.qbd;
                eVar.qbe = this.qbe;
                eVar.qaW = this.qaW;
                return eVar;
            }
        }

        private C1090b() {
            this.qaS = new master.flame.danmaku.danmaku.model.android.d(1);
            this.qaZ = false;
            this.qba = new a();
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
            float eDF;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.eDg()) {
                float eDF2 = mVar.eDF();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.qaS.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.qaZ = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.qba.qaK = mVar;
                    this.qba.qaV = dVar;
                    this.qaS.a(this.qba);
                    e eCy = this.qba.eCy();
                    if (eCy == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = eCy.kFF;
                        dVar6 = eCy.qbb;
                        dVar3 = eCy.qaU;
                        dVar5 = eCy.qaJ;
                        master.flame.danmaku.danmaku.model.d dVar7 = eCy.qbc;
                        z5 = eCy.qbd;
                        z4 = eCy.qbe;
                        z6 = eCy.qaW;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            eDF = dVar5.eDn() + margin;
                        } else {
                            eDF = dVar6.eDl();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        eDF = dVar4.eDl();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        eDF = dVar5.eDn() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        eDF = dVar3.eDl();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        eDF = mVar.eDF();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, eDF, dVar3, dVar5);
                    }
                    if (z7) {
                        eDF = mVar.eDF();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (eDF == mVar.eDF()) {
                        z2 = false;
                        eDF2 = eDF;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        eDF2 = eDF;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, eDF2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.eDk(), eDF2);
                    if (!z2) {
                        this.qaS.l(dVar2);
                        this.qaS.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.eDF()) || (dVar2 != null && dVar2.eDl() > 0.0f) || dVar.pXv + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.qaZ = true;
            this.qaS.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c extends C1090b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C1090b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.pXv + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends c {
        protected C1089a qaR;
        protected master.flame.danmaku.danmaku.model.android.d qaS;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        protected class C1089a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m qaK;
            float qaX;
            int kFF = 0;
            public master.flame.danmaku.danmaku.model.d qaT = null;
            public master.flame.danmaku.danmaku.model.d qaU = null;
            public master.flame.danmaku.danmaku.model.d qaV = null;
            boolean qaW = false;

            protected C1089a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void eDz() {
                this.kFF = 0;
                this.qaU = null;
                this.qaT = null;
                this.qaW = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.qaZ) {
                    return 1;
                }
                this.kFF++;
                if (dVar == this.qaV) {
                    this.qaT = null;
                    this.qaW = false;
                    return 1;
                }
                if (this.qaU == null) {
                    this.qaU = dVar;
                    if (this.qaU.eDn() != this.qaK.getHeight()) {
                        return 1;
                    }
                }
                if (this.qaX < this.qaK.eDF()) {
                    this.qaT = null;
                    return 1;
                }
                this.qaW = master.flame.danmaku.danmaku.c.b.a(this.qaK, dVar, this.qaV, this.qaV.getDuration(), this.qaV.eDo().pXL);
                if (!this.qaW) {
                    this.qaT = dVar;
                    return 1;
                }
                this.qaX = (dVar.eDl() - this.qaK.getMargin()) - this.qaV.pXv;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eEl */
            public e eCy() {
                e eVar = new e();
                eVar.kFF = this.kFF;
                eVar.qaU = this.qaU;
                eVar.qaT = this.qaT;
                eVar.qaW = this.qaW;
                return eVar;
            }
        }

        private a() {
            super();
            this.qaR = new C1089a();
            this.qaS = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C1090b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.eDg()) {
                boolean isShown = dVar.isShown();
                float eDl = isShown ? dVar.eDl() : -1.0f;
                boolean z5 = (isShown || this.qaS.isEmpty()) ? false : true;
                if (eDl < mVar.eDF()) {
                    eDl = mVar.getHeight() - dVar.pXv;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.qaZ = false;
                    this.qaR.qaX = eDl;
                    this.qaR.qaK = mVar;
                    this.qaR.qaV = dVar;
                    this.qaS.a(this.qaR);
                    e eCy = this.qaR.eCy();
                    eDl = this.qaR.qaX;
                    if (eCy != null) {
                        int i2 = eCy.kFF;
                        dVar3 = eCy.qaU;
                        master.flame.danmaku.danmaku.model.d dVar4 = eCy.qaT;
                        boolean z6 = eCy.qbe;
                        z2 = eCy.qaW;
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
                    boolean a2 = a(false, dVar, mVar, eDl, dVar3, null);
                    if (a2) {
                        eDl = mVar.getHeight() - dVar.pXv;
                        z4 = a2;
                        i = 1;
                    } else {
                        z3 = eDl >= ((float) mVar.eDF()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a2;
                        } else {
                            z4 = a2;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, eDl, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.eDk(), eDl);
                    if (!z) {
                        this.qaS.l(dVar2);
                        this.qaS.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C1090b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.eDF()) || !(dVar2 == null || dVar2.eDn() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C1090b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.qaZ = true;
            this.qaS.clear();
        }
    }
}
