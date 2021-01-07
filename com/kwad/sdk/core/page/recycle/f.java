package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    final RecyclerView f9661a;

    /* renamed from: b  reason: collision with root package name */
    final RecyclerView.LayoutManager f9662b;

    f(RecyclerView recyclerView) {
        this.f9661a = recyclerView;
        this.f9662b = recyclerView.getLayoutManager();
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper createVerticalHelper = this.f9662b.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.f9662b) : OrientationHelper.createHorizontalHelper(this.f9662b);
        int startAfterPadding = createVerticalHelper.getStartAfterPadding();
        int endAfterPadding = createVerticalHelper.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.f9662b.getChildAt(i);
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
                    i += i3;
                    view = childAt;
                }
            }
            childAt = view;
            i += i3;
            view = childAt;
        }
        return view;
    }

    public static f a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            throw new NullPointerException("Recycler View is null");
        }
        return new f(recyclerView);
    }

    public int a() {
        View a2 = a(0, this.f9662b.getChildCount(), false, true);
        if (a2 == null) {
            return -1;
        }
        return this.f9661a.getChildAdapterPosition(a2);
    }

    public int b() {
        View a2 = a(this.f9662b.getChildCount() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return this.f9661a.getChildAdapterPosition(a2);
    }
}
