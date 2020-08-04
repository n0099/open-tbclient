package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public class b {
    private d ofn = null;
    private d ofo = null;
    private d ofp = null;
    private d ofq = null;

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
        ye(z);
    }

    public void ye(boolean z) {
        this.ofn = z ? new a() : new C0922b();
        this.ofo = z ? new a() : new C0922b();
        if (this.ofp == null) {
            this.ofp = new c();
        }
        if (this.ofq == null) {
            this.ofq = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.ofn.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.ofq.a(dVar, mVar, fVar);
                return;
            case 5:
                this.ofp.a(dVar, mVar, fVar);
                return;
            case 6:
                this.ofo.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.ofn != null) {
            this.ofn.clear();
        }
        if (this.ofo != null) {
            this.ofo.clear();
        }
        if (this.ofp != null) {
            this.ofp.clear();
        }
        if (this.ofq != null) {
            this.ofq.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int jzG;
        public master.flame.danmaku.danmaku.model.d ofB;
        public master.flame.danmaku.danmaku.model.d ofC;
        public boolean ofD;
        public boolean ofE;
        public master.flame.danmaku.danmaku.model.d ofj;
        public master.flame.danmaku.danmaku.model.d oft;
        public master.flame.danmaku.danmaku.model.d ofu;
        public boolean ofw;

        private e() {
            this.jzG = 0;
            this.ofB = null;
            this.ofu = null;
            this.ofj = null;
            this.ofC = null;
            this.oft = null;
            this.ofD = false;
            this.ofE = false;
            this.ofw = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0922b implements d {
        protected a ofA;
        protected master.flame.danmaku.danmaku.model.android.d ofs;
        protected boolean ofz;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes6.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m ofk;
            int jzG = 0;
            public master.flame.danmaku.danmaku.model.d ofB = null;
            public master.flame.danmaku.danmaku.model.d ofu = null;
            public master.flame.danmaku.danmaku.model.d ofj = null;
            public master.flame.danmaku.danmaku.model.d ofC = null;
            public master.flame.danmaku.danmaku.model.d ofv = null;
            boolean ofD = false;
            boolean ofE = false;
            boolean ofw = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dVP() {
                this.jzG = 0;
                this.ofC = null;
                this.ofj = null;
                this.ofu = null;
                this.ofB = null;
                this.ofw = false;
                this.ofE = false;
                this.ofD = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0922b.this.ofz) {
                    return 1;
                }
                this.jzG++;
                if (dVar == this.ofv) {
                    this.ofB = dVar;
                    this.ofj = null;
                    this.ofE = true;
                    this.ofw = false;
                    return 1;
                }
                if (this.ofu == null) {
                    this.ofu = dVar;
                }
                if (this.ofv.obR + dVar.dVB() > this.ofk.getHeight()) {
                    this.ofD = true;
                    return 1;
                }
                if (this.ofC == null) {
                    this.ofC = dVar;
                } else if (this.ofC.dVC() >= dVar.dVC()) {
                    this.ofC = dVar;
                }
                this.ofw = master.flame.danmaku.danmaku.c.b.a(this.ofk, dVar, this.ofv, this.ofv.getDuration(), this.ofv.dVE().och);
                if (!this.ofw) {
                    this.ofB = dVar;
                    return 1;
                }
                this.ofj = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dWB */
            public e dUP() {
                e eVar = new e();
                eVar.jzG = this.jzG;
                eVar.ofu = this.ofu;
                eVar.ofB = this.ofB;
                eVar.ofj = this.ofj;
                eVar.ofC = this.ofC;
                eVar.ofD = this.ofD;
                eVar.ofE = this.ofE;
                eVar.ofw = this.ofw;
                return eVar;
            }
        }

        private C0922b() {
            this.ofs = new master.flame.danmaku.danmaku.model.android.d(1);
            this.ofz = false;
            this.ofA = new a();
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
            float dVV;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dVw()) {
                float dVV2 = mVar.dVV();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.ofs.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.ofz = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.ofA.ofk = mVar;
                    this.ofA.ofv = dVar;
                    this.ofs.a(this.ofA);
                    e dUP = this.ofA.dUP();
                    if (dUP == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dUP.jzG;
                        dVar6 = dUP.ofB;
                        dVar3 = dUP.ofu;
                        dVar5 = dUP.ofj;
                        master.flame.danmaku.danmaku.model.d dVar7 = dUP.ofC;
                        z5 = dUP.ofD;
                        z4 = dUP.ofE;
                        z6 = dUP.ofw;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dVV = dVar5.dVD() + margin;
                        } else {
                            dVV = dVar6.dVB();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dVV = dVar4.dVB();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dVV = dVar5.dVD() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dVV = dVar3.dVB();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dVV = mVar.dVV();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dVV, dVar3, dVar5);
                    }
                    if (z7) {
                        dVV = mVar.dVV();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dVV == mVar.dVV()) {
                        z2 = false;
                        dVV2 = dVV;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dVV2 = dVV;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dVV2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dVA(), dVV2);
                    if (!z2) {
                        this.ofs.l(dVar2);
                        this.ofs.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dVV()) || (dVar2 != null && dVar2.dVB() > 0.0f) || dVar.obR + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.ofz = true;
            this.ofs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c extends C0922b {
        private c() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0922b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return dVar.obR + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends c {
        protected C0921a ofr;
        protected master.flame.danmaku.danmaku.model.android.d ofs;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        protected class C0921a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m ofk;
            float ofx;
            int jzG = 0;
            public master.flame.danmaku.danmaku.model.d oft = null;
            public master.flame.danmaku.danmaku.model.d ofu = null;
            public master.flame.danmaku.danmaku.model.d ofv = null;
            boolean ofw = false;

            protected C0921a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dVP() {
                this.jzG = 0;
                this.ofu = null;
                this.oft = null;
                this.ofw = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.ofz) {
                    return 1;
                }
                this.jzG++;
                if (dVar == this.ofv) {
                    this.oft = null;
                    this.ofw = false;
                    return 1;
                }
                if (this.ofu == null) {
                    this.ofu = dVar;
                    if (this.ofu.dVD() != this.ofk.getHeight()) {
                        return 1;
                    }
                }
                if (this.ofx < this.ofk.dVV()) {
                    this.oft = null;
                    return 1;
                }
                this.ofw = master.flame.danmaku.danmaku.c.b.a(this.ofk, dVar, this.ofv, this.ofv.getDuration(), this.ofv.dVE().och);
                if (!this.ofw) {
                    this.oft = dVar;
                    return 1;
                }
                this.ofx = (dVar.dVB() - this.ofk.getMargin()) - this.ofv.obR;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dWB */
            public e dUP() {
                e eVar = new e();
                eVar.jzG = this.jzG;
                eVar.ofu = this.ofu;
                eVar.oft = this.oft;
                eVar.ofw = this.ofw;
                return eVar;
            }
        }

        private a() {
            super();
            this.ofr = new C0921a();
            this.ofs = new master.flame.danmaku.danmaku.model.android.d(2);
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0922b, master.flame.danmaku.danmaku.b.a.b.d
        public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
            master.flame.danmaku.danmaku.model.d dVar2;
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.d dVar3;
            boolean z2;
            boolean z3 = true;
            boolean z4 = false;
            if (!dVar.dVw()) {
                boolean isShown = dVar.isShown();
                float dVB = isShown ? dVar.dVB() : -1.0f;
                boolean z5 = (isShown || this.ofs.isEmpty()) ? false : true;
                if (dVB < mVar.dVV()) {
                    dVB = mVar.getHeight() - dVar.obR;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.ofz = false;
                    this.ofr.ofx = dVB;
                    this.ofr.ofk = mVar;
                    this.ofr.ofv = dVar;
                    this.ofs.a(this.ofr);
                    e dUP = this.ofr.dUP();
                    dVB = this.ofr.ofx;
                    if (dUP != null) {
                        int i2 = dUP.jzG;
                        dVar3 = dUP.ofu;
                        master.flame.danmaku.danmaku.model.d dVar4 = dUP.oft;
                        boolean z6 = dUP.ofE;
                        z2 = dUP.ofw;
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
                    boolean a = a(false, dVar, mVar, dVB, dVar3, null);
                    if (a) {
                        dVB = mVar.getHeight() - dVar.obR;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dVB >= ((float) mVar.dVV()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dVB, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dVA(), dVB);
                    if (!z) {
                        this.ofs.l(dVar2);
                        this.ofs.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0922b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dVV()) || !(dVar2 == null || dVar2.dVD() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0922b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.ofz = true;
            this.ofs.clear();
        }
    }
}
