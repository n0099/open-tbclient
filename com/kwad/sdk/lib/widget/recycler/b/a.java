package com.kwad.sdk.lib.widget.recycler.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.c;
import com.kwad.sdk.lib.widget.recycler.b.a.C0428a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class a<MODEL, CallerContext extends C0428a<MODEL>> extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f36001a;

    /* renamed from: b  reason: collision with root package name */
    public final CallerContext f36002b;

    /* renamed from: com.kwad.sdk.lib.widget.recycler.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0428a<MODEL> {

        /* renamed from: d  reason: collision with root package name */
        public KsFragment f36003d;

        /* renamed from: e  reason: collision with root package name */
        public RecyclerView f36004e;

        /* renamed from: f  reason: collision with root package name */
        public c<?, MODEL> f36005f;

        /* renamed from: g  reason: collision with root package name */
        public View f36006g;

        /* renamed from: h  reason: collision with root package name */
        public int f36007h;
        public MODEL i;
    }

    public a(View view, Presenter presenter, CallerContext callercontext) {
        super(view);
        this.f36002b = callercontext;
        callercontext.f36006g = view;
        this.f36001a = presenter;
        presenter.a(view);
    }
}
