package com.kwad.sdk.contentalliance.detail.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.detail.a.c;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.a {

    /* renamed from: h  reason: collision with root package name */
    public int f32134h;
    public AdTemplate i;
    public b j;
    public KsContentPage.SubShowItem k;

    public void a(b bVar) {
        this.j = bVar;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int b() {
        return R.layout.ksad_fragment_empty_container;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public Presenter d() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.c.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.b.a.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.b.a.b());
        return presenter;
    }

    @Override // com.kwad.sdk.contentalliance.detail.a, com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return this.f31886c;
        }
        this.f32134h = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
        Serializable serializable = getArguments().getSerializable("key_template");
        if (serializable instanceof AdTemplate) {
            this.i = (AdTemplate) serializable;
            if (this.j == null) {
                this.j = new b();
            }
            this.k = this.j.a(this.i);
            this.f31886c.removeAllViews();
            KsContentPage.SubShowItem subShowItem = this.k;
            if (subShowItem != null) {
                View instantiateItem = subShowItem.instantiateItem();
                if (instantiateItem != null) {
                    if (instantiateItem.getParent() != null) {
                        ((ViewGroup) instantiateItem.getParent()).removeView(instantiateItem);
                    }
                    this.f31886c.addView(instantiateItem);
                } else {
                    e.i(this.i);
                }
            }
            return this.f31886c;
        }
        return this.f31886c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: p */
    public com.kwad.sdk.contentalliance.detail.c c() {
        com.kwad.sdk.contentalliance.detail.c cVar = new com.kwad.sdk.contentalliance.detail.c();
        cVar.k = this;
        cVar.f32152a = this.f31924e;
        cVar.j = this.i;
        cVar.i = this.f32134h;
        cVar.q = this.j;
        cVar.l = this.f31923d;
        return cVar;
    }
}
