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
/* loaded from: classes6.dex */
public class DanmakuView extends View implements f, g {
    private boolean mRequestRender;
    private c.a oEI;
    private LinkedList<Long> oEQ;
    private boolean oJA;
    private boolean oJB;
    private f.a oJC;
    private a oJD;
    private boolean oJE;
    private boolean oJF;
    protected int oJG;
    private Object oJP;
    private boolean oJQ;
    private long oJR;
    private boolean oJS;
    private int oJT;
    private Runnable oJU;
    private c oJz;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.oJT;
        danmakuView.oJT = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.oJB = true;
        this.oJF = true;
        this.oJG = 0;
        this.oJP = new Object();
        this.oJQ = false;
        this.mRequestRender = false;
        this.oJT = 0;
        this.oJU = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.oJz != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oJT > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.oJz.resume();
                    } else {
                        DanmakuView.this.oJz.postDelayed(this, DanmakuView.this.oJT * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.oJR = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aI(true, false);
        this.oJD = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oJB = true;
        this.oJF = true;
        this.oJG = 0;
        this.oJP = new Object();
        this.oJQ = false;
        this.mRequestRender = false;
        this.oJT = 0;
        this.oJU = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.oJz != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oJT > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.oJz.resume();
                    } else {
                        DanmakuView.this.oJz.postDelayed(this, DanmakuView.this.oJT * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oJB = true;
        this.oJF = true;
        this.oJG = 0;
        this.oJP = new Object();
        this.oJQ = false;
        this.mRequestRender = false;
        this.oJT = 0;
        this.oJU = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.oJz != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oJT > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.oJz.resume();
                    } else {
                        DanmakuView.this.oJz.postDelayed(this, DanmakuView.this.oJT * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.oJz != null) {
            return this.oJz.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oEI = aVar;
        if (this.oJz != null) {
            this.oJz.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.oJz == null) {
            return null;
        }
        return this.oJz.getConfig();
    }

    private float emN() {
        long emL = master.flame.danmaku.danmaku.c.c.emL();
        this.oEQ.addLast(Long.valueOf(emL));
        Long peekFirst = this.oEQ.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (emL - peekFirst.longValue());
        if (this.oEQ.size() > 50) {
            this.oEQ.removeFirst();
        }
        return longValue > 0.0f ? (this.oEQ.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long elu() {
        if (!this.oJA) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long emL = master.flame.danmaku.danmaku.c.c.emL();
        emQ();
        return master.flame.danmaku.danmaku.c.c.emL() - emL;
    }

    @SuppressLint({"NewApi"})
    private void emP() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void emQ() {
        if (this.oJF) {
            emP();
            synchronized (this.oJP) {
                while (!this.oJQ && this.oJz != null) {
                    try {
                        this.oJP.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.oJF || this.oJz == null || this.oJz.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.oJQ = false;
            }
        }
    }

    private void emR() {
        this.oJS = true;
        emQ();
    }

    private void emS() {
        synchronized (this.oJP) {
            this.oJQ = true;
            this.oJP.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.oJF && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.oJS) {
            d.e(canvas);
            this.oJS = false;
        } else if (this.oJz != null) {
            a.b ar = this.oJz.ar(canvas);
            if (this.oJE) {
                if (this.oEQ == null) {
                    this.oEQ = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(emN()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ar.oIQ), Long.valueOf(ar.oIR)));
            }
        }
        this.mRequestRender = false;
        emS();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.oJz != null) {
            this.oJz.eo(i3 - i, i4 - i2);
        }
        this.oJA = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.oJD.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean elv() {
        return this.oJB;
    }

    @Override // master.flame.danmaku.a.g
    public boolean elt() {
        return this.oJA;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (elt()) {
            if (!this.oJF || Thread.currentThread().getId() == this.oJR) {
                this.oJS = true;
                emP();
                return;
            }
            emR();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.oJF && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.oJG = i;
    }

    public long getCurrentTime() {
        if (this.oJz != null) {
            return this.oJz.getCurrentTime();
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
        this.oJC = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.oJC;
    }
}
