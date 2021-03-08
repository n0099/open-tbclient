package com.kwad.sdk.lib.widget.recycler.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.c;
import com.kwad.sdk.lib.widget.recycler.b.a.C1160a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes3.dex */
public class a<MODEL, CallerContext extends C1160a<MODEL>> extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f6891a;
    public final CallerContext b;

    /* renamed from: com.kwad.sdk.lib.widget.recycler.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1160a<MODEL> {
        public KsFragment d;
        public RecyclerView e;
        public c<?, MODEL> f;
        public View g;
        public int h;
        public MODEL i;
    }

    public a(View view, Presenter presenter, CallerContext callercontext) {
        super(view);
        this.b = callercontext;
        this.b.g = view;
        this.f6891a = presenter;
        presenter.a(view);
    }
}
