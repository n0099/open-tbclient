package com.kwad.sdk.contentalliance.profile.tabvideo;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.lib.widget.recycler.c<AdTemplate, com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b> {

    /* renamed from: c  reason: collision with root package name */
    public ProfileTabVideoParam f32922c;

    public b(com.kwad.sdk.lib.a.c<?, AdTemplate> cVar, RecyclerView recyclerView, ProfileTabVideoParam profileTabVideoParam) {
        super(cVar, recyclerView, new com.kwad.sdk.contentalliance.a());
        this.f32922c = profileTabVideoParam;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public View a(ViewGroup viewGroup, int i) {
        return ao.a(viewGroup, R.layout.ksad_profile_fragment_tab_video_item_layout, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: a */
    public com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b b() {
        return new com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b();
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public Presenter a(int i) {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.a.b.b());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.a.b.c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.a.b.d());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.a.b.a());
        return presenter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b bVar, int i) {
        super.a((b) bVar, i);
        bVar.f32915a = this.f32922c;
    }
}
