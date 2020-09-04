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
    protected final DanmakuContext ouY;
    protected l ovE;
    h.a ovF;
    final master.flame.danmaku.danmaku.b.a ovG;
    master.flame.danmaku.danmaku.model.f ovH;
    protected boolean ovJ;
    protected boolean ovL;
    private long ovM;
    private long ovN;
    protected int ovO;
    private boolean ovP;
    private master.flame.danmaku.danmaku.model.d ovQ;
    private l ovS;
    protected master.flame.danmaku.danmaku.a.a ove;
    protected final master.flame.danmaku.danmaku.model.b ovi;
    private l ovI = new master.flame.danmaku.danmaku.model.android.d(4);
    private long ovK = 0;
    private final a.b ovj = new a.b();
    private master.flame.danmaku.danmaku.model.android.d ovR = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a ovT = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.ouY = danmakuContext;
        this.ovi = danmakuContext.eip();
        this.ovF = aVar;
        this.ovG = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.ovG.a(new a.InterfaceC0977a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0977a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.ovF != null) {
                    e.this.ovF.i(dVar);
                }
            }
        });
        this.ovG.yX(this.ouY.eit() || this.ouY.eis());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.ouY.eiq());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.ouY.oyi.Wm("1017_Filter");
            } else {
                this.ouY.oyi.Wn("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.ovH = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.ovE != null) {
            if (dVar.kkN) {
                this.ovR.k(dVar);
                Oc(10);
            }
            dVar.index = this.ovE.size();
            boolean z = true;
            if (this.ovM <= dVar.ehR() && dVar.ehR() <= this.ovN) {
                synchronized (this.ovI) {
                    z = this.ovI.k(dVar);
                }
            } else if (dVar.kkN) {
                z = false;
            }
            synchronized (this.ovE) {
                k = this.ovE.k(dVar);
            }
            if (!z || !k) {
                this.ovN = 0L;
                this.ovM = 0L;
            }
            if (k && this.ovF != null) {
                this.ovF.h(dVar);
            }
            if (this.ovQ == null || (dVar != null && this.ovQ != null && dVar.ehR() > this.ovQ.ehR())) {
                this.ovQ = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void yN(boolean z) {
        if (this.ovE != null && !this.ovE.isEmpty()) {
            synchronized (this.ovE) {
                if (!z) {
                    l S = this.ovE.S((this.ovH.owx - this.ouY.oyj.oyo) - 100, this.ovH.owx + this.ouY.oyj.oyo);
                    if (S != null) {
                        this.ovI = S;
                    }
                }
                this.ovE.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Oc(final int i) {
        if (this.ovE != null && !this.ovE.isEmpty() && !this.ovR.isEmpty()) {
            this.ovR.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.eiO();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean ehH = dVar.ehH();
                    if (master.flame.danmaku.danmaku.c.c.eiO() - this.startTime <= i && ehH) {
                        e.this.ovE.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l gS(long j) {
        l S = this.ovE.S((j - this.ouY.oyj.oyo) - 100, this.ouY.oyj.oyo + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (S != null && !S.isEmpty()) {
            S.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bO(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.ehI()) {
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
        return a(bVar, this.ovH);
    }

    public void reset() {
        if (this.ovI != null) {
            this.ovI = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.ovG != null) {
            this.ovG.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d eia;
        reset();
        this.ouY.oyh.ehT();
        this.ouY.oyh.ehW();
        this.ouY.oyh.ehX();
        this.ouY.oyh.ehY();
        this.ovS = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.ovK = j;
        this.ovj.reset();
        this.ovj.endTime = this.ovK;
        this.ovN = 0L;
        this.ovM = 0L;
        if (this.ovE != null && (eia = this.ovE.eia()) != null && !eia.ehH()) {
            this.ovQ = eia;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gT(long j) {
        reset();
        this.ouY.oyh.ehT();
        this.ouY.oyh.ehW();
        this.ovK = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.ouY.a(this.ovT);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.ouY.eiu();
        if (this.ovG != null) {
            this.ovG.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.ove == null) {
            throw new AssertionError();
        }
        b(this.ove);
        this.ovN = 0L;
        this.ovM = 0L;
        if (this.ovF != null) {
            this.ovF.eho();
            this.ovL = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Ob(int i) {
        this.ovO = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.ovE = aVar.c(this.ouY).c(this.ovi).d(this.ovH).a(new a.InterfaceC0976a() { // from class: master.flame.danmaku.a.e.5
        }).eiI();
        this.ouY.oyh.resetAll();
        if (this.ovE != null) {
            this.ovQ = this.ovE.eia();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.ove = aVar;
        this.ovL = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.ovJ) {
            this.ovG.eiL();
            this.ovJ = false;
        }
        if (this.ovE != null) {
            d.e((Canvas) bVar.tX());
            if (this.ovP) {
                return this.ovj;
            }
            a.b bVar2 = this.ovj;
            long j3 = (fVar.owx - this.ouY.oyj.oyo) - 100;
            long j4 = this.ouY.oyj.oyo + fVar.owx;
            l lVar = this.ovI;
            if (this.ovM > j3 || fVar.owx > this.ovN) {
                lVar = this.ovE.T(j3, j4);
                if (lVar != null) {
                    this.ovI = lVar;
                }
                this.ovM = j3;
                this.ovN = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.ovM;
                j = this.ovN;
                j2 = j5;
            }
            l lVar2 = this.ovS;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.ovj.oyY = true;
                this.ovG.a(bVar, lVar2, 0L, this.ovj);
            }
            this.ovj.oyY = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.ovG.a(this.ovi, lVar, this.ovK, bVar2);
                a(bVar2);
                if (bVar2.ozk) {
                    if (this.ovQ != null && this.ovQ.ehH()) {
                        this.ovQ = null;
                        if (this.ovF != null) {
                            this.ovF.ehp();
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
            bVar2.ozk = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void eht() {
        this.ovN = 0L;
        this.ovM = 0L;
        this.ovP = false;
    }

    @Override // master.flame.danmaku.a.h
    public void ehu() {
        this.ovJ = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l eiM = this.ovj.eiM();
        this.ovS = eiM;
        eiM.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.ehI()) {
                    return 2;
                }
                dVar.gW(j3 + dVar.owb);
                dVar.oww = true;
                return 0;
            }
        });
        this.ovK = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.ovF != null) {
            this.ovF.ehq();
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
                    this.ouY.oyi.Wm("1017_Filter");
                } else {
                    this.ouY.oyi.Wn("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            ehu();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.ovG != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.ovG;
                if (this.ouY.eit() || this.ouY.eis()) {
                    z2 = true;
                }
                aVar.yX(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.ovG != null) {
                this.ovG.yY(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void ehv() {
        this.ovP = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.ovd.gX(master.flame.danmaku.danmaku.c.c.eiO());
        bVar.oyZ = 0;
        bVar.oza = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.ozk = bVar.ozh == 0;
        if (bVar.ozk) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.ozb;
        bVar.ozb = null;
        bVar.endTime = dVar != null ? dVar.ehR() : -1L;
        bVar.ozj = bVar.ovd.gX(master.flame.danmaku.danmaku.c.c.eiO());
    }
}
