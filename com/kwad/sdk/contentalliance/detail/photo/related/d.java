package com.kwad.sdk.contentalliance.detail.photo.related;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* loaded from: classes6.dex */
public class d extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f32878a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32879b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32880c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32881d;

    public d(int i, int i2) {
        this(i, 0, 0, i2);
    }

    public d(int i, int i2, int i3, int i4) {
        this.f32881d = i;
        this.f32878a = i2;
        this.f32879b = i3;
        this.f32880c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
        int i = this.f32880c;
        rect.left = i / 2;
        rect.right = i / 2;
        rect.top = i;
        rect.bottom = 0;
        if (spanIndex == 0) {
            rect.left = this.f32879b;
        } else if (spanIndex == this.f32881d - 1) {
            rect.right = this.f32879b;
        }
        boolean z = childAdapterPosition < this.f32881d;
        int i2 = this.f32881d;
        boolean z2 = (itemCount - 1) / i2 == childAdapterPosition / i2;
        if (z) {
            rect.top = this.f32878a;
        } else if (z2) {
            rect.bottom = this.f32878a;
        }
    }
}
