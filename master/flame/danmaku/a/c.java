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
/* loaded from: classes4.dex */
public class c extends Handler {
    private boolean mReady;
    private master.flame.danmaku.danmaku.a.a nDA;
    public h nDB;
    private g nDC;
    private boolean nDD;
    private master.flame.danmaku.danmaku.model.b nDE;
    private final a.b nDF;
    private LinkedList<Long> nDG;
    private i nDH;
    private final boolean nDI;
    private long nDJ;
    private long nDK;
    private long nDL;
    private long nDM;
    private long nDN;
    private boolean nDO;
    private long nDP;
    private long nDQ;
    private boolean nDR;
    private boolean nDS;
    private boolean nDT;
    private DanmakuContext nDu;
    private long nDv;
    private boolean nDw;
    private long nDx;
    private a nDy;
    private master.flame.danmaku.danmaku.model.f nDz;

    /* loaded from: classes4.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dKc();

        void dKd();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nDv = 0L;
        this.nDw = true;
        this.nDz = new master.flame.danmaku.danmaku.model.f();
        this.nDD = true;
        this.nDF = new a.b();
        this.nDG = new LinkedList<>();
        this.nDJ = 30L;
        this.nDK = 60L;
        this.nDL = 16L;
        this.nDI = Runtime.getRuntime().availableProcessors() > 3;
        this.nDT = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            i((Long) null);
        } else {
            wH(false);
        }
        this.nDD = z;
    }

    private void a(g gVar) {
        this.nDC = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nDu = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nDA = aVar;
    }

    public void setCallback(a aVar) {
        this.nDy = aVar;
    }

    public void quit() {
        this.nDw = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nDw;
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
                    this.nDv = l.longValue();
                } else {
                    this.nDv = 0L;
                }
                if (i == 4) {
                    this.nDw = true;
                    dJQ();
                    Long l2 = (Long) message.obj;
                    this.nDx -= l2.longValue() - this.nDz.nEU;
                    this.nDz.hp(l2.longValue());
                    this.nDu.nGD.dKE();
                    if (this.nDB != null) {
                        this.nDB.seek(l2.longValue());
                    }
                    this.nDv = l2.longValue();
                }
                removeMessages(7);
                this.nDw = false;
                if (!this.mReady) {
                    this.nDF.reset();
                    this.nDG.clear();
                    this.nDx = master.flame.danmaku.danmaku.c.c.dLy() - this.nDv;
                    this.nDz.hp(this.nDv);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nDB.start();
                    dJW();
                    this.nDO = false;
                    if (this.nDB != null) {
                        this.nDB.NH(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nDI) {
                    dJS();
                    return;
                } else {
                    dJR();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nDw = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nDw = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nDx = master.flame.danmaku.danmaku.c.c.dLy();
                if (this.nDA == null || !this.nDC.dKh()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    G(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nDv = 0L;
                            c.this.mReady = true;
                            if (c.this.nDy != null) {
                                c.this.nDy.dKc();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nDw = true;
                dJT();
                this.nDv = this.nDz.nEU;
                if (this.nDH != null) {
                    dJW();
                    dJQ();
                }
                if (i == 6) {
                    if (this.nDB != null) {
                        this.nDB.quit();
                    }
                    if (this.nDA != null) {
                        this.nDA.release();
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
                if (this.nDB != null) {
                    this.nDB.NH(2);
                }
                if (i == 6) {
                }
                this.nDw = true;
                dJT();
                this.nDv = this.nDz.nEU;
                if (this.nDH != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nDD = true;
                Long l3 = (Long) message.obj;
                if (this.nDB == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nDz.hp(getCurrentTime());
                    this.nDB.dKe();
                    z = false;
                } else {
                    this.nDB.start();
                    this.nDB.seek(l3.longValue());
                    this.nDB.dKe();
                    z = true;
                }
                if (this.nDw && this.nDC != null) {
                    this.nDC.dKi();
                }
                dJW();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nDw = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nDD = false;
                if (this.nDC != null) {
                    this.nDC.clear();
                }
                if (this.nDB != null) {
                    this.nDB.dKe();
                    this.nDB.dKg();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nDB != null) {
                    this.nDB.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nDB != null) {
                }
                if (i == 6) {
                }
                this.nDw = true;
                dJT();
                this.nDv = this.nDz.nEU;
                if (this.nDH != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nDu.nGF.b(this.nDu);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nDu.nGD.dKE();
                    this.nDu.nGD.dKD();
                    this.nDB.dKf();
                    return;
                }
                return;
            case 11:
                dJW();
                return;
            case 12:
                if (this.nDw && this.nDC != null) {
                    this.nDB.dKe();
                    this.nDC.dKi();
                    dJW();
                    return;
                }
                return;
            case 13:
                if (this.nDB != null) {
                    this.nDB.hl(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dJQ() {
        if (this.nDH != null) {
            i iVar = this.nDH;
            this.nDH = null;
            synchronized (this.nDB) {
                this.nDB.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dJR() {
        if (!this.nDw) {
            long hi = hi(master.flame.danmaku.danmaku.c.c.dLy());
            if (hi < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - hi);
                return;
            }
            long dKi = this.nDC.dKi();
            removeMessages(2);
            if (dKi > this.nDK) {
                this.nDz.hq(dKi);
                this.nDG.clear();
            }
            if (!this.nDD) {
                hj(10000000L);
                return;
            }
            if (this.nDF.nHI && this.nDT) {
                long j = this.nDF.endTime - this.nDz.nEU;
                if (j > 500) {
                    hj(j - 10);
                    return;
                }
            }
            if (dKi < this.nDL) {
                sendEmptyMessageDelayed(2, this.nDL - dKi);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dJS() {
        if (this.nDH == null) {
            this.nDH = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dLy = master.flame.danmaku.danmaku.c.c.dLy();
                    while (!dKk() && !c.this.nDw) {
                        long dLy2 = master.flame.danmaku.danmaku.c.c.dLy();
                        if (c.this.nDL - (master.flame.danmaku.danmaku.c.c.dLy() - dLy) <= 1) {
                            long hi = c.this.hi(dLy2);
                            if (hi >= 0) {
                                long dKi = c.this.nDC.dKi();
                                if (dKi > c.this.nDK) {
                                    c.this.nDz.hq(dKi);
                                    c.this.nDG.clear();
                                }
                                if (!c.this.nDD) {
                                    c.this.hj(10000000L);
                                } else if (c.this.nDF.nHI && c.this.nDT) {
                                    long j = c.this.nDF.endTime - c.this.nDz.nEU;
                                    if (j > 500) {
                                        c.this.dJW();
                                        c.this.hj(j - 10);
                                    }
                                }
                                dLy = dLy2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.hr(60 - hi);
                                dLy = dLy2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.hr(1L);
                        }
                    }
                }
            };
            this.nDH.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long hi(long j) {
        long j2;
        long j3 = 0;
        if (this.nDO || this.nDR) {
            return 0L;
        }
        this.nDR = true;
        long j4 = j - this.nDx;
        if (!this.nDD || this.nDF.nHI || this.nDS) {
            this.nDz.hp(j4);
            this.nDQ = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nDz.nEU;
            long max = Math.max(this.nDL, dJX());
            if (j2 <= 2000 && this.nDF.nHH <= this.nDJ && max <= this.nDJ) {
                long min = Math.min(this.nDJ, Math.max(this.nDL, (j2 / this.nDL) + max));
                long j5 = min - this.nDN;
                if (j5 > 3 && j5 < 8 && this.nDN >= this.nDL && this.nDN <= this.nDJ) {
                    min = this.nDN;
                }
                long j6 = j2 - min;
                this.nDN = min;
                j2 = min;
                j3 = j6;
            }
            this.nDQ = j3;
            this.nDz.hq(j2);
        }
        if (this.nDy != null) {
            this.nDy.b(this.nDz);
        }
        this.nDR = false;
        return j2;
    }

    private void dJT() {
        if (this.nDS) {
            hi(master.flame.danmaku.danmaku.c.c.dLy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJU() {
        this.nDJ = Math.max(33L, ((float) 16) * 2.5f);
        this.nDK = ((float) this.nDJ) * 2.5f;
        this.nDL = Math.max(16L, (16 / 15) * 15);
        this.nDM = this.nDL + 3;
    }

    private void G(final Runnable runnable) {
        if (this.nDB == null) {
            this.nDB = a(this.nDC.dKj(), this.nDz, this.nDC.getContext(), this.nDC.getWidth(), this.nDC.getHeight(), this.nDC.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dJZ() {
                    c.this.dJU();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dKB = dVar.dKB() - c.this.getCurrentTime();
                        if (dKB < c.this.nDu.nGF.nGK && (c.this.nDS || c.this.nDF.nHI)) {
                            c.this.dJW();
                        } else if (dKB > 0 && dKB <= c.this.nDu.nGF.nGK) {
                            c.this.sendEmptyMessageDelayed(11, dKB);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nDy != null) {
                        c.this.nDy.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dKa() {
                    if (c.this.nDy != null) {
                        c.this.nDy.dKd();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dKb() {
                    c.this.dJV();
                }
            });
        } else {
            runnable.run();
        }
    }

    public boolean aGB() {
        return this.mReady;
    }

    private h a(boolean z, master.flame.danmaku.danmaku.model.f fVar, Context context, int i, int i2, boolean z2, h.a aVar) {
        this.nDE = this.nDu.dKZ();
        this.nDE.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nDE.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nDE.bH(this.nDu.nGd);
        this.nDE.wJ(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nDu, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nDu, aVar);
        aVar2.a(this.nDA);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nDB != null) {
            dVar.nEQ = this.nDu.nGD;
            dVar.c(this.nDz);
            this.nDB.a(dVar);
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
        dJT();
        sendEmptyMessage(7);
    }

    public void i(Long l) {
        if (!this.nDD) {
            this.nDD = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wH(boolean z) {
        if (!this.nDD) {
            return this.nDz.nEU;
        }
        this.nDD = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nDz.nEU;
    }

    public a.b ak(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dKo;
        if (this.nDB == null) {
            return this.nDF;
        }
        if (!this.nDS && (aVar = this.nDu.nGr) != null && ((dKo = aVar.dKo()) || this.nDw)) {
            int dKm = aVar.dKm();
            if (dKm == 2) {
                long j = this.nDz.nEU;
                long dKl = aVar.dKl();
                long j2 = dKl - j;
                if (Math.abs(j2) > aVar.dKn()) {
                    if (dKo && this.nDw) {
                        resume();
                    }
                    this.nDB.j(j, dKl, j2);
                    this.nDz.hp(dKl);
                    this.nDx = master.flame.danmaku.danmaku.c.c.dLy() - dKl;
                    this.nDQ = 0L;
                }
            } else if (dKm == 1 && dKo && !this.nDw) {
                pause();
            }
        }
        this.nDE.setExtraData(canvas);
        this.nDF.b(this.nDB.a(this.nDE));
        dJY();
        return this.nDF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJV() {
        if (this.nDw && this.nDD) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJW() {
        if (this.nDS) {
            if (this.nDB != null) {
                this.nDB.dKe();
            }
            if (this.nDI) {
                synchronized (this) {
                    this.nDG.clear();
                }
                synchronized (this.nDB) {
                    this.nDB.notifyAll();
                }
            } else {
                this.nDG.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nDS = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(long j) {
        if (!isStop() && aGB() && !this.nDO) {
            this.nDF.evF = master.flame.danmaku.danmaku.c.c.dLy();
            this.nDS = true;
            if (this.nDI) {
                if (this.nDH != null) {
                    try {
                        synchronized (this.nDB) {
                            if (j == 10000000) {
                                this.nDB.wait();
                            } else {
                                this.nDB.wait(j);
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

    private synchronized long dJX() {
        long longValue;
        int size = this.nDG.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nDG.peekFirst();
            Long peekLast = this.nDG.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dJY() {
        this.nDG.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dLy()));
        if (this.nDG.size() > 500) {
            this.nDG.removeFirst();
        }
    }

    public void ex(int i, int i2) {
        if (this.nDE != null) {
            if (this.nDE.getWidth() != i || this.nDE.getHeight() != i2) {
                this.nDE.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wD(boolean z) {
        if (this.nDB != null) {
            this.nDB.wD(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nDB != null) {
            return this.nDB.hk(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nDO) {
            return this.nDP;
        }
        if (this.nDw || !this.nDS) {
            return this.nDz.nEU - this.nDQ;
        }
        return master.flame.danmaku.danmaku.c.c.dLy() - this.nDx;
    }

    public DanmakuContext getConfig() {
        return this.nDu;
    }
}
