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
/* loaded from: classes4.dex */
public class DanmakuSurfaceView extends SurfaceView implements SurfaceHolder.Callback, f, g {
    private HandlerThread mHandlerThread;
    private SurfaceHolder mSurfaceHolder;
    private c.a nDD;
    private LinkedList<Long> nDL;
    private f.a nIA;
    private a nIB;
    private boolean nIC;
    private boolean nID;
    protected int nIE;
    private c nIx;
    private boolean nIy;
    private boolean nIz;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.nIz = true;
        this.nID = true;
        this.nIE = 0;
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
        this.nIB = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIz = true;
        this.nID = true;
        this.nIE = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIz = true;
        this.nID = true;
        this.nIE = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nIx != null) {
            this.nIx.a(dVar);
        }
    }

    public void wD(boolean z) {
        if (this.nIx != null) {
            this.nIx.wD(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nIx != null) {
            return this.nIx.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nDD = aVar;
        if (this.nIx != null) {
            this.nIx.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.nIy = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.nIx != null) {
            this.nIx.ex(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.nIy = false;
    }

    public void release() {
        stop();
        if (this.nDL != null) {
            this.nDL.clear();
        }
    }

    public void stop() {
        dLB();
    }

    private synchronized void dLB() {
        if (this.nIx != null) {
            this.nIx.quit();
            this.nIx = null;
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

    protected synchronized Looper NL(int i) {
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
        if (this.nIx == null) {
            this.nIx = new c(NL(this.nIE), this, this.nID);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.nIx.a(danmakuContext);
        this.nIx.a(aVar);
        this.nIx.setCallback(this.nDD);
        this.nIx.prepare();
    }

    public boolean aGB() {
        return this.nIx != null && this.nIx.aGB();
    }

    public DanmakuContext getConfig() {
        if (this.nIx == null) {
            return null;
        }
        return this.nIx.getConfig();
    }

    private float dLC() {
        long dLA = master.flame.danmaku.danmaku.c.c.dLA();
        this.nDL.addLast(Long.valueOf(dLA));
        Long peekFirst = this.nDL.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dLA - peekFirst.longValue());
        if (this.nDL.size() > 50) {
            this.nDL.removeFirst();
        }
        return longValue > 0.0f ? (this.nDL.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dKk() {
        if (!this.nIy) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dLA = master.flame.danmaku.danmaku.c.c.dLA();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.nIx != null) {
                    a.b ak = this.nIx.ak(lockCanvas);
                    if (this.nIC) {
                        if (this.nDL == null) {
                            this.nDL = new LinkedList<>();
                        }
                        long dLA2 = master.flame.danmaku.danmaku.c.c.dLA() - dLA;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dLC()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nHO), Long.valueOf(ak.nHP)));
                    }
                }
                if (this.nIy) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dLA() - dLA;
    }

    public void pause() {
        if (this.nIx != null) {
            this.nIx.pause();
        }
    }

    public void resume() {
        if (this.nIx != null && this.nIx.aGB()) {
            this.nIx.resume();
        } else if (this.nIx == null) {
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
        if (this.nIx == null) {
            prepare();
        } else {
            this.nIx.removeCallbacksAndMessages(null);
        }
        this.nIx.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nIB.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void wP(boolean z) {
        this.nIz = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKl() {
        return this.nIz;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKj() {
        return this.nIy;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nIA = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nIA;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dKj() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nID && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nIE = i;
    }

    public long getCurrentTime() {
        if (this.nIx != null) {
            return this.nIx.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
