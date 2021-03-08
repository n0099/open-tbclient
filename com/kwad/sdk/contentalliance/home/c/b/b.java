package com.kwad.sdk.contentalliance.home.c.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RadiusPvFrameLayout;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.contentalliance.home.c.a.a {
    private RadiusPvFrameLayout b;
    private RadiusPvFrameLayout.a c = new RadiusPvFrameLayout.a() { // from class: com.kwad.sdk.contentalliance.home.c.b.b.1
        @Override // com.kwad.sdk.widget.RadiusPvFrameLayout.a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        e.a((AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) this.f6892a).i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (RadiusPvFrameLayout) b(R.id.ksad_slide_profile_container);
    }
}
