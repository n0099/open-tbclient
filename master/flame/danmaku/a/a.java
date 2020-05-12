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
    private int mYY;
    private C0817a mYZ;
    private master.flame.danmaku.danmaku.model.f mZa;
    private final Object mZb;
    private int mZc;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.mYY = 2;
        this.mZb = new Object();
        NativeBitmapFactory.dKy();
        this.mYY = i;
        if (NativeBitmapFactory.dKx()) {
            this.mYY = i * 2;
        }
        this.mYZ = new C0817a(i, 3);
        this.naC.a(this.mYZ);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.naD = fVar;
        this.mZa = new master.flame.danmaku.danmaku.model.f();
        this.mZa.gp(fVar.nbv);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.mYZ != null) {
            this.mYZ.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wt(boolean z) {
        super.wt(z);
        if (this.mYZ != null) {
            this.mYZ.dEw();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.mYZ != null) {
            int i = this.mZc + 1;
            this.mZc = i;
            if (i > 5) {
                this.mYZ.dEy();
                this.mZc = 0;
                return;
            }
            return;
        }
        n<?> dFg = dVar.dFg();
        if (dFg != null) {
            if (dFg.dFH()) {
                dFg.dFI();
            } else {
                dFg.destroy();
            }
            dVar.nbk = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.mZb) {
            this.mZb.notify();
        }
        if (a != null && this.mYZ != null && a.neg - a.neh < -20) {
            this.mYZ.dEy();
            this.mYZ.gg(-this.mZU.ndh.ndm);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.mYZ == null) {
            start();
        }
        this.mYZ.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dKy();
        if (this.mYZ == null) {
            this.mYZ = new C0817a(this.mYY, 3);
            this.mYZ.dEq();
            this.naC.a(this.mYZ);
            return;
        }
        this.mYZ.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.naC.a((k) null);
        if (this.mYZ != null) {
            this.mYZ.end();
            this.mYZ = null;
        }
        NativeBitmapFactory.dKz();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.naa == null) {
            throw new AssertionError();
        }
        b(this.naa);
        this.mYZ.dEq();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Jk(int i) {
        super.Jk(i);
        if (this.mYZ != null) {
            this.mYZ.Jk(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void h(long j, long j2, long j3) {
        super.h(j, j2, j3);
        if (this.mYZ != null) {
            this.mYZ.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0817a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int mZi;
        private HandlerC0818a mZj;
        master.flame.danmaku.danmaku.model.android.d mZe = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g mZf = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> mZg = master.flame.danmaku.danmaku.model.a.e.a(this.mZf, 800);
        private boolean mZk = false;
        private int mZh = 0;

        public C0817a(int i, int i2) {
            this.mZi = 3;
            this.mMaxSize = i;
            this.mZi = i2;
        }

        public void seek(long j) {
            if (this.mZj != null) {
                this.mZj.dEB();
                this.mZj.removeMessages(3);
                this.mZj.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.mZj != null) {
                if (dVar.nbl) {
                    if (dVar.nbm) {
                        if (!dVar.isTimeOut()) {
                            this.mZj.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.mZj.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.mZj.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void dEq() {
            this.mZk = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.mZj == null) {
                this.mZj = new HandlerC0818a(this.mThread.getLooper());
            }
            this.mZj.dEq();
        }

        public void end() {
            this.mZk = true;
            synchronized (a.this.mZb) {
                a.this.mZb.notifyAll();
            }
            if (this.mZj != null) {
                this.mZj.pause();
                this.mZj = null;
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
            if (this.mZj != null) {
                this.mZj.resume();
            } else {
                dEq();
            }
        }

        public void Jk(int i) {
            if (this.mZj != null) {
                this.mZj.ww(i == 1);
            }
        }

        public float dEr() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.mZh / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.mZe != null) {
                this.mZe.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bF(master.flame.danmaku.danmaku.model.d dVar) {
                        C0817a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.mZe.clear();
            }
            this.mZh = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dEs() {
            wu(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wu(final boolean z) {
            if (this.mZe != null) {
                this.mZe.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bF(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nbk;
                        boolean z2 = nVar != null && nVar.dFH();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0817a.this.mZh -= nVar.size();
                                nVar.destroy();
                            }
                            C0817a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dFh()) {
                            C0817a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dFg = dVar.dFg();
            if (dFg != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.mZU.dFO().dFe().t(dVar);
                }
                if (c > 0) {
                    this.mZh = (int) (this.mZh - c);
                    this.mZg.c((master.flame.danmaku.danmaku.model.android.e) dFg);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nbk;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dFH()) {
                nVar.dFI();
                dVar.nbk = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nbk = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nbk != null && !dVar.nbk.dFH()) {
                    return dVar.nbk.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dEt() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dGf = this.mZg.dGf();
                if (dGf != null) {
                    dGf.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dFy = this.mZe.dFy();
            while (true) {
                if (this.mZh + i <= this.mMaxSize || dFy == null) {
                    break;
                } else if (dFy.isTimeOut()) {
                    a(false, dFy, dVar);
                    this.mZe.l(dFy);
                    dFy = this.mZe.dFy();
                } else if (!z) {
                    return false;
                }
            }
            this.mZe.k(dVar);
            this.mZh += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dEu() {
            this.mZe.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bF(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.mZb) {
                            try {
                                a.this.mZb.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0817a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nae.dFD() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d mZn;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dEz */
                public master.flame.danmaku.danmaku.model.d dEA() {
                    return this.mZn;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bF(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> dFg = dVar2.dFg();
                    if (dFg == null || dFg.get() == null) {
                        return 0;
                    }
                    if (dVar2.nbd == dVar.nbd && dVar2.nbe == dVar.nbe && dVar2.nbb == dVar.nbb && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.mZn = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dFg.dFH()) {
                                return 0;
                            }
                            float width = dFg.width() - dVar.nbd;
                            float height = dFg.height() - dVar.nbe;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.mZn = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.mZe.b(bVar);
            return bVar.dEA();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0818a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean mZs;
            private boolean mZt;

            public HandlerC0818a(Looper looper) {
                super(looper);
            }

            public void dEB() {
                this.mZt = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0817a.this.dEs();
                        for (int i = 0; i < 300; i++) {
                            C0817a.this.mZg.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.naB == null || a.this.naH) || this.mZs;
                        wv(z);
                        if (z) {
                            this.mZs = false;
                        }
                        if (a.this.naB != null && !a.this.naH) {
                            a.this.naB.dEO();
                            a.this.naH = true;
                            return;
                        }
                        return;
                    case 4:
                        C0817a.this.dEu();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.mZa.nbv;
                            a.this.mZa.gp(longValue);
                            this.mZs = true;
                            long dEv = C0817a.this.dEv();
                            if (longValue > j || dEv - longValue > a.this.mZU.ndh.ndm) {
                                C0817a.this.dEs();
                            } else {
                                C0817a.this.dEu();
                            }
                            wv(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0817a.this.evictAll();
                        C0817a.this.dEt();
                        getLooper().quit();
                        return;
                    case 7:
                        C0817a.this.evictAll();
                        a.this.mZa.gp(a.this.naD.nbv - a.this.mZU.ndh.ndm);
                        this.mZs = true;
                        return;
                    case 8:
                        C0817a.this.wu(true);
                        a.this.mZa.gp(a.this.naD.nbv);
                        return;
                    case 9:
                        C0817a.this.wu(true);
                        a.this.mZa.gp(a.this.naD.nbv);
                        a.this.dET();
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
                            n<?> dFg = dVar.dFg();
                            if (!((dVar.nbs & 1) != 0) && dFg != null && dFg.get() != null && !dFg.dFH()) {
                                dVar.nbk = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nae, (master.flame.danmaku.danmaku.model.android.e) dVar.nbk);
                                C0817a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.nbl) {
                                C0817a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dFg != null && dFg.dFH()) {
                                    dFg.destroy();
                                }
                                C0817a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nbk != null) {
                                C0817a.this.a(dVar2, dVar2.nbk.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.mZt = false;
                        return;
                }
                long dEC = dEC();
                if (dEC <= 0) {
                    dEC = a.this.mZU.ndh.ndm / 2;
                }
                sendEmptyMessageDelayed(16, dEC);
            }

            private long dEC() {
                if (a.this.mZa.nbv <= a.this.naD.nbv - a.this.mZU.ndh.ndm) {
                    C0817a.this.dEs();
                    a.this.mZa.gp(a.this.naD.nbv);
                    sendEmptyMessage(3);
                } else {
                    float dEr = C0817a.this.dEr();
                    master.flame.danmaku.danmaku.model.d dFy = C0817a.this.mZe.dFy();
                    long dFq = dFy != null ? dFy.dFq() - a.this.naD.nbv : 0L;
                    long j = a.this.mZU.ndh.ndm * 2;
                    if (dEr < 0.6f && dFq > a.this.mZU.ndh.ndm) {
                        a.this.mZa.gp(a.this.naD.nbv);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dEr > 0.4f && dFq < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dEr < 0.9f) {
                        long j2 = a.this.mZa.nbv - a.this.naD.nbv;
                        if (dFy != null && dFy.isTimeOut() && j2 < (-a.this.mZU.ndh.ndm)) {
                            a.this.mZa.gp(a.this.naD.nbv);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nbk : eVar;
                dVar.nbk = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0817a.this.mZg.c(eVar2);
                }
            }

            private void dED() {
                l lVar = null;
                try {
                    long j = a.this.naD.nbv;
                    lVar = a.this.naA.O(j - a.this.mZU.ndh.ndm, (a.this.mZU.ndh.ndm * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bF(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0818a.this.mPause || HandlerC0818a.this.mZt) {
                                return 1;
                            }
                            if (!dVar.dFj()) {
                                a.this.mZU.ndg.a(dVar, 0, 0, null, true, a.this.mZU);
                            }
                            if (dVar.dFk()) {
                                return 0;
                            }
                            if (!dVar.dFf()) {
                                dVar.a((m) a.this.nae, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nae, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.mZl.mZd.mZa.gp(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wv(final boolean z) {
                l lVar;
                dED();
                final long j = a.this.mZa.nbv;
                long j2 = j + (a.this.mZU.ndh.ndm * C0817a.this.mZi);
                if (j2 < a.this.naD.nbv) {
                    return 0L;
                }
                final long dGn = master.flame.danmaku.danmaku.c.c.dGn();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.naA.O(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.gr(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d dFy = lVar.dFy();
                final master.flame.danmaku.danmaku.model.d dFz = lVar.dFz();
                if (dFy == null || dFz == null) {
                    a.this.mZa.gp(j2);
                    return 0L;
                }
                long dFq = dFy.dFq() - a.this.naD.nbv;
                final long min = Math.min(100L, dFq < 0 ? 30L : ((dFq * 10) / a.this.mZU.ndh.ndm) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int mZv = 0;
                    int mZw = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bF(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0818a.this.mPause || HandlerC0818a.this.mZt || dFz.dFq() < a.this.naD.nbv) {
                            return 1;
                        }
                        n<?> dFg = dVar2.dFg();
                        if (dFg == null || dFg.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dFh())) {
                                if (!dVar2.dFj()) {
                                    a.this.mZU.ndg.a(dVar2, this.mZv, size, null, true, a.this.mZU);
                                }
                                if (dVar2.nbc == 0 && dVar2.dFk()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dFq2 = (int) ((dVar2.dFq() - j) / a.this.mZU.ndh.ndm);
                                    if (this.mZw == dFq2) {
                                        this.mZv++;
                                    } else {
                                        this.mZv = 0;
                                        this.mZw = dFq2;
                                    }
                                }
                                if (!z && !HandlerC0818a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.mZb) {
                                            a.this.mZb.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0818a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dGn2 = master.flame.danmaku.danmaku.c.c.dGn() - dGn;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.mZU.ndh;
                                        if (dGn2 >= 10000 * C0817a.this.mZi) {
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
                long dGn2 = master.flame.danmaku.danmaku.c.c.dGn() - dGn;
                if (0 != 0) {
                    a.this.mZa.gp(dVar.dFq());
                    return dGn2;
                }
                a.this.mZa.gp(j2);
                return dGn2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dFf()) {
                    dVar.a((m) a.this.nae, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nae, C0817a.this.mZg.dGf());
                        dVar.nbk = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0817a.this.mZg.c(eVar);
                        }
                        dVar.nbk = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0817a.this.mZg.c(eVar);
                        }
                        dVar.nbk = null;
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
                if (!dVar.dFf()) {
                    dVar.a((m) a.this.nae, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0817a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nbk : null;
                        try {
                            if (r3 != null) {
                                r3.dGa();
                                dVar.nbk = r3;
                                a.this.mYZ.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0817a c0817a = C0817a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0817a.a(dVar, false, 50);
                            eVar = c0817a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nbk;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nbk = null;
                                    dVar.nbk = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nae, r3);
                                    a.this.mYZ.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.dO((int) dVar.nbd, (int) dVar.nbe) + C0817a.this.mZh <= C0817a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nae, C0817a.this.mZg.dGf());
                                    dVar.nbk = a3;
                                    boolean a4 = a.this.mYZ.a(dVar, C0817a.this.d(dVar), z);
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
                    if (dVar.dFq() <= a.this.mZa.nbv + a.this.mZU.ndh.ndm || dVar.nbl) {
                        if (dVar.nbc != 0 || !dVar.dFk()) {
                            n<?> dFg = dVar.dFg();
                            if (dFg == null || dFg.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void dEq() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.mZU.ndh.ndm);
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
                sendEmptyMessageDelayed(4, a.this.mZU.ndh.ndm);
            }

            public void gh(long j) {
                removeMessages(3);
                this.mZs = true;
                sendEmptyMessage(19);
                a.this.mZa.gp(a.this.naD.nbv + j);
                sendEmptyMessage(3);
            }

            public void ww(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dEv() {
            master.flame.danmaku.danmaku.model.d dFy;
            if (this.mZe == null || this.mZe.size() <= 0 || (dFy = this.mZe.dFy()) == null) {
                return 0L;
            }
            return dFy.dFq();
        }

        public void gg(long j) {
            if (this.mZj != null) {
                this.mZj.gh(j);
            }
        }

        public void dEw() {
            if (this.mZj != null) {
                this.mZj.removeMessages(3);
                this.mZj.removeMessages(19);
                this.mZj.dEB();
                this.mZj.removeMessages(7);
                this.mZj.sendEmptyMessage(7);
            }
        }

        public void dEx() {
            if (this.mZj != null) {
                this.mZj.removeMessages(9);
                this.mZj.sendEmptyMessage(9);
            }
        }

        public void dEy() {
            if (this.mZj != null) {
                this.mZj.removeMessages(4);
                this.mZj.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.mZj != null) {
                this.mZj.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nae.aN(this.mZU.ncF);
                dET();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.mYZ != null)) {
                    this.mYZ.gg(0L);
                }
                dET();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nae.aN(this.mZU.ncF);
                }
                if (this.mYZ != null) {
                    this.mYZ.dEw();
                    this.mYZ.gg(-this.mZU.ndh.ndm);
                }
            } else if (this.mYZ != null) {
                this.mYZ.dEx();
                this.mYZ.gg(0L);
            }
        }
        if (this.naB != null && this.mYZ != null) {
            this.mYZ.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.naB.dEQ();
                }
            });
            return true;
        }
        return true;
    }
}
