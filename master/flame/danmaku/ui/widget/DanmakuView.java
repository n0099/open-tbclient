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
    private Object nXg;
    private boolean nXh;
    private long nXi;
    private boolean nXj;
    private int nXk;
    private Runnable nXl;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nXk;
        danmakuView.nXk = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nWS = true;
        this.nWW = true;
        this.nWX = 0;
        this.nXg = new Object();
        this.nXh = false;
        this.mRequestRender = false;
        this.nXk = 0;
        this.nXl = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nWQ != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nXk > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nWQ.resume();
                    } else {
                        DanmakuView.this.nWQ.postDelayed(this, DanmakuView.this.nXk * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nXi = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.az(true, false);
        this.nWU = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nWS = true;
        this.nWW = true;
        this.nWX = 0;
        this.nXg = new Object();
        this.nXh = false;
        this.mRequestRender = false;
        this.nXk = 0;
        this.nXl = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nWQ != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nXk > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nWQ.resume();
                    } else {
                        DanmakuView.this.nWQ.postDelayed(this, DanmakuView.this.nXk * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nWS = true;
        this.nWW = true;
        this.nWX = 0;
        this.nXg = new Object();
        this.nXh = false;
        this.mRequestRender = false;
        this.nXk = 0;
        this.nXl = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nWQ != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nXk > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nWQ.resume();
                    } else {
                        DanmakuView.this.nWQ.postDelayed(this, DanmakuView.this.nXk * 100);
                    }
                }
            }
        };
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
    public long dRL() {
        if (!this.nWR) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dTb = master.flame.danmaku.danmaku.c.c.dTb();
        dTg();
        return master.flame.danmaku.danmaku.c.c.dTb() - dTb;
    }

    @SuppressLint({"NewApi"})
    private void dTf() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dTg() {
        if (this.nWW) {
            dTf();
            synchronized (this.nXg) {
                while (!this.nXh && this.nWQ != null) {
                    try {
                        this.nXg.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nWW || this.nWQ == null || this.nWQ.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nXh = false;
            }
        }
    }

    private void dTh() {
        this.nXj = true;
        dTg();
    }

    private void dTi() {
        synchronized (this.nXg) {
            this.nXh = true;
            this.nXg.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nWW && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nXj) {
            d.e(canvas);
            this.nXj = false;
        } else if (this.nWQ != null) {
            a.b al = this.nWQ.al(canvas);
            if (this.nWV) {
                if (this.nSf == null) {
                    this.nSf = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dTd()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.nWh), Long.valueOf(al.nWi)));
            }
        }
        this.mRequestRender = false;
        dTi();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nWQ != null) {
            this.nWQ.ea(i3 - i, i4 - i2);
        }
        this.nWR = true;
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

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dRK()) {
            if (!this.nWW || Thread.currentThread().getId() == this.nXi) {
                this.nXj = true;
                dTf();
                return;
            }
            dTh();
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
    @SuppressLint({"NewApi"})
    public boolean isHardwareAccelerated() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.isHardwareAccelerated();
        }
        return false;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nWT = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nWT;
    }
}
