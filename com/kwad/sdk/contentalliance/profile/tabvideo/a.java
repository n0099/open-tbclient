package com.kwad.sdk.contentalliance.profile.tabvideo;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f8797a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8798b;
    private final int c;

    public a(int i, int i2, int i3) {
        this.f8797a = i;
        this.f8798b = i2;
        this.c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition % this.f8797a == 0) {
            rect.left = 0;
        } else {
            rect.left = this.f8798b / 2;
        }
        if (childAdapterPosition % this.f8797a == this.f8797a - 1) {
            rect.right = 0;
        } else {
            rect.right = this.f8798b / 2;
        }
        if (childAdapterPosition < this.f8797a) {
            rect.top = 0;
        } else {
            rect.top = this.c / 2;
        }
        if (childAdapterPosition >= itemCount || childAdapterPosition <= itemCount - this.f8797a) {
            rect.bottom = this.c / 2;
        } else {
            rect.bottom = 0;
        }
    }
}
