package com.kwad.sdk.contentalliance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.h.d;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes4.dex */
public abstract class a<T extends com.kwad.sdk.core.e.b> extends d {
    public Presenter a;

    /* renamed from: b  reason: collision with root package name */
    public T f55762b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f55763c;

    public void a() {
        Presenter presenter = this.a;
        if (presenter != null) {
            presenter.k();
        }
        this.f55763c = null;
    }

    public abstract int b();

    public abstract T c();

    @NonNull
    public abstract Presenter d();

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f55762b = c();
        if (this.a == null) {
            Presenter d2 = d();
            this.a = d2;
            d2.c(this.f55763c);
        }
        this.a.a(this.f55762b);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f55763c == null) {
            this.f55763c = (ViewGroup) layoutInflater.inflate(b(), viewGroup, false);
        }
        return this.f55763c;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        T t = this.f55762b;
        if (t != null) {
            t.a();
        }
        a();
    }
}
