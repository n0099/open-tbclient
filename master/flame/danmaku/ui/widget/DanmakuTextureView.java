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
/* loaded from: classes4.dex */
public class DanmakuTextureView extends TextureView implements TextureView.SurfaceTextureListener, f, g {
    private c.a nDD;
    private LinkedList<Long> nDL;
    private f.a nIA;
    private a nIB;
    private boolean nIC;
    private boolean nID;
    protected int nIE;
    private c nIx;
    private boolean nIy;
    private boolean nIz;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nIz = true;
        this.nID = true;
        this.nIE = 0;
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
        d.ay(true, true);
        this.nIB = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIz = true;
        this.nID = true;
        this.nIE = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIz = true;
        this.nID = true;
        this.nIE = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nIx != null) {
            return this.nIx.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nDD = aVar;
        if (this.nIx != null) {
            this.nIx.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nIy = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nIy = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nIx != null) {
            this.nIx.ex(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nIx == null) {
            return null;
        }
        return this.nIx.getConfig();
    }

    private float dLC() {
        long dLA = master.flame.danmaku.danmaku.c.c.dLA();
        this.nDL.addLast(Long.valueOf(dLA));
        Long peekFirst = this.nDL.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dLA - peekFirst.longValue());
        if (this.nDL.size() > 50) {
            this.nDL.removeFirst();
        }
        return longValue > 0.0f ? (this.nDL.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dKk() {
        long dLA;
        if (!this.nIy) {
            dLA = 0;
        } else {
            long dLA2 = master.flame.danmaku.danmaku.c.c.dLA();
            if (!isShown()) {
                dLA = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nIx != null) {
                        a.b ak = this.nIx.ak(lockCanvas);
                        if (this.nIC) {
                            if (this.nDL == null) {
                                this.nDL = new LinkedList<>();
                            }
                            long dLA3 = master.flame.danmaku.danmaku.c.c.dLA() - dLA2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dLC()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nHO), Long.valueOf(ak.nHP)));
                        }
                    }
                    if (this.nIy) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dLA = master.flame.danmaku.danmaku.c.c.dLA() - dLA2;
            }
        }
        return dLA;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nIB.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKl() {
        return this.nIz;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKj() {
        return this.nIy;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nIA = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nIA;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dKj() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nID && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nIE = i;
    }

    public long getCurrentTime() {
        if (this.nIx != null) {
            return this.nIx.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
