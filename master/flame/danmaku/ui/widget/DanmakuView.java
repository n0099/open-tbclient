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
    private LinkedList<Long> nGD;
    private c.a nGv;
    private Object nLD;
    private boolean nLE;
    private long nLF;
    private boolean nLG;
    private int nLH;
    private Runnable nLI;
    private c nLn;
    private boolean nLo;
    private boolean nLp;
    private f.a nLq;
    private a nLr;
    private boolean nLs;
    private boolean nLt;
    protected int nLu;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nLH;
        danmakuView.nLH = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nLp = true;
        this.nLt = true;
        this.nLu = 0;
        this.nLD = new Object();
        this.nLE = false;
        this.mRequestRender = false;
        this.nLH = 0;
        this.nLI = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nLn != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nLH > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nLn.resume();
                    } else {
                        DanmakuView.this.nLn.postDelayed(this, DanmakuView.this.nLH * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nLF = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aA(true, false);
        this.nLr = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nLp = true;
        this.nLt = true;
        this.nLu = 0;
        this.nLD = new Object();
        this.nLE = false;
        this.mRequestRender = false;
        this.nLH = 0;
        this.nLI = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nLn != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nLH > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nLn.resume();
                    } else {
                        DanmakuView.this.nLn.postDelayed(this, DanmakuView.this.nLH * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nLp = true;
        this.nLt = true;
        this.nLu = 0;
        this.nLD = new Object();
        this.nLE = false;
        this.mRequestRender = false;
        this.nLH = 0;
        this.nLI = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nLn != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nLH > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nLn.resume();
                    } else {
                        DanmakuView.this.nLn.postDelayed(this, DanmakuView.this.nLH * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nLn != null) {
            return this.nLn.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nGv = aVar;
        if (this.nLn != null) {
            this.nLn.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.nLn == null) {
            return null;
        }
        return this.nLn.getConfig();
    }

    private float dNs() {
        long dNq = master.flame.danmaku.danmaku.c.c.dNq();
        this.nGD.addLast(Long.valueOf(dNq));
        Long peekFirst = this.nGD.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dNq - peekFirst.longValue());
        if (this.nGD.size() > 50) {
            this.nGD.removeFirst();
        }
        return longValue > 0.0f ? (this.nGD.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dMa() {
        if (!this.nLo) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dNq = master.flame.danmaku.danmaku.c.c.dNq();
        dNv();
        return master.flame.danmaku.danmaku.c.c.dNq() - dNq;
    }

    @SuppressLint({"NewApi"})
    private void dNu() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dNv() {
        if (this.nLt) {
            dNu();
            synchronized (this.nLD) {
                while (!this.nLE && this.nLn != null) {
                    try {
                        this.nLD.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nLt || this.nLn == null || this.nLn.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nLE = false;
            }
        }
    }

    private void dNw() {
        this.nLG = true;
        dNv();
    }

    private void dNx() {
        synchronized (this.nLD) {
            this.nLE = true;
            this.nLD.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nLt && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nLG) {
            d.e(canvas);
            this.nLG = false;
        } else if (this.nLn != null) {
            a.b al = this.nLn.al(canvas);
            if (this.nLs) {
                if (this.nGD == null) {
                    this.nGD = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dNs()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(al.nKE), Long.valueOf(al.nKF)));
            }
        }
        this.mRequestRender = false;
        dNx();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nLn != null) {
            this.nLn.eB(i3 - i, i4 - i2);
        }
        this.nLo = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nLr.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dMb() {
        return this.nLp;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dLZ() {
        return this.nLo;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dLZ()) {
            if (!this.nLt || Thread.currentThread().getId() == this.nLF) {
                this.nLG = true;
                dNu();
                return;
            }
            dNw();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nLt && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nLu = i;
    }

    public long getCurrentTime() {
        if (this.nLn != null) {
            return this.nLn.getCurrentTime();
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
        this.nLq = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nLq;
    }
}
