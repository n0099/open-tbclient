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
    private DanmakuContext oTT;
    private long oTU;
    private boolean oTV;
    private long oTW;
    private a oTX;
    private master.flame.danmaku.danmaku.model.f oTY;
    private master.flame.danmaku.danmaku.a.a oTZ;
    public h oUa;
    private g oUb;
    private boolean oUc;
    private master.flame.danmaku.danmaku.model.b oUd;
    private final a.b oUe;
    private LinkedList<Long> oUf;
    private i oUg;
    private final boolean oUh;
    private long oUi;
    private long oUj;
    private long oUk;
    private long oUl;
    private long oUm;
    private boolean oUn;
    private long oUo;
    private long oUp;
    private boolean oUq;
    private boolean oUr;
    private boolean oUs;

    /* loaded from: classes6.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void epb();

        void epc();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.oTU = 0L;
        this.oTV = true;
        this.oTY = new master.flame.danmaku.danmaku.model.f();
        this.oUc = true;
        this.oUe = new a.b();
        this.oUf = new LinkedList<>();
        this.oUi = 30L;
        this.oUj = 60L;
        this.oUk = 16L;
        this.oUh = Runtime.getRuntime().availableProcessors() > 3;
        this.oUs = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            i((Long) null);
        } else {
            zG(false);
        }
        this.oUc = z;
    }

    private void a(g gVar) {
        this.oUb = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.oTT = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.oTZ = aVar;
    }

    public void setCallback(a aVar) {
        this.oTX = aVar;
    }

    public void quit() {
        this.oTV = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.oTV;
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
                    this.oTU = l.longValue();
                } else {
                    this.oTU = 0L;
                }
                if (i == 4) {
                    this.oTV = true;
                    eoP();
                    Long l2 = (Long) message.obj;
                    this.oTW -= l2.longValue() - this.oTY.oVs;
                    this.oTY.hD(l2.longValue());
                    this.oTT.oXb.epE();
                    if (this.oUa != null) {
                        this.oUa.seek(l2.longValue());
                    }
                    this.oTU = l2.longValue();
                }
                removeMessages(7);
                this.oTV = false;
                if (!this.mReady) {
                    this.oUe.reset();
                    this.oUf.clear();
                    this.oTW = master.flame.danmaku.danmaku.c.c.eqy() - this.oTU;
                    this.oTY.hD(this.oTU);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.oUa.start();
                    eoV();
                    this.oUn = false;
                    if (this.oUa != null) {
                        this.oUa.Pm(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.oUh) {
                    eoR();
                    return;
                } else {
                    eoQ();
                    return;
                }
            case 3:
                removeMessages(7);
                this.oTV = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.oTV = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.oTW = master.flame.danmaku.danmaku.c.c.eqy();
                if (this.oTZ == null || !this.oUb.epg()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    J(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.oTU = 0L;
                            c.this.mReady = true;
                            if (c.this.oTX != null) {
                                c.this.oTX.epb();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.oTV = true;
                eoS();
                this.oTU = this.oTY.oVs;
                if (this.oUg != null) {
                    eoV();
                    eoP();
                }
                if (i == 6) {
                    if (this.oUa != null) {
                        this.oUa.quit();
                    }
                    if (this.oTZ != null) {
                        this.oTZ.release();
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
                if (this.oUa != null) {
                    this.oUa.Pm(2);
                }
                if (i == 6) {
                }
                this.oTV = true;
                eoS();
                this.oTU = this.oTY.oVs;
                if (this.oUg != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.oUc = true;
                Long l3 = (Long) message.obj;
                if (this.oUa == null) {
                    z = false;
                } else if (l3 == null) {
                    this.oTY.hD(getCurrentTime());
                    this.oUa.epd();
                    z = false;
                } else {
                    this.oUa.start();
                    this.oUa.seek(l3.longValue());
                    this.oUa.epd();
                    z = true;
                }
                if (this.oTV && this.oUb != null) {
                    this.oUb.eph();
                }
                eoV();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.oTV = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.oUc = false;
                if (this.oUb != null) {
                    this.oUb.clear();
                }
                if (this.oUa != null) {
                    this.oUa.epd();
                    this.oUa.epf();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.oUa != null) {
                    this.oUa.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.oUa != null) {
                }
                if (i == 6) {
                }
                this.oTV = true;
                eoS();
                this.oTU = this.oTY.oVs;
                if (this.oUg != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.oTT.oXd.b(this.oTT);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.oTT.oXb.epE();
                    this.oTT.oXb.epD();
                    this.oUa.epe();
                    return;
                }
                return;
            case 11:
                eoV();
                return;
            case 12:
                if (this.oTV && this.oUb != null) {
                    this.oUa.epd();
                    this.oUb.eph();
                    eoV();
                    return;
                }
                return;
            case 13:
                if (this.oUa != null) {
                    this.oUa.hz(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void eoP() {
        if (this.oUg != null) {
            i iVar = this.oUg;
            this.oUg = null;
            synchronized (this.oUa) {
                this.oUa.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void eoQ() {
        if (!this.oTV) {
            long hw = hw(master.flame.danmaku.danmaku.c.c.eqy());
            if (hw < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - hw);
                return;
            }
            long eph = this.oUb.eph();
            removeMessages(2);
            if (eph > this.oUj) {
                this.oTY.hE(eph);
                this.oUf.clear();
            }
            if (!this.oUc) {
                hx(10000000L);
                return;
            }
            if (this.oUe.oYd && this.oUs) {
                long j = this.oUe.endTime - this.oTY.oVs;
                if (j > 500) {
                    hx(j - 10);
                    return;
                }
            }
            if (eph < this.oUk) {
                sendEmptyMessageDelayed(2, this.oUk - eph);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void eoR() {
        if (this.oUg == null) {
            this.oUg = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long eqy = master.flame.danmaku.danmaku.c.c.eqy();
                    while (!epj() && !c.this.oTV) {
                        long eqy2 = master.flame.danmaku.danmaku.c.c.eqy();
                        if (c.this.oUk - (master.flame.danmaku.danmaku.c.c.eqy() - eqy) <= 1) {
                            long hw = c.this.hw(eqy2);
                            if (hw >= 0) {
                                long eph = c.this.oUb.eph();
                                if (eph > c.this.oUj) {
                                    c.this.oTY.hE(eph);
                                    c.this.oUf.clear();
                                }
                                if (!c.this.oUc) {
                                    c.this.hx(10000000L);
                                } else if (c.this.oUe.oYd && c.this.oUs) {
                                    long j = c.this.oUe.endTime - c.this.oTY.oVs;
                                    if (j > 500) {
                                        c.this.eoV();
                                        c.this.hx(j - 10);
                                    }
                                }
                                eqy = eqy2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.hF(60 - hw);
                                eqy = eqy2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.hF(1L);
                        }
                    }
                }
            };
            this.oUg.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long hw(long j) {
        long j2;
        long j3 = 0;
        if (this.oUn || this.oUq) {
            return 0L;
        }
        this.oUq = true;
        long j4 = j - this.oTW;
        if (!this.oUc || this.oUe.oYd || this.oUr) {
            this.oTY.hD(j4);
            this.oUp = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.oTY.oVs;
            long max = Math.max(this.oUk, eoW());
            if (j2 <= 2000 && this.oUe.oYc <= this.oUi && max <= this.oUi) {
                long min = Math.min(this.oUi, Math.max(this.oUk, (j2 / this.oUk) + max));
                long j5 = min - this.oUm;
                if (j5 > 3 && j5 < 8 && this.oUm >= this.oUk && this.oUm <= this.oUi) {
                    min = this.oUm;
                }
                long j6 = j2 - min;
                this.oUm = min;
                j2 = min;
                j3 = j6;
            }
            this.oUp = j3;
            this.oTY.hE(j2);
        }
        if (this.oTX != null) {
            this.oTX.b(this.oTY);
        }
        this.oUq = false;
        return j2;
    }

    private void eoS() {
        if (this.oUr) {
            hw(master.flame.danmaku.danmaku.c.c.eqy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eoT() {
        this.oUi = Math.max(33L, ((float) 16) * 2.5f);
        this.oUj = ((float) this.oUi) * 2.5f;
        this.oUk = Math.max(16L, (16 / 15) * 15);
        this.oUl = this.oUk + 3;
    }

    private void J(final Runnable runnable) {
        if (this.oUa == null) {
            this.oUa = a(this.oUb.epi(), this.oTY, this.oUb.getContext(), this.oUb.getWidth(), this.oUb.getHeight(), this.oUb.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void eoY() {
                    c.this.eoT();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.epr()) {
                        long epB = dVar.epB() - c.this.getCurrentTime();
                        if (epB < c.this.oTT.oXd.oXi && (c.this.oUr || c.this.oUe.oYd)) {
                            c.this.eoV();
                        } else if (epB > 0 && epB <= c.this.oTT.oXd.oXi) {
                            c.this.sendEmptyMessageDelayed(11, epB);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.oTX != null) {
                        c.this.oTX.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void eoZ() {
                    if (c.this.oTX != null) {
                        c.this.oTX.epc();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void epa() {
                    c.this.eoU();
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
        this.oUd = this.oTT.epZ();
        this.oUd.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.oUd.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.oUd.bd(this.oTT.oWB);
        this.oUd.zI(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.oTT, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.oTT, aVar);
        aVar2.a(this.oTZ);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oUa != null) {
            dVar.oVo = this.oTT.oXb;
            dVar.c(this.oTY);
            this.oUa.a(dVar);
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
        eoS();
        sendEmptyMessage(7);
    }

    public void i(Long l) {
        if (!this.oUc) {
            this.oUc = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long zG(boolean z) {
        if (!this.oUc) {
            return this.oTY.oVs;
        }
        this.oUc = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.oTY.oVs;
    }

    public a.b as(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean epn;
        if (this.oUa == null) {
            return this.oUe;
        }
        if (!this.oUr && (aVar = this.oTT.oWP) != null && ((epn = aVar.epn()) || this.oTV)) {
            int epl = aVar.epl();
            if (epl == 2) {
                long j = this.oTY.oVs;
                long epk = aVar.epk();
                long j2 = epk - j;
                if (Math.abs(j2) > aVar.epm()) {
                    if (epn && this.oTV) {
                        resume();
                    }
                    this.oUa.k(j, epk, j2);
                    this.oTY.hD(epk);
                    this.oTW = master.flame.danmaku.danmaku.c.c.eqy() - epk;
                    this.oUp = 0L;
                }
            } else if (epl == 1 && epn && !this.oTV) {
                pause();
            }
        }
        this.oUd.setExtraData(canvas);
        this.oUe.b(this.oUa.a(this.oUd));
        eoX();
        return this.oUe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eoU() {
        if (this.oTV && this.oUc) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eoV() {
        if (this.oUr) {
            if (this.oUa != null) {
                this.oUa.epd();
            }
            if (this.oUh) {
                synchronized (this) {
                    this.oUf.clear();
                }
                synchronized (this.oUa) {
                    this.oUa.notifyAll();
                }
            } else {
                this.oUf.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.oUr = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hx(long j) {
        if (!isStop() && isPrepared() && !this.oUn) {
            this.oUe.gkv = master.flame.danmaku.danmaku.c.c.eqy();
            this.oUr = true;
            if (this.oUh) {
                if (this.oUg != null) {
                    try {
                        synchronized (this.oUa) {
                            if (j == 10000000) {
                                this.oUa.wait();
                            } else {
                                this.oUa.wait(j);
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

    private synchronized long eoW() {
        long longValue;
        int size = this.oUf.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.oUf.peekFirst();
            Long peekLast = this.oUf.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void eoX() {
        this.oUf.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.eqy()));
        if (this.oUf.size() > 500) {
            this.oUf.removeFirst();
        }
    }

    public void eo(int i, int i2) {
        if (this.oUd != null) {
            if (this.oUd.getWidth() != i || this.oUd.getHeight() != i2) {
                this.oUd.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void zC(boolean z) {
        if (this.oUa != null) {
            this.oUa.zC(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.oUa != null) {
            return this.oUa.hy(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.oUn) {
            return this.oUo;
        }
        if (this.oTV || !this.oUr) {
            return this.oTY.oVs - this.oUp;
        }
        return master.flame.danmaku.danmaku.c.c.eqy() - this.oTW;
    }

    public DanmakuContext getConfig() {
        return this.oTT;
    }
}
