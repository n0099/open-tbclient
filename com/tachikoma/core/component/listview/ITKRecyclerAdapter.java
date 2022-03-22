package com.tachikoma.core.component.listview;

import android.view.ViewGroup;
import com.tachikoma.core.component.listview.TKRecyclerAdapter;
/* loaded from: classes7.dex */
public interface ITKRecyclerAdapter {
    int getItemCount();

    int getItemViewType(int i);

    boolean isFullWidgetForView(int i);

    void onBindViewHolder(TKRecyclerAdapter.TKViewHolder tKViewHolder, int i);

    TKRecyclerAdapter.TKViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);

    void onDestroy();

    void setNeedFixHeight(boolean z);

    void setSupportForFullSpan(boolean z);
}
