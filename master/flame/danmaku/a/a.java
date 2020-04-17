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
    private int mYV;
    private C0796a mYW;
    private master.flame.danmaku.danmaku.model.f mYX;
    private final Object mYY;
    private int mYZ;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.mYV = 2;
        this.mYY = new Object();
        NativeBitmapFactory.dKB();
        this.mYV = i;
        if (NativeBitmapFactory.dKA()) {
            this.mYV = i * 2;
        }
        this.mYW = new C0796a(i, 3);
        this.naz.a(this.mYW);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.naA = fVar;
        this.mYX = new master.flame.danmaku.danmaku.model.f();
        this.mYX.gp(fVar.nbs);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.mYW != null) {
            this.mYW.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void wt(boolean z) {
        super.wt(z);
        if (this.mYW != null) {
            this.mYW.dEz();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.mYW != null) {
            int i = this.mYZ + 1;
            this.mYZ = i;
            if (i > 5) {
                this.mYW.dEB();
                this.mYZ = 0;
                return;
            }
            return;
        }
        n<?> dFj = dVar.dFj();
        if (dFj != null) {
            if (dFj.dFK()) {
                dFj.dFL();
            } else {
                dFj.destroy();
            }
            dVar.nbh = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.mYY) {
            this.mYY.notify();
        }
        if (a != null && this.mYW != null && a.ned - a.nee < -20) {
            this.mYW.dEB();
            this.mYW.gg(-this.mZR.nde.ndj);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.mYW == null) {
            start();
        }
        this.mYW.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.dKB();
        if (this.mYW == null) {
            this.mYW = new C0796a(this.mYV, 3);
            this.mYW.dEt();
            this.naz.a(this.mYW);
            return;
        }
        this.mYW.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.naz.a((k) null);
        if (this.mYW != null) {
            this.mYW.end();
            this.mYW = null;
        }
        NativeBitmapFactory.dKC();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.mZX == null) {
            throw new AssertionError();
        }
        b(this.mZX);
        this.mYW.dEt();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Jk(int i) {
        super.Jk(i);
        if (this.mYW != null) {
            this.mYW.Jk(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void h(long j, long j2, long j3) {
        super.h(j, j2, j3);
        if (this.mYW != null) {
            this.mYW.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0796a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int mZf;
        private HandlerC0797a mZg;
        master.flame.danmaku.danmaku.model.android.d mZb = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g mZc = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> mZd = master.flame.danmaku.danmaku.model.a.e.a(this.mZc, 800);
        private boolean mZh = false;
        private int mZe = 0;

        public C0796a(int i, int i2) {
            this.mZf = 3;
            this.mMaxSize = i;
            this.mZf = i2;
        }

        public void seek(long j) {
            if (this.mZg != null) {
                this.mZg.dEE();
                this.mZg.removeMessages(3);
                this.mZg.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.mZg != null) {
                if (dVar.nbi) {
                    if (dVar.nbj) {
                        if (!dVar.isTimeOut()) {
                            this.mZg.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.mZg.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.mZg.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void dEt() {
            this.mZh = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.mZg == null) {
                this.mZg = new HandlerC0797a(this.mThread.getLooper());
            }
            this.mZg.dEt();
        }

        public void end() {
            this.mZh = true;
            synchronized (a.this.mYY) {
                a.this.mYY.notifyAll();
            }
            if (this.mZg != null) {
                this.mZg.pause();
                this.mZg = null;
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
            if (this.mZg != null) {
                this.mZg.resume();
            } else {
                dEt();
            }
        }

        public void Jk(int i) {
            if (this.mZg != null) {
                this.mZg.ww(i == 1);
            }
        }

        public float dEu() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.mZe / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.mZb != null) {
                this.mZb.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                        C0796a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.mZb.clear();
            }
            this.mZe = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dEv() {
            wu(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wu(final boolean z) {
            if (this.mZb != null) {
                this.mZb.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.nbh;
                        boolean z2 = nVar != null && nVar.dFK();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0796a.this.mZe -= nVar.size();
                                nVar.destroy();
                            }
                            C0796a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.dFk()) {
                            C0796a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                });
            }
        }

        protected void a(boolean z, master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            n<?> dFj = dVar.dFj();
            if (dFj != null) {
                long c = c(dVar);
                if (dVar.isTimeOut()) {
                    a.this.mZR.dFR().dFh().t(dVar);
                }
                if (c > 0) {
                    this.mZe = (int) (this.mZe - c);
                    this.mZd.c((master.flame.danmaku.danmaku.model.android.e) dFj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.nbh;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.dFK()) {
                nVar.dFL();
                dVar.nbh = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.nbh = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.nbh != null && !dVar.nbh.dFK()) {
                    return dVar.nbh.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dEw() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e dGi = this.mZd.dGi();
                if (dGi != null) {
                    dGi.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d dFB = this.mZb.dFB();
            while (true) {
                if (this.mZe + i <= this.mMaxSize || dFB == null) {
                    break;
                } else if (dFB.isTimeOut()) {
                    a(false, dFB, dVar);
                    this.mZb.l(dFB);
                    dFB = this.mZb.dFB();
                } else if (!z) {
                    return false;
                }
            }
            this.mZb.k(dVar);
            this.mZe += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dEx() {
            this.mZb.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.isTimeOut()) {
                        synchronized (a.this.mYY) {
                            try {
                                a.this.mYY.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        C0796a.this.a(false, dVar, (master.flame.danmaku.danmaku.model.d) null);
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
                i2 = a.this.nab.dFG() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d mZk;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: dEC */
                public master.flame.danmaku.danmaku.model.d dED() {
                    return this.mZk;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bE(master.flame.danmaku.danmaku.model.d dVar2) {
                    int i3 = this.count;
                    this.count = i3 + 1;
                    if (i3 >= i) {
                        return 1;
                    }
                    n<?> dFj = dVar2.dFj();
                    if (dFj == null || dFj.get() == null) {
                        return 0;
                    }
                    if (dVar2.nba == dVar.nba && dVar2.nbb == dVar.nbb && dVar2.naY == dVar.naY && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.mZk = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.isTimeOut()) {
                            if (dFj.dFK()) {
                                return 0;
                            }
                            float width = dFj.width() - dVar.nba;
                            float height = dFj.height() - dVar.nbb;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.mZk = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.mZb.b(bVar);
            return bVar.dED();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class HandlerC0797a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean mZp;
            private boolean mZq;

            public HandlerC0797a(Looper looper) {
                super(looper);
            }

            public void dEE() {
                this.mZq = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0796a.this.dEv();
                        for (int i = 0; i < 300; i++) {
                            C0796a.this.mZd.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.nay == null || a.this.naE) || this.mZp;
                        wv(z);
                        if (z) {
                            this.mZp = false;
                        }
                        if (a.this.nay != null && !a.this.naE) {
                            a.this.nay.dER();
                            a.this.naE = true;
                            return;
                        }
                        return;
                    case 4:
                        C0796a.this.dEx();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.mYX.nbs;
                            a.this.mYX.gp(longValue);
                            this.mZp = true;
                            long dEy = C0796a.this.dEy();
                            if (longValue > j || dEy - longValue > a.this.mZR.nde.ndj) {
                                C0796a.this.dEv();
                            } else {
                                C0796a.this.dEx();
                            }
                            wv(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0796a.this.evictAll();
                        C0796a.this.dEw();
                        getLooper().quit();
                        return;
                    case 7:
                        C0796a.this.evictAll();
                        a.this.mYX.gp(a.this.naA.nbs - a.this.mZR.nde.ndj);
                        this.mZp = true;
                        return;
                    case 8:
                        C0796a.this.wu(true);
                        a.this.mYX.gp(a.this.naA.nbs);
                        return;
                    case 9:
                        C0796a.this.wu(true);
                        a.this.mYX.gp(a.this.naA.nbs);
                        a.this.dEW();
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
                            n<?> dFj = dVar.dFj();
                            if (!((dVar.nbp & 1) != 0) && dFj != null && dFj.get() != null && !dFj.dFK()) {
                                dVar.nbh = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nab, (master.flame.danmaku.danmaku.model.android.e) dVar.nbh);
                                C0796a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.nbi) {
                                C0796a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (dFj != null && dFj.dFK()) {
                                    dFj.destroy();
                                }
                                C0796a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.isTimeOut()) {
                            f(dVar2);
                            if (dVar2.nbh != null) {
                                C0796a.this.a(dVar2, dVar2.nbh.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.mZq = false;
                        return;
                }
                long dEF = dEF();
                if (dEF <= 0) {
                    dEF = a.this.mZR.nde.ndj / 2;
                }
                sendEmptyMessageDelayed(16, dEF);
            }

            private long dEF() {
                if (a.this.mYX.nbs <= a.this.naA.nbs - a.this.mZR.nde.ndj) {
                    C0796a.this.dEv();
                    a.this.mYX.gp(a.this.naA.nbs);
                    sendEmptyMessage(3);
                } else {
                    float dEu = C0796a.this.dEu();
                    master.flame.danmaku.danmaku.model.d dFB = C0796a.this.mZb.dFB();
                    long dFt = dFB != null ? dFB.dFt() - a.this.naA.nbs : 0L;
                    long j = a.this.mZR.nde.ndj * 2;
                    if (dEu < 0.6f && dFt > a.this.mZR.nde.ndj) {
                        a.this.mYX.gp(a.this.naA.nbs);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (dEu > 0.4f && dFt < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (dEu < 0.9f) {
                        long j2 = a.this.mYX.nbs - a.this.naA.nbs;
                        if (dFB != null && dFB.isTimeOut() && j2 < (-a.this.mZR.nde.ndj)) {
                            a.this.mYX.gp(a.this.naA.nbs);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.nbh : eVar;
                dVar.nbh = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0796a.this.mZd.c(eVar2);
                }
            }

            private void dEG() {
                l lVar = null;
                try {
                    long j = a.this.naA.nbs;
                    lVar = a.this.nax.O(j - a.this.mZR.nde.ndj, (a.this.mZR.nde.ndj * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0797a.this.mPause || HandlerC0797a.this.mZq) {
                                return 1;
                            }
                            if (!dVar.dFm()) {
                                a.this.mZR.ndd.a(dVar, 0, 0, null, true, a.this.mZR);
                            }
                            if (dVar.dFn()) {
                                return 0;
                            }
                            if (!dVar.dFi()) {
                                dVar.a((m) a.this.nab, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.nab, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.mZi.mZa.mYX.gp(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long wv(final boolean z) {
                l lVar;
                dEG();
                final long j = a.this.mYX.nbs;
                long j2 = j + (a.this.mZR.nde.ndj * C0796a.this.mZf);
                if (j2 < a.this.naA.nbs) {
                    return 0L;
                }
                final long dGq = master.flame.danmaku.danmaku.c.c.dGq();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.nax.O(j, j2);
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
                master.flame.danmaku.danmaku.model.d dFB = lVar.dFB();
                final master.flame.danmaku.danmaku.model.d dFC = lVar.dFC();
                if (dFB == null || dFC == null) {
                    a.this.mYX.gp(j2);
                    return 0L;
                }
                long dFt = dFB.dFt() - a.this.naA.nbs;
                final long min = Math.min(100L, dFt < 0 ? 30L : ((dFt * 10) / a.this.mZR.nde.ndj) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int mZs = 0;
                    int mZt = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bE(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0797a.this.mPause || HandlerC0797a.this.mZq || dFC.dFt() < a.this.naA.nbs) {
                            return 1;
                        }
                        n<?> dFj = dVar2.dFj();
                        if (dFj == null || dFj.get() == null) {
                            if (z || (!dVar2.isTimeOut() && dVar2.dFk())) {
                                if (!dVar2.dFm()) {
                                    a.this.mZR.ndd.a(dVar2, this.mZs, size, null, true, a.this.mZR);
                                }
                                if (dVar2.naZ == 0 && dVar2.dFn()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int dFt2 = (int) ((dVar2.dFt() - j) / a.this.mZR.nde.ndj);
                                    if (this.mZt == dFt2) {
                                        this.mZs++;
                                    } else {
                                        this.mZs = 0;
                                        this.mZt = dFt2;
                                    }
                                }
                                if (!z && !HandlerC0797a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.mYY) {
                                            a.this.mYY.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0797a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long dGq2 = master.flame.danmaku.danmaku.c.c.dGq() - dGq;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.mZR.nde;
                                        if (dGq2 >= 10000 * C0796a.this.mZf) {
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
                long dGq2 = master.flame.danmaku.danmaku.c.c.dGq() - dGq;
                if (0 != 0) {
                    a.this.mYX.gp(dVar.dFt());
                    return dGq2;
                }
                a.this.mYX.gp(j2);
                return dGq2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.dFi()) {
                    dVar.a((m) a.this.nab, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nab, C0796a.this.mZd.dGi());
                        dVar.nbh = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0796a.this.mZd.c(eVar);
                        }
                        dVar.nbh = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0796a.this.mZd.c(eVar);
                        }
                        dVar.nbh = null;
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
                if (!dVar.dFi()) {
                    dVar.a((m) a.this.nab, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0796a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.nbh : null;
                        try {
                            if (r3 != null) {
                                r3.dGd();
                                dVar.nbh = r3;
                                a.this.mYW.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0796a c0796a = C0796a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0796a.a(dVar, false, 50);
                            eVar = c0796a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.nbh;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.nbh = null;
                                    dVar.nbh = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nab, r3);
                                    a.this.mYW.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.dO((int) dVar.nba, (int) dVar.nbb) + C0796a.this.mZe <= C0796a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.nab, C0796a.this.mZd.dGi());
                                    dVar.nbh = a3;
                                    boolean a4 = a.this.mYW.a(dVar, C0796a.this.d(dVar), z);
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
                    if (dVar.dFt() <= a.this.mYX.nbs + a.this.mZR.nde.ndj || dVar.nbi) {
                        if (dVar.naZ != 0 || !dVar.dFn()) {
                            n<?> dFj = dVar.dFj();
                            if (dFj == null || dFj.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void dEt() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.mZR.nde.ndj);
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
                sendEmptyMessageDelayed(4, a.this.mZR.nde.ndj);
            }

            public void gh(long j) {
                removeMessages(3);
                this.mZp = true;
                sendEmptyMessage(19);
                a.this.mYX.gp(a.this.naA.nbs + j);
                sendEmptyMessage(3);
            }

            public void ww(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long dEy() {
            master.flame.danmaku.danmaku.model.d dFB;
            if (this.mZb == null || this.mZb.size() <= 0 || (dFB = this.mZb.dFB()) == null) {
                return 0L;
            }
            return dFB.dFt();
        }

        public void gg(long j) {
            if (this.mZg != null) {
                this.mZg.gh(j);
            }
        }

        public void dEz() {
            if (this.mZg != null) {
                this.mZg.removeMessages(3);
                this.mZg.removeMessages(19);
                this.mZg.dEE();
                this.mZg.removeMessages(7);
                this.mZg.sendEmptyMessage(7);
            }
        }

        public void dEA() {
            if (this.mZg != null) {
                this.mZg.removeMessages(9);
                this.mZg.sendEmptyMessage(9);
            }
        }

        public void dEB() {
            if (this.mZg != null) {
                this.mZg.removeMessages(4);
                this.mZg.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.mZg != null) {
                this.mZg.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.nab.aN(this.mZR.ncC);
                dEW();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.mYW != null)) {
                    this.mYW.gg(0L);
                }
                dEW();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.nab.aN(this.mZR.ncC);
                }
                if (this.mYW != null) {
                    this.mYW.dEz();
                    this.mYW.gg(-this.mZR.nde.ndj);
                }
            } else if (this.mYW != null) {
                this.mYW.dEA();
                this.mYW.gg(0L);
            }
        }
        if (this.nay != null && this.mYW != null) {
            this.mYW.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.nay.dET();
                }
            });
            return true;
        }
        return true;
    }
}
