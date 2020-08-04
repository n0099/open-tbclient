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
    private c.a oaL;
    private LinkedList<Long> oaT;
    private c ofG;
    private boolean ofH;
    private boolean ofI;
    private f.a ofJ;
    private a ofK;
    private boolean ofL;
    private boolean ofM;
    protected int ofN;
    private Object ofW;
    private boolean ofX;
    private long ofY;
    private boolean ofZ;
    private int oga;
    private Runnable ogb;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.oga;
        danmakuView.oga = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.ofI = true;
        this.ofM = true;
        this.ofN = 0;
        this.ofW = new Object();
        this.ofX = false;
        this.mRequestRender = false;
        this.oga = 0;
        this.ogb = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ofG != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oga > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ofG.resume();
                    } else {
                        DanmakuView.this.ofG.postDelayed(this, DanmakuView.this.oga * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.ofY = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aA(true, false);
        this.ofK = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ofI = true;
        this.ofM = true;
        this.ofN = 0;
        this.ofW = new Object();
        this.ofX = false;
        this.mRequestRender = false;
        this.oga = 0;
        this.ogb = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ofG != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oga > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ofG.resume();
                    } else {
                        DanmakuView.this.ofG.postDelayed(this, DanmakuView.this.oga * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ofI = true;
        this.ofM = true;
        this.ofN = 0;
        this.ofW = new Object();
        this.ofX = false;
        this.mRequestRender = false;
        this.oga = 0;
        this.ogb = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ofG != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oga > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ofG.resume();
                    } else {
                        DanmakuView.this.ofG.postDelayed(this, DanmakuView.this.oga * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ofG != null) {
            return this.ofG.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oaL = aVar;
        if (this.ofG != null) {
            this.ofG.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.ofG == null) {
            return null;
        }
        return this.ofG.getConfig();
    }

    private float dWE() {
        long dWC = master.flame.danmaku.danmaku.c.c.dWC();
        this.oaT.addLast(Long.valueOf(dWC));
        Long peekFirst = this.oaT.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dWC - peekFirst.longValue());
        if (this.oaT.size() > 50) {
            this.oaT.removeFirst();
        }
        return longValue > 0.0f ? (this.oaT.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dVm() {
        if (!this.ofH) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dWC = master.flame.danmaku.danmaku.c.c.dWC();
        dWH();
        return master.flame.danmaku.danmaku.c.c.dWC() - dWC;
    }

    @SuppressLint({"NewApi"})
    private void dWG() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dWH() {
        if (this.ofM) {
            dWG();
            synchronized (this.ofW) {
                while (!this.ofX && this.ofG != null) {
                    try {
                        this.ofW.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.ofM || this.ofG == null || this.ofG.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.ofX = false;
            }
        }
    }

    private void dWI() {
        this.ofZ = true;
        dWH();
    }

    private void dWJ() {
        synchronized (this.ofW) {
            this.ofX = true;
            this.ofW.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.ofM && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.ofZ) {
            d.e(canvas);
            this.ofZ = false;
        } else if (this.ofG != null) {
            a.b al = this.ofG.al(canvas);
            if (this.ofL) {
                if (this.oaT == null) {
                    this.oaT = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dWE()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.oeW), Long.valueOf(al.oeX)));
            }
        }
        this.mRequestRender = false;
        dWJ();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.ofG != null) {
            this.ofG.ec(i3 - i, i4 - i2);
        }
        this.ofH = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ofK.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVn() {
        return this.ofI;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dVl() {
        return this.ofH;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dVl()) {
            if (!this.ofM || Thread.currentThread().getId() == this.ofY) {
                this.ofZ = true;
                dWG();
                return;
            }
            dWI();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.ofM && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.ofN = i;
    }

    public long getCurrentTime() {
        if (this.ofG != null) {
            return this.ofG.getCurrentTime();
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
        this.ofJ = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ofJ;
    }
}
