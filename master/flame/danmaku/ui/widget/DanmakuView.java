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
    private c.a nEI;
    private LinkedList<Long> nEQ;
    private c nJA;
    private boolean nJB;
    private boolean nJC;
    private f.a nJD;
    private a nJE;
    private boolean nJF;
    private boolean nJG;
    protected int nJH;
    private Object nJQ;
    private boolean nJR;
    private long nJS;
    private boolean nJT;
    private int nJU;
    private Runnable nJV;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nJU;
        danmakuView.nJU = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nJC = true;
        this.nJG = true;
        this.nJH = 0;
        this.nJQ = new Object();
        this.nJR = false;
        this.mRequestRender = false;
        this.nJU = 0;
        this.nJV = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nJA != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nJU > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nJA.resume();
                    } else {
                        DanmakuView.this.nJA.postDelayed(this, DanmakuView.this.nJU * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nJS = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aA(true, false);
        this.nJE = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJC = true;
        this.nJG = true;
        this.nJH = 0;
        this.nJQ = new Object();
        this.nJR = false;
        this.mRequestRender = false;
        this.nJU = 0;
        this.nJV = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nJA != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nJU > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nJA.resume();
                    } else {
                        DanmakuView.this.nJA.postDelayed(this, DanmakuView.this.nJU * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJC = true;
        this.nJG = true;
        this.nJH = 0;
        this.nJQ = new Object();
        this.nJR = false;
        this.mRequestRender = false;
        this.nJU = 0;
        this.nJV = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nJA != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nJU > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nJA.resume();
                    } else {
                        DanmakuView.this.nJA.postDelayed(this, DanmakuView.this.nJU * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nJA != null) {
            return this.nJA.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nEI = aVar;
        if (this.nJA != null) {
            this.nJA.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.nJA == null) {
            return null;
        }
        return this.nJA.getConfig();
    }

    private float dMS() {
        long dMQ = master.flame.danmaku.danmaku.c.c.dMQ();
        this.nEQ.addLast(Long.valueOf(dMQ));
        Long peekFirst = this.nEQ.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dMQ - peekFirst.longValue());
        if (this.nEQ.size() > 50) {
            this.nEQ.removeFirst();
        }
        return longValue > 0.0f ? (this.nEQ.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dLA() {
        if (!this.nJB) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dMQ = master.flame.danmaku.danmaku.c.c.dMQ();
        dMV();
        return master.flame.danmaku.danmaku.c.c.dMQ() - dMQ;
    }

    @SuppressLint({"NewApi"})
    private void dMU() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dMV() {
        if (this.nJG) {
            dMU();
            synchronized (this.nJQ) {
                while (!this.nJR && this.nJA != null) {
                    try {
                        this.nJQ.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nJG || this.nJA == null || this.nJA.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nJR = false;
            }
        }
    }

    private void dMW() {
        this.nJT = true;
        dMV();
    }

    private void dMX() {
        synchronized (this.nJQ) {
            this.nJR = true;
            this.nJQ.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nJG && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nJT) {
            d.e(canvas);
            this.nJT = false;
        } else if (this.nJA != null) {
            a.b ak = this.nJA.ak(canvas);
            if (this.nJF) {
                if (this.nEQ == null) {
                    this.nEQ = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dMS()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nIR), Long.valueOf(ak.nIS)));
            }
        }
        this.mRequestRender = false;
        dMX();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nJA != null) {
            this.nJA.eA(i3 - i, i4 - i2);
        }
        this.nJB = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nJE.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLB() {
        return this.nJC;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLz() {
        return this.nJB;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dLz()) {
            if (!this.nJG || Thread.currentThread().getId() == this.nJS) {
                this.nJT = true;
                dMU();
                return;
            }
            dMW();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nJG && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nJH = i;
    }

    public long getCurrentTime() {
        if (this.nJA != null) {
            return this.nJA.getCurrentTime();
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
        this.nJD = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nJD;
    }
}
