package com.kwad.sdk.core.page.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public class g extends RecyclerView {
    public boolean a;

    public g(Context context) {
        super(context);
    }

    public g(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public void removeDetachedView(View view2, boolean z) {
        boolean z2 = this.a;
        super.removeDetachedView(view2, z);
    }

    public void setIngoreTmpDetachedFlag(boolean z) {
        this.a = z;
    }
}
