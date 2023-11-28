package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.ap;
/* loaded from: classes10.dex */
public final class f {
    public final RecyclerView PK;
    public final RecyclerView.LayoutManager PL;

    public f(RecyclerView recyclerView) {
        this.PK = recyclerView;
        this.PL = recyclerView.getLayoutManager();
    }

    public static f b(RecyclerView recyclerView) {
        ap.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper createHorizontalHelper;
        int i3;
        if (this.PL.canScrollVertically()) {
            createHorizontalHelper = OrientationHelper.createVerticalHelper(this.PL);
        } else {
            createHorizontalHelper = OrientationHelper.createHorizontalHelper(this.PL);
        }
        int startAfterPadding = createHorizontalHelper.getStartAfterPadding();
        int endAfterPadding = createHorizontalHelper.getEndAfterPadding();
        if (i2 > i) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        while (i != i2) {
            View childAt = this.PL.getChildAt(i);
            int decoratedStart = createHorizontalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createHorizontalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    public final int findFirstVisibleItemPosition() {
        View a = a(0, this.PL.getChildCount(), false, true);
        if (a == null) {
            return -1;
        }
        return this.PK.getChildAdapterPosition(a);
    }

    public final int findLastVisibleItemPosition() {
        View a = a(this.PL.getChildCount() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return this.PK.getChildAdapterPosition(a);
    }
}
