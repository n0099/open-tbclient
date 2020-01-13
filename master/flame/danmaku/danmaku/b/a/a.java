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
    private final DanmakuContext nDu;
    private f nHN;
    private b.f nHO;
    private final b nHQ;
    private k nHR;
    private a.InterfaceC0768a nHS;
    private final b.f nHP = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nEC == 0 && a.this.nDu.nGE.b(dVar, i, 0, a.this.nHN, z, a.this.nDu)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0769a nHT = new C0769a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0769a extends l.c<d> {
        private d nHV;
        public m nHW;
        public a.b nHX;
        public long nHY;

        private C0769a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bU(d dVar) {
            this.nHV = dVar;
            if (dVar.isTimeOut()) {
                this.nHW.o(dVar);
                return 0;
            } else if (this.nHX.nHw || !dVar.dKC()) {
                if (!dVar.dKu()) {
                    a.this.nDu.nGE.a(dVar, this.nHX.nHx, this.nHX.nHy, this.nHX.nDz, false, a.this.nDu);
                }
                if (dVar.dKB() >= this.nHY) {
                    if (dVar.nEC == 0 && dVar.dKv()) {
                        return 0;
                    }
                    if (dVar.dKt()) {
                        n<?> dKr = dVar.dKr();
                        if (a.this.nHR != null && (dKr == null || dKr.get() == null)) {
                            a.this.nHR.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nHX.nHx++;
                    }
                    if (!dVar.dKq()) {
                        dVar.a(this.nHW, false);
                    }
                    if (!dVar.aGB()) {
                        dVar.b(this.nHW, false);
                    }
                    a.this.nHQ.a(dVar, this.nHW, a.this.nHO);
                    if (dVar.isShown()) {
                        if (dVar.nEy != null || dVar.dKz() <= this.nHW.getHeight()) {
                            int a = dVar.a(this.nHW);
                            if (a == 1) {
                                this.nHX.nHJ++;
                            } else if (a == 2) {
                                this.nHX.nHK++;
                                if (a.this.nHR != null) {
                                    a.this.nHR.a(dVar);
                                }
                            }
                            this.nHX.ey(dVar.getType(), 1);
                            this.nHX.NK(1);
                            this.nHX.v(dVar);
                            if (a.this.nHS == null || dVar.nES == a.this.nDu.nGD.nFe) {
                                return 0;
                            }
                            dVar.nES = a.this.nDu.nGD.nFe;
                            a.this.nHS.i(dVar);
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
        public void dKM() {
            this.nHX.nHz = this.nHV;
            super.dKM();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nDu = danmakuContext;
        this.nHQ = new b(danmakuContext.dLb());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dLv();
        this.nDu.nGE.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dLv() {
        this.nHQ.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nHQ.release();
        this.nDu.nGE.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wN(boolean z) {
        this.nHO = z ? this.nHP : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nHN = bVar.nDz;
        this.nHT.nHW = mVar;
        this.nHT.nHX = bVar;
        this.nHT.nHY = j;
        lVar.a(this.nHT);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nHR = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0768a interfaceC0768a) {
        this.nHS = interfaceC0768a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wO(boolean z) {
        if (this.nHQ != null) {
            this.nHQ.wO(z);
        }
    }
}
