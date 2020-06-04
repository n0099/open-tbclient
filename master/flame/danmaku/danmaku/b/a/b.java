package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public class b {
    private d nAM = null;
    private d nAN = null;
    private d nAO = null;
    private d nAP = null;

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
        xe(z);
    }

    public void xe(boolean z) {
        this.nAM = z ? new a() : new C0887b();
        this.nAN = z ? new a() : new C0887b();
        if (this.nAO == null) {
            this.nAO = new c();
        }
        if (this.nAP == null) {
            this.nAP = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nAM.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nAP.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nAO.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nAN.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nAM != null) {
            this.nAM.clear();
        }
        if (this.nAN != null) {
            this.nAN.clear();
        }
        if (this.nAO != null) {
            this.nAO.clear();
        }
        if (this.nAP != null) {
            this.nAP.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {
        public int iZR;
        public master.flame.danmaku.danmaku.model.d nAI;
        public master.flame.danmaku.danmaku.model.d nAS;
        public master.flame.danmaku.danmaku.model.d nAT;
        public boolean nAV;
        public master.flame.danmaku.danmaku.model.d nBa;
        public master.flame.danmaku.danmaku.model.d nBb;
        public boolean nBc;
        public boolean nBd;

        private e() {
            this.iZR = 0;
            this.nBa = null;
            this.nAT = null;
            this.nAI = null;
            this.nBb = null;
            this.nAS = null;
            this.nBc = false;
            this.nBd = false;
            this.nAV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0887b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nAR;
        protected boolean nAY;
        protected a nAZ;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes5.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nAJ;
            int iZR = 0;
            public master.flame.danmaku.danmaku.model.d nBa = null;
            public master.flame.danmaku.danmaku.model.d nAT = null;
            public master.flame.danmaku.danmaku.model.d nAI = null;
            public master.flame.danmaku.danmaku.model.d nBb = null;
            public master.flame.danmaku.danmaku.model.d nAU = null;
            boolean nBc = false;
            boolean nBd = false;
            boolean nAV = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dNI() {
                this.iZR = 0;
                this.nBb = null;
                this.nAI = null;
                this.nAT = null;
                this.nBa = null;
                this.nAV = false;
                this.nBd = false;
                this.nBc = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0887b.this.nAY) {
                    return 1;
                }
                this.iZR++;
                if (dVar == this.nAU) {
                    this.nBa = dVar;
                    this.nAI = null;
                    this.nBd = true;
                    this.nAV = false;
                    return 1;
                }
                if (this.nAT == null) {
                    this.nAT = dVar;
                }
                if (this.nAU.nxr + dVar.dNu() > this.nAJ.getHeight()) {
                    this.nBc = true;
                    return 1;
                }
                if (this.nBb == null) {
                    this.nBb = dVar;
                } else if (this.nBb.dNv() >= dVar.dNv()) {
                    this.nBb = dVar;
                }
                this.nAV = master.flame.danmaku.danmaku.c.b.a(this.nAJ, dVar, this.nAU, this.nAU.getDuration(), this.nAU.dNx().nxI);
                if (!this.nAV) {
                    this.nBa = dVar;
                    return 1;
                }
                this.nAI = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dOu */
            public e dMI() {
                e eVar = new e();
                eVar.iZR = this.iZR;
                eVar.nAT = this.nAT;
                eVar.nBa = this.nBa;
                eVar.nAI = this.nAI;
                eVar.nBb = this.nBb;
                eVar.nBc = this.nBc;
                eVar.nBd = this.nBd;
                eVar.nAV = this.nAV;
                return eVar;
            }
        }

        private C0887b() {
            this.nAR = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nAY = false;
            this.nAZ = new a();
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
            float dNO;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dNp()) {
                float dNO2 = mVar.dNO();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nAR.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nAY = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nAZ.nAJ = mVar;
                    this.nAZ.nAU = dVar;
                    this.nAR.a(this.nAZ);
                    e dMI = this.nAZ.dMI();
                    if (dMI == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dMI.iZR;
                        dVar6 = dMI.nBa;
                        dVar3 = dMI.nAT;
                        dVar5 = dMI.nAI;
                        master.flame.danmaku.danmaku.model.d dVar7 = dMI.nBb;
                        z5 = dMI.nBc;
                        z4 = dMI.nBd;
                        z6 = dMI.nAV;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dNO = dVar5.dNw() + margin;
                        } else {
                            dNO = dVar6.dNu();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dNO = dVar4.dNu();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dNO = dVar5.dNw() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dNO = dVar3.dNu();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dNO = mVar.dNO();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dNO, dVar3, dVar5);
                    }
                    if (z7) {
                        dNO = mVar.dNO();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dNO == mVar.dNO()) {
                        z2 = false;
                        dNO2 = dNO;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dNO2 = dNO;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dNO2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dNt(), dNO2);
                    if (!z2) {
                        this.nAR.l(dVar2);
                        this.nAR.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dNO()) || (dVar2 != null && dVar2.dNu() > 0.0f) || dVar.nxr + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nAY = true;
            this.nAR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c extends C0887b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0887b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.nxr + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends c {
        protected C0886a nAQ;
        protected master.flame.danmaku.danmaku.model.android.d nAR;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        protected class C0886a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nAJ;
            float nAW;
            int iZR = 0;
            public master.flame.danmaku.danmaku.model.d nAS = null;
            public master.flame.danmaku.danmaku.model.d nAT = null;
            public master.flame.danmaku.danmaku.model.d nAU = null;
            boolean nAV = false;

            protected C0886a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dNI() {
                this.iZR = 0;
                this.nAT = null;
                this.nAS = null;
                this.nAV = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nAY) {
                    return 1;
                }
                this.iZR++;
                if (dVar == this.nAU) {
                    this.nAS = null;
                    this.nAV = false;
                    return 1;
                }
                if (this.nAT == null) {
                    this.nAT = dVar;
                    if (this.nAT.dNw() != this.nAJ.getHeight()) {
                        return 1;
                    }
                }
                if (this.nAW < this.nAJ.dNO()) {
                    this.nAS = null;
                    return 1;
                }
                this.nAV = master.flame.danmaku.danmaku.c.b.a(this.nAJ, dVar, this.nAU, this.nAU.getDuration(), this.nAU.dNx().nxI);
                if (!this.nAV) {
                    this.nAS = dVar;
                    return 1;
                }
                this.nAW = (dVar.dNu() - this.nAJ.getMargin()) - this.nAU.nxr;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dOu */
            public e dMI() {
                e eVar = new e();
                eVar.iZR = this.iZR;
                eVar.nAT = this.nAT;
                eVar.nAS = this.nAS;
                eVar.nAV = this.nAV;
                return eVar;
            }
        }

        private a() {
            super();
            this.nAQ = new C0886a();
            this.nAR = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0887b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dNp()) {
                boolean isShown = dVar.isShown();
                float dNu = isShown ? dVar.dNu() : -1.0f;
                boolean z5 = (isShown || this.nAR.isEmpty()) ? false : true;
                if (dNu < mVar.dNO()) {
                    dNu = mVar.getHeight() - dVar.nxr;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nAY = false;
                    this.nAQ.nAW = dNu;
                    this.nAQ.nAJ = mVar;
                    this.nAQ.nAU = dVar;
                    this.nAR.a(this.nAQ);
                    e dMI = this.nAQ.dMI();
                    dNu = this.nAQ.nAW;
                    if (dMI != null) {
                        int i2 = dMI.iZR;
                        dVar3 = dMI.nAT;
                        master.flame.danmaku.danmaku.model.d dVar4 = dMI.nAS;
                        boolean z6 = dMI.nBd;
                        z2 = dMI.nAV;
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
                    boolean a = a(false, dVar, mVar, dNu, dVar3, null);
                    if (a) {
                        dNu = mVar.getHeight() - dVar.nxr;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dNu >= ((float) mVar.dNO()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dNu, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dNt(), dNu);
                    if (!z) {
                        this.nAR.l(dVar2);
                        this.nAR.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0887b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dNO()) || !(dVar2 == null || dVar2.dNw() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0887b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nAY = true;
            this.nAR.clear();
        }
    }
}
