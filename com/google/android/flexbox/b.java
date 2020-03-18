package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    int mItemCount;
    int mLd;
    int mLe;
    int mLf;
    int mLg;
    float mLh;
    float mLi;
    int mLj;
    int mLk;
    int mLm;
    int mLn;
    int mLeft = Integer.MAX_VALUE;
    int mTop = Integer.MAX_VALUE;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> mLl = new ArrayList();

    public int dAP() {
        return this.mLf;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dAQ() {
        return this.mItemCount - this.mLg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dAN()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dAO() + view.getBottom() + i4);
    }
}
