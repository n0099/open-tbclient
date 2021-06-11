package com.kwad.sdk.contentalliance.detail.photo.related;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* loaded from: classes6.dex */
public class d extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f33072a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33073b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33074c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33075d;

    public d(int i2, int i3) {
        this(i2, 0, 0, i3);
    }

    public d(int i2, int i3, int i4, int i5) {
        this.f33075d = i2;
        this.f33072a = i3;
        this.f33073b = i4;
        this.f33074c = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
        int i2 = this.f33074c;
        rect.left = i2 / 2;
        rect.right = i2 / 2;
        rect.top = i2;
        rect.bottom = 0;
        if (spanIndex == 0) {
            rect.left = this.f33073b;
        } else if (spanIndex == this.f33075d - 1) {
            rect.right = this.f33073b;
        }
        boolean z = childAdapterPosition < this.f33075d;
        int i3 = this.f33075d;
        boolean z2 = (itemCount - 1) / i3 == childAdapterPosition / i3;
        if (z) {
            rect.top = this.f33072a;
        } else if (z2) {
            rect.bottom = this.f33072a;
        }
    }
}
