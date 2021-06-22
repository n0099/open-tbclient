package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public class h extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public a f32923a;

    public h(View view) {
        super(view);
        this.f32923a = (a) view;
    }

    public void a(b bVar) {
        a aVar = this.f32923a;
        if (aVar != null) {
            aVar.setData(bVar);
        }
    }
}
