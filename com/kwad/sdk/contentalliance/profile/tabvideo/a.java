package com.kwad.sdk.contentalliance.profile.tabvideo;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f33510a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33511b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33512c;

    public a(int i2, int i3, int i4) {
        this.f33510a = i2;
        this.f33511b = i3;
        this.f33512c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition % this.f33510a == 0) {
            rect.left = 0;
        } else {
            rect.left = this.f33511b / 2;
        }
        int i2 = this.f33510a;
        if (childAdapterPosition % i2 == i2 - 1) {
            rect.right = 0;
        } else {
            rect.right = this.f33511b / 2;
        }
        if (childAdapterPosition < this.f33510a) {
            rect.top = 0;
        } else {
            rect.top = this.f33512c / 2;
        }
        if (childAdapterPosition >= itemCount || childAdapterPosition <= itemCount - this.f33510a) {
            rect.bottom = this.f33512c / 2;
        } else {
            rect.bottom = 0;
        }
    }
}
