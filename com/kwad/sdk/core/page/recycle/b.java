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
    public Rect f34313a;

    /* renamed from: b  reason: collision with root package name */
    public int f34314b;

    /* renamed from: c  reason: collision with root package name */
    public int f34315c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34316d;

    /* renamed from: e  reason: collision with root package name */
    public int f34317e;

    /* renamed from: f  reason: collision with root package name */
    public a f34318f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34319g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34320h;

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

    public b(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34317e = Integer.MIN_VALUE;
        this.f34320h = false;
    }

    private void a(int i, int i2, int i3) {
        if (this.f34317e == Integer.MIN_VALUE) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.f34317e = iArr[1];
        }
        int a2 = f.a(this).a();
        int b2 = f.a(this).b();
        if (a2 == -1 || b2 == -1) {
            return;
        }
        if (i < a2 || i > b2) {
            if (i > b2) {
                scrollBy(0, i2);
            } else {
                scrollBy(0, -i2);
            }
            a(i, i2, i3);
            return;
        }
        int i4 = i - a2;
        if (getChildCount() > i4) {
            int[] iArr2 = new int[2];
            getChildAt(i4).getLocationOnScreen(iArr2);
            scrollBy(0, (iArr2[1] - this.f34317e) - i3);
        }
    }

    private void b() {
        Rect rect = this.f34313a;
        if (rect == null) {
            this.f34313a = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                this.f34313a.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    public void a() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).a();
        }
    }

    public void a(int i, int i2) {
        a(i, getHeight(), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f34314b != 0) {
            b();
            Rect rect = this.f34313a;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.f34313a);
                canvas.drawColor(this.f34314b);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f34319g) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.f34320h) {
            stopScroll();
        }
        a aVar = this.f34318f;
        if (aVar == null || !aVar.a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f34315c;
        if (i3 > 0 && i3 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f34315c, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f34319g) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (this.f34316d) {
            a(i, 0);
        } else {
            super.scrollToPosition(i);
        }
    }

    public void setDisableScroll(boolean z) {
        this.f34319g = z;
    }

    public void setDownStop(boolean z) {
        this.f34320h = z;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.f34318f = aVar;
    }

    public void setUnderneathColor(int i) {
        this.f34314b = i;
        b();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.f34316d = z;
    }
}
