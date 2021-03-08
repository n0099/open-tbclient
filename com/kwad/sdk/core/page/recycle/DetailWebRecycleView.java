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
/* loaded from: classes3.dex */
public class DetailWebRecycleView extends b {

    /* renamed from: a  reason: collision with root package name */
    a f6207a;
    private int b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private Runnable i;
    private aq j;

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

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 1000;
        this.c = false;
        this.d = false;
        this.i = new Runnable() { // from class: com.kwad.sdk.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object a2 = n.a(DetailWebRecycleView.this, "mGapWorker");
                    if (a2 != null) {
                        n.a(a2, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.b));
                    }
                } catch (RuntimeException e) {
                    com.kwad.sdk.core.d.a.a(e);
                }
            }
        };
        this.j = new aq(this.i);
        if (context instanceof Activity) {
            this.h = ao.d((Activity) context);
        } else {
            this.h = ao.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.j, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.j);
    }

    @Override // com.kwad.sdk.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f6207a == null || !this.f6207a.a(motionEvent)) {
            this.f = computeVerticalScrollOffset();
            if (motionEvent.getY() <= this.e - this.f) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        this.f = computeVerticalScrollOffset();
        if (this.f >= this.e) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        this.f = computeVerticalScrollOffset();
        if ((i2 > 0 && this.f < this.e) && !this.g && this.f < this.h) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 < 0 && this.f > 0 && !ViewCompat.canScrollVertically(view, -1)) {
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
                    this.g = true;
                    return;
                }
            }
            this.g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.d) {
            this.d = false;
        } else if (this.c) {
        } else {
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.c = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.d = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.f6207a = aVar;
    }

    public void setTopViewHeight(int i) {
        this.e = i;
    }
}
