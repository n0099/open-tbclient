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
    private c.a pUN;
    private LinkedList<Long> pUV;
    private c pZD;
    private boolean pZE;
    private boolean pZF;
    private f.a pZG;
    private a pZH;
    private boolean pZI;
    private boolean pZJ;
    protected int pZK;

    public DanmakuTextureView(Context context) {
        super(context);
        this.pZF = true;
        this.pZJ = true;
        this.pZK = 0;
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
        d.aN(true, true);
        this.pZH = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pZF = true;
        this.pZJ = true;
        this.pZK = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pZF = true;
        this.pZJ = true;
        this.pZK = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.pZD != null) {
            return this.pZD.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.pUN = aVar;
        if (this.pZD != null) {
            this.pZD.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.pZE = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.pZE = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.pZD != null) {
            this.pZD.ez(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.pZD == null) {
            return null;
        }
        return this.pZD.getConfig();
    }

    private float eEn() {
        long eEl = master.flame.danmaku.danmaku.c.c.eEl();
        this.pUV.addLast(Long.valueOf(eEl));
        Long peekFirst = this.pUV.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eEl - peekFirst.longValue());
        if (this.pUV.size() > 50) {
            this.pUV.removeFirst();
        }
        return longValue > 0.0f ? (this.pUV.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long eCU() {
        long eEl;
        if (!this.pZE) {
            eEl = 0;
        } else {
            long eEl2 = master.flame.danmaku.danmaku.c.c.eEl();
            if (!isShown()) {
                eEl = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.pZD != null) {
                        a.b au = this.pZD.au(lockCanvas);
                        if (this.pZI) {
                            if (this.pUV == null) {
                                this.pUV = new LinkedList<>();
                            }
                            long eEl3 = master.flame.danmaku.danmaku.c.c.eEl() - eEl2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eEn()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(au.pYU), Long.valueOf(au.pYV)));
                        }
                    }
                    if (this.pZE) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                eEl = master.flame.danmaku.danmaku.c.c.eEl() - eEl2;
            }
        }
        return eEl;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.pZH.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCV() {
        return this.pZF;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCT() {
        return this.pZE;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.pZG = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.pZG;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (eCT() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.pZJ && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.pZK = i;
    }

    public long getCurrentTime() {
        if (this.pZD != null) {
            return this.pZD.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
