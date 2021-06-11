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
    public int f34000a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f34001b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34002c;

    /* renamed from: d  reason: collision with root package name */
    public float f34003d;

    /* renamed from: e  reason: collision with root package name */
    public a f34004e;

    /* renamed from: f  reason: collision with root package name */
    public float f34005f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34006g;

    /* renamed from: h  reason: collision with root package name */
    public float f34007h;

    /* renamed from: i  reason: collision with root package name */
    public float f34008i;
    public float j;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i2, float f2);

        void a(int i2, int i3, int i4, int i5);

        void a(boolean z, int i2, float f2);
    }

    public b(Context context) {
        super(context);
        this.f34000a = 0;
        this.f34001b = new Rect();
        this.f34002c = true;
        this.f34003d = 0.0f;
        this.f34006g = false;
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void a() {
        if (!this.f34001b.isEmpty()) {
            b();
        }
        this.f34003d = -1.0f;
    }

    private void a(float f2) {
        if (this.f34001b.isEmpty()) {
            this.f34001b.set(getLeft(), getTop(), getRight(), getBottom());
        }
        this.f34002c = false;
        int i2 = (int) (f2 * 0.5f);
        layout(getLeft() + i2, getTop(), getRight() + i2, getBottom());
    }

    private void b() {
        TranslateAnimation translateAnimation = new TranslateAnimation(getLeft(), this.f34001b.left, 0.0f, 0.0f);
        translateAnimation.setDuration(200L);
        startAnimation(translateAnimation);
        Rect rect = this.f34001b;
        layout(rect.left, rect.top, rect.right, rect.bottom);
        this.f34001b.setEmpty();
        this.f34002c = true;
        a aVar = this.f34004e;
        if (aVar != null) {
            aVar.a(this.f34000a, this.f34001b.left - getLeft());
        }
    }

    private int getSideEdgeType() {
        if (getScrollX() >= this.f34005f) {
            return 2;
        }
        return this.f34000a == 0 ? 1 : 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f34007h = motionEvent.getRawX();
            this.f34008i = motionEvent.getRawY();
            this.f34006g = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && !this.f34006g) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f2 = rawX - this.f34007h;
            float f3 = rawY - this.f34008i;
            if (Math.abs(f2) > this.j && Math.abs(f2) > Math.abs(f3)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (Math.abs(f3) - Math.abs(f2) > this.j) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.f34006g = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f34000a = getCurrentItem();
            float f2 = 0.0f;
            if (getAdapter() != null) {
                for (int i2 = 0; i2 < getAdapter().getCount(); i2++) {
                    f2 += getAdapter().getPageWidth(i2);
                }
            }
            this.f34005f = (f2 - 1.0f) * getMeasuredWidth();
            if (this.f34000a == 0 || getScrollX() >= this.f34005f) {
                this.f34003d = motionEvent.getX();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (!z || (aVar = this.f34004e) == null || i2 == this.f34001b.left) {
            return;
        }
        aVar.a(getCurrentItem() == 0, this.f34000a, this.f34001b.left - getLeft());
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.f34004e;
        if (aVar != null) {
            aVar.a(i2, i3, i4, i5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        if ((getLeft() + r2) != r7.f34001b.left) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
        layout(getLeft() + r2, getTop(), getRight() + r2, getBottom());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
        if ((getLeft() + r2) >= r7.f34001b.left) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ae, code lost:
        if ((getRight() + r2) <= r7.f34001b.right) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b7 A[RETURN] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            a();
        } else if (actionMasked == 2) {
            int sideEdgeType = getSideEdgeType();
            if (sideEdgeType > 0 && this.f34003d < 0.0f) {
                this.f34003d = motionEvent.getX(0);
            }
            if (getAdapter().getCount() == 1) {
                float x = motionEvent.getX(0);
                float f2 = x - this.f34003d;
                this.f34003d = x;
                if (f2 > 10.0f || f2 < -10.0f) {
                    a(f2);
                } else if (!this.f34002c) {
                    i2 = (int) (f2 * 0.5f);
                }
                if (!this.f34002c) {
                    return true;
                }
            } else {
                if (sideEdgeType > 0) {
                    float x2 = motionEvent.getX(0);
                    float f3 = x2 - this.f34003d;
                    this.f34003d = x2;
                    if (sideEdgeType == 1) {
                        if (f3 <= 10.0f) {
                            if (!this.f34002c) {
                                i2 = (int) (f3 * 0.5f);
                            }
                        }
                        a(f3);
                    } else {
                        if (f3 >= -10.0f) {
                            if (!this.f34002c) {
                                i2 = (int) (f3 * 0.5f);
                            }
                        }
                        a(f3);
                    }
                } else {
                    this.f34002c = true;
                }
                if (!this.f34002c) {
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDragListener(a aVar) {
        this.f34004e = aVar;
    }
}
