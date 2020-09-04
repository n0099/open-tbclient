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
    private int oub;
    private C0973a ouc;
    private master.flame.danmaku.danmaku.model.f oud;
    private final Object oue;
    private int ouf;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar, int i) {
        super(fVar, danmakuContext, aVar);
        this.oub = 2;
        this.oue = new Object();
        NativeBitmapFactory.emZ();
        this.oub = i;
        if (NativeBitmapFactory.emY()) {
            this.oub = i * 2;
        }
        this.ouc = new C0973a(i, 3);
        this.ovG.a(this.ouc);
    }

    @Override // master.flame.danmaku.a.e
    protected void a(master.flame.danmaku.danmaku.model.f fVar) {
        this.ovH = fVar;
        this.oud = new master.flame.danmaku.danmaku.model.f();
        this.oud.gX(fVar.owx);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        if (this.ouc != null) {
            this.ouc.a(dVar);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void yN(boolean z) {
        super.yN(z);
        if (this.ouc != null) {
            this.ouc.egW();
        }
    }

    @Override // master.flame.danmaku.a.e
    protected void b(master.flame.danmaku.danmaku.model.d dVar) {
        super.b(dVar);
        if (this.ouc != null) {
            int i = this.ouf + 1;
            this.ouf = i;
            if (i > 5) {
                this.ouc.egY();
                this.ouf = 0;
                return;
            }
            return;
        }
        n<?> ehG = dVar.ehG();
        if (ehG != null) {
            if (ehG.eii()) {
                ehG.eij();
            } else {
                ehG.destroy();
            }
            dVar.own = null;
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public a.b a(master.flame.danmaku.danmaku.model.b bVar) {
        a.b a = super.a(bVar);
        synchronized (this.oue) {
            this.oue.notify();
        }
        if (a != null && this.ouc != null && a.ozh - a.ozi < -20) {
            this.ouc.egY();
            this.ouc.gO(-this.ouY.oyj.oyo);
        }
        return a;
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void seek(long j) {
        super.seek(j);
        if (this.ouc == null) {
            start();
        }
        this.ouc.seek(j);
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void start() {
        super.start();
        NativeBitmapFactory.emZ();
        if (this.ouc == null) {
            this.ouc = new C0973a(this.oub, 3);
            this.ouc.egQ();
            this.ovG.a(this.ouc);
            return;
        }
        this.ouc.resume();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void quit() {
        super.quit();
        reset();
        this.ovG.a((k) null);
        if (this.ouc != null) {
            this.ouc.end();
            this.ouc = null;
        }
        NativeBitmapFactory.ena();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void prepare() {
        if (!$assertionsDisabled && this.ove == null) {
            throw new AssertionError();
        }
        b(this.ove);
        this.ouc.egQ();
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void Ob(int i) {
        super.Ob(i);
        if (this.ouc != null) {
            this.ouc.Ob(i);
        }
    }

    @Override // master.flame.danmaku.a.e, master.flame.danmaku.a.h
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        if (this.ouc != null) {
            this.ouc.seek(j2);
        }
    }

    /* renamed from: master.flame.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0973a implements k {
        private int mMaxSize;
        public HandlerThread mThread;
        private int oul;
        private HandlerC0974a oum;
        master.flame.danmaku.danmaku.model.android.d ouh = new master.flame.danmaku.danmaku.model.android.d();
        master.flame.danmaku.danmaku.model.android.g oui = new master.flame.danmaku.danmaku.model.android.g();
        master.flame.danmaku.danmaku.model.a.b<master.flame.danmaku.danmaku.model.android.e> ouj = master.flame.danmaku.danmaku.model.a.e.a(this.oui, 800);
        private boolean oun = false;
        private int ouk = 0;

        public C0973a(int i, int i2) {
            this.oul = 3;
            this.mMaxSize = i;
            this.oul = i2;
        }

        public void seek(long j) {
            if (this.oum != null) {
                this.oum.ehb();
                this.oum.removeMessages(3);
                this.oum.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        @Override // master.flame.danmaku.danmaku.model.k
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            if (this.oum != null) {
                if (dVar.kkN) {
                    if (dVar.owo) {
                        if (!dVar.ehH()) {
                            this.oum.f(dVar);
                            return;
                        }
                        return;
                    }
                    this.oum.obtainMessage(18, dVar).sendToTarget();
                    return;
                }
                this.oum.obtainMessage(2, dVar).sendToTarget();
            }
        }

        public void egQ() {
            this.oun = false;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("DFM Cache-Building Thread");
                this.mThread.start();
            }
            if (this.oum == null) {
                this.oum = new HandlerC0974a(this.mThread.getLooper());
            }
            this.oum.egQ();
        }

        public void end() {
            this.oun = true;
            synchronized (a.this.oue) {
                a.this.oue.notifyAll();
            }
            if (this.oum != null) {
                this.oum.pause();
                this.oum = null;
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
            if (this.oum != null) {
                this.oum.resume();
            } else {
                egQ();
            }
        }

        public void Ob(int i) {
            if (this.oum != null) {
                this.oum.yQ(i == 1);
            }
        }

        public float egR() {
            if (this.mMaxSize == 0) {
                return 0.0f;
            }
            return this.ouk / this.mMaxSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            if (this.ouh != null) {
                this.ouh.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                        C0973a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                        return 0;
                    }
                });
                this.ouh.clear();
            }
            this.ouk = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egS() {
            yO(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void yO(final boolean z) {
            if (this.ouh != null) {
                this.ouh.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                        n<?> nVar = dVar.own;
                        boolean z2 = nVar != null && nVar.eii();
                        if (z && z2) {
                            if (nVar.get() != null) {
                                C0973a.this.ouk -= nVar.size();
                                nVar.destroy();
                            }
                            C0973a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                            return 2;
                        } else if (dVar.ehI()) {
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
            n<?> ehG = dVar.ehG();
            if (ehG != null) {
                long c = c(dVar);
                if (dVar.ehH()) {
                    a.this.ouY.eip().ehE().t(dVar);
                }
                if (c > 0) {
                    this.ouk = (int) (this.ouk - c);
                    this.ouj.c((master.flame.danmaku.danmaku.model.android.e) ehG);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(master.flame.danmaku.danmaku.model.d dVar) {
            n<?> nVar = dVar.own;
            if (nVar == null) {
                return 0L;
            }
            if (nVar.eii()) {
                nVar.eij();
                dVar.own = null;
                return 0L;
            }
            long d = d(dVar);
            nVar.destroy();
            dVar.own = null;
            return d;
        }

        protected int d(master.flame.danmaku.danmaku.model.d dVar) {
            try {
                if (dVar.own != null && !dVar.own.eii()) {
                    return dVar.own.size();
                }
            } catch (Exception e) {
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egT() {
            while (true) {
                master.flame.danmaku.danmaku.model.android.e eiG = this.ouj.eiG();
                if (eiG != null) {
                    eiG.destroy();
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(master.flame.danmaku.danmaku.model.d dVar, int i, boolean z) {
            master.flame.danmaku.danmaku.model.d ehZ = this.ouh.ehZ();
            while (true) {
                if (this.ouk + i <= this.mMaxSize || ehZ == null) {
                    break;
                } else if (ehZ.ehH()) {
                    a(false, ehZ, dVar);
                    this.ouh.l(ehZ);
                    ehZ = this.ouh.ehZ();
                } else if (!z) {
                    return false;
                }
            }
            this.ouh.k(dVar);
            this.ouk += i;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void egU() {
            this.ouh.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: e */
                public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                    int i = 1;
                    if (dVar.ehH()) {
                        synchronized (a.this.oue) {
                            try {
                                a.this.oue.wait(30L);
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
                i2 = a.this.ovi.eie() * 2;
            }
            l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d> bVar = new l.b<master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.4
                int count = 0;
                master.flame.danmaku.danmaku.model.d ouq;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // master.flame.danmaku.danmaku.model.l.b
                /* renamed from: egZ */
                public master.flame.danmaku.danmaku.model.d eha() {
                    return this.ouq;
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
                    n<?> ehG = dVar2.ehG();
                    if (ehG == null || ehG.get() == null) {
                        return 0;
                    }
                    if (dVar2.owg == dVar.owg && dVar2.owh == dVar.owh && dVar2.underlineColor == dVar.underlineColor && dVar2.borderColor == dVar.borderColor && dVar2.textColor == dVar.textColor && dVar2.text.equals(dVar.text) && dVar2.tag == dVar.tag) {
                        this.ouq = dVar2;
                        return 1;
                    } else if (z) {
                        return 0;
                    } else {
                        if (dVar2.ehH()) {
                            if (ehG.eii()) {
                                return 0;
                            }
                            float width = ehG.width() - dVar.owg;
                            float height = ehG.height() - dVar.owh;
                            if (width < 0.0f || width > i2 || height < 0.0f || height > i2) {
                                return 0;
                            }
                            this.ouq = dVar2;
                            return 1;
                        }
                        return 1;
                    }
                }
            };
            this.ouh.b(bVar);
            return bVar.eha();
        }

        /* renamed from: master.flame.danmaku.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class HandlerC0974a extends Handler {
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean ouw;
            private boolean oux;

            public HandlerC0974a(Looper looper) {
                super(looper);
            }

            public void ehb() {
                this.oux = true;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0973a.this.egS();
                        for (int i = 0; i < 300; i++) {
                            C0973a.this.ouj.c(new master.flame.danmaku.danmaku.model.android.e());
                        }
                        break;
                    case 2:
                        g((master.flame.danmaku.danmaku.model.d) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        boolean z = !(a.this.ovF == null || a.this.ovL) || this.ouw;
                        yP(z);
                        if (z) {
                            this.ouw = false;
                        }
                        if (a.this.ovF != null && !a.this.ovL) {
                            a.this.ovF.eho();
                            a.this.ovL = true;
                            return;
                        }
                        return;
                    case 4:
                        C0973a.this.egU();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = a.this.oud.owx;
                            a.this.oud.gX(longValue);
                            this.ouw = true;
                            long egV = C0973a.this.egV();
                            if (longValue > j || egV - longValue > a.this.ouY.oyj.oyo) {
                                C0973a.this.egS();
                            } else {
                                C0973a.this.egU();
                            }
                            yP(true);
                            resume();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        C0973a.this.evictAll();
                        C0973a.this.egT();
                        getLooper().quit();
                        return;
                    case 7:
                        C0973a.this.evictAll();
                        a.this.oud.gX(a.this.ovH.owx - a.this.ouY.oyj.oyo);
                        this.ouw = true;
                        return;
                    case 8:
                        C0973a.this.yO(true);
                        a.this.oud.gX(a.this.ovH.owx);
                        return;
                    case 9:
                        C0973a.this.yO(true);
                        a.this.oud.gX(a.this.ovH.owx);
                        a.this.eht();
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
                            n<?> ehG = dVar.ehG();
                            if (!((dVar.owu & 1) != 0) && ehG != null && ehG.get() != null && !ehG.eii()) {
                                dVar.own = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.ovi, (master.flame.danmaku.danmaku.model.android.e) dVar.own);
                                C0973a.this.a(dVar, 0, true);
                                return;
                            } else if (dVar.kkN) {
                                C0973a.this.c(dVar);
                                f(dVar);
                                return;
                            } else {
                                if (ehG != null && ehG.eii()) {
                                    ehG.destroy();
                                }
                                C0973a.this.a(true, dVar, (master.flame.danmaku.danmaku.model.d) null);
                                g(dVar);
                                return;
                            }
                        }
                        return;
                    case 18:
                        master.flame.danmaku.danmaku.model.d dVar2 = (master.flame.danmaku.danmaku.model.d) message.obj;
                        if (!dVar2.ehH()) {
                            f(dVar2);
                            if (dVar2.own != null) {
                                C0973a.this.a(dVar2, dVar2.own.size(), true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        this.oux = false;
                        return;
                }
                long ehc = ehc();
                if (ehc <= 0) {
                    ehc = a.this.ouY.oyj.oyo / 2;
                }
                sendEmptyMessageDelayed(16, ehc);
            }

            private long ehc() {
                if (a.this.oud.owx <= a.this.ovH.owx - a.this.ouY.oyj.oyo) {
                    C0973a.this.egS();
                    a.this.oud.gX(a.this.ovH.owx);
                    sendEmptyMessage(3);
                } else {
                    float egR = C0973a.this.egR();
                    master.flame.danmaku.danmaku.model.d ehZ = C0973a.this.ouh.ehZ();
                    long ehR = ehZ != null ? ehZ.ehR() - a.this.ovH.owx : 0L;
                    long j = a.this.ouY.oyj.oyo * 2;
                    if (egR < 0.6f && ehR > a.this.ouY.oyj.oyo) {
                        a.this.oud.gX(a.this.ovH.owx);
                        removeMessages(3);
                        sendEmptyMessage(3);
                    } else if (egR > 0.4f && ehR < (-j)) {
                        removeMessages(4);
                        sendEmptyMessage(4);
                    } else if (egR < 0.9f) {
                        long j2 = a.this.oud.owx - a.this.ovH.owx;
                        if (ehZ != null && ehZ.ehH() && j2 < (-a.this.ouY.oyj.oyo)) {
                            a.this.oud.gX(a.this.ovH.owx);
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
                master.flame.danmaku.danmaku.model.android.e eVar2 = eVar == null ? (master.flame.danmaku.danmaku.model.android.e) dVar.own : eVar;
                dVar.own = null;
                if (eVar2 != null) {
                    eVar2.destroy();
                    C0973a.this.ouj.c(eVar2);
                }
            }

            private void ehd() {
                l lVar = null;
                try {
                    long j = a.this.ovH.owx;
                    lVar = a.this.ovE.S(j - a.this.ouY.oyj.oyo, (a.this.ouY.oyj.oyo * 2) + j);
                } catch (Exception e) {
                }
                if (lVar != null && !lVar.isEmpty()) {
                    lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // master.flame.danmaku.danmaku.model.l.b
                        /* renamed from: e */
                        public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                            if (HandlerC0974a.this.mPause || HandlerC0974a.this.oux) {
                                return 1;
                            }
                            if (!dVar.ehK()) {
                                a.this.ouY.oyi.a(dVar, 0, 0, null, true, a.this.ouY);
                            }
                            if (dVar.ehL()) {
                                return 0;
                            }
                            if (!dVar.ehF()) {
                                dVar.a((m) a.this.ovi, true);
                            }
                            if (dVar.isPrepared()) {
                                return 0;
                            }
                            dVar.b(a.this.ovi, true);
                            return 0;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r18.ouo.oug.oud.gX(r16);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private long yP(final boolean z) {
                l lVar;
                ehd();
                final long j = a.this.oud.owx;
                long j2 = j + (a.this.ouY.oyj.oyo * C0973a.this.oul);
                if (j2 < a.this.ovH.owx) {
                    return 0L;
                }
                final long eiO = master.flame.danmaku.danmaku.c.c.eiO();
                l lVar2 = null;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        lVar = a.this.ovE.S(j, j2);
                    } catch (Exception e) {
                        z2 = true;
                        master.flame.danmaku.danmaku.c.c.gZ(10L);
                        lVar = lVar2;
                    }
                    i++;
                    if (i >= 3 || lVar != null || !z2) {
                        break;
                    }
                    lVar2 = lVar;
                }
                master.flame.danmaku.danmaku.model.d ehZ = lVar.ehZ();
                final master.flame.danmaku.danmaku.model.d eia = lVar.eia();
                if (ehZ == null || eia == null) {
                    a.this.oud.gX(j2);
                    return 0L;
                }
                long ehR = ehZ.ehR() - a.this.ovH.owx;
                final long min = Math.min(100L, ehR < 0 ? 30L : ((ehR * 10) / a.this.ouY.oyj.oyo) + 30);
                if (z) {
                    min = 0;
                }
                master.flame.danmaku.danmaku.model.d dVar = null;
                final int size = lVar.size();
                lVar.b(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.a.a.a.a.2
                    int ouz = 0;
                    int ouA = 0;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // master.flame.danmaku.danmaku.model.l.b
                    /* renamed from: e */
                    public int bO(master.flame.danmaku.danmaku.model.d dVar2) {
                        if (HandlerC0974a.this.mPause || HandlerC0974a.this.oux || eia.ehR() < a.this.ovH.owx) {
                            return 1;
                        }
                        n<?> ehG = dVar2.ehG();
                        if (ehG == null || ehG.get() == null) {
                            if (z || (!dVar2.ehH() && dVar2.ehI())) {
                                if (!dVar2.ehK()) {
                                    a.this.ouY.oyi.a(dVar2, this.ouz, size, null, true, a.this.ouY);
                                }
                                if (dVar2.owf == 0 && dVar2.ehL()) {
                                    return 0;
                                }
                                if (dVar2.getType() == 1) {
                                    int ehR2 = (int) ((dVar2.ehR() - j) / a.this.ouY.oyj.oyo);
                                    if (this.ouA == ehR2) {
                                        this.ouz++;
                                    } else {
                                        this.ouz = 0;
                                        this.ouA = ehR2;
                                    }
                                }
                                if (!z && !HandlerC0974a.this.mIsPlayerPause) {
                                    try {
                                        synchronized (a.this.oue) {
                                            a.this.oue.wait(min);
                                        }
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                        return 1;
                                    }
                                }
                                if (HandlerC0974a.this.a(dVar2, false) != 1) {
                                    if (!z) {
                                        long eiO2 = master.flame.danmaku.danmaku.c.c.eiO() - eiO;
                                        master.flame.danmaku.danmaku.model.android.c cVar = a.this.ouY.oyj;
                                        if (eiO2 >= 10000 * C0973a.this.oul) {
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
                long eiO2 = master.flame.danmaku.danmaku.c.c.eiO() - eiO;
                if (0 != 0) {
                    a.this.oud.gX(dVar.ehR());
                    return eiO2;
                }
                a.this.oud.gX(j2);
                return eiO2;
            }

            public boolean f(master.flame.danmaku.danmaku.model.d dVar) {
                master.flame.danmaku.danmaku.model.android.e eVar;
                if (!dVar.ehF()) {
                    dVar.a((m) a.this.ovi, true);
                }
                try {
                    try {
                        eVar = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.ovi, C0973a.this.ouj.eiG());
                        dVar.own = eVar;
                        return true;
                    } catch (Exception e) {
                        if (eVar != null) {
                            C0973a.this.ouj.c(eVar);
                        }
                        dVar.own = null;
                        return false;
                    } catch (OutOfMemoryError e2) {
                        if (eVar != null) {
                            C0973a.this.ouj.c(eVar);
                        }
                        dVar.own = null;
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
                if (!dVar.ehF()) {
                    dVar.a((m) a.this.ovi, true);
                }
                try {
                    try {
                        master.flame.danmaku.danmaku.model.d a = C0973a.this.a(dVar, true, 20);
                        r3 = a != null ? (master.flame.danmaku.danmaku.model.android.e) a.own : null;
                        try {
                            if (r3 != null) {
                                r3.eiB();
                                dVar.own = r3;
                                a.this.ouc.a(dVar, 0, z);
                                return (byte) 0;
                            }
                            C0973a c0973a = C0973a.this;
                            master.flame.danmaku.danmaku.model.d a2 = c0973a.a(dVar, false, 50);
                            eVar = c0973a;
                            if (a2 != null) {
                                master.flame.danmaku.danmaku.model.android.e eVar2 = (master.flame.danmaku.danmaku.model.android.e) a2.own;
                                r3 = eVar2;
                                eVar = eVar2;
                            }
                            try {
                                if (r3 != null) {
                                    a2.own = null;
                                    dVar.own = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.ovi, r3);
                                    a.this.ouc.a(dVar, 0, z);
                                    return (byte) 0;
                                } else if (z || master.flame.danmaku.danmaku.c.b.em((int) dVar.owg, (int) dVar.owh) + C0973a.this.ouk <= C0973a.this.mMaxSize) {
                                    master.flame.danmaku.danmaku.model.android.e a3 = master.flame.danmaku.danmaku.c.b.a(dVar, a.this.ovi, C0973a.this.ouj.eiG());
                                    dVar.own = a3;
                                    boolean a4 = a.this.ouc.a(dVar, C0973a.this.d(dVar), z);
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
                if (!dVar.ehH()) {
                    if (dVar.ehR() <= a.this.oud.owx + a.this.ouY.oyj.oyo || dVar.kkN) {
                        if (dVar.owf != 0 || !dVar.ehL()) {
                            n<?> ehG = dVar.ehG();
                            if (ehG == null || ehG.get() == null) {
                                a(dVar, true);
                            }
                        }
                    }
                }
            }

            public void egQ() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, a.this.ouY.oyj.oyo);
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
                sendEmptyMessageDelayed(4, a.this.ouY.oyj.oyo);
            }

            public void gP(long j) {
                removeMessages(3);
                this.ouw = true;
                sendEmptyMessage(19);
                a.this.oud.gX(a.this.ovH.owx + j);
                sendEmptyMessage(3);
            }

            public void yQ(boolean z) {
                this.mIsPlayerPause = !z;
            }
        }

        public long egV() {
            master.flame.danmaku.danmaku.model.d ehZ;
            if (this.ouh == null || this.ouh.size() <= 0 || (ehZ = this.ouh.ehZ()) == null) {
                return 0L;
            }
            return ehZ.ehR();
        }

        public void gO(long j) {
            if (this.oum != null) {
                this.oum.gP(j);
            }
        }

        public void egW() {
            if (this.oum != null) {
                this.oum.removeMessages(3);
                this.oum.removeMessages(19);
                this.oum.ehb();
                this.oum.removeMessages(7);
                this.oum.sendEmptyMessage(7);
            }
        }

        public void egX() {
            if (this.oum != null) {
                this.oum.removeMessages(9);
                this.oum.sendEmptyMessage(9);
            }
        }

        public void egY() {
            if (this.oum != null) {
                this.oum.removeMessages(4);
                this.oum.sendEmptyMessage(4);
            }
        }

        public void post(Runnable runnable) {
            if (this.oum != null) {
                this.oum.post(runnable);
            }
        }
    }

    @Override // master.flame.danmaku.a.e
    public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        if (!super.b(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.ovi.aX(this.ouY.oxH);
                eht();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && this.ouc != null)) {
                    this.ouc.gO(0L);
                }
                eht();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.ovi.aX(this.ouY.oxH);
                }
                if (this.ouc != null) {
                    this.ouc.egW();
                    this.ouc.gO(-this.ouY.oyj.oyo);
                }
            } else if (this.ouc != null) {
                this.ouc.egX();
                this.ouc.gO(0L);
            }
        }
        if (this.ovF != null && this.ouc != null) {
            this.ouc.post(new Runnable() { // from class: master.flame.danmaku.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ovF.ehq();
                }
            });
            return true;
        }
        return true;
    }
}
