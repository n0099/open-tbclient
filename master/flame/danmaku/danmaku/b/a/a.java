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
    private final DanmakuContext nRT;
    private f nWl;
    private b.f nWm;
    private final b nWo;
    private k nWp;
    private a.InterfaceC0903a nWq;
    private final b.f nWn = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nTb == 0 && a.this.nRT.nVe.b(dVar, i, 0, a.this.nWl, z, a.this.nRT)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0904a nWr = new C0904a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0904a extends l.c<d> {
        private d nWt;
        public m nWu;
        public a.b nWv;
        public long nWw;

        private C0904a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bM(d dVar) {
            this.nWt = dVar;
            if (dVar.isTimeOut()) {
                this.nWu.o(dVar);
                return 0;
            } else if (this.nWv.nVU || !dVar.dSf()) {
                if (!dVar.dRX()) {
                    a.this.nRT.nVe.a(dVar, this.nWv.nVV, this.nWv.nVW, this.nWv.nRY, false, a.this.nRT);
                }
                if (dVar.dSe() >= this.nWw) {
                    if (dVar.nTb == 0 && dVar.dRY()) {
                        return 0;
                    }
                    if (dVar.dRW()) {
                        n<?> dRU = dVar.dRU();
                        if (a.this.nWp != null && (dRU == null || dRU.get() == null)) {
                            a.this.nWp.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nWv.nVV++;
                    }
                    if (!dVar.dRT()) {
                        dVar.a(this.nWu, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.nWu, false);
                    }
                    a.this.nWo.a(dVar, this.nWu, a.this.nWm);
                    if (dVar.isShown()) {
                        if (dVar.nSX != null || dVar.dSc() <= this.nWu.getHeight()) {
                            int a = dVar.a(this.nWu);
                            if (a == 1) {
                                this.nWv.nWh++;
                            } else if (a == 2) {
                                this.nWv.nWi++;
                                if (a.this.nWp != null) {
                                    a.this.nWp.a(dVar);
                                }
                            }
                            this.nWv.eb(dVar.getType(), 1);
                            this.nWv.Lh(1);
                            this.nWv.v(dVar);
                            if (a.this.nWq == null || dVar.nTr == a.this.nRT.nVd.nTE) {
                                return 0;
                            }
                            dVar.nTr = a.this.nRT.nVd.nTE;
                            a.this.nWq.i(dVar);
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
        public void dSp() {
            this.nWv.nVX = this.nWt;
            super.dSp();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nRT = danmakuContext;
        this.nWo = new b(danmakuContext.dSE());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dSY();
        this.nRT.nVe.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dSY() {
        this.nWo.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nWo.release();
        this.nRT.nVe.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void xy(boolean z) {
        this.nWm = z ? this.nWn : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nWl = bVar.nRY;
        this.nWr.nWu = mVar;
        this.nWr.nWv = bVar;
        this.nWr.nWw = j;
        lVar.a(this.nWr);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nWp = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0903a interfaceC0903a) {
        this.nWq = interfaceC0903a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void xz(boolean z) {
        if (this.nWo != null) {
            this.nWo.xz(z);
        }
    }
}
