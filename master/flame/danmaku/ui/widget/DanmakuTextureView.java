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
    private boolean nAa;
    private boolean nAb;
    protected int nAc;
    private c.a nvb;
    private LinkedList<Long> nvj;
    private c nzV;
    private boolean nzW;
    private boolean nzX;
    private f.a nzY;
    private a nzZ;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nzX = true;
        this.nAb = true;
        this.nAc = 0;
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
        this.nzZ = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nzX = true;
        this.nAb = true;
        this.nAc = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nzX = true;
        this.nAb = true;
        this.nAc = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nzV != null) {
            return this.nzV.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nvb = aVar;
        if (this.nzV != null) {
            this.nzV.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nzW = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nzW = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nzV != null) {
            this.nzV.dR(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nzV == null) {
            return null;
        }
        return this.nzV.getConfig();
    }

    private float dOj() {
        long dOh = master.flame.danmaku.danmaku.c.c.dOh();
        this.nvj.addLast(Long.valueOf(dOh));
        Long peekFirst = this.nvj.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dOh - peekFirst.longValue());
        if (this.nvj.size() > 50) {
            this.nvj.removeFirst();
        }
        return longValue > 0.0f ? (this.nvj.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dMR() {
        long dOh;
        if (!this.nzW) {
            dOh = 0;
        } else {
            long dOh2 = master.flame.danmaku.danmaku.c.c.dOh();
            if (!isShown()) {
                dOh = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nzV != null) {
                        a.b ag = this.nzV.ag(lockCanvas);
                        if (this.nAa) {
                            if (this.nvj == null) {
                                this.nvj = new LinkedList<>();
                            }
                            long dOh3 = master.flame.danmaku.danmaku.c.c.dOh() - dOh2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dOj()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ag.nzm), Long.valueOf(ag.nzn)));
                        }
                    }
                    if (this.nzW) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dOh = master.flame.danmaku.danmaku.c.c.dOh() - dOh2;
            }
        }
        return dOh;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nzZ.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dMS() {
        return this.nzX;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dMQ() {
        return this.nzW;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nzY = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nzY;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dMQ() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nAb && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nAc = i;
    }

    public long getCurrentTime() {
        if (this.nzV != null) {
            return this.nzV.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
