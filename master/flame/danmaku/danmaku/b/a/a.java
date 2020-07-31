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
    private final DanmakuContext oaF;
    private f oeY;
    private b.f oeZ;
    private final b ofb;
    private k ofc;
    private a.InterfaceC0919a ofd;
    private final b.f ofa = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.obN == 0 && a.this.oaF.odR.b(dVar, i, 0, a.this.oeY, z, a.this.oaF)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0920a ofe = new C0920a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0920a extends l.c<d> {
        private d ofh;
        public m ofi;
        public a.b ofj;
        public long ofk;

        private C0920a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bM(d dVar) {
            this.ofh = dVar;
            if (dVar.isTimeOut()) {
                this.ofi.o(dVar);
                return 0;
            } else if (this.ofj.oeH || !dVar.dVF()) {
                if (!dVar.dVx()) {
                    a.this.oaF.odR.a(dVar, this.ofj.oeI, this.ofj.oeJ, this.ofj.oaK, false, a.this.oaF);
                }
                if (dVar.dVE() >= this.ofk) {
                    if (dVar.obN == 0 && dVar.dVy()) {
                        return 0;
                    }
                    if (dVar.dVw()) {
                        n<?> dVu = dVar.dVu();
                        if (a.this.ofc != null && (dVu == null || dVu.get() == null)) {
                            a.this.ofc.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.ofj.oeI++;
                    }
                    if (!dVar.dVt()) {
                        dVar.a(this.ofi, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.ofi, false);
                    }
                    a.this.ofb.a(dVar, this.ofi, a.this.oeZ);
                    if (dVar.isShown()) {
                        if (dVar.obK != null || dVar.dVC() <= this.ofi.getHeight()) {
                            int a = dVar.a(this.ofi);
                            if (a == 1) {
                                this.ofj.oeU++;
                            } else if (a == 2) {
                                this.ofj.oeV++;
                                if (a.this.ofc != null) {
                                    a.this.ofc.a(dVar);
                                }
                            }
                            this.ofj.ed(dVar.getType(), 1);
                            this.ofj.LB(1);
                            this.ofj.v(dVar);
                            if (a.this.ofd == null || dVar.ocd == a.this.oaF.odQ.ocq) {
                                return 0;
                            }
                            dVar.ocd = a.this.oaF.odQ.ocq;
                            a.this.ofd.i(dVar);
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
        public void dVP() {
            this.ofj.oeK = this.ofh;
            super.dVP();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.oaF = danmakuContext;
        this.ofb = new b(danmakuContext.dWe());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dWy();
        this.oaF.odR.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dWy() {
        this.ofb.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.ofb.release();
        this.oaF.odR.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void yd(boolean z) {
        this.oeZ = z ? this.ofa : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.oeY = bVar.oaK;
        this.ofe.ofi = mVar;
        this.ofe.ofj = bVar;
        this.ofe.ofk = j;
        lVar.a(this.ofe);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.ofc = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0919a interfaceC0919a) {
        this.ofd = interfaceC0919a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void ye(boolean z) {
        if (this.ofb != null) {
            this.ofb.ye(z);
        }
    }
}
