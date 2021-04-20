package com.kwad.sdk.lib.widget.recycler.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.c;
import com.kwad.sdk.lib.widget.recycler.b.a.C0442a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class a<MODEL, CallerContext extends C0442a<MODEL>> extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Presenter f36290a;

    /* renamed from: b  reason: collision with root package name */
    public final CallerContext f36291b;

    /* renamed from: com.kwad.sdk.lib.widget.recycler.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0442a<MODEL> {

        /* renamed from: d  reason: collision with root package name */
        public KsFragment f36292d;

        /* renamed from: e  reason: collision with root package name */
        public RecyclerView f36293e;

        /* renamed from: f  reason: collision with root package name */
        public c<?, MODEL> f36294f;

        /* renamed from: g  reason: collision with root package name */
        public View f36295g;

        /* renamed from: h  reason: collision with root package name */
        public int f36296h;
        public MODEL i;
    }

    public a(View view, Presenter presenter, CallerContext callercontext) {
        super(view);
        this.f36291b = callercontext;
        callercontext.f36295g = view;
        this.f36290a = presenter;
        presenter.a(view);
    }
}
