package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.TranslateAnimation;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes6.dex */
public class b extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    public int f33382a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f33383b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33384c;

    /* renamed from: d  reason: collision with root package name */
    public float f33385d;

    /* renamed from: e  reason: collision with root package name */
    public a f33386e;

    /* renamed from: f  reason: collision with root package name */
    public float f33387f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33388g;

    /* renamed from: h  reason: collision with root package name */
    public float f33389h;
    public float i;
    public float j;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, float f2);

        void a(int i, int i2, int i3, int i4);

        void a(boolean z, int i, float f2);
    }

    public b(Context context) {
        super(context);
        this.f33382a = 0;
        this.f33383b = new Rect();
        this.f33384c = true;
        this.f33385d = 0.0f;
        this.f33388g = false;
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void a() {
        if (!this.f33383b.isEmpty()) {
            b();
        }
        this.f33385d = -1.0f;
    }

    private void a(float f2) {
        if (this.f33383b.isEmpty()) {
            this.f33383b.set(getLeft(), getTop(), getRight(), getBottom());
        }
        this.f33384c = false;
        int i = (int) (f2 * 0.5f);
        layout(getLeft() + i, getTop(), getRight() + i, getBottom());
    }

    private void b() {
        TranslateAnimation translateAnimation = new TranslateAnimation(getLeft(), this.f33383b.left, 0.0f, 0.0f);
        translateAnimation.setDuration(200L);
        startAnimation(translateAnimation);
        Rect rect = this.f33383b;
        layout(rect.left, rect.top, rect.right, rect.bottom);
        this.f33383b.setEmpty();
        this.f33384c = true;
        a aVar = this.f33386e;
        if (aVar != null) {
            aVar.a(this.f33382a, this.f33383b.left - getLeft());
        }
    }

    private int getSideEdgeType() {
        if (getScrollX() >= this.f33387f) {
            return 2;
        }
        return this.f33382a == 0 ? 1 : 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f33389h = motionEvent.getRawX();
            this.i = motionEvent.getRawY();
            this.f33388g = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && !this.f33388g) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f2 = rawX - this.f33389h;
            float f3 = rawY - this.i;
            if (Math.abs(f2) > this.j && Math.abs(f2) > Math.abs(f3)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (Math.abs(f3) - Math.abs(f2) > this.j) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.f33388g = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f33382a = getCurrentItem();
            float f2 = 0.0f;
            if (getAdapter() != null) {
                for (int i = 0; i < getAdapter().getCount(); i++) {
                    f2 += getAdapter().getPageWidth(i);
                }
            }
            this.f33387f = (f2 - 1.0f) * getMeasuredWidth();
            if (this.f33382a == 0 || getScrollX() >= this.f33387f) {
                this.f33385d = motionEvent.getX();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a aVar;
        super.onLayout(z, i, i2, i3, i4);
        if (!z || (aVar = this.f33386e) == null || i == this.f33383b.left) {
            return;
        }
        aVar.a(getCurrentItem() == 0, this.f33382a, this.f33383b.left - getLeft());
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.f33386e;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        if ((getLeft() + r2) != r7.f33383b.left) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
        layout(getLeft() + r2, getTop(), getRight() + r2, getBottom());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
        if ((getLeft() + r2) >= r7.f33383b.left) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ae, code lost:
        if ((getRight() + r2) <= r7.f33383b.right) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b7 A[RETURN] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            a();
        } else if (actionMasked == 2) {
            int sideEdgeType = getSideEdgeType();
            if (sideEdgeType > 0 && this.f33385d < 0.0f) {
                this.f33385d = motionEvent.getX(0);
            }
            if (getAdapter().getCount() == 1) {
                float x = motionEvent.getX(0);
                float f2 = x - this.f33385d;
                this.f33385d = x;
                if (f2 > 10.0f || f2 < -10.0f) {
                    a(f2);
                } else if (!this.f33384c) {
                    i = (int) (f2 * 0.5f);
                }
                if (!this.f33384c) {
                    return true;
                }
            } else {
                if (sideEdgeType > 0) {
                    float x2 = motionEvent.getX(0);
                    float f3 = x2 - this.f33385d;
                    this.f33385d = x2;
                    if (sideEdgeType == 1) {
                        if (f3 <= 10.0f) {
                            if (!this.f33384c) {
                                i = (int) (f3 * 0.5f);
                            }
                        }
                        a(f3);
                    } else {
                        if (f3 >= -10.0f) {
                            if (!this.f33384c) {
                                i = (int) (f3 * 0.5f);
                            }
                        }
                        a(f3);
                    }
                } else {
                    this.f33384c = true;
                }
                if (!this.f33384c) {
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDragListener(a aVar) {
        this.f33386e = aVar;
    }
}
