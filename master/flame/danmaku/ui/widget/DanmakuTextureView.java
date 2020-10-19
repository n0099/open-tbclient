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
    private c.a oTX;
    private LinkedList<Long> oUf;
    private c oYN;
    private boolean oYO;
    private boolean oYP;
    private f.a oYQ;
    private a oYR;
    private boolean oYS;
    private boolean oYT;
    protected int oYU;

    public DanmakuTextureView(Context context) {
        super(context);
        this.oYP = true;
        this.oYT = true;
        this.oYU = 0;
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
        d.aH(true, true);
        this.oYR = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oYP = true;
        this.oYT = true;
        this.oYU = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oYP = true;
        this.oYT = true;
        this.oYU = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.oYN != null) {
            return this.oYN.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oTX = aVar;
        if (this.oYN != null) {
            this.oYN.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.oYO = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.oYO = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.oYN != null) {
            this.oYN.eo(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.oYN == null) {
            return null;
        }
        return this.oYN.getConfig();
    }

    private float eqA() {
        long eqy = master.flame.danmaku.danmaku.c.c.eqy();
        this.oUf.addLast(Long.valueOf(eqy));
        Long peekFirst = this.oUf.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eqy - peekFirst.longValue());
        if (this.oUf.size() > 50) {
            this.oUf.removeFirst();
        }
        return longValue > 0.0f ? (this.oUf.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long eph() {
        long eqy;
        if (!this.oYO) {
            eqy = 0;
        } else {
            long eqy2 = master.flame.danmaku.danmaku.c.c.eqy();
            if (!isShown()) {
                eqy = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.oYN != null) {
                        a.b as = this.oYN.as(lockCanvas);
                        if (this.oYS) {
                            if (this.oUf == null) {
                                this.oUf = new LinkedList<>();
                            }
                            long eqy3 = master.flame.danmaku.danmaku.c.c.eqy() - eqy2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eqA()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(as.oYe), Long.valueOf(as.oYf)));
                        }
                    }
                    if (this.oYO) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                eqy = master.flame.danmaku.danmaku.c.c.eqy() - eqy2;
            }
        }
        return eqy;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.oYR.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean epi() {
        return this.oYP;
    }

    @Override // master.flame.danmaku.a.g
    public boolean epg() {
        return this.oYO;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.oYQ = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.oYQ;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (epg() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.oYT && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.oYU = i;
    }

    public long getCurrentTime() {
        if (this.oYN != null) {
            return this.oYN.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
