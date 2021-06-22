package com.kwad.sdk.contentalliance.profile.tabvideo.a.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.profile.tabvideo.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33615b;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a).f36810i;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
        String g2 = com.kwad.sdk.core.response.b.d.g(k);
        if (ag.a(g2)) {
            g2 = com.kwad.sdk.core.response.b.d.d(k);
        }
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a).f36805d).a(g2).a((e<Drawable>) new com.kwad.sdk.c(g2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_tube_episode_cover_bg)).c(o().getResources().getDrawable(R.drawable.ksad_tube_episode_cover_bg)).a(this.f33615b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33615b = (ImageView) b(R.id.ksad_profile_video_img);
    }
}
