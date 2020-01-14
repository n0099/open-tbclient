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
/* loaded from: classes4.dex */
public class a extends master.flame.danmaku.danmaku.b.b {
    private final DanmakuContext nDz;
    private f nHS;
    private b.f nHT;
    private final b nHV;
    private k nHW;
    private a.InterfaceC0768a nHX;
    private final b.f nHU = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nEH == 0 && a.this.nDz.nGJ.b(dVar, i, 0, a.this.nHS, z, a.this.nDz)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0769a nHY = new C0769a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0769a extends l.c<d> {
        private d nIa;
        public m nIb;
        public a.b nIc;
        public long nId;

        private C0769a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bU(d dVar) {
            this.nIa = dVar;
            if (dVar.isTimeOut()) {
                this.nIb.o(dVar);
                return 0;
            } else if (this.nIc.nHB || !dVar.dKE()) {
                if (!dVar.dKw()) {
                    a.this.nDz.nGJ.a(dVar, this.nIc.nHC, this.nIc.nHD, this.nIc.nDE, false, a.this.nDz);
                }
                if (dVar.dKD() >= this.nId) {
                    if (dVar.nEH == 0 && dVar.dKx()) {
                        return 0;
                    }
                    if (dVar.dKv()) {
                        n<?> dKt = dVar.dKt();
                        if (a.this.nHW != null && (dKt == null || dKt.get() == null)) {
                            a.this.nHW.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nIc.nHC++;
                    }
                    if (!dVar.dKs()) {
                        dVar.a(this.nIb, false);
                    }
                    if (!dVar.aGB()) {
                        dVar.b(this.nIb, false);
                    }
                    a.this.nHV.a(dVar, this.nIb, a.this.nHT);
                    if (dVar.isShown()) {
                        if (dVar.nED != null || dVar.dKB() <= this.nIb.getHeight()) {
                            int a = dVar.a(this.nIb);
                            if (a == 1) {
                                this.nIc.nHO++;
                            } else if (a == 2) {
                                this.nIc.nHP++;
                                if (a.this.nHW != null) {
                                    a.this.nHW.a(dVar);
                                }
                            }
                            this.nIc.ey(dVar.getType(), 1);
                            this.nIc.NK(1);
                            this.nIc.v(dVar);
                            if (a.this.nHX == null || dVar.nEX == a.this.nDz.nGI.nFj) {
                                return 0;
                            }
                            dVar.nEX = a.this.nDz.nGI.nFj;
                            a.this.nHX.i(dVar);
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
        public void dKO() {
            this.nIc.nHE = this.nIa;
            super.dKO();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nDz = danmakuContext;
        this.nHV = new b(danmakuContext.dLd());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dLx();
        this.nDz.nGJ.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dLx() {
        this.nHV.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nHV.release();
        this.nDz.nGJ.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wN(boolean z) {
        this.nHT = z ? this.nHU : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nHS = bVar.nDE;
        this.nHY.nIb = mVar;
        this.nHY.nIc = bVar;
        this.nHY.nId = j;
        lVar.a(this.nHY);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nHW = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0768a interfaceC0768a) {
        this.nHX = interfaceC0768a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wO(boolean z) {
        if (this.nHV != null) {
            this.nHV.wO(z);
        }
    }
}
