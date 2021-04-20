package com.kwad.sdk.contentalliance.profile.tabvideo;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f33201a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33202b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33203c;

    public a(int i, int i2, int i3) {
        this.f33201a = i;
        this.f33202b = i2;
        this.f33203c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition % this.f33201a == 0) {
            rect.left = 0;
        } else {
            rect.left = this.f33202b / 2;
        }
        int i = this.f33201a;
        if (childAdapterPosition % i == i - 1) {
            rect.right = 0;
        } else {
            rect.right = this.f33202b / 2;
        }
        if (childAdapterPosition < this.f33201a) {
            rect.top = 0;
        } else {
            rect.top = this.f33203c / 2;
        }
        if (childAdapterPosition >= itemCount || childAdapterPosition <= itemCount - this.f33201a) {
            rect.bottom = this.f33203c / 2;
        } else {
            rect.bottom = 0;
        }
    }
}
