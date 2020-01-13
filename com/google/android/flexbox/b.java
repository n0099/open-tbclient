package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    int mIA;
    int mIB;
    int mIC;
    float mIE;
    float mIF;
    int mIG;
    int mIH;
    int mIJ;
    int mIK;
    int mItemCount;
    int mIz;
    int mLeft = Integer.MAX_VALUE;
    int mTop = Integer.MAX_VALUE;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> mII = new ArrayList();

    public int dzd() {
        return this.mIB;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dze() {
        return this.mItemCount - this.mIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dzb()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dzc() + view.getBottom() + i4);
    }
}
