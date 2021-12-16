package com.tachikoma.core.component.listview;

import android.view.ViewGroup;
import com.tachikoma.core.component.listview.TKRecyclerAdapter;
/* loaded from: classes3.dex */
public interface ITKRecyclerAdapter {
    int getItemCount();

    int getItemViewType(int i2);

    boolean isFullWidgetForView(int i2);

    void onBindViewHolder(TKRecyclerAdapter.TKViewHolder tKViewHolder, int i2);

    TKRecyclerAdapter.TKViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2);

    void onDestroy();

    void setNeedFixHeight(boolean z);

    void setSupportForFullSpan(boolean z);
}
