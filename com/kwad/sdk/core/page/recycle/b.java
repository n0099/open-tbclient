package com.kwad.sdk.core.page.recycle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public Rect f33294a;

    /* renamed from: b  reason: collision with root package name */
    public int f33295b;

    /* renamed from: c  reason: collision with root package name */
    public int f33296c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33297d;

    /* renamed from: e  reason: collision with root package name */
    public int f33298e;

    /* renamed from: f  reason: collision with root package name */
    public a f33299f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33300g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33301h;

    /* loaded from: classes6.dex */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33298e = Integer.MIN_VALUE;
        this.f33301h = false;
    }

    private void a(int i2, int i3, int i4) {
        if (this.f33298e == Integer.MIN_VALUE) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.f33298e = iArr[1];
        }
        int a2 = f.a(this).a();
        int b2 = f.a(this).b();
        if (a2 == -1 || b2 == -1) {
            return;
        }
        if (i2 < a2 || i2 > b2) {
            if (i2 > b2) {
                scrollBy(0, i3);
            } else {
                scrollBy(0, -i3);
            }
            a(i2, i3, i4);
            return;
        }
        int i5 = i2 - a2;
        if (getChildCount() > i5) {
            int[] iArr2 = new int[2];
            getChildAt(i5).getLocationOnScreen(iArr2);
            scrollBy(0, (iArr2[1] - this.f33298e) - i4);
        }
    }

    private void b() {
        Rect rect = this.f33294a;
        if (rect == null) {
            this.f33294a = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                this.f33294a.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    public void a() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).a();
        }
    }

    public void a(int i2, int i3) {
        a(i2, getHeight(), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f33295b != 0) {
            b();
            Rect rect = this.f33294a;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.f33294a);
                canvas.drawColor(this.f33295b);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f33300g) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.f33301h) {
            stopScroll();
        }
        a aVar = this.f33299f;
        if (aVar == null || !aVar.a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int i4 = this.f33296c;
        if (i4 > 0 && i4 < size) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.f33296c, View.MeasureSpec.getMode(i3));
        }
        super.onMeasure(i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f33300g) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i2) {
        if (this.f33297d) {
            a(i2, 0);
        } else {
            super.scrollToPosition(i2);
        }
    }

    public void setDisableScroll(boolean z) {
        this.f33300g = z;
    }

    public void setDownStop(boolean z) {
        this.f33301h = z;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.f33299f = aVar;
    }

    public void setUnderneathColor(int i2) {
        this.f33295b = i2;
        b();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.f33297d = z;
    }
}
