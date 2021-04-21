package com.kwad.sdk.core.page.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public class g extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f34329a;

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
    public void removeDetachedView(View view, boolean z) {
        boolean z2 = this.f34329a;
        super.removeDetachedView(view, z);
    }

    public void setIngoreTmpDetachedFlag(boolean z) {
        this.f34329a = z;
    }
}
