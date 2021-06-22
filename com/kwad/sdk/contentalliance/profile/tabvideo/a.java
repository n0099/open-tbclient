package com.kwad.sdk.contentalliance.profile.tabvideo;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f33608a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33609b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33610c;

    public a(int i2, int i3, int i4) {
        this.f33608a = i2;
        this.f33609b = i3;
        this.f33610c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition % this.f33608a == 0) {
            rect.left = 0;
        } else {
            rect.left = this.f33609b / 2;
        }
        int i2 = this.f33608a;
        if (childAdapterPosition % i2 == i2 - 1) {
            rect.right = 0;
        } else {
            rect.right = this.f33609b / 2;
        }
        if (childAdapterPosition < this.f33608a) {
            rect.top = 0;
        } else {
            rect.top = this.f33610c / 2;
        }
        if (childAdapterPosition >= itemCount || childAdapterPosition <= itemCount - this.f33608a) {
            rect.bottom = this.f33610c / 2;
        } else {
            rect.bottom = 0;
        }
    }
}
