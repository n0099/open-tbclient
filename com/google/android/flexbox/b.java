package com.google.android.flexbox;

import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    int mBI;
    int mBJ;
    int mBK;
    int mBL;
    float mBM;
    float mBN;
    int mBO;
    int mBP;
    int mBR;
    int mBS;
    int mItemCount;
    int mLeft = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mTop = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> mBQ = new ArrayList();

    public int dCw() {
        return this.mBK;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dCx() {
        return this.mItemCount - this.mBL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dCu()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dCv() + view.getBottom() + i4);
    }
}
