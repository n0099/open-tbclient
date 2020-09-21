package master.flame.danmaku.a;

import android.graphics.Canvas;
import master.flame.danmaku.a.h;
import master.flame.danmaku.danmaku.a.a;
import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes6.dex */
public class e implements h {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected final DanmakuContext oEE;
    protected master.flame.danmaku.danmaku.a.a oEK;
    protected final master.flame.danmaku.danmaku.model.b oEO;
    protected l oFk;
    h.a oFl;
    final master.flame.danmaku.danmaku.b.a oFm;
    master.flame.danmaku.danmaku.model.f oFn;
    protected boolean oFp;
    protected boolean oFr;
    private long oFs;
    private long oFt;
    protected int oFu;
    private boolean oFv;
    private master.flame.danmaku.danmaku.model.d oFw;
    private l oFy;
    private l oFo = new master.flame.danmaku.danmaku.model.android.d(4);
    private long oFq = 0;
    private final a.b oEP = new a.b();
    private master.flame.danmaku.danmaku.model.android.d oFx = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a oFz = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
        @Override // master.flame.danmaku.danmaku.model.android.DanmakuContext.a
        public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
            return e.this.a(danmakuContext, danmakuConfigTag, objArr);
        }
    };

    static {
        $assertionsDisabled = !e.class.desiredAssertionStatus();
    }

    public e(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar) {
        if (danmakuContext == null) {
            throw new IllegalArgumentException("context is null");
        }
        this.oEE = danmakuContext;
        this.oEO = danmakuContext.emm();
        this.oFl = aVar;
        this.oFm = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.oFm.a(new a.InterfaceC0974a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0974a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.oFl != null) {
                    e.this.oFl.i(dVar);
                }
            }
        });
        this.oFm.zf(this.oEE.emq() || this.oEE.emp());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.oEE.emn());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.oEE.oHN.WO("1017_Filter");
            } else {
                this.oEE.oHN.WP("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.oFn = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.oFk != null) {
            if (dVar.ktm) {
                this.oFx.k(dVar);
                OH(10);
            }
            dVar.index = this.oFk.size();
            boolean z = true;
            if (this.oFs <= dVar.elO() && dVar.elO() <= this.oFt) {
                synchronized (this.oFo) {
                    z = this.oFo.k(dVar);
                }
            } else if (dVar.ktm) {
                z = false;
            }
            synchronized (this.oFk) {
                k = this.oFk.k(dVar);
            }
            if (!z || !k) {
                this.oFt = 0L;
                this.oFs = 0L;
            }
            if (k && this.oFl != null) {
                this.oFl.h(dVar);
            }
            if (this.oFw == null || (dVar != null && this.oFw != null && dVar.elO() > this.oFw.elO())) {
                this.oFw = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void yV(boolean z) {
        if (this.oFk != null && !this.oFk.isEmpty()) {
            synchronized (this.oFk) {
                if (!z) {
                    l P = this.oFk.P((this.oFn.oGd - this.oEE.oHO.oHT) - 100, this.oFn.oGd + this.oEE.oHO.oHT);
                    if (P != null) {
                        this.oFo = P;
                    }
                }
                this.oFk.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void OH(final int i) {
        if (this.oFk != null && !this.oFk.isEmpty() && !this.oFx.isEmpty()) {
            this.oFx.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.emL();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean elE = dVar.elE();
                    if (master.flame.danmaku.danmaku.c.c.emL() - this.startTime <= i && elE) {
                        e.this.oFk.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l hg(long j) {
        l P = this.oFk.P((j - this.oEE.oHO.oHT) - 100, this.oEE.oHO.oHT + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (P != null && !P.isEmpty()) {
            P.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bQ(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.elF()) {
                        dVar.k(dVar2);
                        return 0;
                    }
                    return 0;
                }
            });
        }
        return dVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        return a(bVar, this.oFn);
    }

    public void reset() {
        if (this.oFo != null) {
            this.oFo = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.oFm != null) {
            this.oFm.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d elX;
        reset();
        this.oEE.oHM.elQ();
        this.oEE.oHM.elT();
        this.oEE.oHM.elU();
        this.oEE.oHM.elV();
        this.oFy = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.oFq = j;
        this.oEP.reset();
        this.oEP.endTime = this.oFq;
        this.oFt = 0L;
        this.oFs = 0L;
        if (this.oFk != null && (elX = this.oFk.elX()) != null && !elX.elE()) {
            this.oFw = elX;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void hh(long j) {
        reset();
        this.oEE.oHM.elQ();
        this.oEE.oHM.elT();
        this.oFq = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.oEE.a(this.oFz);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.oEE.emr();
        if (this.oFm != null) {
            this.oFm.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.oEK == null) {
            throw new AssertionError();
        }
        b(this.oEK);
        this.oFt = 0L;
        this.oFs = 0L;
        if (this.oFl != null) {
            this.oFl.ell();
            this.oFr = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void OG(int i) {
        this.oFu = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.oFk = aVar.c(this.oEE).c(this.oEO).d(this.oFn).a(new a.InterfaceC0973a() { // from class: master.flame.danmaku.a.e.5
        }).emF();
        this.oEE.oHM.resetAll();
        if (this.oFk != null) {
            this.oFw = this.oFk.elX();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.oEK = aVar;
        this.oFr = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.oFp) {
            this.oFm.emI();
            this.oFp = false;
        }
        if (this.oFk != null) {
            d.e((Canvas) bVar.ud());
            if (this.oFv) {
                return this.oEP;
            }
            a.b bVar2 = this.oEP;
            long j3 = (fVar.oGd - this.oEE.oHO.oHT) - 100;
            long j4 = this.oEE.oHO.oHT + fVar.oGd;
            l lVar = this.oFo;
            if (this.oFs > j3 || fVar.oGd > this.oFt) {
                lVar = this.oFk.Q(j3, j4);
                if (lVar != null) {
                    this.oFo = lVar;
                }
                this.oFs = j3;
                this.oFt = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.oFs;
                j = this.oFt;
                j2 = j5;
            }
            l lVar2 = this.oFy;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.oEP.oID = true;
                this.oFm.a(bVar, lVar2, 0L, this.oEP);
            }
            this.oEP.oID = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.oFm.a(this.oEO, lVar, this.oFq, bVar2);
                a(bVar2);
                if (bVar2.oIP) {
                    if (this.oFw != null && this.oFw.elE()) {
                        this.oFw = null;
                        if (this.oFl != null) {
                            this.oFl.elm();
                        }
                    }
                    if (bVar2.beginTime == -1) {
                        bVar2.beginTime = j2;
                    }
                    if (bVar2.endTime == -1) {
                        bVar2.endTime = j;
                    }
                }
                return bVar2;
            }
            bVar2.oIP = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void elq() {
        this.oFt = 0L;
        this.oFs = 0L;
        this.oFv = false;
    }

    @Override // master.flame.danmaku.a.h
    public void elr() {
        this.oFp = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l emJ = this.oEP.emJ();
        this.oFy = emJ;
        emJ.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.elF()) {
                    return 2;
                }
                dVar.hk(j3 + dVar.oFH);
                dVar.oGc = true;
                return 0;
            }
        });
        this.oFq = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.oFl != null) {
            this.oFl.eln();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object[] objArr) {
        Boolean bool;
        boolean z;
        boolean z2 = false;
        if (danmakuConfigTag == null || DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN.equals(danmakuConfigTag)) {
            return true;
        }
        if (DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED.equals(danmakuConfigTag)) {
            Boolean bool2 = (Boolean) objArr[0];
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    this.oEE.oHN.WO("1017_Filter");
                } else {
                    this.oEE.oHN.WP("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            elr();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.oFm != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.oFm;
                if (this.oEE.emq() || this.oEE.emp()) {
                    z2 = true;
                }
                aVar.zf(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.oFm != null) {
                this.oFm.zg(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void els() {
        this.oFv = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.oEJ.hl(master.flame.danmaku.danmaku.c.c.emL());
        bVar.oIE = 0;
        bVar.oIF = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.oIP = bVar.oIM == 0;
        if (bVar.oIP) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.oIG;
        bVar.oIG = null;
        bVar.endTime = dVar != null ? dVar.elO() : -1L;
        bVar.oIO = bVar.oEJ.hl(master.flame.danmaku.danmaku.c.c.emL());
    }
}
