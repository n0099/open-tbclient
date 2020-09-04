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
    private final DanmakuContext ouY;
    private f ozp;
    private b.f ozq;
    private final b ozs;
    private k ozt;
    private a.InterfaceC0977a ozu;
    private final b.f ozr = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.owf == 0 && a.this.ouY.oyi.b(dVar, i, 0, a.this.ozp, z, a.this.ouY)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0978a ozv = new C0978a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0978a extends l.c<d> {
        public long ozA;
        private d ozx;
        public m ozy;
        public a.b ozz;

        private C0978a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bO(d dVar) {
            this.ozx = dVar;
            if (dVar.ehH()) {
                this.ozy.o(dVar);
                return 0;
            } else if (this.ozz.oyY || !dVar.ehS()) {
                if (!dVar.ehK()) {
                    a.this.ouY.oyi.a(dVar, this.ozz.oyZ, this.ozz.oza, this.ozz.ovd, false, a.this.ouY);
                }
                if (dVar.ehR() >= this.ozA) {
                    if (dVar.owf == 0 && dVar.ehL()) {
                        return 0;
                    }
                    if (dVar.ehJ()) {
                        n<?> ehG = dVar.ehG();
                        if (a.this.ozt != null && (ehG == null || ehG.get() == null)) {
                            a.this.ozt.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.ozz.oyZ++;
                    }
                    if (!dVar.ehF()) {
                        dVar.a(this.ozy, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.ozy, false);
                    }
                    a.this.ozs.a(dVar, this.ozy, a.this.ozq);
                    if (dVar.isShown()) {
                        if (dVar.owc != null || dVar.ehP() <= this.ozy.getHeight()) {
                            int a = dVar.a(this.ozy);
                            if (a == 1) {
                                this.ozz.ozl++;
                            } else if (a == 2) {
                                this.ozz.ozm++;
                                if (a.this.ozt != null) {
                                    a.this.ozt.a(dVar);
                                }
                            }
                            this.ozz.el(dVar.getType(), 1);
                            this.ozz.Oe(1);
                            this.ozz.v(dVar);
                            if (a.this.ozu == null || dVar.owv == a.this.ouY.oyh.owI) {
                                return 0;
                            }
                            dVar.owv = a.this.ouY.oyh.owI;
                            a.this.ozu.i(dVar);
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
        public void eic() {
            this.ozz.ozb = this.ozx;
            super.eic();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.ouY = danmakuContext;
        this.ozs = new b(danmakuContext.eir());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        eiL();
        this.ouY.oyi.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void eiL() {
        this.ozs.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.ozs.release();
        this.ouY.oyi.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void yX(boolean z) {
        this.ozq = z ? this.ozr : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.ozp = bVar.ovd;
        this.ozv.ozy = mVar;
        this.ozv.ozz = bVar;
        this.ozv.ozA = j;
        lVar.a(this.ozv);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.ozt = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0977a interfaceC0977a) {
        this.ozu = interfaceC0977a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void yY(boolean z) {
        if (this.ozs != null) {
            this.ozs.yY(z);
        }
    }
}
