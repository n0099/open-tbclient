package com.kwad.sdk.lib.widget.recycler;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer;
/* loaded from: classes5.dex */
public class CustomAppBarFlingRecyclerView extends RecyclerView implements CustomAppBarFlingConsumer {
    public CustomAppBarFlingRecyclerView(Context context) {
        super(context);
    }

    public CustomAppBarFlingRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomAppBarFlingRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void consumeAppBarFling(int i, int i2) {
        scrollBy(i, i2);
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void onAppBarTouchDown() {
        stopNestedScroll(1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i, int i2) {
        startNestedScroll(2, 1);
        super.smoothScrollBy(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i) {
        startNestedScroll(2, 1);
        super.smoothScrollToPosition(i);
    }
}
