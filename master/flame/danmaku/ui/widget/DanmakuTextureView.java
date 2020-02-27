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
    private LinkedList<Long> nED;
    private c.a nEv;
    private c nJn;
    private boolean nJo;
    private boolean nJp;
    private f.a nJq;
    private a nJr;
    private boolean nJs;
    private boolean nJt;
    protected int nJu;

    public DanmakuTextureView(Context context) {
        super(context);
        this.nJp = true;
        this.nJt = true;
        this.nJu = 0;
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
        this.nJr = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJp = true;
        this.nJt = true;
        this.nJu = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJp = true;
        this.nJt = true;
        this.nJu = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nJn != null) {
            return this.nJn.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nEv = aVar;
        if (this.nJn != null) {
            this.nJn.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.nJo = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.nJo = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.nJn != null) {
            this.nJn.eA(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.nJn == null) {
            return null;
        }
        return this.nJn.getConfig();
    }

    private float dMP() {
        long dMN = master.flame.danmaku.danmaku.c.c.dMN();
        this.nED.addLast(Long.valueOf(dMN));
        Long peekFirst = this.nED.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dMN - peekFirst.longValue());
        if (this.nED.size() > 50) {
            this.nED.removeFirst();
        }
        return longValue > 0.0f ? (this.nED.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long dLx() {
        long dMN;
        if (!this.nJo) {
            dMN = 0;
        } else {
            long dMN2 = master.flame.danmaku.danmaku.c.c.dMN();
            if (!isShown()) {
                dMN = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.nJn != null) {
                        a.b ak = this.nJn.ak(lockCanvas);
                        if (this.nJs) {
                            if (this.nED == null) {
                                this.nED = new LinkedList<>();
                            }
                            long dMN3 = master.flame.danmaku.danmaku.c.c.dMN() - dMN2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dMP()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nIE), Long.valueOf(ak.nIF)));
                        }
                    }
                    if (this.nJo) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                dMN = master.flame.danmaku.danmaku.c.c.dMN() - dMN2;
            }
        }
        return dMN;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nJr.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLy() {
        return this.nJp;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLw() {
        return this.nJo;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nJq = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nJq;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (dLw() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nJt && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nJu = i;
    }

    public long getCurrentTime() {
        if (this.nJn != null) {
            return this.nJn.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
