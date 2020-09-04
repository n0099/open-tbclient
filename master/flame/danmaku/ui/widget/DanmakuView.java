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
    private boolean oAa;
    protected int oAb;
    private Object oAk;
    private boolean oAl;
    private long oAm;
    private boolean oAn;
    private int oAo;
    private Runnable oAp;
    private c.a ovc;
    private LinkedList<Long> ovk;
    private c ozU;
    private boolean ozV;
    private boolean ozW;
    private f.a ozX;
    private a ozY;
    private boolean ozZ;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.oAo;
        danmakuView.oAo = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.ozW = true;
        this.oAa = true;
        this.oAb = 0;
        this.oAk = new Object();
        this.oAl = false;
        this.mRequestRender = false;
        this.oAo = 0;
        this.oAp = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ozU != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oAo > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ozU.resume();
                    } else {
                        DanmakuView.this.ozU.postDelayed(this, DanmakuView.this.oAo * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.oAm = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aG(true, false);
        this.ozY = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ozW = true;
        this.oAa = true;
        this.oAb = 0;
        this.oAk = new Object();
        this.oAl = false;
        this.mRequestRender = false;
        this.oAo = 0;
        this.oAp = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ozU != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oAo > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ozU.resume();
                    } else {
                        DanmakuView.this.ozU.postDelayed(this, DanmakuView.this.oAo * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ozW = true;
        this.oAa = true;
        this.oAb = 0;
        this.oAk = new Object();
        this.oAl = false;
        this.mRequestRender = false;
        this.oAo = 0;
        this.oAp = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ozU != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.oAo > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ozU.resume();
                    } else {
                        DanmakuView.this.ozU.postDelayed(this, DanmakuView.this.oAo * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ozU != null) {
            return this.ozU.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.ovc = aVar;
        if (this.ozU != null) {
            this.ozU.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.ozU == null) {
            return null;
        }
        return this.ozU.getConfig();
    }

    private float eiQ() {
        long eiO = master.flame.danmaku.danmaku.c.c.eiO();
        this.ovk.addLast(Long.valueOf(eiO));
        Long peekFirst = this.ovk.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eiO - peekFirst.longValue());
        if (this.ovk.size() > 50) {
            this.ovk.removeFirst();
        }
        return longValue > 0.0f ? (this.ovk.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long ehx() {
        if (!this.ozV) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eiO = master.flame.danmaku.danmaku.c.c.eiO();
        eiT();
        return master.flame.danmaku.danmaku.c.c.eiO() - eiO;
    }

    @SuppressLint({"NewApi"})
    private void eiS() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void eiT() {
        if (this.oAa) {
            eiS();
            synchronized (this.oAk) {
                while (!this.oAl && this.ozU != null) {
                    try {
                        this.oAk.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.oAa || this.ozU == null || this.ozU.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.oAl = false;
            }
        }
    }

    private void eiU() {
        this.oAn = true;
        eiT();
    }

    private void eiV() {
        synchronized (this.oAk) {
            this.oAl = true;
            this.oAk.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.oAa && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.oAn) {
            d.e(canvas);
            this.oAn = false;
        } else if (this.ozU != null) {
            a.b ar = this.ozU.ar(canvas);
            if (this.ozZ) {
                if (this.ovk == null) {
                    this.ovk = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eiQ()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ar.ozl), Long.valueOf(ar.ozm)));
            }
        }
        this.mRequestRender = false;
        eiV();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.ozU != null) {
            this.ozU.ek(i3 - i, i4 - i2);
        }
        this.ozV = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ozY.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehy() {
        return this.ozW;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehw() {
        return this.ozV;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (ehw()) {
            if (!this.oAa || Thread.currentThread().getId() == this.oAm) {
                this.oAn = true;
                eiS();
                return;
            }
            eiU();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.oAa && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.oAb = i;
    }

    public long getCurrentTime() {
        if (this.ozU != null) {
            return this.ozU.getCurrentTime();
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
        this.ozX = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ozX;
    }
}
