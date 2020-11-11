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
    private int pTN;
    private C1080a pTO;
    private master.flame.danmaku.danmaku.model.f pTP;
    private final Object pTQ;
    private int pTR;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.pTN = 2;
        this.pTQ = new Object();
        NativeBitmapFactory.eIt();
        this.pTN = i;
        if (NativeBitmapFactory.eIs()) {
            this.pTN = i * 2;
        }
        this.pTO = new C1080a(i, 3);
        this.pVr.a(this.pTO);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.pVs = fVar;
        this.pTP = new master.flame.danmaku.danmaku.model.f();
        this.pTP.ip(fVar.pWi);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.pTO != null) {
            this.pTO.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void AV(boolean z) {
        super.AV(z);
        if (this.pTO != null) {
            this.pTO.eCt();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.pTO != null) {
            int i = this.pTR + 1;
            this.pTR = i;
            if (i > 5) {
                this.pTO.eCv();
                this.pTR = 0;
                return;
            }
            return;
        }
        n<?> eDd = dVar.eDd();
        if (eDd != null) {
            if (eDd.eDF()) {
                eDd.eDG();
            } else {
                eDd.destroy();
            }
            dVar.pVY = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a2 = super.a(bVar);
        synchronized (this.pTQ) {
            this.pTQ.notify();
        }
        if (a2 != null && this.pTO != null && a2.pYQ - a2.pYR < -20) {
            this.pTO.eCv();
            this.pTO.ig(-this.pUJ.pXT.pXY);
        }
        return a2;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.pTO == null) {
            start();
        }
        this.pTO.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.eIt();
        if (this.pTO == null) {
            this.pTO = new C1080a(this.pTN, 3);
            this.pTO.eCn();
            this.pVr.a(this.pTO);
            return;
        }
        this.pTO.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.pVr.a((k) null);
        if (this.pTO != null) {
            this.pTO.end();
            this.pTO = null;
        }
        NativeBitmapFactory.eIu();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.pUP == null) {
            throw new AssertionError();
        }
        b(this.pUP);
        this.pTO.eCn();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Ry(int i) {
        super.Ry(i);
        if (this.pTO != null) {
            this.pTO.Ry(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.pTO != null) {
            this.pTO.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1080a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int pTX;
        private HandlerC1081a pTY;
        master.flame.danmaku.danmaku.model.android.d pTT = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g pTU = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> pTV = master.flame.danmaku.danmaku.model.a.e.a(this.pTU, 800);
        private boolean pTZ = false;
        private int pTW = 0;

        public C1080a(int i, int i2) {
            this.pTX = 3;
            this.mMaxSize = i;
            this.pTX = i2;
        }

        public void seek(long j) {
            if (this.pTY != null) {
                this.pTY.eCy();
                this.pTY.removeMessages(3);
                this.pTY.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.pTY != null) {
                if (dVar.laS) {
                    if (dVar.pVZ) {
                        if (!dVar.eDe()) {
                            this.pTY.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.pTY.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.pTY.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void eCn() {
            this.pTZ = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.pTY == null) {
                this.pTY = new HandlerC1081a(this.mThread.getLooper());
            }
            this.pTY.eCn();
        }

        public void end() {
            this.pTZ = true;
            synchronized (a.this.pTQ) {
                a.this.pTQ.notifyAll();
            }
            if (this.pTY != null) {
                this.pTY.pause();
                this.pTY = null;
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
            if (this.pTY != null) {
                this.pTY.resume();
            } else {
                eCn();
            }
        }

        public void Ry(int i) {
            if (this.pTY != null) {
                this.pTY.AY(i == 1);
            }
        }

        public float eCo() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.pTW / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.pTT != null) {
                this.pTT.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                        C1080a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.pTT.clear();
            }
            this.pTW = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eCp() {
            AW(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void AW(final boolean z) {
            if (this.pTT != null) {
                this.pTT.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.pVY;
                        boolean z2 = nVar != null && nVar.eDF();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C1080a.this.pTW -= nVar.size();
                                nVar.destroy();
                            }
                            C1080a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.eDf()) {
                            C1080a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> eDd = dVar.eDd();
            if (eDd != null) {
                long c = c(dVar);
                if (dVar.eDe()) {
                    a.this.pUJ.eDM().eDb().t(dVar);
                }
                if (c > 0) {
                    this.pTW = (int) (this.pTW - c);
                    this.pTV.c((master.flame.danmaku.danmaku.model.android.e) eDd);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.pVY;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.eDF()) {
                nVar.eDG();
                dVar.pVY = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.pVY = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.pVY != null && !dVar.pVY.eDF()) {
                    return dVar.pVY.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eCq() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e eEd = this.pTV.eEd();
                if (eEd != null) {
                    eEd.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d eDw = this.pTT.eDw();
            while (true) {
                if (this.pTW + i <= this.mMaxSize || eDw == null) {
                    break;
                } else if (eDw.eDe()) {
                    a(false, eDw, dVar);
                    this.pTT.l(eDw);
                    eDw = this.pTT.eDw();
                } else if (!z) {
                    return false;
                }
            }
            this.pTT.k(dVar);
            this.pTW += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eCr() {
            this.pTT.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.eDe()) {
                        synchronized (a.this.pTQ) {
                            try {
                                a.this.pTQ.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C1080a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.pUT.eDB() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d pUc;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: eCw */
                public master.flame.danmaku.danmaku.model.d eCx() {
                    return this.pUc;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bX(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> eDd = dVar2.eDd();
                    if (eDd == null || eDd.get() == null) {
                        return 0;
                    }
                    if (dVar2.pVR == dVar.pVR && dVar2.pVS == dVar.pVS && dVar2.underlineColor == dVar.underlineColor && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.pUc = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.eDe()) {
                            if (eDd.eDF()) {
                                return 0;
                            }
                            float width = eDd.width() - dVar.pVR;
                            float height = eDd.height() - dVar.pVS;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.pUc = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.pTT.b(bVar);
            return bVar.eCx();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC1081a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean pUh;
            private boolean pUi;

            public HandlerC1081a(Looper looper) {
                super(looper);
            }

            public void eCy() {
                this.pUi = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C1080a.this.eCp();
                        for (int i = 0; i < 300; i++) {
                            C1080a.this.pTV.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.pVq == null || a.this.pVw) || this.pUh;
                        AX(z);
                        if (z) {
                            this.pUh = false;
                        }
                        if (a.this.pVq != null && !a.this.pVw) {
                            a.this.pVq.eCL();
                            a.this.pVw = true;
                            return;
                        }
                        return;
                    case 4:
                        C1080a.this.eCr();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.pTP.pWi;
                            a.this.pTP.ip(longValue);
                            this.pUh = true;
                            long eCs = C1080a.this.eCs();
                            if (longValue > j || eCs - longValue > a.this.pUJ.pXT.pXY) {
                                C1080a.this.eCp();
                            } else {
                                C1080a.this.eCr();
                            }
                            AX(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C1080a.this.evictAll();
                        C1080a.this.eCq();
                        getLooper().quit();
                        return;
                    case 7:
                        C1080a.this.evictAll();
                        a.this.pTP.ip(a.this.pVs.pWi - a.this.pUJ.pXT.pXY);
                        this.pUh = true;
                        return;
                    case 8:
                        C1080a.this.AW(true);
                        a.this.pTP.ip(a.this.pVs.pWi);
                        return;
                    case 9:
                        C1080a.this.AW(true);
                        a.this.pTP.ip(a.this.pVs.pWi);
                        a.this.eCQ();
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
                            n<?> eDd = dVar.eDd();
                            if (!((dVar.pWf & 1) != 0) && eDd != null && eDd.get() != null && !eDd.eDF()) {
                                dVar.pVY = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pUT, (master.flame.danmaku.danmaku.model.android.e) dVar.pVY);
                                C1080a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.laS) {
                                C1080a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (eDd != null && eDd.eDF()) {
                                    eDd.destroy();
                                }
                                C1080a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.eDe()) {
                            f(dVar2);
                            if (dVar2.pVY != null) {
                                C1080a.this.a(dVar2, dVar2.pVY.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.pUi = false;
                        return;
                }
                long eCz = eCz();
                if (eCz <= 0) {
                    eCz = a.this.pUJ.pXT.pXY / 2;
                }
                sendEmptyMessageDelayed(16, eCz);
            }

            private long eCz() {
                if (a.this.pTP.pWi <= a.this.pVs.pWi - a.this.pUJ.pXT.pXY) {
                    C1080a.this.eCp();
                    a.this.pTP.ip(a.this.pVs.pWi);
                    sendEmptyMessage(3);
                } else {
                    float eCo = C1080a.this.eCo();
                    master.flame.danmaku.danmaku.model.d eDw = C1080a.this.pTT.eDw();
                    long eDo = eDw != null ? eDw.eDo() - a.this.pVs.pWi : 0L;
                    long j = a.this.pUJ.pXT.pXY * 2;
                    if (eCo < 0.6f && eDo > a.this.pUJ.pXT.pXY) {
                        a.this.pTP.ip(a.this.pVs.pWi);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (eCo > 0.4f && eDo < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (eCo < 0.9f) {
                        long j2 = a.this.pTP.pWi - a.this.pVs.pWi;
                        if (eDw != null && eDw.eDe() && j2 < (-a.this.pUJ.pXT.pXY)) {
                            a.this.pTP.ip(a.this.pVs.pWi);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.pVY : eVar;
                dVar.pVY = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C1080a.this.pTV.c(eVar2);
                }
            }

            private void eCA() {
                l lVar = null;
                try {
                    long j = a.this.pVs.pWi;
                    lVar = a.this.pVp.R(j - a.this.pUJ.pXT.pXY, (a.this.pUJ.pXT.pXY * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC1081a.this.mPause || HandlerC1081a.this.pUi) {
                                return 1;
                            }
                            if (!dVar.eDh()) {
                                a.this.pUJ.pXS.a(dVar, 0, 0, null, true, a.this.pUJ);
                            }
                            if (dVar.eDi()) {
                                return 0;
                            }
                            if (!dVar.eDc()) {
                                dVar.a((m) a.this.pUT, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.pUT, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.pUa.pTS.pTP.ip(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long AX(final boolean z) {
                l lVar;
                eCA();
                final long j = a.this.pTP.pWi;
                long j2 = j + (a.this.pUJ.pXT.pXY * C1080a.this.pTX);
                if (j2 < a.this.pVs.pWi) {
                    return 0L;
                }
                final long eEl = master.flame.danmaku.danmaku.c.c.eEl();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.pVp.R(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.ir(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d eDw = lVar.eDw();
                final master.flame.danmaku.danmaku.model.d eDx = lVar.eDx();
                if (eDw == null || eDx == null) {
                    a.this.pTP.ip(j2);
                    return 0L;
                }
                long eDo = eDw.eDo() - a.this.pVs.pWi;
                final long min = Math.min(100L, eDo < 0 ? 30L : ((eDo * 10) / a.this.pUJ.pXT.pXY) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int pUk = 0;
                    int pUl = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bX(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC1081a.this.mPause || HandlerC1081a.this.pUi || eDx.eDo() < a.this.pVs.pWi) {
                            return 1;
                        }
                        n<?> eDd = dVar2.eDd();
                        if (eDd == null || eDd.get() == null) {
                            if (z || (!dVar2.eDe() && dVar2.eDf())) {
                                if (!dVar2.eDh()) {
                                    a.this.pUJ.pXS.a(dVar2, this.pUk, size, null, true, a.this.pUJ);
                                }
                                if (dVar2.pVQ == 0 && dVar2.eDi()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int eDo2 = (int) ((dVar2.eDo() - j) / a.this.pUJ.pXT.pXY);
                                    if (this.pUl == eDo2) {
                                        this.pUk++;
                                    } else {
                                        this.pUk = 0;
                                        this.pUl = eDo2;
                                    }
                                }
                                if (!z && !HandlerC1081a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.pTQ) {
                                            a.this.pTQ.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC1081a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long eEl2 = master.flame.danmaku.danmaku.c.c.eEl() - eEl;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.pUJ.pXT;
                                        if (eEl2 >= 10000 * C1080a.this.pTX) {
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
                long eEl2 = master.flame.danmaku.danmaku.c.c.eEl() - eEl;
                if (0 != 0) {
                    a.this.pTP.ip(dVar.eDo());
                    return eEl2;
                }
                a.this.pTP.ip(j2);
                return eEl2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.eDc()) {
                    dVar.a((m) a.this.pUT, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pUT, C1080a.this.pTV.eEd());
                        dVar.pVY = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C1080a.this.pTV.c(eVar);
                        }
                        dVar.pVY = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C1080a.this.pTV.c(eVar);
                        }
                        dVar.pVY = null;
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
                if (!dVar.eDc()) {
                    dVar.a((m) a.this.pUT, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a2 = C1080a.this.a(dVar, true, 20);
                        r3 = a2 != null ? (master.flame.danmaku.danmaku.model.android.e) a2.pVY : null;
                        try {
                            if (r3 != null) {
                                r3.eDY();
                                dVar.pVY = r3;
                                a.this.pTO.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C1080a c1080a = C1080a.this;
                            master.flame.danmaku.danmaku.model.d a3 = c1080a.a(dVar, false, 50);
                            eVar = c1080a;
                            if (a3 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a3.pVY;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a3.pVY = null;
                                    dVar.pVY = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pUT, r3);
                                    a.this.pTO.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.eB((int) dVar.pVR, (int) dVar.pVS) + C1080a.this.pTW <= C1080a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a4 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.pUT, C1080a.this.pTV.eEd());
                                    dVar.pVY = a4;
                                    boolean a5 = a.this.pTO.a(dVar, C1080a.this.d(dVar), z);
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
                if (!dVar.eDe()) {
                    if (dVar.eDo() <= a.this.pTP.pWi + a.this.pUJ.pXT.pXY || dVar.laS) {
                        if (dVar.pVQ != 0 || !dVar.eDi()) {
                            n<?> eDd = dVar.eDd();
                            if (eDd == null || eDd.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void eCn() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.pUJ.pXT.pXY);
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
                sendEmptyMessageDelayed(4, a.this.pUJ.pXT.pXY);
            }

            public void ih(long j) {
                removeMessages(3);
                this.pUh = true;
                sendEmptyMessage(19);
                a.this.pTP.ip(a.this.pVs.pWi + j);
                sendEmptyMessage(3);
            }

            public void AY(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long eCs() {
            master.flame.danmaku.danmaku.model.d eDw;
            if (this.pTT == null || this.pTT.size() <= 0 || (eDw = this.pTT.eDw()) == null) {
                return 0L;
            }
            return eDw.eDo();
        }

        public void ig(long j) {
            if (this.pTY != null) {
                this.pTY.ih(j);
            }
        }

        public void eCt() {
            if (this.pTY != null) {
                this.pTY.removeMessages(3);
                this.pTY.removeMessages(19);
                this.pTY.eCy();
                this.pTY.removeMessages(7);
                this.pTY.sendEmptyMessage(7);
            }
        }

        public void eCu() {
            if (this.pTY != null) {
                this.pTY.removeMessages(9);
                this.pTY.sendEmptyMessage(9);
            }
        }

        public void eCv() {
            if (this.pTY != null) {
                this.pTY.removeMessages(4);
                this.pTY.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.pTY != null) {
                this.pTY.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.pUT.bw(this.pUJ.pXr);
                eCQ();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.pTO != null)) {
                    this.pTO.ig(0L);
                }
                eCQ();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.pUT.bw(this.pUJ.pXr);
                }
                if (this.pTO != null) {
                    this.pTO.eCt();
                    this.pTO.ig(-this.pUJ.pXT.pXY);
                }
            } else if (this.pTO != null) {
                this.pTO.eCu();
                this.pTO.ig(0L);
            }
        }
        if (this.pVq != null && this.pTO != null) {
            this.pTO.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.pVq.eCN();
                }
            });
            return true;
        }
        return true;
    }
}
