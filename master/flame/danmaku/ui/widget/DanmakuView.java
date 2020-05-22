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
    private boolean nAa;
    private boolean nAb;
    protected int nAc;
    private Object nAl;
    private boolean nAm;
    private long nAn;
    private boolean nAo;
    private int nAp;
    private Runnable nAq;
    private c.a nvb;
    private LinkedList<Long> nvj;
    private c nzV;
    private boolean nzW;
    private boolean nzX;
    private f.a nzY;
    private a nzZ;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nAp;
        danmakuView.nAp = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nzX = true;
        this.nAb = true;
        this.nAc = 0;
        this.nAl = new Object();
        this.nAm = false;
        this.mRequestRender = false;
        this.nAp = 0;
        this.nAq = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nzV != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nAp > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nzV.resume();
                    } else {
                        DanmakuView.this.nzV.postDelayed(this, DanmakuView.this.nAp * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nAn = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.ay(true, false);
        this.nzZ = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nzX = true;
        this.nAb = true;
        this.nAc = 0;
        this.nAl = new Object();
        this.nAm = false;
        this.mRequestRender = false;
        this.nAp = 0;
        this.nAq = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nzV != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nAp > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nzV.resume();
                    } else {
                        DanmakuView.this.nzV.postDelayed(this, DanmakuView.this.nAp * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nzX = true;
        this.nAb = true;
        this.nAc = 0;
        this.nAl = new Object();
        this.nAm = false;
        this.mRequestRender = false;
        this.nAp = 0;
        this.nAq = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nzV != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nAp > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nzV.resume();
                    } else {
                        DanmakuView.this.nzV.postDelayed(this, DanmakuView.this.nAp * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nzV != null) {
            return this.nzV.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nvb = aVar;
        if (this.nzV != null) {
            this.nzV.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.nzV == null) {
            return null;
        }
        return this.nzV.getConfig();
    }

    private float dOj() {
        long dOh = master.flame.danmaku.danmaku.c.c.dOh();
        this.nvj.addLast(Long.valueOf(dOh));
        Long peekFirst = this.nvj.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dOh - peekFirst.longValue());
        if (this.nvj.size() > 50) {
            this.nvj.removeFirst();
        }
        return longValue > 0.0f ? (this.nvj.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dMR() {
        if (!this.nzW) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dOh = master.flame.danmaku.danmaku.c.c.dOh();
        dOm();
        return master.flame.danmaku.danmaku.c.c.dOh() - dOh;
    }

    @SuppressLint({"NewApi"})
    private void dOl() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dOm() {
        if (this.nAb) {
            dOl();
            synchronized (this.nAl) {
                while (!this.nAm && this.nzV != null) {
                    try {
                        this.nAl.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nAb || this.nzV == null || this.nzV.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nAm = false;
            }
        }
    }

    private void dOn() {
        this.nAo = true;
        dOm();
    }

    private void dOo() {
        synchronized (this.nAl) {
            this.nAm = true;
            this.nAl.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nAb && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nAo) {
            d.e(canvas);
            this.nAo = false;
        } else if (this.nzV != null) {
            a.b ag = this.nzV.ag(canvas);
            if (this.nAa) {
                if (this.nvj == null) {
                    this.nvj = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dOj()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ag.nzm), Long.valueOf(ag.nzn)));
            }
        }
        this.mRequestRender = false;
        dOo();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nzV != null) {
            this.nzV.dR(i3 - i, i4 - i2);
        }
        this.nzW = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nzZ.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dMS() {
        return this.nzX;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dMQ() {
        return this.nzW;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dMQ()) {
            if (!this.nAb || Thread.currentThread().getId() == this.nAn) {
                this.nAo = true;
                dOl();
                return;
            }
            dOn();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nAb && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nAc = i;
    }

    public long getCurrentTime() {
        if (this.nzV != null) {
            return this.nzV.getCurrentTime();
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
        this.nzY = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nzY;
    }
}
