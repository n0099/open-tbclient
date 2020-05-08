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
    private c.a mZY;
    private LinkedList<Long> nag;
    private c neU;
    private boolean neV;
    private boolean neW;
    private f.a neX;
    private a neY;
    private boolean neZ;
    private boolean nfa;
    protected int nfb;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.neW = true;
        this.nfa = true;
        this.nfb = 0;
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
        d.av(true, true);
        this.neY = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.neW = true;
        this.nfa = true;
        this.nfb = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.neW = true;
        this.nfa = true;
        this.nfb = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.neU != null) {
            this.neU.a(dVar);
        }
    }

    public void wt(boolean z) {
        if (this.neU != null) {
            this.neU.wt(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.neU != null) {
            return this.neU.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.mZY = aVar;
        if (this.neU != null) {
            this.neU.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.neV = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.neU != null) {
            this.neU.dM(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.neV = false;
    }

    public void release() {
        stop();
        if (this.nag != null) {
            this.nag.clear();
        }
    }

    public void stop() {
        dGn();
    }

    private synchronized void dGn() {
        if (this.neU != null) {
            this.neU.quit();
            this.neU = null;
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

    protected synchronized Looper Jo(int i) {
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
        if (this.neU == null) {
            this.neU = new c(Jo(this.nfb), this, this.nfa);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.neU.a(danmakuContext);
        this.neU.a(aVar);
        this.neU.setCallback(this.mZY);
        this.neU.prepare();
    }

    public boolean isPrepared() {
        return this.neU != null && this.neU.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.neU == null) {
            return null;
        }
        return this.neU.getConfig();
    }

    private float dGo() {
        long dGm = master.flame.danmaku.danmaku.c.c.dGm();
        this.nag.addLast(Long.valueOf(dGm));
        Long peekFirst = this.nag.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dGm - peekFirst.longValue());
        if (this.nag.size() > 50) {
            this.nag.removeFirst();
        }
        return longValue > 0.0f ? (this.nag.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dEW() {
        if (!this.neV) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dGm = master.flame.danmaku.danmaku.c.c.dGm();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.neU != null) {
                    a.b ae = this.neU.ae(lockCanvas);
                    if (this.neZ) {
                        if (this.nag == null) {
                            this.nag = new LinkedList<>();
                        }
                        long dGm2 = master.flame.danmaku.danmaku.c.c.dGm() - dGm;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dGo()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ae.nek), Long.valueOf(ae.nel)));
                    }
                }
                if (this.neV) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.dGm() - dGm;
    }

    public void pause() {
        if (this.neU != null) {
            this.neU.pause();
        }
    }

    public void resume() {
        if (this.neU != null && this.neU.isPrepared()) {
            this.neU.resume();
        } else if (this.neU == null) {
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
        if (this.neU == null) {
            prepare();
        } else {
            this.neU.removeCallbacksAndMessages(null);
        }
        this.neU.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.neY.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void wF(boolean z) {
        this.neW = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dEX() {
        return this.neW;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dEV() {
        return this.neV;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.neX = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.neX;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (dEV() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nfa && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nfb = i;
    }

    public long getCurrentTime() {
        if (this.neU != null) {
            return this.neU.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
