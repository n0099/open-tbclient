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
    private c.a nRX;
    private LinkedList<Long> nSf;
    private c nWQ;
    private boolean nWR;
    private boolean nWS;
    private f.a nWT;
    private a nWU;
    private boolean nWV;
    private boolean nWW;
    protected int nWX;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.nWS = true;
        this.nWW = true;
        this.nWX = 0;
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
        this.nWU = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nWS = true;
        this.nWW = true;
        this.nWX = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nWS = true;
        this.nWW = true;
        this.nWX = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nWQ != null) {
            this.nWQ.a(dVar);
        }
    }

    public void xo(boolean z) {
        if (this.nWQ != null) {
            this.nWQ.xo(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nWQ != null) {
            return this.nWQ.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nRX = aVar;
        if (this.nWQ != null) {
            this.nWQ.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.nWR = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.nWQ != null) {
            this.nWQ.ea(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.nWR = false;
    }

    public void release() {
        stop();
        if (this.nSf != null) {
            this.nSf.clear();
        }
    }

    public void stop() {
        dTc();
    }

    private synchronized void dTc() {
        if (this.nWQ != null) {
            this.nWQ.quit();
            this.nWQ = null;
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
        if (this.nWQ == null) {
            this.nWQ = new c(Li(this.nWX), this, this.nWW);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.nWQ.a(danmakuContext);
        this.nWQ.a(aVar);
        this.nWQ.setCallback(this.nRX);
        this.nWQ.prepare();
    }

    public boolean isPrepared() {
        return this.nWQ != null && this.nWQ.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.nWQ == null) {
            return null;
        }
        return this.nWQ.getConfig();
    }

    private float dTd() {
        long dTb = master.flame.danmaku.danmaku.c.c.dTb();
        this.nSf.addLast(Long.valueOf(dTb));
        Long peekFirst = this.nSf.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dTb - peekFirst.longValue());
        if (this.nSf.size() > 50) {
            this.nSf.removeFirst();
        }
        return longValue > 0.0f ? (this.nSf.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dRL() {
        if (!this.nWR) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dTb = master.flame.danmaku.danmaku.c.c.dTb();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.nWQ != null) {
                    a.b al = this.nWQ.al(lockCanvas);
                    if (this.nWV) {
                        if (this.nSf == null) {
                            this.nSf = new LinkedList<>();
                        }
                        long dTb2 = master.flame.danmaku.danmaku.c.c.dTb() - dTb;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dTd()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.nWh), Long.valueOf(al.nWi)));
                    }
                }
                if (this.nWR) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dTb() - dTb;
    }

    public void pause() {
        if (this.nWQ != null) {
            this.nWQ.pause();
        }
    }

    public void resume() {
        if (this.nWQ != null && this.nWQ.isPrepared()) {
            this.nWQ.resume();
        } else if (this.nWQ == null) {
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
        if (this.nWQ == null) {
            prepare();
        } else {
            this.nWQ.removeCallbacksAndMessages(null);
        }
        this.nWQ.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nWU.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void xA(boolean z) {
        this.nWS = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRM() {
        return this.nWS;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRK() {
        return this.nWR;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nWT = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nWT;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dRK() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nWW && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nWX = i;
    }

    public long getCurrentTime() {
        if (this.nWQ != null) {
            return this.nWQ.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
