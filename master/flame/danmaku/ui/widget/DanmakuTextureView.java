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
    private c.a nRX;
    private LinkedList<Long> nSf;
    private c nWQ;
    private boolean nWR;
    private boolean nWS;
    private f.a nWT;
    private a nWU;
    private boolean nWV;
    private boolean nWW;
    protected int nWX;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nWS = true;
        this.nWW = true;
        this.nWX = 0;
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
        this.nWU = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nWS = true;
        this.nWW = true;
        this.nWX = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nWS = true;
        this.nWW = true;
        this.nWX = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nWQ != null) {
            return this.nWQ.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nRX = aVar;
        if (this.nWQ != null) {
            this.nWQ.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nWR = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nWR = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nWQ != null) {
            this.nWQ.ea(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nWQ == null) {
            return null;
        }
        return this.nWQ.getConfig();
    }

    private float dTd() {
        long dTb = master.flame.danmaku.danmaku.c.c.dTb();
        this.nSf.addLast(Long.valueOf(dTb));
        Long peekFirst = this.nSf.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dTb - peekFirst.longValue());
        if (this.nSf.size() > 50) {
            this.nSf.removeFirst();
        }
        return longValue > 0.0f ? (this.nSf.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dRL() {
        long dTb;
        if (!this.nWR) {
            dTb = 0;
        } else {
            long dTb2 = master.flame.danmaku.danmaku.c.c.dTb();
            if (!isShown()) {
                dTb = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nWQ != null) {
                        a.b al = this.nWQ.al(lockCanvas);
                        if (this.nWV) {
                            if (this.nSf == null) {
                                this.nSf = new LinkedList<>();
                            }
                            long dTb3 = master.flame.danmaku.danmaku.c.c.dTb() - dTb2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dTd()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.nWh), Long.valueOf(al.nWi)));
                        }
                    }
                    if (this.nWR) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dTb = master.flame.danmaku.danmaku.c.c.dTb() - dTb2;
            }
        }
        return dTb;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nWU.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRM() {
        return this.nWS;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRK() {
        return this.nWR;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nWT = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nWT;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dRK() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nWW && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nWX = i;
    }

    public long getCurrentTime() {
        if (this.nWQ != null) {
            return this.nWQ.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
