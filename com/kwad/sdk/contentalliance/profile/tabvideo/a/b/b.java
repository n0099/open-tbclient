package com.kwad.sdk.contentalliance.profile.tabvideo.a.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.contentalliance.profile.tabvideo.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f9099b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).i;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
        String g = com.kwad.sdk.core.response.b.d.g(k);
        String d = ag.a(g) ? com.kwad.sdk.core.response.b.d.d(k) : g;
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).d).a(d).a((e<Drawable>) new com.kwad.sdk.c(d, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_tube_episode_cover_bg)).c(o().getResources().getDrawable(R.drawable.ksad_tube_episode_cover_bg)).a(this.f9099b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9099b = (ImageView) b(R.id.ksad_profile_video_img);
    }
}
