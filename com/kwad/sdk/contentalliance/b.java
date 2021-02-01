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
/* loaded from: classes3.dex */
public abstract class b<T extends com.kwad.sdk.core.e.b> extends KsFragment {

    /* renamed from: a  reason: collision with root package name */
    protected Presenter f8265a;

    /* renamed from: b  reason: collision with root package name */
    protected T f8266b;
    protected ViewGroup c;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.f8265a != null) {
            this.f8265a.j();
        }
        this.c = null;
    }

    protected abstract int b();

    protected abstract T c();

    @NonNull
    public abstract Presenter d();

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f8266b = c();
        if (this.f8265a == null) {
            this.f8265a = d();
            this.f8265a.a((View) this.c);
        }
        this.f8265a.a(this.f8266b);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.c == null) {
            this.c = (ViewGroup) layoutInflater.inflate(b(), viewGroup, false);
        }
        return this.c;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f8266b != null) {
            this.f8266b.a();
        }
        a();
    }
}
