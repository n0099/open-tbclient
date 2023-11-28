package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes10.dex */
public class g extends RecyclerView {
    public boolean PM;

    public g(Context context) {
        super(context);
    }

    public void setIngoreTmpDetachedFlag(boolean z) {
        this.PM = z;
    }

    public g(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public void removeDetachedView(View view2, boolean z) {
        if (!this.PM) {
            super.removeDetachedView(view2, z);
        } else {
            super.removeDetachedView(view2, z);
        }
    }

    public g(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
