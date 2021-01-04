package com.kwad.sdk.contentalliance.profile.tabvideo.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.contentalliance.profile.tabvideo.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private View f9101b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (com.kwad.sdk.core.response.b.c.z((AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).i) == ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).f9096a.mCurrentPhotoId) {
            this.f9101b.setVisibility(0);
        } else {
            this.f9101b.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9101b = b(R.id.ksad_profile_watched_tip);
    }
}
