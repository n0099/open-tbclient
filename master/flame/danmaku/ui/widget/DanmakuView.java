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
/* loaded from: classes4.dex */
public class DanmakuView extends View implements f, g {
    private boolean aUl;
    private c.a nDD;
    private LinkedList<Long> nDL;
    private f.a nIA;
    private a nIB;
    private boolean nIC;
    private boolean nID;
    protected int nIE;
    private Object nIN;
    private boolean nIO;
    private long nIP;
    private boolean nIQ;
    private int nIR;
    private Runnable nIS;
    private c nIx;
    private boolean nIy;
    private boolean nIz;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nIR;
        danmakuView.nIR = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nIz = true;
        this.nID = true;
        this.nIE = 0;
        this.nIN = new Object();
        this.nIO = false;
        this.aUl = false;
        this.nIR = 0;
        this.nIS = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nIx != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nIR > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nIx.resume();
                    } else {
                        DanmakuView.this.nIx.postDelayed(this, DanmakuView.this.nIR * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nIP = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.ay(true, false);
        this.nIB = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIz = true;
        this.nID = true;
        this.nIE = 0;
        this.nIN = new Object();
        this.nIO = false;
        this.aUl = false;
        this.nIR = 0;
        this.nIS = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nIx != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nIR > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nIx.resume();
                    } else {
                        DanmakuView.this.nIx.postDelayed(this, DanmakuView.this.nIR * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIz = true;
        this.nID = true;
        this.nIE = 0;
        this.nIN = new Object();
        this.nIO = false;
        this.aUl = false;
        this.nIR = 0;
        this.nIS = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nIx != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nIR > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nIx.resume();
                    } else {
                        DanmakuView.this.nIx.postDelayed(this, DanmakuView.this.nIR * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nIx != null) {
            return this.nIx.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nDD = aVar;
        if (this.nIx != null) {
            this.nIx.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.nIx == null) {
            return null;
        }
        return this.nIx.getConfig();
    }

    private float dLC() {
        long dLA = master.flame.danmaku.danmaku.c.c.dLA();
        this.nDL.addLast(Long.valueOf(dLA));
        Long peekFirst = this.nDL.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dLA - peekFirst.longValue());
        if (this.nDL.size() > 50) {
            this.nDL.removeFirst();
        }
        return longValue > 0.0f ? (this.nDL.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dKk() {
        if (!this.nIy) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dLA = master.flame.danmaku.danmaku.c.c.dLA();
        dLF();
        return master.flame.danmaku.danmaku.c.c.dLA() - dLA;
    }

    @SuppressLint({"NewApi"})
    private void dLE() {
        this.aUl = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dLF() {
        if (this.nID) {
            dLE();
            synchronized (this.nIN) {
                while (!this.nIO && this.nIx != null) {
                    try {
                        this.nIN.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nID || this.nIx == null || this.nIx.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nIO = false;
            }
        }
    }

    private void dLG() {
        this.nIQ = true;
        dLF();
    }

    private void dLH() {
        synchronized (this.nIN) {
            this.nIO = true;
            this.nIN.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nID && !this.aUl) {
            super.onDraw(canvas);
            return;
        }
        if (this.nIQ) {
            d.e(canvas);
            this.nIQ = false;
        } else if (this.nIx != null) {
            a.b ak = this.nIx.ak(canvas);
            if (this.nIC) {
                if (this.nDL == null) {
                    this.nDL = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dLC()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nHO), Long.valueOf(ak.nHP)));
            }
        }
        this.aUl = false;
        dLH();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nIx != null) {
            this.nIx.ex(i3 - i, i4 - i2);
        }
        this.nIy = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nIB.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKl() {
        return this.nIz;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKj() {
        return this.nIy;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dKj()) {
            if (!this.nID || Thread.currentThread().getId() == this.nIP) {
                this.nIQ = true;
                dLE();
                return;
            }
            dLG();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nID && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nIE = i;
    }

    public long getCurrentTime() {
        if (this.nIx != null) {
            return this.nIx.getCurrentTime();
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
        this.nIA = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nIA;
    }
}
