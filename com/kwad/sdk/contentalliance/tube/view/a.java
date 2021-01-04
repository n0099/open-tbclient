package com.kwad.sdk.contentalliance.tube.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private int f9309a;

    public a(int i) {
        this.f9309a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.left = this.f9309a;
        rect.bottom = this.f9309a;
    }
}
