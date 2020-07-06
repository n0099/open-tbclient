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
    private DanmakuContext nRW;
    private long nRX;
    private boolean nRY;
    private long nRZ;
    private a nSa;
    private master.flame.danmaku.danmaku.model.f nSb;
    private master.flame.danmaku.danmaku.a.a nSc;
    public h nSd;
    private g nSe;
    private boolean nSf;
    private master.flame.danmaku.danmaku.model.b nSg;
    private final a.b nSh;
    private LinkedList<Long> nSi;
    private i nSj;
    private final boolean nSk;
    private long nSl;
    private long nSm;
    private long nSn;
    private long nSo;
    private long nSp;
    private boolean nSq;
    private long nSr;
    private long nSs;
    private boolean nSt;
    private boolean nSu;
    private boolean nSv;

    /* loaded from: classes5.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void dRJ();

        void dRK();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.nRX = 0L;
        this.nRY = true;
        this.nSb = new master.flame.danmaku.danmaku.model.f();
        this.nSf = true;
        this.nSh = new a.b();
        this.nSi = new LinkedList<>();
        this.nSl = 30L;
        this.nSm = 60L;
        this.nSn = 16L;
        this.nSk = Runtime.getRuntime().availableProcessors() > 3;
        this.nSv = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            xs(false);
        }
        this.nSf = z;
    }

    private void a(g gVar) {
        this.nSe = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.nRW = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.nSc = aVar;
    }

    public void setCallback(a aVar) {
        this.nSa = aVar;
    }

    public void quit() {
        this.nRY = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.nRY;
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
                    this.nRX = l.longValue();
                } else {
                    this.nRX = 0L;
                }
                if (i == 4) {
                    this.nRY = true;
                    dRx();
                    Long l2 = (Long) message.obj;
                    this.nRZ -= l2.longValue() - this.nSb.nTw;
                    this.nSb.gv(l2.longValue());
                    this.nRW.nVg.dSl();
                    if (this.nSd != null) {
                        this.nSd.seek(l2.longValue());
                    }
                    this.nRX = l2.longValue();
                }
                removeMessages(7);
                this.nRY = false;
                if (!this.mReady) {
                    this.nSh.reset();
                    this.nSi.clear();
                    this.nRZ = master.flame.danmaku.danmaku.c.c.dTf() - this.nRX;
                    this.nSb.gv(this.nRX);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.nSd.start();
                    dRD();
                    this.nSq = false;
                    if (this.nSd != null) {
                        this.nSd.Le(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.nSk) {
                    dRz();
                    return;
                } else {
                    dRy();
                    return;
                }
            case 3:
                removeMessages(7);
                this.nRY = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.nRY = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.nRZ = master.flame.danmaku.danmaku.c.c.dTf();
                if (this.nSc == null || !this.nSe.dRO()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    N(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.nRX = 0L;
                            c.this.mReady = true;
                            if (c.this.nSa != null) {
                                c.this.nSa.dRJ();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.nRY = true;
                dRA();
                this.nRX = this.nSb.nTw;
                if (this.nSj != null) {
                    dRD();
                    dRx();
                }
                if (i == 6) {
                    if (this.nSd != null) {
                        this.nSd.quit();
                    }
                    if (this.nSc != null) {
                        this.nSc.release();
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
                if (this.nSd != null) {
                    this.nSd.Le(2);
                }
                if (i == 6) {
                }
                this.nRY = true;
                dRA();
                this.nRX = this.nSb.nTw;
                if (this.nSj != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.nSf = true;
                Long l3 = (Long) message.obj;
                if (this.nSd == null) {
                    z = false;
                } else if (l3 == null) {
                    this.nSb.gv(getCurrentTime());
                    this.nSd.dRL();
                    z = false;
                } else {
                    this.nSd.start();
                    this.nSd.seek(l3.longValue());
                    this.nSd.dRL();
                    z = true;
                }
                if (this.nRY && this.nSe != null) {
                    this.nSe.dRP();
                }
                dRD();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.nRY = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.nSf = false;
                if (this.nSe != null) {
                    this.nSe.clear();
                }
                if (this.nSd != null) {
                    this.nSd.dRL();
                    this.nSd.dRN();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.nSd != null) {
                    this.nSd.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.nSd != null) {
                }
                if (i == 6) {
                }
                this.nRY = true;
                dRA();
                this.nRX = this.nSb.nTw;
                if (this.nSj != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.nRW.nVi.b(this.nRW);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.nRW.nVg.dSl();
                    this.nRW.nVg.dSk();
                    this.nSd.dRM();
                    return;
                }
                return;
            case 11:
                dRD();
                return;
            case 12:
                if (this.nRY && this.nSe != null) {
                    this.nSd.dRL();
                    this.nSe.dRP();
                    dRD();
                    return;
                }
                return;
            case 13:
                if (this.nSd != null) {
                    this.nSd.gr(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dRx() {
        if (this.nSj != null) {
            i iVar = this.nSj;
            this.nSj = null;
            synchronized (this.nSd) {
                this.nSd.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void dRy() {
        if (!this.nRY) {
            long go = go(master.flame.danmaku.danmaku.c.c.dTf());
            if (go < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - go);
                return;
            }
            long dRP = this.nSe.dRP();
            removeMessages(2);
            if (dRP > this.nSm) {
                this.nSb.gw(dRP);
                this.nSi.clear();
            }
            if (!this.nSf) {
                gp(10000000L);
                return;
            }
            if (this.nSh.nWj && this.nSv) {
                long j = this.nSh.endTime - this.nSb.nTw;
                if (j > 500) {
                    gp(j - 10);
                    return;
                }
            }
            if (dRP < this.nSn) {
                sendEmptyMessageDelayed(2, this.nSn - dRP);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void dRz() {
        if (this.nSj == null) {
            this.nSj = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long dTf = master.flame.danmaku.danmaku.c.c.dTf();
                    while (!dRR() && !c.this.nRY) {
                        long dTf2 = master.flame.danmaku.danmaku.c.c.dTf();
                        if (c.this.nSn - (master.flame.danmaku.danmaku.c.c.dTf() - dTf) <= 1) {
                            long go = c.this.go(dTf2);
                            if (go >= 0) {
                                long dRP = c.this.nSe.dRP();
                                if (dRP > c.this.nSm) {
                                    c.this.nSb.gw(dRP);
                                    c.this.nSi.clear();
                                }
                                if (!c.this.nSf) {
                                    c.this.gp(10000000L);
                                } else if (c.this.nSh.nWj && c.this.nSv) {
                                    long j = c.this.nSh.endTime - c.this.nSb.nTw;
                                    if (j > 500) {
                                        c.this.dRD();
                                        c.this.gp(j - 10);
                                    }
                                }
                                dTf = dTf2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gx(60 - go);
                                dTf = dTf2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gx(1L);
                        }
                    }
                }
            };
            this.nSj.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long go(long j) {
        long j2;
        long j3 = 0;
        if (this.nSq || this.nSt) {
            return 0L;
        }
        this.nSt = true;
        long j4 = j - this.nRZ;
        if (!this.nSf || this.nSh.nWj || this.nSu) {
            this.nSb.gv(j4);
            this.nSs = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.nSb.nTw;
            long max = Math.max(this.nSn, dRE());
            if (j2 <= 2000 && this.nSh.nWi <= this.nSl && max <= this.nSl) {
                long min = Math.min(this.nSl, Math.max(this.nSn, (j2 / this.nSn) + max));
                long j5 = min - this.nSp;
                if (j5 > 3 && j5 < 8 && this.nSp >= this.nSn && this.nSp <= this.nSl) {
                    min = this.nSp;
                }
                long j6 = j2 - min;
                this.nSp = min;
                j2 = min;
                j3 = j6;
            }
            this.nSs = j3;
            this.nSb.gw(j2);
        }
        if (this.nSa != null) {
            this.nSa.b(this.nSb);
        }
        this.nSt = false;
        return j2;
    }

    private void dRA() {
        if (this.nSu) {
            go(master.flame.danmaku.danmaku.c.c.dTf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRB() {
        this.nSl = Math.max(33L, ((float) 16) * 2.5f);
        this.nSm = ((float) this.nSl) * 2.5f;
        this.nSn = Math.max(16L, (16 / 15) * 15);
        this.nSo = this.nSn + 3;
    }

    private void N(final Runnable runnable) {
        if (this.nSd == null) {
            this.nSd = a(this.nSe.dRQ(), this.nSb, this.nSe.getContext(), this.nSe.getWidth(), this.nSe.getHeight(), this.nSe.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void dRG() {
                    c.this.dRB();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.isTimeOut()) {
                        long dSi = dVar.dSi() - c.this.getCurrentTime();
                        if (dSi < c.this.nRW.nVi.nVn && (c.this.nSu || c.this.nSh.nWj)) {
                            c.this.dRD();
                        } else if (dSi > 0 && dSi <= c.this.nRW.nVi.nVn) {
                            c.this.sendEmptyMessageDelayed(11, dSi);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.nSa != null) {
                        c.this.nSa.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dRH() {
                    if (c.this.nSa != null) {
                        c.this.nSa.dRK();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void dRI() {
                    c.this.dRC();
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
        this.nSg = this.nRW.dSG();
        this.nSg.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.nSg.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.nSg.aS(this.nRW.nUG);
        this.nSg.xu(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.nRW, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.nRW, aVar);
        aVar2.a(this.nSc);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nSd != null) {
            dVar.nTs = this.nRW.nVg;
            dVar.c(this.nSb);
            this.nSd.a(dVar);
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
        dRA();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.nSf) {
            this.nSf = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long xs(boolean z) {
        if (!this.nSf) {
            return this.nSb.nTw;
        }
        this.nSf = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.nSb.nTw;
    }

    public a.b al(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean dRV;
        if (this.nSd == null) {
            return this.nSh;
        }
        if (!this.nSu && (aVar = this.nRW.nUU) != null && ((dRV = aVar.dRV()) || this.nRY)) {
            int dRT = aVar.dRT();
            if (dRT == 2) {
                long j = this.nSb.nTw;
                long dRS = aVar.dRS();
                long j2 = dRS - j;
                if (Math.abs(j2) > aVar.dRU()) {
                    if (dRV && this.nRY) {
                        resume();
                    }
                    this.nSd.k(j, dRS, j2);
                    this.nSb.gv(dRS);
                    this.nRZ = master.flame.danmaku.danmaku.c.c.dTf() - dRS;
                    this.nSs = 0L;
                }
            } else if (dRT == 1 && dRV && !this.nRY) {
                pause();
            }
        }
        this.nSg.setExtraData(canvas);
        this.nSh.b(this.nSd.a(this.nSg));
        dRF();
        return this.nSh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRC() {
        if (this.nRY && this.nSf) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRD() {
        if (this.nSu) {
            if (this.nSd != null) {
                this.nSd.dRL();
            }
            if (this.nSk) {
                synchronized (this) {
                    this.nSi.clear();
                }
                synchronized (this.nSd) {
                    this.nSd.notifyAll();
                }
            } else {
                this.nSi.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.nSu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(long j) {
        if (!isStop() && isPrepared() && !this.nSq) {
            this.nSh.fDZ = master.flame.danmaku.danmaku.c.c.dTf();
            this.nSu = true;
            if (this.nSk) {
                if (this.nSj != null) {
                    try {
                        synchronized (this.nSd) {
                            if (j == 10000000) {
                                this.nSd.wait();
                            } else {
                                this.nSd.wait(j);
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

    private synchronized long dRE() {
        long longValue;
        int size = this.nSi.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.nSi.peekFirst();
            Long peekLast = this.nSi.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void dRF() {
        this.nSi.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.dTf()));
        if (this.nSi.size() > 500) {
            this.nSi.removeFirst();
        }
    }

    public void ea(int i, int i2) {
        if (this.nSg != null) {
            if (this.nSg.getWidth() != i || this.nSg.getHeight() != i2) {
                this.nSg.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void xo(boolean z) {
        if (this.nSd != null) {
            this.nSd.xo(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.nSd != null) {
            return this.nSd.gq(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.nSq) {
            return this.nSr;
        }
        if (this.nRY || !this.nSu) {
            return this.nSb.nTw - this.nSs;
        }
        return master.flame.danmaku.danmaku.c.c.dTf() - this.nRZ;
    }

    public DanmakuContext getConfig() {
        return this.nRW;
    }
}
