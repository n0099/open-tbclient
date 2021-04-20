package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class c extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f34226a;

    /* renamed from: b  reason: collision with root package name */
    public final e f34227b;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.f34227b = eVar;
        this.f34226a = presenter;
        presenter.a(view);
    }
}
