package com.kascend.chushou.widget.gifts;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
/* loaded from: classes5.dex */
public class PagerView extends ViewGroup {
    private float a;
    private float b;
    private float c;
    private boolean d;
    private float e;
    private float f;
    private int k;
    private OverScroller niT;
    private ViewConfiguration niU;
    private VelocityTracker niV;
    private a niW;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
    }

    public PagerView(Context context) {
        this(context, null);
    }

    public PagerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.niV = VelocityTracker.obtain();
        this.k = 0;
        this.niT = new OverScroller(context);
        this.niU = ViewConfiguration.get(context);
        this.f = this.niU.getScaledMaximumFlingVelocity();
        this.e = this.niU.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        int i5 = width;
        int i6 = 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).layout(i6, 0, i5, height);
            i6 += getWidth();
            i5 += getWidth();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.niV.clear();
        }
        this.niV.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.d = false;
                this.a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = getScrollX();
                return false;
            case 1:
            default:
                return false;
            case 2:
                float x = this.a - motionEvent.getX();
                if (a(this, false, (int) (-x), (int) motionEvent.getX(), (int) motionEvent.getY()) || this.d) {
                    return false;
                }
                int childCount = getChildCount();
                if (Math.abs(x) > this.niU.getScaledPagingTouchSlop() * 1.5f) {
                    if ((x <= 0.0f || this.k >= childCount - 1) && (x >= 0.0f || this.k <= 0)) {
                        return false;
                    }
                    this.d = true;
                    return true;
                }
                return false;
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (getChildCount() <= 1) {
            return false;
        }
        int width = getWidth();
        int scrollX = getScrollX();
        int childCount = getChildCount();
        if (i < 0) {
            return scrollX > 0;
        } else if (i > 0) {
            return scrollX < (width * childCount) + (-1);
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (motionEvent.getActionMasked() == 0) {
            this.niV.clear();
        }
        this.niV.addMovement(motionEvent);
        int childCount = getChildCount();
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = getScrollX();
                float x = (this.a - motionEvent.getX()) + this.c;
                if (childCount > 1) {
                    if (x > getWidth() * (childCount - 1)) {
                        f = getWidth() * (childCount - 1);
                    } else if (x >= 0.0f) {
                        f = x;
                    }
                    scrollTo((int) f, 0);
                    return true;
                }
                return false;
            case 1:
                if (childCount > 1) {
                    this.niV.computeCurrentVelocity(1000, this.f);
                    float xVelocity = this.niV.getXVelocity();
                    int scrollX = getScrollX();
                    int width = scrollX / getWidth();
                    if (width + 1 >= childCount) {
                        width = childCount - 2;
                    }
                    if (Math.abs(xVelocity) < this.e) {
                        if (scrollX % getWidth() > getWidth() / 2) {
                            width++;
                        }
                    } else if (xVelocity < 0.0f) {
                        width++;
                    }
                    this.niT.startScroll(getScrollX(), 0, (getWidth() * width) - scrollX, 0);
                    ViewCompat.postInvalidateOnAnimation(this);
                    return true;
                }
                return false;
            case 2:
                float x2 = (this.a - motionEvent.getX()) + this.c;
                if (childCount > 1) {
                }
                return false;
            default:
                return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        super.removeViewAt(i);
    }

    public void a(int i, boolean z) {
        int childCount = getChildCount();
        int i2 = i > childCount + (-1) ? childCount - 1 : i;
        if (i2 < 0) {
            i2 = 0;
        }
        if (getChildCount() > 1 && this.k != i2) {
            if (z) {
                this.niT.startScroll(getScrollX(), 0, (i2 * getWidth()) - getScrollX(), 0);
                invalidate();
                return;
            }
            this.k = i2;
            scrollTo(this.k * getWidth(), 0);
            if (this.niW != null) {
                this.niW.a(i2);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.niT.computeScrollOffset()) {
            scrollTo(this.niT.getCurrX(), this.niT.getCurrY());
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        int scrollX = getScrollX() / getWidth();
        int scrollX2 = getScrollX() % getWidth();
        if (scrollX != this.k && scrollX2 == 0) {
            this.k = scrollX;
            if (this.niW != null) {
                this.niW.a(scrollX);
            }
        }
    }

    public void setOnPageChangedListener(a aVar) {
        this.niW = aVar;
    }
}
