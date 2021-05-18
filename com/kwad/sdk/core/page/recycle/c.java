package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class c extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f32547a;

    /* renamed from: b  reason: collision with root package name */
    public final e f32548b;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.f32548b = eVar;
        this.f32547a = presenter;
        presenter.a(view);
    }
}
