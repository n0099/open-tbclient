package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes3.dex */
public class c extends RecyclerView.ViewHolder {
    public final Presenter a;

    /* renamed from: b  reason: collision with root package name */
    public final e f56029b;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.f56029b = eVar;
        this.a = presenter;
        presenter.c(view);
    }
}
