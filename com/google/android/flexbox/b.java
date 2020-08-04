package com.google.android.flexbox;

import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    int mItemCount;
    int nhg;
    int nhh;
    int nhi;
    int nhj;
    float nhk;
    float nhl;
    int nhm;
    int nhn;
    int nhp;
    int nhq;
    int mLeft = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mTop = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> nho = new ArrayList();

    public int dKD() {
        return this.nhi;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dKE() {
        return this.mItemCount - this.nhj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dKB()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dKC() + view.getBottom() + i4);
    }
}
