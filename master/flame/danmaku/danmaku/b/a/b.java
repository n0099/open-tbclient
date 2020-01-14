package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes4.dex */
public class b {
    private d nIe = null;
    private d nIf = null;
    private d nIg = null;
    private d nIh = null;

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
        this.nIe = z ? new a() : new C0771b();
        this.nIf = z ? new a() : new C0771b();
        if (this.nIg == null) {
            this.nIg = new c();
        }
        if (this.nIh == null) {
            this.nIh = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.nIe.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.nIh.a(dVar, mVar, fVar);
                return;
            case 5:
                this.nIg.a(dVar, mVar, fVar);
                return;
            case 6:
                this.nIf.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.nIe != null) {
            this.nIe.clear();
        }
        if (this.nIf != null) {
            this.nIf.clear();
        }
        if (this.nIg != null) {
            this.nIg.clear();
        }
        if (this.nIh != null) {
            this.nIh.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e {
        public int hWu;
        public master.flame.danmaku.danmaku.model.d nIa;
        public master.flame.danmaku.danmaku.model.d nIk;
        public master.flame.danmaku.danmaku.model.d nIl;
        public boolean nIn;
        public master.flame.danmaku.danmaku.model.d nIs;
        public master.flame.danmaku.danmaku.model.d nIt;
        public boolean nIu;
        public boolean nIv;

        private e() {
            this.hWu = 0;
            this.nIs = null;
            this.nIl = null;
            this.nIa = null;
            this.nIt = null;
            this.nIk = null;
            this.nIu = false;
            this.nIv = false;
            this.nIn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0771b implements d {
        protected master.flame.danmaku.danmaku.model.android.d nIj;
        protected boolean nIq;
        protected a nIr;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes4.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nIb;
            int hWu = 0;
            public master.flame.danmaku.danmaku.model.d nIs = null;
            public master.flame.danmaku.danmaku.model.d nIl = null;
            public master.flame.danmaku.danmaku.model.d nIa = null;
            public master.flame.danmaku.danmaku.model.d nIt = null;
            public master.flame.danmaku.danmaku.model.d nIm = null;
            boolean nIu = false;
            boolean nIv = false;
            boolean nIn = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dKN() {
                this.hWu = 0;
                this.nIt = null;
                this.nIa = null;
                this.nIl = null;
                this.nIs = null;
                this.nIn = false;
                this.nIv = false;
                this.nIu = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0771b.this.nIq) {
                    return 1;
                }
                this.hWu++;
                if (dVar == this.nIm) {
                    this.nIs = dVar;
                    this.nIa = null;
                    this.nIv = true;
                    this.nIn = false;
                    return 1;
                }
                if (this.nIl == null) {
                    this.nIl = dVar;
                }
                if (this.nIm.nEJ + dVar.dKz() > this.nIb.getHeight()) {
                    this.nIu = true;
                    return 1;
                }
                if (this.nIt == null) {
                    this.nIt = dVar;
                } else if (this.nIt.dKA() >= dVar.dKA()) {
                    this.nIt = dVar;
                }
                this.nIn = master.flame.danmaku.danmaku.c.b.a(this.nIb, dVar, this.nIm, this.nIm.getDuration(), this.nIm.dKC().nEZ);
                if (!this.nIn) {
                    this.nIs = dVar;
                    return 1;
                }
                this.nIa = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dLz */
            public e dJN() {
                e eVar = new e();
                eVar.hWu = this.hWu;
                eVar.nIl = this.nIl;
                eVar.nIs = this.nIs;
                eVar.nIa = this.nIa;
                eVar.nIt = this.nIt;
                eVar.nIu = this.nIu;
                eVar.nIv = this.nIv;
                eVar.nIn = this.nIn;
                return eVar;
            }
        }

        private C0771b() {
            this.nIj = new master.flame.danmaku.danmaku.model.android.d(1);
            this.nIq = false;
            this.nIr = new a();
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
            float dKT;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dKu()) {
                float dKT2 = mVar.dKT();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.nIj.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.nIq = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.nIr.nIb = mVar;
                    this.nIr.nIm = dVar;
                    this.nIj.a(this.nIr);
                    e dJN = this.nIr.dJN();
                    if (dJN == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dJN.hWu;
                        dVar6 = dJN.nIs;
                        dVar3 = dJN.nIl;
                        dVar5 = dJN.nIa;
                        master.flame.danmaku.danmaku.model.d dVar7 = dJN.nIt;
                        z5 = dJN.nIu;
                        z4 = dJN.nIv;
                        z6 = dJN.nIn;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dKT = dVar5.dKB() + margin;
                        } else {
                            dKT = dVar6.dKz();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dKT = dVar4.dKz();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dKT = dVar5.dKB() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dKT = dVar3.dKz();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dKT = mVar.dKT();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dKT, dVar3, dVar5);
                    }
                    if (z7) {
                        dKT = mVar.dKT();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dKT == mVar.dKT()) {
                        z2 = false;
                        dKT2 = dKT;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dKT2 = dKT;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dKT2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dKy(), dKT2);
                    if (!z2) {
                        this.nIj.l(dVar2);
                        this.nIj.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dKT()) || (dVar2 != null && dVar2.dKz() > 0.0f) || dVar.nEJ + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nIq = true;
            this.nIj.clear();
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
            return dVar.nEJ + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends c {
        protected C0770a nIi;
        protected master.flame.danmaku.danmaku.model.android.d nIj;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        protected class C0770a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m nIb;
            float nIo;
            int hWu = 0;
            public master.flame.danmaku.danmaku.model.d nIk = null;
            public master.flame.danmaku.danmaku.model.d nIl = null;
            public master.flame.danmaku.danmaku.model.d nIm = null;
            boolean nIn = false;

            protected C0770a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dKN() {
                this.hWu = 0;
                this.nIl = null;
                this.nIk = null;
                this.nIn = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.nIq) {
                    return 1;
                }
                this.hWu++;
                if (dVar == this.nIm) {
                    this.nIk = null;
                    this.nIn = false;
                    return 1;
                }
                if (this.nIl == null) {
                    this.nIl = dVar;
                    if (this.nIl.dKB() != this.nIb.getHeight()) {
                        return 1;
                    }
                }
                if (this.nIo < this.nIb.dKT()) {
                    this.nIk = null;
                    return 1;
                }
                this.nIn = master.flame.danmaku.danmaku.c.b.a(this.nIb, dVar, this.nIm, this.nIm.getDuration(), this.nIm.dKC().nEZ);
                if (!this.nIn) {
                    this.nIk = dVar;
                    return 1;
                }
                this.nIo = (dVar.dKz() - this.nIb.getMargin()) - this.nIm.nEJ;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dLz */
            public e dJN() {
                e eVar = new e();
                eVar.hWu = this.hWu;
                eVar.nIl = this.nIl;
                eVar.nIk = this.nIk;
                eVar.nIn = this.nIn;
                return eVar;
            }
        }

        private a() {
            super();
            this.nIi = new C0770a();
            this.nIj = new master.flame.danmaku.danmaku.model.android.d(2);
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
            if (!dVar.dKu()) {
                boolean isShown = dVar.isShown();
                float dKz = isShown ? dVar.dKz() : -1.0f;
                boolean z5 = (isShown || this.nIj.isEmpty()) ? false : true;
                if (dKz < mVar.dKT()) {
                    dKz = mVar.getHeight() - dVar.nEJ;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.nIq = false;
                    this.nIi.nIo = dKz;
                    this.nIi.nIb = mVar;
                    this.nIi.nIm = dVar;
                    this.nIj.a(this.nIi);
                    e dJN = this.nIi.dJN();
                    dKz = this.nIi.nIo;
                    if (dJN != null) {
                        int i2 = dJN.hWu;
                        dVar3 = dJN.nIl;
                        master.flame.danmaku.danmaku.model.d dVar4 = dJN.nIk;
                        boolean z6 = dJN.nIv;
                        z2 = dJN.nIn;
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
                    boolean a = a(false, dVar, mVar, dKz, dVar3, null);
                    if (a) {
                        dKz = mVar.getHeight() - dVar.nEJ;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dKz >= ((float) mVar.dKT()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dKz, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dKy(), dKz);
                    if (!z) {
                        this.nIj.l(dVar2);
                        this.nIj.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0771b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dKT()) || !(dVar2 == null || dVar2.dKB() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0771b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.nIq = true;
            this.nIj.clear();
        }
    }
}
