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
    private final DanmakuContext nEE;
    private f nIV;
    private b.f nIW;
    private final b nIY;
    private k nIZ;
    private a.InterfaceC0776a nJa;
    private final b.f nIX = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nFM == 0 && a.this.nEE.nHN.b(dVar, i, 0, a.this.nIV, z, a.this.nEE)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0777a nJb = new C0777a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0777a extends l.c<d> {
        private d nJd;
        public m nJe;
        public a.b nJf;
        public long nJg;

        private C0777a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bV(d dVar) {
            this.nJd = dVar;
            if (dVar.isTimeOut()) {
                this.nJe.o(dVar);
                return 0;
            } else if (this.nJf.nIE || !dVar.dLU()) {
                if (!dVar.dLM()) {
                    a.this.nEE.nHN.a(dVar, this.nJf.nIF, this.nJf.nIG, this.nJf.nEJ, false, a.this.nEE);
                }
                if (dVar.dLT() >= this.nJg) {
                    if (dVar.nFM == 0 && dVar.dLN()) {
                        return 0;
                    }
                    if (dVar.dLL()) {
                        n<?> dLJ = dVar.dLJ();
                        if (a.this.nIZ != null && (dLJ == null || dLJ.get() == null)) {
                            a.this.nIZ.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nJf.nIF++;
                    }
                    if (!dVar.dLI()) {
                        dVar.a(this.nJe, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.nJe, false);
                    }
                    a.this.nIY.a(dVar, this.nJe, a.this.nIW);
                    if (dVar.isShown()) {
                        if (dVar.nFI != null || dVar.dLR() <= this.nJe.getHeight()) {
                            int a = dVar.a(this.nJe);
                            if (a == 1) {
                                this.nJf.nIR++;
                            } else if (a == 2) {
                                this.nJf.nIS++;
                                if (a.this.nIZ != null) {
                                    a.this.nIZ.a(dVar);
                                }
                            }
                            this.nJf.eB(dVar.getType(), 1);
                            this.nJf.NN(1);
                            this.nJf.v(dVar);
                            if (a.this.nJa == null || dVar.nGc == a.this.nEE.nHM.nGo) {
                                return 0;
                            }
                            dVar.nGc = a.this.nEE.nHM.nGo;
                            a.this.nJa.i(dVar);
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
        public void dMe() {
            this.nJf.nIH = this.nJd;
            super.dMe();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nEE = danmakuContext;
        this.nIY = new b(danmakuContext.dMt());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dMN();
        this.nEE.nHN.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dMN() {
        this.nIY.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nIY.release();
        this.nEE.nHN.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wQ(boolean z) {
        this.nIW = z ? this.nIX : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nIV = bVar.nEJ;
        this.nJb.nJe = mVar;
        this.nJb.nJf = bVar;
        this.nJb.nJg = j;
        lVar.a(this.nJb);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nIZ = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0776a interfaceC0776a) {
        this.nJa = interfaceC0776a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wR(boolean z) {
        if (this.nIY != null) {
            this.nIY.wR(z);
        }
    }
}
