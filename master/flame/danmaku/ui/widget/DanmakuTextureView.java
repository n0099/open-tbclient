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
    private c.a oaL;
    private LinkedList<Long> oaT;
    private c ofG;
    private boolean ofH;
    private boolean ofI;
    private f.a ofJ;
    private a ofK;
    private boolean ofL;
    private boolean ofM;
    protected int ofN;

    public DanmakuTextureView(Context context) {
        super(context);
        this.ofI = true;
        this.ofM = true;
        this.ofN = 0;
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
        this.ofK = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ofI = true;
        this.ofM = true;
        this.ofN = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ofI = true;
        this.ofM = true;
        this.ofN = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ofG != null) {
            return this.ofG.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oaL = aVar;
        if (this.ofG != null) {
            this.ofG.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.ofH = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.ofH = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.ofG != null) {
            this.ofG.ec(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.ofG == null) {
            return null;
        }
        return this.ofG.getConfig();
    }

    private float dWE() {
        long dWC = master.flame.danmaku.danmaku.c.c.dWC();
        this.oaT.addLast(Long.valueOf(dWC));
        Long peekFirst = this.oaT.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dWC - peekFirst.longValue());
        if (this.oaT.size() > 50) {
            this.oaT.removeFirst();
        }
        return longValue > 0.0f ? (this.oaT.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dVm() {
        long dWC;
        if (!this.ofH) {
            dWC = 0;
        } else {
            long dWC2 = master.flame.danmaku.danmaku.c.c.dWC();
            if (!isShown()) {
                dWC = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.ofG != null) {
                        a.b al = this.ofG.al(lockCanvas);
                        if (this.ofL) {
                            if (this.oaT == null) {
                                this.oaT = new LinkedList<>();
                            }
                            long dWC3 = master.flame.danmaku.danmaku.c.c.dWC() - dWC2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dWE()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.oeW), Long.valueOf(al.oeX)));
                        }
                    }
                    if (this.ofH) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dWC = master.flame.danmaku.danmaku.c.c.dWC() - dWC2;
            }
        }
        return dWC;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ofK.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVn() {
        return this.ofI;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVl() {
        return this.ofH;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.ofJ = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ofJ;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dVl() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.ofM && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.ofN = i;
    }

    public long getCurrentTime() {
        if (this.ofG != null) {
            return this.ofG.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
