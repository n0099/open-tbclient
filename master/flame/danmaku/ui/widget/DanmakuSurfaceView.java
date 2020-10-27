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
    private LinkedList<Long> pLB;
    private c.a pLt;
    private c pQj;
    private boolean pQk;
    private boolean pQl;
    private f.a pQm;
    private a pQn;
    private boolean pQo;
    private boolean pQp;
    protected int pQq;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.pQl = true;
        this.pQp = true;
        this.pQq = 0;
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
        this.pQn = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pQl = true;
        this.pQp = true;
        this.pQq = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pQl = true;
        this.pQp = true;
        this.pQq = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.pQj != null) {
            this.pQj.a(dVar);
        }
    }

    public void AK(boolean z) {
        if (this.pQj != null) {
            this.pQj.AK(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.pQj != null) {
            return this.pQj.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.pLt = aVar;
        if (this.pQj != null) {
            this.pQj.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.pQk = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.pQj != null) {
            this.pQj.ew(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.pQk = false;
    }

    public void release() {
        stop();
        if (this.pLB != null) {
            this.pLB.clear();
        }
    }

    public void stop() {
        eAx();
    }

    private synchronized void eAx() {
        if (this.pQj != null) {
            this.pQj.quit();
            this.pQj = null;
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

    protected synchronized Looper Rh(int i) {
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
        if (this.pQj == null) {
            this.pQj = new c(Rh(this.pQq), this, this.pQp);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.pQj.a(danmakuContext);
        this.pQj.a(aVar);
        this.pQj.setCallback(this.pLt);
        this.pQj.prepare();
    }

    public boolean isPrepared() {
        return this.pQj != null && this.pQj.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.pQj == null) {
            return null;
        }
        return this.pQj.getConfig();
    }

    private float eAy() {
        long eAw = master.flame.danmaku.danmaku.c.c.eAw();
        this.pLB.addLast(Long.valueOf(eAw));
        Long peekFirst = this.pLB.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eAw - peekFirst.longValue());
        if (this.pLB.size() > 50) {
            this.pLB.removeFirst();
        }
        return longValue > 0.0f ? (this.pLB.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long ezf() {
        if (!this.pQk) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eAw = master.flame.danmaku.danmaku.c.c.eAw();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.pQj != null) {
                    a.b au = this.pQj.au(lockCanvas);
                    if (this.pQo) {
                        if (this.pLB == null) {
                            this.pLB = new LinkedList<>();
                        }
                        long eAw2 = master.flame.danmaku.danmaku.c.c.eAw() - eAw;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eAy()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(au.pPA), Long.valueOf(au.pPB)));
                    }
                }
                if (this.pQk) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.eAw() - eAw;
    }

    public void pause() {
        if (this.pQj != null) {
            this.pQj.pause();
        }
    }

    public void resume() {
        if (this.pQj != null && this.pQj.isPrepared()) {
            this.pQj.resume();
        } else if (this.pQj == null) {
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
        if (this.pQj == null) {
            prepare();
        } else {
            this.pQj.removeCallbacksAndMessages(null);
        }
        this.pQj.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.pQn.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void AW(boolean z) {
        this.pQl = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ezg() {
        return this.pQl;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eze() {
        return this.pQk;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.pQm = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.pQm;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (eze() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.pQp && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.pQq = i;
    }

    public long getCurrentTime() {
        if (this.pQj != null) {
            return this.pQj.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
