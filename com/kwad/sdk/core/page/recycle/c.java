package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes8.dex */
public class c extends RecyclerView.ViewHolder {
    public final Presenter a;

    /* renamed from: b  reason: collision with root package name */
    public final e f54546b;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.f54546b = eVar;
        this.a = presenter;
        presenter.c(view);
    }
}
