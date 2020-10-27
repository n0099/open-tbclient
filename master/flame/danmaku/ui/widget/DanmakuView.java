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
    private LinkedList<Long> pLB;
    private c.a pLt;
    private long pQA;
    private boolean pQB;
    private int pQC;
    private Runnable pQD;
    private c pQj;
    private boolean pQk;
    private boolean pQl;
    private f.a pQm;
    private a pQn;
    private boolean pQo;
    private boolean pQp;
    protected int pQq;
    private Object pQy;
    private boolean pQz;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.pQC;
        danmakuView.pQC = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.pQl = true;
        this.pQp = true;
        this.pQq = 0;
        this.pQy = new Object();
        this.pQz = false;
        this.mRequestRender = false;
        this.pQC = 0;
        this.pQD = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.pQj != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.pQC > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.pQj.resume();
                    } else {
                        DanmakuView.this.pQj.postDelayed(this, DanmakuView.this.pQC * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.pQA = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aN(true, false);
        this.pQn = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pQl = true;
        this.pQp = true;
        this.pQq = 0;
        this.pQy = new Object();
        this.pQz = false;
        this.mRequestRender = false;
        this.pQC = 0;
        this.pQD = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.pQj != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.pQC > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.pQj.resume();
                    } else {
                        DanmakuView.this.pQj.postDelayed(this, DanmakuView.this.pQC * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pQl = true;
        this.pQp = true;
        this.pQq = 0;
        this.pQy = new Object();
        this.pQz = false;
        this.mRequestRender = false;
        this.pQC = 0;
        this.pQD = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.pQj != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.pQC > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.pQj.resume();
                    } else {
                        DanmakuView.this.pQj.postDelayed(this, DanmakuView.this.pQC * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.pQj != null) {
            return this.pQj.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.pLt = aVar;
        if (this.pQj != null) {
            this.pQj.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.pQj == null) {
            return null;
        }
        return this.pQj.getConfig();
    }

    private float eAy() {
        long eAw = master.flame.danmaku.danmaku.c.c.eAw();
        this.pLB.addLast(Long.valueOf(eAw));
        Long peekFirst = this.pLB.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eAw - peekFirst.longValue());
        if (this.pLB.size() > 50) {
            this.pLB.removeFirst();
        }
        return longValue > 0.0f ? (this.pLB.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long ezf() {
        if (!this.pQk) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eAw = master.flame.danmaku.danmaku.c.c.eAw();
        eAB();
        return master.flame.danmaku.danmaku.c.c.eAw() - eAw;
    }

    @SuppressLint({"NewApi"})
    private void eAA() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void eAB() {
        if (this.pQp) {
            eAA();
            synchronized (this.pQy) {
                while (!this.pQz && this.pQj != null) {
                    try {
                        this.pQy.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.pQp || this.pQj == null || this.pQj.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.pQz = false;
            }
        }
    }

    private void eAC() {
        this.pQB = true;
        eAB();
    }

    private void eAD() {
        synchronized (this.pQy) {
            this.pQz = true;
            this.pQy.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.pQp && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.pQB) {
            d.e(canvas);
            this.pQB = false;
        } else if (this.pQj != null) {
            a.b au = this.pQj.au(canvas);
            if (this.pQo) {
                if (this.pLB == null) {
                    this.pLB = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eAy()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(au.pPA), Long.valueOf(au.pPB)));
            }
        }
        this.mRequestRender = false;
        eAD();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.pQj != null) {
            this.pQj.ew(i3 - i, i4 - i2);
        }
        this.pQk = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.pQn.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ezg() {
        return this.pQl;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eze() {
        return this.pQk;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (eze()) {
            if (!this.pQp || Thread.currentThread().getId() == this.pQA) {
                this.pQB = true;
                eAA();
                return;
            }
            eAC();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.pQp && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.pQq = i;
    }

    public long getCurrentTime() {
        if (this.pQj != null) {
            return this.pQj.getCurrentTime();
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
        this.pQm = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.pQm;
    }
}
