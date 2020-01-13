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
    private LinkedList<Long> nDG;
    private c.a nDy;
    private c nIs;
    private boolean nIt;
    private boolean nIu;
    private f.a nIv;
    private a nIw;
    private boolean nIx;
    private boolean nIy;
    protected int nIz;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.nIu = true;
        this.nIy = true;
        this.nIz = 0;
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
        this.nIw = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIu = true;
        this.nIy = true;
        this.nIz = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIu = true;
        this.nIy = true;
        this.nIz = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nIs != null) {
            this.nIs.a(dVar);
        }
    }

    public void wD(boolean z) {
        if (this.nIs != null) {
            this.nIs.wD(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nIs != null) {
            return this.nIs.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nDy = aVar;
        if (this.nIs != null) {
            this.nIs.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.nIt = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.nIs != null) {
            this.nIs.ex(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.nIt = false;
    }

    public void release() {
        stop();
        if (this.nDG != null) {
            this.nDG.clear();
        }
    }

    public void stop() {
        dLz();
    }

    private synchronized void dLz() {
        if (this.nIs != null) {
            this.nIs.quit();
            this.nIs = null;
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
        if (this.nIs == null) {
            this.nIs = new c(NL(this.nIz), this, this.nIy);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.nIs.a(danmakuContext);
        this.nIs.a(aVar);
        this.nIs.setCallback(this.nDy);
        this.nIs.prepare();
    }

    public boolean aGB() {
        return this.nIs != null && this.nIs.aGB();
    }

    public DanmakuContext getConfig() {
        if (this.nIs == null) {
            return null;
        }
        return this.nIs.getConfig();
    }

    private float dLA() {
        long dLy = master.flame.danmaku.danmaku.c.c.dLy();
        this.nDG.addLast(Long.valueOf(dLy));
        Long peekFirst = this.nDG.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dLy - peekFirst.longValue());
        if (this.nDG.size() > 50) {
            this.nDG.removeFirst();
        }
        return longValue > 0.0f ? (this.nDG.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dKi() {
        if (!this.nIt) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dLy = master.flame.danmaku.danmaku.c.c.dLy();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.nIs != null) {
                    a.b ak = this.nIs.ak(lockCanvas);
                    if (this.nIx) {
                        if (this.nDG == null) {
                            this.nDG = new LinkedList<>();
                        }
                        long dLy2 = master.flame.danmaku.danmaku.c.c.dLy() - dLy;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dLA()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nHJ), Long.valueOf(ak.nHK)));
                    }
                }
                if (this.nIt) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dLy() - dLy;
    }

    public void pause() {
        if (this.nIs != null) {
            this.nIs.pause();
        }
    }

    public void resume() {
        if (this.nIs != null && this.nIs.aGB()) {
            this.nIs.resume();
        } else if (this.nIs == null) {
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
        if (this.nIs == null) {
            prepare();
        } else {
            this.nIs.removeCallbacksAndMessages(null);
        }
        this.nIs.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nIw.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void wP(boolean z) {
        this.nIu = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKj() {
        return this.nIu;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKh() {
        return this.nIt;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nIv = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nIv;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dKh() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nIy && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nIz = i;
    }

    public long getCurrentTime() {
        if (this.nIs != null) {
            return this.nIs.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
