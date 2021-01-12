package com.kwad.sdk.lib.widget.recycler.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.c;
import com.kwad.sdk.lib.widget.recycler.b.a.C1137a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes4.dex */
public class a<MODEL, CallerContext extends C1137a<MODEL>> extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f10450a;

    /* renamed from: b  reason: collision with root package name */
    public final CallerContext f10451b;

    /* renamed from: com.kwad.sdk.lib.widget.recycler.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1137a<MODEL> {
        public KsFragment d;
        public RecyclerView e;
        public c<?, MODEL> f;
        public View g;
        public int h;
        public MODEL i;
    }

    public a(View view, Presenter presenter, CallerContext callercontext) {
        super(view);
        this.f10451b = callercontext;
        this.f10451b.g = view;
        this.f10450a = presenter;
        presenter.a(view);
    }
}
