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
    protected l pWS;
    h.a pWT;
    final master.flame.danmaku.danmaku.b.a pWU;
    master.flame.danmaku.danmaku.model.f pWV;
    protected boolean pWX;
    protected boolean pWZ;
    protected final DanmakuContext pWm;
    protected master.flame.danmaku.danmaku.a.a pWs;
    protected final master.flame.danmaku.danmaku.model.b pWw;
    private long pXa;
    private long pXb;
    protected int pXc;
    private boolean pXd;
    private master.flame.danmaku.danmaku.model.d pXe;
    private l pXg;
    private l pWW = new master.flame.danmaku.danmaku.model.android.d(4);
    private long pWY = 0;
    private final a.b pWx = new a.b();
    private master.flame.danmaku.danmaku.model.android.d pXf = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a pXh = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.pWm = danmakuContext;
        this.pWw = danmakuContext.eDN();
        this.pWT = aVar;
        this.pWU = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.pWU.a(new a.InterfaceC1087a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC1087a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.pWT != null) {
                    e.this.pWT.i(dVar);
                }
            }
        });
        this.pWU.Bm(this.pWm.eDR() || this.pWm.eDQ());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.pWm.eDO());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.pWm.pZv.ZE("1017_Filter");
            } else {
                this.pWm.pZv.ZF("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.pWV = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.pWS != null) {
            if (dVar.lbl) {
                this.pXf.k(dVar);
                Sc(10);
            }
            dVar.index = this.pWS.size();
            boolean z = true;
            if (this.pXa <= dVar.eDp() && dVar.eDp() <= this.pXb) {
                synchronized (this.pWW) {
                    z = this.pWW.k(dVar);
                }
            } else if (dVar.lbl) {
                z = false;
            }
            synchronized (this.pWS) {
                k = this.pWS.k(dVar);
            }
            if (!z || !k) {
                this.pXb = 0L;
                this.pXa = 0L;
            }
            if (k && this.pWT != null) {
                this.pWT.h(dVar);
            }
            if (this.pXe == null || (dVar != null && this.pXe != null && dVar.eDp() > this.pXe.eDp())) {
                this.pXe = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void Bc(boolean z) {
        if (this.pWS != null && !this.pWS.isEmpty()) {
            synchronized (this.pWS) {
                if (!z) {
                    l R = this.pWS.R((this.pWV.pXL - this.pWm.pZw.pZB) - 100, this.pWV.pXL + this.pWm.pZw.pZB);
                    if (R != null) {
                        this.pWW = R;
                    }
                }
                this.pWS.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Sc(final int i) {
        if (this.pWS != null && !this.pWS.isEmpty() && !this.pXf.isEmpty()) {
            this.pXf.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.eEm();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean eDf = dVar.eDf();
                    if (master.flame.danmaku.danmaku.c.c.eEm() - this.startTime <= i && eDf) {
                        e.this.pWS.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l in(long j) {
        l R = this.pWS.R((j - this.pWm.pZw.pZB) - 100, this.pWm.pZw.pZB + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (R != null && !R.isEmpty()) {
            R.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bY(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.eDg()) {
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
        return a(bVar, this.pWV);
    }

    public void reset() {
        if (this.pWW != null) {
            this.pWW = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.pWU != null) {
            this.pWU.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d eDy;
        reset();
        this.pWm.pZu.eDr();
        this.pWm.pZu.eDu();
        this.pWm.pZu.eDv();
        this.pWm.pZu.eDw();
        this.pXg = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.pWY = j;
        this.pWx.reset();
        this.pWx.endTime = this.pWY;
        this.pXb = 0L;
        this.pXa = 0L;
        if (this.pWS != null && (eDy = this.pWS.eDy()) != null && !eDy.eDf()) {
            this.pXe = eDy;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void io(long j) {
        reset();
        this.pWm.pZu.eDr();
        this.pWm.pZu.eDu();
        this.pWY = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.pWm.a(this.pXh);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.pWm.eDS();
        if (this.pWU != null) {
            this.pWU.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.pWs == null) {
            throw new AssertionError();
        }
        b(this.pWs);
        this.pXb = 0L;
        this.pXa = 0L;
        if (this.pWT != null) {
            this.pWT.eCM();
            this.pWZ = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Sb(int i) {
        this.pXc = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.pWS = aVar.c(this.pWm).c(this.pWw).d(this.pWV).a(new a.InterfaceC1086a() { // from class: master.flame.danmaku.a.e.5
        }).eEg();
        this.pWm.pZu.resetAll();
        if (this.pWS != null) {
            this.pXe = this.pWS.eDy();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.pWs = aVar;
        this.pWZ = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.pWX) {
            this.pWU.eEj();
            this.pWX = false;
        }
        if (this.pWS != null) {
            d.e((Canvas) bVar.ud());
            if (this.pXd) {
                return this.pWx;
            }
            a.b bVar2 = this.pWx;
            long j3 = (fVar.pXL - this.pWm.pZw.pZB) - 100;
            long j4 = this.pWm.pZw.pZB + fVar.pXL;
            l lVar = this.pWW;
            if (this.pXa > j3 || fVar.pXL > this.pXb) {
                lVar = this.pWS.S(j3, j4);
                if (lVar != null) {
                    this.pWW = lVar;
                }
                this.pXa = j3;
                this.pXb = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.pXa;
                j = this.pXb;
                j2 = j5;
            }
            l lVar2 = this.pXg;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.pWx.qak = true;
                this.pWU.a(bVar, lVar2, 0L, this.pWx);
            }
            this.pWx.qak = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.pWU.a(this.pWw, lVar, this.pWY, bVar2);
                a(bVar2);
                if (bVar2.qaw) {
                    if (this.pXe != null && this.pXe.eDf()) {
                        this.pXe = null;
                        if (this.pWT != null) {
                            this.pWT.eCN();
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
            bVar2.qaw = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void eCR() {
        this.pXb = 0L;
        this.pXa = 0L;
        this.pXd = false;
    }

    @Override // master.flame.danmaku.a.h
    public void eCS() {
        this.pWX = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l eEk = this.pWx.eEk();
        this.pXg = eEk;
        eEk.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.eDg()) {
                    return 2;
                }
                dVar.ir(j3 + dVar.pXp);
                dVar.pXK = true;
                return 0;
            }
        });
        this.pWY = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.pWT != null) {
            this.pWT.eCO();
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
                    this.pWm.pZv.ZE("1017_Filter");
                } else {
                    this.pWm.pZv.ZF("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            eCS();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.pWU != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.pWU;
                if (this.pWm.eDR() || this.pWm.eDQ()) {
                    z2 = true;
                }
                aVar.Bm(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.pWU != null) {
                this.pWU.Bn(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void eCT() {
        this.pXd = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.pWr.is(master.flame.danmaku.danmaku.c.c.eEm());
        bVar.qal = 0;
        bVar.qam = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.qaw = bVar.qat == 0;
        if (bVar.qaw) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.qan;
        bVar.qan = null;
        bVar.endTime = dVar != null ? dVar.eDp() : -1L;
        bVar.qav = bVar.pWr.is(master.flame.danmaku.danmaku.c.c.eEm());
    }
}
