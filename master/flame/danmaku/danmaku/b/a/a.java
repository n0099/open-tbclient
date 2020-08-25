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
    private final DanmakuContext ouG;
    private f oyX;
    private b.f oyY;
    private final b oza;
    private k ozb;
    private a.InterfaceC0977a ozc;
    private final b.f oyZ = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.ovN == 0 && a.this.ouG.oxQ.b(dVar, i, 0, a.this.oyX, z, a.this.ouG)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0978a ozd = new C0978a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0978a extends l.c<d> {
        private d ozf;
        public m ozg;
        public a.b ozh;
        public long ozi;

        private C0978a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bO(d dVar) {
            this.ozf = dVar;
            if (dVar.ehy()) {
                this.ozg.o(dVar);
                return 0;
            } else if (this.ozh.oyG || !dVar.ehJ()) {
                if (!dVar.ehB()) {
                    a.this.ouG.oxQ.a(dVar, this.ozh.oyH, this.ozh.oyI, this.ozh.ouL, false, a.this.ouG);
                }
                if (dVar.ehI() >= this.ozi) {
                    if (dVar.ovN == 0 && dVar.ehC()) {
                        return 0;
                    }
                    if (dVar.ehA()) {
                        n<?> ehx = dVar.ehx();
                        if (a.this.ozb != null && (ehx == null || ehx.get() == null)) {
                            a.this.ozb.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.ozh.oyH++;
                    }
                    if (!dVar.ehw()) {
                        dVar.a(this.ozg, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.ozg, false);
                    }
                    a.this.oza.a(dVar, this.ozg, a.this.oyY);
                    if (dVar.isShown()) {
                        if (dVar.ovK != null || dVar.ehG() <= this.ozg.getHeight()) {
                            int a = dVar.a(this.ozg);
                            if (a == 1) {
                                this.ozh.oyT++;
                            } else if (a == 2) {
                                this.ozh.oyU++;
                                if (a.this.ozb != null) {
                                    a.this.ozb.a(dVar);
                                }
                            }
                            this.ozh.el(dVar.getType(), 1);
                            this.ozh.Oe(1);
                            this.ozh.v(dVar);
                            if (a.this.ozc == null || dVar.owd == a.this.ouG.oxP.owq) {
                                return 0;
                            }
                            dVar.owd = a.this.ouG.oxP.owq;
                            a.this.ozc.i(dVar);
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
        public void ehT() {
            this.ozh.oyJ = this.ozf;
            super.ehT();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.ouG = danmakuContext;
        this.oza = new b(danmakuContext.eii());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        eiC();
        this.ouG.oxQ.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void eiC() {
        this.oza.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.oza.release();
        this.ouG.oxQ.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void yV(boolean z) {
        this.oyY = z ? this.oyZ : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.oyX = bVar.ouL;
        this.ozd.ozg = mVar;
        this.ozd.ozh = bVar;
        this.ozd.ozi = j;
        lVar.a(this.ozd);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.ozb = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0977a interfaceC0977a) {
        this.ozc = interfaceC0977a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void yW(boolean z) {
        if (this.oza != null) {
            this.oza.yW(z);
        }
    }
}
