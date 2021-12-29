package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public class f {
    public final RecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView.LayoutManager f58186b;

    public f(RecyclerView recyclerView) {
        this.a = recyclerView;
        this.f58186b = recyclerView.getLayoutManager();
    }

    private View a(int i2, int i3, boolean z, boolean z2) {
        OrientationHelper createVerticalHelper = this.f58186b.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.f58186b) : OrientationHelper.createHorizontalHelper(this.f58186b);
        int startAfterPadding = createVerticalHelper.getStartAfterPadding();
        int endAfterPadding = createVerticalHelper.getEndAfterPadding();
        int i4 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View childAt = this.f58186b.getChildAt(i2);
            int decoratedStart = createVerticalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createVerticalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                if (!z) {
                    return childAt;
                }
                if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
            i2 += i4;
        }
        return view;
    }

    public static f a(RecyclerView recyclerView) {
        if (recyclerView != null) {
            return new f(recyclerView);
        }
        throw new NullPointerException("Recycler View is null");
    }

    public int a() {
        View a = a(0, this.f58186b.getChildCount(), false, true);
        if (a == null) {
            return -1;
        }
        return this.a.getChildAdapterPosition(a);
    }

    public int b() {
        View a = a(this.f58186b.getChildCount() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return this.a.getChildAdapterPosition(a);
    }
}
