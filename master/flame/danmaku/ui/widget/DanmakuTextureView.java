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
/* loaded from: classes6.dex */
public class DanmakuTextureView extends TextureView implements TextureView.SurfaceTextureListener, f, g {
    private c.a oEI;
    private LinkedList<Long> oEQ;
    private boolean oJA;
    private boolean oJB;
    private f.a oJC;
    private a oJD;
    private boolean oJE;
    private boolean oJF;
    protected int oJG;
    private c oJz;

    public DanmakuTextureView(Context context) {
        super(context);
        this.oJB = true;
        this.oJF = true;
        this.oJG = 0;
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
        d.aI(true, true);
        this.oJD = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oJB = true;
        this.oJF = true;
        this.oJG = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oJB = true;
        this.oJF = true;
        this.oJG = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.oJz != null) {
            return this.oJz.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oEI = aVar;
        if (this.oJz != null) {
            this.oJz.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.oJA = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.oJA = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.oJz != null) {
            this.oJz.eo(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.oJz == null) {
            return null;
        }
        return this.oJz.getConfig();
    }

    private float emN() {
        long emL = master.flame.danmaku.danmaku.c.c.emL();
        this.oEQ.addLast(Long.valueOf(emL));
        Long peekFirst = this.oEQ.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (emL - peekFirst.longValue());
        if (this.oEQ.size() > 50) {
            this.oEQ.removeFirst();
        }
        return longValue > 0.0f ? (this.oEQ.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long elu() {
        long emL;
        if (!this.oJA) {
            emL = 0;
        } else {
            long emL2 = master.flame.danmaku.danmaku.c.c.emL();
            if (!isShown()) {
                emL = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.oJz != null) {
                        a.b ar = this.oJz.ar(lockCanvas);
                        if (this.oJE) {
                            if (this.oEQ == null) {
                                this.oEQ = new LinkedList<>();
                            }
                            long emL3 = master.flame.danmaku.danmaku.c.c.emL() - emL2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(emN()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ar.oIQ), Long.valueOf(ar.oIR)));
                        }
                    }
                    if (this.oJA) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                emL = master.flame.danmaku.danmaku.c.c.emL() - emL2;
            }
        }
        return emL;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.oJD.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean elv() {
        return this.oJB;
    }

    @Override // master.flame.danmaku.a.g
    public boolean elt() {
        return this.oJA;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.oJC = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.oJC;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (elt() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.oJF && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.oJG = i;
    }

    public long getCurrentTime() {
        if (this.oJz != null) {
            return this.oJz.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
