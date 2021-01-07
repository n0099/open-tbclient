package com.kwad.sdk.lib.widget.recycler.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.c;
import com.kwad.sdk.lib.widget.recycler.b.a.C1154a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class a<MODEL, CallerContext extends C1154a<MODEL>> extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f10750a;

    /* renamed from: b  reason: collision with root package name */
    public final CallerContext f10751b;

    /* renamed from: com.kwad.sdk.lib.widget.recycler.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1154a<MODEL> {
        public KsFragment d;
        public RecyclerView e;
        public c<?, MODEL> f;
        public View g;
        public int h;
        public MODEL i;
    }

    public a(View view, Presenter presenter, CallerContext callercontext) {
        super(view);
        this.f10751b = callercontext;
        this.f10751b.g = view;
        this.f10750a = presenter;
        presenter.a(view);
    }
}
