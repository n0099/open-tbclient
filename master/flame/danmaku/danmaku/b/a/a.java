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
    private final DanmakuContext nuX;
    private f nzq;
    private b.f nzr;
    private final b nzt;
    private k nzu;
    private a.InterfaceC0883a nzv;
    private final b.f nzs = new b.f() { // from class: master.flame.danmaku.danmaku.b.a.a.1
        @Override // master.flame.danmaku.danmaku.b.a.b.f
        public boolean a(d dVar, float f, int i, boolean z) {
            if (dVar.nwf == 0 && a.this.nuX.nyj.b(dVar, i, 0, a.this.nzq, z, a.this.nuX)) {
                dVar.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private C0884a nzw = new C0884a();

    /* renamed from: master.flame.danmaku.danmaku.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0884a extends l.c<d> {
        public a.b nzA;
        public long nzB;
        private d nzy;
        public m nzz;

        private C0884a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.b
        /* renamed from: e */
        public int bL(d dVar) {
            this.nzy = dVar;
            if (dVar.isTimeOut()) {
                this.nzz.o(dVar);
                return 0;
            } else if (this.nzA.nyZ || !dVar.dNl()) {
                if (!dVar.dNd()) {
                    a.this.nuX.nyj.a(dVar, this.nzA.nza, this.nzA.nzb, this.nzA.nvc, false, a.this.nuX);
                }
                if (dVar.dNk() >= this.nzB) {
                    if (dVar.nwf == 0 && dVar.dNe()) {
                        return 0;
                    }
                    if (dVar.dNc()) {
                        n<?> dNa = dVar.dNa();
                        if (a.this.nzu != null && (dNa == null || dNa.get() == null)) {
                            a.this.nzu.a(dVar);
                        }
                        return 1;
                    }
                    if (dVar.getType() == 1) {
                        this.nzA.nza++;
                    }
                    if (!dVar.dMZ()) {
                        dVar.a(this.nzz, false);
                    }
                    if (!dVar.isPrepared()) {
                        dVar.b(this.nzz, false);
                    }
                    a.this.nzt.a(dVar, this.nzz, a.this.nzr);
                    if (dVar.isShown()) {
                        if (dVar.nwb != null || dVar.dNi() <= this.nzz.getHeight()) {
                            int a = dVar.a(this.nzz);
                            if (a == 1) {
                                this.nzA.nzm++;
                            } else if (a == 2) {
                                this.nzA.nzn++;
                                if (a.this.nzu != null) {
                                    a.this.nzu.a(dVar);
                                }
                            }
                            this.nzA.dS(dVar.getType(), 1);
                            this.nzA.JY(1);
                            this.nzA.v(dVar);
                            if (a.this.nzv == null || dVar.nww == a.this.nuX.nyi.nwJ) {
                                return 0;
                            }
                            dVar.nww = a.this.nuX.nyi.nwJ;
                            a.this.nzv.i(dVar);
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
        public void dNv() {
            this.nzA.nzc = this.nzy;
            super.dNv();
        }
    }

    public a(DanmakuContext danmakuContext) {
        this.nuX = danmakuContext;
        this.nzt = new b(danmakuContext.dNK());
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void clear() {
        dOe();
        this.nuX.nyj.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void dOe() {
        this.nzt.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void release() {
        this.nzt.release();
        this.nuX.nyj.clear();
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void xb(boolean z) {
        this.nzr = z ? this.nzs : null;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(m mVar, l lVar, long j, a.b bVar) {
        this.nzq = bVar.nvc;
        this.nzw.nzz = mVar;
        this.nzw.nzA = bVar;
        this.nzw.nzB = j;
        lVar.a(this.nzw);
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(k kVar) {
        this.nzu = kVar;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void a(a.InterfaceC0883a interfaceC0883a) {
        this.nzv = interfaceC0883a;
    }

    @Override // master.flame.danmaku.danmaku.b.a
    public void xc(boolean z) {
        if (this.nzt != null) {
            this.nzt.xc(z);
        }
    }
}
