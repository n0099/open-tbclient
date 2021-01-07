package com.kwad.sdk.contentalliance.detail.photo.a;

import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f8715b;
    private com.kwad.sdk.contentalliance.trends.view.c c = new com.kwad.sdk.contentalliance.trends.view.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.c.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            c.this.f8715b.setVisibility(4);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            c.this.f8715b.setVisibility(0);
        }
    };

    public c() {
        a((Presenter) new com.kwad.sdk.contentalliance.detail.a.a.a());
        a((Presenter) new com.kwad.sdk.contentalliance.detail.a.a.b());
        a((Presenter) new com.kwad.sdk.contentalliance.detail.a.a.c());
        a((Presenter) new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (com.kwad.sdk.core.response.b.c.B(this.f8693a.j)) {
            this.f8693a.a(this.c);
            if (this.f8693a.f8702a.l) {
                this.f8715b.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8693a.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8715b = (LinearLayout) b(R.id.ksad_bottom_content_container);
    }
}
