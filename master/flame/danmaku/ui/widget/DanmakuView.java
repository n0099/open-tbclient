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
    private LinkedList<Long> nDG;
    private c.a nDy;
    private Object nII;
    private boolean nIJ;
    private long nIK;
    private boolean nIL;
    private int nIM;
    private Runnable nIN;
    private c nIs;
    private boolean nIt;
    private boolean nIu;
    private f.a nIv;
    private a nIw;
    private boolean nIx;
    private boolean nIy;
    protected int nIz;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nIM;
        danmakuView.nIM = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.nIu = true;
        this.nIy = true;
        this.nIz = 0;
        this.nII = new Object();
        this.nIJ = false;
        this.aUl = false;
        this.nIM = 0;
        this.nIN = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nIs != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nIM > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nIs.resume();
                    } else {
                        DanmakuView.this.nIs.postDelayed(this, DanmakuView.this.nIM * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nIK = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.ay(true, false);
        this.nIw = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIu = true;
        this.nIy = true;
        this.nIz = 0;
        this.nII = new Object();
        this.nIJ = false;
        this.aUl = false;
        this.nIM = 0;
        this.nIN = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nIs != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nIM > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nIs.resume();
                    } else {
                        DanmakuView.this.nIs.postDelayed(this, DanmakuView.this.nIM * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIu = true;
        this.nIy = true;
        this.nIz = 0;
        this.nII = new Object();
        this.nIJ = false;
        this.aUl = false;
        this.nIM = 0;
        this.nIN = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.nIs != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nIM > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.nIs.resume();
                    } else {
                        DanmakuView.this.nIs.postDelayed(this, DanmakuView.this.nIM * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.nIs != null) {
            return this.nIs.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.nDy = aVar;
        if (this.nIs != null) {
            this.nIs.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.nIs == null) {
            return null;
        }
        return this.nIs.getConfig();
    }

    private float dLA() {
        long dLy = master.flame.danmaku.danmaku.c.c.dLy();
        this.nDG.addLast(Long.valueOf(dLy));
        Long peekFirst = this.nDG.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dLy - peekFirst.longValue());
        if (this.nDG.size() > 50) {
            this.nDG.removeFirst();
        }
        return longValue > 0.0f ? (this.nDG.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dKi() {
        if (!this.nIt) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dLy = master.flame.danmaku.danmaku.c.c.dLy();
        dLD();
        return master.flame.danmaku.danmaku.c.c.dLy() - dLy;
    }

    @SuppressLint({"NewApi"})
    private void dLC() {
        this.aUl = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dLD() {
        if (this.nIy) {
            dLC();
            synchronized (this.nII) {
                while (!this.nIJ && this.nIs != null) {
                    try {
                        this.nII.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nIy || this.nIs == null || this.nIs.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nIJ = false;
            }
        }
    }

    private void dLE() {
        this.nIL = true;
        dLD();
    }

    private void dLF() {
        synchronized (this.nII) {
            this.nIJ = true;
            this.nII.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nIy && !this.aUl) {
            super.onDraw(canvas);
            return;
        }
        if (this.nIL) {
            d.e(canvas);
            this.nIL = false;
        } else if (this.nIs != null) {
            a.b ak = this.nIs.ak(canvas);
            if (this.nIx) {
                if (this.nDG == null) {
                    this.nDG = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dLA()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ak.nHJ), Long.valueOf(ak.nHK)));
            }
        }
        this.aUl = false;
        dLF();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nIs != null) {
            this.nIs.ex(i3 - i, i4 - i2);
        }
        this.nIt = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nIw.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKj() {
        return this.nIu;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dKh() {
        return this.nIt;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dKh()) {
            if (!this.nIy || Thread.currentThread().getId() == this.nIK) {
                this.nIL = true;
                dLC();
                return;
            }
            dLE();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nIy && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nIz = i;
    }

    public long getCurrentTime() {
        if (this.nIs != null) {
            return this.nIs.getCurrentTime();
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
        this.nIv = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.nIv;
    }
}
