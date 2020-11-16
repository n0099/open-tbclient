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
    private c.a pWq;
    private LinkedList<Long> pWy;
    private c qbg;
    private boolean qbh;
    private boolean qbi;
    private f.a qbj;
    private a qbk;
    private boolean qbl;
    private boolean qbm;
    protected int qbn;

    public DanmakuTextureView(Context context) {
        super(context);
        this.qbi = true;
        this.qbm = true;
        this.qbn = 0;
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
        d.aL(true, true);
        this.qbk = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qbi = true;
        this.qbm = true;
        this.qbn = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qbi = true;
        this.qbm = true;
        this.qbn = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.qbg != null) {
            return this.qbg.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.pWq = aVar;
        if (this.qbg != null) {
            this.qbg.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.qbh = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.qbh = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.qbg != null) {
            this.qbg.eA(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.qbg == null) {
            return null;
        }
        return this.qbg.getConfig();
    }

    private float eEo() {
        long eEm = master.flame.danmaku.danmaku.c.c.eEm();
        this.pWy.addLast(Long.valueOf(eEm));
        Long peekFirst = this.pWy.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eEm - peekFirst.longValue());
        if (this.pWy.size() > 50) {
            this.pWy.removeFirst();
        }
        return longValue > 0.0f ? (this.pWy.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long eCV() {
        long eEm;
        if (!this.qbh) {
            eEm = 0;
        } else {
            long eEm2 = master.flame.danmaku.danmaku.c.c.eEm();
            if (!isShown()) {
                eEm = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.qbg != null) {
                        a.b av = this.qbg.av(lockCanvas);
                        if (this.qbl) {
                            if (this.pWy == null) {
                                this.pWy = new LinkedList<>();
                            }
                            long eEm3 = master.flame.danmaku.danmaku.c.c.eEm() - eEm2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eEo()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(av.qax), Long.valueOf(av.qay)));
                        }
                    }
                    if (this.qbh) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                eEm = master.flame.danmaku.danmaku.c.c.eEm() - eEm2;
            }
        }
        return eEm;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.qbk.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCW() {
        return this.qbi;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCU() {
        return this.qbh;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.qbj = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.qbj;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (eCU() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.qbm && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.qbn = i;
    }

    public long getCurrentTime() {
        if (this.qbg != null) {
            return this.qbg.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
