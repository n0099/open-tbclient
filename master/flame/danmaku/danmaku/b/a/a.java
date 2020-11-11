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
    private final DanmakuContext pUJ;
    private f pYY;
    private b.f pYZ;
    private final b pZb;
    private k pZc;
    private a.InterfaceC1084a pZd;
    private final b.f pZa = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.pVQ == 0 && a.this.pUJ.pXS.b(dVar, i, 0, a.this.pYY, z, a.this.pUJ)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C1085a pZe = new C1085a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C1085a extends l.c<d> {
        private d pZg;
        public m pZh;
        public a.b pZi;
        public long pZj;

        private C1085a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bX(d dVar) {
            this.pZg = dVar;
            if (dVar.eDe()) {
                this.pZh.o(dVar);
                return 0;
            } else if (this.pZi.pYH || !dVar.eDp()) {
                if (!dVar.eDh()) {
                    a.this.pUJ.pXS.a(dVar, this.pZi.pYI, this.pZi.pYJ, this.pZi.pUO, false, a.this.pUJ);
                }
                if (dVar.eDo() >= this.pZj) {
                    if (dVar.pVQ == 0 && dVar.eDi()) {
                        return 0;
                    }
                    if (dVar.eDg()) {
                        n<?> eDd = dVar.eDd();
                        if (a.this.pZc != null && (eDd == null || eDd.get() == null)) {
                            a.this.pZc.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.pZi.pYI++;
                    }
                    if (!dVar.eDc()) {
                        dVar.a(this.pZh, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.pZh, false);
                    }
                    a.this.pZb.a(dVar, this.pZh, a.this.pYZ);
                    if (dVar.isShown()) {
                        if (dVar.pVN != null || dVar.eDm() <= this.pZh.getHeight()) {
                            int a2 = dVar.a(this.pZh);
                            if (a2 == 1) {
                                this.pZi.pYU++;
                            } else if (a2 == 2) {
                                this.pZi.pYV++;
                                if (a.this.pZc != null) {
                                    a.this.pZc.a(dVar);
                                }
                            }
                            this.pZi.eA(dVar.getType(), 1);
                            this.pZi.RB(1);
                            this.pZi.v(dVar);
                            if (a.this.pZd == null || dVar.pWg == a.this.pUJ.pXR.pWt) {
                                return 0;
                            }
                            dVar.pWg = a.this.pUJ.pXR.pWt;
                            a.this.pZd.i(dVar);
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
        public void eDz() {
            this.pZi.pYK = this.pZg;
            super.eDz();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.pUJ = danmakuContext;
        this.pZb = new b(danmakuContext.eDO());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        eEi();
        this.pUJ.pXS.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void eEi() {
        this.pZb.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.pZb.release();
        this.pUJ.pXS.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void Bf(boolean z) {
        this.pYZ = z ? this.pZa : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.pYY = bVar.pUO;
        this.pZe.pZh = mVar;
        this.pZe.pZi = bVar;
        this.pZe.pZj = j;
        lVar.a(this.pZe);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.pZc = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC1084a interfaceC1084a) {
        this.pZd = interfaceC1084a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void Bg(boolean z) {
        if (this.pZb != null) {
            this.pZb.Bg(z);
        }
    }
}
