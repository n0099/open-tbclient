package master.flame.danmaku.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.util.LinkedList;
import java.util.Locale;
import master.flame.danmaku.a.c;
import master.flame.danmaku.a.d;
import master.flame.danmaku.a.f;
import master.flame.danmaku.a.g;
import master.flame.danmaku.danmaku.b.a;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.l;
/* loaded from: classes5.dex */
public class DanmakuSurfaceView extends SurfaceView implements SurfaceHolder.Callback, f, g {
    private HandlerThread mHandlerThread;
    private SurfaceHolder mSurfaceHolder;
    private LinkedList<Long> nGD;
    private c.a nGv;
    private c nLn;
    private boolean nLo;
    private boolean nLp;
    private f.a nLq;
    private a nLr;
    private boolean nLs;
    private boolean nLt;
    protected int nLu;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.nLp = true;
        this.nLt = true;
        this.nLu = 0;
        init();
    }

    private void init() {
        setZOrderMediaOverlay(true);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.addCallback(this);
        this.mSurfaceHolder.setFormat(-2);
        d.aA(true, true);
        this.nLr = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nLp = true;
        this.nLt = true;
        this.nLu = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nLp = true;
        this.nLt = true;
        this.nLu = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nLn != null) {
            this.nLn.a(dVar);
        }
    }

    public void wO(boolean z) {
        if (this.nLn != null) {
            this.nLn.wO(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nLn != null) {
            return this.nLn.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nGv = aVar;
        if (this.nLn != null) {
            this.nLn.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.nLo = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.nLn != null) {
            this.nLn.eB(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.nLo = false;
    }

    public void release() {
        stop();
        if (this.nGD != null) {
            this.nGD.clear();
        }
    }

    public void stop() {
        dNr();
    }

    private synchronized void dNr() {
        if (this.nLn != null) {
            this.nLn.quit();
            this.nLn = null;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        this.mHandlerThread = null;
        if (handlerThread != null) {
            try {
                handlerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handlerThread.quit();
        }
    }

    protected synchronized Looper NU(int i) {
        int i2;
        Looper mainLooper;
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
        }
        switch (i) {
            case 1:
                mainLooper = Looper.getMainLooper();
                break;
            case 2:
                i2 = -8;
                this.mHandlerThread = new HandlerThread("DFM Handler Thread #" + i2, i2);
                this.mHandlerThread.start();
                mainLooper = this.mHandlerThread.getLooper();
                break;
            case 3:
                i2 = 19;
                this.mHandlerThread = new HandlerThread("DFM Handler Thread #" + i2, i2);
                this.mHandlerThread.start();
                mainLooper = this.mHandlerThread.getLooper();
                break;
            default:
                i2 = 0;
                this.mHandlerThread = new HandlerThread("DFM Handler Thread #" + i2, i2);
                this.mHandlerThread.start();
                mainLooper = this.mHandlerThread.getLooper();
                break;
        }
        return mainLooper;
    }

    private void prepare() {
        if (this.nLn == null) {
            this.nLn = new c(NU(this.nLu), this, this.nLt);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.nLn.a(danmakuContext);
        this.nLn.a(aVar);
        this.nLn.setCallback(this.nGv);
        this.nLn.prepare();
    }

    public boolean isPrepared() {
        return this.nLn != null && this.nLn.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.nLn == null) {
            return null;
        }
        return this.nLn.getConfig();
    }

    private float dNs() {
        long dNq = master.flame.danmaku.danmaku.c.c.dNq();
        this.nGD.addLast(Long.valueOf(dNq));
        Long peekFirst = this.nGD.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dNq - peekFirst.longValue());
        if (this.nGD.size() > 50) {
            this.nGD.removeFirst();
        }
        return longValue > 0.0f ? (this.nGD.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dMa() {
        if (!this.nLo) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dNq = master.flame.danmaku.danmaku.c.c.dNq();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.nLn != null) {
                    a.b al = this.nLn.al(lockCanvas);
                    if (this.nLs) {
                        if (this.nGD == null) {
                            this.nGD = new LinkedList<>();
                        }
                        long dNq2 = master.flame.danmaku.danmaku.c.c.dNq() - dNq;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dNs()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.nKE), Long.valueOf(al.nKF)));
                    }
                }
                if (this.nLo) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dNq() - dNq;
    }

    public void pause() {
        if (this.nLn != null) {
            this.nLn.pause();
        }
    }

    public void resume() {
        if (this.nLn != null && this.nLn.isPrepared()) {
            this.nLn.resume();
        } else if (this.nLn == null) {
            restart();
        }
    }

    public void restart() {
        stop();
        start();
    }

    public void start() {
        start(0L);
    }

    public void start(long j) {
        if (this.nLn == null) {
            prepare();
        } else {
            this.nLn.removeCallbacksAndMessages(null);
        }
        this.nLn.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nLr.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void xa(boolean z) {
        this.nLp = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dMb() {
        return this.nLp;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLZ() {
        return this.nLo;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nLq = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nLq;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dLZ() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nLt && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nLu = i;
    }

    public long getCurrentTime() {
        if (this.nLn != null) {
            return this.nLn.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
