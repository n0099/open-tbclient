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
    private LinkedList<Long> nDG;
    private c.a nDy;
    private c nIs;
    private boolean nIt;
    private boolean nIu;
    private f.a nIv;
    private a nIw;
    private boolean nIx;
    private boolean nIy;
    protected int nIz;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nIu = true;
        this.nIy = true;
        this.nIz = 0;
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
        this.nIw = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIu = true;
        this.nIy = true;
        this.nIz = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIu = true;
        this.nIy = true;
        this.nIz = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nIs != null) {
            return this.nIs.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nDy = aVar;
        if (this.nIs != null) {
            this.nIs.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nIt = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nIt = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nIs != null) {
            this.nIs.ex(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nIs == null) {
            return null;
        }
        return this.nIs.getConfig();
    }

    private float dLA() {
        long dLy = master.flame.danmaku.danmaku.c.c.dLy();
        this.nDG.addLast(Long.valueOf(dLy));
        Long peekFirst = this.nDG.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dLy - peekFirst.longValue());
        if (this.nDG.size() > 50) {
            this.nDG.removeFirst();
        }
        return longValue > 0.0f ? (this.nDG.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dKi() {
        long dLy;
        if (!this.nIt) {
            dLy = 0;
        } else {
            long dLy2 = master.flame.danmaku.danmaku.c.c.dLy();
            if (!isShown()) {
                dLy = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nIs != null) {
                        a.b ak = this.nIs.ak(lockCanvas);
                        if (this.nIx) {
                            if (this.nDG == null) {
                                this.nDG = new LinkedList<>();
                            }
                            long dLy3 = master.flame.danmaku.danmaku.c.c.dLy() - dLy2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dLA()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nHJ), Long.valueOf(ak.nHK)));
                        }
                    }
                    if (this.nIt) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dLy = master.flame.danmaku.danmaku.c.c.dLy() - dLy2;
            }
        }
        return dLy;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nIw.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKj() {
        return this.nIu;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKh() {
        return this.nIt;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nIv = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nIv;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dKh() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nIy && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nIz = i;
    }

    public long getCurrentTime() {
        if (this.nIs != null) {
            return this.nIs.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
