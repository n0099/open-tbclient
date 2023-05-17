package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.m.o;
import com.kwad.sdk.utils.q;
/* loaded from: classes9.dex */
public class DetailWebRecycleView extends b {
    public int GA;
    public int GB;
    public boolean GC;
    public int GD;
    public a GE;
    public Runnable GF;
    public o GG;
    public int Gx;
    public boolean Gy;
    public boolean Gz;

    /* loaded from: classes9.dex */
    public interface a {
        boolean nW();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Gx = 1000;
        this.Gy = false;
        this.Gz = false;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object c = q.c(DetailWebRecycleView.this, "mGapWorker");
                    if (c != null) {
                        q.a(c, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Gx));
                    }
                } catch (RuntimeException e) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                }
            }
        };
        this.GF = runnable;
        this.GG = new o(runnable);
        this.GD = context instanceof Activity ? com.kwad.sdk.b.kwai.a.d((Activity) context) : com.kwad.sdk.b.kwai.a.getScreenHeight(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.GG, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.GG);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.GE;
        if (aVar == null || !aVar.nW()) {
            this.GB = computeVerticalScrollOffset();
            if (motionEvent.getY() <= this.GA - this.GB) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view2, float f, float f2) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.GB = computeVerticalScrollOffset;
        if (computeVerticalScrollOffset >= this.GA) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        this.GB = computeVerticalScrollOffset;
        if ((i2 > 0 && computeVerticalScrollOffset < this.GA) && !this.GC && this.GB < this.GD) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 < 0 && this.GB > 0 && !ViewCompat.canScrollVertically(view2, -1)) {
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
                    this.GC = true;
                    return;
                }
            }
            this.GC = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view2, View view3, int i) {
        return (i & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view2, View view3) {
        if (this.Gz) {
            this.Gz = false;
        } else if (this.Gy) {
        } else {
            super.requestChildFocus(view2, view3);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.Gy = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.Gz = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.GE = aVar;
    }

    public void setTopViewHeight(int i) {
        this.GA = i;
    }
}
