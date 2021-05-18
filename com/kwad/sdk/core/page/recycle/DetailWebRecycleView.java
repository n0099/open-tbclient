package com.kwad.sdk.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.n;
/* loaded from: classes6.dex */
public class DetailWebRecycleView extends b {

    /* renamed from: a  reason: collision with root package name */
    public a f32520a;

    /* renamed from: b  reason: collision with root package name */
    public int f32521b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32522c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32523d;

    /* renamed from: e  reason: collision with root package name */
    public int f32524e;

    /* renamed from: f  reason: collision with root package name */
    public int f32525f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32526g;

    /* renamed from: h  reason: collision with root package name */
    public int f32527h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f32528i;
    public ap j;

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
        this.f32521b = 1000;
        this.f32522c = false;
        this.f32523d = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object a2 = n.a(DetailWebRecycleView.this, "mGapWorker");
                    if (a2 != null) {
                        n.a(a2, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.f32521b));
                    }
                } catch (RuntimeException e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
        };
        this.f32528i = runnable;
        this.j = new ap(runnable);
        this.f32527h = context instanceof Activity ? an.c((Activity) context) : an.b(context);
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
        a aVar = this.f32520a;
        if (aVar == null || !aVar.a(motionEvent)) {
            this.f32525f = computeVerticalScrollOffset();
            if (motionEvent.getY() <= this.f32524e - this.f32525f) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f32525f = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.f32524e) {
            return false;
        }
        fling((int) f2, (int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.f32525f = computeVerticalScrollOffset;
        if ((i3 > 0 && computeVerticalScrollOffset < this.f32524e) && !this.f32526g && this.f32525f < this.f32527h) {
            scrollBy(0, i3);
            iArr[1] = i3;
        }
        if (i3 < 0 && this.f32525f > 0 && !ViewCompat.canScrollVertically(view, -1)) {
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
                    this.f32526g = true;
                    return;
                }
            }
            this.f32526g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f32523d) {
            this.f32523d = false;
        } else if (this.f32522c) {
        } else {
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.f32522c = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.f32523d = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.f32520a = aVar;
    }

    public void setTopViewHeight(int i2) {
        this.f32524e = i2;
    }
}
