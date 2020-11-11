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
/* loaded from: classes6.dex */
public class DanmakuSurfaceView extends SurfaceView implements SurfaceHolder.Callback, f, g {
    private HandlerThread mHandlerThread;
    private SurfaceHolder mSurfaceHolder;
    private c.a pUN;
    private LinkedList<Long> pUV;
    private c pZD;
    private boolean pZE;
    private boolean pZF;
    private f.a pZG;
    private a pZH;
    private boolean pZI;
    private boolean pZJ;
    protected int pZK;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.pZF = true;
        this.pZJ = true;
        this.pZK = 0;
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
        d.aN(true, true);
        this.pZH = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pZF = true;
        this.pZJ = true;
        this.pZK = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pZF = true;
        this.pZJ = true;
        this.pZK = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.pZD != null) {
            this.pZD.a(dVar);
        }
    }

    public void AV(boolean z) {
        if (this.pZD != null) {
            this.pZD.AV(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.pZD != null) {
            return this.pZD.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.pUN = aVar;
        if (this.pZD != null) {
            this.pZD.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.pZE = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.pZD != null) {
            this.pZD.ez(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.pZE = false;
    }

    public void release() {
        stop();
        if (this.pUV != null) {
            this.pUV.clear();
        }
    }

    public void stop() {
        eEm();
    }

    private synchronized void eEm() {
        if (this.pZD != null) {
            this.pZD.quit();
            this.pZD = null;
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

    protected synchronized Looper RC(int i) {
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
        if (this.pZD == null) {
            this.pZD = new c(RC(this.pZK), this, this.pZJ);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.pZD.a(danmakuContext);
        this.pZD.a(aVar);
        this.pZD.setCallback(this.pUN);
        this.pZD.prepare();
    }

    public boolean isPrepared() {
        return this.pZD != null && this.pZD.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.pZD == null) {
            return null;
        }
        return this.pZD.getConfig();
    }

    private float eEn() {
        long eEl = master.flame.danmaku.danmaku.c.c.eEl();
        this.pUV.addLast(Long.valueOf(eEl));
        Long peekFirst = this.pUV.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eEl - peekFirst.longValue());
        if (this.pUV.size() > 50) {
            this.pUV.removeFirst();
        }
        return longValue > 0.0f ? (this.pUV.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long eCU() {
        if (!this.pZE) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eEl = master.flame.danmaku.danmaku.c.c.eEl();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.pZD != null) {
                    a.b au = this.pZD.au(lockCanvas);
                    if (this.pZI) {
                        if (this.pUV == null) {
                            this.pUV = new LinkedList<>();
                        }
                        long eEl2 = master.flame.danmaku.danmaku.c.c.eEl() - eEl;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eEn()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(au.pYU), Long.valueOf(au.pYV)));
                    }
                }
                if (this.pZE) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.eEl() - eEl;
    }

    public void pause() {
        if (this.pZD != null) {
            this.pZD.pause();
        }
    }

    public void resume() {
        if (this.pZD != null && this.pZD.isPrepared()) {
            this.pZD.resume();
        } else if (this.pZD == null) {
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
        if (this.pZD == null) {
            prepare();
        } else {
            this.pZD.removeCallbacksAndMessages(null);
        }
        this.pZD.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.pZH.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void Bh(boolean z) {
        this.pZF = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCV() {
        return this.pZF;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCT() {
        return this.pZE;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.pZG = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.pZG;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (eCT() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.pZJ && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.pZK = i;
    }

    public long getCurrentTime() {
        if (this.pZD != null) {
            return this.pZD.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
