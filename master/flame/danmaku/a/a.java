package master.flame.danmaku.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import master.flame.danmaku.a.h;
import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;
import tv.cjump.jni.NativeBitmapFactory;
/* loaded from: classes6.dex */
public class a extends e {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int oSX;
    private C0988a oSY;
    private master.flame.danmaku.danmaku.model.f oSZ;
    private final Object oTa;
    private int oTb;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.oSX = 2;
        this.oTa = new Object();
        NativeBitmapFactory.euG();
        this.oSX = i;
        if (NativeBitmapFactory.euF()) {
            this.oSX = i * 2;
        }
        this.oSY = new C0988a(i, 3);
        this.oUB.a(this.oSY);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.oUC = fVar;
        this.oSZ = new master.flame.danmaku.danmaku.model.f();
        this.oSZ.hD(fVar.oVs);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.oSY != null) {
            this.oSY.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void zC(boolean z) {
        super.zC(z);
        if (this.oSY != null) {
            this.oSY.eoG();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.oSY != null) {
            int i = this.oTb + 1;
            this.oTb = i;
            if (i > 5) {
                this.oSY.eoI();
                this.oTb = 0;
                return;
            }
            return;
        }
        n<?> epq = dVar.epq();
        if (epq != null) {
            if (epq.epS()) {
                epq.epT();
            } else {
                epq.destroy();
            }
            dVar.oVi = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a2 = super.a(bVar);
        synchronized (this.oTa) {
            this.oTa.notify();
        }
        if (a2 != null && this.oSY != null && a2.oYa - a2.oYb < -20) {
            this.oSY.eoI();
            this.oSY.hu(-this.oTT.oXd.oXi);
        }
        return a2;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.oSY == null) {
            start();
        }
        this.oSY.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.euG();
        if (this.oSY == null) {
            this.oSY = new C0988a(this.oSX, 3);
            this.oSY.eoA();
            this.oUB.a(this.oSY);
            return;
        }
        this.oSY.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.oUB.a((k) null);
        if (this.oSY != null) {
            this.oSY.end();
            this.oSY = null;
        }
        NativeBitmapFactory.euH();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.oTZ == null) {
            throw new AssertionError();
        }
        b(this.oTZ);
        this.oSY.eoA();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Pm(int i) {
        super.Pm(i);
        if (this.oSY != null) {
            this.oSY.Pm(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.oSY != null) {
            this.oSY.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0988a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int oTh;
        private HandlerC0989a oTi;
        master.flame.danmaku.danmaku.model.android.d oTd = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g oTe = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> oTf = master.flame.danmaku.danmaku.model.a.e.a(this.oTe, 800);
        private boolean oTj = false;
        private int oTg = 0;

        public C0988a(int i, int i2) {
            this.oTh = 3;
            this.mMaxSize = i;
            this.oTh = i2;
        }

        public void seek(long j) {
            if (this.oTi != null) {
                this.oTi.eoL();
                this.oTi.removeMessages(3);
                this.oTi.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.oTi != null) {
                if (dVar.kIy) {
                    if (dVar.oVj) {
                        if (!dVar.epr()) {
                            this.oTi.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.oTi.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.oTi.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void eoA() {
            this.oTj = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.oTi == null) {
                this.oTi = new HandlerC0989a(this.mThread.getLooper());
            }
            this.oTi.eoA();
        }

        public void end() {
            this.oTj = true;
            synchronized (a.this.oTa) {
                a.this.oTa.notifyAll();
            }
            if (this.oTi != null) {
                this.oTi.pause();
                this.oTi = null;
            }
            if (this.mThread != null) {
                try {
                    this.mThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.mThread.quit();
                this.mThread = null;
            }
        }

        public void resume() {
            if (this.oTi != null) {
                this.oTi.resume();
            } else {
                eoA();
            }
        }

        public void Pm(int i) {
            if (this.oTi != null) {
                this.oTi.zF(i == 1);
            }
        }

        public float eoB() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.oTg / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.oTd != null) {
                this.oTd.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                        C0988a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.oTd.clear();
            }
            this.oTg = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eoC() {
            zD(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void zD(final boolean z) {
            if (this.oTd != null) {
                this.oTd.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.oVi;
                        boolean z2 = nVar != null && nVar.epS();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0988a.this.oTg -= nVar.size();
                                nVar.destroy();
                            }
                            C0988a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.eps()) {
                            C0988a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> epq = dVar.epq();
            if (epq != null) {
                long c = c(dVar);
                if (dVar.epr()) {
                    a.this.oTT.epZ().epo().t(dVar);
                }
                if (c > 0) {
                    this.oTg = (int) (this.oTg - c);
                    this.oTf.c((master.flame.danmaku.danmaku.model.android.e) epq);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.oVi;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.epS()) {
                nVar.epT();
                dVar.oVi = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.oVi = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.oVi != null && !dVar.oVi.epS()) {
                    return dVar.oVi.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eoD() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e eqq = this.oTf.eqq();
                if (eqq != null) {
                    eqq.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d epJ = this.oTd.epJ();
            while (true) {
                if (this.oTg + i <= this.mMaxSize || epJ == null) {
                    break;
                } else if (epJ.epr()) {
                    a(false, epJ, dVar);
                    this.oTd.l(epJ);
                    epJ = this.oTd.epJ();
                } else if (!z) {
                    return false;
                }
            }
            this.oTd.k(dVar);
            this.oTg += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eoE() {
            this.oTd.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.epr()) {
                        synchronized (a.this.oTa) {
                            try {
                                a.this.oTa.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0988a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        i = 2;
                    }
                    return i;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public master.flame.danmaku.danmaku.model.d a(final master.flame.danmaku.danmaku.model.d dVar, final boolean z, final int i) {
            final int i2 = 0;
            if (!z) {
                i2 = a.this.oUd.epO() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d oTm;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: eoJ */
                public master.flame.danmaku.danmaku.model.d eoK() {
                    return this.oTm;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bT(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> epq = dVar2.epq();
                    if (epq == null || epq.get() == null) {
                        return 0;
                    }
                    if (dVar2.oVb == dVar.oVb && dVar2.oVc == dVar.oVc && dVar2.underlineColor == dVar.underlineColor && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.oTm = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.epr()) {
                            if (epq.epS()) {
                                return 0;
                            }
                            float width = epq.width() - dVar.oVb;
                            float height = epq.height() - dVar.oVc;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.oTm = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.oTd.b(bVar);
            return bVar.eoK();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC0989a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean oTr;
            private boolean oTs;

            public HandlerC0989a(Looper looper) {
                super(looper);
            }

            public void eoL() {
                this.oTs = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0988a.this.eoC();
                        for (int i = 0; i < 300; i++) {
                            C0988a.this.oTf.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.oUA == null || a.this.oUG) || this.oTr;
                        zE(z);
                        if (z) {
                            this.oTr = false;
                        }
                        if (a.this.oUA != null && !a.this.oUG) {
                            a.this.oUA.eoY();
                            a.this.oUG = true;
                            return;
                        }
                        return;
                    case 4:
                        C0988a.this.eoE();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.oSZ.oVs;
                            a.this.oSZ.hD(longValue);
                            this.oTr = true;
                            long eoF = C0988a.this.eoF();
                            if (longValue > j || eoF - longValue > a.this.oTT.oXd.oXi) {
                                C0988a.this.eoC();
                            } else {
                                C0988a.this.eoE();
                            }
                            zE(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0988a.this.evictAll();
                        C0988a.this.eoD();
                        getLooper().quit();
                        return;
                    case 7:
                        C0988a.this.evictAll();
                        a.this.oSZ.hD(a.this.oUC.oVs - a.this.oTT.oXd.oXi);
                        this.oTr = true;
                        return;
                    case 8:
                        C0988a.this.zD(true);
                        a.this.oSZ.hD(a.this.oUC.oVs);
                        return;
                    case 9:
                        C0988a.this.zD(true);
                        a.this.oSZ.hD(a.this.oUC.oVs);
                        a.this.epd();
                        return;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    default:
                        return;
                    case 16:
                        break;
                    case 17:
                        master.flame.danmaku.danmaku.model.d dVar = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (dVar != null) {
                            n<?> epq = dVar.epq();
                            if (!((dVar.oVp & 1) != 0) && epq != null && epq.get() != null && !epq.epS()) {
                                dVar.oVi = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oUd, (master.flame.danmaku.danmaku.model.android.e) dVar.oVi);
                                C0988a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.kIy) {
                                C0988a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (epq != null && epq.epS()) {
                                    epq.destroy();
                                }
                                C0988a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.epr()) {
                            f(dVar2);
                            if (dVar2.oVi != null) {
                                C0988a.this.a(dVar2, dVar2.oVi.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.oTs = false;
                        return;
                }
                long eoM = eoM();
                if (eoM <= 0) {
                    eoM = a.this.oTT.oXd.oXi / 2;
                }
                sendEmptyMessageDelayed(16, eoM);
            }

            private long eoM() {
                if (a.this.oSZ.oVs <= a.this.oUC.oVs - a.this.oTT.oXd.oXi) {
                    C0988a.this.eoC();
                    a.this.oSZ.hD(a.this.oUC.oVs);
                    sendEmptyMessage(3);
                } else {
                    float eoB = C0988a.this.eoB();
                    master.flame.danmaku.danmaku.model.d epJ = C0988a.this.oTd.epJ();
                    long epB = epJ != null ? epJ.epB() - a.this.oUC.oVs : 0L;
                    long j = a.this.oTT.oXd.oXi * 2;
                    if (eoB < 0.6f && epB > a.this.oTT.oXd.oXi) {
                        a.this.oSZ.hD(a.this.oUC.oVs);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (eoB > 0.4f && epB < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (eoB < 0.9f) {
                        long j2 = a.this.oSZ.oVs - a.this.oUC.oVs;
                        if (epJ != null && epJ.epr() && j2 < (-a.this.oTT.oXd.oXi)) {
                            a.this.oSZ.hD(a.this.oUC.oVs);
                            sendEmptyMessage(8);
                            sendEmptyMessage(3);
                        } else if (j2 <= j) {
                            removeMessages(3);
                            sendEmptyMessage(3);
                        }
                    }
                }
                return 0L;
            }

            private void a(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.android.e eVar) {
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.oVi : eVar;
                dVar.oVi = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0988a.this.oTf.c(eVar2);
                }
            }

            private void eoN() {
                l lVar = null;
                try {
                    long j = a.this.oUC.oVs;
                    lVar = a.this.oUz.P(j - a.this.oTT.oXd.oXi, (a.this.oTT.oXd.oXi * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0989a.this.mPause || HandlerC0989a.this.oTs) {
                                return 1;
                            }
                            if (!dVar.epu()) {
                                a.this.oTT.oXc.a(dVar, 0, 0, null, true, a.this.oTT);
                            }
                            if (dVar.epv()) {
                                return 0;
                            }
                            if (!dVar.epp()) {
                                dVar.a((m) a.this.oUd, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.oUd, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.oTk.oTc.oSZ.hD(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long zE(final boolean z) {
                l lVar;
                eoN();
                final long j = a.this.oSZ.oVs;
                long j2 = j + (a.this.oTT.oXd.oXi * C0988a.this.oTh);
                if (j2 < a.this.oUC.oVs) {
                    return 0L;
                }
                final long eqy = master.flame.danmaku.danmaku.c.c.eqy();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.oUz.P(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.hF(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d epJ = lVar.epJ();
                final master.flame.danmaku.danmaku.model.d epK = lVar.epK();
                if (epJ == null || epK == null) {
                    a.this.oSZ.hD(j2);
                    return 0L;
                }
                long epB = epJ.epB() - a.this.oUC.oVs;
                final long min = Math.min(100L, epB < 0 ? 30L : ((epB * 10) / a.this.oTT.oXd.oXi) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int oTu = 0;
                    int oTv = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bT(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0989a.this.mPause || HandlerC0989a.this.oTs || epK.epB() < a.this.oUC.oVs) {
                            return 1;
                        }
                        n<?> epq = dVar2.epq();
                        if (epq == null || epq.get() == null) {
                            if (z || (!dVar2.epr() && dVar2.eps())) {
                                if (!dVar2.epu()) {
                                    a.this.oTT.oXc.a(dVar2, this.oTu, size, null, true, a.this.oTT);
                                }
                                if (dVar2.oVa == 0 && dVar2.epv()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int epB2 = (int) ((dVar2.epB() - j) / a.this.oTT.oXd.oXi);
                                    if (this.oTv == epB2) {
                                        this.oTu++;
                                    } else {
                                        this.oTu = 0;
                                        this.oTv = epB2;
                                    }
                                }
                                if (!z && !HandlerC0989a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.oTa) {
                                            a.this.oTa.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0989a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long eqy2 = master.flame.danmaku.danmaku.c.c.eqy() - eqy;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.oTT.oXd;
                                        if (eqy2 >= 10000 * C0988a.this.oTh) {
                                            return 1;
                                        }
                                    }
                                    return 0;
                                }
                                return 1;
                            }
                            return 0;
                        }
                        return 0;
                    }
                });
                long eqy2 = master.flame.danmaku.danmaku.c.c.eqy() - eqy;
                if (0 != 0) {
                    a.this.oSZ.hD(dVar.epB());
                    return eqy2;
                }
                a.this.oSZ.hD(j2);
                return eqy2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.epp()) {
                    dVar.a((m) a.this.oUd, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oUd, C0988a.this.oTf.eqq());
                        dVar.oVi = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0988a.this.oTf.c(eVar);
                        }
                        dVar.oVi = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0988a.this.oTf.c(eVar);
                        }
                        dVar.oVi = null;
                        return false;
                    }
                } catch (Exception e3) {
                    eVar = null;
                } catch (OutOfMemoryError e4) {
                    eVar = null;
                }
            }

            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00c8 */
            /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: master.flame.danmaku.a.a$a */
            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public byte a(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.epp()) {
                    dVar.a((m) a.this.oUd, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a2 = C0988a.this.a(dVar, true, 20);
                        r3 = a2 != null ? (master.flame.danmaku.danmaku.model.android.e) a2.oVi : null;
                        try {
                            if (r3 != null) {
                                r3.eql();
                                dVar.oVi = r3;
                                a.this.oSY.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0988a c0988a = C0988a.this;
                            master.flame.danmaku.danmaku.model.d a3 = c0988a.a(dVar, false, 50);
                            eVar = c0988a;
                            if (a3 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a3.oVi;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a3.oVi = null;
                                    dVar.oVi = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oUd, r3);
                                    a.this.oSY.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.eq((int) dVar.oVb, (int) dVar.oVc) + C0988a.this.oTg <= C0988a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a4 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oUd, C0988a.this.oTf.eqq());
                                    dVar.oVi = a4;
                                    boolean a5 = a.this.oSY.a(dVar, C0988a.this.d(dVar), z);
                                    if (!a5) {
                                        a(dVar, a4);
                                    }
                                    return a5 ? (byte) 0 : (byte) 1;
                                } else {
                                    return (byte) 1;
                                }
                            } catch (Exception e) {
                                r3 = eVar;
                                a(dVar, r3);
                                return (byte) 1;
                            } catch (OutOfMemoryError e2) {
                                a(dVar, eVar);
                                return (byte) 1;
                            }
                        } catch (OutOfMemoryError e3) {
                            eVar = r3;
                        }
                    } catch (OutOfMemoryError e4) {
                        eVar = null;
                    }
                } catch (Exception e5) {
                }
            }

            private final void g(master.flame.danmaku.danmaku.model.d dVar) {
                if (!dVar.epr()) {
                    if (dVar.epB() <= a.this.oSZ.oVs + a.this.oTT.oXd.oXi || dVar.kIy) {
                        if (dVar.oVa != 0 || !dVar.epv()) {
                            n<?> epq = dVar.epq();
                            if (epq == null || epq.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void eoA() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.oTT.oXd.oXi);
            }

            public void pause() {
                this.mPause = true;
                removeCallbacksAndMessages(null);
                sendEmptyMessage(6);
            }

            public void resume() {
                sendEmptyMessage(19);
                this.mPause = false;
                removeMessages(16);
                sendEmptyMessage(16);
                sendEmptyMessageDelayed(4, a.this.oTT.oXd.oXi);
            }

            public void hv(long j) {
                removeMessages(3);
                this.oTr = true;
                sendEmptyMessage(19);
                a.this.oSZ.hD(a.this.oUC.oVs + j);
                sendEmptyMessage(3);
            }

            public void zF(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long eoF() {
            master.flame.danmaku.danmaku.model.d epJ;
            if (this.oTd == null || this.oTd.size() <= 0 || (epJ = this.oTd.epJ()) == null) {
                return 0L;
            }
            return epJ.epB();
        }

        public void hu(long j) {
            if (this.oTi != null) {
                this.oTi.hv(j);
            }
        }

        public void eoG() {
            if (this.oTi != null) {
                this.oTi.removeMessages(3);
                this.oTi.removeMessages(19);
                this.oTi.eoL();
                this.oTi.removeMessages(7);
                this.oTi.sendEmptyMessage(7);
            }
        }

        public void eoH() {
            if (this.oTi != null) {
                this.oTi.removeMessages(9);
                this.oTi.sendEmptyMessage(9);
            }
        }

        public void eoI() {
            if (this.oTi != null) {
                this.oTi.removeMessages(4);
                this.oTi.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.oTi != null) {
                this.oTi.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.oUd.bd(this.oTT.oWB);
                epd();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.oSY != null)) {
                    this.oSY.hu(0L);
                }
                epd();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.oUd.bd(this.oTT.oWB);
                }
                if (this.oSY != null) {
                    this.oSY.eoG();
                    this.oSY.hu(-this.oTT.oXd.oXi);
                }
            } else if (this.oSY != null) {
                this.oSY.eoH();
                this.oSY.hu(0L);
            }
        }
        if (this.oUA != null && this.oSY != null) {
            this.oSY.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.oUA.epa();
                }
            });
            return true;
        }
        return true;
    }
}
