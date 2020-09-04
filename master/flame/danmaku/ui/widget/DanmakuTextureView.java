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

    public DanmakuTextureView(Context context) {
        super(context);
        this.ozW = true;
        this.oAa = true;
        this.oAb = 0;
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
        d.aG(true, true);
        this.ozY = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ozW = true;
        this.oAa = true;
        this.oAb = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ozW = true;
        this.oAa = true;
        this.oAb = 0;
        init();
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

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.ozV = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.ozV = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.ozU != null) {
            this.ozU.ek(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
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
    public synchronized long ehx() {
        long eiO;
        if (!this.ozV) {
            eiO = 0;
        } else {
            long eiO2 = master.flame.danmaku.danmaku.c.c.eiO();
            if (!isShown()) {
                eiO = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.ozU != null) {
                        a.b ar = this.ozU.ar(lockCanvas);
                        if (this.ozZ) {
                            if (this.ovk == null) {
                                this.ovk = new LinkedList<>();
                            }
                            long eiO3 = master.flame.danmaku.danmaku.c.c.eiO() - eiO2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eiQ()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ar.ozl), Long.valueOf(ar.ozm)));
                        }
                    }
                    if (this.ozV) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                eiO = master.flame.danmaku.danmaku.c.c.eiO() - eiO2;
            }
        }
        return eiO;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ozY.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
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
    public synchronized void clear() {
        Canvas lockCanvas;
        if (ehw() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
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
