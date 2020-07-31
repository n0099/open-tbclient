package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public class b {
    private d ofl = null;
    private d ofm = null;
    private d ofn = null;
    private d ofo = null;

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
        this.ofl = z ? new a() : new C0922b();
        this.ofm = z ? new a() : new C0922b();
        if (this.ofn == null) {
            this.ofn = new c();
        }
        if (this.ofo == null) {
            this.ofo = new a();
        }
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, m mVar, f fVar) {
        switch (dVar.getType()) {
            case 1:
                this.ofl.a(dVar, mVar, fVar);
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                this.ofo.a(dVar, mVar, fVar);
                return;
            case 5:
                this.ofn.a(dVar, mVar, fVar);
                return;
            case 6:
                this.ofm.a(dVar, mVar, fVar);
                return;
            case 7:
                dVar.a(mVar, 0.0f, 0.0f);
                return;
        }
    }

    public void clear() {
        if (this.ofl != null) {
            this.ofl.clear();
        }
        if (this.ofm != null) {
            this.ofm.clear();
        }
        if (this.ofn != null) {
            this.ofn.clear();
        }
        if (this.ofo != null) {
            this.ofo.clear();
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {
        public int jzE;
        public master.flame.danmaku.danmaku.model.d ofA;
        public boolean ofB;
        public boolean ofC;
        public master.flame.danmaku.danmaku.model.d ofh;
        public master.flame.danmaku.danmaku.model.d ofr;
        public master.flame.danmaku.danmaku.model.d ofs;
        public boolean ofu;
        public master.flame.danmaku.danmaku.model.d ofz;

        private e() {
            this.jzE = 0;
            this.ofz = null;
            this.ofs = null;
            this.ofh = null;
            this.ofA = null;
            this.ofr = null;
            this.ofB = false;
            this.ofC = false;
            this.ofu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: master.flame.danmaku.danmaku.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0922b implements d {
        protected master.flame.danmaku.danmaku.model.android.d ofq;
        protected boolean ofx;
        protected a ofy;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$b$a */
        /* loaded from: classes6.dex */
        protected class a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m ofi;
            int jzE = 0;
            public master.flame.danmaku.danmaku.model.d ofz = null;
            public master.flame.danmaku.danmaku.model.d ofs = null;
            public master.flame.danmaku.danmaku.model.d ofh = null;
            public master.flame.danmaku.danmaku.model.d ofA = null;
            public master.flame.danmaku.danmaku.model.d oft = null;
            boolean ofB = false;
            boolean ofC = false;
            boolean ofu = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dVO() {
                this.jzE = 0;
                this.ofA = null;
                this.ofh = null;
                this.ofs = null;
                this.ofz = null;
                this.ofu = false;
                this.ofC = false;
                this.ofB = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0922b.this.ofx) {
                    return 1;
                }
                this.jzE++;
                if (dVar == this.oft) {
                    this.ofz = dVar;
                    this.ofh = null;
                    this.ofC = true;
                    this.ofu = false;
                    return 1;
                }
                if (this.ofs == null) {
                    this.ofs = dVar;
                }
                if (this.oft.obP + dVar.dVA() > this.ofi.getHeight()) {
                    this.ofB = true;
                    return 1;
                }
                if (this.ofA == null) {
                    this.ofA = dVar;
                } else if (this.ofA.dVB() >= dVar.dVB()) {
                    this.ofA = dVar;
                }
                this.ofu = master.flame.danmaku.danmaku.c.b.a(this.ofi, dVar, this.oft, this.oft.getDuration(), this.oft.dVD().ocf);
                if (!this.ofu) {
                    this.ofz = dVar;
                    return 1;
                }
                this.ofh = dVar;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dWA */
            public e dUO() {
                e eVar = new e();
                eVar.jzE = this.jzE;
                eVar.ofs = this.ofs;
                eVar.ofz = this.ofz;
                eVar.ofh = this.ofh;
                eVar.ofA = this.ofA;
                eVar.ofB = this.ofB;
                eVar.ofC = this.ofC;
                eVar.ofu = this.ofu;
                return eVar;
            }
        }

        private C0922b() {
            this.ofq = new master.flame.danmaku.danmaku.model.android.d(1);
            this.ofx = false;
            this.ofy = new a();
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
            float dVU;
            boolean z7;
            boolean z8;
            int i2;
            if (!dVar.dVv()) {
                float dVU2 = mVar.dVU();
                int i3 = 0;
                boolean isShown = dVar.isShown();
                boolean z9 = (isShown || this.ofq.isEmpty()) ? false : true;
                int margin = mVar.getMargin();
                if (isShown) {
                    z = z9;
                    dVar2 = null;
                    z2 = isShown;
                    z3 = false;
                } else {
                    this.ofx = false;
                    master.flame.danmaku.danmaku.model.d dVar6 = null;
                    this.ofy.ofi = mVar;
                    this.ofy.oft = dVar;
                    this.ofq.a(this.ofy);
                    e dUO = this.ofy.dUO();
                    if (dUO == null) {
                        z4 = isShown;
                        z5 = false;
                        dVar3 = null;
                        i = 0;
                        dVar4 = null;
                        dVar5 = null;
                        z6 = z9;
                    } else {
                        i = dUO.jzE;
                        dVar6 = dUO.ofz;
                        dVar3 = dUO.ofs;
                        dVar5 = dUO.ofh;
                        master.flame.danmaku.danmaku.model.d dVar7 = dUO.ofA;
                        z5 = dUO.ofB;
                        z4 = dUO.ofC;
                        z6 = dUO.ofu;
                        dVar4 = dVar7;
                    }
                    boolean z10 = true;
                    if (dVar6 != null) {
                        if (dVar5 != null) {
                            dVU = dVar5.dVC() + margin;
                        } else {
                            dVU = dVar6.dVA();
                        }
                        if (dVar6 == dVar) {
                            dVar6 = null;
                        } else {
                            z4 = false;
                        }
                    } else if (z5 && dVar4 != null) {
                        dVU = dVar4.dVA();
                        z10 = false;
                        z4 = false;
                        dVar6 = null;
                    } else if (dVar5 != null) {
                        dVU = dVar5.dVC() + margin;
                        z6 = false;
                        dVar6 = null;
                    } else if (dVar3 != null) {
                        dVU = dVar3.dVA();
                        z4 = false;
                        dVar6 = dVar3;
                    } else {
                        dVU = mVar.dVU();
                        dVar6 = null;
                    }
                    if (!z10) {
                        z7 = false;
                    } else {
                        z7 = a(z5, dVar, mVar, dVU, dVar3, dVar5);
                    }
                    if (z7) {
                        dVU = mVar.dVU();
                        z8 = true;
                        i2 = 1;
                    } else if (dVar6 != null) {
                        i2 = i - 1;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        i2 = i;
                    }
                    if (dVU == mVar.dVU()) {
                        z2 = false;
                        dVU2 = dVU;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    } else {
                        z2 = z4;
                        dVU2 = dVU;
                        i3 = i2;
                        z3 = z7;
                        z = z8;
                        dVar2 = dVar6;
                    }
                }
                if (fVar == null || !fVar.a(dVar, dVU2, i3, z)) {
                    if (z3) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dVz(), dVU2);
                    if (!z2) {
                        this.ofq.l(dVar2);
                        this.ofq.k(dVar);
                    }
                }
            }
        }

        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dVU()) || (dVar2 != null && dVar2.dVA() > 0.0f) || dVar.obP + f > ((float) mVar.getHeight());
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.ofx = true;
            this.ofq.clear();
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
            return dVar.obP + f > ((float) mVar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends c {
        protected C0921a ofp;
        protected master.flame.danmaku.danmaku.model.android.d ofq;

        /* renamed from: master.flame.danmaku.danmaku.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        protected class C0921a extends l.b<master.flame.danmaku.danmaku.model.d, e> {
            public m ofi;
            float ofv;
            int jzE = 0;
            public master.flame.danmaku.danmaku.model.d ofr = null;
            public master.flame.danmaku.danmaku.model.d ofs = null;
            public master.flame.danmaku.danmaku.model.d oft = null;
            boolean ofu = false;

            protected C0921a() {
            }

            @Override // master.flame.danmaku.danmaku.model.l.b
            public void dVO() {
                this.jzE = 0;
                this.ofs = null;
                this.ofr = null;
                this.ofu = false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                if (a.this.ofx) {
                    return 1;
                }
                this.jzE++;
                if (dVar == this.oft) {
                    this.ofr = null;
                    this.ofu = false;
                    return 1;
                }
                if (this.ofs == null) {
                    this.ofs = dVar;
                    if (this.ofs.dVC() != this.ofi.getHeight()) {
                        return 1;
                    }
                }
                if (this.ofv < this.ofi.dVU()) {
                    this.ofr = null;
                    return 1;
                }
                this.ofu = master.flame.danmaku.danmaku.c.b.a(this.ofi, dVar, this.oft, this.oft.getDuration(), this.oft.dVD().ocf);
                if (!this.ofu) {
                    this.ofr = dVar;
                    return 1;
                }
                this.ofv = (dVar.dVA() - this.ofi.getMargin()) - this.oft.obP;
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: dWA */
            public e dUO() {
                e eVar = new e();
                eVar.jzE = this.jzE;
                eVar.ofs = this.ofs;
                eVar.ofr = this.ofr;
                eVar.ofu = this.ofu;
                return eVar;
            }
        }

        private a() {
            super();
            this.ofp = new C0921a();
            this.ofq = new master.flame.danmaku.danmaku.model.android.d(2);
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
            if (!dVar.dVv()) {
                boolean isShown = dVar.isShown();
                float dVA = isShown ? dVar.dVA() : -1.0f;
                boolean z5 = (isShown || this.ofq.isEmpty()) ? false : true;
                if (dVA < mVar.dVU()) {
                    dVA = mVar.getHeight() - dVar.obP;
                }
                if (isShown) {
                    dVar2 = null;
                    z3 = z5;
                    i = 0;
                    z = isShown;
                } else {
                    this.ofx = false;
                    this.ofp.ofv = dVA;
                    this.ofp.ofi = mVar;
                    this.ofp.oft = dVar;
                    this.ofq.a(this.ofp);
                    e dUO = this.ofp.dUO();
                    dVA = this.ofp.ofv;
                    if (dUO != null) {
                        int i2 = dUO.jzE;
                        dVar3 = dUO.ofs;
                        master.flame.danmaku.danmaku.model.d dVar4 = dUO.ofr;
                        boolean z6 = dUO.ofC;
                        z2 = dUO.ofu;
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
                    boolean a = a(false, dVar, mVar, dVA, dVar3, null);
                    if (a) {
                        dVA = mVar.getHeight() - dVar.obP;
                        z4 = a;
                        i = 1;
                    } else {
                        z3 = dVA >= ((float) mVar.dVU()) ? false : z2;
                        if (dVar2 != null) {
                            i--;
                            z4 = a;
                        } else {
                            z4 = a;
                        }
                    }
                }
                if (fVar == null || !fVar.a(dVar, dVA, i, z3)) {
                    if (z4) {
                        clear();
                    }
                    dVar.a(mVar, dVar.dVz(), dVA);
                    if (!z) {
                        this.ofq.l(dVar2);
                        this.ofq.k(dVar);
                    }
                }
            }
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.c, master.flame.danmaku.danmaku.b.a.b.C0922b
        protected boolean a(boolean z, master.flame.danmaku.danmaku.model.d dVar, m mVar, float f, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f < ((float) mVar.dVU()) || !(dVar2 == null || dVar2.dVC() == ((float) mVar.getHeight()));
        }

        @Override // master.flame.danmaku.danmaku.b.a.b.C0922b, master.flame.danmaku.danmaku.b.a.b.d
        public void clear() {
            this.ofx = true;
            this.ofq.clear();
        }
    }
}
