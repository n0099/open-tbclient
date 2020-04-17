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
    private final DanmakuContext mZR;
    private f nel;
    private b.f nem;
    private final b neo;
    private k nep;
    private a.InterfaceC0800a neq;
    private final b.f nen = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.naZ == 0 && a.this.mZR.ndd.b(dVar, i, 0, a.this.nel, z, a.this.mZR)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0801a ner = new C0801a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0801a extends l.c<d> {
        private d neu;
        public m nev;

        /* renamed from: new  reason: not valid java name */
        public a.b f953new;
        public long nex;

        private C0801a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bE(d dVar) {
            this.neu = dVar;
            if (dVar.isTimeOut()) {
                this.nev.o(dVar);
                return 0;
            } else if (this.f953new.ndU || !dVar.dFu()) {
                if (!dVar.dFm()) {
                    a.this.mZR.ndd.a(dVar, this.f953new.ndV, this.f953new.ndW, this.f953new.mZW, false, a.this.mZR);
                }
                if (dVar.dFt() >= this.nex) {
                    if (dVar.naZ == 0 && dVar.dFn()) {
                        return 0;
                    }
                    if (dVar.dFl()) {
                        n<?> dFj = dVar.dFj();
                        if (a.this.nep != null && (dFj == null || dFj.get() == null)) {
                            a.this.nep.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.f953new.ndV++;
                    }
                    if (!dVar.dFi()) {
                        dVar.a(this.nev, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.nev, false);
                    }
                    a.this.neo.a(dVar, this.nev, a.this.nem);
                    if (dVar.isShown()) {
                        if (dVar.naV != null || dVar.dFr() <= this.nev.getHeight()) {
                            int a = dVar.a(this.nev);
                            if (a == 1) {
                                this.f953new.neh++;
                            } else if (a == 2) {
                                this.f953new.nei++;
                                if (a.this.nep != null) {
                                    a.this.nep.a(dVar);
                                }
                            }
                            this.f953new.dN(dVar.getType(), 1);
                            this.f953new.Jn(1);
                            this.f953new.v(dVar);
                            if (a.this.neq == null || dVar.nbq == a.this.mZR.ndc.nbD) {
                                return 0;
                            }
                            dVar.nbq = a.this.mZR.ndc.nbD;
                            a.this.neq.i(dVar);
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
        public void dFE() {
            this.f953new.ndX = this.neu;
            super.dFE();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.mZR = danmakuContext;
        this.neo = new b(danmakuContext.dFT());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dGn();
        this.mZR.ndd.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dGn() {
        this.neo.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.neo.release();
        this.mZR.ndd.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wD(boolean z) {
        this.nem = z ? this.nen : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nel = bVar.mZW;
        this.ner.nev = mVar;
        this.ner.f953new = bVar;
        this.ner.nex = j;
        lVar.a(this.ner);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nep = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0800a interfaceC0800a) {
        this.neq = interfaceC0800a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void wE(boolean z) {
        if (this.neo != null) {
            this.neo.wE(z);
        }
    }
}
