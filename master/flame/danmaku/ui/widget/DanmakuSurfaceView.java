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
    private c.a mZV;
    private LinkedList<Long> nad;
    private c neR;
    private boolean neS;
    private boolean neT;
    private f.a neU;
    private a neV;
    private boolean neW;
    private boolean neX;
    protected int neY;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.neT = true;
        this.neX = true;
        this.neY = 0;
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
        d.av(true, true);
        this.neV = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.neT = true;
        this.neX = true;
        this.neY = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.neT = true;
        this.neX = true;
        this.neY = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.neR != null) {
            this.neR.a(dVar);
        }
    }

    public void wt(boolean z) {
        if (this.neR != null) {
            this.neR.wt(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.neR != null) {
            return this.neR.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.mZV = aVar;
        if (this.neR != null) {
            this.neR.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.neS = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.neR != null) {
            this.neR.dM(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.neS = false;
    }

    public void release() {
        stop();
        if (this.nad != null) {
            this.nad.clear();
        }
    }

    public void stop() {
        dGr();
    }

    private synchronized void dGr() {
        if (this.neR != null) {
            this.neR.quit();
            this.neR = null;
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

    protected synchronized Looper Jo(int i) {
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
        if (this.neR == null) {
            this.neR = new c(Jo(this.neY), this, this.neX);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.neR.a(danmakuContext);
        this.neR.a(aVar);
        this.neR.setCallback(this.mZV);
        this.neR.prepare();
    }

    public boolean isPrepared() {
        return this.neR != null && this.neR.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.neR == null) {
            return null;
        }
        return this.neR.getConfig();
    }

    private float dGs() {
        long dGq = master.flame.danmaku.danmaku.c.c.dGq();
        this.nad.addLast(Long.valueOf(dGq));
        Long peekFirst = this.nad.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dGq - peekFirst.longValue());
        if (this.nad.size() > 50) {
            this.nad.removeFirst();
        }
        return longValue > 0.0f ? (this.nad.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dFa() {
        if (!this.neS) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dGq = master.flame.danmaku.danmaku.c.c.dGq();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.neR != null) {
                    a.b ae = this.neR.ae(lockCanvas);
                    if (this.neW) {
                        if (this.nad == null) {
                            this.nad = new LinkedList<>();
                        }
                        long dGq2 = master.flame.danmaku.danmaku.c.c.dGq() - dGq;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dGs()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ae.neh), Long.valueOf(ae.nei)));
                    }
                }
                if (this.neS) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dGq() - dGq;
    }

    public void pause() {
        if (this.neR != null) {
            this.neR.pause();
        }
    }

    public void resume() {
        if (this.neR != null && this.neR.isPrepared()) {
            this.neR.resume();
        } else if (this.neR == null) {
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
        if (this.neR == null) {
            prepare();
        } else {
            this.neR.removeCallbacksAndMessages(null);
        }
        this.neR.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.neV.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void wF(boolean z) {
        this.neT = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dFb() {
        return this.neT;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dEZ() {
        return this.neS;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.neU = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.neU;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dEZ() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.neX && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.neY = i;
    }

    public long getCurrentTime() {
        if (this.neR != null) {
            return this.neR.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
