package com.kwad.sdk.contentalliance.profile.tabvideo.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.profile.tabvideo.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public View f33210b;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33210b.setVisibility(com.kwad.sdk.core.response.b.c.z((AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i) == ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).f33204a.mCurrentPhotoId ? 0 : 8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33210b = b(R.id.ksad_profile_watched_tip);
    }
}
