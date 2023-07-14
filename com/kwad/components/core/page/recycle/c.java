package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public final class c extends RecyclerView.ViewHolder {
    public final e Fz;
    public final Presenter mPresenter;

    public c(View view2, Presenter presenter, e eVar) {
        super(view2);
        this.Fz = eVar;
        this.mPresenter = presenter;
        presenter.B(view2);
    }
}
