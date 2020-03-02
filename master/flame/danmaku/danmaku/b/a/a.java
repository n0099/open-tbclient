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
    private final DanmakuContext nEt;
    private f nIK;
    private b.f nIL;
    private final b nIN;
    private k nIO;
    private a.InterfaceC0776a nIP;
    private final b.f nIM = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nFB == 0 && a.this.nEt.nHC.b(dVar, i, 0, a.this.nIK, z, a.this.nEt)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0777a nIQ = new C0777a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0777a extends l.c<d> {
        private d nIS;
        public m nIT;
        public a.b nIU;
        public long nIV;

        private C0777a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bV(d dVar) {
            this.nIS = dVar;
            if (dVar.isTimeOut()) {
                this.nIT.o(dVar);
                return 0;
            } else if (this.nIU.nIt || !dVar.dLT()) {
                if (!dVar.dLL()) {
                    a.this.nEt.nHC.a(dVar, this.nIU.nIu, this.nIU.nIv, this.nIU.nEy, false, a.this.nEt);
                }
                if (dVar.dLS() >= this.nIV) {
                    if (dVar.nFB == 0 && dVar.dLM()) {
                        return 0;
                    }
                    if (dVar.dLK()) {
                        n<?> dLI = dVar.dLI();
                        if (a.this.nIO != null && (dLI == null || dLI.get() == null)) {
                            a.this.nIO.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nIU.nIu++;
                    }
                    if (!dVar.dLH()) {
                        dVar.a(this.nIT, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.nIT, false);
                    }
                    a.this.nIN.a(dVar, this.nIT, a.this.nIL);
                    if (dVar.isShown()) {
                        if (dVar.nFx != null || dVar.dLQ() <= this.nIT.getHeight()) {
                            int a = dVar.a(this.nIT);
                            if (a == 1) {
                                this.nIU.nIG++;
                            } else if (a == 2) {
                                this.nIU.nIH++;
                                if (a.this.nIO != null) {
                                    a.this.nIO.a(dVar);
                                }
                            }
                            this.nIU.eB(dVar.getType(), 1);
                            this.nIU.NN(1);
                            this.nIU.v(dVar);
                            if (a.this.nIP == null || dVar.nFR == a.this.nEt.nHB.nGd) {
                                return 0;
                            }
                            dVar.nFR = a.this.nEt.nHB.nGd;
                            a.this.nIP.i(dVar);
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
        public void dMd() {
            this.nIU.nIw = this.nIS;
            super.dMd();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nEt = danmakuContext;
        this.nIN = new b(danmakuContext.dMs());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dMM();
        this.nEt.nHC.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dMM() {
        this.nIN.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nIN.release();
        this.nEt.nHC.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wQ(boolean z) {
        this.nIL = z ? this.nIM : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nIK = bVar.nEy;
        this.nIQ.nIT = mVar;
        this.nIQ.nIU = bVar;
        this.nIQ.nIV = j;
        lVar.a(this.nIQ);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nIO = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0776a interfaceC0776a) {
        this.nIP = interfaceC0776a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wR(boolean z) {
        if (this.nIN != null) {
            this.nIN.wR(z);
        }
    }
}
