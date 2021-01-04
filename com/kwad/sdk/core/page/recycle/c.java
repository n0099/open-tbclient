package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f9655a;

    /* renamed from: b  reason: collision with root package name */
    public final e f9656b;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.f9656b = eVar;
        this.f9655a = presenter;
        presenter.a(view);
    }
}
