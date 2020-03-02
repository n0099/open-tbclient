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
    private LinkedList<Long> nEF;
    private c.a nEx;
    private Object nJF;
    private boolean nJG;
    private long nJH;
    private boolean nJI;
    private int nJJ;
    private Runnable nJK;
    private c nJp;
    private boolean nJq;
    private boolean nJr;
    private f.a nJs;
    private a nJt;
    private boolean nJu;
    private boolean nJv;
    protected int nJw;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nJJ;
        danmakuView.nJJ = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nJr = true;
        this.nJv = true;
        this.nJw = 0;
        this.nJF = new Object();
        this.nJG = false;
        this.mRequestRender = false;
        this.nJJ = 0;
        this.nJK = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nJp != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nJJ > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nJp.resume();
                    } else {
                        DanmakuView.this.nJp.postDelayed(this, DanmakuView.this.nJJ * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nJH = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aA(true, false);
        this.nJt = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJr = true;
        this.nJv = true;
        this.nJw = 0;
        this.nJF = new Object();
        this.nJG = false;
        this.mRequestRender = false;
        this.nJJ = 0;
        this.nJK = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nJp != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nJJ > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nJp.resume();
                    } else {
                        DanmakuView.this.nJp.postDelayed(this, DanmakuView.this.nJJ * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJr = true;
        this.nJv = true;
        this.nJw = 0;
        this.nJF = new Object();
        this.nJG = false;
        this.mRequestRender = false;
        this.nJJ = 0;
        this.nJK = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nJp != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nJJ > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nJp.resume();
                    } else {
                        DanmakuView.this.nJp.postDelayed(this, DanmakuView.this.nJJ * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nJp != null) {
            return this.nJp.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nEx = aVar;
        if (this.nJp != null) {
            this.nJp.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.nJp == null) {
            return null;
        }
        return this.nJp.getConfig();
    }

    private float dMR() {
        long dMP = master.flame.danmaku.danmaku.c.c.dMP();
        this.nEF.addLast(Long.valueOf(dMP));
        Long peekFirst = this.nEF.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dMP - peekFirst.longValue());
        if (this.nEF.size() > 50) {
            this.nEF.removeFirst();
        }
        return longValue > 0.0f ? (this.nEF.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dLz() {
        if (!this.nJq) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dMP = master.flame.danmaku.danmaku.c.c.dMP();
        dMU();
        return master.flame.danmaku.danmaku.c.c.dMP() - dMP;
    }

    @SuppressLint({"NewApi"})
    private void dMT() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dMU() {
        if (this.nJv) {
            dMT();
            synchronized (this.nJF) {
                while (!this.nJG && this.nJp != null) {
                    try {
                        this.nJF.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nJv || this.nJp == null || this.nJp.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nJG = false;
            }
        }
    }

    private void dMV() {
        this.nJI = true;
        dMU();
    }

    private void dMW() {
        synchronized (this.nJF) {
            this.nJG = true;
            this.nJF.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nJv && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nJI) {
            d.e(canvas);
            this.nJI = false;
        } else if (this.nJp != null) {
            a.b ak = this.nJp.ak(canvas);
            if (this.nJu) {
                if (this.nEF == null) {
                    this.nEF = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dMR()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nIG), Long.valueOf(ak.nIH)));
            }
        }
        this.mRequestRender = false;
        dMW();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nJp != null) {
            this.nJp.eA(i3 - i, i4 - i2);
        }
        this.nJq = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nJt.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLA() {
        return this.nJr;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLy() {
        return this.nJq;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dLy()) {
            if (!this.nJv || Thread.currentThread().getId() == this.nJH) {
                this.nJI = true;
                dMT();
                return;
            }
            dMV();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nJv && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nJw = i;
    }

    public long getCurrentTime() {
        if (this.nJp != null) {
            return this.nJp.getCurrentTime();
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
        this.nJs = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nJs;
    }
}
