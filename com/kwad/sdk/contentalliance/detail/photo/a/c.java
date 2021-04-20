package com.kwad.sdk.contentalliance.detail.photo.a;

import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f32468b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.c f32469c = new com.kwad.sdk.contentalliance.trends.view.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.c.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            c.this.f32468b.setVisibility(4);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            c.this.f32468b.setVisibility(0);
        }
    };

    public c() {
        a((Presenter) new com.kwad.sdk.contentalliance.detail.a.a.a());
        a((Presenter) new com.kwad.sdk.contentalliance.detail.a.a.b());
        a((Presenter) new com.kwad.sdk.contentalliance.detail.a.a.c());
        a((Presenter) new d());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j)) {
            ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.a(this.f32469c);
            if (((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32441a.l) {
                this.f32468b.setVisibility(4);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.b(this.f32469c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32468b = (LinearLayout) b(R.id.ksad_bottom_content_container);
    }
}
