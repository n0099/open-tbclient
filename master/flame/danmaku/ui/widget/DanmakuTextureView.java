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
    private c.a ouK;
    private LinkedList<Long> ouS;
    private c ozC;
    private boolean ozD;
    private boolean ozE;
    private f.a ozF;
    private a ozG;
    private boolean ozH;
    private boolean ozI;
    protected int ozJ;

    public DanmakuTextureView(Context context) {
        super(context);
        this.ozE = true;
        this.ozI = true;
        this.ozJ = 0;
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
        d.aG(true, true);
        this.ozG = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ozE = true;
        this.ozI = true;
        this.ozJ = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ozE = true;
        this.ozI = true;
        this.ozJ = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ozC != null) {
            return this.ozC.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.ouK = aVar;
        if (this.ozC != null) {
            this.ozC.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.ozD = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.ozD = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.ozC != null) {
            this.ozC.ek(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.ozC == null) {
            return null;
        }
        return this.ozC.getConfig();
    }

    private float eiH() {
        long eiF = master.flame.danmaku.danmaku.c.c.eiF();
        this.ouS.addLast(Long.valueOf(eiF));
        Long peekFirst = this.ouS.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eiF - peekFirst.longValue());
        if (this.ouS.size() > 50) {
            this.ouS.removeFirst();
        }
        return longValue > 0.0f ? (this.ouS.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long eho() {
        long eiF;
        if (!this.ozD) {
            eiF = 0;
        } else {
            long eiF2 = master.flame.danmaku.danmaku.c.c.eiF();
            if (!isShown()) {
                eiF = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.ozC != null) {
                        a.b ar = this.ozC.ar(lockCanvas);
                        if (this.ozH) {
                            if (this.ouS == null) {
                                this.ouS = new LinkedList<>();
                            }
                            long eiF3 = master.flame.danmaku.danmaku.c.c.eiF() - eiF2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eiH()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ar.oyT), Long.valueOf(ar.oyU)));
                        }
                    }
                    if (this.ozD) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                eiF = master.flame.danmaku.danmaku.c.c.eiF() - eiF2;
            }
        }
        return eiF;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ozG.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehp() {
        return this.ozE;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehn() {
        return this.ozD;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.ozF = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ozF;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (ehn() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.ozI && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.ozJ = i;
    }

    public long getCurrentTime() {
        if (this.ozC != null) {
            return this.ozC.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
