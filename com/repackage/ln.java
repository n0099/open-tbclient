package com.repackage;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes6.dex */
public interface ln<V extends ViewGroup> {
    int getContentViewsCount();

    int getFooterViewsCount();

    int getHeaderViewsCount();

    V getListView();

    boolean removeHeaderView(View view2);
}
