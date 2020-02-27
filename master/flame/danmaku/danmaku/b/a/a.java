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
    private final DanmakuContext nEr;
    private f nII;
    private b.f nIJ;
    private final b nIL;
    private k nIM;
    private a.InterfaceC0776a nIN;
    private final b.f nIK = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nFz == 0 && a.this.nEr.nHA.b(dVar, i, 0, a.this.nII, z, a.this.nEr)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0777a nIO = new C0777a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0777a extends l.c<d> {
        private d nIQ;
        public m nIR;
        public a.b nIS;
        public long nIT;

        private C0777a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bV(d dVar) {
            this.nIQ = dVar;
            if (dVar.isTimeOut()) {
                this.nIR.o(dVar);
                return 0;
            } else if (this.nIS.nIr || !dVar.dLR()) {
                if (!dVar.dLJ()) {
                    a.this.nEr.nHA.a(dVar, this.nIS.nIs, this.nIS.nIt, this.nIS.nEw, false, a.this.nEr);
                }
                if (dVar.dLQ() >= this.nIT) {
                    if (dVar.nFz == 0 && dVar.dLK()) {
                        return 0;
                    }
                    if (dVar.dLI()) {
                        n<?> dLG = dVar.dLG();
                        if (a.this.nIM != null && (dLG == null || dLG.get() == null)) {
                            a.this.nIM.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nIS.nIs++;
                    }
                    if (!dVar.dLF()) {
                        dVar.a(this.nIR, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.nIR, false);
                    }
                    a.this.nIL.a(dVar, this.nIR, a.this.nIJ);
                    if (dVar.isShown()) {
                        if (dVar.nFv != null || dVar.dLO() <= this.nIR.getHeight()) {
                            int a = dVar.a(this.nIR);
                            if (a == 1) {
                                this.nIS.nIE++;
                            } else if (a == 2) {
                                this.nIS.nIF++;
                                if (a.this.nIM != null) {
                                    a.this.nIM.a(dVar);
                                }
                            }
                            this.nIS.eB(dVar.getType(), 1);
                            this.nIS.NN(1);
                            this.nIS.v(dVar);
                            if (a.this.nIN == null || dVar.nFP == a.this.nEr.nHz.nGb) {
                                return 0;
                            }
                            dVar.nFP = a.this.nEr.nHz.nGb;
                            a.this.nIN.i(dVar);
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
        public void dMb() {
            this.nIS.nIu = this.nIQ;
            super.dMb();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nEr = danmakuContext;
        this.nIL = new b(danmakuContext.dMq());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dMK();
        this.nEr.nHA.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dMK() {
        this.nIL.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nIL.release();
        this.nEr.nHA.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wQ(boolean z) {
        this.nIJ = z ? this.nIK : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nII = bVar.nEw;
        this.nIO.nIR = mVar;
        this.nIO.nIS = bVar;
        this.nIO.nIT = j;
        lVar.a(this.nIO);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nIM = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0776a interfaceC0776a) {
        this.nIN = interfaceC0776a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wR(boolean z) {
        if (this.nIL != null) {
            this.nIL.wR(z);
        }
    }
}
