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
    private DanmakuContext ouG;
    private long ouH;
    private boolean ouI;
    private long ouJ;
    private a ouK;
    private master.flame.danmaku.danmaku.model.f ouL;
    private master.flame.danmaku.danmaku.a.a ouM;
    public h ouN;
    private g ouO;
    private boolean ouP;
    private master.flame.danmaku.danmaku.model.b ouQ;
    private final a.b ouR;
    private LinkedList<Long> ouS;
    private i ouT;
    private final boolean ouU;
    private long ouV;
    private long ouW;
    private long ouX;
    private long ouY;
    private long ouZ;
    private boolean ova;
    private long ovb;
    private long ovc;
    private boolean ovd;
    private boolean ove;
    private boolean ovf;

    /* loaded from: classes6.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void ehi();

        void ehj();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.ouH = 0L;
        this.ouI = true;
        this.ouL = new master.flame.danmaku.danmaku.model.f();
        this.ouP = true;
        this.ouR = new a.b();
        this.ouS = new LinkedList<>();
        this.ouV = 30L;
        this.ouW = 60L;
        this.ouX = 16L;
        this.ouU = Runtime.getRuntime().availableProcessors() > 3;
        this.ovf = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            h((Long) null);
        } else {
            yP(false);
        }
        this.ouP = z;
    }

    private void a(g gVar) {
        this.ouO = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.ouG = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.ouM = aVar;
    }

    public void setCallback(a aVar) {
        this.ouK = aVar;
    }

    public void quit() {
        this.ouI = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.ouI;
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
                    this.ouH = l.longValue();
                } else {
                    this.ouH = 0L;
                }
                if (i == 4) {
                    this.ouI = true;
                    egW();
                    Long l2 = (Long) message.obj;
                    this.ouJ -= l2.longValue() - this.ouL.owf;
                    this.ouL.gV(l2.longValue());
                    this.ouG.oxP.ehL();
                    if (this.ouN != null) {
                        this.ouN.seek(l2.longValue());
                    }
                    this.ouH = l2.longValue();
                }
                removeMessages(7);
                this.ouI = false;
                if (!this.mReady) {
                    this.ouR.reset();
                    this.ouS.clear();
                    this.ouJ = master.flame.danmaku.danmaku.c.c.eiF() - this.ouH;
                    this.ouL.gV(this.ouH);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.ouN.start();
                    ehc();
                    this.ova = false;
                    if (this.ouN != null) {
                        this.ouN.Ob(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.ouU) {
                    egY();
                    return;
                } else {
                    egX();
                    return;
                }
            case 3:
                removeMessages(7);
                this.ouI = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.ouI = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.ouJ = master.flame.danmaku.danmaku.c.c.eiF();
                if (this.ouM == null || !this.ouO.ehn()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    J(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ouH = 0L;
                            c.this.mReady = true;
                            if (c.this.ouK != null) {
                                c.this.ouK.ehi();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.ouI = true;
                egZ();
                this.ouH = this.ouL.owf;
                if (this.ouT != null) {
                    ehc();
                    egW();
                }
                if (i == 6) {
                    if (this.ouN != null) {
                        this.ouN.quit();
                    }
                    if (this.ouM != null) {
                        this.ouM.release();
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
                if (this.ouN != null) {
                    this.ouN.Ob(2);
                }
                if (i == 6) {
                }
                this.ouI = true;
                egZ();
                this.ouH = this.ouL.owf;
                if (this.ouT != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.ouP = true;
                Long l3 = (Long) message.obj;
                if (this.ouN == null) {
                    z = false;
                } else if (l3 == null) {
                    this.ouL.gV(getCurrentTime());
                    this.ouN.ehk();
                    z = false;
                } else {
                    this.ouN.start();
                    this.ouN.seek(l3.longValue());
                    this.ouN.ehk();
                    z = true;
                }
                if (this.ouI && this.ouO != null) {
                    this.ouO.eho();
                }
                ehc();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.ouI = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.ouP = false;
                if (this.ouO != null) {
                    this.ouO.clear();
                }
                if (this.ouN != null) {
                    this.ouN.ehk();
                    this.ouN.ehm();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.ouN != null) {
                    this.ouN.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.ouN != null) {
                }
                if (i == 6) {
                }
                this.ouI = true;
                egZ();
                this.ouH = this.ouL.owf;
                if (this.ouT != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.ouG.oxR.b(this.ouG);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.ouG.oxP.ehL();
                    this.ouG.oxP.ehK();
                    this.ouN.ehl();
                    return;
                }
                return;
            case 11:
                ehc();
                return;
            case 12:
                if (this.ouI && this.ouO != null) {
                    this.ouN.ehk();
                    this.ouO.eho();
                    ehc();
                    return;
                }
                return;
            case 13:
                if (this.ouN != null) {
                    this.ouN.gR(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void egW() {
        if (this.ouT != null) {
            i iVar = this.ouT;
            this.ouT = null;
            synchronized (this.ouN) {
                this.ouN.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void egX() {
        if (!this.ouI) {
            long gO = gO(master.flame.danmaku.danmaku.c.c.eiF());
            if (gO < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - gO);
                return;
            }
            long eho = this.ouO.eho();
            removeMessages(2);
            if (eho > this.ouW) {
                this.ouL.gW(eho);
                this.ouS.clear();
            }
            if (!this.ouP) {
                gP(10000000L);
                return;
            }
            if (this.ouR.oyS && this.ovf) {
                long j = this.ouR.endTime - this.ouL.owf;
                if (j > 500) {
                    gP(j - 10);
                    return;
                }
            }
            if (eho < this.ouX) {
                sendEmptyMessageDelayed(2, this.ouX - eho);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void egY() {
        if (this.ouT == null) {
            this.ouT = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long eiF = master.flame.danmaku.danmaku.c.c.eiF();
                    while (!ehq() && !c.this.ouI) {
                        long eiF2 = master.flame.danmaku.danmaku.c.c.eiF();
                        if (c.this.ouX - (master.flame.danmaku.danmaku.c.c.eiF() - eiF) <= 1) {
                            long gO = c.this.gO(eiF2);
                            if (gO >= 0) {
                                long eho = c.this.ouO.eho();
                                if (eho > c.this.ouW) {
                                    c.this.ouL.gW(eho);
                                    c.this.ouS.clear();
                                }
                                if (!c.this.ouP) {
                                    c.this.gP(10000000L);
                                } else if (c.this.ouR.oyS && c.this.ovf) {
                                    long j = c.this.ouR.endTime - c.this.ouL.owf;
                                    if (j > 500) {
                                        c.this.ehc();
                                        c.this.gP(j - 10);
                                    }
                                }
                                eiF = eiF2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.gX(60 - gO);
                                eiF = eiF2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.gX(1L);
                        }
                    }
                }
            };
            this.ouT.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long gO(long j) {
        long j2;
        long j3 = 0;
        if (this.ova || this.ovd) {
            return 0L;
        }
        this.ovd = true;
        long j4 = j - this.ouJ;
        if (!this.ouP || this.ouR.oyS || this.ove) {
            this.ouL.gV(j4);
            this.ovc = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.ouL.owf;
            long max = Math.max(this.ouX, ehd());
            if (j2 <= 2000 && this.ouR.oyR <= this.ouV && max <= this.ouV) {
                long min = Math.min(this.ouV, Math.max(this.ouX, (j2 / this.ouX) + max));
                long j5 = min - this.ouZ;
                if (j5 > 3 && j5 < 8 && this.ouZ >= this.ouX && this.ouZ <= this.ouV) {
                    min = this.ouZ;
                }
                long j6 = j2 - min;
                this.ouZ = min;
                j2 = min;
                j3 = j6;
            }
            this.ovc = j3;
            this.ouL.gW(j2);
        }
        if (this.ouK != null) {
            this.ouK.b(this.ouL);
        }
        this.ovd = false;
        return j2;
    }

    private void egZ() {
        if (this.ove) {
            gO(master.flame.danmaku.danmaku.c.c.eiF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eha() {
        this.ouV = Math.max(33L, ((float) 16) * 2.5f);
        this.ouW = ((float) this.ouV) * 2.5f;
        this.ouX = Math.max(16L, (16 / 15) * 15);
        this.ouY = this.ouX + 3;
    }

    private void J(final Runnable runnable) {
        if (this.ouN == null) {
            this.ouN = a(this.ouO.ehp(), this.ouL, this.ouO.getContext(), this.ouO.getWidth(), this.ouO.getHeight(), this.ouO.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void ehf() {
                    c.this.eha();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.ehy()) {
                        long ehI = dVar.ehI() - c.this.getCurrentTime();
                        if (ehI < c.this.ouG.oxR.oxW && (c.this.ove || c.this.ouR.oyS)) {
                            c.this.ehc();
                        } else if (ehI > 0 && ehI <= c.this.ouG.oxR.oxW) {
                            c.this.sendEmptyMessageDelayed(11, ehI);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.ouK != null) {
                        c.this.ouK.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void ehg() {
                    if (c.this.ouK != null) {
                        c.this.ouK.ehj();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void ehh() {
                    c.this.ehb();
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
        this.ouQ = this.ouG.eig();
        this.ouQ.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.ouQ.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.ouQ.aX(this.ouG.oxp);
        this.ouQ.yR(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.ouG, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.ouG, aVar);
        aVar2.a(this.ouM);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.ouN != null) {
            dVar.owb = this.ouG.oxP;
            dVar.c(this.ouL);
            this.ouN.a(dVar);
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
        egZ();
        sendEmptyMessage(7);
    }

    public void h(Long l) {
        if (!this.ouP) {
            this.ouP = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long yP(boolean z) {
        if (!this.ouP) {
            return this.ouL.owf;
        }
        this.ouP = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.ouL.owf;
    }

    public a.b ar(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean ehu;
        if (this.ouN == null) {
            return this.ouR;
        }
        if (!this.ove && (aVar = this.ouG.oxD) != null && ((ehu = aVar.ehu()) || this.ouI)) {
            int ehs = aVar.ehs();
            if (ehs == 2) {
                long j = this.ouL.owf;
                long ehr = aVar.ehr();
                long j2 = ehr - j;
                if (Math.abs(j2) > aVar.eht()) {
                    if (ehu && this.ouI) {
                        resume();
                    }
                    this.ouN.k(j, ehr, j2);
                    this.ouL.gV(ehr);
                    this.ouJ = master.flame.danmaku.danmaku.c.c.eiF() - ehr;
                    this.ovc = 0L;
                }
            } else if (ehs == 1 && ehu && !this.ouI) {
                pause();
            }
        }
        this.ouQ.setExtraData(canvas);
        this.ouR.b(this.ouN.a(this.ouQ));
        ehe();
        return this.ouR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehb() {
        if (this.ouI && this.ouP) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehc() {
        if (this.ove) {
            if (this.ouN != null) {
                this.ouN.ehk();
            }
            if (this.ouU) {
                synchronized (this) {
                    this.ouS.clear();
                }
                synchronized (this.ouN) {
                    this.ouN.notifyAll();
                }
            } else {
                this.ouS.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.ove = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gP(long j) {
        if (!isStop() && isPrepared() && !this.ova) {
            this.ouR.fUL = master.flame.danmaku.danmaku.c.c.eiF();
            this.ove = true;
            if (this.ouU) {
                if (this.ouT != null) {
                    try {
                        synchronized (this.ouN) {
                            if (j == 10000000) {
                                this.ouN.wait();
                            } else {
                                this.ouN.wait(j);
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

    private synchronized long ehd() {
        long longValue;
        int size = this.ouS.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.ouS.peekFirst();
            Long peekLast = this.ouS.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void ehe() {
        this.ouS.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.eiF()));
        if (this.ouS.size() > 500) {
            this.ouS.removeFirst();
        }
    }

    public void ek(int i, int i2) {
        if (this.ouQ != null) {
            if (this.ouQ.getWidth() != i || this.ouQ.getHeight() != i2) {
                this.ouQ.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void yL(boolean z) {
        if (this.ouN != null) {
            this.ouN.yL(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.ouN != null) {
            return this.ouN.gQ(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.ova) {
            return this.ovb;
        }
        if (this.ouI || !this.ove) {
            return this.ouL.owf - this.ovc;
        }
        return master.flame.danmaku.danmaku.c.c.eiF() - this.ouJ;
    }

    public DanmakuContext getConfig() {
        return this.ouG;
    }
}
