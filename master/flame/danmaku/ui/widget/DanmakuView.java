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
    private c.a mZY;
    private LinkedList<Long> nag;
    private c neU;
    private boolean neV;
    private boolean neW;
    private f.a neX;
    private a neY;
    private boolean neZ;
    private boolean nfa;
    protected int nfb;
    private Object nfk;
    private boolean nfl;
    private long nfm;
    private boolean nfn;
    private int nfo;
    private Runnable nfp;

    static /* synthetic */ int b(DanmakuView danmakuView) {
        int i = danmakuView.nfo;
        danmakuView.nfo = i + 1;
        return i;
    }

    public DanmakuView(Context context) {
        super(context);
        this.neW = true;
        this.nfa = true;
        this.nfb = 0;
        this.nfk = new Object();
        this.nfl = false;
        this.mRequestRender = false;
        this.nfo = 0;
        this.nfp = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.neU != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nfo > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.neU.resume();
                    } else {
                        DanmakuView.this.neU.postDelayed(this, DanmakuView.this.nfo * 100);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.nfm = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.av(true, false);
        this.neY = a.b(this);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.neW = true;
        this.nfa = true;
        this.nfb = 0;
        this.nfk = new Object();
        this.nfl = false;
        this.mRequestRender = false;
        this.nfo = 0;
        this.nfp = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.neU != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nfo > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.neU.resume();
                    } else {
                        DanmakuView.this.neU.postDelayed(this, DanmakuView.this.nfo * 100);
                    }
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.neW = true;
        this.nfa = true;
        this.nfb = 0;
        this.nfk = new Object();
        this.nfl = false;
        this.mRequestRender = false;
        this.nfo = 0;
        this.nfp = new Runnable() { // from class: master.flame.danmaku.ui.widget.DanmakuView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.neU != null) {
                    DanmakuView.b(DanmakuView.this);
                    if (DanmakuView.this.nfo > 4 || DanmakuView.super.isShown()) {
                        DanmakuView.this.neU.resume();
                    } else {
                        DanmakuView.this.neU.postDelayed(this, DanmakuView.this.nfo * 100);
                    }
                }
            }
        };
        init();
    }

    @Override // master.flame.danmaku.a.f
    public l getCurrentVisibleDanmakus() {
        if (this.neU != null) {
            return this.neU.getCurrentVisibleDanmakus();
        }
        return null;
    }

    public void setCallback(c.a aVar) {
        this.mZY = aVar;
        if (this.neU != null) {
            this.neU.setCallback(aVar);
        }
    }

    public DanmakuContext getConfig() {
        if (this.neU == null) {
            return null;
        }
        return this.neU.getConfig();
    }

    private float dGo() {
        long dGm = master.flame.danmaku.danmaku.c.c.dGm();
        this.nag.addLast(Long.valueOf(dGm));
        Long peekFirst = this.nag.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (dGm - peekFirst.longValue());
        if (this.nag.size() > 50) {
            this.nag.removeFirst();
        }
        return longValue > 0.0f ? (this.nag.size() * 1000) / longValue : 0.0f;
    }

    @Override // master.flame.danmaku.a.g
    public long dEW() {
        if (!this.neV) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long dGm = master.flame.danmaku.danmaku.c.c.dGm();
        dGr();
        return master.flame.danmaku.danmaku.c.c.dGm() - dGm;
    }

    @SuppressLint({"NewApi"})
    private void dGq() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void dGr() {
        if (this.nfa) {
            dGq();
            synchronized (this.nfk) {
                while (!this.nfl && this.neU != null) {
                    try {
                        this.nfk.wait(200L);
                    } catch (InterruptedException e) {
                        if (!this.nfa || this.neU == null || this.neU.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.nfl = false;
            }
        }
    }

    private void dGs() {
        this.nfn = true;
        dGr();
    }

    private void dGt() {
        synchronized (this.nfk) {
            this.nfl = true;
            this.nfk.notifyAll();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.nfa && !this.mRequestRender) {
            super.onDraw(canvas);
            return;
        }
        if (this.nfn) {
            d.e(canvas);
            this.nfn = false;
        } else if (this.neU != null) {
            a.b ae = this.neU.ae(canvas);
            if (this.neZ) {
                if (this.nag == null) {
                    this.nag = new LinkedList<>();
                }
                d.c(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(dGo()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(ae.nek), Long.valueOf(ae.nel)));
            }
        }
        this.mRequestRender = false;
        dGt();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.neU != null) {
            this.neU.dM(i3 - i, i4 - i2);
        }
        this.neV = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.neY.onTouchEvent(motionEvent);
        if (!onTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dEX() {
        return this.neW;
    }

    @Override // master.flame.danmaku.a.g
    public boolean dEV() {
        return this.neV;
    }

    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.a.g
    public void clear() {
        if (dEV()) {
            if (!this.nfa || Thread.currentThread().getId() == this.nfm) {
                this.nfn = true;
                dGq();
                return;
            }
            dGs();
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.nfa && super.isShown();
    }

    public void setDrawingThreadType(int i) {
        this.nfb = i;
    }

    public long getCurrentTime() {
        if (this.neU != null) {
            return this.neU.getCurrentTime();
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
        this.neX = aVar;
    }

    @Override // master.flame.danmaku.a.f
    public f.a getOnDanmakuClickListener() {
        return this.neX;
    }
}
