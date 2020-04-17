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
    private c.a mZV;
    private LinkedList<Long> nad;
    private c neR;
    private boolean neS;
    private boolean neT;
    private f.a neU;
    private a neV;
    private boolean neW;
    private boolean neX;
    protected int neY;

    public DanmakuTextureView(Context context) {
        super(context);
        this.neT = true;
        this.neX = true;
        this.neY = 0;
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
        d.av(true, true);
        this.neV = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.neT = true;
        this.neX = true;
        this.neY = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.neT = true;
        this.neX = true;
        this.neY = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.neR != null) {
            return this.neR.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.mZV = aVar;
        if (this.neR != null) {
            this.neR.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.neS = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.neS = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.neR != null) {
            this.neR.dM(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.neR == null) {
            return null;
        }
        return this.neR.getConfig();
    }

    private float dGs() {
        long dGq = master.flame.danmaku.danmaku.c.c.dGq();
        this.nad.addLast(Long.valueOf(dGq));
        Long peekFirst = this.nad.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dGq - peekFirst.longValue());
        if (this.nad.size() > 50) {
            this.nad.removeFirst();
        }
        return longValue > 0.0f ? (this.nad.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dFa() {
        long dGq;
        if (!this.neS) {
            dGq = 0;
        } else {
            long dGq2 = master.flame.danmaku.danmaku.c.c.dGq();
            if (!isShown()) {
                dGq = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.neR != null) {
                        a.b ae = this.neR.ae(lockCanvas);
                        if (this.neW) {
                            if (this.nad == null) {
                                this.nad = new LinkedList<>();
                            }
                            long dGq3 = master.flame.danmaku.danmaku.c.c.dGq() - dGq2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dGs()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ae.neh), Long.valueOf(ae.nei)));
                        }
                    }
                    if (this.neS) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dGq = master.flame.danmaku.danmaku.c.c.dGq() - dGq2;
            }
        }
        return dGq;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.neV.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dFb() {
        return this.neT;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dEZ() {
        return this.neS;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.neU = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.neU;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dEZ() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.neX && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.neY = i;
    }

    public long getCurrentTime() {
        if (this.neR != null) {
            return this.neR.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
