package master.flame.danmaku.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
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
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class DanmakuTextureView extends TextureView implements TextureView.SurfaceTextureListener, f, g {
    private c.a nEI;
    private LinkedList<Long> nEQ;
    private c nJA;
    private boolean nJB;
    private boolean nJC;
    private f.a nJD;
    private a nJE;
    private boolean nJF;
    private boolean nJG;
    protected int nJH;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nJC = true;
        this.nJG = true;
        this.nJH = 0;
        init();
    }

    @TargetApi(11)
    private void init() {
        setLayerType(2, null);
        setOpaque(false);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(false);
        setSurfaceTextureListener(this);
        d.aA(true, true);
        this.nJE = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJC = true;
        this.nJG = true;
        this.nJH = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJC = true;
        this.nJG = true;
        this.nJH = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nJA != null) {
            return this.nJA.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nEI = aVar;
        if (this.nJA != null) {
            this.nJA.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nJB = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nJB = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nJA != null) {
            this.nJA.eA(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nJA == null) {
            return null;
        }
        return this.nJA.getConfig();
    }

    private float dMS() {
        long dMQ = master.flame.danmaku.danmaku.c.c.dMQ();
        this.nEQ.addLast(Long.valueOf(dMQ));
        Long peekFirst = this.nEQ.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dMQ - peekFirst.longValue());
        if (this.nEQ.size() > 50) {
            this.nEQ.removeFirst();
        }
        return longValue > 0.0f ? (this.nEQ.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dLA() {
        long dMQ;
        if (!this.nJB) {
            dMQ = 0;
        } else {
            long dMQ2 = master.flame.danmaku.danmaku.c.c.dMQ();
            if (!isShown()) {
                dMQ = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nJA != null) {
                        a.b ak = this.nJA.ak(lockCanvas);
                        if (this.nJF) {
                            if (this.nEQ == null) {
                                this.nEQ = new LinkedList<>();
                            }
                            long dMQ3 = master.flame.danmaku.danmaku.c.c.dMQ() - dMQ2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dMS()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nIR), Long.valueOf(ak.nIS)));
                        }
                    }
                    if (this.nJB) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dMQ = master.flame.danmaku.danmaku.c.c.dMQ() - dMQ2;
            }
        }
        return dMQ;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nJE.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLB() {
        return this.nJC;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLz() {
        return this.nJB;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nJD = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nJD;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dLz() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nJG && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nJH = i;
    }

    public long getCurrentTime() {
        if (this.nJA != null) {
            return this.nJA.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
