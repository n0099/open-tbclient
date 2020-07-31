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
    private c.a oaJ;
    private LinkedList<Long> oaR;
    private c ofE;
    private boolean ofF;
    private boolean ofG;
    private f.a ofH;
    private a ofI;
    private boolean ofJ;
    private boolean ofK;
    protected int ofL;

    public DanmakuTextureView(Context context) {
        super(context);
        this.ofG = true;
        this.ofK = true;
        this.ofL = 0;
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
        this.ofI = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ofG = true;
        this.ofK = true;
        this.ofL = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ofG = true;
        this.ofK = true;
        this.ofL = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ofE != null) {
            return this.ofE.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oaJ = aVar;
        if (this.ofE != null) {
            this.ofE.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.ofF = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.ofF = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.ofE != null) {
            this.ofE.ec(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.ofE == null) {
            return null;
        }
        return this.ofE.getConfig();
    }

    private float dWD() {
        long dWB = master.flame.danmaku.danmaku.c.c.dWB();
        this.oaR.addLast(Long.valueOf(dWB));
        Long peekFirst = this.oaR.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dWB - peekFirst.longValue());
        if (this.oaR.size() > 50) {
            this.oaR.removeFirst();
        }
        return longValue > 0.0f ? (this.oaR.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dVl() {
        long dWB;
        if (!this.ofF) {
            dWB = 0;
        } else {
            long dWB2 = master.flame.danmaku.danmaku.c.c.dWB();
            if (!isShown()) {
                dWB = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.ofE != null) {
                        a.b al = this.ofE.al(lockCanvas);
                        if (this.ofJ) {
                            if (this.oaR == null) {
                                this.oaR = new LinkedList<>();
                            }
                            long dWB3 = master.flame.danmaku.danmaku.c.c.dWB() - dWB2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dWD()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.oeU), Long.valueOf(al.oeV)));
                        }
                    }
                    if (this.ofF) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dWB = master.flame.danmaku.danmaku.c.c.dWB() - dWB2;
            }
        }
        return dWB;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ofI.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVm() {
        return this.ofG;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVk() {
        return this.ofF;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.ofH = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ofH;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dVk() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.ofK && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.ofL = i;
    }

    public long getCurrentTime() {
        if (this.ofE != null) {
            return this.ofE.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
