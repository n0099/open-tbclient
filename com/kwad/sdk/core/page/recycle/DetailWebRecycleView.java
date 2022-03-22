package com.kwad.sdk.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.s;
/* loaded from: classes7.dex */
public class DetailWebRecycleView extends b {
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public int f39640b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39641c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39642d;

    /* renamed from: e  reason: collision with root package name */
    public int f39643e;

    /* renamed from: f  reason: collision with root package name */
    public int f39644f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39645g;

    /* renamed from: h  reason: collision with root package name */
    public int f39646h;
    public Runnable i;
    public bd j;

    /* loaded from: classes7.dex */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39640b = 1000;
        this.f39641c = false;
        this.f39642d = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object a2 = s.a(DetailWebRecycleView.this, "mGapWorker");
                    if (a2 != null) {
                        s.a(a2, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.f39640b));
                    }
                } catch (RuntimeException e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
        };
        this.i = runnable;
        this.j = new bd(runnable);
        this.f39646h = context instanceof Activity ? com.kwad.sdk.a.kwai.a.b((Activity) context) : com.kwad.sdk.a.kwai.a.b(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.j, 50L);
    }

    @Override // com.kwad.sdk.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.j);
    }

    @Override // com.kwad.sdk.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.a;
        if (aVar == null || !aVar.a(motionEvent)) {
            this.f39644f = computeVerticalScrollOffset();
            if (motionEvent.getY() <= this.f39643e - this.f39644f) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f39644f = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.f39643e) {
            return false;
        }
        fling((int) f2, (int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f39644f = computeVerticalScrollOffset;
        if ((i2 > 0 && computeVerticalScrollOffset < this.f39643e) && !this.f39645g && this.f39644f < this.f39646h) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 < 0 && this.f39644f > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.f39645g = true;
                    return;
                }
            }
            this.f39645g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f39642d) {
            this.f39642d = false;
        } else if (this.f39641c) {
        } else {
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.f39641c = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.f39642d = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.a = aVar;
    }

    public void setTopViewHeight(int i) {
        this.f39643e = i;
    }
}
