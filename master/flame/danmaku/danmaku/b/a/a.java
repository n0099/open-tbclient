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
    private final DanmakuContext mZU;
    private f neo;
    private b.f nep;
    private final b ner;
    private k nes;
    private a.InterfaceC0821a neu;
    private final b.f neq = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nbc == 0 && a.this.mZU.ndg.b(dVar, i, 0, a.this.neo, z, a.this.mZU)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0822a nev = new C0822a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0822a extends l.c<d> {
        public long neA;
        private d nex;
        public m ney;
        public a.b nez;

        private C0822a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bF(d dVar) {
            this.nex = dVar;
            if (dVar.isTimeOut()) {
                this.ney.o(dVar);
                return 0;
            } else if (this.nez.ndX || !dVar.dFq()) {
                if (!dVar.dFi()) {
                    a.this.mZU.ndg.a(dVar, this.nez.ndY, this.nez.ndZ, this.nez.mZZ, false, a.this.mZU);
                }
                if (dVar.dFp() >= this.neA) {
                    if (dVar.nbc == 0 && dVar.dFj()) {
                        return 0;
                    }
                    if (dVar.dFh()) {
                        n<?> dFf = dVar.dFf();
                        if (a.this.nes != null && (dFf == null || dFf.get() == null)) {
                            a.this.nes.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nez.ndY++;
                    }
                    if (!dVar.dFe()) {
                        dVar.a(this.ney, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.ney, false);
                    }
                    a.this.ner.a(dVar, this.ney, a.this.nep);
                    if (dVar.isShown()) {
                        if (dVar.naY != null || dVar.dFn() <= this.ney.getHeight()) {
                            int a = dVar.a(this.ney);
                            if (a == 1) {
                                this.nez.nek++;
                            } else if (a == 2) {
                                this.nez.nel++;
                                if (a.this.nes != null) {
                                    a.this.nes.a(dVar);
                                }
                            }
                            this.nez.dN(dVar.getType(), 1);
                            this.nez.Jn(1);
                            this.nez.v(dVar);
                            if (a.this.neu == null || dVar.nbt == a.this.mZU.ndf.nbG) {
                                return 0;
                            }
                            dVar.nbt = a.this.mZU.ndf.nbG;
                            a.this.neu.i(dVar);
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
        public void dFA() {
            this.nez.nea = this.nex;
            super.dFA();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.mZU = danmakuContext;
        this.ner = new b(danmakuContext.dFP());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dGj();
        this.mZU.ndg.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dGj() {
        this.ner.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.ner.release();
        this.mZU.ndg.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wD(boolean z) {
        this.nep = z ? this.neq : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.neo = bVar.mZZ;
        this.nev.ney = mVar;
        this.nev.nez = bVar;
        this.nev.neA = j;
        lVar.a(this.nev);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nes = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0821a interfaceC0821a) {
        this.neu = interfaceC0821a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wE(boolean z) {
        if (this.ner != null) {
            this.ner.wE(z);
        }
    }
}
