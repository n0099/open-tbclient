package com.google.android.flexbox;

import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    int mItemCount;
    int mhQ;
    int mhR;
    int mhS;
    int mhT;
    float mhU;
    float mhV;
    int mhW;
    int mhX;
    int mhZ;
    int mia;
    int mLeft = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mTop = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    int mRight = Integer.MIN_VALUE;
    int mBottom = Integer.MIN_VALUE;
    List<Integer> mhY = new ArrayList();

    public int dvf() {
        return this.mhS;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int dvg() {
        return this.mItemCount - this.mhT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.dvd()) - i2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i3);
        this.mBottom = Math.max(this.mBottom, flexItem.dve() + view.getBottom() + i4);
    }
}
