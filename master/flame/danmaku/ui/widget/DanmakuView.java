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
    private c.a ouK;
    private LinkedList<Long> ouS;
    private c ozC;
    private boolean ozD;
    private boolean ozE;
    private f.a ozF;
    private a ozG;
    private boolean ozH;
    private boolean ozI;
    protected int ozJ;
    private Object ozS;
    private boolean ozT;
    private long ozU;
    private boolean ozV;
    private int ozW;
    private Runnable ozX;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.ozW;
        danmakuView.ozW = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.ozE = true;
        this.ozI = true;
        this.ozJ = 0;
        this.ozS = new Object();
        this.ozT = false;
        this.mRequestRender = false;
        this.ozW = 0;
        this.ozX = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ozC != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.ozW > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ozC.resume();
                    } else {
                        DanmakuView.this.ozC.postDelayed(this, DanmakuView.this.ozW * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.ozU = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.aG(true, false);
        this.ozG = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ozE = true;
        this.ozI = true;
        this.ozJ = 0;
        this.ozS = new Object();
        this.ozT = false;
        this.mRequestRender = false;
        this.ozW = 0;
        this.ozX = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ozC != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.ozW > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ozC.resume();
                    } else {
                        DanmakuView.this.ozC.postDelayed(this, DanmakuView.this.ozW * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ozE = true;
        this.ozI = true;
        this.ozJ = 0;
        this.ozS = new Object();
        this.ozT = false;
        this.mRequestRender = false;
        this.ozW = 0;
        this.ozX = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.ozC != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.ozW > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.ozC.resume();
                    } else {
                        DanmakuView.this.ozC.postDelayed(this, DanmakuView.this.ozW * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.ozC != null) {
            return this.ozC.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.ouK = aVar;
        if (this.ozC != null) {
            this.ozC.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.ozC == null) {
            return null;
        }
        return this.ozC.getConfig();
    }

    private float eiH() {
        long eiF = master.flame.danmaku.danmaku.c.c.eiF();
        this.ouS.addLast(Long.valueOf(eiF));
        Long peekFirst = this.ouS.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (eiF - peekFirst.longValue());
        if (this.ouS.size() > 50) {
            this.ouS.removeFirst();
        }
        return longValue > 0.0f ? (this.ouS.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long eho() {
        if (!this.ozD) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long eiF = master.flame.danmaku.danmaku.c.c.eiF();
        eiK();
        return master.flame.danmaku.danmaku.c.c.eiF() - eiF;
    }

    @SuppressLint({"NewApi"})
    private void eiJ() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void eiK() {
        if (this.ozI) {
            eiJ();
            synchronized (this.ozS) {
                while (!this.ozT && this.ozC != null) {
                    try {
                        this.ozS.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.ozI || this.ozC == null || this.ozC.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.ozT = false;
            }
        }
    }

    private void eiL() {
        this.ozV = true;
        eiK();
    }

    private void eiM() {
        synchronized (this.ozS) {
            this.ozT = true;
            this.ozS.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.ozI && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.ozV) {
            d.e(canvas);
            this.ozV = false;
        } else if (this.ozC != null) {
            a.b ar = this.ozC.ar(canvas);
            if (this.ozH) {
                if (this.ouS == null) {
                    this.ouS = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(eiH()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ar.oyT), Long.valueOf(ar.oyU)));
            }
        }
        this.mRequestRender = false;
        eiM();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.ozC != null) {
            this.ozC.ek(i3 - i, i4 - i2);
        }
        this.ozD = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ozG.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehp() {
        return this.ozE;
    }

    @Override // master.flame.danmaku.a.g
    public boolean ehn() {
        return this.ozD;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (ehn()) {
            if (!this.ozI || Thread.currentThread().getId() == this.ozU) {
                this.ozV = true;
                eiJ();
                return;
            }
            eiL();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.ozI && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.ozJ = i;
    }

    public long getCurrentTime() {
        if (this.ozC != null) {
            return this.ozC.getCurrentTime();
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
        this.ozF = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.ozF;
    }
}
