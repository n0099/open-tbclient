package com.kwad.sdk.contentalliance.detail.photo.related;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.lib.widget.recycler.c<AdTemplate, com.kwad.sdk.contentalliance.detail.photo.related.a.b> {

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32480c;

    public b(KsFragment ksFragment, RecyclerView recyclerView, AdTemplate adTemplate) {
        super(ksFragment, recyclerView, new com.kwad.sdk.contentalliance.a());
        this.f32480c = adTemplate;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public View a(ViewGroup viewGroup, int i) {
        return ao.a(viewGroup, R.layout.ksad_content_related_video_item, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: a */
    public com.kwad.sdk.contentalliance.detail.photo.related.a.b b() {
        return new com.kwad.sdk.contentalliance.detail.photo.related.a.b();
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public Presenter a(int i) {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.related.b.b());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.related.b.c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.related.b.d());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.related.b.a());
        return presenter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.contentalliance.detail.photo.related.a.b bVar, int i) {
        super.a((b) bVar, i);
        bVar.f32479a = this.f32480c;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public boolean a(boolean z, boolean z2) {
        return z && !z2;
    }
}
