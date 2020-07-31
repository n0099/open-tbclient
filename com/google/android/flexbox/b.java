package com.google.android.flexbox;

import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    int mItemCount;
    int nhe;
    int nhf;
    int nhg;
    int nhh;
    float nhi;
    float nhj;
    int nhk;
    int nhl;
    int nhn;
    int nho;
    int mLeft = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mTop = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> nhm = new ArrayList();

    public int dKC() {
        return this.nhg;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dKD() {
        return this.mItemCount - this.nhh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dKA()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dKB() + view.getBottom() + i4);
    }
}
