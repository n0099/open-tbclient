package com.kwad.sdk.contentalliance.profile.tabvideo.a.b;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.contentalliance.profile.tabvideo.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private TextView f9101b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f9101b.setText(ag.a(com.kwad.sdk.core.response.b.c.s((AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10752a).i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9101b = (TextView) b(R.id.ksad_profile_like_count);
    }
}
