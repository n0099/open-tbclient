package com.kwad.sdk.feed.a.a.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RCPVFrameLayout;
import com.kwad.sdk.widget.a;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public RCPVFrameLayout f35509b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0439a f35510c = new a.InterfaceC0439a() { // from class: com.kwad.sdk.feed.a.a.b.d.1
        @Override // com.kwad.sdk.widget.a.InterfaceC0439a
        public void a() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.e.a((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a).f36712i);
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f35509b.setVisibleListener(this.f35510c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35509b.setVisibleListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35509b = (RCPVFrameLayout) b(R.id.ksad_feed_item_root);
    }
}
