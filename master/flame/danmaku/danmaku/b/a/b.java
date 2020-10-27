package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public class b {
    private d pPQ = null;
    private d pPR = null;
    private d pPS = null;
    private d pPT = null;

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
        AV(z);
    }

    public void AV(boolean z) {
        this.pPQ = z ? new a() : new C1067b();
        this.pPR = z ? new a() : new C1067b();
        if (this.pPS == null) {
            this.pPS = new c();
        }
        if (this.pPT == null) {
            this.pPT = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.pPQ.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.pPT.a(dVar, mVar, fVar);
                return;
            case 5:
                this.pPS.a(dVar, mVar, fVar);
                return;
            case 6:
                this.pPR.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.pPQ != null) {
            this.pPQ.clear();
        }
        if (this.pPR != null) {
            this.pPR.clear();
        }
        if (this.pPS != null) {
            this.pPS.clear();
        }
        if (this.pPT != null) {
            this.pPT.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int kzw;
        public master.flame.danmaku.danmaku.model.d pPM;
        public master.flame.danmaku.danmaku.model.d pPW;
        public master.flame.danmaku.danmaku.model.d pPX;
        public boolean pPZ;
        public master.flame.danmaku.danmaku.model.d pQe;
        public master.flame.danmaku.danmaku.model.d pQf;
        public boolean pQg;
        public boolean pQh;

        private e() {
            this.kzw = 0;
            this.pQe = null;
            this.pPX = null;
            this.pPM = null;
            this.pQf = null;
            this.pPW = null;
            this.pQg = false;
            this.pQh = false;
            this.pPZ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1067b implements d {
        protected master.flame.danmaku.danmaku.model.android.d pPV;
        protected boolean pQc;
        protected a pQd;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes6.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m pPN;
            int kzw = 0;
            public master.flame.danmaku.danmaku.model.d pQe = null;
            public master.flame.danmaku.danmaku.model.d pPX = null;
            public master.flame.danmaku.danmaku.model.d pPM = null;
            public master.flame.danmaku.danmaku.model.d pQf = null;
            public master.flame.danmaku.danmaku.model.d pPY = null;
            boolean pQg = false;
            boolean pQh = false;
            boolean pPZ = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void ezJ() {
                this.kzw = 0;
                this.pQf = null;
                this.pPM = null;
                this.pPX = null;
                this.pQe = null;
                this.pPZ = false;
                this.pQh = false;
                this.pQg = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                if (C1067b.this.pQc) {
                    return 1;
                }
                this.kzw++;
                if (dVar == this.pPY) {
                    this.pQe = dVar;
                    this.pPM = null;
                    this.pQh = true;
                    this.pPZ = false;
                    return 1;
                }
                if (this.pPX == null) {
                    this.pPX = dVar;
                }
                if (this.pPY.pMy + dVar.ezv() > this.pPN.getHeight()) {
                    this.pQg = true;
                    return 1;
                }
                if (this.pQf == null) {
                    this.pQf = dVar;
                } else if (this.pQf.ezw() >= dVar.ezw()) {
                    this.pQf = dVar;
                }
                this.pPZ = master.flame.danmaku.danmaku.c.b.a(this.pPN, dVar, this.pPY, this.pPY.getDuration(), this.pPY.ezy().pMO);
                if (!this.pPZ) {
                    this.pQe = dVar;
                    return 1;
                }
                this.pPM = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eAv */
            public e eyI() {
                e eVar = new e();
                eVar.kzw = this.kzw;
                eVar.pPX = this.pPX;
                eVar.pQe = this.pQe;
                eVar.pPM = this.pPM;
                eVar.pQf = this.pQf;
                eVar.pQg = this.pQg;
                eVar.pQh = this.pQh;
                eVar.pPZ = this.pPZ;
                return eVar;
            }
        }

        private C1067b() {
            this.pPV = new master.flame.danmaku.danmaku.model.android.d(1);
            this.pQc = false;
            this.pQd = new a();
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
            float ezP;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.ezq()) {
                float ezP2 = mVar.ezP();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.pPV.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.pQc = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.pQd.pPN = mVar;
                    this.pQd.pPY = dVar;
                    this.pPV.a(this.pQd);
                    e eyI = this.pQd.eyI();
                    if (eyI == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = eyI.kzw;
                        dVar6 = eyI.pQe;
                        dVar3 = eyI.pPX;
                        dVar5 = eyI.pPM;
                        master.flame.danmaku.danmaku.model.d dVar7 = eyI.pQf;
                        z5 = eyI.pQg;
                        z4 = eyI.pQh;
                        z6 = eyI.pPZ;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            ezP = dVar5.ezx() + margin;
                        } else {
                            ezP = dVar6.ezv();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        ezP = dVar4.ezv();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        ezP = dVar5.ezx() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        ezP = dVar3.ezv();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        ezP = mVar.ezP();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, ezP, dVar3, dVar5);
                    }
                    if (z7) {
                        ezP = mVar.ezP();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (ezP == mVar.ezP()) {
                        z2 = false;
                        ezP2 = ezP;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        ezP2 = ezP;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, ezP2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.ezu(), ezP2);
                    if (!z2) {
                        this.pPV.l(dVar2);
                        this.pPV.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.ezP()) || (dVar2 != null && dVar2.ezv() > 0.0f) || dVar.pMy + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.pQc = true;
            this.pPV.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c extends C1067b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C1067b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.pMy + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends c {
        protected C1066a pPU;
        protected master.flame.danmaku.danmaku.model.android.d pPV;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        protected class C1066a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m pPN;
            float pQa;
            int kzw = 0;
            public master.flame.danmaku.danmaku.model.d pPW = null;
            public master.flame.danmaku.danmaku.model.d pPX = null;
            public master.flame.danmaku.danmaku.model.d pPY = null;
            boolean pPZ = false;

            protected C1066a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void ezJ() {
                this.kzw = 0;
                this.pPX = null;
                this.pPW = null;
                this.pPZ = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.pQc) {
                    return 1;
                }
                this.kzw++;
                if (dVar == this.pPY) {
                    this.pPW = null;
                    this.pPZ = false;
                    return 1;
                }
                if (this.pPX == null) {
                    this.pPX = dVar;
                    if (this.pPX.ezx() != this.pPN.getHeight()) {
                        return 1;
                    }
                }
                if (this.pQa < this.pPN.ezP()) {
                    this.pPW = null;
                    return 1;
                }
                this.pPZ = master.flame.danmaku.danmaku.c.b.a(this.pPN, dVar, this.pPY, this.pPY.getDuration(), this.pPY.ezy().pMO);
                if (!this.pPZ) {
                    this.pPW = dVar;
                    return 1;
                }
                this.pQa = (dVar.ezv() - this.pPN.getMargin()) - this.pPY.pMy;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: eAv */
            public e eyI() {
                e eVar = new e();
                eVar.kzw = this.kzw;
                eVar.pPX = this.pPX;
                eVar.pPW = this.pPW;
                eVar.pPZ = this.pPZ;
                return eVar;
            }
        }

        private a() {
            super();
            this.pPU = new C1066a();
            this.pPV = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C1067b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.ezq()) {
                boolean isShown = dVar.isShown();
                float ezv = isShown ? dVar.ezv() : -1.0f;
                boolean z5 = (isShown || this.pPV.isEmpty()) ? false : true;
                if (ezv < mVar.ezP()) {
                    ezv = mVar.getHeight() - dVar.pMy;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.pQc = false;
                    this.pPU.pQa = ezv;
                    this.pPU.pPN = mVar;
                    this.pPU.pPY = dVar;
                    this.pPV.a(this.pPU);
                    e eyI = this.pPU.eyI();
                    ezv = this.pPU.pQa;
                    if (eyI != null) {
                        int i2 = eyI.kzw;
                        dVar3 = eyI.pPX;
                        master.flame.danmaku.danmaku.model.d dVar4 = eyI.pPW;
                        boolean z6 = eyI.pQh;
                        z2 = eyI.pPZ;
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
                    boolean a2 = a(false, dVar, mVar, ezv, dVar3, null);
                    if (a2) {
                        ezv = mVar.getHeight() - dVar.pMy;
                        z4 = a2;
                        i = 1;
                    } else {
                        z3 = ezv >= ((float) mVar.ezP()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a2;
                        } else {
                            z4 = a2;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, ezv, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.ezu(), ezv);
                    if (!z) {
                        this.pPV.l(dVar2);
                        this.pPV.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C1067b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.ezP()) || !(dVar2 == null || dVar2.ezx() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C1067b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.pQc = true;
            this.pPV.clear();
        }
    }
}
