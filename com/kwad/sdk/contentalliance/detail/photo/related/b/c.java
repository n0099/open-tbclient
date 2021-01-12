package com.kwad.sdk.contentalliance.detail.photo.related.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RadiusPvFrameLayout;
/* loaded from: classes4.dex */
public class c extends com.kwad.sdk.contentalliance.detail.photo.related.a.a {

    /* renamed from: b  reason: collision with root package name */
    private RadiusPvFrameLayout f8578b;
    private RadiusPvFrameLayout.a c = new RadiusPvFrameLayout.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.b.c.1
        @Override // com.kwad.sdk.widget.RadiusPvFrameLayout.a
        public void a() {
            c.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        e.c((AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10452a).i, "related_video_list");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8578b.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8578b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8578b = (RadiusPvFrameLayout) b(R.id.ksad_related_video_item_root);
    }
}
