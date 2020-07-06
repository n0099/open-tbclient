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
    private c.a nSa;
    private LinkedList<Long> nSi;
    private c nWT;
    private boolean nWU;
    private boolean nWV;
    private f.a nWW;
    private a nWX;
    private boolean nWY;
    private boolean nWZ;
    protected int nXa;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nWV = true;
        this.nWZ = true;
        this.nXa = 0;
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
        d.az(true, true);
        this.nWX = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nWV = true;
        this.nWZ = true;
        this.nXa = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nWV = true;
        this.nWZ = true;
        this.nXa = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nWT != null) {
            return this.nWT.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nSa = aVar;
        if (this.nWT != null) {
            this.nWT.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nWU = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nWU = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nWT != null) {
            this.nWT.ea(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nWT == null) {
            return null;
        }
        return this.nWT.getConfig();
    }

    private float dTh() {
        long dTf = master.flame.danmaku.danmaku.c.c.dTf();
        this.nSi.addLast(Long.valueOf(dTf));
        Long peekFirst = this.nSi.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dTf - peekFirst.longValue());
        if (this.nSi.size() > 50) {
            this.nSi.removeFirst();
        }
        return longValue > 0.0f ? (this.nSi.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dRP() {
        long dTf;
        if (!this.nWU) {
            dTf = 0;
        } else {
            long dTf2 = master.flame.danmaku.danmaku.c.c.dTf();
            if (!isShown()) {
                dTf = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nWT != null) {
                        a.b al = this.nWT.al(lockCanvas);
                        if (this.nWY) {
                            if (this.nSi == null) {
                                this.nSi = new LinkedList<>();
                            }
                            long dTf3 = master.flame.danmaku.danmaku.c.c.dTf() - dTf2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dTh()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.nWk), Long.valueOf(al.nWl)));
                        }
                    }
                    if (this.nWU) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dTf = master.flame.danmaku.danmaku.c.c.dTf() - dTf2;
            }
        }
        return dTf;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nWX.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRQ() {
        return this.nWV;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRO() {
        return this.nWU;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nWW = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nWW;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dRO() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nWZ && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nXa = i;
    }

    public long getCurrentTime() {
        if (this.nWT != null) {
            return this.nWT.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
