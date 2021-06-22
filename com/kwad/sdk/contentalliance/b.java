package com.kwad.sdk.contentalliance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public abstract class b<T extends com.kwad.sdk.core.e.b> extends KsFragment {

    /* renamed from: a  reason: collision with root package name */
    public Presenter f32529a;

    /* renamed from: b  reason: collision with root package name */
    public T f32530b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32531c;

    public void a() {
        Presenter presenter = this.f32529a;
        if (presenter != null) {
            presenter.j();
        }
        this.f32531c = null;
    }

    public abstract int b();

    public abstract T c();

    @NonNull
    public abstract Presenter d();

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f32530b = c();
        if (this.f32529a == null) {
            Presenter d2 = d();
            this.f32529a = d2;
            d2.a((View) this.f32531c);
        }
        this.f32529a.a(this.f32530b);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f32531c == null) {
            this.f32531c = (ViewGroup) layoutInflater.inflate(b(), viewGroup, false);
        }
        return this.f32531c;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        T t = this.f32530b;
        if (t != null) {
            t.a();
        }
        a();
    }
}
