package com.kwad.sdk.contentalliance.detail.photo.related.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RadiusPvFrameLayout;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.detail.photo.related.a.a {

    /* renamed from: b  reason: collision with root package name */
    public RadiusPvFrameLayout f32486b;

    /* renamed from: c  reason: collision with root package name */
    public RadiusPvFrameLayout.a f32487c = new RadiusPvFrameLayout.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.b.c.1
        @Override // com.kwad.sdk.widget.RadiusPvFrameLayout.a
        public void a() {
            c.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        e.c((AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a).i, "related_video_list");
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32486b.a(this.f32487c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32486b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32486b = (RadiusPvFrameLayout) b(R.id.ksad_related_video_item_root);
    }
}
