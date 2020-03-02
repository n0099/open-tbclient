package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    int mItemCount;
    int mJm;
    int mJn;
    int mJo;
    int mJp;
    float mJq;
    float mJr;
    int mJs;
    int mJt;
    int mJv;
    int mJw;
    int mLeft = Integer.MAX_VALUE;
    int mTop = Integer.MAX_VALUE;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> mJu = new ArrayList();

    public int dAr() {
        return this.mJo;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dAs() {
        return this.mItemCount - this.mJp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dAp()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dAq() + view.getBottom() + i4);
    }
}
