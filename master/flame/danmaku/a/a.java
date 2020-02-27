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
    private C0772a nDw;
    private master.flame.danmaku.danmaku.model.f nDx;
    private final Object nDy;
    private int nDz;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.mMaxCacheSize = 2;
        this.nDy = new Object();
        NativeBitmapFactory.dQW();
        this.mMaxCacheSize = i;
        if (NativeBitmapFactory.dQV()) {
            this.mMaxCacheSize = i * 2;
        }
        this.nDw = new C0772a(i, 3);
        this.nEZ.a(this.nDw);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.nFa = fVar;
        this.nDx = new master.flame.danmaku.danmaku.model.f();
        this.nDx.hn(fVar.nFR);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.nDw != null) {
            this.nDw.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wG(boolean z) {
        super.wG(z);
        if (this.nDw != null) {
            this.nDw.dKW();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.nDw != null) {
            int i = this.nDz + 1;
            this.nDz = i;
            if (i > 5) {
                this.nDw.dKY();
                this.nDz = 0;
                return;
            }
            return;
        }
        n<?> dLG = dVar.dLG();
        if (dLG != null) {
            if (dLG.dMh()) {
                dLG.dMi();
            } else {
                dLG.destroy();
            }
            dVar.nFH = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.nDy) {
            this.nDy.notify();
        }
        if (a != null && this.nDw != null && a.nIA - a.nIB < -20) {
            this.nDw.dKY();
            this.nDw.he(-this.nEr.nHB.nHG);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.nDw == null) {
            start();
        }
        this.nDw.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dQW();
        if (this.nDw == null) {
            this.nDw = new C0772a(this.mMaxCacheSize, 3);
            this.nDw.begin();
            this.nEZ.a(this.nDw);
            return;
        }
        this.nDw.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.nEZ.a((k) null);
        if (this.nDw != null) {
            this.nDw.end();
            this.nDw = null;
        }
        NativeBitmapFactory.dQX();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.nEx == null) {
            throw new AssertionError();
        }
        b(this.nEx);
        this.nDw.begin();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void NK(int i) {
        super.NK(i);
        if (this.nDw != null) {
            this.nDw.NK(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void m(long j, long j2, long j3) {
        super.m(j, j2, j3);
        if (this.nDw != null) {
            this.nDw.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0772a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int nDF;
        private HandlerC0773a nDG;
        master.flame.danmaku.danmaku.model.android.d nDB = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g nDC = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> nDD = master.flame.danmaku.danmaku.model.a.e.a(this.nDC, 800);
        private boolean nDH = false;
        private int nDE = 0;

        public C0772a(int i, int i2) {
            this.nDF = 3;
            this.mMaxSize = i;
            this.nDF = i2;
        }

        public void seek(long j) {
            if (this.nDG != null) {
                this.nDG.dLb();
                this.nDG.removeMessages(3);
                this.nDG.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.nDG != null) {
                if (dVar.mxI) {
                    if (dVar.nFI) {
                        if (!dVar.isTimeOut()) {
                            this.nDG.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.nDG.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.nDG.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void begin() {
            this.nDH = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.nDG == null) {
                this.nDG = new HandlerC0773a(this.mThread.getLooper());
            }
            this.nDG.begin();
        }

        public void end() {
            this.nDH = true;
            synchronized (a.this.nDy) {
                a.this.nDy.notifyAll();
            }
            if (this.nDG != null) {
                this.nDG.pause();
                this.nDG = null;
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
            if (this.nDG != null) {
                this.nDG.resume();
            } else {
                begin();
            }
        }

        public void NK(int i) {
            if (this.nDG != null) {
                this.nDG.wJ(i == 1);
            }
        }

        public float dKR() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.nDE / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.nDB != null) {
                this.nDB.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                        C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.nDB.clear();
            }
            this.nDE = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKS() {
            wH(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wH(final boolean z) {
            if (this.nDB != null) {
                this.nDB.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nFH;
                        boolean z2 = nVar != null && nVar.dMh();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0772a.this.nDE -= nVar.size();
                                nVar.destroy();
                            }
                            C0772a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dLH()) {
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
            n<?> dLG = dVar.dLG();
            if (dLG != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.nEr.dMo().dLE().t(dVar);
                }
                if (c > 0) {
                    this.nDE = (int) (this.nDE - c);
                    this.nDD.c((master.flame.danmaku.danmaku.model.android.e) dLG);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nFH;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dMh()) {
                nVar.dMi();
                dVar.nFH = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nFH = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nFH != null && !dVar.nFH.dMh()) {
                    return dVar.nFH.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKT() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dMF = this.nDD.dMF();
                if (dMF != null) {
                    dMF.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dLY = this.nDB.dLY();
            while (true) {
                if (this.nDE + i <= this.mMaxSize || dLY == null) {
                    break;
                } else if (dLY.isTimeOut()) {
                    a(false, dLY, dVar);
                    this.nDB.l(dLY);
                    dLY = this.nDB.dLY();
                } else if (!z) {
                    return false;
                }
            }
            this.nDB.k(dVar);
            this.nDE += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dKU() {
            this.nDB.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.nDy) {
                            try {
                                a.this.nDy.wait(30L);
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
                i2 = a.this.nEB.dMd() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d nDK;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dKZ */
                public master.flame.danmaku.danmaku.model.d dLa() {
                    return this.nDK;
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
                    n<?> dLG = dVar2.dLG();
                    if (dLG == null || dLG.get() == null) {
                        return 0;
                    }
                    if (dVar2.nFA == dVar.nFA && dVar2.nFB == dVar.nFB && dVar2.nFy == dVar.nFy && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.nDK = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dLG.dMh()) {
                                return 0;
                            }
                            float width = dLG.width() - dVar.nFA;
                            float height = dLG.height() - dVar.nFB;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.nDK = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.nDB.b(bVar);
            return bVar.dLa();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0773a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean nDP;
            private boolean nDQ;

            public HandlerC0773a(Looper looper) {
                super(looper);
            }

            public void dLb() {
                this.nDQ = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0772a.this.dKS();
                        for (int i = 0; i < 300; i++) {
                            C0772a.this.nDD.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nEY == null || a.this.nFe) || this.nDP;
                        wI(z);
                        if (z) {
                            this.nDP = false;
                        }
                        if (a.this.nEY != null && !a.this.nFe) {
                            a.this.nEY.dLo();
                            a.this.nFe = true;
                            return;
                        }
                        return;
                    case 4:
                        C0772a.this.dKU();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.nDx.nFR;
                            a.this.nDx.hn(longValue);
                            this.nDP = true;
                            long dKV = C0772a.this.dKV();
                            if (longValue > j || dKV - longValue > a.this.nEr.nHB.nHG) {
                                C0772a.this.dKS();
                            } else {
                                C0772a.this.dKU();
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
                        C0772a.this.dKT();
                        getLooper().quit();
                        return;
                    case 7:
                        C0772a.this.evictAll();
                        a.this.nDx.hn(a.this.nFa.nFR - a.this.nEr.nHB.nHG);
                        this.nDP = true;
                        return;
                    case 8:
                        C0772a.this.wH(true);
                        a.this.nDx.hn(a.this.nFa.nFR);
                        return;
                    case 9:
                        C0772a.this.wH(true);
                        a.this.nDx.hn(a.this.nFa.nFR);
                        a.this.dLt();
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
                            n<?> dLG = dVar.dLG();
                            if (!((dVar.nFO & 1) != 0) && dLG != null && dLG.get() != null && !dLG.dMh()) {
                                dVar.nFH = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nEB, (master.flame.danmaku.danmaku.model.android.e) dVar.nFH);
                                C0772a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.mxI) {
                                C0772a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dLG != null && dLG.dMh()) {
                                    dLG.destroy();
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
                            if (dVar2.nFH != null) {
                                C0772a.this.a(dVar2, dVar2.nFH.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.nDQ = false;
                        return;
                }
                long dLc = dLc();
                if (dLc <= 0) {
                    dLc = a.this.nEr.nHB.nHG / 2;
                }
                sendEmptyMessageDelayed(16, dLc);
            }

            private long dLc() {
                if (a.this.nDx.nFR <= a.this.nFa.nFR - a.this.nEr.nHB.nHG) {
                    C0772a.this.dKS();
                    a.this.nDx.hn(a.this.nFa.nFR);
                    sendEmptyMessage(3);
                } else {
                    float dKR = C0772a.this.dKR();
                    master.flame.danmaku.danmaku.model.d dLY = C0772a.this.nDB.dLY();
                    long dLQ = dLY != null ? dLY.dLQ() - a.this.nFa.nFR : 0L;
                    long j = a.this.nEr.nHB.nHG * 2;
                    if (dKR < 0.6f && dLQ > a.this.nEr.nHB.nHG) {
                        a.this.nDx.hn(a.this.nFa.nFR);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dKR > 0.4f && dLQ < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dKR < 0.9f) {
                        long j2 = a.this.nDx.nFR - a.this.nFa.nFR;
                        if (dLY != null && dLY.isTimeOut() && j2 < (-a.this.nEr.nHB.nHG)) {
                            a.this.nDx.hn(a.this.nFa.nFR);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nFH : eVar;
                dVar.nFH = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0772a.this.nDD.c(eVar2);
                }
            }

            private void dLd() {
                l lVar = null;
                try {
                    long j = a.this.nFa.nFR;
                    lVar = a.this.nEX.ag(j - a.this.nEr.nHB.nHG, (a.this.nEr.nHB.nHG * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0773a.this.mPause || HandlerC0773a.this.nDQ) {
                                return 1;
                            }
                            if (!dVar.dLJ()) {
                                a.this.nEr.nHA.a(dVar, 0, 0, null, true, a.this.nEr);
                            }
                            if (dVar.dLK()) {
                                return 0;
                            }
                            if (!dVar.dLF()) {
                                dVar.a((m) a.this.nEB, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nEB, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.nDI.nDA.nDx.hn(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wI(final boolean z) {
                l lVar;
                dLd();
                final long j = a.this.nDx.nFR;
                long j2 = j + (a.this.nEr.nHB.nHG * C0772a.this.nDF);
                if (j2 < a.this.nFa.nFR) {
                    return 0L;
                }
                final long dMN = master.flame.danmaku.danmaku.c.c.dMN();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nEX.ag(j, j2);
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
                master.flame.danmaku.danmaku.model.d dLY = lVar.dLY();
                final master.flame.danmaku.danmaku.model.d dLZ = lVar.dLZ();
                if (dLY == null || dLZ == null) {
                    a.this.nDx.hn(j2);
                    return 0L;
                }
                long dLQ = dLY.dLQ() - a.this.nFa.nFR;
                final long min = Math.min(100L, dLQ < 0 ? 30L : ((dLQ * 10) / a.this.nEr.nHB.nHG) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int nDS = 0;
                    int nDT = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bV(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0773a.this.mPause || HandlerC0773a.this.nDQ || dLZ.dLQ() < a.this.nFa.nFR) {
                            return 1;
                        }
                        n<?> dLG = dVar2.dLG();
                        if (dLG == null || dLG.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dLH())) {
                                if (!dVar2.dLJ()) {
                                    a.this.nEr.nHA.a(dVar2, this.nDS, size, null, true, a.this.nEr);
                                }
                                if (dVar2.nFz == 0 && dVar2.dLK()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dLQ2 = (int) ((dVar2.dLQ() - j) / a.this.nEr.nHB.nHG);
                                    if (this.nDT == dLQ2) {
                                        this.nDS++;
                                    } else {
                                        this.nDS = 0;
                                        this.nDT = dLQ2;
                                    }
                                }
                                if (!z && !HandlerC0773a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.nDy) {
                                            a.this.nDy.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0773a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dMN2 = master.flame.danmaku.danmaku.c.c.dMN() - dMN;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.nEr.nHB;
                                        if (dMN2 >= 10000 * C0772a.this.nDF) {
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
                long dMN2 = master.flame.danmaku.danmaku.c.c.dMN() - dMN;
                if (0 != 0) {
                    a.this.nDx.hn(dVar.dLQ());
                    return dMN2;
                }
                a.this.nDx.hn(j2);
                return dMN2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dLF()) {
                    dVar.a((m) a.this.nEB, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nEB, C0772a.this.nDD.dMF());
                        dVar.nFH = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0772a.this.nDD.c(eVar);
                        }
                        dVar.nFH = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0772a.this.nDD.c(eVar);
                        }
                        dVar.nFH = null;
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
                if (!dVar.dLF()) {
                    dVar.a((m) a.this.nEB, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0772a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nFH : null;
                        try {
                            if (r3 != null) {
                                r3.dMA();
                                dVar.nFH = r3;
                                a.this.nDw.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0772a c0772a = C0772a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0772a.a(dVar, false, 50);
                            eVar = c0772a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nFH;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nFH = null;
                                    dVar.nFH = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nEB, r3);
                                    a.this.nDw.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.eC((int) dVar.nFA, (int) dVar.nFB) + C0772a.this.nDE <= C0772a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nEB, C0772a.this.nDD.dMF());
                                    dVar.nFH = a3;
                                    boolean a4 = a.this.nDw.a(dVar, C0772a.this.d(dVar), z);
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
                    if (dVar.dLQ() <= a.this.nDx.nFR + a.this.nEr.nHB.nHG || dVar.mxI) {
                        if (dVar.nFz != 0 || !dVar.dLK()) {
                            n<?> dLG = dVar.dLG();
                            if (dLG == null || dLG.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void begin() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.nEr.nHB.nHG);
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
                sendEmptyMessageDelayed(4, a.this.nEr.nHB.nHG);
            }

            public void hf(long j) {
                removeMessages(3);
                this.nDP = true;
                sendEmptyMessage(19);
                a.this.nDx.hn(a.this.nFa.nFR + j);
                sendEmptyMessage(3);
            }

            public void wJ(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dKV() {
            master.flame.danmaku.danmaku.model.d dLY;
            if (this.nDB == null || this.nDB.size() <= 0 || (dLY = this.nDB.dLY()) == null) {
                return 0L;
            }
            return dLY.dLQ();
        }

        public void he(long j) {
            if (this.nDG != null) {
                this.nDG.hf(j);
            }
        }

        public void dKW() {
            if (this.nDG != null) {
                this.nDG.removeMessages(3);
                this.nDG.removeMessages(19);
                this.nDG.dLb();
                this.nDG.removeMessages(7);
                this.nDG.sendEmptyMessage(7);
            }
        }

        public void dKX() {
            if (this.nDG != null) {
                this.nDG.removeMessages(9);
                this.nDG.sendEmptyMessage(9);
            }
        }

        public void dKY() {
            if (this.nDG != null) {
                this.nDG.removeMessages(4);
                this.nDG.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.nDG != null) {
                this.nDG.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nEB.bG(this.nEr.nGZ);
                dLt();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.nDw != null)) {
                    this.nDw.he(0L);
                }
                dLt();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nEB.bG(this.nEr.nGZ);
                }
                if (this.nDw != null) {
                    this.nDw.dKW();
                    this.nDw.he(-this.nEr.nHB.nHG);
                }
            } else if (this.nDw != null) {
                this.nDw.dKX();
                this.nDw.he(0L);
            }
        }
        if (this.nEY != null && this.nDw != null) {
            this.nDw.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nEY.dLq();
                }
            });
            return true;
        }
        return true;
    }
}
