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
    private LinkedList<Long> nGD;
    private c.a nGv;
    private c nLn;
    private boolean nLo;
    private boolean nLp;
    private f.a nLq;
    private a nLr;
    private boolean nLs;
    private boolean nLt;
    protected int nLu;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nLp = true;
        this.nLt = true;
        this.nLu = 0;
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
        this.nLr = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nLp = true;
        this.nLt = true;
        this.nLu = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nLp = true;
        this.nLt = true;
        this.nLu = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nLn != null) {
            return this.nLn.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nGv = aVar;
        if (this.nLn != null) {
            this.nLn.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nLo = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nLo = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nLn != null) {
            this.nLn.eB(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nLn == null) {
            return null;
        }
        return this.nLn.getConfig();
    }

    private float dNs() {
        long dNq = master.flame.danmaku.danmaku.c.c.dNq();
        this.nGD.addLast(Long.valueOf(dNq));
        Long peekFirst = this.nGD.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dNq - peekFirst.longValue());
        if (this.nGD.size() > 50) {
            this.nGD.removeFirst();
        }
        return longValue > 0.0f ? (this.nGD.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dMa() {
        long dNq;
        if (!this.nLo) {
            dNq = 0;
        } else {
            long dNq2 = master.flame.danmaku.danmaku.c.c.dNq();
            if (!isShown()) {
                dNq = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nLn != null) {
                        a.b al = this.nLn.al(lockCanvas);
                        if (this.nLs) {
                            if (this.nGD == null) {
                                this.nGD = new LinkedList<>();
                            }
                            long dNq3 = master.flame.danmaku.danmaku.c.c.dNq() - dNq2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dNs()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.nKE), Long.valueOf(al.nKF)));
                        }
                    }
                    if (this.nLo) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dNq = master.flame.danmaku.danmaku.c.c.dNq() - dNq2;
            }
        }
        return dNq;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nLr.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dMb() {
        return this.nLp;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLZ() {
        return this.nLo;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nLq = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nLq;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dLZ() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nLt && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nLu = i;
    }

    public long getCurrentTime() {
        if (this.nLn != null) {
            return this.nLn.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
