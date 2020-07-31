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
    private int nZJ;
    private C0915a nZK;
    private master.flame.danmaku.danmaku.model.f nZL;
    private final Object nZM;
    private int nZN;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.nZJ = 2;
        this.nZM = new Object();
        NativeBitmapFactory.eaM();
        this.nZJ = i;
        if (NativeBitmapFactory.eaL()) {
            this.nZJ = i * 2;
        }
        this.nZK = new C0915a(i, 3);
        this.obo.a(this.nZK);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.obp = fVar;
        this.nZL = new master.flame.danmaku.danmaku.model.f();
        this.nZL.gI(fVar.ocf);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nZK != null) {
            this.nZK.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void xT(boolean z) {
        super.xT(z);
        if (this.nZK != null) {
            this.nZK.dUK();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nZK != null) {
            int i = this.nZN + 1;
            this.nZN = i;
            if (i > 5) {
                this.nZK.dUM();
                this.nZN = 0;
                return;
            }
            return;
        }
        n<?> dVu = dVar.dVu();
        if (dVu != null) {
            if (dVu.dVV()) {
                dVu.dVW();
            } else {
                dVu.destroy();
            }
            dVar.obV = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nZM) {
            this.nZM.notify();
        }
        if (a != null && this.nZK != null && a.oeQ - a.oeR < -20) {
            this.nZK.dUM();
            this.nZK.gz(-this.oaF.odS.odX);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nZK == null) {
            start();
        }
        this.nZK.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.eaM();
        if (this.nZK == null) {
            this.nZK = new C0915a(this.nZJ, 3);
            this.nZK.dUE();
            this.obo.a(this.nZK);
            return;
        }
        this.nZK.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.obo.a((k) null);
        if (this.nZK != null) {
            this.nZK.end();
            this.nZK = null;
        }
        NativeBitmapFactory.eaN();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.oaL == null) {
            throw new AssertionError();
        }
        b(this.oaL);
        this.nZK.dUE();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Ly(int i) {
        super.Ly(i);
        if (this.nZK != null) {
            this.nZK.Ly(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.nZK != null) {
            this.nZK.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0915a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nZT;
        private HandlerC0916a nZU;
        master.flame.danmaku.danmaku.model.android.d nZP = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nZQ = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nZR = master.flame.danmaku.danmaku.model.a.e.a(this.nZQ, 800);
        private boolean nZV = false;
        private int nZS = 0;

        public C0915a(int i, int i2) {
            this.nZT = 3;
            this.mMaxSize = i;
            this.nZT = i2;
        }

        public void seek(long j) {
            if (this.nZU != null) {
                this.nZU.dUP();
                this.nZU.removeMessages(3);
                this.nZU.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nZU != null) {
                if (dVar.jVi) {
                    if (dVar.obW) {
                        if (!dVar.isTimeOut()) {
                            this.nZU.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nZU.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nZU.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void dUE() {
            this.nZV = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nZU == null) {
                this.nZU = new HandlerC0916a(this.mThread.getLooper());
            }
            this.nZU.dUE();
        }

        public void end() {
            this.nZV = true;
            synchronized (a.this.nZM) {
                a.this.nZM.notifyAll();
            }
            if (this.nZU != null) {
                this.nZU.pause();
                this.nZU = null;
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
            if (this.nZU != null) {
                this.nZU.resume();
            } else {
                dUE();
            }
        }

        public void Ly(int i) {
            if (this.nZU != null) {
                this.nZU.xW(i == 1);
            }
        }

        public float dUF() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nZS / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nZP != null) {
                this.nZP.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                        C0915a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nZP.clear();
            }
            this.nZS = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dUG() {
            xU(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xU(final boolean z) {
            if (this.nZP != null) {
                this.nZP.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.obV;
                        boolean z2 = nVar != null && nVar.dVV();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0915a.this.nZS -= nVar.size();
                                nVar.destroy();
                            }
                            C0915a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dVv()) {
                            C0915a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dVu = dVar.dVu();
            if (dVu != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.oaF.dWc().dVs().t(dVar);
                }
                if (c > 0) {
                    this.nZS = (int) (this.nZS - c);
                    this.nZR.c((master.flame.danmaku.danmaku.model.android.e) dVu);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.obV;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dVV()) {
                nVar.dVW();
                dVar.obV = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.obV = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.obV != null && !dVar.obV.dVV()) {
                    return dVar.obV.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dUH() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dWt = this.nZR.dWt();
                if (dWt != null) {
                    dWt.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dVM = this.nZP.dVM();
            while (true) {
                if (this.nZS + i <= this.mMaxSize || dVM == null) {
                    break;
                } else if (dVM.isTimeOut()) {
                    a(false, dVM, dVar);
                    this.nZP.l(dVM);
                    dVM = this.nZP.dVM();
                } else if (!z) {
                    return false;
                }
            }
            this.nZP.k(dVar);
            this.nZS += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dUI() {
            this.nZP.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nZM) {
                            try {
                                a.this.nZM.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0915a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.oaP.dVR() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nZY;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dUN */
                public master.flame.danmaku.danmaku.model.d dUO() {
                    return this.nZY;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> dVu = dVar2.dVu();
                    if (dVu == null || dVu.get() == null) {
                        return 0;
                    }
                    if (dVar2.obO == dVar.obO && dVar2.obP == dVar.obP && dVar2.underlineColor == dVar.underlineColor && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nZY = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dVu.dVV()) {
                                return 0;
                            }
                            float width = dVu.width() - dVar.obO;
                            float height = dVu.height() - dVar.obP;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nZY = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nZP.b(bVar);
            return bVar.dUO();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC0916a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean oad;
            private boolean oae;

            public HandlerC0916a(Looper looper) {
                super(looper);
            }

            public void dUP() {
                this.oae = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0915a.this.dUG();
                        for (int i = 0; i < 300; i++) {
                            C0915a.this.nZR.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.obn == null || a.this.obt) || this.oad;
                        xV(z);
                        if (z) {
                            this.oad = false;
                        }
                        if (a.this.obn != null && !a.this.obt) {
                            a.this.obn.dVc();
                            a.this.obt = true;
                            return;
                        }
                        return;
                    case 4:
                        C0915a.this.dUI();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nZL.ocf;
                            a.this.nZL.gI(longValue);
                            this.oad = true;
                            long dUJ = C0915a.this.dUJ();
                            if (longValue > j || dUJ - longValue > a.this.oaF.odS.odX) {
                                C0915a.this.dUG();
                            } else {
                                C0915a.this.dUI();
                            }
                            xV(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0915a.this.evictAll();
                        C0915a.this.dUH();
                        getLooper().quit();
                        return;
                    case 7:
                        C0915a.this.evictAll();
                        a.this.nZL.gI(a.this.obp.ocf - a.this.oaF.odS.odX);
                        this.oad = true;
                        return;
                    case 8:
                        C0915a.this.xU(true);
                        a.this.nZL.gI(a.this.obp.ocf);
                        return;
                    case 9:
                        C0915a.this.xU(true);
                        a.this.nZL.gI(a.this.obp.ocf);
                        a.this.dVh();
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
                            n<?> dVu = dVar.dVu();
                            if (!((dVar.occ & 1) != 0) && dVu != null && dVu.get() != null && !dVu.dVV()) {
                                dVar.obV = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oaP, (master.flame.danmaku.danmaku.model.android.e) dVar.obV);
                                C0915a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.jVi) {
                                C0915a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dVu != null && dVu.dVV()) {
                                    dVu.destroy();
                                }
                                C0915a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.obV != null) {
                                C0915a.this.a(dVar2, dVar2.obV.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.oae = false;
                        return;
                }
                long dUQ = dUQ();
                if (dUQ <= 0) {
                    dUQ = a.this.oaF.odS.odX / 2;
                }
                sendEmptyMessageDelayed(16, dUQ);
            }

            private long dUQ() {
                if (a.this.nZL.ocf <= a.this.obp.ocf - a.this.oaF.odS.odX) {
                    C0915a.this.dUG();
                    a.this.nZL.gI(a.this.obp.ocf);
                    sendEmptyMessage(3);
                } else {
                    float dUF = C0915a.this.dUF();
                    master.flame.danmaku.danmaku.model.d dVM = C0915a.this.nZP.dVM();
                    long dVE = dVM != null ? dVM.dVE() - a.this.obp.ocf : 0L;
                    long j = a.this.oaF.odS.odX * 2;
                    if (dUF < 0.6f && dVE > a.this.oaF.odS.odX) {
                        a.this.nZL.gI(a.this.obp.ocf);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dUF > 0.4f && dVE < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dUF < 0.9f) {
                        long j2 = a.this.nZL.ocf - a.this.obp.ocf;
                        if (dVM != null && dVM.isTimeOut() && j2 < (-a.this.oaF.odS.odX)) {
                            a.this.nZL.gI(a.this.obp.ocf);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.obV : eVar;
                dVar.obV = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0915a.this.nZR.c(eVar2);
                }
            }

            private void dUR() {
                l lVar = null;
                try {
                    long j = a.this.obp.ocf;
                    lVar = a.this.obm.S(j - a.this.oaF.odS.odX, (a.this.oaF.odS.odX * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0916a.this.mPause || HandlerC0916a.this.oae) {
                                return 1;
                            }
                            if (!dVar.dVx()) {
                                a.this.oaF.odR.a(dVar, 0, 0, null, true, a.this.oaF);
                            }
                            if (dVar.dVy()) {
                                return 0;
                            }
                            if (!dVar.dVt()) {
                                dVar.a((m) a.this.oaP, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.oaP, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nZW.nZO.nZL.gI(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long xV(final boolean z) {
                l lVar;
                dUR();
                final long j = a.this.nZL.ocf;
                long j2 = j + (a.this.oaF.odS.odX * C0915a.this.nZT);
                if (j2 < a.this.obp.ocf) {
                    return 0L;
                }
                final long dWB = master.flame.danmaku.danmaku.c.c.dWB();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.obm.S(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.gK(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d dVM = lVar.dVM();
                final master.flame.danmaku.danmaku.model.d dVN = lVar.dVN();
                if (dVM == null || dVN == null) {
                    a.this.nZL.gI(j2);
                    return 0L;
                }
                long dVE = dVM.dVE() - a.this.obp.ocf;
                final long min = Math.min(100L, dVE < 0 ? 30L : ((dVE * 10) / a.this.oaF.odS.odX) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int oag = 0;
                    int oah = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bM(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0916a.this.mPause || HandlerC0916a.this.oae || dVN.dVE() < a.this.obp.ocf) {
                            return 1;
                        }
                        n<?> dVu = dVar2.dVu();
                        if (dVu == null || dVu.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dVv())) {
                                if (!dVar2.dVx()) {
                                    a.this.oaF.odR.a(dVar2, this.oag, size, null, true, a.this.oaF);
                                }
                                if (dVar2.obN == 0 && dVar2.dVy()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dVE2 = (int) ((dVar2.dVE() - j) / a.this.oaF.odS.odX);
                                    if (this.oah == dVE2) {
                                        this.oag++;
                                    } else {
                                        this.oag = 0;
                                        this.oah = dVE2;
                                    }
                                }
                                if (!z && !HandlerC0916a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nZM) {
                                            a.this.nZM.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0916a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dWB2 = master.flame.danmaku.danmaku.c.c.dWB() - dWB;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.oaF.odS;
                                        if (dWB2 >= 10000 * C0915a.this.nZT) {
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
                long dWB2 = master.flame.danmaku.danmaku.c.c.dWB() - dWB;
                if (0 != 0) {
                    a.this.nZL.gI(dVar.dVE());
                    return dWB2;
                }
                a.this.nZL.gI(j2);
                return dWB2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dVt()) {
                    dVar.a((m) a.this.oaP, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oaP, C0915a.this.nZR.dWt());
                        dVar.obV = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0915a.this.nZR.c(eVar);
                        }
                        dVar.obV = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0915a.this.nZR.c(eVar);
                        }
                        dVar.obV = null;
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
                if (!dVar.dVt()) {
                    dVar.a((m) a.this.oaP, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0915a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.obV : null;
                        try {
                            if (r3 != null) {
                                r3.dWo();
                                dVar.obV = r3;
                                a.this.nZK.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0915a c0915a = C0915a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0915a.a(dVar, false, 50);
                            eVar = c0915a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.obV;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.obV = null;
                                    dVar.obV = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oaP, r3);
                                    a.this.nZK.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.ee((int) dVar.obO, (int) dVar.obP) + C0915a.this.nZS <= C0915a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oaP, C0915a.this.nZR.dWt());
                                    dVar.obV = a3;
                                    boolean a4 = a.this.nZK.a(dVar, C0915a.this.d(dVar), z);
                                    if (!a4) {
                                        a(dVar, a3);
                                    }
                                    return a4 ? (byte) 0 : (byte) 1;
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
                if (!dVar.isTimeOut()) {
                    if (dVar.dVE() <= a.this.nZL.ocf + a.this.oaF.odS.odX || dVar.jVi) {
                        if (dVar.obN != 0 || !dVar.dVy()) {
                            n<?> dVu = dVar.dVu();
                            if (dVu == null || dVu.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void dUE() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.oaF.odS.odX);
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
                sendEmptyMessageDelayed(4, a.this.oaF.odS.odX);
            }

            public void gA(long j) {
                removeMessages(3);
                this.oad = true;
                sendEmptyMessage(19);
                a.this.nZL.gI(a.this.obp.ocf + j);
                sendEmptyMessage(3);
            }

            public void xW(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dUJ() {
            master.flame.danmaku.danmaku.model.d dVM;
            if (this.nZP == null || this.nZP.size() <= 0 || (dVM = this.nZP.dVM()) == null) {
                return 0L;
            }
            return dVM.dVE();
        }

        public void gz(long j) {
            if (this.nZU != null) {
                this.nZU.gA(j);
            }
        }

        public void dUK() {
            if (this.nZU != null) {
                this.nZU.removeMessages(3);
                this.nZU.removeMessages(19);
                this.nZU.dUP();
                this.nZU.removeMessages(7);
                this.nZU.sendEmptyMessage(7);
            }
        }

        public void dUL() {
            if (this.nZU != null) {
                this.nZU.removeMessages(9);
                this.nZU.sendEmptyMessage(9);
            }
        }

        public void dUM() {
            if (this.nZU != null) {
                this.nZU.removeMessages(4);
                this.nZU.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nZU != null) {
                this.nZU.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.oaP.aR(this.oaF.odq);
                dVh();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nZK != null)) {
                    this.nZK.gz(0L);
                }
                dVh();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.oaP.aR(this.oaF.odq);
                }
                if (this.nZK != null) {
                    this.nZK.dUK();
                    this.nZK.gz(-this.oaF.odS.odX);
                }
            } else if (this.nZK != null) {
                this.nZK.dUL();
                this.nZK.gz(0L);
            }
        }
        if (this.obn != null && this.nZK != null) {
            this.nZK.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.obn.dVe();
                }
            });
            return true;
        }
        return true;
    }
}
