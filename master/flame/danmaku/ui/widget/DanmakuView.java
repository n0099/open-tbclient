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
    private c.a oTX;
    private LinkedList<Long> oUf;
    private c oYN;
    private boolean oYO;
    private boolean oYP;
    private f.a oYQ;
    private a oYR;
    private boolean oYS;
    private boolean oYT;
    protected int oYU;
    private Object oZd;
    private boolean oZe;
    private long oZf;
    private boolean oZg;
    private int oZh;
    private Runnable oZi;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.oZh;
        danmakuView.oZh = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.oYP = true;
        this.oYT = true;
        this.oYU = 0;
        this.oZd = new Object();
        this.oZe = false;
        this.mRequestRender = false;
        this.oZh = 0;
        this.oZi = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.oYN != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oZh > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.oYN.resume();
                    } else {
                        DanmakuView.this.oYN.postDelayed(this, DanmakuView.this.oZh * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.oZf = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aH(true, false);
        this.oYR = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oYP = true;
        this.oYT = true;
        this.oYU = 0;
        this.oZd = new Object();
        this.oZe = false;
        this.mRequestRender = false;
        this.oZh = 0;
        this.oZi = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.oYN != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oZh > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.oYN.resume();
                    } else {
                        DanmakuView.this.oYN.postDelayed(this, DanmakuView.this.oZh * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oYP = true;
        this.oYT = true;
        this.oYU = 0;
        this.oZd = new Object();
        this.oZe = false;
        this.mRequestRender = false;
        this.oZh = 0;
        this.oZi = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.oYN != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oZh > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.oYN.resume();
                    } else {
                        DanmakuView.this.oYN.postDelayed(this, DanmakuView.this.oZh * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.oYN != null) {
            return this.oYN.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.oTX = aVar;
        if (this.oYN != null) {
            this.oYN.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.oYN == null) {
            return null;
        }
        return this.oYN.getConfig();
    }

    private float eqA() {
        long eqy = master.flame.danmaku.danmaku.c.c.eqy();
        this.oUf.addLast(Long.valueOf(eqy));
        Long peekFirst = this.oUf.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eqy - peekFirst.longValue());
        if (this.oUf.size() > 50) {
            this.oUf.removeFirst();
        }
        return longValue > 0.0f ? (this.oUf.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long eph() {
        if (!this.oYO) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eqy = master.flame.danmaku.danmaku.c.c.eqy();
        eqD();
        return master.flame.danmaku.danmaku.c.c.eqy() - eqy;
    }

    @SuppressLint({"NewApi"})
    private void eqC() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void eqD() {
        if (this.oYT) {
            eqC();
            synchronized (this.oZd) {
                while (!this.oZe && this.oYN != null) {
                    try {
                        this.oZd.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.oYT || this.oYN == null || this.oYN.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.oZe = false;
            }
        }
    }

    private void eqE() {
        this.oZg = true;
        eqD();
    }

    private void eqF() {
        synchronized (this.oZd) {
            this.oZe = true;
            this.oZd.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.oYT && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.oZg) {
            d.e(canvas);
            this.oZg = false;
        } else if (this.oYN != null) {
            a.b as = this.oYN.as(canvas);
            if (this.oYS) {
                if (this.oUf == null) {
                    this.oUf = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eqA()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(as.oYe), Long.valueOf(as.oYf)));
            }
        }
        this.mRequestRender = false;
        eqF();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.oYN != null) {
            this.oYN.eo(i3 - i, i4 - i2);
        }
        this.oYO = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.oYR.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean epi() {
        return this.oYP;
    }

    @Override // master.flame.danmaku.a.g
    public boolean epg() {
        return this.oYO;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (epg()) {
            if (!this.oYT || Thread.currentThread().getId() == this.oZf) {
                this.oZg = true;
                eqC();
                return;
            }
            eqE();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.oYT && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.oYU = i;
    }

    public long getCurrentTime() {
        if (this.oYN != null) {
            return this.oYN.getCurrentTime();
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
        this.oYQ = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.oYQ;
    }
}
