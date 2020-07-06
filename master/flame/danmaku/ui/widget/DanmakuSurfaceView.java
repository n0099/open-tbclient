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
    private c.a nSa;
    private LinkedList<Long> nSi;
    private c nWT;
    private boolean nWU;
    private boolean nWV;
    private f.a nWW;
    private a nWX;
    private boolean nWY;
    private boolean nWZ;
    protected int nXa;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.nWV = true;
        this.nWZ = true;
        this.nXa = 0;
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
        d.az(true, true);
        this.nWX = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nWV = true;
        this.nWZ = true;
        this.nXa = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nWV = true;
        this.nWZ = true;
        this.nXa = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nWT != null) {
            this.nWT.a(dVar);
        }
    }

    public void xo(boolean z) {
        if (this.nWT != null) {
            this.nWT.xo(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nWT != null) {
            return this.nWT.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nSa = aVar;
        if (this.nWT != null) {
            this.nWT.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.nWU = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.nWT != null) {
            this.nWT.ea(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.nWU = false;
    }

    public void release() {
        stop();
        if (this.nSi != null) {
            this.nSi.clear();
        }
    }

    public void stop() {
        dTg();
    }

    private synchronized void dTg() {
        if (this.nWT != null) {
            this.nWT.quit();
            this.nWT = null;
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

    protected synchronized Looper Li(int i) {
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
        if (this.nWT == null) {
            this.nWT = new c(Li(this.nXa), this, this.nWZ);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.nWT.a(danmakuContext);
        this.nWT.a(aVar);
        this.nWT.setCallback(this.nSa);
        this.nWT.prepare();
    }

    public boolean isPrepared() {
        return this.nWT != null && this.nWT.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.nWT == null) {
            return null;
        }
        return this.nWT.getConfig();
    }

    private float dTh() {
        long dTf = master.flame.danmaku.danmaku.c.c.dTf();
        this.nSi.addLast(Long.valueOf(dTf));
        Long peekFirst = this.nSi.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dTf - peekFirst.longValue());
        if (this.nSi.size() > 50) {
            this.nSi.removeFirst();
        }
        return longValue > 0.0f ? (this.nSi.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dRP() {
        if (!this.nWU) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dTf = master.flame.danmaku.danmaku.c.c.dTf();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.nWT != null) {
                    a.b al = this.nWT.al(lockCanvas);
                    if (this.nWY) {
                        if (this.nSi == null) {
                            this.nSi = new LinkedList<>();
                        }
                        long dTf2 = master.flame.danmaku.danmaku.c.c.dTf() - dTf;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dTh()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.nWk), Long.valueOf(al.nWl)));
                    }
                }
                if (this.nWU) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dTf() - dTf;
    }

    public void pause() {
        if (this.nWT != null) {
            this.nWT.pause();
        }
    }

    public void resume() {
        if (this.nWT != null && this.nWT.isPrepared()) {
            this.nWT.resume();
        } else if (this.nWT == null) {
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
        if (this.nWT == null) {
            prepare();
        } else {
            this.nWT.removeCallbacksAndMessages(null);
        }
        this.nWT.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nWX.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void xA(boolean z) {
        this.nWV = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRQ() {
        return this.nWV;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRO() {
        return this.nWU;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nWW = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nWW;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dRO() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nWZ && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nXa = i;
    }

    public long getCurrentTime() {
        if (this.nWT != null) {
            return this.nWT.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
