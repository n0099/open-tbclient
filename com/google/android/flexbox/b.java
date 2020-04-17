package com.google.android.flexbox;

import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    int mItemCount;
    int mhM;
    int mhN;
    int mhO;
    int mhP;
    float mhQ;
    float mhR;
    int mhS;
    int mhT;
    int mhV;
    int mhW;
    int mLeft = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mTop = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> mhU = new ArrayList();

    public int dvh() {
        return this.mhO;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dvi() {
        return this.mItemCount - this.mhP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dvf()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dvg() + view.getBottom() + i4);
    }
}
