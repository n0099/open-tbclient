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
/* loaded from: classes7.dex */
public class b extends g {
    public Rect a;

    /* renamed from: b  reason: collision with root package name */
    public int f39654b;

    /* renamed from: c  reason: collision with root package name */
    public int f39655c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39656d;

    /* renamed from: e  reason: collision with root package name */
    public int f39657e;

    /* renamed from: f  reason: collision with root package name */
    public a f39658f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39659g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39660h;

    /* loaded from: classes7.dex */
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
        this.f39657e = Integer.MIN_VALUE;
        this.f39660h = false;
    }

    private void a(int i, int i2, int i3) {
        if (this.f39657e == Integer.MIN_VALUE) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.f39657e = iArr[1];
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
            scrollBy(0, (iArr2[1] - this.f39657e) - i3);
        }
    }

    private void b() {
        Rect rect = this.a;
        if (rect == null) {
            this.a = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                this.a.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
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
        if (this.f39654b != 0) {
            b();
            Rect rect = this.a;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.a);
                canvas.drawColor(this.f39654b);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f39659g) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.f39660h) {
            stopScroll();
        }
        a aVar = this.f39658f;
        if (aVar == null || !aVar.a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f39655c;
        if (i3 > 0 && i3 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f39655c, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f39659g) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (this.f39656d) {
            a(i, 0);
        } else {
            super.scrollToPosition(i);
        }
    }

    public void setDisableScroll(boolean z) {
        this.f39659g = z;
    }

    public void setDownStop(boolean z) {
        this.f39660h = z;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.f39658f = aVar;
    }

    public void setUnderneathColor(int i) {
        this.f39654b = i;
        b();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.f39656d = z;
    }
}
