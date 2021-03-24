package com.kwad.sdk.contentalliance.home.c.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RadiusPvFrameLayout;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.home.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    public RadiusPvFrameLayout f32738b;

    /* renamed from: c  reason: collision with root package name */
    public RadiusPvFrameLayout.a f32739c = new RadiusPvFrameLayout.a() { // from class: com.kwad.sdk.contentalliance.home.c.b.b.1
        @Override // com.kwad.sdk.widget.RadiusPvFrameLayout.a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        e.a((AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).i);
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32738b.a(this.f32739c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32738b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32738b = (RadiusPvFrameLayout) b(R.id.ksad_slide_profile_container);
    }
}
