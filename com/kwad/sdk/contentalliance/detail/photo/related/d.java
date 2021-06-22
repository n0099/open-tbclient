package com.kwad.sdk.contentalliance.detail.photo.related;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* loaded from: classes6.dex */
public class d extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f33170a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33171b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33172c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33173d;

    public d(int i2, int i3) {
        this(i2, 0, 0, i3);
    }

    public d(int i2, int i3, int i4, int i5) {
        this.f33173d = i2;
        this.f33170a = i3;
        this.f33171b = i4;
        this.f33172c = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
        int i2 = this.f33172c;
        rect.left = i2 / 2;
        rect.right = i2 / 2;
        rect.top = i2;
        rect.bottom = 0;
        if (spanIndex == 0) {
            rect.left = this.f33171b;
        } else if (spanIndex == this.f33173d - 1) {
            rect.right = this.f33171b;
        }
        boolean z = childAdapterPosition < this.f33173d;
        int i3 = this.f33173d;
        boolean z2 = (itemCount - 1) / i3 == childAdapterPosition / i3;
        if (z) {
            rect.top = this.f33170a;
        } else if (z2) {
            rect.bottom = this.f33170a;
        }
    }
}
