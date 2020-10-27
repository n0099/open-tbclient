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
    private final DanmakuContext pLp;
    private f pPE;
    private b.f pPF;
    private final b pPH;
    private k pPI;
    private a.InterfaceC1064a pPJ;
    private final b.f pPG = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.pMw == 0 && a.this.pLp.pOy.b(dVar, i, 0, a.this.pPE, z, a.this.pLp)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C1065a pPK = new C1065a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C1065a extends l.c<d> {
        private d pPM;
        public m pPN;
        public a.b pPO;
        public long pPP;

        private C1065a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bX(d dVar) {
            this.pPM = dVar;
            if (dVar.ezp()) {
                this.pPN.o(dVar);
                return 0;
            } else if (this.pPO.pPn || !dVar.ezA()) {
                if (!dVar.ezs()) {
                    a.this.pLp.pOy.a(dVar, this.pPO.pPo, this.pPO.pPp, this.pPO.pLu, false, a.this.pLp);
                }
                if (dVar.ezz() >= this.pPP) {
                    if (dVar.pMw == 0 && dVar.ezt()) {
                        return 0;
                    }
                    if (dVar.ezr()) {
                        n<?> ezo = dVar.ezo();
                        if (a.this.pPI != null && (ezo == null || ezo.get() == null)) {
                            a.this.pPI.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.pPO.pPo++;
                    }
                    if (!dVar.ezn()) {
                        dVar.a(this.pPN, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.pPN, false);
                    }
                    a.this.pPH.a(dVar, this.pPN, a.this.pPF);
                    if (dVar.isShown()) {
                        if (dVar.pMt != null || dVar.ezx() <= this.pPN.getHeight()) {
                            int a2 = dVar.a(this.pPN);
                            if (a2 == 1) {
                                this.pPO.pPA++;
                            } else if (a2 == 2) {
                                this.pPO.pPB++;
                                if (a.this.pPI != null) {
                                    a.this.pPI.a(dVar);
                                }
                            }
                            this.pPO.ex(dVar.getType(), 1);
                            this.pPO.Rg(1);
                            this.pPO.v(dVar);
                            if (a.this.pPJ == null || dVar.pMM == a.this.pLp.pOx.pMZ) {
                                return 0;
                            }
                            dVar.pMM = a.this.pLp.pOx.pMZ;
                            a.this.pPJ.i(dVar);
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
        public void ezK() {
            this.pPO.pPq = this.pPM;
            super.ezK();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.pLp = danmakuContext;
        this.pPH = new b(danmakuContext.ezZ());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        eAt();
        this.pLp.pOy.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void eAt() {
        this.pPH.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.pPH.release();
        this.pLp.pOy.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void AU(boolean z) {
        this.pPF = z ? this.pPG : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.pPE = bVar.pLu;
        this.pPK.pPN = mVar;
        this.pPK.pPO = bVar;
        this.pPK.pPP = j;
        lVar.a(this.pPK);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.pPI = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC1064a interfaceC1064a) {
        this.pPJ = interfaceC1064a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void AV(boolean z) {
        if (this.pPH != null) {
            this.pPH.AV(z);
        }
    }
}
