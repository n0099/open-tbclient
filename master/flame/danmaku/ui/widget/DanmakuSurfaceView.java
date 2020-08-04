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
    private c.a oaL;
    private LinkedList<Long> oaT;
    private c ofG;
    private boolean ofH;
    private boolean ofI;
    private f.a ofJ;
    private a ofK;
    private boolean ofL;
    private boolean ofM;
    protected int ofN;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.ofI = true;
        this.ofM = true;
        this.ofN = 0;
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
        this.ofK = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ofI = true;
        this.ofM = true;
        this.ofN = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ofI = true;
        this.ofM = true;
        this.ofN = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.ofG != null) {
            this.ofG.a(dVar);
        }
    }

    public void xT(boolean z) {
        if (this.ofG != null) {
            this.ofG.xT(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ofG != null) {
            return this.ofG.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oaL = aVar;
        if (this.ofG != null) {
            this.ofG.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.ofH = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.ofG != null) {
            this.ofG.ec(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.ofH = false;
    }

    public void release() {
        stop();
        if (this.oaT != null) {
            this.oaT.clear();
        }
    }

    public void stop() {
        dWD();
    }

    private synchronized void dWD() {
        if (this.ofG != null) {
            this.ofG.quit();
            this.ofG = null;
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
        if (this.ofG == null) {
            this.ofG = new c(LC(this.ofN), this, this.ofM);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.ofG.a(danmakuContext);
        this.ofG.a(aVar);
        this.ofG.setCallback(this.oaL);
        this.ofG.prepare();
    }

    public boolean isPrepared() {
        return this.ofG != null && this.ofG.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.ofG == null) {
            return null;
        }
        return this.ofG.getConfig();
    }

    private float dWE() {
        long dWC = master.flame.danmaku.danmaku.c.c.dWC();
        this.oaT.addLast(Long.valueOf(dWC));
        Long peekFirst = this.oaT.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dWC - peekFirst.longValue());
        if (this.oaT.size() > 50) {
            this.oaT.removeFirst();
        }
        return longValue > 0.0f ? (this.oaT.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dVm() {
        if (!this.ofH) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dWC = master.flame.danmaku.danmaku.c.c.dWC();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.ofG != null) {
                    a.b al = this.ofG.al(lockCanvas);
                    if (this.ofL) {
                        if (this.oaT == null) {
                            this.oaT = new LinkedList<>();
                        }
                        long dWC2 = master.flame.danmaku.danmaku.c.c.dWC() - dWC;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dWE()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.oeW), Long.valueOf(al.oeX)));
                    }
                }
                if (this.ofH) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dWC() - dWC;
    }

    public void pause() {
        if (this.ofG != null) {
            this.ofG.pause();
        }
    }

    public void resume() {
        if (this.ofG != null && this.ofG.isPrepared()) {
            this.ofG.resume();
        } else if (this.ofG == null) {
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
        if (this.ofG == null) {
            prepare();
        } else {
            this.ofG.removeCallbacksAndMessages(null);
        }
        this.ofG.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ofK.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void yf(boolean z) {
        this.ofI = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVn() {
        return this.ofI;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVl() {
        return this.ofH;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.ofJ = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ofJ;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dVl() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.ofM && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.ofN = i;
    }

    public long getCurrentTime() {
        if (this.ofG != null) {
            return this.ofG.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
