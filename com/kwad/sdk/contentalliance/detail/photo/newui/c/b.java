package com.kwad.sdk.contentalliance.detail.photo.newui.c;

import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.f.f;
import com.kwad.sdk.contentalliance.detail.photo.f.j;
import com.kwad.sdk.contentalliance.detail.photo.f.k;
import com.kwad.sdk.contentalliance.trends.view.c;
import com.kwad.sdk.contentalliance.trends.view.d;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f32997b;

    /* renamed from: c  reason: collision with root package name */
    public c f32998c = new d() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.c.b.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            b.this.f32997b.setVisibility(4);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            b.this.f32997b.setVisibility(0);
        }
    };

    public b(boolean z) {
        if (z && com.kwad.sdk.core.config.c.N()) {
            a((Presenter) new j(true));
        }
        a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.newui.d.a());
        if (com.kwad.sdk.core.config.c.f()) {
            a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.e.b());
        }
        if (com.kwad.sdk.core.config.c.j()) {
            a((Presenter) new f());
        }
        if (com.kwad.sdk.core.config.c.h()) {
            a((Presenter) new k());
        }
        if (z && com.kwad.sdk.core.config.c.O()) {
            a((Presenter) new j(false));
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j)) {
            ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.a(this.f32998c);
            if (((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32713a.l) {
                this.f32997b.setVisibility(4);
            }
        }
        this.f32997b.setPadding(0, 0, 0, ao.a(o(), 0.0f));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.b(this.f32998c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32997b = (LinearLayout) b(R.id.ksad_photo_detail_bottom_toolbar);
    }
}
