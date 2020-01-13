package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes4.dex */
public class b {
    private d nHZ = null;
    private d nIa = null;
    private d nIb = null;
    private d nIc = null;

    /* loaded from: classes4.dex */
    public interface d {
        void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar);

        void clear();
    }

    /* loaded from: classes4.dex */
    public interface f {
        boolean a(master.flame.danmaku.danmaku.model.d dVar, float f, int i, boolean z);
    }

    public b(boolean z) {
        wO(z);
    }

    public void wO(boolean z) {
        this.nHZ = z ? new a() : new C0771b();
        this.nIa = z ? new a() : new C0771b();
        if (this.nIb == null) {
            this.nIb = new c();
        }
        if (this.nIc == null) {
            this.nIc = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nHZ.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nIc.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nIb.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nIa.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nHZ != null) {
            this.nHZ.clear();
        }
        if (this.nIa != null) {
            this.nIa.clear();
        }
        if (this.nIb != null) {
            this.nIb.clear();
        }
        if (this.nIc != null) {
            this.nIc.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e {
        public int hWu;
        public master.flame.danmaku.danmaku.model.d nHV;
        public master.flame.danmaku.danmaku.model.d nIf;
        public master.flame.danmaku.danmaku.model.d nIg;
        public boolean nIi;
        public master.flame.danmaku.danmaku.model.d nIn;
        public master.flame.danmaku.danmaku.model.d nIo;
        public boolean nIp;
        public boolean nIq;

        private e() {
            this.hWu = 0;
            this.nIn = null;
            this.nIg = null;
            this.nHV = null;
            this.nIo = null;
            this.nIf = null;
            this.nIp = false;
            this.nIq = false;
            this.nIi = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0771b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nIe;
        protected boolean nIl;
        protected a nIm;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes4.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nHW;
            int hWu = 0;
            public master.flame.danmaku.danmaku.model.d nIn = null;
            public master.flame.danmaku.danmaku.model.d nIg = null;
            public master.flame.danmaku.danmaku.model.d nHV = null;
            public master.flame.danmaku.danmaku.model.d nIo = null;
            public master.flame.danmaku.danmaku.model.d nIh = null;
            boolean nIp = false;
            boolean nIq = false;
            boolean nIi = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dKL() {
                this.hWu = 0;
                this.nIo = null;
                this.nHV = null;
                this.nIg = null;
                this.nIn = null;
                this.nIi = false;
                this.nIq = false;
                this.nIp = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0771b.this.nIl) {
                    return 1;
                }
                this.hWu++;
                if (dVar == this.nIh) {
                    this.nIn = dVar;
                    this.nHV = null;
                    this.nIq = true;
                    this.nIi = false;
                    return 1;
                }
                if (this.nIg == null) {
                    this.nIg = dVar;
                }
                if (this.nIh.nEE + dVar.dKx() > this.nHW.getHeight()) {
                    this.nIp = true;
                    return 1;
                }
                if (this.nIo == null) {
                    this.nIo = dVar;
                } else if (this.nIo.dKy() >= dVar.dKy()) {
                    this.nIo = dVar;
                }
                this.nIi = master.flame.danmaku.danmaku.c.b.a(this.nHW, dVar, this.nIh, this.nIh.getDuration(), this.nIh.dKA().nEU);
                if (!this.nIi) {
                    this.nIn = dVar;
                    return 1;
                }
                this.nHV = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dLx */
            public e dJL() {
                e eVar = new e();
                eVar.hWu = this.hWu;
                eVar.nIg = this.nIg;
                eVar.nIn = this.nIn;
                eVar.nHV = this.nHV;
                eVar.nIo = this.nIo;
                eVar.nIp = this.nIp;
                eVar.nIq = this.nIq;
                eVar.nIi = this.nIi;
                return eVar;
            }
        }

        private C0771b() {
            this.nIe = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nIl = false;
            this.nIm = new a();
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
            float dKR;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dKs()) {
                float dKR2 = mVar.dKR();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nIe.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nIl = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nIm.nHW = mVar;
                    this.nIm.nIh = dVar;
                    this.nIe.a(this.nIm);
                    e dJL = this.nIm.dJL();
                    if (dJL == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dJL.hWu;
                        dVar6 = dJL.nIn;
                        dVar3 = dJL.nIg;
                        dVar5 = dJL.nHV;
                        master.flame.danmaku.danmaku.model.d dVar7 = dJL.nIo;
                        z5 = dJL.nIp;
                        z4 = dJL.nIq;
                        z6 = dJL.nIi;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dKR = dVar5.dKz() + margin;
                        } else {
                            dKR = dVar6.dKx();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dKR = dVar4.dKx();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dKR = dVar5.dKz() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dKR = dVar3.dKx();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dKR = mVar.dKR();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dKR, dVar3, dVar5);
                    }
                    if (z7) {
                        dKR = mVar.dKR();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dKR == mVar.dKR()) {
                        z2 = false;
                        dKR2 = dKR;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dKR2 = dKR;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dKR2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dKw(), dKR2);
                    if (!z2) {
                        this.nIe.l(dVar2);
                        this.nIe.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dKR()) || (dVar2 != null && dVar2.dKx() > 0.0f) || dVar.nEE + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nIl = true;
            this.nIe.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends C0771b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0771b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.nEE + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends c {
        protected C0770a nId;
        protected master.flame.danmaku.danmaku.model.android.d nIe;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        protected class C0770a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nHW;
            float nIj;
            int hWu = 0;
            public master.flame.danmaku.danmaku.model.d nIf = null;
            public master.flame.danmaku.danmaku.model.d nIg = null;
            public master.flame.danmaku.danmaku.model.d nIh = null;
            boolean nIi = false;

            protected C0770a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dKL() {
                this.hWu = 0;
                this.nIg = null;
                this.nIf = null;
                this.nIi = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nIl) {
                    return 1;
                }
                this.hWu++;
                if (dVar == this.nIh) {
                    this.nIf = null;
                    this.nIi = false;
                    return 1;
                }
                if (this.nIg == null) {
                    this.nIg = dVar;
                    if (this.nIg.dKz() != this.nHW.getHeight()) {
                        return 1;
                    }
                }
                if (this.nIj < this.nHW.dKR()) {
                    this.nIf = null;
                    return 1;
                }
                this.nIi = master.flame.danmaku.danmaku.c.b.a(this.nHW, dVar, this.nIh, this.nIh.getDuration(), this.nIh.dKA().nEU);
                if (!this.nIi) {
                    this.nIf = dVar;
                    return 1;
                }
                this.nIj = (dVar.dKx() - this.nHW.getMargin()) - this.nIh.nEE;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dLx */
            public e dJL() {
                e eVar = new e();
                eVar.hWu = this.hWu;
                eVar.nIg = this.nIg;
                eVar.nIf = this.nIf;
                eVar.nIi = this.nIi;
                return eVar;
            }
        }

        private a() {
            super();
            this.nId = new C0770a();
            this.nIe = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0771b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dKs()) {
                boolean isShown = dVar.isShown();
                float dKx = isShown ? dVar.dKx() : -1.0f;
                boolean z5 = (isShown || this.nIe.isEmpty()) ? false : true;
                if (dKx < mVar.dKR()) {
                    dKx = mVar.getHeight() - dVar.nEE;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nIl = false;
                    this.nId.nIj = dKx;
                    this.nId.nHW = mVar;
                    this.nId.nIh = dVar;
                    this.nIe.a(this.nId);
                    e dJL = this.nId.dJL();
                    dKx = this.nId.nIj;
                    if (dJL != null) {
                        int i2 = dJL.hWu;
                        dVar3 = dJL.nIg;
                        master.flame.danmaku.danmaku.model.d dVar4 = dJL.nIf;
                        boolean z6 = dJL.nIq;
                        z2 = dJL.nIi;
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
                    boolean a = a(false, dVar, mVar, dKx, dVar3, null);
                    if (a) {
                        dKx = mVar.getHeight() - dVar.nEE;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dKx >= ((float) mVar.dKR()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dKx, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dKw(), dKx);
                    if (!z) {
                        this.nIe.l(dVar2);
                        this.nIe.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0771b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dKR()) || !(dVar2 == null || dVar2.dKz() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0771b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nIl = true;
            this.nIe.clear();
        }
    }
}
