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
    private c.a pWq;
    private LinkedList<Long> pWy;
    private c qbg;
    private boolean qbh;
    private boolean qbi;
    private f.a qbj;
    private a qbk;
    private boolean qbl;
    private boolean qbm;
    protected int qbn;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.qbi = true;
        this.qbm = true;
        this.qbn = 0;
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
        d.aL(true, true);
        this.qbk = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qbi = true;
        this.qbm = true;
        this.qbn = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qbi = true;
        this.qbm = true;
        this.qbn = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.qbg != null) {
            this.qbg.a(dVar);
        }
    }

    public void Bc(boolean z) {
        if (this.qbg != null) {
            this.qbg.Bc(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.qbg != null) {
            return this.qbg.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.pWq = aVar;
        if (this.qbg != null) {
            this.qbg.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.qbh = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.qbg != null) {
            this.qbg.eA(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.qbh = false;
    }

    public void release() {
        stop();
        if (this.pWy != null) {
            this.pWy.clear();
        }
    }

    public void stop() {
        eEn();
    }

    private synchronized void eEn() {
        if (this.qbg != null) {
            this.qbg.quit();
            this.qbg = null;
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

    protected synchronized Looper Sf(int i) {
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
        if (this.qbg == null) {
            this.qbg = new c(Sf(this.qbn), this, this.qbm);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.qbg.a(danmakuContext);
        this.qbg.a(aVar);
        this.qbg.setCallback(this.pWq);
        this.qbg.prepare();
    }

    public boolean isPrepared() {
        return this.qbg != null && this.qbg.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.qbg == null) {
            return null;
        }
        return this.qbg.getConfig();
    }

    private float eEo() {
        long eEm = master.flame.danmaku.danmaku.c.c.eEm();
        this.pWy.addLast(Long.valueOf(eEm));
        Long peekFirst = this.pWy.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eEm - peekFirst.longValue());
        if (this.pWy.size() > 50) {
            this.pWy.removeFirst();
        }
        return longValue > 0.0f ? (this.pWy.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long eCV() {
        if (!this.qbh) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eEm = master.flame.danmaku.danmaku.c.c.eEm();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.qbg != null) {
                    a.b av = this.qbg.av(lockCanvas);
                    if (this.qbl) {
                        if (this.pWy == null) {
                            this.pWy = new LinkedList<>();
                        }
                        long eEm2 = master.flame.danmaku.danmaku.c.c.eEm() - eEm;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eEo()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(av.qax), Long.valueOf(av.qay)));
                    }
                }
                if (this.qbh) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.eEm() - eEm;
    }

    public void pause() {
        if (this.qbg != null) {
            this.qbg.pause();
        }
    }

    public void resume() {
        if (this.qbg != null && this.qbg.isPrepared()) {
            this.qbg.resume();
        } else if (this.qbg == null) {
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
        if (this.qbg == null) {
            prepare();
        } else {
            this.qbg.removeCallbacksAndMessages(null);
        }
        this.qbg.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.qbk.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void Bo(boolean z) {
        this.qbi = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCW() {
        return this.qbi;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCU() {
        return this.qbh;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.qbj = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.qbj;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (eCU() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.qbm && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.qbn = i;
    }

    public long getCurrentTime() {
        if (this.qbg != null) {
            return this.qbg.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
