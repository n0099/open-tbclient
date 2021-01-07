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
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.contentalliance.detail.a {
    private int h;
    private AdTemplate i;
    private DetailVideoView j;

    @Override // com.kwad.sdk.contentalliance.b
    protected int b() {
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
        if (this.e != null && this.e.i) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.ad.presenter.a());
        }
        if (com.kwad.sdk.core.config.c.e()) {
            presenter.a((Presenter) new b(this.e != null && this.e.j));
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
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            com.kwad.sdk.core.d.a.d("DetailAdFragment", "bundle is null");
            return this.c;
        }
        this.h = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
        Serializable serializable = getArguments().getSerializable("key_template");
        if (!(serializable instanceof AdTemplate)) {
            com.kwad.sdk.core.d.a.d("DetailAdFragment", "data is not instanceof AdTemplate:" + serializable);
            return this.c;
        }
        this.i = (AdTemplate) serializable;
        this.j = (DetailVideoView) this.c.findViewById(R.id.ksad_video_player);
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: p */
    public com.kwad.sdk.contentalliance.detail.c c() {
        com.kwad.sdk.contentalliance.detail.c cVar = new com.kwad.sdk.contentalliance.detail.c();
        cVar.k = this;
        cVar.f8702a = this.e;
        cVar.l = this.d;
        cVar.j = this.i;
        cVar.i = this.h;
        if (com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.i))) {
            cVar.o = new com.kwad.sdk.core.download.b.b(this.i);
        }
        if (com.kwad.sdk.core.response.b.b.p(this.i)) {
            cVar.p = new com.kwad.sdk.c.c();
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = new com.kwad.sdk.contentalliance.detail.video.b(this, this.d, this.j, this.i, this.h);
        cVar.f8703b.add(bVar);
        cVar.c.add(bVar.d());
        cVar.m = bVar;
        return cVar;
    }
}
