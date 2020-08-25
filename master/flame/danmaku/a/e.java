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
    protected final DanmakuContext ouG;
    protected master.flame.danmaku.danmaku.a.a ouM;
    protected final master.flame.danmaku.danmaku.model.b ouQ;
    private l ovA;
    protected l ovm;
    h.a ovn;
    final master.flame.danmaku.danmaku.b.a ovo;
    master.flame.danmaku.danmaku.model.f ovp;
    protected boolean ovr;
    protected boolean ovt;
    private long ovu;
    private long ovv;
    protected int ovw;
    private boolean ovx;
    private master.flame.danmaku.danmaku.model.d ovy;
    private l ovq = new master.flame.danmaku.danmaku.model.android.d(4);
    private long ovs = 0;
    private final a.b ouR = new a.b();
    private master.flame.danmaku.danmaku.model.android.d ovz = new master.flame.danmaku.danmaku.model.android.d(4);
    private DanmakuContext.a ovB = new DanmakuContext.a() { // from class: master.flame.danmaku.a.e.1
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
        this.ouG = danmakuContext;
        this.ouQ = danmakuContext.eig();
        this.ovn = aVar;
        this.ovo = new master.flame.danmaku.danmaku.b.a.a(danmakuContext);
        this.ovo.a(new a.InterfaceC0977a() { // from class: master.flame.danmaku.a.e.2
            @Override // master.flame.danmaku.danmaku.b.a.InterfaceC0977a
            public void i(master.flame.danmaku.danmaku.model.d dVar) {
                if (e.this.ovn != null) {
                    e.this.ovn.i(dVar);
                }
            }
        });
        this.ovo.yV(this.ouG.eik() || this.ouG.eij());
        a(fVar);
        Boolean valueOf = Boolean.valueOf(this.ouG.eih());
        if (valueOf != null) {
            if (valueOf.booleanValue()) {
                this.ouG.oxQ.Wm("1017_Filter");
            } else {
                this.ouG.oxQ.Wn("1017_Filter");
            }
        }
    }

    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.ovp = fVar;
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean k;
        if (this.ovm != null) {
            if (dVar.kkG) {
                this.ovz.k(dVar);
                Oc(10);
            }
            dVar.index = this.ovm.size();
            boolean z = true;
            if (this.ovu <= dVar.ehI() && dVar.ehI() <= this.ovv) {
                synchronized (this.ovq) {
                    z = this.ovq.k(dVar);
                }
            } else if (dVar.kkG) {
                z = false;
            }
            synchronized (this.ovm) {
                k = this.ovm.k(dVar);
            }
            if (!z || !k) {
                this.ovv = 0L;
                this.ovu = 0L;
            }
            if (k && this.ovn != null) {
                this.ovn.h(dVar);
            }
            if (this.ovy == null || (dVar != null && this.ovy != null && dVar.ehI() > this.ovy.ehI())) {
                this.ovy = dVar;
            }
        }
    }

    @Override // master.flame.danmaku.a.h
    public synchronized void yL(boolean z) {
        if (this.ovm != null && !this.ovm.isEmpty()) {
            synchronized (this.ovm) {
                if (!z) {
                    l S = this.ovm.S((this.ovp.owf - this.ouG.oxR.oxW) - 100, this.ovp.owf + this.ouG.oxR.oxW);
                    if (S != null) {
                        this.ovq = S;
                    }
                }
                this.ovm.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.model.d dVar) {
    }

    protected synchronized void Oc(final int i) {
        if (this.ovm != null && !this.ovm.isEmpty() && !this.ovz.isEmpty()) {
            this.ovz.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.3
                long startTime = master.flame.danmaku.danmaku.c.c.eiF();

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                    boolean ehy = dVar.ehy();
                    if (master.flame.danmaku.danmaku.c.c.eiF() - this.startTime <= i && ehy) {
                        e.this.ovm.l(dVar);
                        e.this.b(dVar);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // master.flame.danmaku.a.h
    public l gQ(long j) {
        l S = this.ovm.S((j - this.ouG.oxR.oxW) - 100, this.ouG.oxR.oxW + j);
        final master.flame.danmaku.danmaku.model.android.d dVar = new master.flame.danmaku.danmaku.model.android.d();
        if (S != null && !S.isEmpty()) {
            S.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bO(master.flame.danmaku.danmaku.model.d dVar2) {
                    if (dVar2.isShown() && !dVar2.ehz()) {
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
        return a(bVar, this.ovp);
    }

    public void reset() {
        if (this.ovq != null) {
            this.ovq = new master.flame.danmaku.danmaku.model.android.d();
        }
        if (this.ovo != null) {
            this.ovo.clear();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void seek(long j) {
        master.flame.danmaku.danmaku.model.d ehR;
        reset();
        this.ouG.oxP.ehK();
        this.ouG.oxP.ehN();
        this.ouG.oxP.ehO();
        this.ouG.oxP.ehP();
        this.ovA = new master.flame.danmaku.danmaku.model.android.d(4);
        if (j < 1000) {
            j = 0;
        }
        this.ovs = j;
        this.ouR.reset();
        this.ouR.endTime = this.ovs;
        this.ovv = 0L;
        this.ovu = 0L;
        if (this.ovm != null && (ehR = this.ovm.ehR()) != null && !ehR.ehy()) {
            this.ovy = ehR;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void gR(long j) {
        reset();
        this.ouG.oxP.ehK();
        this.ouG.oxP.ehN();
        this.ovs = j;
    }

    @Override // master.flame.danmaku.a.h
    public void start() {
        this.ouG.a(this.ovB);
    }

    @Override // master.flame.danmaku.a.h
    public void quit() {
        this.ouG.eil();
        if (this.ovo != null) {
            this.ovo.release();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.ouM == null) {
            throw new AssertionError();
        }
        b(this.ouM);
        this.ovv = 0L;
        this.ovu = 0L;
        if (this.ovn != null) {
            this.ovn.ehf();
            this.ovt = true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void Ob(int i) {
        this.ovw = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(master.flame.danmaku.danmaku.a.a aVar) {
        this.ovm = aVar.c(this.ouG).c(this.ouQ).d(this.ovp).a(new a.InterfaceC0976a() { // from class: master.flame.danmaku.a.e.5
        }).eiz();
        this.ouG.oxP.resetAll();
        if (this.ovm != null) {
            this.ovy = this.ovm.ehR();
        }
    }

    @Override // master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.ouM = aVar;
        this.ovt = false;
    }

    protected a.b a(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j;
        long j2;
        if (this.ovr) {
            this.ovo.eiC();
            this.ovr = false;
        }
        if (this.ovm != null) {
            d.e((Canvas) bVar.tX());
            if (this.ovx) {
                return this.ouR;
            }
            a.b bVar2 = this.ouR;
            long j3 = (fVar.owf - this.ouG.oxR.oxW) - 100;
            long j4 = this.ouG.oxR.oxW + fVar.owf;
            l lVar = this.ovq;
            if (this.ovu > j3 || fVar.owf > this.ovv) {
                lVar = this.ovm.T(j3, j4);
                if (lVar != null) {
                    this.ovq = lVar;
                }
                this.ovu = j3;
                this.ovv = j4;
                j = j4;
                j2 = j3;
            } else {
                long j5 = this.ovu;
                j = this.ovv;
                j2 = j5;
            }
            l lVar2 = this.ovA;
            a(bVar2, lVar2, lVar);
            if (lVar2 != null && !lVar2.isEmpty()) {
                this.ouR.oyG = true;
                this.ovo.a(bVar, lVar2, 0L, this.ouR);
            }
            this.ouR.oyG = false;
            if (lVar != null && !lVar.isEmpty()) {
                this.ovo.a(this.ouQ, lVar, this.ovs, bVar2);
                a(bVar2);
                if (bVar2.oyS) {
                    if (this.ovy != null && this.ovy.ehy()) {
                        this.ovy = null;
                        if (this.ovn != null) {
                            this.ovn.ehg();
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
            bVar2.oyS = true;
            bVar2.beginTime = j2;
            bVar2.endTime = j;
            return bVar2;
        }
        return null;
    }

    @Override // master.flame.danmaku.a.h
    public void ehk() {
        this.ovv = 0L;
        this.ovu = 0L;
        this.ovx = false;
    }

    @Override // master.flame.danmaku.a.h
    public void ehl() {
        this.ovr = true;
    }

    @Override // master.flame.danmaku.a.h
    public void k(long j, long j2, final long j3) {
        l eiD = this.ouR.eiD();
        this.ovA = eiD;
        eiD.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                if (dVar.ehz()) {
                    return 2;
                }
                dVar.gU(j3 + dVar.ovJ);
                dVar.owe = true;
                return 0;
            }
        });
        this.ovs = j2;
    }

    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean b = b(danmakuContext, danmakuConfigTag, objArr);
        if (this.ovn != null) {
            this.ovn.ehh();
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
                    this.ouG.oxQ.Wm("1017_Filter");
                } else {
                    this.ouG.oxQ.Wn("1017_Filter");
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            ehl();
            return false;
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            if (this.ovo != null) {
                master.flame.danmaku.danmaku.b.a aVar = this.ovo;
                if (this.ouG.eik() || this.ouG.eij()) {
                    z2 = true;
                }
                aVar.yV(z2);
                return true;
            }
            return true;
        } else if (!DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) || (bool = (Boolean) objArr[0]) == null) {
            return false;
        } else {
            if (this.ovo != null) {
                this.ovo.yW(bool.booleanValue());
                return true;
            }
            return true;
        }
    }

    @Override // master.flame.danmaku.a.h
    public void ehm() {
        this.ovx = true;
    }

    private void a(a.b bVar, l lVar, l lVar2) {
        bVar.reset();
        bVar.ouL.gV(master.flame.danmaku.danmaku.c.c.eiF());
        bVar.oyH = 0;
        bVar.oyI = (lVar2 != null ? lVar2.size() : 0) + (lVar != null ? lVar.size() : 0);
    }

    private void a(a.b bVar) {
        bVar.oyS = bVar.oyP == 0;
        if (bVar.oyS) {
            bVar.beginTime = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = bVar.oyJ;
        bVar.oyJ = null;
        bVar.endTime = dVar != null ? dVar.ehI() : -1L;
        bVar.oyR = bVar.ouL.gV(master.flame.danmaku.danmaku.c.c.eiF());
    }
}
