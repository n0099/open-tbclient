package com.kascend.chushou.player.ui.pk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class HorizontalMarqueeView extends HorizontalScrollView {
    protected Context a;
    protected int b;
    protected LinearLayout c;
    protected int d;
    protected Scroller e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected boolean m;
    protected ArrayList<Integer> mBF;
    protected ArrayList<Integer> mpe;
    protected boolean n;
    protected int o;
    protected int p;
    protected ArrayList<View> q;
    protected ArrayList<Integer> r;

    public HorizontalMarqueeView(Context context) {
        this(context, null);
    }

    public HorizontalMarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalMarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 2;
        this.g = 0;
        this.h = 0;
        this.k = 3000;
        this.l = 3000;
        this.m = false;
        this.n = false;
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.mpe = new ArrayList<>();
        this.mBF = new ArrayList<>();
        this.a = context;
        h();
    }

    private void h() {
        this.c = getContentLayout();
        this.c.setVisibility(4);
        addView(this.c);
        this.e = new Scroller(getContext(), new LinearInterpolator());
    }

    protected LinearLayout getContentLayout() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        return linearLayout;
    }

    public void m(View view, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, 0, i2, 0);
        view.setLayoutParams(layoutParams);
        this.c.addView(view);
        this.q.add(view);
        view.measure(0, 0);
        this.r.add(Integer.valueOf(view.getMeasuredWidth()));
        this.mpe.add(Integer.valueOf(i));
        this.mBF.add(Integer.valueOf(i2));
    }

    public void a() {
        this.c.removeAllViews();
        this.q.clear();
        this.r.clear();
        this.mpe.clear();
        this.mBF.clear();
    }

    public void setScrollDirection(int i) {
        this.f = i;
    }

    public void setDuration(int i) {
        this.k = i;
    }

    public void a(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.c.measure(0, 0);
        this.d = this.c.getMeasuredWidth();
    }

    protected void c() {
        if (this.f == 1) {
            this.g = this.d;
            this.h = 0;
            this.i = -this.b;
            this.j = 0;
            this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
            return;
        }
        this.g = -this.b;
        this.h = 0;
        this.i = this.d;
        this.j = 0;
        this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
    }

    public void d() {
        b();
        c();
        this.m = false;
        this.c.scrollTo(this.g, this.h);
        this.c.setVisibility(0);
        this.e.startScroll(this.g, this.h, this.i - this.g, this.j - this.h, this.l);
        invalidate();
    }

    protected void e() {
        if (this.n) {
            this.g = this.o;
            this.h = this.p;
            this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
        } else if (this.f == 1) {
            this.g = this.d;
            this.h = 0;
            this.i = -this.b;
            this.j = 0;
            this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
        } else {
            this.g = -this.b;
            this.h = 0;
            this.i = this.d;
            this.j = 0;
            this.l = (int) ((this.k * Math.abs(this.i - this.g)) / this.b);
        }
    }

    public void f() {
        if (!this.m) {
            e();
            this.n = false;
            this.c.scrollTo(this.g, this.h);
            this.e.startScroll(this.g, this.h, this.i - this.g, this.j - this.h, this.l);
            invalidate();
        }
    }

    public void g() {
        this.m = true;
        this.n = false;
        if (this.e.computeScrollOffset()) {
            this.e.abortAnimation();
        }
    }

    public int getParentWidth() {
        measure(0, 0);
        return getMeasuredWidth();
    }

    public int getContentWidth() {
        this.c.measure(0, 0);
        return this.c.getMeasuredWidth();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (!this.n && !this.m) {
            if (this.e.computeScrollOffset()) {
                this.c.scrollTo(this.e.getCurrX(), this.e.getCurrY());
                invalidate();
                return;
            }
            f();
        }
    }
}
