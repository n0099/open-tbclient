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
    private DanmakuContext nRT;
    private long nRU;
    private boolean nRV;
    private long nRW;
    private a nRX;
    private master.flame.danmaku.danmaku.model.f nRY;
    private master.flame.danmaku.danmaku.a.a nRZ;
    public h nSa;
    private g nSb;
    private boolean nSc;
    private master.flame.danmaku.danmaku.model.b nSd;
    private final a.b nSe;
    private LinkedList<Long> nSf;
    private i nSg;
    private final boolean nSh;
    private long nSi;
    private long nSj;
    private long nSk;
    private long nSl;
    private long nSm;
    private boolean nSn;
    private long nSo;
    private long nSp;
    private boolean nSq;
    private boolean nSr;
    private boolean nSs;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dRF();

        void dRG();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nRU = 0L;
        this.nRV = true;
        this.nRY = new master.flame.danmaku.danmaku.model.f();
        this.nSc = true;
        this.nSe = new a.b();
        this.nSf = new LinkedList<>();
        this.nSi = 30L;
        this.nSj = 60L;
        this.nSk = 16L;
        this.nSh = Runtime.getRuntime().availableProcessors() > 3;
        this.nSs = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            xs(false);
        }
        this.nSc = z;
    }

    private void a(g gVar) {
        this.nSb = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nRT = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nRZ = aVar;
    }

    public void setCallback(a aVar) {
        this.nRX = aVar;
    }

    public void quit() {
        this.nRV = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nRV;
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
                    this.nRU = l.longValue();
                } else {
                    this.nRU = 0L;
                }
                if (i == 4) {
                    this.nRV = true;
                    dRt();
                    Long l2 = (Long) message.obj;
                    this.nRW -= l2.longValue() - this.nRY.nTt;
                    this.nRY.gv(l2.longValue());
                    this.nRT.nVd.dSh();
                    if (this.nSa != null) {
                        this.nSa.seek(l2.longValue());
                    }
                    this.nRU = l2.longValue();
                }
                removeMessages(7);
                this.nRV = false;
                if (!this.mReady) {
                    this.nSe.reset();
                    this.nSf.clear();
                    this.nRW = master.flame.danmaku.danmaku.c.c.dTb() - this.nRU;
                    this.nRY.gv(this.nRU);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nSa.start();
                    dRz();
                    this.nSn = false;
                    if (this.nSa != null) {
                        this.nSa.Le(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nSh) {
                    dRv();
                    return;
                } else {
                    dRu();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nRV = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nRV = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nRW = master.flame.danmaku.danmaku.c.c.dTb();
                if (this.nRZ == null || !this.nSb.dRK()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    N(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nRU = 0L;
                            c.this.mReady = true;
                            if (c.this.nRX != null) {
                                c.this.nRX.dRF();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nRV = true;
                dRw();
                this.nRU = this.nRY.nTt;
                if (this.nSg != null) {
                    dRz();
                    dRt();
                }
                if (i == 6) {
                    if (this.nSa != null) {
                        this.nSa.quit();
                    }
                    if (this.nRZ != null) {
                        this.nRZ.release();
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
                if (this.nSa != null) {
                    this.nSa.Le(2);
                }
                if (i == 6) {
                }
                this.nRV = true;
                dRw();
                this.nRU = this.nRY.nTt;
                if (this.nSg != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nSc = true;
                Long l3 = (Long) message.obj;
                if (this.nSa == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nRY.gv(getCurrentTime());
                    this.nSa.dRH();
                    z = false;
                } else {
                    this.nSa.start();
                    this.nSa.seek(l3.longValue());
                    this.nSa.dRH();
                    z = true;
                }
                if (this.nRV && this.nSb != null) {
                    this.nSb.dRL();
                }
                dRz();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nRV = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nSc = false;
                if (this.nSb != null) {
                    this.nSb.clear();
                }
                if (this.nSa != null) {
                    this.nSa.dRH();
                    this.nSa.dRJ();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nSa != null) {
                    this.nSa.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nSa != null) {
                }
                if (i == 6) {
                }
                this.nRV = true;
                dRw();
                this.nRU = this.nRY.nTt;
                if (this.nSg != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nRT.nVf.b(this.nRT);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nRT.nVd.dSh();
                    this.nRT.nVd.dSg();
                    this.nSa.dRI();
                    return;
                }
                return;
            case 11:
                dRz();
                return;
            case 12:
                if (this.nRV && this.nSb != null) {
                    this.nSa.dRH();
                    this.nSb.dRL();
                    dRz();
                    return;
                }
                return;
            case 13:
                if (this.nSa != null) {
                    this.nSa.gr(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dRt() {
        if (this.nSg != null) {
            i iVar = this.nSg;
            this.nSg = null;
            synchronized (this.nSa) {
                this.nSa.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dRu() {
        if (!this.nRV) {
            long go = go(master.flame.danmaku.danmaku.c.c.dTb());
            if (go < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - go);
                return;
            }
            long dRL = this.nSb.dRL();
            removeMessages(2);
            if (dRL > this.nSj) {
                this.nRY.gw(dRL);
                this.nSf.clear();
            }
            if (!this.nSc) {
                gp(10000000L);
                return;
            }
            if (this.nSe.nWg && this.nSs) {
                long j = this.nSe.endTime - this.nRY.nTt;
                if (j > 500) {
                    gp(j - 10);
                    return;
                }
            }
            if (dRL < this.nSk) {
                sendEmptyMessageDelayed(2, this.nSk - dRL);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dRv() {
        if (this.nSg == null) {
            this.nSg = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dTb = master.flame.danmaku.danmaku.c.c.dTb();
                    while (!dRN() && !c.this.nRV) {
                        long dTb2 = master.flame.danmaku.danmaku.c.c.dTb();
                        if (c.this.nSk - (master.flame.danmaku.danmaku.c.c.dTb() - dTb) <= 1) {
                            long go = c.this.go(dTb2);
                            if (go >= 0) {
                                long dRL = c.this.nSb.dRL();
                                if (dRL > c.this.nSj) {
                                    c.this.nRY.gw(dRL);
                                    c.this.nSf.clear();
                                }
                                if (!c.this.nSc) {
                                    c.this.gp(10000000L);
                                } else if (c.this.nSe.nWg && c.this.nSs) {
                                    long j = c.this.nSe.endTime - c.this.nRY.nTt;
                                    if (j > 500) {
                                        c.this.dRz();
                                        c.this.gp(j - 10);
                                    }
                                }
                                dTb = dTb2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gx(60 - go);
                                dTb = dTb2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gx(1L);
                        }
                    }
                }
            };
            this.nSg.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long go(long j) {
        long j2;
        long j3 = 0;
        if (this.nSn || this.nSq) {
            return 0L;
        }
        this.nSq = true;
        long j4 = j - this.nRW;
        if (!this.nSc || this.nSe.nWg || this.nSr) {
            this.nRY.gv(j4);
            this.nSp = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nRY.nTt;
            long max = Math.max(this.nSk, dRA());
            if (j2 <= 2000 && this.nSe.nWf <= this.nSi && max <= this.nSi) {
                long min = Math.min(this.nSi, Math.max(this.nSk, (j2 / this.nSk) + max));
                long j5 = min - this.nSm;
                if (j5 > 3 && j5 < 8 && this.nSm >= this.nSk && this.nSm <= this.nSi) {
                    min = this.nSm;
                }
                long j6 = j2 - min;
                this.nSm = min;
                j2 = min;
                j3 = j6;
            }
            this.nSp = j3;
            this.nRY.gw(j2);
        }
        if (this.nRX != null) {
            this.nRX.b(this.nRY);
        }
        this.nSq = false;
        return j2;
    }

    private void dRw() {
        if (this.nSr) {
            go(master.flame.danmaku.danmaku.c.c.dTb());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRx() {
        this.nSi = Math.max(33L, ((float) 16) * 2.5f);
        this.nSj = ((float) this.nSi) * 2.5f;
        this.nSk = Math.max(16L, (16 / 15) * 15);
        this.nSl = this.nSk + 3;
    }

    private void N(final Runnable runnable) {
        if (this.nSa == null) {
            this.nSa = a(this.nSb.dRM(), this.nRY, this.nSb.getContext(), this.nSb.getWidth(), this.nSb.getHeight(), this.nSb.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dRC() {
                    c.this.dRx();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dSe = dVar.dSe() - c.this.getCurrentTime();
                        if (dSe < c.this.nRT.nVf.nVk && (c.this.nSr || c.this.nSe.nWg)) {
                            c.this.dRz();
                        } else if (dSe > 0 && dSe <= c.this.nRT.nVf.nVk) {
                            c.this.sendEmptyMessageDelayed(11, dSe);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nRX != null) {
                        c.this.nRX.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dRD() {
                    if (c.this.nRX != null) {
                        c.this.nRX.dRG();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dRE() {
                    c.this.dRy();
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
        this.nSd = this.nRT.dSC();
        this.nSd.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nSd.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nSd.aS(this.nRT.nUD);
        this.nSd.xu(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nRT, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nRT, aVar);
        aVar2.a(this.nRZ);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nSa != null) {
            dVar.nTp = this.nRT.nVd;
            dVar.c(this.nRY);
            this.nSa.a(dVar);
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
        dRw();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.nSc) {
            this.nSc = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long xs(boolean z) {
        if (!this.nSc) {
            return this.nRY.nTt;
        }
        this.nSc = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nRY.nTt;
    }

    public a.b al(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dRR;
        if (this.nSa == null) {
            return this.nSe;
        }
        if (!this.nSr && (aVar = this.nRT.nUR) != null && ((dRR = aVar.dRR()) || this.nRV)) {
            int dRP = aVar.dRP();
            if (dRP == 2) {
                long j = this.nRY.nTt;
                long dRO = aVar.dRO();
                long j2 = dRO - j;
                if (Math.abs(j2) > aVar.dRQ()) {
                    if (dRR && this.nRV) {
                        resume();
                    }
                    this.nSa.k(j, dRO, j2);
                    this.nRY.gv(dRO);
                    this.nRW = master.flame.danmaku.danmaku.c.c.dTb() - dRO;
                    this.nSp = 0L;
                }
            } else if (dRP == 1 && dRR && !this.nRV) {
                pause();
            }
        }
        this.nSd.setExtraData(canvas);
        this.nSe.b(this.nSa.a(this.nSd));
        dRB();
        return this.nSe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRy() {
        if (this.nRV && this.nSc) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRz() {
        if (this.nSr) {
            if (this.nSa != null) {
                this.nSa.dRH();
            }
            if (this.nSh) {
                synchronized (this) {
                    this.nSf.clear();
                }
                synchronized (this.nSa) {
                    this.nSa.notifyAll();
                }
            } else {
                this.nSf.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nSr = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(long j) {
        if (!isStop() && isPrepared() && !this.nSn) {
            this.nSe.fDZ = master.flame.danmaku.danmaku.c.c.dTb();
            this.nSr = true;
            if (this.nSh) {
                if (this.nSg != null) {
                    try {
                        synchronized (this.nSa) {
                            if (j == 10000000) {
                                this.nSa.wait();
                            } else {
                                this.nSa.wait(j);
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

    private synchronized long dRA() {
        long longValue;
        int size = this.nSf.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nSf.peekFirst();
            Long peekLast = this.nSf.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dRB() {
        this.nSf.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dTb()));
        if (this.nSf.size() > 500) {
            this.nSf.removeFirst();
        }
    }

    public void ea(int i, int i2) {
        if (this.nSd != null) {
            if (this.nSd.getWidth() != i || this.nSd.getHeight() != i2) {
                this.nSd.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void xo(boolean z) {
        if (this.nSa != null) {
            this.nSa.xo(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nSa != null) {
            return this.nSa.gq(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nSn) {
            return this.nSo;
        }
        if (this.nRV || !this.nSr) {
            return this.nRY.nTt - this.nSp;
        }
        return master.flame.danmaku.danmaku.c.c.dTb() - this.nRW;
    }

    public DanmakuContext getConfig() {
        return this.nRT;
    }
}
