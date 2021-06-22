package com.kwad.sdk.feed.a.a.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RCPVFrameLayout;
import com.kwad.sdk.widget.a;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public RCPVFrameLayout f35607b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0442a f35608c = new a.InterfaceC0442a() { // from class: com.kwad.sdk.feed.a.a.b.d.1
        @Override // com.kwad.sdk.widget.a.InterfaceC0442a
        public void a() {
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.e.a((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a).f36810i);
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f35607b.setVisibleListener(this.f35608c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35607b.setVisibleListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35607b = (RCPVFrameLayout) b(R.id.ksad_feed_item_root);
    }
}
