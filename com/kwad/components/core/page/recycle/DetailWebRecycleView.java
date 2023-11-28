package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.s.o;
import com.kwad.sdk.utils.s;
/* loaded from: classes10.dex */
public class DetailWebRecycleView extends b {
    public int Po;
    public boolean Pp;
    public boolean Pq;
    public int Pr;
    public int Ps;
    public boolean Pt;
    public a Pu;
    public Runnable Pv;
    public o Pw;
    public int me;

    /* loaded from: classes10.dex */
    public interface a {
        boolean pG();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view2, View view3, int i) {
        return (i & 2) != 0;
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.Pu;
        if (aVar != null && aVar.pG()) {
            return true;
        }
        this.Ps = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.Pr - this.Ps) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.Pp = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.Pq = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.Pu = aVar;
    }

    public void setTopViewHeight(int i) {
        this.Pr = i;
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view2, View view3) {
        if (this.Pq) {
            this.Pq = false;
        } else if (!this.Pp) {
            super.requestChildFocus(view2, view3);
        }
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Po = 1000;
        this.Pp = false;
        this.Pq = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = s.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        s.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Po));
                    }
                } catch (RuntimeException e) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
            }
        };
        this.Pv = runnable;
        this.Pw = new o(runnable);
        if (context instanceof Activity) {
            this.me = com.kwad.sdk.d.a.a.e((Activity) context);
        } else {
            this.me = com.kwad.sdk.d.a.a.getScreenHeight(context);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view2, float f, float f2) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.Ps = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.Pr) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.Pw, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Pw);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr) {
        boolean z;
        boolean z2;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.Ps = computeVerticalScrollOffset;
        if (i2 > 0 && computeVerticalScrollOffset < this.Pr) {
            z = true;
        } else {
            z = false;
        }
        if (z && !this.Pt && this.Ps < this.me) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 < 0 && this.Ps > 0 && !ViewCompat.canScrollVertically(view2, -1)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
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
                    this.Pt = true;
                    return;
                }
            }
            this.Pt = false;
        }
    }
}
