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
    private LinkedList<Long> pLB;
    private c.a pLt;
    private c pQj;
    private boolean pQk;
    private boolean pQl;
    private f.a pQm;
    private a pQn;
    private boolean pQo;
    private boolean pQp;
    protected int pQq;

    public DanmakuTextureView(Context context) {
        super(context);
        this.pQl = true;
        this.pQp = true;
        this.pQq = 0;
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
        d.aN(true, true);
        this.pQn = a.b(this);
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pQl = true;
        this.pQp = true;
        this.pQq = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pQl = true;
        this.pQp = true;
        this.pQq = 0;
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.pQj != null) {
            return this.pQj.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.pLt = aVar;
        if (this.pQj != null) {
            this.pQj.setCallback(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.pQk = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.pQk = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.pQj != null) {
            this.pQj.ew(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DanmakuContext getConfig() {
        if (this.pQj == null) {
            return null;
        }
        return this.pQj.getConfig();
    }

    private float eAy() {
        long eAw = master.flame.danmaku.danmaku.c.c.eAw();
        this.pLB.addLast(Long.valueOf(eAw));
        Long peekFirst = this.pLB.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eAw - peekFirst.longValue());
        if (this.pLB.size() > 50) {
            this.pLB.removeFirst();
        }
        return longValue > 0.0f ? (this.pLB.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized long ezf() {
        long eAw;
        if (!this.pQk) {
            eAw = 0;
        } else {
            long eAw2 = master.flame.danmaku.danmaku.c.c.eAw();
            if (!isShown()) {
                eAw = -1;
            } else {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    if (this.pQj != null) {
                        a.b au = this.pQj.au(lockCanvas);
                        if (this.pQo) {
                            if (this.pLB == null) {
                                this.pLB = new LinkedList<>();
                            }
                            long eAw3 = master.flame.danmaku.danmaku.c.c.eAw() - eAw2;
                            d.c(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eAy()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(au.pPA), Long.valueOf(au.pPB)));
                        }
                    }
                    if (this.pQk) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
                eAw = master.flame.danmaku.danmaku.c.c.eAw() - eAw2;
            }
        }
        return eAw;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.pQn.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ezg() {
        return this.pQl;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eze() {
        return this.pQk;
    }

    public View getView() {
        return this;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.pQm = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.pQm;
    }

    @Override // master.flame.danmaku.a.g
    public synchronized void clear() {
        Canvas lockCanvas;
        if (eze() && (lockCanvas = lockCanvas()) != null) {
            d.e(lockCanvas);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.pQp && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.pQq = i;
    }

    public long getCurrentTime() {
        if (this.pQj != null) {
            return this.pQj.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    public boolean isHardwareAccelerated() {
        return false;
    }
}
