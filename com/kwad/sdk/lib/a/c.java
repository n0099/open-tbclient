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
import java.util.List;
/* loaded from: classes6.dex */
public abstract class c<PAGE, MODEL> extends KsFragment implements a.InterfaceC0422a, b<PAGE> {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f35928a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f35929b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f35930c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public RefreshLayout f35931d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35932e;

    /* renamed from: f  reason: collision with root package name */
    public a f35933f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.lib.a.a.b<PAGE, MODEL> f35934g;

    @NonNull
    private com.kwad.sdk.lib.a.a.b<PAGE, MODEL> k() {
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> f2 = f();
        f2.f35903e = this;
        f2.f35904f = this.f35929b;
        f2.k = this;
        f2.f35905g = c();
        com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> d2 = d();
        this.f35930c = d2;
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(d2);
        f2.f35906h = this.f35930c;
        f2.i = dVar;
        f2.j = this.f35931d;
        f2.l = h();
        return f2;
    }

    public abstract int a();

    public void a(@NonNull Presenter presenter) {
    }

    public abstract int b();

    public abstract com.kwad.sdk.lib.b.c<PAGE, MODEL> c();

    public abstract com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> d();

    @Override // com.kwad.sdk.lib.a.a.InterfaceC0422a
    @NonNull
    public final Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.lib.a.b.b(g()));
        if (this.f35932e) {
            presenter.a((Presenter) new com.kwad.sdk.lib.a.b.d());
        }
        presenter.a((Presenter) new com.kwad.sdk.lib.a.b.a());
        a(presenter);
        presenter.a((Presenter) new com.kwad.sdk.lib.a.b.c());
        return presenter;
    }

    public com.kwad.sdk.lib.a.a.b<PAGE, MODEL> f() {
        return new com.kwad.sdk.lib.a.a.b<>();
    }

    public boolean g() {
        return false;
    }

    public int h() {
        return 1;
    }

    public final RecyclerView i() {
        return this.f35929b;
    }

    public RefreshLayout j() {
        return null;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        List<com.kwad.sdk.contentalliance.a.c> list;
        super.onActivityCreated(bundle);
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f35934g;
        if (bVar == null || (list = bVar.f35902d) == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : list) {
            cVar.e();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        List<com.kwad.sdk.contentalliance.a.c> list;
        super.onActivityResult(i, i2, intent);
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f35934g;
        if (bVar == null || (list = bVar.f35902d) == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : list) {
            cVar.a(i, i2, intent);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f35933f = new a(this, this);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f35928a == null) {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(a(), viewGroup, false);
            this.f35928a = viewGroup2;
            this.f35929b = (RecyclerView) viewGroup2.findViewById(b());
            RefreshLayout j = j();
            this.f35931d = j;
            this.f35932e = j != null;
        }
        return this.f35928a;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        List<com.kwad.sdk.contentalliance.a.c> list;
        super.onDestroy();
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f35934g;
        if (bVar == null || (list = bVar.f35902d) == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : list) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        List<com.kwad.sdk.contentalliance.a.c> list;
        super.onDestroyView();
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f35934g;
        if (bVar == null || (list = bVar.f35902d) == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : list) {
            cVar.f();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        List<com.kwad.sdk.contentalliance.a.c> list;
        super.onPause();
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f35934g;
        if (bVar == null || (list = bVar.f35902d) == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : list) {
            cVar.d();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        List<com.kwad.sdk.contentalliance.a.c> list;
        super.onResume();
        com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f35934g;
        if (bVar == null || (list = bVar.f35902d) == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : list) {
            cVar.c();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f35933f != null) {
            com.kwad.sdk.lib.a.a.b<PAGE, MODEL> k = k();
            this.f35934g = k;
            this.f35933f.a(k);
        }
    }
}
