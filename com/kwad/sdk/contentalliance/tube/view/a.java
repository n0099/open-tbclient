package com.kwad.sdk.contentalliance.tube.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private int f9010a;

    public a(int i) {
        this.f9010a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.left = this.f9010a;
        rect.bottom = this.f9010a;
    }
}
