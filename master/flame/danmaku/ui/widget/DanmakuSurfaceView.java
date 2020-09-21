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
    private c.a oEI;
    private LinkedList<Long> oEQ;
    private boolean oJA;
    private boolean oJB;
    private f.a oJC;
    private a oJD;
    private boolean oJE;
    private boolean oJF;
    protected int oJG;
    private c oJz;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.oJB = true;
        this.oJF = true;
        this.oJG = 0;
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
        d.aI(true, true);
        this.oJD = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oJB = true;
        this.oJF = true;
        this.oJG = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oJB = true;
        this.oJF = true;
        this.oJG = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oJz != null) {
            this.oJz.a(dVar);
        }
    }

    public void yV(boolean z) {
        if (this.oJz != null) {
            this.oJz.yV(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.oJz != null) {
            return this.oJz.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oEI = aVar;
        if (this.oJz != null) {
            this.oJz.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.oJA = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.oJz != null) {
            this.oJz.eo(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.oJA = false;
    }

    public void release() {
        stop();
        if (this.oEQ != null) {
            this.oEQ.clear();
        }
    }

    public void stop() {
        emM();
    }

    private synchronized void emM() {
        if (this.oJz != null) {
            this.oJz.quit();
            this.oJz = null;
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

    protected synchronized Looper OK(int i) {
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
        if (this.oJz == null) {
            this.oJz = new c(OK(this.oJG), this, this.oJF);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.oJz.a(danmakuContext);
        this.oJz.a(aVar);
        this.oJz.setCallback(this.oEI);
        this.oJz.prepare();
    }

    public boolean isPrepared() {
        return this.oJz != null && this.oJz.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.oJz == null) {
            return null;
        }
        return this.oJz.getConfig();
    }

    private float emN() {
        long emL = master.flame.danmaku.danmaku.c.c.emL();
        this.oEQ.addLast(Long.valueOf(emL));
        Long peekFirst = this.oEQ.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (emL - peekFirst.longValue());
        if (this.oEQ.size() > 50) {
            this.oEQ.removeFirst();
        }
        return longValue > 0.0f ? (this.oEQ.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long elu() {
        if (!this.oJA) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long emL = master.flame.danmaku.danmaku.c.c.emL();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.oJz != null) {
                    a.b ar = this.oJz.ar(lockCanvas);
                    if (this.oJE) {
                        if (this.oEQ == null) {
                            this.oEQ = new LinkedList<>();
                        }
                        long emL2 = master.flame.danmaku.danmaku.c.c.emL() - emL;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(emN()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ar.oIQ), Long.valueOf(ar.oIR)));
                    }
                }
                if (this.oJA) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.emL() - emL;
    }

    public void pause() {
        if (this.oJz != null) {
            this.oJz.pause();
        }
    }

    public void resume() {
        if (this.oJz != null && this.oJz.isPrepared()) {
            this.oJz.resume();
        } else if (this.oJz == null) {
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
        if (this.oJz == null) {
            prepare();
        } else {
            this.oJz.removeCallbacksAndMessages(null);
        }
        this.oJz.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.oJD.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void zh(boolean z) {
        this.oJB = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean elv() {
        return this.oJB;
    }

    @Override // master.flame.danmaku.a.g
    public boolean elt() {
        return this.oJA;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.oJC = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.oJC;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (elt() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.oJF && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.oJG = i;
    }

    public long getCurrentTime() {
        if (this.oJz != null) {
            return this.oJz.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
