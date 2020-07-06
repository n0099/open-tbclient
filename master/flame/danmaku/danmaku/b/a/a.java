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
/* loaded from: classes5.dex */
public class a extends master.flame.danmaku.danmaku.b.b {
    private final DanmakuContext nRW;
    private f nWo;
    private b.f nWp;
    private final b nWr;
    private k nWs;
    private a.InterfaceC0904a nWt;
    private final b.f nWq = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nTe == 0 && a.this.nRW.nVh.b(dVar, i, 0, a.this.nWo, z, a.this.nRW)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0905a nWu = new C0905a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0905a extends l.c<d> {
        private d nWw;
        public m nWx;
        public a.b nWy;
        public long nWz;

        private C0905a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bM(d dVar) {
            this.nWw = dVar;
            if (dVar.isTimeOut()) {
                this.nWx.o(dVar);
                return 0;
            } else if (this.nWy.nVX || !dVar.dSj()) {
                if (!dVar.dSb()) {
                    a.this.nRW.nVh.a(dVar, this.nWy.nVY, this.nWy.nVZ, this.nWy.nSb, false, a.this.nRW);
                }
                if (dVar.dSi() >= this.nWz) {
                    if (dVar.nTe == 0 && dVar.dSc()) {
                        return 0;
                    }
                    if (dVar.dSa()) {
                        n<?> dRY = dVar.dRY();
                        if (a.this.nWs != null && (dRY == null || dRY.get() == null)) {
                            a.this.nWs.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nWy.nVY++;
                    }
                    if (!dVar.dRX()) {
                        dVar.a(this.nWx, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.nWx, false);
                    }
                    a.this.nWr.a(dVar, this.nWx, a.this.nWp);
                    if (dVar.isShown()) {
                        if (dVar.nTa != null || dVar.dSg() <= this.nWx.getHeight()) {
                            int a = dVar.a(this.nWx);
                            if (a == 1) {
                                this.nWy.nWk++;
                            } else if (a == 2) {
                                this.nWy.nWl++;
                                if (a.this.nWs != null) {
                                    a.this.nWs.a(dVar);
                                }
                            }
                            this.nWy.eb(dVar.getType(), 1);
                            this.nWy.Lh(1);
                            this.nWy.v(dVar);
                            if (a.this.nWt == null || dVar.nTu == a.this.nRW.nVg.nTH) {
                                return 0;
                            }
                            dVar.nTu = a.this.nRW.nVg.nTH;
                            a.this.nWt.i(dVar);
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
        public void dSt() {
            this.nWy.nWa = this.nWw;
            super.dSt();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nRW = danmakuContext;
        this.nWr = new b(danmakuContext.dSI());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dTc();
        this.nRW.nVh.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dTc() {
        this.nWr.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nWr.release();
        this.nRW.nVh.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void xy(boolean z) {
        this.nWp = z ? this.nWq : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nWo = bVar.nSb;
        this.nWu.nWx = mVar;
        this.nWu.nWy = bVar;
        this.nWu.nWz = j;
        lVar.a(this.nWu);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nWs = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0904a interfaceC0904a) {
        this.nWt = interfaceC0904a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void xz(boolean z) {
        if (this.nWr != null) {
            this.nWr.xz(z);
        }
    }
}
