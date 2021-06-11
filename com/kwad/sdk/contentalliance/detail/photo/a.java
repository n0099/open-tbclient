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
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ae;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.a {

    /* renamed from: h  reason: collision with root package name */
    public int f32722h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f32723i;
    public DetailVideoView j;

    @Override // com.kwad.sdk.contentalliance.b
    public int b() {
        return R.layout.ksad_content_alliance_detail_photo_2;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public Presenter d() {
        int pageScene;
        com.kwad.sdk.contentalliance.detail.photo.b.a aVar;
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
            h hVar = this.f32472e;
            presenter.a((Presenter) new b(hVar != null && hVar.j));
        }
        if (!com.kwad.sdk.core.response.b.c.B(this.f32723i)) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.e.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.a.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.a.b());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.a.c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.a.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.a.b());
        h hVar2 = this.f32472e;
        if (hVar2 != null && hVar2.f33387i) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.a.a());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.b());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.d());
        }
        if (com.kwad.sdk.core.config.c.R()) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.newui.c.a());
        }
        h hVar3 = this.f32472e;
        if (hVar3 != null && ((pageScene = hVar3.k.getPageScene()) == 1 || pageScene == 12)) {
            if (com.kwad.sdk.core.config.c.ak()) {
                if (this.f32472e.f33387i && ae.a(getContext())) {
                    aVar = new com.kwad.sdk.contentalliance.detail.photo.b.a();
                    presenter.a((Presenter) aVar);
                }
            } else if (com.kwad.sdk.core.config.c.al()) {
                if (ae.c(getContext())) {
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.b.b());
                }
                if (this.f32472e.f33387i && ae.a(getContext())) {
                    aVar = new com.kwad.sdk.contentalliance.detail.photo.b.a();
                    presenter.a((Presenter) aVar);
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
        String str;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            str = "bundle is null";
        } else {
            this.f32722h = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
            Serializable serializable = getArguments().getSerializable("key_template");
            if (serializable instanceof AdTemplate) {
                this.f32723i = (AdTemplate) serializable;
                DetailVideoView detailVideoView = (DetailVideoView) this.f32433c.findViewById(R.id.ksad_video_player);
                this.j = detailVideoView;
                detailVideoView.setVideoInfo(this.f32723i.photoInfo.videoInfo);
                return this.f32433c;
            }
            str = "data is not instanceof AdTemplate:" + serializable;
        }
        com.kwad.sdk.core.d.a.d("DetailPhotoFragment", str);
        return this.f32433c;
    }

    @Override // com.kwad.sdk.contentalliance.detail.a, com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: p */
    public com.kwad.sdk.contentalliance.detail.c c() {
        com.kwad.sdk.contentalliance.detail.c cVar = new com.kwad.sdk.contentalliance.detail.c();
        cVar.k = this;
        cVar.f32713a = this.f32472e;
        cVar.l = this.f32471d;
        cVar.j = this.f32723i;
        cVar.f32721i = this.f32722h;
        com.kwad.sdk.contentalliance.detail.video.b bVar = new com.kwad.sdk.contentalliance.detail.video.b(this, this.f32471d, this.j, this.f32723i, this.f32722h);
        cVar.f32714b.add(bVar);
        cVar.f32715c.add(bVar.d());
        cVar.m = bVar;
        return cVar;
    }
}
