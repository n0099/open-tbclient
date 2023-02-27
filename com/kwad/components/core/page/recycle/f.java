package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.am;
/* loaded from: classes8.dex */
public final class f {
    public final RecyclerView GU;
    public final RecyclerView.LayoutManager GV;

    public f(RecyclerView recyclerView) {
        this.GU = recyclerView;
        this.GV = recyclerView.getLayoutManager();
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper createVerticalHelper = this.GV.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.GV) : OrientationHelper.createHorizontalHelper(this.GV);
        int startAfterPadding = createVerticalHelper.getStartAfterPadding();
        int endAfterPadding = createVerticalHelper.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = this.GV.getChildAt(i);
            int decoratedStart = createVerticalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createVerticalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    public static f b(RecyclerView recyclerView) {
        am.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View a = a(0, this.GV.getChildCount(), false, true);
        if (a == null) {
            return -1;
        }
        return this.GU.getChildAdapterPosition(a);
    }

    public final int findLastVisibleItemPosition() {
        View a = a(this.GV.getChildCount() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return this.GU.getChildAdapterPosition(a);
    }
}
