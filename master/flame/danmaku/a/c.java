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
    private boolean nGA;
    private master.flame.danmaku.danmaku.model.b nGB;
    private final a.b nGC;
    private LinkedList<Long> nGD;
    private i nGE;
    private final boolean nGF;
    private long nGG;
    private long nGH;
    private long nGI;
    private long nGJ;
    private long nGK;
    private boolean nGL;
    private long nGM;
    private long nGN;
    private boolean nGO;
    private boolean nGP;
    private boolean nGQ;
    private DanmakuContext nGr;
    private long nGs;
    private boolean nGt;
    private long nGu;
    private a nGv;
    private master.flame.danmaku.danmaku.model.f nGw;
    private master.flame.danmaku.danmaku.a.a nGx;
    public h nGy;
    private g nGz;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dLU();

        void dLV();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nGs = 0L;
        this.nGt = true;
        this.nGw = new master.flame.danmaku.danmaku.model.f();
        this.nGA = true;
        this.nGC = new a.b();
        this.nGD = new LinkedList<>();
        this.nGG = 30L;
        this.nGH = 60L;
        this.nGI = 16L;
        this.nGF = Runtime.getRuntime().availableProcessors() > 3;
        this.nGQ = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            i((Long) null);
        } else {
            wS(false);
        }
        this.nGA = z;
    }

    private void a(g gVar) {
        this.nGz = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nGr = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nGx = aVar;
    }

    public void setCallback(a aVar) {
        this.nGv = aVar;
    }

    public void quit() {
        this.nGt = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nGt;
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
                    this.nGs = l.longValue();
                } else {
                    this.nGs = 0L;
                }
                if (i == 4) {
                    this.nGt = true;
                    dLI();
                    Long l2 = (Long) message.obj;
                    this.nGu -= l2.longValue() - this.nGw.nHR;
                    this.nGw.ho(l2.longValue());
                    this.nGr.nJz.dMw();
                    if (this.nGy != null) {
                        this.nGy.seek(l2.longValue());
                    }
                    this.nGs = l2.longValue();
                }
                removeMessages(7);
                this.nGt = false;
                if (!this.mReady) {
                    this.nGC.reset();
                    this.nGD.clear();
                    this.nGu = master.flame.danmaku.danmaku.c.c.dNq() - this.nGs;
                    this.nGw.ho(this.nGs);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nGy.start();
                    dLO();
                    this.nGL = false;
                    if (this.nGy != null) {
                        this.nGy.NQ(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nGF) {
                    dLK();
                    return;
                } else {
                    dLJ();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nGt = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nGt = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nGu = master.flame.danmaku.danmaku.c.c.dNq();
                if (this.nGx == null || !this.nGz.dLZ()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    G(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nGs = 0L;
                            c.this.mReady = true;
                            if (c.this.nGv != null) {
                                c.this.nGv.dLU();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nGt = true;
                dLL();
                this.nGs = this.nGw.nHR;
                if (this.nGE != null) {
                    dLO();
                    dLI();
                }
                if (i == 6) {
                    if (this.nGy != null) {
                        this.nGy.quit();
                    }
                    if (this.nGx != null) {
                        this.nGx.release();
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
                if (this.nGy != null) {
                    this.nGy.NQ(2);
                }
                if (i == 6) {
                }
                this.nGt = true;
                dLL();
                this.nGs = this.nGw.nHR;
                if (this.nGE != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nGA = true;
                Long l3 = (Long) message.obj;
                if (this.nGy == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nGw.ho(getCurrentTime());
                    this.nGy.dLW();
                    z = false;
                } else {
                    this.nGy.start();
                    this.nGy.seek(l3.longValue());
                    this.nGy.dLW();
                    z = true;
                }
                if (this.nGt && this.nGz != null) {
                    this.nGz.dMa();
                }
                dLO();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nGt = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nGA = false;
                if (this.nGz != null) {
                    this.nGz.clear();
                }
                if (this.nGy != null) {
                    this.nGy.dLW();
                    this.nGy.dLY();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nGy != null) {
                    this.nGy.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nGy != null) {
                }
                if (i == 6) {
                }
                this.nGt = true;
                dLL();
                this.nGs = this.nGw.nHR;
                if (this.nGE != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nGr.nJB.b(this.nGr);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nGr.nJz.dMw();
                    this.nGr.nJz.dMv();
                    this.nGy.dLX();
                    return;
                }
                return;
            case 11:
                dLO();
                return;
            case 12:
                if (this.nGt && this.nGz != null) {
                    this.nGy.dLW();
                    this.nGz.dMa();
                    dLO();
                    return;
                }
                return;
            case 13:
                if (this.nGy != null) {
                    this.nGy.hk(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dLI() {
        if (this.nGE != null) {
            i iVar = this.nGE;
            this.nGE = null;
            synchronized (this.nGy) {
                this.nGy.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dLJ() {
        if (!this.nGt) {
            long hh = hh(master.flame.danmaku.danmaku.c.c.dNq());
            if (hh < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - hh);
                return;
            }
            long dMa = this.nGz.dMa();
            removeMessages(2);
            if (dMa > this.nGH) {
                this.nGw.hp(dMa);
                this.nGD.clear();
            }
            if (!this.nGA) {
                hi(10000000L);
                return;
            }
            if (this.nGC.nKD && this.nGQ) {
                long j = this.nGC.endTime - this.nGw.nHR;
                if (j > 500) {
                    hi(j - 10);
                    return;
                }
            }
            if (dMa < this.nGI) {
                sendEmptyMessageDelayed(2, this.nGI - dMa);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dLK() {
        if (this.nGE == null) {
            this.nGE = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dNq = master.flame.danmaku.danmaku.c.c.dNq();
                    while (!dMc() && !c.this.nGt) {
                        long dNq2 = master.flame.danmaku.danmaku.c.c.dNq();
                        if (c.this.nGI - (master.flame.danmaku.danmaku.c.c.dNq() - dNq) <= 1) {
                            long hh = c.this.hh(dNq2);
                            if (hh >= 0) {
                                long dMa = c.this.nGz.dMa();
                                if (dMa > c.this.nGH) {
                                    c.this.nGw.hp(dMa);
                                    c.this.nGD.clear();
                                }
                                if (!c.this.nGA) {
                                    c.this.hi(10000000L);
                                } else if (c.this.nGC.nKD && c.this.nGQ) {
                                    long j = c.this.nGC.endTime - c.this.nGw.nHR;
                                    if (j > 500) {
                                        c.this.dLO();
                                        c.this.hi(j - 10);
                                    }
                                }
                                dNq = dNq2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.hq(60 - hh);
                                dNq = dNq2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.hq(1L);
                        }
                    }
                }
            };
            this.nGE.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long hh(long j) {
        long j2;
        long j3 = 0;
        if (this.nGL || this.nGO) {
            return 0L;
        }
        this.nGO = true;
        long j4 = j - this.nGu;
        if (!this.nGA || this.nGC.nKD || this.nGP) {
            this.nGw.ho(j4);
            this.nGN = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nGw.nHR;
            long max = Math.max(this.nGI, dLP());
            if (j2 <= 2000 && this.nGC.nKC <= this.nGG && max <= this.nGG) {
                long min = Math.min(this.nGG, Math.max(this.nGI, (j2 / this.nGI) + max));
                long j5 = min - this.nGK;
                if (j5 > 3 && j5 < 8 && this.nGK >= this.nGI && this.nGK <= this.nGG) {
                    min = this.nGK;
                }
                long j6 = j2 - min;
                this.nGK = min;
                j2 = min;
                j3 = j6;
            }
            this.nGN = j3;
            this.nGw.hp(j2);
        }
        if (this.nGv != null) {
            this.nGv.b(this.nGw);
        }
        this.nGO = false;
        return j2;
    }

    private void dLL() {
        if (this.nGP) {
            hh(master.flame.danmaku.danmaku.c.c.dNq());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLM() {
        this.nGG = Math.max(33L, ((float) 16) * 2.5f);
        this.nGH = ((float) this.nGG) * 2.5f;
        this.nGI = Math.max(16L, (16 / 15) * 15);
        this.nGJ = this.nGI + 3;
    }

    private void G(final Runnable runnable) {
        if (this.nGy == null) {
            this.nGy = a(this.nGz.dMb(), this.nGw, this.nGz.getContext(), this.nGz.getWidth(), this.nGz.getHeight(), this.nGz.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dLR() {
                    c.this.dLM();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dMt = dVar.dMt() - c.this.getCurrentTime();
                        if (dMt < c.this.nGr.nJB.nJG && (c.this.nGP || c.this.nGC.nKD)) {
                            c.this.dLO();
                        } else if (dMt > 0 && dMt <= c.this.nGr.nJB.nJG) {
                            c.this.sendEmptyMessageDelayed(11, dMt);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nGv != null) {
                        c.this.nGv.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dLS() {
                    if (c.this.nGv != null) {
                        c.this.nGv.dLV();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dLT() {
                    c.this.dLN();
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
        this.nGB = this.nGr.dMR();
        this.nGB.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nGB.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nGB.bG(this.nGr.nIZ);
        this.nGB.wU(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nGr, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nGr, aVar);
        aVar2.a(this.nGx);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nGy != null) {
            dVar.nHN = this.nGr.nJz;
            dVar.c(this.nGw);
            this.nGy.a(dVar);
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
        dLL();
        sendEmptyMessage(7);
    }

    public void i(Long l) {
        if (!this.nGA) {
            this.nGA = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wS(boolean z) {
        if (!this.nGA) {
            return this.nGw.nHR;
        }
        this.nGA = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nGw.nHR;
    }

    public a.b al(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dMg;
        if (this.nGy == null) {
            return this.nGC;
        }
        if (!this.nGP && (aVar = this.nGr.nJn) != null && ((dMg = aVar.dMg()) || this.nGt)) {
            int dMe = aVar.dMe();
            if (dMe == 2) {
                long j = this.nGw.nHR;
                long dMd = aVar.dMd();
                long j2 = dMd - j;
                if (Math.abs(j2) > aVar.dMf()) {
                    if (dMg && this.nGt) {
                        resume();
                    }
                    this.nGy.m(j, dMd, j2);
                    this.nGw.ho(dMd);
                    this.nGu = master.flame.danmaku.danmaku.c.c.dNq() - dMd;
                    this.nGN = 0L;
                }
            } else if (dMe == 1 && dMg && !this.nGt) {
                pause();
            }
        }
        this.nGB.setExtraData(canvas);
        this.nGC.b(this.nGy.a(this.nGB));
        dLQ();
        return this.nGC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLN() {
        if (this.nGt && this.nGA) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLO() {
        if (this.nGP) {
            if (this.nGy != null) {
                this.nGy.dLW();
            }
            if (this.nGF) {
                synchronized (this) {
                    this.nGD.clear();
                }
                synchronized (this.nGy) {
                    this.nGy.notifyAll();
                }
            } else {
                this.nGD.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nGP = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi(long j) {
        if (!isStop() && isPrepared() && !this.nGL) {
            this.nGC.eAA = master.flame.danmaku.danmaku.c.c.dNq();
            this.nGP = true;
            if (this.nGF) {
                if (this.nGE != null) {
                    try {
                        synchronized (this.nGy) {
                            if (j == 10000000) {
                                this.nGy.wait();
                            } else {
                                this.nGy.wait(j);
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

    private synchronized long dLP() {
        long longValue;
        int size = this.nGD.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nGD.peekFirst();
            Long peekLast = this.nGD.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dLQ() {
        this.nGD.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dNq()));
        if (this.nGD.size() > 500) {
            this.nGD.removeFirst();
        }
    }

    public void eB(int i, int i2) {
        if (this.nGB != null) {
            if (this.nGB.getWidth() != i || this.nGB.getHeight() != i2) {
                this.nGB.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wO(boolean z) {
        if (this.nGy != null) {
            this.nGy.wO(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nGy != null) {
            return this.nGy.hj(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nGL) {
            return this.nGM;
        }
        if (this.nGt || !this.nGP) {
            return this.nGw.nHR - this.nGN;
        }
        return master.flame.danmaku.danmaku.c.c.dNq() - this.nGu;
    }

    public DanmakuContext getConfig() {
        return this.nGr;
    }
}
