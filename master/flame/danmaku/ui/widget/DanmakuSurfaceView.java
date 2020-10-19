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
    private c.a oTX;
    private LinkedList<Long> oUf;
    private c oYN;
    private boolean oYO;
    private boolean oYP;
    private f.a oYQ;
    private a oYR;
    private boolean oYS;
    private boolean oYT;
    protected int oYU;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.oYP = true;
        this.oYT = true;
        this.oYU = 0;
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
        d.aH(true, true);
        this.oYR = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oYP = true;
        this.oYT = true;
        this.oYU = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oYP = true;
        this.oYT = true;
        this.oYU = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.oYN != null) {
            this.oYN.a(dVar);
        }
    }

    public void zC(boolean z) {
        if (this.oYN != null) {
            this.oYN.zC(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.oYN != null) {
            return this.oYN.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oTX = aVar;
        if (this.oYN != null) {
            this.oYN.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.oYO = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.oYN != null) {
            this.oYN.eo(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.oYO = false;
    }

    public void release() {
        stop();
        if (this.oUf != null) {
            this.oUf.clear();
        }
    }

    public void stop() {
        eqz();
    }

    private synchronized void eqz() {
        if (this.oYN != null) {
            this.oYN.quit();
            this.oYN = null;
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

    protected synchronized Looper Pq(int i) {
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
        if (this.oYN == null) {
            this.oYN = new c(Pq(this.oYU), this, this.oYT);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.oYN.a(danmakuContext);
        this.oYN.a(aVar);
        this.oYN.setCallback(this.oTX);
        this.oYN.prepare();
    }

    public boolean isPrepared() {
        return this.oYN != null && this.oYN.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.oYN == null) {
            return null;
        }
        return this.oYN.getConfig();
    }

    private float eqA() {
        long eqy = master.flame.danmaku.danmaku.c.c.eqy();
        this.oUf.addLast(Long.valueOf(eqy));
        Long peekFirst = this.oUf.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eqy - peekFirst.longValue());
        if (this.oUf.size() > 50) {
            this.oUf.removeFirst();
        }
        return longValue > 0.0f ? (this.oUf.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long eph() {
        if (!this.oYO) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eqy = master.flame.danmaku.danmaku.c.c.eqy();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.oYN != null) {
                    a.b as = this.oYN.as(lockCanvas);
                    if (this.oYS) {
                        if (this.oUf == null) {
                            this.oUf = new LinkedList<>();
                        }
                        long eqy2 = master.flame.danmaku.danmaku.c.c.eqy() - eqy;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eqA()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(as.oYe), Long.valueOf(as.oYf)));
                    }
                }
                if (this.oYO) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.eqy() - eqy;
    }

    public void pause() {
        if (this.oYN != null) {
            this.oYN.pause();
        }
    }

    public void resume() {
        if (this.oYN != null && this.oYN.isPrepared()) {
            this.oYN.resume();
        } else if (this.oYN == null) {
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
        if (this.oYN == null) {
            prepare();
        } else {
            this.oYN.removeCallbacksAndMessages(null);
        }
        this.oYN.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.oYR.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void zO(boolean z) {
        this.oYP = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean epi() {
        return this.oYP;
    }

    @Override // master.flame.danmaku.a.g
    public boolean epg() {
        return this.oYO;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.oYQ = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.oYQ;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (epg() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.oYT && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.oYU = i;
    }

    public long getCurrentTime() {
        if (this.oYN != null) {
            return this.oYN.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
