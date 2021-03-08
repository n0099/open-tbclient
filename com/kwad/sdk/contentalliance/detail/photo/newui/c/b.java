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
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    private LinearLayout b;
    private c c = new d() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.c.b.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            b.this.b.setVisibility(4);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            b.this.b.setVisibility(0);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (com.kwad.sdk.core.response.b.c.B(this.f5594a.j)) {
            this.f5594a.a(this.c);
            if (this.f5594a.f5600a.l) {
                this.b.setVisibility(4);
            }
        }
        this.b.setPadding(0, 0, 0, ao.a(o(), 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f5594a.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (LinearLayout) b(R.id.ksad_photo_detail_bottom_toolbar);
    }
}
