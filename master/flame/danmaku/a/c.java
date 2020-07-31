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
/* loaded from: classes6.dex */
public class c extends Handler {
    private boolean mReady;
    private DanmakuContext oaF;
    private long oaG;
    private boolean oaH;
    private long oaI;
    private a oaJ;
    private master.flame.danmaku.danmaku.model.f oaK;
    private master.flame.danmaku.danmaku.a.a oaL;
    public h oaM;
    private g oaN;
    private boolean oaO;
    private master.flame.danmaku.danmaku.model.b oaP;
    private final a.b oaQ;
    private LinkedList<Long> oaR;
    private i oaS;
    private final boolean oaT;
    private long oaU;
    private long oaV;
    private long oaW;
    private long oaX;
    private long oaY;
    private boolean oaZ;
    private long oba;
    private long obb;
    private boolean obc;
    private boolean obd;
    private boolean obe;

    /* loaded from: classes6.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dVf();

        void dVg();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.oaG = 0L;
        this.oaH = true;
        this.oaK = new master.flame.danmaku.danmaku.model.f();
        this.oaO = true;
        this.oaQ = new a.b();
        this.oaR = new LinkedList<>();
        this.oaU = 30L;
        this.oaV = 60L;
        this.oaW = 16L;
        this.oaT = Runtime.getRuntime().availableProcessors() > 3;
        this.obe = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            xX(false);
        }
        this.oaO = z;
    }

    private void a(g gVar) {
        this.oaN = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.oaF = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.oaL = aVar;
    }

    public void setCallback(a aVar) {
        this.oaJ = aVar;
    }

    public void quit() {
        this.oaH = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.oaH;
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
                    this.oaG = l.longValue();
                } else {
                    this.oaG = 0L;
                }
                if (i == 4) {
                    this.oaH = true;
                    dUT();
                    Long l2 = (Long) message.obj;
                    this.oaI -= l2.longValue() - this.oaK.ocf;
                    this.oaK.gI(l2.longValue());
                    this.oaF.odQ.dVH();
                    if (this.oaM != null) {
                        this.oaM.seek(l2.longValue());
                    }
                    this.oaG = l2.longValue();
                }
                removeMessages(7);
                this.oaH = false;
                if (!this.mReady) {
                    this.oaQ.reset();
                    this.oaR.clear();
                    this.oaI = master.flame.danmaku.danmaku.c.c.dWB() - this.oaG;
                    this.oaK.gI(this.oaG);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.oaM.start();
                    dUZ();
                    this.oaZ = false;
                    if (this.oaM != null) {
                        this.oaM.Ly(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.oaT) {
                    dUV();
                    return;
                } else {
                    dUU();
                    return;
                }
            case 3:
                removeMessages(7);
                this.oaH = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.oaH = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.oaI = master.flame.danmaku.danmaku.c.c.dWB();
                if (this.oaL == null || !this.oaN.dVk()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    M(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.oaG = 0L;
                            c.this.mReady = true;
                            if (c.this.oaJ != null) {
                                c.this.oaJ.dVf();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.oaH = true;
                dUW();
                this.oaG = this.oaK.ocf;
                if (this.oaS != null) {
                    dUZ();
                    dUT();
                }
                if (i == 6) {
                    if (this.oaM != null) {
                        this.oaM.quit();
                    }
                    if (this.oaL != null) {
                        this.oaL.release();
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
                if (this.oaM != null) {
                    this.oaM.Ly(2);
                }
                if (i == 6) {
                }
                this.oaH = true;
                dUW();
                this.oaG = this.oaK.ocf;
                if (this.oaS != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.oaO = true;
                Long l3 = (Long) message.obj;
                if (this.oaM == null) {
                    z = false;
                } else if (l3 == null) {
                    this.oaK.gI(getCurrentTime());
                    this.oaM.dVh();
                    z = false;
                } else {
                    this.oaM.start();
                    this.oaM.seek(l3.longValue());
                    this.oaM.dVh();
                    z = true;
                }
                if (this.oaH && this.oaN != null) {
                    this.oaN.dVl();
                }
                dUZ();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.oaH = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.oaO = false;
                if (this.oaN != null) {
                    this.oaN.clear();
                }
                if (this.oaM != null) {
                    this.oaM.dVh();
                    this.oaM.dVj();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.oaM != null) {
                    this.oaM.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.oaM != null) {
                }
                if (i == 6) {
                }
                this.oaH = true;
                dUW();
                this.oaG = this.oaK.ocf;
                if (this.oaS != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.oaF.odS.b(this.oaF);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.oaF.odQ.dVH();
                    this.oaF.odQ.dVG();
                    this.oaM.dVi();
                    return;
                }
                return;
            case 11:
                dUZ();
                return;
            case 12:
                if (this.oaH && this.oaN != null) {
                    this.oaM.dVh();
                    this.oaN.dVl();
                    dUZ();
                    return;
                }
                return;
            case 13:
                if (this.oaM != null) {
                    this.oaM.gE(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dUT() {
        if (this.oaS != null) {
            i iVar = this.oaS;
            this.oaS = null;
            synchronized (this.oaM) {
                this.oaM.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dUU() {
        if (!this.oaH) {
            long gB = gB(master.flame.danmaku.danmaku.c.c.dWB());
            if (gB < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - gB);
                return;
            }
            long dVl = this.oaN.dVl();
            removeMessages(2);
            if (dVl > this.oaV) {
                this.oaK.gJ(dVl);
                this.oaR.clear();
            }
            if (!this.oaO) {
                gC(10000000L);
                return;
            }
            if (this.oaQ.oeT && this.obe) {
                long j = this.oaQ.endTime - this.oaK.ocf;
                if (j > 500) {
                    gC(j - 10);
                    return;
                }
            }
            if (dVl < this.oaW) {
                sendEmptyMessageDelayed(2, this.oaW - dVl);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dUV() {
        if (this.oaS == null) {
            this.oaS = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dWB = master.flame.danmaku.danmaku.c.c.dWB();
                    while (!dVn() && !c.this.oaH) {
                        long dWB2 = master.flame.danmaku.danmaku.c.c.dWB();
                        if (c.this.oaW - (master.flame.danmaku.danmaku.c.c.dWB() - dWB) <= 1) {
                            long gB = c.this.gB(dWB2);
                            if (gB >= 0) {
                                long dVl = c.this.oaN.dVl();
                                if (dVl > c.this.oaV) {
                                    c.this.oaK.gJ(dVl);
                                    c.this.oaR.clear();
                                }
                                if (!c.this.oaO) {
                                    c.this.gC(10000000L);
                                } else if (c.this.oaQ.oeT && c.this.obe) {
                                    long j = c.this.oaQ.endTime - c.this.oaK.ocf;
                                    if (j > 500) {
                                        c.this.dUZ();
                                        c.this.gC(j - 10);
                                    }
                                }
                                dWB = dWB2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gK(60 - gB);
                                dWB = dWB2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gK(1L);
                        }
                    }
                }
            };
            this.oaS.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long gB(long j) {
        long j2;
        long j3 = 0;
        if (this.oaZ || this.obc) {
            return 0L;
        }
        this.obc = true;
        long j4 = j - this.oaI;
        if (!this.oaO || this.oaQ.oeT || this.obd) {
            this.oaK.gI(j4);
            this.obb = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.oaK.ocf;
            long max = Math.max(this.oaW, dVa());
            if (j2 <= 2000 && this.oaQ.oeS <= this.oaU && max <= this.oaU) {
                long min = Math.min(this.oaU, Math.max(this.oaW, (j2 / this.oaW) + max));
                long j5 = min - this.oaY;
                if (j5 > 3 && j5 < 8 && this.oaY >= this.oaW && this.oaY <= this.oaU) {
                    min = this.oaY;
                }
                long j6 = j2 - min;
                this.oaY = min;
                j2 = min;
                j3 = j6;
            }
            this.obb = j3;
            this.oaK.gJ(j2);
        }
        if (this.oaJ != null) {
            this.oaJ.b(this.oaK);
        }
        this.obc = false;
        return j2;
    }

    private void dUW() {
        if (this.obd) {
            gB(master.flame.danmaku.danmaku.c.c.dWB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUX() {
        this.oaU = Math.max(33L, ((float) 16) * 2.5f);
        this.oaV = ((float) this.oaU) * 2.5f;
        this.oaW = Math.max(16L, (16 / 15) * 15);
        this.oaX = this.oaW + 3;
    }

    private void M(final Runnable runnable) {
        if (this.oaM == null) {
            this.oaM = a(this.oaN.dVm(), this.oaK, this.oaN.getContext(), this.oaN.getWidth(), this.oaN.getHeight(), this.oaN.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dVc() {
                    c.this.dUX();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dVE = dVar.dVE() - c.this.getCurrentTime();
                        if (dVE < c.this.oaF.odS.odX && (c.this.obd || c.this.oaQ.oeT)) {
                            c.this.dUZ();
                        } else if (dVE > 0 && dVE <= c.this.oaF.odS.odX) {
                            c.this.sendEmptyMessageDelayed(11, dVE);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.oaJ != null) {
                        c.this.oaJ.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dVd() {
                    if (c.this.oaJ != null) {
                        c.this.oaJ.dVg();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dVe() {
                    c.this.dUY();
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
        this.oaP = this.oaF.dWc();
        this.oaP.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.oaP.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.oaP.aR(this.oaF.odq);
        this.oaP.xZ(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.oaF, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.oaF, aVar);
        aVar2.a(this.oaL);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oaM != null) {
            dVar.ocb = this.oaF.odQ;
            dVar.c(this.oaK);
            this.oaM.a(dVar);
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
        dUW();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.oaO) {
            this.oaO = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long xX(boolean z) {
        if (!this.oaO) {
            return this.oaK.ocf;
        }
        this.oaO = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.oaK.ocf;
    }

    public a.b al(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dVr;
        if (this.oaM == null) {
            return this.oaQ;
        }
        if (!this.obd && (aVar = this.oaF.odE) != null && ((dVr = aVar.dVr()) || this.oaH)) {
            int dVp = aVar.dVp();
            if (dVp == 2) {
                long j = this.oaK.ocf;
                long dVo = aVar.dVo();
                long j2 = dVo - j;
                if (Math.abs(j2) > aVar.dVq()) {
                    if (dVr && this.oaH) {
                        resume();
                    }
                    this.oaM.k(j, dVo, j2);
                    this.oaK.gI(dVo);
                    this.oaI = master.flame.danmaku.danmaku.c.c.dWB() - dVo;
                    this.obb = 0L;
                }
            } else if (dVp == 1 && dVr && !this.oaH) {
                pause();
            }
        }
        this.oaP.setExtraData(canvas);
        this.oaQ.b(this.oaM.a(this.oaP));
        dVb();
        return this.oaQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUY() {
        if (this.oaH && this.oaO) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUZ() {
        if (this.obd) {
            if (this.oaM != null) {
                this.oaM.dVh();
            }
            if (this.oaT) {
                synchronized (this) {
                    this.oaR.clear();
                }
                synchronized (this.oaM) {
                    this.oaM.notifyAll();
                }
            } else {
                this.oaR.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.obd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(long j) {
        if (!isStop() && isPrepared() && !this.oaZ) {
            this.oaQ.fJu = master.flame.danmaku.danmaku.c.c.dWB();
            this.obd = true;
            if (this.oaT) {
                if (this.oaS != null) {
                    try {
                        synchronized (this.oaM) {
                            if (j == 10000000) {
                                this.oaM.wait();
                            } else {
                                this.oaM.wait(j);
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

    private synchronized long dVa() {
        long longValue;
        int size = this.oaR.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.oaR.peekFirst();
            Long peekLast = this.oaR.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dVb() {
        this.oaR.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dWB()));
        if (this.oaR.size() > 500) {
            this.oaR.removeFirst();
        }
    }

    public void ec(int i, int i2) {
        if (this.oaP != null) {
            if (this.oaP.getWidth() != i || this.oaP.getHeight() != i2) {
                this.oaP.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void xT(boolean z) {
        if (this.oaM != null) {
            this.oaM.xT(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.oaM != null) {
            return this.oaM.gD(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.oaZ) {
            return this.oba;
        }
        if (this.oaH || !this.obd) {
            return this.oaK.ocf - this.obb;
        }
        return master.flame.danmaku.danmaku.c.c.dWB() - this.oaI;
    }

    public DanmakuContext getConfig() {
        return this.oaF;
    }
}
