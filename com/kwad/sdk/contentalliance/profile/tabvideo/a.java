package com.kwad.sdk.contentalliance.profile.tabvideo;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f5860a;
    private final int b;
    private final int c;

    public a(int i, int i2, int i3) {
        this.f5860a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition % this.f5860a == 0) {
            rect.left = 0;
        } else {
            rect.left = this.b / 2;
        }
        if (childAdapterPosition % this.f5860a == this.f5860a - 1) {
            rect.right = 0;
        } else {
            rect.right = this.b / 2;
        }
        if (childAdapterPosition < this.f5860a) {
            rect.top = 0;
        } else {
            rect.top = this.c / 2;
        }
        if (childAdapterPosition >= itemCount || childAdapterPosition <= itemCount - this.f5860a) {
            rect.bottom = this.c / 2;
        } else {
            rect.bottom = 0;
        }
    }
}
