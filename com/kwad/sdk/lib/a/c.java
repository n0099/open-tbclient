package com.kwad.sdk.lib.a;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.lib.a.a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes4.dex */
public abstract class c<PAGE, MODEL> extends KsFragment implements a.InterfaceC1132a, b<PAGE> {

    /* renamed from: a  reason: collision with root package name */
    protected ViewGroup f10414a;

    /* renamed from: b  reason: collision with root package name */
    protected RecyclerView f10415b;
    protected com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> c;
    @Nullable
    private RefreshLayout d;
    private boolean e;
    private a f;
    private com.kwad.sdk.lib.a.a.b<PAGE, MODEL> g;

    @NonNull
    private com.kwad.sdk.lib.a.a.b<PAGE, MODEL> k() {
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> f = f();
        f.e = this;
        f.f = this.f10415b;
        f.k = this;
        f.g = c();
        this.c = d();
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(this.c);
        f.h = this.c;
        f.i = dVar;
        f.j = this.d;
        f.l = h();
        return f;
    }

    protected abstract int a();

    protected void a(@NonNull Presenter presenter) {
    }

    protected abstract int b();

    protected abstract com.kwad.sdk.lib.b.c<PAGE, MODEL> c();

    protected abstract com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> d();

    @Override // com.kwad.sdk.lib.a.a.InterfaceC1132a
    @NonNull
    public final Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.lib.a.b.b(g()));
        if (this.e) {
            presenter.a((Presenter) new com.kwad.sdk.lib.a.b.d());
        }
        presenter.a((Presenter) new com.kwad.sdk.lib.a.b.a());
        a(presenter);
        presenter.a((Presenter) new com.kwad.sdk.lib.a.b.c());
        return presenter;
    }

    protected com.kwad.sdk.lib.a.a.b<PAGE, MODEL> f() {
        return new com.kwad.sdk.lib.a.a.b<>();
    }

    protected boolean g() {
        return false;
    }

    protected int h() {
        return 1;
    }

    public final RecyclerView i() {
        return this.f10415b;
    }

    protected RefreshLayout j() {
        return null;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.g == null || this.g.d == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : this.g.d) {
            cVar.e();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.g == null || this.g.d == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : this.g.d) {
            cVar.a(i, i2, intent);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f = new a(this, this);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f10414a == null) {
            this.f10414a = (ViewGroup) layoutInflater.inflate(a(), viewGroup, false);
            this.f10415b = (RecyclerView) this.f10414a.findViewById(b());
            this.d = j();
            this.e = this.d != null;
        }
        return this.f10414a;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (this.g == null || this.g.d == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : this.g.d) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        if (this.g == null || this.g.d == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : this.g.d) {
            cVar.f();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        if (this.g == null || this.g.d == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : this.g.d) {
            cVar.d();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        if (this.g == null || this.g.d == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : this.g.d) {
            cVar.c();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f != null) {
            this.g = k();
            this.f.a(this.g);
        }
    }
}
