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
    private boolean oAa;
    protected int oAb;
    private c.a ovc;
    private LinkedList<Long> ovk;
    private c ozU;
    private boolean ozV;
    private boolean ozW;
    private f.a ozX;
    private a ozY;
    private boolean ozZ;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.ozW = true;
        this.oAa = true;
        this.oAb = 0;
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
        d.aG(true, true);
        this.ozY = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ozW = true;
        this.oAa = true;
        this.oAb = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ozW = true;
        this.oAa = true;
        this.oAb = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.ozU != null) {
            this.ozU.a(dVar);
        }
    }

    public void yN(boolean z) {
        if (this.ozU != null) {
            this.ozU.yN(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ozU != null) {
            return this.ozU.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.ovc = aVar;
        if (this.ozU != null) {
            this.ozU.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.ozV = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.ozU != null) {
            this.ozU.ek(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.ozV = false;
    }

    public void release() {
        stop();
        if (this.ovk != null) {
            this.ovk.clear();
        }
    }

    public void stop() {
        eiP();
    }

    private synchronized void eiP() {
        if (this.ozU != null) {
            this.ozU.quit();
            this.ozU = null;
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

    protected synchronized Looper Of(int i) {
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
        if (this.ozU == null) {
            this.ozU = new c(Of(this.oAb), this, this.oAa);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.ozU.a(danmakuContext);
        this.ozU.a(aVar);
        this.ozU.setCallback(this.ovc);
        this.ozU.prepare();
    }

    public boolean isPrepared() {
        return this.ozU != null && this.ozU.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.ozU == null) {
            return null;
        }
        return this.ozU.getConfig();
    }

    private float eiQ() {
        long eiO = master.flame.danmaku.danmaku.c.c.eiO();
        this.ovk.addLast(Long.valueOf(eiO));
        Long peekFirst = this.ovk.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eiO - peekFirst.longValue());
        if (this.ovk.size() > 50) {
            this.ovk.removeFirst();
        }
        return longValue > 0.0f ? (this.ovk.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long ehx() {
        if (!this.ozV) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eiO = master.flame.danmaku.danmaku.c.c.eiO();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.ozU != null) {
                    a.b ar = this.ozU.ar(lockCanvas);
                    if (this.ozZ) {
                        if (this.ovk == null) {
                            this.ovk = new LinkedList<>();
                        }
                        long eiO2 = master.flame.danmaku.danmaku.c.c.eiO() - eiO;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eiQ()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ar.ozl), Long.valueOf(ar.ozm)));
                    }
                }
                if (this.ozV) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.eiO() - eiO;
    }

    public void pause() {
        if (this.ozU != null) {
            this.ozU.pause();
        }
    }

    public void resume() {
        if (this.ozU != null && this.ozU.isPrepared()) {
            this.ozU.resume();
        } else if (this.ozU == null) {
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
        if (this.ozU == null) {
            prepare();
        } else {
            this.ozU.removeCallbacksAndMessages(null);
        }
        this.ozU.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ozY.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void yZ(boolean z) {
        this.ozW = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehy() {
        return this.ozW;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehw() {
        return this.ozV;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.ozX = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ozX;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (ehw() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.oAa && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.oAb = i;
    }

    public long getCurrentTime() {
        if (this.ozU != null) {
            return this.ozU.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
