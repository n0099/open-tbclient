package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public class c extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f34666a;

    /* renamed from: b  reason: collision with root package name */
    public final e f34667b;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.f34667b = eVar;
        this.f34666a = presenter;
        presenter.a(view);
    }
}
