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
    private LinkedList<Long> nEF;
    private c.a nEx;
    private c nJp;
    private boolean nJq;
    private boolean nJr;
    private f.a nJs;
    private a nJt;
    private boolean nJu;
    private boolean nJv;
    protected int nJw;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.nJr = true;
        this.nJv = true;
        this.nJw = 0;
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
        this.nJt = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJr = true;
        this.nJv = true;
        this.nJw = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJr = true;
        this.nJv = true;
        this.nJw = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nJp != null) {
            this.nJp.a(dVar);
        }
    }

    public void wG(boolean z) {
        if (this.nJp != null) {
            this.nJp.wG(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nJp != null) {
            return this.nJp.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nEx = aVar;
        if (this.nJp != null) {
            this.nJp.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.nJq = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.nJp != null) {
            this.nJp.eA(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.nJq = false;
    }

    public void release() {
        stop();
        if (this.nEF != null) {
            this.nEF.clear();
        }
    }

    public void stop() {
        dMQ();
    }

    private synchronized void dMQ() {
        if (this.nJp != null) {
            this.nJp.quit();
            this.nJp = null;
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

    protected synchronized Looper NO(int i) {
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
        if (this.nJp == null) {
            this.nJp = new c(NO(this.nJw), this, this.nJv);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.nJp.a(danmakuContext);
        this.nJp.a(aVar);
        this.nJp.setCallback(this.nEx);
        this.nJp.prepare();
    }

    public boolean isPrepared() {
        return this.nJp != null && this.nJp.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.nJp == null) {
            return null;
        }
        return this.nJp.getConfig();
    }

    private float dMR() {
        long dMP = master.flame.danmaku.danmaku.c.c.dMP();
        this.nEF.addLast(Long.valueOf(dMP));
        Long peekFirst = this.nEF.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dMP - peekFirst.longValue());
        if (this.nEF.size() > 50) {
            this.nEF.removeFirst();
        }
        return longValue > 0.0f ? (this.nEF.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dLz() {
        if (!this.nJq) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dMP = master.flame.danmaku.danmaku.c.c.dMP();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.nJp != null) {
                    a.b ak = this.nJp.ak(lockCanvas);
                    if (this.nJu) {
                        if (this.nEF == null) {
                            this.nEF = new LinkedList<>();
                        }
                        long dMP2 = master.flame.danmaku.danmaku.c.c.dMP() - dMP;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dMR()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nIG), Long.valueOf(ak.nIH)));
                    }
                }
                if (this.nJq) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dMP() - dMP;
    }

    public void pause() {
        if (this.nJp != null) {
            this.nJp.pause();
        }
    }

    public void resume() {
        if (this.nJp != null && this.nJp.isPrepared()) {
            this.nJp.resume();
        } else if (this.nJp == null) {
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
        if (this.nJp == null) {
            prepare();
        } else {
            this.nJp.removeCallbacksAndMessages(null);
        }
        this.nJp.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nJt.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void wS(boolean z) {
        this.nJr = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLA() {
        return this.nJr;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLy() {
        return this.nJq;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nJs = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nJs;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dLy() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nJv && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nJw = i;
    }

    public long getCurrentTime() {
        if (this.nJp != null) {
            return this.nJp.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
