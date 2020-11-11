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
    protected final DanmakuContext pUJ;
    protected master.flame.danmaku.danmaku.a.a pUP;
    protected final master.flame.danmaku.danmaku.model.b pUT;
    private boolean pVA;
    private master.flame.danmaku.danmaku.model.d pVB;
    private l pVD;
    protected l pVp;
    h.a pVq;
    final master.flame.danmaku.danmaku.b.a pVr;
    master.flame.danmaku.danmaku.model.f pVs;
    protected boolean pVu;
    protected boolean pVw;
    private long pVx;
    private long pVy;
    protected int pVz;
    private l pVt = new master.flame.danmaku.danmaku.model.android.d(4);
    private long pVv = 0;
    private final a.b pUU = new a.b();
    private master.flame.danmaku.danmaku.model.android.d pVC = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a pVE = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.pUJ = danmakuContext;
        this.pUT = danmakuContext.eDM();
        this.pVq = aVar;
        this.pVr = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.pVr.a(new a.InterfaceC1084a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC1084a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.pVq != null) {
                    e.this.pVq.i(dVar);
                }
            }
        });
        this.pVr.Bf(this.pUJ.eDQ() || this.pUJ.eDP());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.pUJ.eDN());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.pUJ.pXS.ZT("1017_Filter");
            } else {
                this.pUJ.pXS.ZU("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.pVs = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.pVp != null) {
            if (dVar.laS) {
                this.pVC.k(dVar);
                Rz(10);
            }
            dVar.index = this.pVp.size();
            boolean z = true;
            if (this.pVx <= dVar.eDo() && dVar.eDo() <= this.pVy) {
                synchronized (this.pVt) {
                    z = this.pVt.k(dVar);
                }
            } else if (dVar.laS) {
                z = false;
            }
            synchronized (this.pVp) {
                k = this.pVp.k(dVar);
            }
            if (!z || !k) {
                this.pVy = 0L;
                this.pVx = 0L;
            }
            if (k && this.pVq != null) {
                this.pVq.h(dVar);
            }
            if (this.pVB == null || (dVar != null && this.pVB != null && dVar.eDo() > this.pVB.eDo())) {
                this.pVB = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void AV(boolean z) {
        if (this.pVp != null && !this.pVp.isEmpty()) {
            synchronized (this.pVp) {
                if (!z) {
                    l R = this.pVp.R((this.pVs.pWi - this.pUJ.pXT.pXY) - 100, this.pVs.pWi + this.pUJ.pXT.pXY);
                    if (R != null) {
                        this.pVt = R;
                    }
                }
                this.pVp.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Rz(final int i) {
        if (this.pVp != null && !this.pVp.isEmpty() && !this.pVC.isEmpty()) {
            this.pVC.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.eEl();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean eDe = dVar.eDe();
                    if (master.flame.danmaku.danmaku.c.c.eEl() - this.startTime <= i && eDe) {
                        e.this.pVp.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l ik(long j) {
        l R = this.pVp.R((j - this.pUJ.pXT.pXY) - 100, this.pUJ.pXT.pXY + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (R != null && !R.isEmpty()) {
            R.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.eDf()) {
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
        return a(bVar, this.pVs);
    }

    public void reset() {
        if (this.pVt != null) {
            this.pVt = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.pVr != null) {
            this.pVr.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d eDx;
        reset();
        this.pUJ.pXR.eDq();
        this.pUJ.pXR.eDt();
        this.pUJ.pXR.eDu();
        this.pUJ.pXR.eDv();
        this.pVD = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.pVv = j;
        this.pUU.reset();
        this.pUU.endTime = this.pVv;
        this.pVy = 0L;
        this.pVx = 0L;
        if (this.pVp != null && (eDx = this.pVp.eDx()) != null && !eDx.eDe()) {
            this.pVB = eDx;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void il(long j) {
        reset();
        this.pUJ.pXR.eDq();
        this.pUJ.pXR.eDt();
        this.pVv = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.pUJ.a(this.pVE);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.pUJ.eDR();
        if (this.pVr != null) {
            this.pVr.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.pUP == null) {
            throw new AssertionError();
        }
        b(this.pUP);
        this.pVy = 0L;
        this.pVx = 0L;
        if (this.pVq != null) {
            this.pVq.eCL();
            this.pVw = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Ry(int i) {
        this.pVz = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.pVp = aVar.c(this.pUJ).c(this.pUT).d(this.pVs).a(new a.InterfaceC1083a() { // from class: master.flame.danmaku.a.e.5
        }).eEf();
        this.pUJ.pXR.resetAll();
        if (this.pVp != null) {
            this.pVB = this.pVp.eDx();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.pUP = aVar;
        this.pVw = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.pVu) {
            this.pVr.eEi();
            this.pVu = false;
        }
        if (this.pVp != null) {
            d.e((Canvas) bVar.ud());
            if (this.pVA) {
                return this.pUU;
            }
            a.b bVar2 = this.pUU;
            long j3 = (fVar.pWi - this.pUJ.pXT.pXY) - 100;
            long j4 = this.pUJ.pXT.pXY + fVar.pWi;
            l lVar = this.pVt;
            if (this.pVx > j3 || fVar.pWi > this.pVy) {
                lVar = this.pVp.S(j3, j4);
                if (lVar != null) {
                    this.pVt = lVar;
                }
                this.pVx = j3;
                this.pVy = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.pVx;
                j = this.pVy;
                j2 = j5;
            }
            l lVar2 = this.pVD;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.pUU.pYH = true;
                this.pVr.a(bVar, lVar2, 0L, this.pUU);
            }
            this.pUU.pYH = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.pVr.a(this.pUT, lVar, this.pVv, bVar2);
                a(bVar2);
                if (bVar2.pYT) {
                    if (this.pVB != null && this.pVB.eDe()) {
                        this.pVB = null;
                        if (this.pVq != null) {
                            this.pVq.eCM();
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
            bVar2.pYT = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void eCQ() {
        this.pVy = 0L;
        this.pVx = 0L;
        this.pVA = false;
    }

    @Override // master.flame.danmaku.a.h
    public void eCR() {
        this.pVu = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l eEj = this.pUU.eEj();
        this.pVD = eEj;
        eEj.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.eDf()) {
                    return 2;
                }
                dVar.io(j3 + dVar.pVM);
                dVar.pWh = true;
                return 0;
            }
        });
        this.pVv = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.pVq != null) {
            this.pVq.eCN();
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
                    this.pUJ.pXS.ZT("1017_Filter");
                } else {
                    this.pUJ.pXS.ZU("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            eCR();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.pVr != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.pVr;
                if (this.pUJ.eDQ() || this.pUJ.eDP()) {
                    z2 = true;
                }
                aVar.Bf(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.pVr != null) {
                this.pVr.Bg(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void eCS() {
        this.pVA = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.pUO.ip(master.flame.danmaku.danmaku.c.c.eEl());
        bVar.pYI = 0;
        bVar.pYJ = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.pYT = bVar.pYQ == 0;
        if (bVar.pYT) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.pYK;
        bVar.pYK = null;
        bVar.endTime = dVar != null ? dVar.eDo() : -1L;
        bVar.pYS = bVar.pUO.ip(master.flame.danmaku.danmaku.c.c.eEl());
    }
}
