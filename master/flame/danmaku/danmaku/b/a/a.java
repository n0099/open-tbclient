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
    private final DanmakuContext pWm;
    private f qaB;
    private b.f qaC;
    private final b qaE;
    private k qaF;
    private a.InterfaceC1087a qaG;
    private final b.f qaD = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.pXt == 0 && a.this.pWm.pZv.b(dVar, i, 0, a.this.qaB, z, a.this.pWm)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C1088a qaH = new C1088a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C1088a extends l.c<d> {
        private d qaJ;
        public m qaK;
        public a.b qaL;
        public long qaM;

        private C1088a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bY(d dVar) {
            this.qaJ = dVar;
            if (dVar.eDf()) {
                this.qaK.o(dVar);
                return 0;
            } else if (this.qaL.qak || !dVar.eDq()) {
                if (!dVar.eDi()) {
                    a.this.pWm.pZv.a(dVar, this.qaL.qal, this.qaL.qam, this.qaL.pWr, false, a.this.pWm);
                }
                if (dVar.eDp() >= this.qaM) {
                    if (dVar.pXt == 0 && dVar.eDj()) {
                        return 0;
                    }
                    if (dVar.eDh()) {
                        n<?> eDe = dVar.eDe();
                        if (a.this.qaF != null && (eDe == null || eDe.get() == null)) {
                            a.this.qaF.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.qaL.qal++;
                    }
                    if (!dVar.eDd()) {
                        dVar.a(this.qaK, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.qaK, false);
                    }
                    a.this.qaE.a(dVar, this.qaK, a.this.qaC);
                    if (dVar.isShown()) {
                        if (dVar.pXq != null || dVar.eDn() <= this.qaK.getHeight()) {
                            int a2 = dVar.a(this.qaK);
                            if (a2 == 1) {
                                this.qaL.qax++;
                            } else if (a2 == 2) {
                                this.qaL.qay++;
                                if (a.this.qaF != null) {
                                    a.this.qaF.a(dVar);
                                }
                            }
                            this.qaL.eB(dVar.getType(), 1);
                            this.qaL.Se(1);
                            this.qaL.v(dVar);
                            if (a.this.qaG == null || dVar.pXJ == a.this.pWm.pZu.pXW) {
                                return 0;
                            }
                            dVar.pXJ = a.this.pWm.pZu.pXW;
                            a.this.qaG.i(dVar);
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
        public void eDA() {
            this.qaL.qan = this.qaJ;
            super.eDA();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.pWm = danmakuContext;
        this.qaE = new b(danmakuContext.eDP());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        eEj();
        this.pWm.pZv.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void eEj() {
        this.qaE.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.qaE.release();
        this.pWm.pZv.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void Bm(boolean z) {
        this.qaC = z ? this.qaD : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.qaB = bVar.pWr;
        this.qaH.qaK = mVar;
        this.qaH.qaL = bVar;
        this.qaH.qaM = j;
        lVar.a(this.qaH);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.qaF = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC1087a interfaceC1087a) {
        this.qaG = interfaceC1087a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void Bn(boolean z) {
        if (this.qaE != null) {
            this.qaE.Bn(z);
        }
    }
}
