package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    int mEI;
    int mEJ;
    int mEK;
    int mEL;
    float mEM;
    float mEN;
    int mEO;
    int mEP;
    int mER;
    int mES;
    int mItemCount;
    int mLeft = Integer.MAX_VALUE;
    int mTop = Integer.MAX_VALUE;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> mEQ = new ArrayList();

    public int dxU() {
        return this.mEK;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dxV() {
        return this.mItemCount - this.mEL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dxS()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dxT() + view.getBottom() + i4);
    }
}
