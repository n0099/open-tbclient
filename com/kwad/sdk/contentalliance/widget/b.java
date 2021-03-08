package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.TranslateAnimation;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class b extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f5999a;
    private Rect b;
    private boolean c;
    private float d;
    private a e;
    private float f;
    private boolean g;
    private float h;
    private float i;
    private float j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, float f);

        void a(int i, int i2, int i3, int i4);

        void a(boolean z, int i, float f);
    }

    public b(Context context) {
        super(context);
        this.f5999a = 0;
        this.b = new Rect();
        this.c = true;
        this.d = 0.0f;
        this.g = false;
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void a() {
        if (!this.b.isEmpty()) {
            b();
        }
        this.d = -1.0f;
    }

    private void a(float f) {
        if (this.b.isEmpty()) {
            this.b.set(getLeft(), getTop(), getRight(), getBottom());
        }
        this.c = false;
        layout(getLeft() + ((int) (f * 0.5f)), getTop(), getRight() + ((int) (f * 0.5f)), getBottom());
    }

    private void b() {
        TranslateAnimation translateAnimation = new TranslateAnimation(getLeft(), this.b.left, 0.0f, 0.0f);
        translateAnimation.setDuration(200L);
        startAnimation(translateAnimation);
        layout(this.b.left, this.b.top, this.b.right, this.b.bottom);
        this.b.setEmpty();
        this.c = true;
        if (this.e != null) {
            this.e.a(this.f5999a, this.b.left - getLeft());
        }
    }

    private int getSideEdgeType() {
        if (getScrollX() >= this.f) {
            return 2;
        }
        return this.f5999a == 0 ? 1 : 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.h = motionEvent.getRawX();
                this.i = motionEvent.getRawY();
                this.g = false;
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 2:
                if (!this.g) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f = rawX - this.h;
                    float f2 = rawY - this.i;
                    if (Math.abs(f) > this.j && Math.abs(f) > Math.abs(f2)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        this.g = true;
                        break;
                    } else if (Math.abs(f2) - Math.abs(f) > this.j) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        this.g = true;
                        break;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f5999a = getCurrentItem();
            float f = 0.0f;
            if (getAdapter() != null) {
                for (int i = 0; i < getAdapter().getCount(); i++) {
                    f += getAdapter().getPageWidth(i);
                }
            }
            this.f = (f - 1.0f) * getMeasuredWidth();
            if (this.f5999a == 0 || getScrollX() >= this.f) {
                this.d = motionEvent.getX();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.e == null || i == this.b.left) {
            return;
        }
        this.e.a(getCurrentItem() == 0, this.f5999a, this.b.left - getLeft());
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.e != null) {
            this.e.a(i, i2, i3, i4);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 1:
                a();
                break;
            case 2:
                int sideEdgeType = getSideEdgeType();
                if (sideEdgeType > 0 && this.d < 0.0f) {
                    this.d = motionEvent.getX(0);
                }
                if (getAdapter().getCount() == 1) {
                    float x = motionEvent.getX(0);
                    float f = x - this.d;
                    this.d = x;
                    if (f > 10.0f) {
                        a(f);
                    } else if (f < -10.0f) {
                        a(f);
                    } else if (!this.c && getLeft() + ((int) (f * 0.5f)) != this.b.left) {
                        layout(getLeft() + ((int) (f * 0.5f)), getTop(), ((int) (f * 0.5f)) + getRight(), getBottom());
                    }
                } else if (sideEdgeType > 0) {
                    float x2 = motionEvent.getX(0);
                    float f2 = x2 - this.d;
                    this.d = x2;
                    if (sideEdgeType == 1) {
                        if (f2 > 10.0f) {
                            a(f2);
                        } else if (!this.c && getLeft() + ((int) (f2 * 0.5f)) >= this.b.left) {
                            layout(getLeft() + ((int) (f2 * 0.5f)), getTop(), ((int) (f2 * 0.5f)) + getRight(), getBottom());
                        }
                    } else if (f2 < -10.0f) {
                        a(f2);
                    } else if (!this.c && getRight() + ((int) (f2 * 0.5f)) <= this.b.right) {
                        layout(getLeft() + ((int) (f2 * 0.5f)), getTop(), ((int) (f2 * 0.5f)) + getRight(), getBottom());
                    }
                } else {
                    this.c = true;
                }
                if (!this.c) {
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDragListener(a aVar) {
        this.e = aVar;
    }
}
