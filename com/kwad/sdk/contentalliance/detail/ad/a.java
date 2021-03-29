package com.kwad.sdk.contentalliance.detail.ad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.a.c;
import com.kwad.sdk.contentalliance.detail.a.e;
import com.kwad.sdk.contentalliance.detail.photo.newui.c.b;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.a {

    /* renamed from: h  reason: collision with root package name */
    public int f32045h;
    public AdTemplate i;
    public DetailVideoView j;

    @Override // com.kwad.sdk.contentalliance.b
    public int b() {
        return R.layout.ksad_content_alliance_detail_ad_2;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public Presenter d() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.ad.presenter.b.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.a());
        presenter.a((Presenter) new e());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.b.a());
        h hVar = this.f31924e;
        if (hVar != null && hVar.i) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.ad.presenter.a());
        }
        if (com.kwad.sdk.core.config.c.e()) {
            h hVar2 = this.f31924e;
            presenter.a((Presenter) new b(hVar2 != null && hVar2.j));
        }
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.ad.presenter.a.c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.ad.presenter.b());
        if (com.kwad.sdk.core.config.c.C()) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.e.a());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.sdk.contentalliance.detail.a, com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        String str;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            str = "bundle is null";
        } else {
            this.f32045h = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
            Serializable serializable = getArguments().getSerializable("key_template");
            if (serializable instanceof AdTemplate) {
                this.i = (AdTemplate) serializable;
                this.j = (DetailVideoView) this.f31886c.findViewById(R.id.ksad_video_player);
                return this.f31886c;
            }
            str = "data is not instanceof AdTemplate:" + serializable;
        }
        com.kwad.sdk.core.d.a.d("DetailAdFragment", str);
        return this.f31886c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: p */
    public com.kwad.sdk.contentalliance.detail.c c() {
        com.kwad.sdk.contentalliance.detail.c cVar = new com.kwad.sdk.contentalliance.detail.c();
        cVar.k = this;
        cVar.f32152a = this.f31924e;
        cVar.l = this.f31923d;
        AdTemplate adTemplate = this.i;
        cVar.j = adTemplate;
        cVar.i = this.f32045h;
        if (com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(adTemplate))) {
            cVar.o = new com.kwad.sdk.core.download.b.b(this.i);
        }
        if (com.kwad.sdk.core.response.b.b.p(this.i)) {
            cVar.p = new com.kwad.sdk.c.c();
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = new com.kwad.sdk.contentalliance.detail.video.b(this, this.f31923d, this.j, this.i, this.f32045h);
        cVar.f32153b.add(bVar);
        cVar.f32154c.add(bVar.d());
        cVar.m = bVar;
        return cVar;
    }
}
