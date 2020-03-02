package master.flame.danmaku.a;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import java.util.LinkedList;
import master.flame.danmaku.a.h;
import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.l;
import tv.cjump.jni.DeviceUtils;
/* loaded from: classes5.dex */
public class c extends Handler {
    private boolean mReady;
    public h nEA;
    private g nEB;
    private boolean nEC;
    private master.flame.danmaku.danmaku.model.b nED;
    private final a.b nEE;
    private LinkedList<Long> nEF;
    private i nEG;
    private final boolean nEH;
    private long nEI;
    private long nEJ;
    private long nEK;
    private long nEL;
    private long nEM;
    private boolean nEN;
    private long nEO;
    private long nEP;
    private boolean nEQ;
    private boolean nER;
    private boolean nES;
    private DanmakuContext nEt;
    private long nEu;
    private boolean nEv;
    private long nEw;
    private a nEx;
    private master.flame.danmaku.danmaku.model.f nEy;
    private master.flame.danmaku.danmaku.a.a nEz;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dLt();

        void dLu();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nEu = 0L;
        this.nEv = true;
        this.nEy = new master.flame.danmaku.danmaku.model.f();
        this.nEC = true;
        this.nEE = new a.b();
        this.nEF = new LinkedList<>();
        this.nEI = 30L;
        this.nEJ = 60L;
        this.nEK = 16L;
        this.nEH = Runtime.getRuntime().availableProcessors() > 3;
        this.nES = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            i((Long) null);
        } else {
            wK(false);
        }
        this.nEC = z;
    }

    private void a(g gVar) {
        this.nEB = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nEt = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nEz = aVar;
    }

    public void setCallback(a aVar) {
        this.nEx = aVar;
    }

    public void quit() {
        this.nEv = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nEv;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019c  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        Long l;
        boolean z;
        int i = message.what;
        switch (i) {
            case 1:
                l = (Long) message.obj;
                if (l == null) {
                    this.nEu = l.longValue();
                } else {
                    this.nEu = 0L;
                }
                if (i == 4) {
                    this.nEv = true;
                    dLh();
                    Long l2 = (Long) message.obj;
                    this.nEw -= l2.longValue() - this.nEy.nFT;
                    this.nEy.hn(l2.longValue());
                    this.nEt.nHB.dLV();
                    if (this.nEA != null) {
                        this.nEA.seek(l2.longValue());
                    }
                    this.nEu = l2.longValue();
                }
                removeMessages(7);
                this.nEv = false;
                if (!this.mReady) {
                    this.nEE.reset();
                    this.nEF.clear();
                    this.nEw = master.flame.danmaku.danmaku.c.c.dMP() - this.nEu;
                    this.nEy.hn(this.nEu);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nEA.start();
                    dLn();
                    this.nEN = false;
                    if (this.nEA != null) {
                        this.nEA.NK(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nEH) {
                    dLj();
                    return;
                } else {
                    dLi();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nEv = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nEv = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nEw = master.flame.danmaku.danmaku.c.c.dMP();
                if (this.nEz == null || !this.nEB.dLy()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    G(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nEu = 0L;
                            c.this.mReady = true;
                            if (c.this.nEx != null) {
                                c.this.nEx.dLt();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nEv = true;
                dLk();
                this.nEu = this.nEy.nFT;
                if (this.nEG != null) {
                    dLn();
                    dLh();
                }
                if (i == 6) {
                    if (this.nEA != null) {
                        this.nEA.quit();
                    }
                    if (this.nEz != null) {
                        this.nEz.release();
                    }
                    if (getLooper() != Looper.getMainLooper()) {
                        getLooper().quit();
                        return;
                    }
                    return;
                }
                return;
            case 7:
                removeMessages(3);
                removeMessages(2);
                if (this.nEA != null) {
                    this.nEA.NK(2);
                }
                if (i == 6) {
                }
                this.nEv = true;
                dLk();
                this.nEu = this.nEy.nFT;
                if (this.nEG != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nEC = true;
                Long l3 = (Long) message.obj;
                if (this.nEA == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nEy.hn(getCurrentTime());
                    this.nEA.dLv();
                    z = false;
                } else {
                    this.nEA.start();
                    this.nEA.seek(l3.longValue());
                    this.nEA.dLv();
                    z = true;
                }
                if (this.nEv && this.nEB != null) {
                    this.nEB.dLz();
                }
                dLn();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nEv = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nEC = false;
                if (this.nEB != null) {
                    this.nEB.clear();
                }
                if (this.nEA != null) {
                    this.nEA.dLv();
                    this.nEA.dLx();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nEA != null) {
                    this.nEA.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nEA != null) {
                }
                if (i == 6) {
                }
                this.nEv = true;
                dLk();
                this.nEu = this.nEy.nFT;
                if (this.nEG != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nEt.nHD.b(this.nEt);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nEt.nHB.dLV();
                    this.nEt.nHB.dLU();
                    this.nEA.dLw();
                    return;
                }
                return;
            case 11:
                dLn();
                return;
            case 12:
                if (this.nEv && this.nEB != null) {
                    this.nEA.dLv();
                    this.nEB.dLz();
                    dLn();
                    return;
                }
                return;
            case 13:
                if (this.nEA != null) {
                    this.nEA.hj(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dLh() {
        if (this.nEG != null) {
            i iVar = this.nEG;
            this.nEG = null;
            synchronized (this.nEA) {
                this.nEA.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dLi() {
        if (!this.nEv) {
            long hg = hg(master.flame.danmaku.danmaku.c.c.dMP());
            if (hg < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - hg);
                return;
            }
            long dLz = this.nEB.dLz();
            removeMessages(2);
            if (dLz > this.nEJ) {
                this.nEy.ho(dLz);
                this.nEF.clear();
            }
            if (!this.nEC) {
                hh(10000000L);
                return;
            }
            if (this.nEE.nIF && this.nES) {
                long j = this.nEE.endTime - this.nEy.nFT;
                if (j > 500) {
                    hh(j - 10);
                    return;
                }
            }
            if (dLz < this.nEK) {
                sendEmptyMessageDelayed(2, this.nEK - dLz);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dLj() {
        if (this.nEG == null) {
            this.nEG = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dMP = master.flame.danmaku.danmaku.c.c.dMP();
                    while (!dLB() && !c.this.nEv) {
                        long dMP2 = master.flame.danmaku.danmaku.c.c.dMP();
                        if (c.this.nEK - (master.flame.danmaku.danmaku.c.c.dMP() - dMP) <= 1) {
                            long hg = c.this.hg(dMP2);
                            if (hg >= 0) {
                                long dLz = c.this.nEB.dLz();
                                if (dLz > c.this.nEJ) {
                                    c.this.nEy.ho(dLz);
                                    c.this.nEF.clear();
                                }
                                if (!c.this.nEC) {
                                    c.this.hh(10000000L);
                                } else if (c.this.nEE.nIF && c.this.nES) {
                                    long j = c.this.nEE.endTime - c.this.nEy.nFT;
                                    if (j > 500) {
                                        c.this.dLn();
                                        c.this.hh(j - 10);
                                    }
                                }
                                dMP = dMP2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.hp(60 - hg);
                                dMP = dMP2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.hp(1L);
                        }
                    }
                }
            };
            this.nEG.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long hg(long j) {
        long j2;
        long j3 = 0;
        if (this.nEN || this.nEQ) {
            return 0L;
        }
        this.nEQ = true;
        long j4 = j - this.nEw;
        if (!this.nEC || this.nEE.nIF || this.nER) {
            this.nEy.hn(j4);
            this.nEP = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nEy.nFT;
            long max = Math.max(this.nEK, dLo());
            if (j2 <= 2000 && this.nEE.nIE <= this.nEI && max <= this.nEI) {
                long min = Math.min(this.nEI, Math.max(this.nEK, (j2 / this.nEK) + max));
                long j5 = min - this.nEM;
                if (j5 > 3 && j5 < 8 && this.nEM >= this.nEK && this.nEM <= this.nEI) {
                    min = this.nEM;
                }
                long j6 = j2 - min;
                this.nEM = min;
                j2 = min;
                j3 = j6;
            }
            this.nEP = j3;
            this.nEy.ho(j2);
        }
        if (this.nEx != null) {
            this.nEx.b(this.nEy);
        }
        this.nEQ = false;
        return j2;
    }

    private void dLk() {
        if (this.nER) {
            hg(master.flame.danmaku.danmaku.c.c.dMP());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLl() {
        this.nEI = Math.max(33L, ((float) 16) * 2.5f);
        this.nEJ = ((float) this.nEI) * 2.5f;
        this.nEK = Math.max(16L, (16 / 15) * 15);
        this.nEL = this.nEK + 3;
    }

    private void G(final Runnable runnable) {
        if (this.nEA == null) {
            this.nEA = a(this.nEB.dLA(), this.nEy, this.nEB.getContext(), this.nEB.getWidth(), this.nEB.getHeight(), this.nEB.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dLq() {
                    c.this.dLl();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dLS = dVar.dLS() - c.this.getCurrentTime();
                        if (dLS < c.this.nEt.nHD.nHI && (c.this.nER || c.this.nEE.nIF)) {
                            c.this.dLn();
                        } else if (dLS > 0 && dLS <= c.this.nEt.nHD.nHI) {
                            c.this.sendEmptyMessageDelayed(11, dLS);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nEx != null) {
                        c.this.nEx.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dLr() {
                    if (c.this.nEx != null) {
                        c.this.nEx.dLu();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dLs() {
                    c.this.dLm();
                }
            });
        } else {
            runnable.run();
        }
    }

    public boolean isPrepared() {
        return this.mReady;
    }

    private h a(boolean z, master.flame.danmaku.danmaku.model.f fVar, Context context, int i, int i2, boolean z2, h.a aVar) {
        this.nED = this.nEt.dMq();
        this.nED.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nED.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nED.bG(this.nEt.nHb);
        this.nED.wM(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nEt, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nEt, aVar);
        aVar2.a(this.nEz);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nEA != null) {
            dVar.nFP = this.nEt.nHB;
            dVar.c(this.nEy);
            this.nEA.a(dVar);
            obtainMessage(11).sendToTarget();
        }
    }

    public void resume() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    public void prepare() {
        this.mReady = false;
        sendEmptyMessage(5);
    }

    public void pause() {
        removeMessages(3);
        dLk();
        sendEmptyMessage(7);
    }

    public void i(Long l) {
        if (!this.nEC) {
            this.nEC = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wK(boolean z) {
        if (!this.nEC) {
            return this.nEy.nFT;
        }
        this.nEC = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nEy.nFT;
    }

    public a.b ak(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dLF;
        if (this.nEA == null) {
            return this.nEE;
        }
        if (!this.nER && (aVar = this.nEt.nHp) != null && ((dLF = aVar.dLF()) || this.nEv)) {
            int dLD = aVar.dLD();
            if (dLD == 2) {
                long j = this.nEy.nFT;
                long dLC = aVar.dLC();
                long j2 = dLC - j;
                if (Math.abs(j2) > aVar.dLE()) {
                    if (dLF && this.nEv) {
                        resume();
                    }
                    this.nEA.m(j, dLC, j2);
                    this.nEy.hn(dLC);
                    this.nEw = master.flame.danmaku.danmaku.c.c.dMP() - dLC;
                    this.nEP = 0L;
                }
            } else if (dLD == 1 && dLF && !this.nEv) {
                pause();
            }
        }
        this.nED.setExtraData(canvas);
        this.nEE.b(this.nEA.a(this.nED));
        dLp();
        return this.nEE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLm() {
        if (this.nEv && this.nEC) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLn() {
        if (this.nER) {
            if (this.nEA != null) {
                this.nEA.dLv();
            }
            if (this.nEH) {
                synchronized (this) {
                    this.nEF.clear();
                }
                synchronized (this.nEA) {
                    this.nEA.notifyAll();
                }
            } else {
                this.nEF.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nER = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh(long j) {
        if (!isStop() && isPrepared() && !this.nEN) {
            this.nEE.ezR = master.flame.danmaku.danmaku.c.c.dMP();
            this.nER = true;
            if (this.nEH) {
                if (this.nEG != null) {
                    try {
                        synchronized (this.nEA) {
                            if (j == 10000000) {
                                this.nEA.wait();
                            } else {
                                this.nEA.wait(j);
                            }
                            sendEmptyMessage(11);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (j == 10000000) {
                removeMessages(11);
                removeMessages(2);
            } else {
                removeMessages(11);
                removeMessages(2);
                sendEmptyMessageDelayed(11, j);
            }
        }
    }

    private synchronized long dLo() {
        long longValue;
        int size = this.nEF.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nEF.peekFirst();
            Long peekLast = this.nEF.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dLp() {
        this.nEF.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dMP()));
        if (this.nEF.size() > 500) {
            this.nEF.removeFirst();
        }
    }

    public void eA(int i, int i2) {
        if (this.nED != null) {
            if (this.nED.getWidth() != i || this.nED.getHeight() != i2) {
                this.nED.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wG(boolean z) {
        if (this.nEA != null) {
            this.nEA.wG(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nEA != null) {
            return this.nEA.hi(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nEN) {
            return this.nEO;
        }
        if (this.nEv || !this.nER) {
            return this.nEy.nFT - this.nEP;
        }
        return master.flame.danmaku.danmaku.c.c.dMP() - this.nEw;
    }

    public DanmakuContext getConfig() {
        return this.nEt;
    }
}
