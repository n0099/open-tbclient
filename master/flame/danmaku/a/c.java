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
    private DanmakuContext oEE;
    private long oEF;
    private boolean oEG;
    private long oEH;
    private a oEI;
    private master.flame.danmaku.danmaku.model.f oEJ;
    private master.flame.danmaku.danmaku.a.a oEK;
    public h oEL;
    private g oEM;
    private boolean oEN;
    private master.flame.danmaku.danmaku.model.b oEO;
    private final a.b oEP;
    private LinkedList<Long> oEQ;
    private i oER;
    private final boolean oES;
    private long oET;
    private long oEU;
    private long oEV;
    private long oEW;
    private long oEX;
    private boolean oEY;
    private long oEZ;
    private long oFa;
    private boolean oFb;
    private boolean oFc;
    private boolean oFd;

    /* loaded from: classes6.dex */
    public interface a {
        void b(master.flame.danmaku.danmaku.model.f fVar);

        void elo();

        void elp();

        void j(master.flame.danmaku.danmaku.model.d dVar);
    }

    public c(Looper looper, g gVar, boolean z) {
        super(looper);
        this.oEF = 0L;
        this.oEG = true;
        this.oEJ = new master.flame.danmaku.danmaku.model.f();
        this.oEN = true;
        this.oEP = new a.b();
        this.oEQ = new LinkedList<>();
        this.oET = 30L;
        this.oEU = 60L;
        this.oEV = 16L;
        this.oES = Runtime.getRuntime().availableProcessors() > 3;
        this.oFd = DeviceUtils.isProblemBoxDevice() ? false : true;
        a(gVar);
        if (z) {
            i((Long) null);
        } else {
            yZ(false);
        }
        this.oEN = z;
    }

    private void a(g gVar) {
        this.oEM = gVar;
    }

    public void a(DanmakuContext danmakuContext) {
        this.oEE = danmakuContext;
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar) {
        this.oEK = aVar;
    }

    public void setCallback(a aVar) {
        this.oEI = aVar;
    }

    public void quit() {
        this.oEG = true;
        sendEmptyMessage(6);
    }

    public boolean isStop() {
        return this.oEG;
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
                    this.oEF = l.longValue();
                } else {
                    this.oEF = 0L;
                }
                if (i == 4) {
                    this.oEG = true;
                    elc();
                    Long l2 = (Long) message.obj;
                    this.oEH -= l2.longValue() - this.oEJ.oGd;
                    this.oEJ.hl(l2.longValue());
                    this.oEE.oHM.elR();
                    if (this.oEL != null) {
                        this.oEL.seek(l2.longValue());
                    }
                    this.oEF = l2.longValue();
                }
                removeMessages(7);
                this.oEG = false;
                if (!this.mReady) {
                    this.oEP.reset();
                    this.oEQ.clear();
                    this.oEH = master.flame.danmaku.danmaku.c.c.emL() - this.oEF;
                    this.oEJ.hl(this.oEF);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.oEL.start();
                    eli();
                    this.oEY = false;
                    if (this.oEL != null) {
                        this.oEL.OG(1);
                        return;
                    }
                    return;
                }
                sendEmptyMessageDelayed(3, 100L);
                return;
            case 2:
                if (this.oES) {
                    ele();
                    return;
                } else {
                    eld();
                    return;
                }
            case 3:
                removeMessages(7);
                this.oEG = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.oEG = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                this.oEH = master.flame.danmaku.danmaku.c.c.emL();
                if (this.oEK == null || !this.oEM.elt()) {
                    sendEmptyMessageDelayed(5, 100L);
                    return;
                } else {
                    J(new Runnable() { // from class: master.flame.danmaku.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.oEF = 0L;
                            c.this.mReady = true;
                            if (c.this.oEI != null) {
                                c.this.oEI.elo();
                            }
                        }
                    });
                    return;
                }
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.oEG = true;
                elf();
                this.oEF = this.oEJ.oGd;
                if (this.oER != null) {
                    eli();
                    elc();
                }
                if (i == 6) {
                    if (this.oEL != null) {
                        this.oEL.quit();
                    }
                    if (this.oEK != null) {
                        this.oEK.release();
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
                if (this.oEL != null) {
                    this.oEL.OG(2);
                }
                if (i == 6) {
                }
                this.oEG = true;
                elf();
                this.oEF = this.oEJ.oGd;
                if (this.oER != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.oEN = true;
                Long l3 = (Long) message.obj;
                if (this.oEL == null) {
                    z = false;
                } else if (l3 == null) {
                    this.oEJ.hl(getCurrentTime());
                    this.oEL.elq();
                    z = false;
                } else {
                    this.oEL.start();
                    this.oEL.seek(l3.longValue());
                    this.oEL.elq();
                    z = true;
                }
                if (this.oEG && this.oEM != null) {
                    this.oEM.elu();
                }
                eli();
                if (!z) {
                    return;
                }
                l = (Long) message.obj;
                if (l == null) {
                }
                if (i == 4) {
                }
                removeMessages(7);
                this.oEG = false;
                if (!this.mReady) {
                }
                break;
            case 9:
                this.oEN = false;
                if (this.oEM != null) {
                    this.oEM.clear();
                }
                if (this.oEL != null) {
                    this.oEL.elq();
                    this.oEL.els();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && this.oEL != null) {
                    this.oEL.quit();
                }
                if (!bool.booleanValue()) {
                    return;
                }
                removeMessages(3);
                removeMessages(2);
                if (this.oEL != null) {
                }
                if (i == 6) {
                }
                this.oEG = true;
                elf();
                this.oEF = this.oEJ.oGd;
                if (this.oER != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                this.oEE.oHO.b(this.oEE);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.oEE.oHM.elR();
                    this.oEE.oHM.elQ();
                    this.oEL.elr();
                    return;
                }
                return;
            case 11:
                eli();
                return;
            case 12:
                if (this.oEG && this.oEM != null) {
                    this.oEL.elq();
                    this.oEM.elu();
                    eli();
                    return;
                }
                return;
            case 13:
                if (this.oEL != null) {
                    this.oEL.hh(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void elc() {
        if (this.oER != null) {
            i iVar = this.oER;
            this.oER = null;
            synchronized (this.oEL) {
                this.oEL.notifyAll();
            }
            iVar.quit();
            try {
                iVar.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void eld() {
        if (!this.oEG) {
            long he = he(master.flame.danmaku.danmaku.c.c.emL());
            if (he < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - he);
                return;
            }
            long elu = this.oEM.elu();
            removeMessages(2);
            if (elu > this.oEU) {
                this.oEJ.hm(elu);
                this.oEQ.clear();
            }
            if (!this.oEN) {
                hf(10000000L);
                return;
            }
            if (this.oEP.oIP && this.oFd) {
                long j = this.oEP.endTime - this.oEJ.oGd;
                if (j > 500) {
                    hf(j - 10);
                    return;
                }
            }
            if (elu < this.oEV) {
                sendEmptyMessageDelayed(2, this.oEV - elu);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void ele() {
        if (this.oER == null) {
            this.oER = new i("DFM Update") { // from class: master.flame.danmaku.a.c.2
                @Override // master.flame.danmaku.a.i, java.lang.Thread, java.lang.Runnable
                public void run() {
                    long emL = master.flame.danmaku.danmaku.c.c.emL();
                    while (!elw() && !c.this.oEG) {
                        long emL2 = master.flame.danmaku.danmaku.c.c.emL();
                        if (c.this.oEV - (master.flame.danmaku.danmaku.c.c.emL() - emL) <= 1) {
                            long he = c.this.he(emL2);
                            if (he >= 0) {
                                long elu = c.this.oEM.elu();
                                if (elu > c.this.oEU) {
                                    c.this.oEJ.hm(elu);
                                    c.this.oEQ.clear();
                                }
                                if (!c.this.oEN) {
                                    c.this.hf(10000000L);
                                } else if (c.this.oEP.oIP && c.this.oFd) {
                                    long j = c.this.oEP.endTime - c.this.oEJ.oGd;
                                    if (j > 500) {
                                        c.this.eli();
                                        c.this.hf(j - 10);
                                    }
                                }
                                emL = emL2;
                            } else {
                                master.flame.danmaku.danmaku.c.c.hn(60 - he);
                                emL = emL2;
                            }
                        } else {
                            master.flame.danmaku.danmaku.c.c.hn(1L);
                        }
                    }
                }
            };
            this.oER.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long he(long j) {
        long j2;
        long j3 = 0;
        if (this.oEY || this.oFb) {
            return 0L;
        }
        this.oFb = true;
        long j4 = j - this.oEH;
        if (!this.oEN || this.oEP.oIP || this.oFc) {
            this.oEJ.hl(j4);
            this.oFa = 0L;
            j2 = 0;
        } else {
            j2 = j4 - this.oEJ.oGd;
            long max = Math.max(this.oEV, elj());
            if (j2 <= 2000 && this.oEP.oIO <= this.oET && max <= this.oET) {
                long min = Math.min(this.oET, Math.max(this.oEV, (j2 / this.oEV) + max));
                long j5 = min - this.oEX;
                if (j5 > 3 && j5 < 8 && this.oEX >= this.oEV && this.oEX <= this.oET) {
                    min = this.oEX;
                }
                long j6 = j2 - min;
                this.oEX = min;
                j2 = min;
                j3 = j6;
            }
            this.oFa = j3;
            this.oEJ.hm(j2);
        }
        if (this.oEI != null) {
            this.oEI.b(this.oEJ);
        }
        this.oFb = false;
        return j2;
    }

    private void elf() {
        if (this.oFc) {
            he(master.flame.danmaku.danmaku.c.c.emL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elg() {
        this.oET = Math.max(33L, ((float) 16) * 2.5f);
        this.oEU = ((float) this.oET) * 2.5f;
        this.oEV = Math.max(16L, (16 / 15) * 15);
        this.oEW = this.oEV + 3;
    }

    private void J(final Runnable runnable) {
        if (this.oEL == null) {
            this.oEL = a(this.oEM.elv(), this.oEJ, this.oEM.getContext(), this.oEM.getWidth(), this.oEM.getHeight(), this.oEM.isHardwareAccelerated(), new h.a() { // from class: master.flame.danmaku.a.c.3
                @Override // master.flame.danmaku.a.h.a
                public void ell() {
                    c.this.elg();
                    runnable.run();
                }

                @Override // master.flame.danmaku.a.h.a
                public void h(master.flame.danmaku.danmaku.model.d dVar) {
                    if (!dVar.elE()) {
                        long elO = dVar.elO() - c.this.getCurrentTime();
                        if (elO < c.this.oEE.oHO.oHT && (c.this.oFc || c.this.oEP.oIP)) {
                            c.this.eli();
                        } else if (elO > 0 && elO <= c.this.oEE.oHO.oHT) {
                            c.this.sendEmptyMessageDelayed(11, elO);
                        }
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void i(master.flame.danmaku.danmaku.model.d dVar) {
                    if (c.this.oEI != null) {
                        c.this.oEI.j(dVar);
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void elm() {
                    if (c.this.oEI != null) {
                        c.this.oEI.elp();
                    }
                }

                @Override // master.flame.danmaku.a.h.a
                public void eln() {
                    c.this.elh();
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
        this.oEO = this.oEE.emm();
        this.oEO.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.oEO.a(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.oEO.aX(this.oEE.oHm);
        this.oEO.zb(z2);
        h aVar2 = z ? new master.flame.danmaku.a.a(fVar, this.oEE, aVar, (1048576 * master.flame.danmaku.danmaku.c.a.getMemoryClass(context)) / 3) : new e(fVar, this.oEE, aVar);
        aVar2.a(this.oEK);
        aVar2.prepare();
        obtainMessage(10, false).sendToTarget();
        return aVar2;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oEL != null) {
            dVar.oFZ = this.oEE.oHM;
            dVar.c(this.oEJ);
            this.oEL.a(dVar);
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
        elf();
        sendEmptyMessage(7);
    }

    public void i(Long l) {
        if (!this.oEN) {
            this.oEN = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    public long yZ(boolean z) {
        if (!this.oEN) {
            return this.oEJ.oGd;
        }
        this.oEN = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.oEJ.oGd;
    }

    public a.b ar(Canvas canvas) {
        master.flame.danmaku.danmaku.model.a aVar;
        boolean elA;
        if (this.oEL == null) {
            return this.oEP;
        }
        if (!this.oFc && (aVar = this.oEE.oHA) != null && ((elA = aVar.elA()) || this.oEG)) {
            int ely = aVar.ely();
            if (ely == 2) {
                long j = this.oEJ.oGd;
                long elx = aVar.elx();
                long j2 = elx - j;
                if (Math.abs(j2) > aVar.elz()) {
                    if (elA && this.oEG) {
                        resume();
                    }
                    this.oEL.k(j, elx, j2);
                    this.oEJ.hl(elx);
                    this.oEH = master.flame.danmaku.danmaku.c.c.emL() - elx;
                    this.oFa = 0L;
                }
            } else if (ely == 1 && elA && !this.oEG) {
                pause();
            }
        }
        this.oEO.setExtraData(canvas);
        this.oEP.b(this.oEL.a(this.oEO));
        elk();
        return this.oEP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elh() {
        if (this.oEG && this.oEN) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli() {
        if (this.oFc) {
            if (this.oEL != null) {
                this.oEL.elq();
            }
            if (this.oES) {
                synchronized (this) {
                    this.oEQ.clear();
                }
                synchronized (this.oEL) {
                    this.oEL.notifyAll();
                }
            } else {
                this.oEQ.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.oFc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(long j) {
        if (!isStop() && isPrepared() && !this.oEY) {
            this.oEP.fYd = master.flame.danmaku.danmaku.c.c.emL();
            this.oFc = true;
            if (this.oES) {
                if (this.oER != null) {
                    try {
                        synchronized (this.oEL) {
                            if (j == 10000000) {
                                this.oEL.wait();
                            } else {
                                this.oEL.wait(j);
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

    private synchronized long elj() {
        long longValue;
        int size = this.oEQ.size();
        if (size <= 0) {
            longValue = 0;
        } else {
            Long peekFirst = this.oEQ.peekFirst();
            Long peekLast = this.oEQ.peekLast();
            longValue = (peekFirst == null || peekLast == null) ? 0L : (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return longValue;
    }

    private synchronized void elk() {
        this.oEQ.addLast(Long.valueOf(master.flame.danmaku.danmaku.c.c.emL()));
        if (this.oEQ.size() > 500) {
            this.oEQ.removeFirst();
        }
    }

    public void eo(int i, int i2) {
        if (this.oEO != null) {
            if (this.oEO.getWidth() != i || this.oEO.getHeight() != i2) {
                this.oEO.setSize(i, i2);
                obtainMessage(10, true).sendToTarget();
            }
        }
    }

    public void yV(boolean z) {
        if (this.oEL != null) {
            this.oEL.yV(z);
        }
    }

    public l getCurrentVisibleDanmakus() {
        if (this.oEL != null) {
            return this.oEL.hg(getCurrentTime());
        }
        return null;
    }

    public long getCurrentTime() {
        if (!this.mReady) {
            return 0L;
        }
        if (this.oEY) {
            return this.oEZ;
        }
        if (this.oEG || !this.oFc) {
            return this.oEJ.oGd - this.oFa;
        }
        return master.flame.danmaku.danmaku.c.c.emL() - this.oEH;
    }

    public DanmakuContext getConfig() {
        return this.oEE;
    }
}
