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
    private final DanmakuContext oaH;
    private f ofa;
    private b.f ofb;
    private final b ofd;
    private k ofe;
    private a.InterfaceC0919a ofg;
    private final b.f ofc = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.obP == 0 && a.this.oaH.odT.b(dVar, i, 0, a.this.ofa, z, a.this.oaH)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0920a ofh = new C0920a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0920a extends l.c<d> {
        private d ofj;
        public m ofk;
        public a.b ofl;
        public long ofm;

        private C0920a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bM(d dVar) {
            this.ofj = dVar;
            if (dVar.isTimeOut()) {
                this.ofk.o(dVar);
                return 0;
            } else if (this.ofl.oeJ || !dVar.dVG()) {
                if (!dVar.dVy()) {
                    a.this.oaH.odT.a(dVar, this.ofl.oeK, this.ofl.oeL, this.ofl.oaM, false, a.this.oaH);
                }
                if (dVar.dVF() >= this.ofm) {
                    if (dVar.obP == 0 && dVar.dVz()) {
                        return 0;
                    }
                    if (dVar.dVx()) {
                        n<?> dVv = dVar.dVv();
                        if (a.this.ofe != null && (dVv == null || dVv.get() == null)) {
                            a.this.ofe.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.ofl.oeK++;
                    }
                    if (!dVar.dVu()) {
                        dVar.a(this.ofk, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.ofk, false);
                    }
                    a.this.ofd.a(dVar, this.ofk, a.this.ofb);
                    if (dVar.isShown()) {
                        if (dVar.obM != null || dVar.dVD() <= this.ofk.getHeight()) {
                            int a = dVar.a(this.ofk);
                            if (a == 1) {
                                this.ofl.oeW++;
                            } else if (a == 2) {
                                this.ofl.oeX++;
                                if (a.this.ofe != null) {
                                    a.this.ofe.a(dVar);
                                }
                            }
                            this.ofl.ed(dVar.getType(), 1);
                            this.ofl.LB(1);
                            this.ofl.v(dVar);
                            if (a.this.ofg == null || dVar.ocf == a.this.oaH.odS.oct) {
                                return 0;
                            }
                            dVar.ocf = a.this.oaH.odS.oct;
                            a.this.ofg.i(dVar);
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
        public void dVQ() {
            this.ofl.oeM = this.ofj;
            super.dVQ();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.oaH = danmakuContext;
        this.ofd = new b(danmakuContext.dWf());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dWz();
        this.oaH.odT.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dWz() {
        this.ofd.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.ofd.release();
        this.oaH.odT.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void yd(boolean z) {
        this.ofb = z ? this.ofc : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.ofa = bVar.oaM;
        this.ofh.ofk = mVar;
        this.ofh.ofl = bVar;
        this.ofh.ofm = j;
        lVar.a(this.ofh);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.ofe = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0919a interfaceC0919a) {
        this.ofg = interfaceC0919a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void ye(boolean z) {
        if (this.ofd != null) {
            this.ofd.ye(z);
        }
    }
}
