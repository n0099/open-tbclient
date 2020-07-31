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
    private c.a oaJ;
    private LinkedList<Long> oaR;
    private c ofE;
    private boolean ofF;
    private boolean ofG;
    private f.a ofH;
    private a ofI;
    private boolean ofJ;
    private boolean ofK;
    protected int ofL;
    private Object ofU;
    private boolean ofV;
    private long ofW;
    private boolean ofX;
    private int ofY;
    private Runnable ofZ;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.ofY;
        danmakuView.ofY = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.ofG = true;
        this.ofK = true;
        this.ofL = 0;
        this.ofU = new Object();
        this.ofV = false;
        this.mRequestRender = false;
        this.ofY = 0;
        this.ofZ = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ofE != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.ofY > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ofE.resume();
                    } else {
                        DanmakuView.this.ofE.postDelayed(this, DanmakuView.this.ofY * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.ofW = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aA(true, false);
        this.ofI = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ofG = true;
        this.ofK = true;
        this.ofL = 0;
        this.ofU = new Object();
        this.ofV = false;
        this.mRequestRender = false;
        this.ofY = 0;
        this.ofZ = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ofE != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.ofY > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ofE.resume();
                    } else {
                        DanmakuView.this.ofE.postDelayed(this, DanmakuView.this.ofY * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ofG = true;
        this.ofK = true;
        this.ofL = 0;
        this.ofU = new Object();
        this.ofV = false;
        this.mRequestRender = false;
        this.ofY = 0;
        this.ofZ = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ofE != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.ofY > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ofE.resume();
                    } else {
                        DanmakuView.this.ofE.postDelayed(this, DanmakuView.this.ofY * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ofE != null) {
            return this.ofE.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oaJ = aVar;
        if (this.ofE != null) {
            this.ofE.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.ofE == null) {
            return null;
        }
        return this.ofE.getConfig();
    }

    private float dWD() {
        long dWB = master.flame.danmaku.danmaku.c.c.dWB();
        this.oaR.addLast(Long.valueOf(dWB));
        Long peekFirst = this.oaR.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dWB - peekFirst.longValue());
        if (this.oaR.size() > 50) {
            this.oaR.removeFirst();
        }
        return longValue > 0.0f ? (this.oaR.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dVl() {
        if (!this.ofF) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dWB = master.flame.danmaku.danmaku.c.c.dWB();
        dWG();
        return master.flame.danmaku.danmaku.c.c.dWB() - dWB;
    }

    @SuppressLint({"NewApi"})
    private void dWF() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dWG() {
        if (this.ofK) {
            dWF();
            synchronized (this.ofU) {
                while (!this.ofV && this.ofE != null) {
                    try {
                        this.ofU.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.ofK || this.ofE == null || this.ofE.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.ofV = false;
            }
        }
    }

    private void dWH() {
        this.ofX = true;
        dWG();
    }

    private void dWI() {
        synchronized (this.ofU) {
            this.ofV = true;
            this.ofU.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.ofK && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.ofX) {
            d.e(canvas);
            this.ofX = false;
        } else if (this.ofE != null) {
            a.b al = this.ofE.al(canvas);
            if (this.ofJ) {
                if (this.oaR == null) {
                    this.oaR = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dWD()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.oeU), Long.valueOf(al.oeV)));
            }
        }
        this.mRequestRender = false;
        dWI();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.ofE != null) {
            this.ofE.ec(i3 - i, i4 - i2);
        }
        this.ofF = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ofI.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVm() {
        return this.ofG;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVk() {
        return this.ofF;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dVk()) {
            if (!this.ofK || Thread.currentThread().getId() == this.ofW) {
                this.ofX = true;
                dWF();
                return;
            }
            dWH();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.ofK && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.ofL = i;
    }

    public long getCurrentTime() {
        if (this.ofE != null) {
            return this.ofE.getCurrentTime();
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
        this.ofH = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ofH;
    }
}
