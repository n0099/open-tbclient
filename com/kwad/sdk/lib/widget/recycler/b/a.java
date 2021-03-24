package com.kwad.sdk.lib.widget.recycler.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.c;
import com.kwad.sdk.lib.widget.recycler.b.a.C0427a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class a<MODEL, CallerContext extends C0427a<MODEL>> extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f36000a;

    /* renamed from: b  reason: collision with root package name */
    public final CallerContext f36001b;

    /* renamed from: com.kwad.sdk.lib.widget.recycler.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0427a<MODEL> {

        /* renamed from: d  reason: collision with root package name */
        public KsFragment f36002d;

        /* renamed from: e  reason: collision with root package name */
        public RecyclerView f36003e;

        /* renamed from: f  reason: collision with root package name */
        public c<?, MODEL> f36004f;

        /* renamed from: g  reason: collision with root package name */
        public View f36005g;

        /* renamed from: h  reason: collision with root package name */
        public int f36006h;
        public MODEL i;
    }

    public a(View view, Presenter presenter, CallerContext callercontext) {
        super(view);
        this.f36001b = callercontext;
        callercontext.f36005g = view;
        this.f36000a = presenter;
        presenter.a(view);
    }
}
