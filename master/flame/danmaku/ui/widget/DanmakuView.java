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
    private c.a pWq;
    private LinkedList<Long> pWy;
    private Runnable qbA;
    private c qbg;
    private boolean qbh;
    private boolean qbi;
    private f.a qbj;
    private a qbk;
    private boolean qbl;
    private boolean qbm;
    protected int qbn;
    private Object qbv;
    private boolean qbw;
    private long qbx;
    private boolean qby;
    private int qbz;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.qbz;
        danmakuView.qbz = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.qbi = true;
        this.qbm = true;
        this.qbn = 0;
        this.qbv = new Object();
        this.qbw = false;
        this.mRequestRender = false;
        this.qbz = 0;
        this.qbA = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.qbg != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.qbz > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.qbg.resume();
                    } else {
                        DanmakuView.this.qbg.postDelayed(this, DanmakuView.this.qbz * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.qbx = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aL(true, false);
        this.qbk = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qbi = true;
        this.qbm = true;
        this.qbn = 0;
        this.qbv = new Object();
        this.qbw = false;
        this.mRequestRender = false;
        this.qbz = 0;
        this.qbA = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.qbg != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.qbz > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.qbg.resume();
                    } else {
                        DanmakuView.this.qbg.postDelayed(this, DanmakuView.this.qbz * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qbi = true;
        this.qbm = true;
        this.qbn = 0;
        this.qbv = new Object();
        this.qbw = false;
        this.mRequestRender = false;
        this.qbz = 0;
        this.qbA = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.qbg != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.qbz > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.qbg.resume();
                    } else {
                        DanmakuView.this.qbg.postDelayed(this, DanmakuView.this.qbz * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.qbg != null) {
            return this.qbg.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.pWq = aVar;
        if (this.qbg != null) {
            this.qbg.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.qbg == null) {
            return null;
        }
        return this.qbg.getConfig();
    }

    private float eEo() {
        long eEm = master.flame.danmaku.danmaku.c.c.eEm();
        this.pWy.addLast(Long.valueOf(eEm));
        Long peekFirst = this.pWy.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eEm - peekFirst.longValue());
        if (this.pWy.size() > 50) {
            this.pWy.removeFirst();
        }
        return longValue > 0.0f ? (this.pWy.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long eCV() {
        if (!this.qbh) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eEm = master.flame.danmaku.danmaku.c.c.eEm();
        eEr();
        return master.flame.danmaku.danmaku.c.c.eEm() - eEm;
    }

    @SuppressLint({"NewApi"})
    private void eEq() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void eEr() {
        if (this.qbm) {
            eEq();
            synchronized (this.qbv) {
                while (!this.qbw && this.qbg != null) {
                    try {
                        this.qbv.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.qbm || this.qbg == null || this.qbg.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.qbw = false;
            }
        }
    }

    private void eEs() {
        this.qby = true;
        eEr();
    }

    private void eEt() {
        synchronized (this.qbv) {
            this.qbw = true;
            this.qbv.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.qbm && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.qby) {
            d.e(canvas);
            this.qby = false;
        } else if (this.qbg != null) {
            a.b av = this.qbg.av(canvas);
            if (this.qbl) {
                if (this.pWy == null) {
                    this.pWy = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eEo()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(av.qax), Long.valueOf(av.qay)));
            }
        }
        this.mRequestRender = false;
        eEt();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.qbg != null) {
            this.qbg.eA(i3 - i, i4 - i2);
        }
        this.qbh = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.qbk.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCW() {
        return this.qbi;
    }

    @Override // master.flame.danmaku.a.g
    public boolean eCU() {
        return this.qbh;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (eCU()) {
            if (!this.qbm || Thread.currentThread().getId() == this.qbx) {
                this.qby = true;
                eEq();
                return;
            }
            eEs();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.qbm && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.qbn = i;
    }

    public long getCurrentTime() {
        if (this.qbg != null) {
            return this.qbg.getCurrentTime();
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
        this.qbj = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.qbj;
    }
}
