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
/* loaded from: classes5.dex */
public class a extends e {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int mMaxCacheSize;
    private C0772a nDJ;
    private master.flame.danmaku.danmaku.model.f nDK;
    private final Object nDL;
    private int nDM;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.mMaxCacheSize = 2;
        this.nDL = new Object();
        NativeBitmapFactory.dQZ();
        this.mMaxCacheSize = i;
        if (NativeBitmapFactory.dQY()) {
            this.mMaxCacheSize = i * 2;
        }
        this.nDJ = new C0772a(i, 3);
        this.nFm.a(this.nDJ);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nFn = fVar;
        this.nDK = new master.flame.danmaku.danmaku.model.f();
        this.nDK.hn(fVar.nGe);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nDJ != null) {
            this.nDJ.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wG(boolean z) {
        super.wG(z);
        if (this.nDJ != null) {
            this.nDJ.dKZ();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nDJ != null) {
            int i = this.nDM + 1;
            this.nDM = i;
            if (i > 5) {
                this.nDJ.dLb();
                this.nDM = 0;
                return;
            }
            return;
        }
        n<?> dLJ = dVar.dLJ();
        if (dLJ != null) {
            if (dLJ.dMk()) {
                dLJ.dMl();
            } else {
                dLJ.destroy();
            }
            dVar.nFU = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nDL) {
            this.nDL.notify();
        }
        if (a != null && this.nDJ != null && a.nIN - a.nIO < -20) {
            this.nDJ.dLb();
            this.nDJ.he(-this.nEE.nHO.nHT);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nDJ == null) {
            start();
        }
        this.nDJ.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dQZ();
        if (this.nDJ == null) {
            this.nDJ = new C0772a(this.mMaxCacheSize, 3);
            this.nDJ.begin();
            this.nFm.a(this.nDJ);
            return;
        }
        this.nDJ.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nFm.a((k) null);
        if (this.nDJ != null) {
            this.nDJ.end();
            this.nDJ = null;
        }
        NativeBitmapFactory.dRa();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nEK == null) {
            throw new AssertionError();
        }
        b(this.nEK);
        this.nDJ.begin();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void NK(int i) {
        super.NK(i);
        if (this.nDJ != null) {
            this.nDJ.NK(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void m(long j, long j2, long j3) {
        super.m(j, j2, j3);
        if (this.nDJ != null) {
            this.nDJ.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0772a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nDS;
        private HandlerC0773a nDT;
        master.flame.danmaku.danmaku.model.android.d nDO = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nDP = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nDQ = master.flame.danmaku.danmaku.model.a.e.a(this.nDP, 800);
        private boolean nDU = false;
        private int nDR = 0;

        public C0772a(int i, int i2) {
            this.nDS = 3;
            this.mMaxSize = i;
            this.nDS = i2;
        }

        public void seek(long j) {
            if (this.nDT != null) {
                this.nDT.dLe();
                this.nDT.removeMessages(3);
                this.nDT.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nDT != null) {
                if (dVar.mxV) {
                    if (dVar.nFV) {
                        if (!dVar.isTimeOut()) {
                            this.nDT.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nDT.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nDT.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void begin() {
            this.nDU = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nDT == null) {
                this.nDT = new HandlerC0773a(this.mThread.getLooper());
            }
            this.nDT.begin();
        }

        public void end() {
            this.nDU = true;
            synchronized (a.this.nDL) {
                a.this.nDL.notifyAll();
            }
            if (this.nDT != null) {
                this.nDT.pause();
                this.nDT = null;
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
            if (this.nDT != null) {
                this.nDT.resume();
            } else {
                begin();
            }
        }

        public void NK(int i) {
            if (this.nDT != null) {
                this.nDT.wJ(i == 1);
            }
        }

        public float dKU() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nDR / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nDO != null) {
                this.nDO.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                        C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nDO.clear();
            }
            this.nDR = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKV() {
            wH(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wH(final boolean z) {
            if (this.nDO != null) {
                this.nDO.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nFU;
                        boolean z2 = nVar != null && nVar.dMk();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0772a.this.nDR -= nVar.size();
                                nVar.destroy();
                            }
                            C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dLK()) {
                            C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dLJ = dVar.dLJ();
            if (dLJ != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nEE.dMr().dLH().t(dVar);
                }
                if (c > 0) {
                    this.nDR = (int) (this.nDR - c);
                    this.nDQ.c((master.flame.danmaku.danmaku.model.android.e) dLJ);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nFU;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dMk()) {
                nVar.dMl();
                dVar.nFU = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nFU = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nFU != null && !dVar.nFU.dMk()) {
                    return dVar.nFU.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKW() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dMI = this.nDQ.dMI();
                if (dMI != null) {
                    dMI.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dMb = this.nDO.dMb();
            while (true) {
                if (this.nDR + i <= this.mMaxSize || dMb == null) {
                    break;
                } else if (dMb.isTimeOut()) {
                    a(false, dMb, dVar);
                    this.nDO.l(dMb);
                    dMb = this.nDO.dMb();
                } else if (!z) {
                    return false;
                }
            }
            this.nDO.k(dVar);
            this.nDR += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKX() {
            this.nDO.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nDL) {
                            try {
                                a.this.nDL.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0772a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nEO.dMg() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nDX;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dLc */
                public master.flame.danmaku.danmaku.model.d dLd() {
                    return this.nDX;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> dLJ = dVar2.dLJ();
                    if (dLJ == null || dLJ.get() == null) {
                        return 0;
                    }
                    if (dVar2.nFN == dVar.nFN && dVar2.nFO == dVar.nFO && dVar2.nFL == dVar.nFL && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nDX = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dLJ.dMk()) {
                                return 0;
                            }
                            float width = dLJ.width() - dVar.nFN;
                            float height = dLJ.height() - dVar.nFO;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nDX = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nDO.b(bVar);
            return bVar.dLd();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0773a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nEc;
            private boolean nEd;

            public HandlerC0773a(Looper looper) {
                super(looper);
            }

            public void dLe() {
                this.nEd = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0772a.this.dKV();
                        for (int i = 0; i < 300; i++) {
                            C0772a.this.nDQ.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nFl == null || a.this.nFr) || this.nEc;
                        wI(z);
                        if (z) {
                            this.nEc = false;
                        }
                        if (a.this.nFl != null && !a.this.nFr) {
                            a.this.nFl.dLr();
                            a.this.nFr = true;
                            return;
                        }
                        return;
                    case 4:
                        C0772a.this.dKX();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nDK.nGe;
                            a.this.nDK.hn(longValue);
                            this.nEc = true;
                            long dKY = C0772a.this.dKY();
                            if (longValue > j || dKY - longValue > a.this.nEE.nHO.nHT) {
                                C0772a.this.dKV();
                            } else {
                                C0772a.this.dKX();
                            }
                            wI(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0772a.this.evictAll();
                        C0772a.this.dKW();
                        getLooper().quit();
                        return;
                    case 7:
                        C0772a.this.evictAll();
                        a.this.nDK.hn(a.this.nFn.nGe - a.this.nEE.nHO.nHT);
                        this.nEc = true;
                        return;
                    case 8:
                        C0772a.this.wH(true);
                        a.this.nDK.hn(a.this.nFn.nGe);
                        return;
                    case 9:
                        C0772a.this.wH(true);
                        a.this.nDK.hn(a.this.nFn.nGe);
                        a.this.dLw();
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
                            n<?> dLJ = dVar.dLJ();
                            if (!((dVar.nGb & 1) != 0) && dLJ != null && dLJ.get() != null && !dLJ.dMk()) {
                                dVar.nFU = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nEO, (master.flame.danmaku.danmaku.model.android.e) dVar.nFU);
                                C0772a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.mxV) {
                                C0772a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dLJ != null && dLJ.dMk()) {
                                    dLJ.destroy();
                                }
                                C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nFU != null) {
                                C0772a.this.a(dVar2, dVar2.nFU.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nEd = false;
                        return;
                }
                long dLf = dLf();
                if (dLf <= 0) {
                    dLf = a.this.nEE.nHO.nHT / 2;
                }
                sendEmptyMessageDelayed(16, dLf);
            }

            private long dLf() {
                if (a.this.nDK.nGe <= a.this.nFn.nGe - a.this.nEE.nHO.nHT) {
                    C0772a.this.dKV();
                    a.this.nDK.hn(a.this.nFn.nGe);
                    sendEmptyMessage(3);
                } else {
                    float dKU = C0772a.this.dKU();
                    master.flame.danmaku.danmaku.model.d dMb = C0772a.this.nDO.dMb();
                    long dLT = dMb != null ? dMb.dLT() - a.this.nFn.nGe : 0L;
                    long j = a.this.nEE.nHO.nHT * 2;
                    if (dKU < 0.6f && dLT > a.this.nEE.nHO.nHT) {
                        a.this.nDK.hn(a.this.nFn.nGe);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dKU > 0.4f && dLT < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dKU < 0.9f) {
                        long j2 = a.this.nDK.nGe - a.this.nFn.nGe;
                        if (dMb != null && dMb.isTimeOut() && j2 < (-a.this.nEE.nHO.nHT)) {
                            a.this.nDK.hn(a.this.nFn.nGe);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nFU : eVar;
                dVar.nFU = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0772a.this.nDQ.c(eVar2);
                }
            }

            private void dLg() {
                l lVar = null;
                try {
                    long j = a.this.nFn.nGe;
                    lVar = a.this.nFk.ag(j - a.this.nEE.nHO.nHT, (a.this.nEE.nHO.nHT * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0773a.this.mPause || HandlerC0773a.this.nEd) {
                                return 1;
                            }
                            if (!dVar.dLM()) {
                                a.this.nEE.nHN.a(dVar, 0, 0, null, true, a.this.nEE);
                            }
                            if (dVar.dLN()) {
                                return 0;
                            }
                            if (!dVar.dLI()) {
                                dVar.a((m) a.this.nEO, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nEO, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nDV.nDN.nDK.hn(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wI(final boolean z) {
                l lVar;
                dLg();
                final long j = a.this.nDK.nGe;
                long j2 = j + (a.this.nEE.nHO.nHT * C0772a.this.nDS);
                if (j2 < a.this.nFn.nGe) {
                    return 0L;
                }
                final long dMQ = master.flame.danmaku.danmaku.c.c.dMQ();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nFk.ag(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.hp(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d dMb = lVar.dMb();
                final master.flame.danmaku.danmaku.model.d dMc = lVar.dMc();
                if (dMb == null || dMc == null) {
                    a.this.nDK.hn(j2);
                    return 0L;
                }
                long dLT = dMb.dLT() - a.this.nFn.nGe;
                final long min = Math.min(100L, dLT < 0 ? 30L : ((dLT * 10) / a.this.nEE.nHO.nHT) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nEf = 0;
                    int nEg = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0773a.this.mPause || HandlerC0773a.this.nEd || dMc.dLT() < a.this.nFn.nGe) {
                            return 1;
                        }
                        n<?> dLJ = dVar2.dLJ();
                        if (dLJ == null || dLJ.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dLK())) {
                                if (!dVar2.dLM()) {
                                    a.this.nEE.nHN.a(dVar2, this.nEf, size, null, true, a.this.nEE);
                                }
                                if (dVar2.nFM == 0 && dVar2.dLN()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dLT2 = (int) ((dVar2.dLT() - j) / a.this.nEE.nHO.nHT);
                                    if (this.nEg == dLT2) {
                                        this.nEf++;
                                    } else {
                                        this.nEf = 0;
                                        this.nEg = dLT2;
                                    }
                                }
                                if (!z && !HandlerC0773a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nDL) {
                                            a.this.nDL.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0773a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dMQ2 = master.flame.danmaku.danmaku.c.c.dMQ() - dMQ;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nEE.nHO;
                                        if (dMQ2 >= 10000 * C0772a.this.nDS) {
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
                long dMQ2 = master.flame.danmaku.danmaku.c.c.dMQ() - dMQ;
                if (0 != 0) {
                    a.this.nDK.hn(dVar.dLT());
                    return dMQ2;
                }
                a.this.nDK.hn(j2);
                return dMQ2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dLI()) {
                    dVar.a((m) a.this.nEO, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nEO, C0772a.this.nDQ.dMI());
                        dVar.nFU = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0772a.this.nDQ.c(eVar);
                        }
                        dVar.nFU = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0772a.this.nDQ.c(eVar);
                        }
                        dVar.nFU = null;
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
                if (!dVar.dLI()) {
                    dVar.a((m) a.this.nEO, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0772a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nFU : null;
                        try {
                            if (r3 != null) {
                                r3.dMD();
                                dVar.nFU = r3;
                                a.this.nDJ.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0772a c0772a = C0772a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0772a.a(dVar, false, 50);
                            eVar = c0772a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nFU;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nFU = null;
                                    dVar.nFU = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nEO, r3);
                                    a.this.nDJ.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.eC((int) dVar.nFN, (int) dVar.nFO) + C0772a.this.nDR <= C0772a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nEO, C0772a.this.nDQ.dMI());
                                    dVar.nFU = a3;
                                    boolean a4 = a.this.nDJ.a(dVar, C0772a.this.d(dVar), z);
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
                    if (dVar.dLT() <= a.this.nDK.nGe + a.this.nEE.nHO.nHT || dVar.mxV) {
                        if (dVar.nFM != 0 || !dVar.dLN()) {
                            n<?> dLJ = dVar.dLJ();
                            if (dLJ == null || dLJ.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void begin() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nEE.nHO.nHT);
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
                sendEmptyMessageDelayed(4, a.this.nEE.nHO.nHT);
            }

            public void hf(long j) {
                removeMessages(3);
                this.nEc = true;
                sendEmptyMessage(19);
                a.this.nDK.hn(a.this.nFn.nGe + j);
                sendEmptyMessage(3);
            }

            public void wJ(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dKY() {
            master.flame.danmaku.danmaku.model.d dMb;
            if (this.nDO == null || this.nDO.size() <= 0 || (dMb = this.nDO.dMb()) == null) {
                return 0L;
            }
            return dMb.dLT();
        }

        public void he(long j) {
            if (this.nDT != null) {
                this.nDT.hf(j);
            }
        }

        public void dKZ() {
            if (this.nDT != null) {
                this.nDT.removeMessages(3);
                this.nDT.removeMessages(19);
                this.nDT.dLe();
                this.nDT.removeMessages(7);
                this.nDT.sendEmptyMessage(7);
            }
        }

        public void dLa() {
            if (this.nDT != null) {
                this.nDT.removeMessages(9);
                this.nDT.sendEmptyMessage(9);
            }
        }

        public void dLb() {
            if (this.nDT != null) {
                this.nDT.removeMessages(4);
                this.nDT.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nDT != null) {
                this.nDT.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nEO.bG(this.nEE.nHm);
                dLw();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nDJ != null)) {
                    this.nDJ.he(0L);
                }
                dLw();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nEO.bG(this.nEE.nHm);
                }
                if (this.nDJ != null) {
                    this.nDJ.dKZ();
                    this.nDJ.he(-this.nEE.nHO.nHT);
                }
            } else if (this.nDJ != null) {
                this.nDJ.dLa();
                this.nDJ.he(0L);
            }
        }
        if (this.nFl != null && this.nDJ != null) {
            this.nDJ.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nFl.dLt();
                }
            });
            return true;
        }
        return true;
    }
}
