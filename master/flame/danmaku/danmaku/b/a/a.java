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
    private final DanmakuContext nGr;
    private f nKI;
    private b.f nKJ;
    private final b nKL;
    private k nKM;
    private a.InterfaceC0777a nKN;
    private final b.f nKK = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nHz == 0 && a.this.nGr.nJA.b(dVar, i, 0, a.this.nKI, z, a.this.nGr)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0778a nKO = new C0778a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0778a extends l.c<d> {
        private d nKQ;
        public m nKR;
        public a.b nKS;
        public long nKT;

        private C0778a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bV(d dVar) {
            this.nKQ = dVar;
            if (dVar.isTimeOut()) {
                this.nKR.o(dVar);
                return 0;
            } else if (this.nKS.nKr || !dVar.dMu()) {
                if (!dVar.dMm()) {
                    a.this.nGr.nJA.a(dVar, this.nKS.nKs, this.nKS.nKt, this.nKS.nGw, false, a.this.nGr);
                }
                if (dVar.dMt() >= this.nKT) {
                    if (dVar.nHz == 0 && dVar.dMn()) {
                        return 0;
                    }
                    if (dVar.dMl()) {
                        n<?> dMj = dVar.dMj();
                        if (a.this.nKM != null && (dMj == null || dMj.get() == null)) {
                            a.this.nKM.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nKS.nKs++;
                    }
                    if (!dVar.dMi()) {
                        dVar.a(this.nKR, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.nKR, false);
                    }
                    a.this.nKL.a(dVar, this.nKR, a.this.nKJ);
                    if (dVar.isShown()) {
                        if (dVar.nHv != null || dVar.dMr() <= this.nKR.getHeight()) {
                            int a = dVar.a(this.nKR);
                            if (a == 1) {
                                this.nKS.nKE++;
                            } else if (a == 2) {
                                this.nKS.nKF++;
                                if (a.this.nKM != null) {
                                    a.this.nKM.a(dVar);
                                }
                            }
                            this.nKS.eC(dVar.getType(), 1);
                            this.nKS.NT(1);
                            this.nKS.v(dVar);
                            if (a.this.nKN == null || dVar.nHP == a.this.nGr.nJz.nIb) {
                                return 0;
                            }
                            dVar.nHP = a.this.nGr.nJz.nIb;
                            a.this.nKN.i(dVar);
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
        public void dME() {
            this.nKS.nKu = this.nKQ;
            super.dME();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nGr = danmakuContext;
        this.nKL = new b(danmakuContext.dMT());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dNn();
        this.nGr.nJA.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dNn() {
        this.nKL.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nKL.release();
        this.nGr.nJA.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wY(boolean z) {
        this.nKJ = z ? this.nKK : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nKI = bVar.nGw;
        this.nKO.nKR = mVar;
        this.nKO.nKS = bVar;
        this.nKO.nKT = j;
        lVar.a(this.nKO);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nKM = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0777a interfaceC0777a) {
        this.nKN = interfaceC0777a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wZ(boolean z) {
        if (this.nKL != null) {
            this.nKL.wZ(z);
        }
    }
}
