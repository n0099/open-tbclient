package com.kwad.sdk.contentalliance.detail.photo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.a.c;
import com.kwad.sdk.contentalliance.detail.photo.e.d;
import com.kwad.sdk.contentalliance.detail.photo.e.e;
import com.kwad.sdk.contentalliance.detail.photo.newui.c.b;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ae;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.contentalliance.detail.a {
    private int h;
    private AdTemplate i;
    private DetailVideoView j;

    @Override // com.kwad.sdk.contentalliance.b
    protected int b() {
        return R.layout.ksad_content_alliance_detail_photo_2;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public Presenter d() {
        int pageScene;
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.c.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.a());
        presenter.a((Presenter) new e());
        presenter.a((Presenter) new d());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.e.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.e());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.b.a());
        if (com.kwad.sdk.core.config.c.e()) {
            presenter.a((Presenter) new b(this.e != null && this.e.j));
        }
        if (!com.kwad.sdk.core.response.b.c.B(this.i)) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.e.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.a.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.a.b());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.a.c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.a.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.a.b());
        if (this.e != null && this.e.i) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.a.a());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.b());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.d());
        }
        if (com.kwad.sdk.core.config.c.R()) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.newui.c.a());
        }
        if (this.e != null && ((pageScene = this.e.k.getPageScene()) == 1 || pageScene == 12)) {
            if (com.kwad.sdk.core.config.c.ak()) {
                if (this.e.i && ae.a(getContext())) {
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.b.a());
                }
            } else if (com.kwad.sdk.core.config.c.al()) {
                if (ae.c(getContext())) {
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.b.b());
                }
                if (this.e.i && ae.a(getContext())) {
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.b.a());
                }
            }
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
            com.kwad.sdk.core.d.a.d("DetailPhotoFragment", "bundle is null");
            return this.c;
        }
        this.h = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
        Serializable serializable = getArguments().getSerializable("key_template");
        if (!(serializable instanceof AdTemplate)) {
            com.kwad.sdk.core.d.a.d("DetailPhotoFragment", "data is not instanceof AdTemplate:" + serializable);
            return this.c;
        }
        this.i = (AdTemplate) serializable;
        this.j = (DetailVideoView) this.c.findViewById(R.id.ksad_video_player);
        this.j.setVideoInfo(this.i.photoInfo.videoInfo);
        return this.c;
    }

    @Override // com.kwad.sdk.contentalliance.detail.a, com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: p */
    public com.kwad.sdk.contentalliance.detail.c c() {
        com.kwad.sdk.contentalliance.detail.c cVar = new com.kwad.sdk.contentalliance.detail.c();
        cVar.k = this;
        cVar.f8402a = this.e;
        cVar.l = this.d;
        cVar.j = this.i;
        cVar.i = this.h;
        com.kwad.sdk.contentalliance.detail.video.b bVar = new com.kwad.sdk.contentalliance.detail.video.b(this, this.d, this.j, this.i, this.h);
        cVar.f8403b.add(bVar);
        cVar.c.add(bVar.d());
        cVar.m = bVar;
        return cVar;
    }
}
