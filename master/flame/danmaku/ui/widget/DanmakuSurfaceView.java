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
    private boolean nAa;
    private boolean nAb;
    protected int nAc;
    private c.a nvb;
    private LinkedList<Long> nvj;
    private c nzV;
    private boolean nzW;
    private boolean nzX;
    private f.a nzY;
    private a nzZ;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.nzX = true;
        this.nAb = true;
        this.nAc = 0;
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
        this.nzZ = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nzX = true;
        this.nAb = true;
        this.nAc = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nzX = true;
        this.nAb = true;
        this.nAc = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nzV != null) {
            this.nzV.a(dVar);
        }
    }

    public void wR(boolean z) {
        if (this.nzV != null) {
            this.nzV.wR(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nzV != null) {
            return this.nzV.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nvb = aVar;
        if (this.nzV != null) {
            this.nzV.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.nzW = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.nzV != null) {
            this.nzV.dR(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.nzW = false;
    }

    public void release() {
        stop();
        if (this.nvj != null) {
            this.nvj.clear();
        }
    }

    public void stop() {
        dOi();
    }

    private synchronized void dOi() {
        if (this.nzV != null) {
            this.nzV.quit();
            this.nzV = null;
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

    protected synchronized Looper JZ(int i) {
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
        if (this.nzV == null) {
            this.nzV = new c(JZ(this.nAc), this, this.nAb);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.nzV.a(danmakuContext);
        this.nzV.a(aVar);
        this.nzV.setCallback(this.nvb);
        this.nzV.prepare();
    }

    public boolean isPrepared() {
        return this.nzV != null && this.nzV.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.nzV == null) {
            return null;
        }
        return this.nzV.getConfig();
    }

    private float dOj() {
        long dOh = master.flame.danmaku.danmaku.c.c.dOh();
        this.nvj.addLast(Long.valueOf(dOh));
        Long peekFirst = this.nvj.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dOh - peekFirst.longValue());
        if (this.nvj.size() > 50) {
            this.nvj.removeFirst();
        }
        return longValue > 0.0f ? (this.nvj.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dMR() {
        if (!this.nzW) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dOh = master.flame.danmaku.danmaku.c.c.dOh();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.nzV != null) {
                    a.b ag = this.nzV.ag(lockCanvas);
                    if (this.nAa) {
                        if (this.nvj == null) {
                            this.nvj = new LinkedList<>();
                        }
                        long dOh2 = master.flame.danmaku.danmaku.c.c.dOh() - dOh;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dOj()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ag.nzm), Long.valueOf(ag.nzn)));
                    }
                }
                if (this.nzW) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dOh() - dOh;
    }

    public void pause() {
        if (this.nzV != null) {
            this.nzV.pause();
        }
    }

    public void resume() {
        if (this.nzV != null && this.nzV.isPrepared()) {
            this.nzV.resume();
        } else if (this.nzV == null) {
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
        if (this.nzV == null) {
            prepare();
        } else {
            this.nzV.removeCallbacksAndMessages(null);
        }
        this.nzV.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nzZ.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void xd(boolean z) {
        this.nzX = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dMS() {
        return this.nzX;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dMQ() {
        return this.nzW;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nzY = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nzY;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dMQ() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nAb && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nAc = i;
    }

    public long getCurrentTime() {
        if (this.nzV != null) {
            return this.nzV.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
