package com.kwad.sdk.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.n;
/* loaded from: classes6.dex */
public class DetailWebRecycleView extends b {

    /* renamed from: a  reason: collision with root package name */
    public a f34541a;

    /* renamed from: b  reason: collision with root package name */
    public int f34542b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34543c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34544d;

    /* renamed from: e  reason: collision with root package name */
    public int f34545e;

    /* renamed from: f  reason: collision with root package name */
    public int f34546f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34547g;

    /* renamed from: h  reason: collision with root package name */
    public int f34548h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f34549i;
    public aq j;

    /* loaded from: classes6.dex */
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
        this.f34542b = 1000;
        this.f34543c = false;
        this.f34544d = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object a2 = n.a(DetailWebRecycleView.this, "mGapWorker");
                    if (a2 != null) {
                        n.a(a2, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.f34542b));
                    }
                } catch (RuntimeException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
        };
        this.f34549i = runnable;
        this.j = new aq(runnable);
        this.f34548h = context instanceof Activity ? ao.d((Activity) context) : ao.b(context);
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
        a aVar = this.f34541a;
        if (aVar == null || !aVar.a(motionEvent)) {
            this.f34546f = computeVerticalScrollOffset();
            if (motionEvent.getY() <= this.f34545e - this.f34546f) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f34546f = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.f34545e) {
            return false;
        }
        fling((int) f2, (int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f34546f = computeVerticalScrollOffset;
        if ((i3 > 0 && computeVerticalScrollOffset < this.f34545e) && !this.f34547g && this.f34546f < this.f34548h) {
            scrollBy(0, i3);
            iArr[1] = i3;
        }
        if (i3 < 0 && this.f34546f > 0 && !ViewCompat.canScrollVertically(view, -1)) {
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
                    this.f34547g = true;
                    return;
                }
            }
            this.f34547g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f34544d) {
            this.f34544d = false;
        } else if (this.f34543c) {
        } else {
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.f34543c = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.f34544d = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.f34541a = aVar;
    }

    public void setTopViewHeight(int i2) {
        this.f34545e = i2;
    }
}
