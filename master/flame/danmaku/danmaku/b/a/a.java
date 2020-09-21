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
    private final DanmakuContext oEE;
    private f oIU;
    private b.f oIV;
    private final b oIX;
    private k oIY;
    private a.InterfaceC0974a oIZ;
    private final b.f oIW = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.oFL == 0 && a.this.oEE.oHN.b(dVar, i, 0, a.this.oIU, z, a.this.oEE)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0975a oJa = new C0975a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0975a extends l.c<d> {
        private d oJc;
        public m oJd;
        public a.b oJe;
        public long oJf;

        private C0975a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bQ(d dVar) {
            this.oJc = dVar;
            if (dVar.elE()) {
                this.oJd.o(dVar);
                return 0;
            } else if (this.oJe.oID || !dVar.elP()) {
                if (!dVar.elH()) {
                    a.this.oEE.oHN.a(dVar, this.oJe.oIE, this.oJe.oIF, this.oJe.oEJ, false, a.this.oEE);
                }
                if (dVar.elO() >= this.oJf) {
                    if (dVar.oFL == 0 && dVar.elI()) {
                        return 0;
                    }
                    if (dVar.elG()) {
                        n<?> elD = dVar.elD();
                        if (a.this.oIY != null && (elD == null || elD.get() == null)) {
                            a.this.oIY.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.oJe.oIE++;
                    }
                    if (!dVar.elC()) {
                        dVar.a(this.oJd, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.oJd, false);
                    }
                    a.this.oIX.a(dVar, this.oJd, a.this.oIV);
                    if (dVar.isShown()) {
                        if (dVar.oFI != null || dVar.elM() <= this.oJd.getHeight()) {
                            int a = dVar.a(this.oJd);
                            if (a == 1) {
                                this.oJe.oIQ++;
                            } else if (a == 2) {
                                this.oJe.oIR++;
                                if (a.this.oIY != null) {
                                    a.this.oIY.a(dVar);
                                }
                            }
                            this.oJe.ep(dVar.getType(), 1);
                            this.oJe.OJ(1);
                            this.oJe.v(dVar);
                            if (a.this.oIZ == null || dVar.oGb == a.this.oEE.oHM.oGo) {
                                return 0;
                            }
                            dVar.oGb = a.this.oEE.oHM.oGo;
                            a.this.oIZ.i(dVar);
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
        public void elZ() {
            this.oJe.oIG = this.oJc;
            super.elZ();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.oEE = danmakuContext;
        this.oIX = new b(danmakuContext.emo());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        emI();
        this.oEE.oHN.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void emI() {
        this.oIX.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.oIX.release();
        this.oEE.oHN.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void zf(boolean z) {
        this.oIV = z ? this.oIW : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.oIU = bVar.oEJ;
        this.oJa.oJd = mVar;
        this.oJa.oJe = bVar;
        this.oJa.oJf = j;
        lVar.a(this.oJa);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.oIY = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0974a interfaceC0974a) {
        this.oIZ = interfaceC0974a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void zg(boolean z) {
        if (this.oIX != null) {
            this.oIX.zg(z);
        }
    }
}
