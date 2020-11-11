package com.google.android.flexbox;

import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    int mItemCount;
    int pbA;
    int pbB;
    int pbr;
    int pbs;
    int pbt;
    int pbu;
    float pbv;
    float pbw;
    int pbx;
    int pby;
    int mLeft = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mTop = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> pbz = new ArrayList();

    public int esl() {
        return this.pbt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int esm() {
        return this.mItemCount - this.pbu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.esj()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.esk() + view.getBottom() + i4);
    }
}
