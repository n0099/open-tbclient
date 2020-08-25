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
    private c.a ouK;
    private LinkedList<Long> ouS;
    private c ozC;
    private boolean ozD;
    private boolean ozE;
    private f.a ozF;
    private a ozG;
    private boolean ozH;
    private boolean ozI;
    protected int ozJ;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.ozE = true;
        this.ozI = true;
        this.ozJ = 0;
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
        this.ozG = a.b(this);
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ozE = true;
        this.ozI = true;
        this.ozJ = 0;
        init();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ozE = true;
        this.ozI = true;
        this.ozJ = 0;
        init();
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.ozC != null) {
            this.ozC.a(dVar);
        }
    }

    public void yL(boolean z) {
        if (this.ozC != null) {
            this.ozC.yL(z);
        }
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ozC != null) {
            return this.ozC.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.ouK = aVar;
        if (this.ozC != null) {
            this.ozC.setCallback(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.ozD = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.e(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.ozC != null) {
            this.ozC.ek(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.ozD = false;
    }

    public void release() {
        stop();
        if (this.ouS != null) {
            this.ouS.clear();
        }
    }

    public void stop() {
        eiG();
    }

    private synchronized void eiG() {
        if (this.ozC != null) {
            this.ozC.quit();
            this.ozC = null;
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
        if (this.ozC == null) {
            this.ozC = new c(Of(this.ozJ), this, this.ozI);
        }
    }

    public void a(master.flame.danmaku.danmaku.a.a aVar, DanmakuContext danmakuContext) {
        prepare();
        this.ozC.a(danmakuContext);
        this.ozC.a(aVar);
        this.ozC.setCallback(this.ouK);
        this.ozC.prepare();
    }

    public boolean isPrepared() {
        return this.ozC != null && this.ozC.isPrepared();
    }

    public DanmakuContext getConfig() {
        if (this.ozC == null) {
            return null;
        }
        return this.ozC.getConfig();
    }

    private float eiH() {
        long eiF = master.flame.danmaku.danmaku.c.c.eiF();
        this.ouS.addLast(Long.valueOf(eiF));
        Long peekFirst = this.ouS.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eiF - peekFirst.longValue());
        if (this.ouS.size() > 50) {
            this.ouS.removeFirst();
        }
        return longValue > 0.0f ? (this.ouS.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long eho() {
        if (!this.ozD) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eiF = master.flame.danmaku.danmaku.c.c.eiF();
        try {
            Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                if (this.ozC != null) {
                    a.b ar = this.ozC.ar(lockCanvas);
                    if (this.ozH) {
                        if (this.ouS == null) {
                            this.ouS = new LinkedList<>();
                        }
                        long eiF2 = master.flame.danmaku.danmaku.c.c.eiF() - eiF;
                        d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eiH()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ar.oyT), Long.valueOf(ar.oyU)));
                    }
                }
                if (this.ozD) {
                    this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e) {
        }
        return master.flame.danmaku.danmaku.c.c.eiF() - eiF;
    }

    public void pause() {
        if (this.ozC != null) {
            this.ozC.pause();
        }
    }

    public void resume() {
        if (this.ozC != null && this.ozC.isPrepared()) {
            this.ozC.resume();
        } else if (this.ozC == null) {
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
        if (this.ozC == null) {
            prepare();
        } else {
            this.ozC.removeCallbacksAndMessages(null);
        }
        this.ozC.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ozG.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void yX(boolean z) {
        this.ozE = z;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehp() {
        return this.ozE;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehn() {
        return this.ozD;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.ozF = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ozF;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        Canvas lockCanvas;
        if (ehn() && (lockCanvas = this.mSurfaceHolder.lockCanvas()) != null) {
            d.e(lockCanvas);
            this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.ozI && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.ozJ = i;
    }

    public long getCurrentTime() {
        if (this.ozC != null) {
            return this.ozC.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
