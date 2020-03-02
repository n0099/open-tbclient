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
    private LinkedList<Long> nEF;
    private c.a nEx;
    private c nJp;
    private boolean nJq;
    private boolean nJr;
    private f.a nJs;
    private a nJt;
    private boolean nJu;
    private boolean nJv;
    protected int nJw;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nJr = true;
        this.nJv = true;
        this.nJw = 0;
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
        this.nJt = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJr = true;
        this.nJv = true;
        this.nJw = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJr = true;
        this.nJv = true;
        this.nJw = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nJp != null) {
            return this.nJp.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nEx = aVar;
        if (this.nJp != null) {
            this.nJp.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nJq = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nJq = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nJp != null) {
            this.nJp.eA(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nJp == null) {
            return null;
        }
        return this.nJp.getConfig();
    }

    private float dMR() {
        long dMP = master.flame.danmaku.danmaku.c.c.dMP();
        this.nEF.addLast(Long.valueOf(dMP));
        Long peekFirst = this.nEF.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dMP - peekFirst.longValue());
        if (this.nEF.size() > 50) {
            this.nEF.removeFirst();
        }
        return longValue > 0.0f ? (this.nEF.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dLz() {
        long dMP;
        if (!this.nJq) {
            dMP = 0;
        } else {
            long dMP2 = master.flame.danmaku.danmaku.c.c.dMP();
            if (!isShown()) {
                dMP = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nJp != null) {
                        a.b ak = this.nJp.ak(lockCanvas);
                        if (this.nJu) {
                            if (this.nEF == null) {
                                this.nEF = new LinkedList<>();
                            }
                            long dMP3 = master.flame.danmaku.danmaku.c.c.dMP() - dMP2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dMR()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nIG), Long.valueOf(ak.nIH)));
                        }
                    }
                    if (this.nJq) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dMP = master.flame.danmaku.danmaku.c.c.dMP() - dMP2;
            }
        }
        return dMP;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nJt.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLA() {
        return this.nJr;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLy() {
        return this.nJq;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nJs = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nJs;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dLy() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nJv && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nJw = i;
    }

    public long getCurrentTime() {
        if (this.nJp != null) {
            return this.nJp.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
