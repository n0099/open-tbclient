package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public class c extends RecyclerView.ViewHolder {
    public final Presenter a;

    /* renamed from: b  reason: collision with root package name */
    public final e f39661b;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.f39661b = eVar;
        this.a = presenter;
        presenter.c(view);
    }
}
