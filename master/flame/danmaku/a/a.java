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
    private int oDI;
    private C0970a oDJ;
    private master.flame.danmaku.danmaku.model.f oDK;
    private final Object oDL;
    private int oDM;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.oDI = 2;
        this.oDL = new Object();
        NativeBitmapFactory.eqV();
        this.oDI = i;
        if (NativeBitmapFactory.eqU()) {
            this.oDI = i * 2;
        }
        this.oDJ = new C0970a(i, 3);
        this.oFm.a(this.oDJ);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.oFn = fVar;
        this.oDK = new master.flame.danmaku.danmaku.model.f();
        this.oDK.hl(fVar.oGd);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.oDJ != null) {
            this.oDJ.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void yV(boolean z) {
        super.yV(z);
        if (this.oDJ != null) {
            this.oDJ.ekT();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.oDJ != null) {
            int i = this.oDM + 1;
            this.oDM = i;
            if (i > 5) {
                this.oDJ.ekV();
                this.oDM = 0;
                return;
            }
            return;
        }
        n<?> elD = dVar.elD();
        if (elD != null) {
            if (elD.emf()) {
                elD.emg();
            } else {
                elD.destroy();
            }
            dVar.oFT = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.oDL) {
            this.oDL.notify();
        }
        if (a != null && this.oDJ != null && a.oIM - a.oIN < -20) {
            this.oDJ.ekV();
            this.oDJ.hc(-this.oEE.oHO.oHT);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.oDJ == null) {
            start();
        }
        this.oDJ.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.eqV();
        if (this.oDJ == null) {
            this.oDJ = new C0970a(this.oDI, 3);
            this.oDJ.ekN();
            this.oFm.a(this.oDJ);
            return;
        }
        this.oDJ.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.oFm.a((k) null);
        if (this.oDJ != null) {
            this.oDJ.end();
            this.oDJ = null;
        }
        NativeBitmapFactory.eqW();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.oEK == null) {
            throw new AssertionError();
        }
        b(this.oEK);
        this.oDJ.ekN();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void OG(int i) {
        super.OG(i);
        if (this.oDJ != null) {
            this.oDJ.OG(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.oDJ != null) {
            this.oDJ.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0970a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int oDS;
        private HandlerC0971a oDT;
        master.flame.danmaku.danmaku.model.android.d oDO = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g oDP = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> oDQ = master.flame.danmaku.danmaku.model.a.e.a(this.oDP, 800);
        private boolean oDU = false;
        private int oDR = 0;

        public C0970a(int i, int i2) {
            this.oDS = 3;
            this.mMaxSize = i;
            this.oDS = i2;
        }

        public void seek(long j) {
            if (this.oDT != null) {
                this.oDT.ekY();
                this.oDT.removeMessages(3);
                this.oDT.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.oDT != null) {
                if (dVar.ktm) {
                    if (dVar.oFU) {
                        if (!dVar.elE()) {
                            this.oDT.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.oDT.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.oDT.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void ekN() {
            this.oDU = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.oDT == null) {
                this.oDT = new HandlerC0971a(this.mThread.getLooper());
            }
            this.oDT.ekN();
        }

        public void end() {
            this.oDU = true;
            synchronized (a.this.oDL) {
                a.this.oDL.notifyAll();
            }
            if (this.oDT != null) {
                this.oDT.pause();
                this.oDT = null;
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
            if (this.oDT != null) {
                this.oDT.resume();
            } else {
                ekN();
            }
        }

        public void OG(int i) {
            if (this.oDT != null) {
                this.oDT.yY(i == 1);
            }
        }

        public float ekO() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.oDR / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.oDO != null) {
                this.oDO.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                        C0970a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.oDO.clear();
            }
            this.oDR = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ekP() {
            yW(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void yW(final boolean z) {
            if (this.oDO != null) {
                this.oDO.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.oFT;
                        boolean z2 = nVar != null && nVar.emf();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0970a.this.oDR -= nVar.size();
                                nVar.destroy();
                            }
                            C0970a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.elF()) {
                            C0970a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> elD = dVar.elD();
            if (elD != null) {
                long c = c(dVar);
                if (dVar.elE()) {
                    a.this.oEE.emm().elB().t(dVar);
                }
                if (c > 0) {
                    this.oDR = (int) (this.oDR - c);
                    this.oDQ.c((master.flame.danmaku.danmaku.model.android.e) elD);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.oFT;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.emf()) {
                nVar.emg();
                dVar.oFT = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.oFT = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.oFT != null && !dVar.oFT.emf()) {
                    return dVar.oFT.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ekQ() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e emD = this.oDQ.emD();
                if (emD != null) {
                    emD.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d elW = this.oDO.elW();
            while (true) {
                if (this.oDR + i <= this.mMaxSize || elW == null) {
                    break;
                } else if (elW.elE()) {
                    a(false, elW, dVar);
                    this.oDO.l(elW);
                    elW = this.oDO.elW();
                } else if (!z) {
                    return false;
                }
            }
            this.oDO.k(dVar);
            this.oDR += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ekR() {
            this.oDO.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.elE()) {
                        synchronized (a.this.oDL) {
                            try {
                                a.this.oDL.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0970a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.oEO.emb() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d oDX;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: ekW */
                public master.flame.danmaku.danmaku.model.d ekX() {
                    return this.oDX;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bQ(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> elD = dVar2.elD();
                    if (elD == null || elD.get() == null) {
                        return 0;
                    }
                    if (dVar2.oFM == dVar.oFM && dVar2.oFN == dVar.oFN && dVar2.underlineColor == dVar.underlineColor && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.oDX = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.elE()) {
                            if (elD.emf()) {
                                return 0;
                            }
                            float width = elD.width() - dVar.oFM;
                            float height = elD.height() - dVar.oFN;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.oDX = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.oDO.b(bVar);
            return bVar.ekX();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC0971a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean oEc;
            private boolean oEd;

            public HandlerC0971a(Looper looper) {
                super(looper);
            }

            public void ekY() {
                this.oEd = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0970a.this.ekP();
                        for (int i = 0; i < 300; i++) {
                            C0970a.this.oDQ.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.oFl == null || a.this.oFr) || this.oEc;
                        yX(z);
                        if (z) {
                            this.oEc = false;
                        }
                        if (a.this.oFl != null && !a.this.oFr) {
                            a.this.oFl.ell();
                            a.this.oFr = true;
                            return;
                        }
                        return;
                    case 4:
                        C0970a.this.ekR();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.oDK.oGd;
                            a.this.oDK.hl(longValue);
                            this.oEc = true;
                            long ekS = C0970a.this.ekS();
                            if (longValue > j || ekS - longValue > a.this.oEE.oHO.oHT) {
                                C0970a.this.ekP();
                            } else {
                                C0970a.this.ekR();
                            }
                            yX(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0970a.this.evictAll();
                        C0970a.this.ekQ();
                        getLooper().quit();
                        return;
                    case 7:
                        C0970a.this.evictAll();
                        a.this.oDK.hl(a.this.oFn.oGd - a.this.oEE.oHO.oHT);
                        this.oEc = true;
                        return;
                    case 8:
                        C0970a.this.yW(true);
                        a.this.oDK.hl(a.this.oFn.oGd);
                        return;
                    case 9:
                        C0970a.this.yW(true);
                        a.this.oDK.hl(a.this.oFn.oGd);
                        a.this.elq();
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
                            n<?> elD = dVar.elD();
                            if (!((dVar.oGa & 1) != 0) && elD != null && elD.get() != null && !elD.emf()) {
                                dVar.oFT = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oEO, (master.flame.danmaku.danmaku.model.android.e) dVar.oFT);
                                C0970a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.ktm) {
                                C0970a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (elD != null && elD.emf()) {
                                    elD.destroy();
                                }
                                C0970a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.elE()) {
                            f(dVar2);
                            if (dVar2.oFT != null) {
                                C0970a.this.a(dVar2, dVar2.oFT.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.oEd = false;
                        return;
                }
                long ekZ = ekZ();
                if (ekZ <= 0) {
                    ekZ = a.this.oEE.oHO.oHT / 2;
                }
                sendEmptyMessageDelayed(16, ekZ);
            }

            private long ekZ() {
                if (a.this.oDK.oGd <= a.this.oFn.oGd - a.this.oEE.oHO.oHT) {
                    C0970a.this.ekP();
                    a.this.oDK.hl(a.this.oFn.oGd);
                    sendEmptyMessage(3);
                } else {
                    float ekO = C0970a.this.ekO();
                    master.flame.danmaku.danmaku.model.d elW = C0970a.this.oDO.elW();
                    long elO = elW != null ? elW.elO() - a.this.oFn.oGd : 0L;
                    long j = a.this.oEE.oHO.oHT * 2;
                    if (ekO < 0.6f && elO > a.this.oEE.oHO.oHT) {
                        a.this.oDK.hl(a.this.oFn.oGd);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (ekO > 0.4f && elO < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (ekO < 0.9f) {
                        long j2 = a.this.oDK.oGd - a.this.oFn.oGd;
                        if (elW != null && elW.elE() && j2 < (-a.this.oEE.oHO.oHT)) {
                            a.this.oDK.hl(a.this.oFn.oGd);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.oFT : eVar;
                dVar.oFT = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0970a.this.oDQ.c(eVar2);
                }
            }

            private void ela() {
                l lVar = null;
                try {
                    long j = a.this.oFn.oGd;
                    lVar = a.this.oFk.P(j - a.this.oEE.oHO.oHT, (a.this.oEE.oHO.oHT * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0971a.this.mPause || HandlerC0971a.this.oEd) {
                                return 1;
                            }
                            if (!dVar.elH()) {
                                a.this.oEE.oHN.a(dVar, 0, 0, null, true, a.this.oEE);
                            }
                            if (dVar.elI()) {
                                return 0;
                            }
                            if (!dVar.elC()) {
                                dVar.a((m) a.this.oEO, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.oEO, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.oDV.oDN.oDK.hl(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long yX(final boolean z) {
                l lVar;
                ela();
                final long j = a.this.oDK.oGd;
                long j2 = j + (a.this.oEE.oHO.oHT * C0970a.this.oDS);
                if (j2 < a.this.oFn.oGd) {
                    return 0L;
                }
                final long emL = master.flame.danmaku.danmaku.c.c.emL();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.oFk.P(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.hn(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d elW = lVar.elW();
                final master.flame.danmaku.danmaku.model.d elX = lVar.elX();
                if (elW == null || elX == null) {
                    a.this.oDK.hl(j2);
                    return 0L;
                }
                long elO = elW.elO() - a.this.oFn.oGd;
                final long min = Math.min(100L, elO < 0 ? 30L : ((elO * 10) / a.this.oEE.oHO.oHT) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int oEf = 0;
                    int oEg = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bQ(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0971a.this.mPause || HandlerC0971a.this.oEd || elX.elO() < a.this.oFn.oGd) {
                            return 1;
                        }
                        n<?> elD = dVar2.elD();
                        if (elD == null || elD.get() == null) {
                            if (z || (!dVar2.elE() && dVar2.elF())) {
                                if (!dVar2.elH()) {
                                    a.this.oEE.oHN.a(dVar2, this.oEf, size, null, true, a.this.oEE);
                                }
                                if (dVar2.oFL == 0 && dVar2.elI()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int elO2 = (int) ((dVar2.elO() - j) / a.this.oEE.oHO.oHT);
                                    if (this.oEg == elO2) {
                                        this.oEf++;
                                    } else {
                                        this.oEf = 0;
                                        this.oEg = elO2;
                                    }
                                }
                                if (!z && !HandlerC0971a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.oDL) {
                                            a.this.oDL.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0971a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long emL2 = master.flame.danmaku.danmaku.c.c.emL() - emL;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.oEE.oHO;
                                        if (emL2 >= 10000 * C0970a.this.oDS) {
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
                long emL2 = master.flame.danmaku.danmaku.c.c.emL() - emL;
                if (0 != 0) {
                    a.this.oDK.hl(dVar.elO());
                    return emL2;
                }
                a.this.oDK.hl(j2);
                return emL2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.elC()) {
                    dVar.a((m) a.this.oEO, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oEO, C0970a.this.oDQ.emD());
                        dVar.oFT = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0970a.this.oDQ.c(eVar);
                        }
                        dVar.oFT = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0970a.this.oDQ.c(eVar);
                        }
                        dVar.oFT = null;
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
                if (!dVar.elC()) {
                    dVar.a((m) a.this.oEO, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0970a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.oFT : null;
                        try {
                            if (r3 != null) {
                                r3.emy();
                                dVar.oFT = r3;
                                a.this.oDJ.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0970a c0970a = C0970a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0970a.a(dVar, false, 50);
                            eVar = c0970a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.oFT;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.oFT = null;
                                    dVar.oFT = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oEO, r3);
                                    a.this.oDJ.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.eq((int) dVar.oFM, (int) dVar.oFN) + C0970a.this.oDR <= C0970a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.oEO, C0970a.this.oDQ.emD());
                                    dVar.oFT = a3;
                                    boolean a4 = a.this.oDJ.a(dVar, C0970a.this.d(dVar), z);
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
                if (!dVar.elE()) {
                    if (dVar.elO() <= a.this.oDK.oGd + a.this.oEE.oHO.oHT || dVar.ktm) {
                        if (dVar.oFL != 0 || !dVar.elI()) {
                            n<?> elD = dVar.elD();
                            if (elD == null || elD.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void ekN() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.oEE.oHO.oHT);
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
                sendEmptyMessageDelayed(4, a.this.oEE.oHO.oHT);
            }

            public void hd(long j) {
                removeMessages(3);
                this.oEc = true;
                sendEmptyMessage(19);
                a.this.oDK.hl(a.this.oFn.oGd + j);
                sendEmptyMessage(3);
            }

            public void yY(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long ekS() {
            master.flame.danmaku.danmaku.model.d elW;
            if (this.oDO == null || this.oDO.size() <= 0 || (elW = this.oDO.elW()) == null) {
                return 0L;
            }
            return elW.elO();
        }

        public void hc(long j) {
            if (this.oDT != null) {
                this.oDT.hd(j);
            }
        }

        public void ekT() {
            if (this.oDT != null) {
                this.oDT.removeMessages(3);
                this.oDT.removeMessages(19);
                this.oDT.ekY();
                this.oDT.removeMessages(7);
                this.oDT.sendEmptyMessage(7);
            }
        }

        public void ekU() {
            if (this.oDT != null) {
                this.oDT.removeMessages(9);
                this.oDT.sendEmptyMessage(9);
            }
        }

        public void ekV() {
            if (this.oDT != null) {
                this.oDT.removeMessages(4);
                this.oDT.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.oDT != null) {
                this.oDT.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.oEO.aX(this.oEE.oHm);
                elq();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.oDJ != null)) {
                    this.oDJ.hc(0L);
                }
                elq();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.oEO.aX(this.oEE.oHm);
                }
                if (this.oDJ != null) {
                    this.oDJ.ekT();
                    this.oDJ.hc(-this.oEE.oHO.oHT);
                }
            } else if (this.oDJ != null) {
                this.oDJ.ekU();
                this.oDJ.hc(0L);
            }
        }
        if (this.oFl != null && this.oDJ != null) {
            this.oDJ.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.oFl.eln();
                }
            });
            return true;
        }
        return true;
    }
}
