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
/* loaded from: classes3.dex */
public class DetailWebRecycleView extends b {
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public int f58157b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58158c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58159d;

    /* renamed from: e  reason: collision with root package name */
    public int f58160e;

    /* renamed from: f  reason: collision with root package name */
    public int f58161f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58162g;

    /* renamed from: h  reason: collision with root package name */
    public int f58163h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f58164i;

    /* renamed from: j  reason: collision with root package name */
    public bd f58165j;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f58157b = 1000;
        this.f58158c = false;
        this.f58159d = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object a2 = s.a(DetailWebRecycleView.this, "mGapWorker");
                    if (a2 != null) {
                        s.a(a2, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.f58157b));
                    }
                } catch (RuntimeException e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
        };
        this.f58164i = runnable;
        this.f58165j = new bd(runnable);
        this.f58163h = context instanceof Activity ? com.kwad.sdk.a.kwai.a.b((Activity) context) : com.kwad.sdk.a.kwai.a.b(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.f58165j, 50L);
    }

    @Override // com.kwad.sdk.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f58165j);
    }

    @Override // com.kwad.sdk.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.a;
        if (aVar == null || !aVar.a(motionEvent)) {
            this.f58161f = computeVerticalScrollOffset();
            if (motionEvent.getY() <= this.f58160e - this.f58161f) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f58161f = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.f58160e) {
            return false;
        }
        fling((int) f2, (int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f58161f = computeVerticalScrollOffset;
        if ((i3 > 0 && computeVerticalScrollOffset < this.f58160e) && !this.f58162g && this.f58161f < this.f58163h) {
            scrollBy(0, i3);
            iArr[1] = i3;
        }
        if (i3 < 0 && this.f58161f > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i3);
            iArr[1] = i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i2) {
        super.onScrollStateChanged(i2);
        if (i2 == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.f58162g = true;
                    return;
                }
            }
            this.f58162g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f58159d) {
            this.f58159d = false;
        } else if (this.f58158c) {
        } else {
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.f58158c = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.f58159d = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.a = aVar;
    }

    public void setTopViewHeight(int i2) {
        this.f58160e = i2;
    }
}
