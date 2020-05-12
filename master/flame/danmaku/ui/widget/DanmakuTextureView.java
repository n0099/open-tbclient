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
    private c.a mZY;
    private LinkedList<Long> nag;
    private c neU;
    private boolean neV;
    private boolean neW;
    private f.a neX;
    private a neY;
    private boolean neZ;
    private boolean nfa;
    protected int nfb;

    public DanmakuTextureView(Context context) {
        super(context);
        this.neW = true;
        this.nfa = true;
        this.nfb = 0;
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
        d.av(true, true);
        this.neY = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.neW = true;
        this.nfa = true;
        this.nfb = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.neW = true;
        this.nfa = true;
        this.nfb = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.neU != null) {
            return this.neU.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.mZY = aVar;
        if (this.neU != null) {
            this.neU.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.neV = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.neV = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.neU != null) {
            this.neU.dM(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.neU == null) {
            return null;
        }
        return this.neU.getConfig();
    }

    private float dGp() {
        long dGn = master.flame.danmaku.danmaku.c.c.dGn();
        this.nag.addLast(Long.valueOf(dGn));
        Long peekFirst = this.nag.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dGn - peekFirst.longValue());
        if (this.nag.size() > 50) {
            this.nag.removeFirst();
        }
        return longValue > 0.0f ? (this.nag.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dEX() {
        long dGn;
        if (!this.neV) {
            dGn = 0;
        } else {
            long dGn2 = master.flame.danmaku.danmaku.c.c.dGn();
            if (!isShown()) {
                dGn = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.neU != null) {
                        a.b ae = this.neU.ae(lockCanvas);
                        if (this.neZ) {
                            if (this.nag == null) {
                                this.nag = new LinkedList<>();
                            }
                            long dGn3 = master.flame.danmaku.danmaku.c.c.dGn() - dGn2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dGp()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ae.nek), Long.valueOf(ae.nel)));
                        }
                    }
                    if (this.neV) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dGn = master.flame.danmaku.danmaku.c.c.dGn() - dGn2;
            }
        }
        return dGn;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.neY.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dEY() {
        return this.neW;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dEW() {
        return this.neV;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.neX = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.neX;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dEW() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nfa && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nfb = i;
    }

    public long getCurrentTime() {
        if (this.neU != null) {
            return this.neU.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
