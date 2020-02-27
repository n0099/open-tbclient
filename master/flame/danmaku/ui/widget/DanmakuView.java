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
    private LinkedList<Long> nED;
    private c.a nEv;
    private Object nJD;
    private boolean nJE;
    private long nJF;
    private boolean nJG;
    private int nJH;
    private Runnable nJI;
    private c nJn;
    private boolean nJo;
    private boolean nJp;
    private f.a nJq;
    private a nJr;
    private boolean nJs;
    private boolean nJt;
    protected int nJu;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nJH;
        danmakuView.nJH = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nJp = true;
        this.nJt = true;
        this.nJu = 0;
        this.nJD = new Object();
        this.nJE = false;
        this.mRequestRender = false;
        this.nJH = 0;
        this.nJI = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nJn != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nJH > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nJn.resume();
                    } else {
                        DanmakuView.this.nJn.postDelayed(this, DanmakuView.this.nJH * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nJF = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aA(true, false);
        this.nJr = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJp = true;
        this.nJt = true;
        this.nJu = 0;
        this.nJD = new Object();
        this.nJE = false;
        this.mRequestRender = false;
        this.nJH = 0;
        this.nJI = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nJn != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nJH > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nJn.resume();
                    } else {
                        DanmakuView.this.nJn.postDelayed(this, DanmakuView.this.nJH * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJp = true;
        this.nJt = true;
        this.nJu = 0;
        this.nJD = new Object();
        this.nJE = false;
        this.mRequestRender = false;
        this.nJH = 0;
        this.nJI = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nJn != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nJH > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nJn.resume();
                    } else {
                        DanmakuView.this.nJn.postDelayed(this, DanmakuView.this.nJH * 100);
                    }
                }
            }
        };
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
    public long dLx() {
        if (!this.nJo) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dMN = master.flame.danmaku.danmaku.c.c.dMN();
        dMS();
        return master.flame.danmaku.danmaku.c.c.dMN() - dMN;
    }

    @SuppressLint({"NewApi"})
    private void dMR() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dMS() {
        if (this.nJt) {
            dMR();
            synchronized (this.nJD) {
                while (!this.nJE && this.nJn != null) {
                    try {
                        this.nJD.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nJt || this.nJn == null || this.nJn.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nJE = false;
            }
        }
    }

    private void dMT() {
        this.nJG = true;
        dMS();
    }

    private void dMU() {
        synchronized (this.nJD) {
            this.nJE = true;
            this.nJD.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nJt && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nJG) {
            d.e(canvas);
            this.nJG = false;
        } else if (this.nJn != null) {
            a.b ak = this.nJn.ak(canvas);
            if (this.nJs) {
                if (this.nED == null) {
                    this.nED = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dMP()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nIE), Long.valueOf(ak.nIF)));
            }
        }
        this.mRequestRender = false;
        dMU();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nJn != null) {
            this.nJn.eA(i3 - i, i4 - i2);
        }
        this.nJo = true;
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

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dLw()) {
            if (!this.nJt || Thread.currentThread().getId() == this.nJF) {
                this.nJG = true;
                dMR();
                return;
            }
            dMT();
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
    @SuppressLint({"NewApi"})
    public boolean isHardwareAccelerated() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.isHardwareAccelerated();
        }
        return false;
    }

    public void setOnDanmakuClickListener(f.a aVar) {
        this.nJq = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nJq;
    }
}
