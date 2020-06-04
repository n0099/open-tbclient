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
    private c nBf;
    private boolean nBg;
    private boolean nBh;
    private f.a nBi;
    private a nBj;
    private boolean nBk;
    private boolean nBl;
    protected int nBm;
    private c.a nwl;
    private LinkedList<Long> nwt;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nBh = true;
        this.nBl = true;
        this.nBm = 0;
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
        this.nBj = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nBh = true;
        this.nBl = true;
        this.nBm = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nBh = true;
        this.nBl = true;
        this.nBm = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nBf != null) {
            return this.nBf.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nwl = aVar;
        if (this.nBf != null) {
            this.nBf.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nBg = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nBg = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nBf != null) {
            this.nBf.dR(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nBf == null) {
            return null;
        }
        return this.nBf.getConfig();
    }

    private float dOx() {
        long dOv = master.flame.danmaku.danmaku.c.c.dOv();
        this.nwt.addLast(Long.valueOf(dOv));
        Long peekFirst = this.nwt.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dOv - peekFirst.longValue());
        if (this.nwt.size() > 50) {
            this.nwt.removeFirst();
        }
        return longValue > 0.0f ? (this.nwt.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dNf() {
        long dOv;
        if (!this.nBg) {
            dOv = 0;
        } else {
            long dOv2 = master.flame.danmaku.danmaku.c.c.dOv();
            if (!isShown()) {
                dOv = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nBf != null) {
                        a.b ag = this.nBf.ag(lockCanvas);
                        if (this.nBk) {
                            if (this.nwt == null) {
                                this.nwt = new LinkedList<>();
                            }
                            long dOv3 = master.flame.danmaku.danmaku.c.c.dOv() - dOv2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dOx()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ag.nAw), Long.valueOf(ag.nAx)));
                        }
                    }
                    if (this.nBg) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dOv = master.flame.danmaku.danmaku.c.c.dOv() - dOv2;
            }
        }
        return dOv;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nBj.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dNg() {
        return this.nBh;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dNe() {
        return this.nBg;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nBi = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nBi;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dNe() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nBl && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nBm = i;
    }

    public long getCurrentTime() {
        if (this.nBf != null) {
            return this.nBf.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
