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
    private Runnable nBA;
    private c nBf;
    private boolean nBg;
    private boolean nBh;
    private f.a nBi;
    private a nBj;
    private boolean nBk;
    private boolean nBl;
    protected int nBm;
    private Object nBv;
    private boolean nBw;
    private long nBx;
    private boolean nBy;
    private int nBz;
    private c.a nwl;
    private LinkedList<Long> nwt;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nBz;
        danmakuView.nBz = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nBh = true;
        this.nBl = true;
        this.nBm = 0;
        this.nBv = new Object();
        this.nBw = false;
        this.mRequestRender = false;
        this.nBz = 0;
        this.nBA = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nBf != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nBz > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nBf.resume();
                    } else {
                        DanmakuView.this.nBf.postDelayed(this, DanmakuView.this.nBz * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nBx = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.ay(true, false);
        this.nBj = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nBh = true;
        this.nBl = true;
        this.nBm = 0;
        this.nBv = new Object();
        this.nBw = false;
        this.mRequestRender = false;
        this.nBz = 0;
        this.nBA = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nBf != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nBz > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nBf.resume();
                    } else {
                        DanmakuView.this.nBf.postDelayed(this, DanmakuView.this.nBz * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nBh = true;
        this.nBl = true;
        this.nBm = 0;
        this.nBv = new Object();
        this.nBw = false;
        this.mRequestRender = false;
        this.nBz = 0;
        this.nBA = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nBf != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nBz > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nBf.resume();
                    } else {
                        DanmakuView.this.nBf.postDelayed(this, DanmakuView.this.nBz * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nBf != null) {
            return this.nBf.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nwl = aVar;
        if (this.nBf != null) {
            this.nBf.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.nBf == null) {
            return null;
        }
        return this.nBf.getConfig();
    }

    private float dOx() {
        long dOv = master.flame.danmaku.danmaku.c.c.dOv();
        this.nwt.addLast(Long.valueOf(dOv));
        Long peekFirst = this.nwt.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dOv - peekFirst.longValue());
        if (this.nwt.size() > 50) {
            this.nwt.removeFirst();
        }
        return longValue > 0.0f ? (this.nwt.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dNf() {
        if (!this.nBg) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dOv = master.flame.danmaku.danmaku.c.c.dOv();
        dOA();
        return master.flame.danmaku.danmaku.c.c.dOv() - dOv;
    }

    @SuppressLint({"NewApi"})
    private void dOz() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dOA() {
        if (this.nBl) {
            dOz();
            synchronized (this.nBv) {
                while (!this.nBw && this.nBf != null) {
                    try {
                        this.nBv.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nBl || this.nBf == null || this.nBf.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nBw = false;
            }
        }
    }

    private void dOB() {
        this.nBy = true;
        dOA();
    }

    private void dOC() {
        synchronized (this.nBv) {
            this.nBw = true;
            this.nBv.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nBl && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nBy) {
            d.e(canvas);
            this.nBy = false;
        } else if (this.nBf != null) {
            a.b ag = this.nBf.ag(canvas);
            if (this.nBk) {
                if (this.nwt == null) {
                    this.nwt = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dOx()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ag.nAw), Long.valueOf(ag.nAx)));
            }
        }
        this.mRequestRender = false;
        dOC();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nBf != null) {
            this.nBf.dR(i3 - i, i4 - i2);
        }
        this.nBg = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nBj.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dNg() {
        return this.nBh;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dNe() {
        return this.nBg;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dNe()) {
            if (!this.nBl || Thread.currentThread().getId() == this.nBx) {
                this.nBy = true;
                dOz();
                return;
            }
            dOB();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nBl && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nBm = i;
    }

    public long getCurrentTime() {
        if (this.nBf != null) {
            return this.nBf.getCurrentTime();
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
        this.nBi = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nBi;
    }
}
