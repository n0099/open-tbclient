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
    private f nAA;
    private b.f nAB;
    private final b nAD;
    private k nAE;
    private a.InterfaceC0884a nAF;
    private final DanmakuContext nwh;
    private final b.f nAC = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nxp == 0 && a.this.nwh.nzt.b(dVar, i, 0, a.this.nAA, z, a.this.nwh)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0885a nAG = new C0885a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0885a extends l.c<d> {
        private d nAI;
        public m nAJ;
        public a.b nAK;
        public long nAL;

        private C0885a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bL(d dVar) {
            this.nAI = dVar;
            if (dVar.isTimeOut()) {
                this.nAJ.o(dVar);
                return 0;
            } else if (this.nAK.nAj || !dVar.dNz()) {
                if (!dVar.dNr()) {
                    a.this.nwh.nzt.a(dVar, this.nAK.nAk, this.nAK.nAl, this.nAK.nwm, false, a.this.nwh);
                }
                if (dVar.dNy() >= this.nAL) {
                    if (dVar.nxp == 0 && dVar.dNs()) {
                        return 0;
                    }
                    if (dVar.dNq()) {
                        n<?> dNo = dVar.dNo();
                        if (a.this.nAE != null && (dNo == null || dNo.get() == null)) {
                            a.this.nAE.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nAK.nAk++;
                    }
                    if (!dVar.dNn()) {
                        dVar.a(this.nAJ, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.nAJ, false);
                    }
                    a.this.nAD.a(dVar, this.nAJ, a.this.nAB);
                    if (dVar.isShown()) {
                        if (dVar.nxl != null || dVar.dNw() <= this.nAJ.getHeight()) {
                            int a = dVar.a(this.nAJ);
                            if (a == 1) {
                                this.nAK.nAw++;
                            } else if (a == 2) {
                                this.nAK.nAx++;
                                if (a.this.nAE != null) {
                                    a.this.nAE.a(dVar);
                                }
                            }
                            this.nAK.dS(dVar.getType(), 1);
                            this.nAK.Ka(1);
                            this.nAK.v(dVar);
                            if (a.this.nAF == null || dVar.nxG == a.this.nwh.nzs.nxT) {
                                return 0;
                            }
                            dVar.nxG = a.this.nwh.nzs.nxT;
                            a.this.nAF.i(dVar);
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
        public void dNJ() {
            this.nAK.nAm = this.nAI;
            super.dNJ();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nwh = danmakuContext;
        this.nAD = new b(danmakuContext.dNY());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dOs();
        this.nwh.nzt.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dOs() {
        this.nAD.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nAD.release();
        this.nwh.nzt.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void xd(boolean z) {
        this.nAB = z ? this.nAC : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nAA = bVar.nwm;
        this.nAG.nAJ = mVar;
        this.nAG.nAK = bVar;
        this.nAG.nAL = j;
        lVar.a(this.nAG);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nAE = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0884a interfaceC0884a) {
        this.nAF = interfaceC0884a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void xe(boolean z) {
        if (this.nAD != null) {
            this.nAD.xe(z);
        }
    }
}
