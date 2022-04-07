package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public class f {
    public final RecyclerView a;
    public final RecyclerView.LayoutManager b;

    public f(RecyclerView recyclerView) {
        this.a = recyclerView;
        this.b = recyclerView.getLayoutManager();
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper createVerticalHelper = this.b.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.b) : OrientationHelper.createHorizontalHelper(this.b);
        int startAfterPadding = createVerticalHelper.getStartAfterPadding();
        int endAfterPadding = createVerticalHelper.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View childAt = this.b.getChildAt(i);
            int decoratedStart = createVerticalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createVerticalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                if (!z) {
                    return childAt;
                }
                if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                    return childAt;
                }
                if (z2 && view2 == null) {
                    view2 = childAt;
                }
            }
            i += i3;
        }
        return view2;
    }

    public static f a(RecyclerView recyclerView) {
        if (recyclerView != null) {
            return new f(recyclerView);
        }
        throw new NullPointerException("Recycler View is null");
    }

    public int a() {
        View a = a(0, this.b.getChildCount(), false, true);
        if (a == null) {
            return -1;
        }
        return this.a.getChildAdapterPosition(a);
    }

    public int b() {
        View a = a(this.b.getChildCount() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return this.a.getChildAdapterPosition(a);
    }
}
