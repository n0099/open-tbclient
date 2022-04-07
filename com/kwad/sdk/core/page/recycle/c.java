package com.kwad.sdk.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class c extends RecyclerView.ViewHolder {
    public final Presenter a;
    public final e b;

    public c(View view2, Presenter presenter, e eVar) {
        super(view2);
        this.b = eVar;
        this.a = presenter;
        presenter.c(view2);
    }
}
