package com.kwad.sdk.contentalliance.detail.photo.related;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* loaded from: classes4.dex */
public class d extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f8583a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8584b;
    private final int c;
    private final int d;

    public d(int i, int i2) {
        this(i, 0, 0, i2);
    }

    public d(int i, int i2, int i3, int i4) {
        this.d = i;
        this.f8583a = i2;
        this.f8584b = i3;
        this.c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
        rect.left = this.c / 2;
        rect.right = this.c / 2;
        rect.top = this.c;
        rect.bottom = 0;
        if (spanIndex == 0) {
            rect.left = this.f8584b;
        } else if (spanIndex == this.d - 1) {
            rect.right = this.f8584b;
        }
        boolean z = childAdapterPosition < this.d;
        boolean z2 = (itemCount + (-1)) / this.d == childAdapterPosition / this.d;
        if (z) {
            rect.top = this.f8583a;
        } else if (z2) {
            rect.bottom = this.f8583a;
        }
    }
}
