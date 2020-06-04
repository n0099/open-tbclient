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
    private long nwA;
    private boolean nwB;
    private long nwC;
    private long nwD;
    private boolean nwE;
    private boolean nwF;
    private boolean nwG;
    private DanmakuContext nwh;
    private long nwi;
    private boolean nwj;
    private long nwk;
    private a nwl;
    private master.flame.danmaku.danmaku.model.f nwm;
    private master.flame.danmaku.danmaku.a.a nwn;
    public h nwo;
    private g nwp;
    private boolean nwq;
    private master.flame.danmaku.danmaku.model.b nwr;
    private final a.b nws;
    private LinkedList<Long> nwt;
    private i nwu;
    private final boolean nwv;
    private long nww;
    private long nwx;
    private long nwy;
    private long nwz;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dMZ();

        void dNa();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nwi = 0L;
        this.nwj = true;
        this.nwm = new master.flame.danmaku.danmaku.model.f();
        this.nwq = true;
        this.nws = new a.b();
        this.nwt = new LinkedList<>();
        this.nww = 30L;
        this.nwx = 60L;
        this.nwy = 16L;
        this.nwv = Runtime.getRuntime().availableProcessors() > 3;
        this.nwG = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            wX(false);
        }
        this.nwq = z;
    }

    private void a(g gVar) {
        this.nwp = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nwh = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nwn = aVar;
    }

    public void setCallback(a aVar) {
        this.nwl = aVar;
    }

    public void quit() {
        this.nwj = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nwj;
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
                    this.nwi = l.longValue();
                } else {
                    this.nwi = 0L;
                }
                if (i == 4) {
                    this.nwj = true;
                    dMN();
                    Long l2 = (Long) message.obj;
                    this.nwk -= l2.longValue() - this.nwm.nxI;
                    this.nwm.gq(l2.longValue());
                    this.nwh.nzs.dNB();
                    if (this.nwo != null) {
                        this.nwo.seek(l2.longValue());
                    }
                    this.nwi = l2.longValue();
                }
                removeMessages(7);
                this.nwj = false;
                if (!this.mReady) {
                    this.nws.reset();
                    this.nwt.clear();
                    this.nwk = master.flame.danmaku.danmaku.c.c.dOv() - this.nwi;
                    this.nwm.gq(this.nwi);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nwo.start();
                    dMT();
                    this.nwB = false;
                    if (this.nwo != null) {
                        this.nwo.JX(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nwv) {
                    dMP();
                    return;
                } else {
                    dMO();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nwj = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nwj = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nwk = master.flame.danmaku.danmaku.c.c.dOv();
                if (this.nwn == null || !this.nwp.dNe()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    N(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nwi = 0L;
                            c.this.mReady = true;
                            if (c.this.nwl != null) {
                                c.this.nwl.dMZ();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nwj = true;
                dMQ();
                this.nwi = this.nwm.nxI;
                if (this.nwu != null) {
                    dMT();
                    dMN();
                }
                if (i == 6) {
                    if (this.nwo != null) {
                        this.nwo.quit();
                    }
                    if (this.nwn != null) {
                        this.nwn.release();
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
                if (this.nwo != null) {
                    this.nwo.JX(2);
                }
                if (i == 6) {
                }
                this.nwj = true;
                dMQ();
                this.nwi = this.nwm.nxI;
                if (this.nwu != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nwq = true;
                Long l3 = (Long) message.obj;
                if (this.nwo == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nwm.gq(getCurrentTime());
                    this.nwo.dNb();
                    z = false;
                } else {
                    this.nwo.start();
                    this.nwo.seek(l3.longValue());
                    this.nwo.dNb();
                    z = true;
                }
                if (this.nwj && this.nwp != null) {
                    this.nwp.dNf();
                }
                dMT();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nwj = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nwq = false;
                if (this.nwp != null) {
                    this.nwp.clear();
                }
                if (this.nwo != null) {
                    this.nwo.dNb();
                    this.nwo.dNd();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nwo != null) {
                    this.nwo.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nwo != null) {
                }
                if (i == 6) {
                }
                this.nwj = true;
                dMQ();
                this.nwi = this.nwm.nxI;
                if (this.nwu != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nwh.nzu.b(this.nwh);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nwh.nzs.dNB();
                    this.nwh.nzs.dNA();
                    this.nwo.dNc();
                    return;
                }
                return;
            case 11:
                dMT();
                return;
            case 12:
                if (this.nwj && this.nwp != null) {
                    this.nwo.dNb();
                    this.nwp.dNf();
                    dMT();
                    return;
                }
                return;
            case 13:
                if (this.nwo != null) {
                    this.nwo.gm(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dMN() {
        if (this.nwu != null) {
            i iVar = this.nwu;
            this.nwu = null;
            synchronized (this.nwo) {
                this.nwo.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dMO() {
        if (!this.nwj) {
            long gj = gj(master.flame.danmaku.danmaku.c.c.dOv());
            if (gj < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - gj);
                return;
            }
            long dNf = this.nwp.dNf();
            removeMessages(2);
            if (dNf > this.nwx) {
                this.nwm.gr(dNf);
                this.nwt.clear();
            }
            if (!this.nwq) {
                gk(10000000L);
                return;
            }
            if (this.nws.nAv && this.nwG) {
                long j = this.nws.endTime - this.nwm.nxI;
                if (j > 500) {
                    gk(j - 10);
                    return;
                }
            }
            if (dNf < this.nwy) {
                sendEmptyMessageDelayed(2, this.nwy - dNf);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dMP() {
        if (this.nwu == null) {
            this.nwu = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dOv = master.flame.danmaku.danmaku.c.c.dOv();
                    while (!dNh() && !c.this.nwj) {
                        long dOv2 = master.flame.danmaku.danmaku.c.c.dOv();
                        if (c.this.nwy - (master.flame.danmaku.danmaku.c.c.dOv() - dOv) <= 1) {
                            long gj = c.this.gj(dOv2);
                            if (gj >= 0) {
                                long dNf = c.this.nwp.dNf();
                                if (dNf > c.this.nwx) {
                                    c.this.nwm.gr(dNf);
                                    c.this.nwt.clear();
                                }
                                if (!c.this.nwq) {
                                    c.this.gk(10000000L);
                                } else if (c.this.nws.nAv && c.this.nwG) {
                                    long j = c.this.nws.endTime - c.this.nwm.nxI;
                                    if (j > 500) {
                                        c.this.dMT();
                                        c.this.gk(j - 10);
                                    }
                                }
                                dOv = dOv2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gs(60 - gj);
                                dOv = dOv2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gs(1L);
                        }
                    }
                }
            };
            this.nwu.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long gj(long j) {
        long j2;
        long j3 = 0;
        if (this.nwB || this.nwE) {
            return 0L;
        }
        this.nwE = true;
        long j4 = j - this.nwk;
        if (!this.nwq || this.nws.nAv || this.nwF) {
            this.nwm.gq(j4);
            this.nwD = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nwm.nxI;
            long max = Math.max(this.nwy, dMU());
            if (j2 <= 2000 && this.nws.nAu <= this.nww && max <= this.nww) {
                long min = Math.min(this.nww, Math.max(this.nwy, (j2 / this.nwy) + max));
                long j5 = min - this.nwA;
                if (j5 > 3 && j5 < 8 && this.nwA >= this.nwy && this.nwA <= this.nww) {
                    min = this.nwA;
                }
                long j6 = j2 - min;
                this.nwA = min;
                j2 = min;
                j3 = j6;
            }
            this.nwD = j3;
            this.nwm.gr(j2);
        }
        if (this.nwl != null) {
            this.nwl.b(this.nwm);
        }
        this.nwE = false;
        return j2;
    }

    private void dMQ() {
        if (this.nwF) {
            gj(master.flame.danmaku.danmaku.c.c.dOv());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMR() {
        this.nww = Math.max(33L, ((float) 16) * 2.5f);
        this.nwx = ((float) this.nww) * 2.5f;
        this.nwy = Math.max(16L, (16 / 15) * 15);
        this.nwz = this.nwy + 3;
    }

    private void N(final Runnable runnable) {
        if (this.nwo == null) {
            this.nwo = a(this.nwp.dNg(), this.nwm, this.nwp.getContext(), this.nwp.getWidth(), this.nwp.getHeight(), this.nwp.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dMW() {
                    c.this.dMR();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dNy = dVar.dNy() - c.this.getCurrentTime();
                        if (dNy < c.this.nwh.nzu.nzz && (c.this.nwF || c.this.nws.nAv)) {
                            c.this.dMT();
                        } else if (dNy > 0 && dNy <= c.this.nwh.nzu.nzz) {
                            c.this.sendEmptyMessageDelayed(11, dNy);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nwl != null) {
                        c.this.nwl.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dMX() {
                    if (c.this.nwl != null) {
                        c.this.nwl.dNa();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dMY() {
                    c.this.dMS();
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
        this.nwr = this.nwh.dNW();
        this.nwr.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nwr.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nwr.aM(this.nwh.nyS);
        this.nwr.wZ(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nwh, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nwh, aVar);
        aVar2.a(this.nwn);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nwo != null) {
            dVar.nxE = this.nwh.nzs;
            dVar.c(this.nwm);
            this.nwo.a(dVar);
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
        dMQ();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.nwq) {
            this.nwq = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long wX(boolean z) {
        if (!this.nwq) {
            return this.nwm.nxI;
        }
        this.nwq = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nwm.nxI;
    }

    public a.b ag(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dNl;
        if (this.nwo == null) {
            return this.nws;
        }
        if (!this.nwF && (aVar = this.nwh.nzg) != null && ((dNl = aVar.dNl()) || this.nwj)) {
            int dNj = aVar.dNj();
            if (dNj == 2) {
                long j = this.nwm.nxI;
                long dNi = aVar.dNi();
                long j2 = dNi - j;
                if (Math.abs(j2) > aVar.dNk()) {
                    if (dNl && this.nwj) {
                        resume();
                    }
                    this.nwo.h(j, dNi, j2);
                    this.nwm.gq(dNi);
                    this.nwk = master.flame.danmaku.danmaku.c.c.dOv() - dNi;
                    this.nwD = 0L;
                }
            } else if (dNj == 1 && dNl && !this.nwj) {
                pause();
            }
        }
        this.nwr.setExtraData(canvas);
        this.nws.b(this.nwo.a(this.nwr));
        dMV();
        return this.nws;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMS() {
        if (this.nwj && this.nwq) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMT() {
        if (this.nwF) {
            if (this.nwo != null) {
                this.nwo.dNb();
            }
            if (this.nwv) {
                synchronized (this) {
                    this.nwt.clear();
                }
                synchronized (this.nwo) {
                    this.nwo.notifyAll();
                }
            } else {
                this.nwt.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nwF = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(long j) {
        if (!isStop() && isPrepared() && !this.nwB) {
            this.nws.fsO = master.flame.danmaku.danmaku.c.c.dOv();
            this.nwF = true;
            if (this.nwv) {
                if (this.nwu != null) {
                    try {
                        synchronized (this.nwo) {
                            if (j == 10000000) {
                                this.nwo.wait();
                            } else {
                                this.nwo.wait(j);
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

    private synchronized long dMU() {
        long longValue;
        int size = this.nwt.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nwt.peekFirst();
            Long peekLast = this.nwt.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dMV() {
        this.nwt.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dOv()));
        if (this.nwt.size() > 500) {
            this.nwt.removeFirst();
        }
    }

    public void dR(int i, int i2) {
        if (this.nwr != null) {
            if (this.nwr.getWidth() != i || this.nwr.getHeight() != i2) {
                this.nwr.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void wT(boolean z) {
        if (this.nwo != null) {
            this.nwo.wT(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nwo != null) {
            return this.nwo.gl(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nwB) {
            return this.nwC;
        }
        if (this.nwj || !this.nwF) {
            return this.nwm.nxI - this.nwD;
        }
        return master.flame.danmaku.danmaku.c.c.dOv() - this.nwk;
    }

    public DanmakuContext getConfig() {
        return this.nwh;
    }
}
