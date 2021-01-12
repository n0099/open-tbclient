package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes4.dex */
public class c extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f9356a;

    /* renamed from: b  reason: collision with root package name */
    public final e f9357b;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.f9357b = eVar;
        this.f9356a = presenter;
        presenter.a(view);
    }
}
