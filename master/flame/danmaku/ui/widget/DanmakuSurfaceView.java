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
    private c nBf;
    private boolean nBg;
    private boolean nBh;
    private f.a nBi;
    private a nBj;
    private boolean nBk;
    private boolean nBl;
    protected int nBm;
    private c.a nwl;
    private LinkedList<Long> nwt;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.nBh = true;
        this.nBl = true;
        this.nBm = 0;
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
        d.ay(true, true);
        this.nBj = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nBh = true;
        this.nBl = true;
        this.nBm = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nBh = true;
        this.nBl = true;
        this.nBm = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nBf != null) {
            this.nBf.a(dVar);
        }
    }

    public void wT(boolean z) {
        if (this.nBf != null) {
            this.nBf.wT(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nBf != null) {
            return this.nBf.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nwl = aVar;
        if (this.nBf != null) {
            this.nBf.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.nBg = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.nBf != null) {
            this.nBf.dR(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.nBg = false;
    }

    public void release() {
        stop();
        if (this.nwt != null) {
            this.nwt.clear();
        }
    }

    public void stop() {
        dOw();
    }

    private synchronized void dOw() {
        if (this.nBf != null) {
            this.nBf.quit();
            this.nBf = null;
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

    protected synchronized Looper Kb(int i) {
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
        if (this.nBf == null) {
            this.nBf = new c(Kb(this.nBm), this, this.nBl);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.nBf.a(danmakuContext);
        this.nBf.a(aVar);
        this.nBf.setCallback(this.nwl);
        this.nBf.prepare();
    }

    public boolean isPrepared() {
        return this.nBf != null && this.nBf.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.nBf == null) {
            return null;
        }
        return this.nBf.getConfig();
    }

    private float dOx() {
        long dOv = master.flame.danmaku.danmaku.c.c.dOv();
        this.nwt.addLast(Long.valueOf(dOv));
        Long peekFirst = this.nwt.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dOv - peekFirst.longValue());
        if (this.nwt.size() > 50) {
            this.nwt.removeFirst();
        }
        return longValue > 0.0f ? (this.nwt.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dNf() {
        if (!this.nBg) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dOv = master.flame.danmaku.danmaku.c.c.dOv();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.nBf != null) {
                    a.b ag = this.nBf.ag(lockCanvas);
                    if (this.nBk) {
                        if (this.nwt == null) {
                            this.nwt = new LinkedList<>();
                        }
                        long dOv2 = master.flame.danmaku.danmaku.c.c.dOv() - dOv;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dOx()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ag.nAw), Long.valueOf(ag.nAx)));
                    }
                }
                if (this.nBg) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dOv() - dOv;
    }

    public void pause() {
        if (this.nBf != null) {
            this.nBf.pause();
        }
    }

    public void resume() {
        if (this.nBf != null && this.nBf.isPrepared()) {
            this.nBf.resume();
        } else if (this.nBf == null) {
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
        if (this.nBf == null) {
            prepare();
        } else {
            this.nBf.removeCallbacksAndMessages(null);
        }
        this.nBf.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nBj.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void xf(boolean z) {
        this.nBh = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dNg() {
        return this.nBh;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dNe() {
        return this.nBg;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nBi = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nBi;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dNe() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nBl && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nBm = i;
    }

    public long getCurrentTime() {
        if (this.nBf != null) {
            return this.nBf.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
