package master.flame.danmaku.danmaku.b.a;

import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.b.a.b;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class a extends master.flame.danmaku.danmaku.b.b {
    private final DanmakuContext oTT;
    private f oYi;
    private b.f oYj;
    private final b oYl;
    private k oYm;
    private a.InterfaceC0992a oYn;
    private final b.f oYk = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.oVa == 0 && a.this.oTT.oXc.b(dVar, i, 0, a.this.oYi, z, a.this.oTT)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0993a oYo = new C0993a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0993a extends l.c<d> {
        private d oYq;
        public m oYr;
        public a.b oYs;
        public long oYt;

        private C0993a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bT(d dVar) {
            this.oYq = dVar;
            if (dVar.epr()) {
                this.oYr.o(dVar);
                return 0;
            } else if (this.oYs.oXR || !dVar.epC()) {
                if (!dVar.epu()) {
                    a.this.oTT.oXc.a(dVar, this.oYs.oXS, this.oYs.oXT, this.oYs.oTY, false, a.this.oTT);
                }
                if (dVar.epB() >= this.oYt) {
                    if (dVar.oVa == 0 && dVar.epv()) {
                        return 0;
                    }
                    if (dVar.ept()) {
                        n<?> epq = dVar.epq();
                        if (a.this.oYm != null && (epq == null || epq.get() == null)) {
                            a.this.oYm.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.oYs.oXS++;
                    }
                    if (!dVar.epp()) {
                        dVar.a(this.oYr, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.oYr, false);
                    }
                    a.this.oYl.a(dVar, this.oYr, a.this.oYj);
                    if (dVar.isShown()) {
                        if (dVar.oUX != null || dVar.epz() <= this.oYr.getHeight()) {
                            int a2 = dVar.a(this.oYr);
                            if (a2 == 1) {
                                this.oYs.oYe++;
                            } else if (a2 == 2) {
                                this.oYs.oYf++;
                                if (a.this.oYm != null) {
                                    a.this.oYm.a(dVar);
                                }
                            }
                            this.oYs.ep(dVar.getType(), 1);
                            this.oYs.Pp(1);
                            this.oYs.v(dVar);
                            if (a.this.oYn == null || dVar.oVq == a.this.oTT.oXb.oVD) {
                                return 0;
                            }
                            dVar.oVq = a.this.oTT.oXb.oVD;
                            a.this.oYn.i(dVar);
                            return 0;
                        }
                        return 0;
                    }
                    return 0;
                }
                return 0;
            } else {
                return 2;
            }
        }

        @Override // master.flame.danmaku.danmaku.model.l.b
        public void epM() {
            this.oYs.oXU = this.oYq;
            super.epM();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.oTT = danmakuContext;
        this.oYl = new b(danmakuContext.eqb());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        eqv();
        this.oTT.oXc.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void eqv() {
        this.oYl.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.oYl.release();
        this.oTT.oXc.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void zM(boolean z) {
        this.oYj = z ? this.oYk : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.oYi = bVar.oTY;
        this.oYo.oYr = mVar;
        this.oYo.oYs = bVar;
        this.oYo.oYt = j;
        lVar.a(this.oYo);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.oYm = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0992a interfaceC0992a) {
        this.oYn = interfaceC0992a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void zN(boolean z) {
        if (this.oYl != null) {
            this.oYl.zN(z);
        }
    }
}
