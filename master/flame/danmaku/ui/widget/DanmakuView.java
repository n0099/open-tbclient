package master.flame.danmaku.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
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
/* loaded from: classes5.dex */
public class DanmakuView extends View implements f, g {
    private boolean mRequestRender;
    private c.a mZV;
    private LinkedList<Long> nad;
    private c neR;
    private boolean neS;
    private boolean neT;
    private f.a neU;
    private a neV;
    private boolean neW;
    private boolean neX;
    protected int neY;
    private Object nfh;
    private boolean nfi;
    private long nfj;
    private boolean nfk;
    private int nfl;
    private Runnable nfm;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nfl;
        danmakuView.nfl = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.neT = true;
        this.neX = true;
        this.neY = 0;
        this.nfh = new Object();
        this.nfi = false;
        this.mRequestRender = false;
        this.nfl = 0;
        this.nfm = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.neR != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nfl > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.neR.resume();
                    } else {
                        DanmakuView.this.neR.postDelayed(this, DanmakuView.this.nfl * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nfj = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.av(true, false);
        this.neV = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.neT = true;
        this.neX = true;
        this.neY = 0;
        this.nfh = new Object();
        this.nfi = false;
        this.mRequestRender = false;
        this.nfl = 0;
        this.nfm = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.neR != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nfl > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.neR.resume();
                    } else {
                        DanmakuView.this.neR.postDelayed(this, DanmakuView.this.nfl * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.neT = true;
        this.neX = true;
        this.neY = 0;
        this.nfh = new Object();
        this.nfi = false;
        this.mRequestRender = false;
        this.nfl = 0;
        this.nfm = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.neR != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nfl > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.neR.resume();
                    } else {
                        DanmakuView.this.neR.postDelayed(this, DanmakuView.this.nfl * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.neR != null) {
            return this.neR.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.mZV = aVar;
        if (this.neR != null) {
            this.neR.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.neR == null) {
            return null;
        }
        return this.neR.getConfig();
    }

    private float dGs() {
        long dGq = master.flame.danmaku.danmaku.c.c.dGq();
        this.nad.addLast(Long.valueOf(dGq));
        Long peekFirst = this.nad.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dGq - peekFirst.longValue());
        if (this.nad.size() > 50) {
            this.nad.removeFirst();
        }
        return longValue > 0.0f ? (this.nad.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dFa() {
        if (!this.neS) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dGq = master.flame.danmaku.danmaku.c.c.dGq();
        dGv();
        return master.flame.danmaku.danmaku.c.c.dGq() - dGq;
    }

    @SuppressLint({"NewApi"})
    private void dGu() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dGv() {
        if (this.neX) {
            dGu();
            synchronized (this.nfh) {
                while (!this.nfi && this.neR != null) {
                    try {
                        this.nfh.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.neX || this.neR == null || this.neR.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nfi = false;
            }
        }
    }

    private void dGw() {
        this.nfk = true;
        dGv();
    }

    private void dGx() {
        synchronized (this.nfh) {
            this.nfi = true;
            this.nfh.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.neX && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nfk) {
            d.e(canvas);
            this.nfk = false;
        } else if (this.neR != null) {
            a.b ae = this.neR.ae(canvas);
            if (this.neW) {
                if (this.nad == null) {
                    this.nad = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dGs()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ae.neh), Long.valueOf(ae.nei)));
            }
        }
        this.mRequestRender = false;
        dGx();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.neR != null) {
            this.neR.dM(i3 - i, i4 - i2);
        }
        this.neS = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.neV.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dFb() {
        return this.neT;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dEZ() {
        return this.neS;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dEZ()) {
            if (!this.neX || Thread.currentThread().getId() == this.nfj) {
                this.nfk = true;
                dGu();
                return;
            }
            dGw();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.neX && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.neY = i;
    }

    public long getCurrentTime() {
        if (this.neR != null) {
            return this.neR.getCurrentTime();
        }
        return 0L;
    }

    @Override // android.view.View, master.flame.danmaku.a.g
    @SuppressLint({"NewApi"})
    public boolean isHardwareAccelerated() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.isHardwareAccelerated();
        }
        return false;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.neU = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.neU;
    }
}
