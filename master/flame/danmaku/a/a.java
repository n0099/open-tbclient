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
    private int otJ;
    private C0973a otK;
    private master.flame.danmaku.danmaku.model.f otL;
    private final Object otM;
    private int otN;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.otJ = 2;
        this.otM = new Object();
        NativeBitmapFactory.emQ();
        this.otJ = i;
        if (NativeBitmapFactory.emP()) {
            this.otJ = i * 2;
        }
        this.otK = new C0973a(i, 3);
        this.ovo.a(this.otK);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.ovp = fVar;
        this.otL = new master.flame.danmaku.danmaku.model.f();
        this.otL.gV(fVar.owf);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.otK != null) {
            this.otK.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void yL(boolean z) {
        super.yL(z);
        if (this.otK != null) {
            this.otK.egN();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.otK != null) {
            int i = this.otN + 1;
            this.otN = i;
            if (i > 5) {
                this.otK.egP();
                this.otN = 0;
                return;
            }
            return;
        }
        n<?> ehx = dVar.ehx();
        if (ehx != null) {
            if (ehx.ehZ()) {
                ehx.eia();
            } else {
                ehx.destroy();
            }
            dVar.ovV = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.otM) {
            this.otM.notify();
        }
        if (a != null && this.otK != null && a.oyP - a.oyQ < -20) {
            this.otK.egP();
            this.otK.gM(-this.ouG.oxR.oxW);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.otK == null) {
            start();
        }
        this.otK.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.emQ();
        if (this.otK == null) {
            this.otK = new C0973a(this.otJ, 3);
            this.otK.egH();
            this.ovo.a(this.otK);
            return;
        }
        this.otK.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.ovo.a((k) null);
        if (this.otK != null) {
            this.otK.end();
            this.otK = null;
        }
        NativeBitmapFactory.emR();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.ouM == null) {
            throw new AssertionError();
        }
        b(this.ouM);
        this.otK.egH();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Ob(int i) {
        super.Ob(i);
        if (this.otK != null) {
            this.otK.Ob(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.otK != null) {
            this.otK.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0973a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int otT;
        private HandlerC0974a otU;
        master.flame.danmaku.danmaku.model.android.d otP = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g otQ = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> otR = master.flame.danmaku.danmaku.model.a.e.a(this.otQ, 800);
        private boolean otV = false;
        private int otS = 0;

        public C0973a(int i, int i2) {
            this.otT = 3;
            this.mMaxSize = i;
            this.otT = i2;
        }

        public void seek(long j) {
            if (this.otU != null) {
                this.otU.egS();
                this.otU.removeMessages(3);
                this.otU.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.otU != null) {
                if (dVar.kkG) {
                    if (dVar.ovW) {
                        if (!dVar.ehy()) {
                            this.otU.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.otU.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.otU.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void egH() {
            this.otV = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.otU == null) {
                this.otU = new HandlerC0974a(this.mThread.getLooper());
            }
            this.otU.egH();
        }

        public void end() {
            this.otV = true;
            synchronized (a.this.otM) {
                a.this.otM.notifyAll();
            }
            if (this.otU != null) {
                this.otU.pause();
                this.otU = null;
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
            if (this.otU != null) {
                this.otU.resume();
            } else {
                egH();
            }
        }

        public void Ob(int i) {
            if (this.otU != null) {
                this.otU.yO(i == 1);
            }
        }

        public float egI() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.otS / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.otP != null) {
                this.otP.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                        C0973a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.otP.clear();
            }
            this.otS = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egJ() {
            yM(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void yM(final boolean z) {
            if (this.otP != null) {
                this.otP.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.ovV;
                        boolean z2 = nVar != null && nVar.ehZ();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0973a.this.otS -= nVar.size();
                                nVar.destroy();
                            }
                            C0973a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.ehz()) {
                            C0973a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> ehx = dVar.ehx();
            if (ehx != null) {
                long c = c(dVar);
                if (dVar.ehy()) {
                    a.this.ouG.eig().ehv().t(dVar);
                }
                if (c > 0) {
                    this.otS = (int) (this.otS - c);
                    this.otR.c((master.flame.danmaku.danmaku.model.android.e) ehx);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.ovV;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.ehZ()) {
                nVar.eia();
                dVar.ovV = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.ovV = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.ovV != null && !dVar.ovV.ehZ()) {
                    return dVar.ovV.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egK() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e eix = this.otR.eix();
                if (eix != null) {
                    eix.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d ehQ = this.otP.ehQ();
            while (true) {
                if (this.otS + i <= this.mMaxSize || ehQ == null) {
                    break;
                } else if (ehQ.ehy()) {
                    a(false, ehQ, dVar);
                    this.otP.l(ehQ);
                    ehQ = this.otP.ehQ();
                } else if (!z) {
                    return false;
                }
            }
            this.otP.k(dVar);
            this.otS += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egL() {
            this.otP.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.ehy()) {
                        synchronized (a.this.otM) {
                            try {
                                a.this.otM.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0973a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.ouQ.ehV() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d otY;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: egQ */
                public master.flame.danmaku.danmaku.model.d egR() {
                    return this.otY;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bO(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> ehx = dVar2.ehx();
                    if (ehx == null || ehx.get() == null) {
                        return 0;
                    }
                    if (dVar2.ovO == dVar.ovO && dVar2.ovP == dVar.ovP && dVar2.underlineColor == dVar.underlineColor && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.otY = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.ehy()) {
                            if (ehx.ehZ()) {
                                return 0;
                            }
                            float width = ehx.width() - dVar.ovO;
                            float height = ehx.height() - dVar.ovP;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.otY = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.otP.b(bVar);
            return bVar.egR();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC0974a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean oud;
            private boolean oue;

            public HandlerC0974a(Looper looper) {
                super(looper);
            }

            public void egS() {
                this.oue = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0973a.this.egJ();
                        for (int i = 0; i < 300; i++) {
                            C0973a.this.otR.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.ovn == null || a.this.ovt) || this.oud;
                        yN(z);
                        if (z) {
                            this.oud = false;
                        }
                        if (a.this.ovn != null && !a.this.ovt) {
                            a.this.ovn.ehf();
                            a.this.ovt = true;
                            return;
                        }
                        return;
                    case 4:
                        C0973a.this.egL();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.otL.owf;
                            a.this.otL.gV(longValue);
                            this.oud = true;
                            long egM = C0973a.this.egM();
                            if (longValue > j || egM - longValue > a.this.ouG.oxR.oxW) {
                                C0973a.this.egJ();
                            } else {
                                C0973a.this.egL();
                            }
                            yN(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0973a.this.evictAll();
                        C0973a.this.egK();
                        getLooper().quit();
                        return;
                    case 7:
                        C0973a.this.evictAll();
                        a.this.otL.gV(a.this.ovp.owf - a.this.ouG.oxR.oxW);
                        this.oud = true;
                        return;
                    case 8:
                        C0973a.this.yM(true);
                        a.this.otL.gV(a.this.ovp.owf);
                        return;
                    case 9:
                        C0973a.this.yM(true);
                        a.this.otL.gV(a.this.ovp.owf);
                        a.this.ehk();
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
                            n<?> ehx = dVar.ehx();
                            if (!((dVar.owc & 1) != 0) && ehx != null && ehx.get() != null && !ehx.ehZ()) {
                                dVar.ovV = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.ouQ, (master.flame.danmaku.danmaku.model.android.e) dVar.ovV);
                                C0973a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.kkG) {
                                C0973a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (ehx != null && ehx.ehZ()) {
                                    ehx.destroy();
                                }
                                C0973a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.ehy()) {
                            f(dVar2);
                            if (dVar2.ovV != null) {
                                C0973a.this.a(dVar2, dVar2.ovV.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.oue = false;
                        return;
                }
                long egT = egT();
                if (egT <= 0) {
                    egT = a.this.ouG.oxR.oxW / 2;
                }
                sendEmptyMessageDelayed(16, egT);
            }

            private long egT() {
                if (a.this.otL.owf <= a.this.ovp.owf - a.this.ouG.oxR.oxW) {
                    C0973a.this.egJ();
                    a.this.otL.gV(a.this.ovp.owf);
                    sendEmptyMessage(3);
                } else {
                    float egI = C0973a.this.egI();
                    master.flame.danmaku.danmaku.model.d ehQ = C0973a.this.otP.ehQ();
                    long ehI = ehQ != null ? ehQ.ehI() - a.this.ovp.owf : 0L;
                    long j = a.this.ouG.oxR.oxW * 2;
                    if (egI < 0.6f && ehI > a.this.ouG.oxR.oxW) {
                        a.this.otL.gV(a.this.ovp.owf);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (egI > 0.4f && ehI < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (egI < 0.9f) {
                        long j2 = a.this.otL.owf - a.this.ovp.owf;
                        if (ehQ != null && ehQ.ehy() && j2 < (-a.this.ouG.oxR.oxW)) {
                            a.this.otL.gV(a.this.ovp.owf);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.ovV : eVar;
                dVar.ovV = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0973a.this.otR.c(eVar2);
                }
            }

            private void egU() {
                l lVar = null;
                try {
                    long j = a.this.ovp.owf;
                    lVar = a.this.ovm.S(j - a.this.ouG.oxR.oxW, (a.this.ouG.oxR.oxW * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0974a.this.mPause || HandlerC0974a.this.oue) {
                                return 1;
                            }
                            if (!dVar.ehB()) {
                                a.this.ouG.oxQ.a(dVar, 0, 0, null, true, a.this.ouG);
                            }
                            if (dVar.ehC()) {
                                return 0;
                            }
                            if (!dVar.ehw()) {
                                dVar.a((m) a.this.ouQ, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.ouQ, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.otW.otO.otL.gV(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long yN(final boolean z) {
                l lVar;
                egU();
                final long j = a.this.otL.owf;
                long j2 = j + (a.this.ouG.oxR.oxW * C0973a.this.otT);
                if (j2 < a.this.ovp.owf) {
                    return 0L;
                }
                final long eiF = master.flame.danmaku.danmaku.c.c.eiF();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.ovm.S(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.gX(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d ehQ = lVar.ehQ();
                final master.flame.danmaku.danmaku.model.d ehR = lVar.ehR();
                if (ehQ == null || ehR == null) {
                    a.this.otL.gV(j2);
                    return 0L;
                }
                long ehI = ehQ.ehI() - a.this.ovp.owf;
                final long min = Math.min(100L, ehI < 0 ? 30L : ((ehI * 10) / a.this.ouG.oxR.oxW) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int oug = 0;
                    int ouh = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bO(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0974a.this.mPause || HandlerC0974a.this.oue || ehR.ehI() < a.this.ovp.owf) {
                            return 1;
                        }
                        n<?> ehx = dVar2.ehx();
                        if (ehx == null || ehx.get() == null) {
                            if (z || (!dVar2.ehy() && dVar2.ehz())) {
                                if (!dVar2.ehB()) {
                                    a.this.ouG.oxQ.a(dVar2, this.oug, size, null, true, a.this.ouG);
                                }
                                if (dVar2.ovN == 0 && dVar2.ehC()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int ehI2 = (int) ((dVar2.ehI() - j) / a.this.ouG.oxR.oxW);
                                    if (this.ouh == ehI2) {
                                        this.oug++;
                                    } else {
                                        this.oug = 0;
                                        this.ouh = ehI2;
                                    }
                                }
                                if (!z && !HandlerC0974a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.otM) {
                                            a.this.otM.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0974a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long eiF2 = master.flame.danmaku.danmaku.c.c.eiF() - eiF;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.ouG.oxR;
                                        if (eiF2 >= 10000 * C0973a.this.otT) {
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
                long eiF2 = master.flame.danmaku.danmaku.c.c.eiF() - eiF;
                if (0 != 0) {
                    a.this.otL.gV(dVar.ehI());
                    return eiF2;
                }
                a.this.otL.gV(j2);
                return eiF2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.ehw()) {
                    dVar.a((m) a.this.ouQ, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.ouQ, C0973a.this.otR.eix());
                        dVar.ovV = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0973a.this.otR.c(eVar);
                        }
                        dVar.ovV = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0973a.this.otR.c(eVar);
                        }
                        dVar.ovV = null;
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
                if (!dVar.ehw()) {
                    dVar.a((m) a.this.ouQ, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0973a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.ovV : null;
                        try {
                            if (r3 != null) {
                                r3.eis();
                                dVar.ovV = r3;
                                a.this.otK.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0973a c0973a = C0973a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0973a.a(dVar, false, 50);
                            eVar = c0973a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.ovV;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.ovV = null;
                                    dVar.ovV = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.ouQ, r3);
                                    a.this.otK.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.em((int) dVar.ovO, (int) dVar.ovP) + C0973a.this.otS <= C0973a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.ouQ, C0973a.this.otR.eix());
                                    dVar.ovV = a3;
                                    boolean a4 = a.this.otK.a(dVar, C0973a.this.d(dVar), z);
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
                if (!dVar.ehy()) {
                    if (dVar.ehI() <= a.this.otL.owf + a.this.ouG.oxR.oxW || dVar.kkG) {
                        if (dVar.ovN != 0 || !dVar.ehC()) {
                            n<?> ehx = dVar.ehx();
                            if (ehx == null || ehx.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void egH() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.ouG.oxR.oxW);
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
                sendEmptyMessageDelayed(4, a.this.ouG.oxR.oxW);
            }

            public void gN(long j) {
                removeMessages(3);
                this.oud = true;
                sendEmptyMessage(19);
                a.this.otL.gV(a.this.ovp.owf + j);
                sendEmptyMessage(3);
            }

            public void yO(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long egM() {
            master.flame.danmaku.danmaku.model.d ehQ;
            if (this.otP == null || this.otP.size() <= 0 || (ehQ = this.otP.ehQ()) == null) {
                return 0L;
            }
            return ehQ.ehI();
        }

        public void gM(long j) {
            if (this.otU != null) {
                this.otU.gN(j);
            }
        }

        public void egN() {
            if (this.otU != null) {
                this.otU.removeMessages(3);
                this.otU.removeMessages(19);
                this.otU.egS();
                this.otU.removeMessages(7);
                this.otU.sendEmptyMessage(7);
            }
        }

        public void egO() {
            if (this.otU != null) {
                this.otU.removeMessages(9);
                this.otU.sendEmptyMessage(9);
            }
        }

        public void egP() {
            if (this.otU != null) {
                this.otU.removeMessages(4);
                this.otU.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.otU != null) {
                this.otU.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.ouQ.aX(this.ouG.oxp);
                ehk();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.otK != null)) {
                    this.otK.gM(0L);
                }
                ehk();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.ouQ.aX(this.ouG.oxp);
                }
                if (this.otK != null) {
                    this.otK.egN();
                    this.otK.gM(-this.ouG.oxR.oxW);
                }
            } else if (this.otK != null) {
                this.otK.egO();
                this.otK.gM(0L);
            }
        }
        if (this.ovn != null && this.otK != null) {
            this.otK.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ovn.ehh();
                }
            });
            return true;
        }
        return true;
    }
}
