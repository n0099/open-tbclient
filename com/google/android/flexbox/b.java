package com.google.android.flexbox;

import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    int mItemCount;
    int nAY;
    int nAZ;
    int nBa;
    int nBb;
    float nBc;
    float nBd;
    int nBe;
    int nBf;
    int nBh;
    int nBi;
    int mLeft = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mTop = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> nBg = new ArrayList();

    public int dWE() {
        return this.nBa;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dWF() {
        return this.mItemCount - this.nBb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dWC()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dWD() + view.getBottom() + i4);
    }
}
