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
    private LinkedList<Long> nED;
    private c.a nEv;
    private c nJn;
    private boolean nJo;
    private boolean nJp;
    private f.a nJq;
    private a nJr;
    private boolean nJs;
    private boolean nJt;
    protected int nJu;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.nJp = true;
        this.nJt = true;
        this.nJu = 0;
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
        this.nJr = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJp = true;
        this.nJt = true;
        this.nJu = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJp = true;
        this.nJt = true;
        this.nJu = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nJn != null) {
            this.nJn.a(dVar);
        }
    }

    public void wG(boolean z) {
        if (this.nJn != null) {
            this.nJn.wG(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nJn != null) {
            return this.nJn.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nEv = aVar;
        if (this.nJn != null) {
            this.nJn.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.nJo = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.nJn != null) {
            this.nJn.eA(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.nJo = false;
    }

    public void release() {
        stop();
        if (this.nED != null) {
            this.nED.clear();
        }
    }

    public void stop() {
        dMO();
    }

    private synchronized void dMO() {
        if (this.nJn != null) {
            this.nJn.quit();
            this.nJn = null;
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

    protected synchronized Looper NO(int i) {
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
        if (this.nJn == null) {
            this.nJn = new c(NO(this.nJu), this, this.nJt);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.nJn.a(danmakuContext);
        this.nJn.a(aVar);
        this.nJn.setCallback(this.nEv);
        this.nJn.prepare();
    }

    public boolean isPrepared() {
        return this.nJn != null && this.nJn.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.nJn == null) {
            return null;
        }
        return this.nJn.getConfig();
    }

    private float dMP() {
        long dMN = master.flame.danmaku.danmaku.c.c.dMN();
        this.nED.addLast(Long.valueOf(dMN));
        Long peekFirst = this.nED.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dMN - peekFirst.longValue());
        if (this.nED.size() > 50) {
            this.nED.removeFirst();
        }
        return longValue > 0.0f ? (this.nED.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dLx() {
        if (!this.nJo) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dMN = master.flame.danmaku.danmaku.c.c.dMN();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.nJn != null) {
                    a.b ak = this.nJn.ak(lockCanvas);
                    if (this.nJs) {
                        if (this.nED == null) {
                            this.nED = new LinkedList<>();
                        }
                        long dMN2 = master.flame.danmaku.danmaku.c.c.dMN() - dMN;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dMP()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nIE), Long.valueOf(ak.nIF)));
                    }
                }
                if (this.nJo) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dMN() - dMN;
    }

    public void pause() {
        if (this.nJn != null) {
            this.nJn.pause();
        }
    }

    public void resume() {
        if (this.nJn != null && this.nJn.isPrepared()) {
            this.nJn.resume();
        } else if (this.nJn == null) {
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
        if (this.nJn == null) {
            prepare();
        } else {
            this.nJn.removeCallbacksAndMessages(null);
        }
        this.nJn.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nJr.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void wS(boolean z) {
        this.nJp = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLy() {
        return this.nJp;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLw() {
        return this.nJo;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nJq = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nJq;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dLw() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nJt && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nJu = i;
    }

    public long getCurrentTime() {
        if (this.nJn != null) {
            return this.nJn.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
