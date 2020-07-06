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
    private c.a nSa;
    private LinkedList<Long> nSi;
    private c nWT;
    private boolean nWU;
    private boolean nWV;
    private f.a nWW;
    private a nWX;
    private boolean nWY;
    private boolean nWZ;
    protected int nXa;
    private Object nXj;
    private boolean nXk;
    private long nXl;
    private boolean nXm;
    private int nXn;
    private Runnable nXo;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nXn;
        danmakuView.nXn = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nWV = true;
        this.nWZ = true;
        this.nXa = 0;
        this.nXj = new Object();
        this.nXk = false;
        this.mRequestRender = false;
        this.nXn = 0;
        this.nXo = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nWT != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nXn > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nWT.resume();
                    } else {
                        DanmakuView.this.nWT.postDelayed(this, DanmakuView.this.nXn * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nXl = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.az(true, false);
        this.nWX = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nWV = true;
        this.nWZ = true;
        this.nXa = 0;
        this.nXj = new Object();
        this.nXk = false;
        this.mRequestRender = false;
        this.nXn = 0;
        this.nXo = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nWT != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nXn > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nWT.resume();
                    } else {
                        DanmakuView.this.nWT.postDelayed(this, DanmakuView.this.nXn * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nWV = true;
        this.nWZ = true;
        this.nXa = 0;
        this.nXj = new Object();
        this.nXk = false;
        this.mRequestRender = false;
        this.nXn = 0;
        this.nXo = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nWT != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nXn > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nWT.resume();
                    } else {
                        DanmakuView.this.nWT.postDelayed(this, DanmakuView.this.nXn * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nWT != null) {
            return this.nWT.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nSa = aVar;
        if (this.nWT != null) {
            this.nWT.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.nWT == null) {
            return null;
        }
        return this.nWT.getConfig();
    }

    private float dTh() {
        long dTf = master.flame.danmaku.danmaku.c.c.dTf();
        this.nSi.addLast(Long.valueOf(dTf));
        Long peekFirst = this.nSi.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dTf - peekFirst.longValue());
        if (this.nSi.size() > 50) {
            this.nSi.removeFirst();
        }
        return longValue > 0.0f ? (this.nSi.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dRP() {
        if (!this.nWU) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dTf = master.flame.danmaku.danmaku.c.c.dTf();
        dTk();
        return master.flame.danmaku.danmaku.c.c.dTf() - dTf;
    }

    @SuppressLint({"NewApi"})
    private void dTj() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dTk() {
        if (this.nWZ) {
            dTj();
            synchronized (this.nXj) {
                while (!this.nXk && this.nWT != null) {
                    try {
                        this.nXj.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nWZ || this.nWT == null || this.nWT.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nXk = false;
            }
        }
    }

    private void dTl() {
        this.nXm = true;
        dTk();
    }

    private void dTm() {
        synchronized (this.nXj) {
            this.nXk = true;
            this.nXj.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nWZ && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nXm) {
            d.e(canvas);
            this.nXm = false;
        } else if (this.nWT != null) {
            a.b al = this.nWT.al(canvas);
            if (this.nWY) {
                if (this.nSi == null) {
                    this.nSi = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dTh()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.nWk), Long.valueOf(al.nWl)));
            }
        }
        this.mRequestRender = false;
        dTm();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nWT != null) {
            this.nWT.ea(i3 - i, i4 - i2);
        }
        this.nWU = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nWX.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRQ() {
        return this.nWV;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dRO() {
        return this.nWU;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dRO()) {
            if (!this.nWZ || Thread.currentThread().getId() == this.nXl) {
                this.nXm = true;
                dTj();
                return;
            }
            dTl();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nWZ && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nXa = i;
    }

    public long getCurrentTime() {
        if (this.nWT != null) {
            return this.nWT.getCurrentTime();
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
        this.nWW = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nWW;
    }
}
