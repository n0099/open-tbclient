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
    private c.a oaJ;
    private LinkedList<Long> oaR;
    private c ofE;
    private boolean ofF;
    private boolean ofG;
    private f.a ofH;
    private a ofI;
    private boolean ofJ;
    private boolean ofK;
    protected int ofL;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.ofG = true;
        this.ofK = true;
        this.ofL = 0;
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
        this.ofI = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ofG = true;
        this.ofK = true;
        this.ofL = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ofG = true;
        this.ofK = true;
        this.ofL = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.ofE != null) {
            this.ofE.a(dVar);
        }
    }

    public void xT(boolean z) {
        if (this.ofE != null) {
            this.ofE.xT(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ofE != null) {
            return this.ofE.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oaJ = aVar;
        if (this.ofE != null) {
            this.ofE.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.ofF = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.ofE != null) {
            this.ofE.ec(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.ofF = false;
    }

    public void release() {
        stop();
        if (this.oaR != null) {
            this.oaR.clear();
        }
    }

    public void stop() {
        dWC();
    }

    private synchronized void dWC() {
        if (this.ofE != null) {
            this.ofE.quit();
            this.ofE = null;
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

    protected synchronized Looper LC(int i) {
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
        if (this.ofE == null) {
            this.ofE = new c(LC(this.ofL), this, this.ofK);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.ofE.a(danmakuContext);
        this.ofE.a(aVar);
        this.ofE.setCallback(this.oaJ);
        this.ofE.prepare();
    }

    public boolean isPrepared() {
        return this.ofE != null && this.ofE.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.ofE == null) {
            return null;
        }
        return this.ofE.getConfig();
    }

    private float dWD() {
        long dWB = master.flame.danmaku.danmaku.c.c.dWB();
        this.oaR.addLast(Long.valueOf(dWB));
        Long peekFirst = this.oaR.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dWB - peekFirst.longValue());
        if (this.oaR.size() > 50) {
            this.oaR.removeFirst();
        }
        return longValue > 0.0f ? (this.oaR.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dVl() {
        if (!this.ofF) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dWB = master.flame.danmaku.danmaku.c.c.dWB();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.ofE != null) {
                    a.b al = this.ofE.al(lockCanvas);
                    if (this.ofJ) {
                        if (this.oaR == null) {
                            this.oaR = new LinkedList<>();
                        }
                        long dWB2 = master.flame.danmaku.danmaku.c.c.dWB() - dWB;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dWD()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.oeU), Long.valueOf(al.oeV)));
                    }
                }
                if (this.ofF) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dWB() - dWB;
    }

    public void pause() {
        if (this.ofE != null) {
            this.ofE.pause();
        }
    }

    public void resume() {
        if (this.ofE != null && this.ofE.isPrepared()) {
            this.ofE.resume();
        } else if (this.ofE == null) {
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
        if (this.ofE == null) {
            prepare();
        } else {
            this.ofE.removeCallbacksAndMessages(null);
        }
        this.ofE.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ofI.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void yf(boolean z) {
        this.ofG = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVm() {
        return this.ofG;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVk() {
        return this.ofF;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.ofH = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ofH;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dVk() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.ofK && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.ofL = i;
    }

    public long getCurrentTime() {
        if (this.ofE != null) {
            return this.ofE.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
