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
    private DanmakuContext ouY;
    private long ouZ;
    private boolean ova;
    private long ovb;
    private a ovc;
    private master.flame.danmaku.danmaku.model.f ovd;
    private master.flame.danmaku.danmaku.a.a ove;
    public h ovf;
    private g ovg;
    private boolean ovh;
    private master.flame.danmaku.danmaku.model.b ovi;
    private final a.b ovj;
    private LinkedList<Long> ovk;
    private i ovl;
    private final boolean ovm;
    private long ovn;
    private long ovo;
    private long ovp;
    private long ovq;
    private long ovr;
    private boolean ovs;
    private long ovt;
    private long ovu;
    private boolean ovv;
    private boolean ovw;
    private boolean ovx;

    /* loaded from: classes6.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void ehr();

        void ehs();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.ouZ = 0L;
        this.ova = true;
        this.ovd = new master.flame.danmaku.danmaku.model.f();
        this.ovh = true;
        this.ovj = new a.b();
        this.ovk = new LinkedList<>();
        this.ovn = 30L;
        this.ovo = 60L;
        this.ovp = 16L;
        this.ovm = Runtime.getRuntime().availableProcessors() > 3;
        this.ovx = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            yR(false);
        }
        this.ovh = z;
    }

    private void a(g gVar) {
        this.ovg = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.ouY = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.ove = aVar;
    }

    public void setCallback(a aVar) {
        this.ovc = aVar;
    }

    public void quit() {
        this.ova = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.ova;
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
                    this.ouZ = l.longValue();
                } else {
                    this.ouZ = 0L;
                }
                if (i == 4) {
                    this.ova = true;
                    ehf();
                    Long l2 = (Long) message.obj;
                    this.ovb -= l2.longValue() - this.ovd.owx;
                    this.ovd.gX(l2.longValue());
                    this.ouY.oyh.ehU();
                    if (this.ovf != null) {
                        this.ovf.seek(l2.longValue());
                    }
                    this.ouZ = l2.longValue();
                }
                removeMessages(7);
                this.ova = false;
                if (!this.mReady) {
                    this.ovj.reset();
                    this.ovk.clear();
                    this.ovb = master.flame.danmaku.danmaku.c.c.eiO() - this.ouZ;
                    this.ovd.gX(this.ouZ);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.ovf.start();
                    ehl();
                    this.ovs = false;
                    if (this.ovf != null) {
                        this.ovf.Ob(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.ovm) {
                    ehh();
                    return;
                } else {
                    ehg();
                    return;
                }
            case 3:
                removeMessages(7);
                this.ova = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.ova = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.ovb = master.flame.danmaku.danmaku.c.c.eiO();
                if (this.ove == null || !this.ovg.ehw()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    J(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ouZ = 0L;
                            c.this.mReady = true;
                            if (c.this.ovc != null) {
                                c.this.ovc.ehr();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.ova = true;
                ehi();
                this.ouZ = this.ovd.owx;
                if (this.ovl != null) {
                    ehl();
                    ehf();
                }
                if (i == 6) {
                    if (this.ovf != null) {
                        this.ovf.quit();
                    }
                    if (this.ove != null) {
                        this.ove.release();
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
                if (this.ovf != null) {
                    this.ovf.Ob(2);
                }
                if (i == 6) {
                }
                this.ova = true;
                ehi();
                this.ouZ = this.ovd.owx;
                if (this.ovl != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.ovh = true;
                Long l3 = (Long) message.obj;
                if (this.ovf == null) {
                    z = false;
                } else if (l3 == null) {
                    this.ovd.gX(getCurrentTime());
                    this.ovf.eht();
                    z = false;
                } else {
                    this.ovf.start();
                    this.ovf.seek(l3.longValue());
                    this.ovf.eht();
                    z = true;
                }
                if (this.ova && this.ovg != null) {
                    this.ovg.ehx();
                }
                ehl();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.ova = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.ovh = false;
                if (this.ovg != null) {
                    this.ovg.clear();
                }
                if (this.ovf != null) {
                    this.ovf.eht();
                    this.ovf.ehv();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.ovf != null) {
                    this.ovf.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.ovf != null) {
                }
                if (i == 6) {
                }
                this.ova = true;
                ehi();
                this.ouZ = this.ovd.owx;
                if (this.ovl != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.ouY.oyj.b(this.ouY);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.ouY.oyh.ehU();
                    this.ouY.oyh.ehT();
                    this.ovf.ehu();
                    return;
                }
                return;
            case 11:
                ehl();
                return;
            case 12:
                if (this.ova && this.ovg != null) {
                    this.ovf.eht();
                    this.ovg.ehx();
                    ehl();
                    return;
                }
                return;
            case 13:
                if (this.ovf != null) {
                    this.ovf.gT(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void ehf() {
        if (this.ovl != null) {
            i iVar = this.ovl;
            this.ovl = null;
            synchronized (this.ovf) {
                this.ovf.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void ehg() {
        if (!this.ova) {
            long gQ = gQ(master.flame.danmaku.danmaku.c.c.eiO());
            if (gQ < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - gQ);
                return;
            }
            long ehx = this.ovg.ehx();
            removeMessages(2);
            if (ehx > this.ovo) {
                this.ovd.gY(ehx);
                this.ovk.clear();
            }
            if (!this.ovh) {
                gR(10000000L);
                return;
            }
            if (this.ovj.ozk && this.ovx) {
                long j = this.ovj.endTime - this.ovd.owx;
                if (j > 500) {
                    gR(j - 10);
                    return;
                }
            }
            if (ehx < this.ovp) {
                sendEmptyMessageDelayed(2, this.ovp - ehx);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void ehh() {
        if (this.ovl == null) {
            this.ovl = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long eiO = master.flame.danmaku.danmaku.c.c.eiO();
                    while (!ehz() && !c.this.ova) {
                        long eiO2 = master.flame.danmaku.danmaku.c.c.eiO();
                        if (c.this.ovp - (master.flame.danmaku.danmaku.c.c.eiO() - eiO) <= 1) {
                            long gQ = c.this.gQ(eiO2);
                            if (gQ >= 0) {
                                long ehx = c.this.ovg.ehx();
                                if (ehx > c.this.ovo) {
                                    c.this.ovd.gY(ehx);
                                    c.this.ovk.clear();
                                }
                                if (!c.this.ovh) {
                                    c.this.gR(10000000L);
                                } else if (c.this.ovj.ozk && c.this.ovx) {
                                    long j = c.this.ovj.endTime - c.this.ovd.owx;
                                    if (j > 500) {
                                        c.this.ehl();
                                        c.this.gR(j - 10);
                                    }
                                }
                                eiO = eiO2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gZ(60 - gQ);
                                eiO = eiO2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gZ(1L);
                        }
                    }
                }
            };
            this.ovl.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long gQ(long j) {
        long j2;
        long j3 = 0;
        if (this.ovs || this.ovv) {
            return 0L;
        }
        this.ovv = true;
        long j4 = j - this.ovb;
        if (!this.ovh || this.ovj.ozk || this.ovw) {
            this.ovd.gX(j4);
            this.ovu = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.ovd.owx;
            long max = Math.max(this.ovp, ehm());
            if (j2 <= 2000 && this.ovj.ozj <= this.ovn && max <= this.ovn) {
                long min = Math.min(this.ovn, Math.max(this.ovp, (j2 / this.ovp) + max));
                long j5 = min - this.ovr;
                if (j5 > 3 && j5 < 8 && this.ovr >= this.ovp && this.ovr <= this.ovn) {
                    min = this.ovr;
                }
                long j6 = j2 - min;
                this.ovr = min;
                j2 = min;
                j3 = j6;
            }
            this.ovu = j3;
            this.ovd.gY(j2);
        }
        if (this.ovc != null) {
            this.ovc.b(this.ovd);
        }
        this.ovv = false;
        return j2;
    }

    private void ehi() {
        if (this.ovw) {
            gQ(master.flame.danmaku.danmaku.c.c.eiO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehj() {
        this.ovn = Math.max(33L, ((float) 16) * 2.5f);
        this.ovo = ((float) this.ovn) * 2.5f;
        this.ovp = Math.max(16L, (16 / 15) * 15);
        this.ovq = this.ovp + 3;
    }

    private void J(final Runnable runnable) {
        if (this.ovf == null) {
            this.ovf = a(this.ovg.ehy(), this.ovd, this.ovg.getContext(), this.ovg.getWidth(), this.ovg.getHeight(), this.ovg.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void eho() {
                    c.this.ehj();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.ehH()) {
                        long ehR = dVar.ehR() - c.this.getCurrentTime();
                        if (ehR < c.this.ouY.oyj.oyo && (c.this.ovw || c.this.ovj.ozk)) {
                            c.this.ehl();
                        } else if (ehR > 0 && ehR <= c.this.ouY.oyj.oyo) {
                            c.this.sendEmptyMessageDelayed(11, ehR);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.ovc != null) {
                        c.this.ovc.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void ehp() {
                    if (c.this.ovc != null) {
                        c.this.ovc.ehs();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void ehq() {
                    c.this.ehk();
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
        this.ovi = this.ouY.eip();
        this.ovi.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.ovi.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.ovi.aX(this.ouY.oxH);
        this.ovi.yT(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.ouY, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.ouY, aVar);
        aVar2.a(this.ove);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.ovf != null) {
            dVar.owt = this.ouY.oyh;
            dVar.c(this.ovd);
            this.ovf.a(dVar);
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
        ehi();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.ovh) {
            this.ovh = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long yR(boolean z) {
        if (!this.ovh) {
            return this.ovd.owx;
        }
        this.ovh = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.ovd.owx;
    }

    public a.b ar(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean ehD;
        if (this.ovf == null) {
            return this.ovj;
        }
        if (!this.ovw && (aVar = this.ouY.oxV) != null && ((ehD = aVar.ehD()) || this.ova)) {
            int ehB = aVar.ehB();
            if (ehB == 2) {
                long j = this.ovd.owx;
                long ehA = aVar.ehA();
                long j2 = ehA - j;
                if (Math.abs(j2) > aVar.ehC()) {
                    if (ehD && this.ova) {
                        resume();
                    }
                    this.ovf.k(j, ehA, j2);
                    this.ovd.gX(ehA);
                    this.ovb = master.flame.danmaku.danmaku.c.c.eiO() - ehA;
                    this.ovu = 0L;
                }
            } else if (ehB == 1 && ehD && !this.ova) {
                pause();
            }
        }
        this.ovi.setExtraData(canvas);
        this.ovj.b(this.ovf.a(this.ovi));
        ehn();
        return this.ovj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehk() {
        if (this.ova && this.ovh) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehl() {
        if (this.ovw) {
            if (this.ovf != null) {
                this.ovf.eht();
            }
            if (this.ovm) {
                synchronized (this) {
                    this.ovk.clear();
                }
                synchronized (this.ovf) {
                    this.ovf.notifyAll();
                }
            } else {
                this.ovk.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.ovw = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(long j) {
        if (!isStop() && isPrepared() && !this.ovs) {
            this.ovj.fUP = master.flame.danmaku.danmaku.c.c.eiO();
            this.ovw = true;
            if (this.ovm) {
                if (this.ovl != null) {
                    try {
                        synchronized (this.ovf) {
                            if (j == 10000000) {
                                this.ovf.wait();
                            } else {
                                this.ovf.wait(j);
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

    private synchronized long ehm() {
        long longValue;
        int size = this.ovk.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.ovk.peekFirst();
            Long peekLast = this.ovk.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void ehn() {
        this.ovk.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.eiO()));
        if (this.ovk.size() > 500) {
            this.ovk.removeFirst();
        }
    }

    public void ek(int i, int i2) {
        if (this.ovi != null) {
            if (this.ovi.getWidth() != i || this.ovi.getHeight() != i2) {
                this.ovi.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void yN(boolean z) {
        if (this.ovf != null) {
            this.ovf.yN(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.ovf != null) {
            return this.ovf.gS(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.ovs) {
            return this.ovt;
        }
        if (this.ova || !this.ovw) {
            return this.ovd.owx - this.ovu;
        }
        return master.flame.danmaku.danmaku.c.c.eiO() - this.ovb;
    }

    public DanmakuContext getConfig() {
        return this.ouY;
    }
}
