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
    private c.a pUN;
    private LinkedList<Long> pUV;
    private c pZD;
    private boolean pZE;
    private boolean pZF;
    private f.a pZG;
    private a pZH;
    private boolean pZI;
    private boolean pZJ;
    protected int pZK;
    private Object pZS;
    private boolean pZT;
    private long pZU;
    private boolean pZV;
    private int pZW;
    private Runnable pZX;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.pZW;
        danmakuView.pZW = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.pZF = true;
        this.pZJ = true;
        this.pZK = 0;
        this.pZS = new Object();
        this.pZT = false;
        this.mRequestRender = false;
        this.pZW = 0;
        this.pZX = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.pZD != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.pZW > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.pZD.resume();
                    } else {
                        DanmakuView.this.pZD.postDelayed(this, DanmakuView.this.pZW * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.pZU = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aN(true, false);
        this.pZH = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pZF = true;
        this.pZJ = true;
        this.pZK = 0;
        this.pZS = new Object();
        this.pZT = false;
        this.mRequestRender = false;
        this.pZW = 0;
        this.pZX = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.pZD != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.pZW > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.pZD.resume();
                    } else {
                        DanmakuView.this.pZD.postDelayed(this, DanmakuView.this.pZW * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pZF = true;
        this.pZJ = true;
        this.pZK = 0;
        this.pZS = new Object();
        this.pZT = false;
        this.mRequestRender = false;
        this.pZW = 0;
        this.pZX = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.pZD != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.pZW > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.pZD.resume();
                    } else {
                        DanmakuView.this.pZD.postDelayed(this, DanmakuView.this.pZW * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.pZD != null) {
            return this.pZD.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.pUN = aVar;
        if (this.pZD != null) {
            this.pZD.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.pZD == null) {
            return null;
        }
        return this.pZD.getConfig();
    }

    private float eEn() {
        long eEl = master.flame.danmaku.danmaku.c.c.eEl();
        this.pUV.addLast(Long.valueOf(eEl));
        Long peekFirst = this.pUV.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eEl - peekFirst.longValue());
        if (this.pUV.size() > 50) {
            this.pUV.removeFirst();
        }
        return longValue > 0.0f ? (this.pUV.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long eCU() {
        if (!this.pZE) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eEl = master.flame.danmaku.danmaku.c.c.eEl();
        eEq();
        return master.flame.danmaku.danmaku.c.c.eEl() - eEl;
    }

    @SuppressLint({"NewApi"})
    private void eEp() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void eEq() {
        if (this.pZJ) {
            eEp();
            synchronized (this.pZS) {
                while (!this.pZT && this.pZD != null) {
                    try {
                        this.pZS.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.pZJ || this.pZD == null || this.pZD.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.pZT = false;
            }
        }
    }

    private void eEr() {
        this.pZV = true;
        eEq();
    }

    private void eEs() {
        synchronized (this.pZS) {
            this.pZT = true;
            this.pZS.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.pZJ && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.pZV) {
            d.e(canvas);
            this.pZV = false;
        } else if (this.pZD != null) {
            a.b au = this.pZD.au(canvas);
            if (this.pZI) {
                if (this.pUV == null) {
                    this.pUV = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eEn()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(au.pYU), Long.valueOf(au.pYV)));
            }
        }
        this.mRequestRender = false;
        eEs();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.pZD != null) {
            this.pZD.ez(i3 - i, i4 - i2);
        }
        this.pZE = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.pZH.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCV() {
        return this.pZF;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCT() {
        return this.pZE;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (eCT()) {
            if (!this.pZJ || Thread.currentThread().getId() == this.pZU) {
                this.pZV = true;
                eEp();
                return;
            }
            eEr();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.pZJ && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.pZK = i;
    }

    public long getCurrentTime() {
        if (this.pZD != null) {
            return this.pZD.getCurrentTime();
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
        this.pZG = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.pZG;
    }
}
