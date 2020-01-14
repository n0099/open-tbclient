package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    int mIF;
    int mIG;
    int mIH;
    int mII;
    float mIJ;
    float mIK;
    int mIL;
    int mIM;
    int mIO;
    int mIP;
    int mItemCount;
    int mLeft = Integer.MAX_VALUE;
    int mTop = Integer.MAX_VALUE;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> mIN = new ArrayList();

    public int dzf() {
        return this.mIH;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dzg() {
        return this.mItemCount - this.mII;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dzd()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dze() + view.getBottom() + i4);
    }
}
