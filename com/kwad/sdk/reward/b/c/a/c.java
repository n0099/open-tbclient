package com.kwad.sdk.reward.b.c.a;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f33772b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.c.c f33773c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f33774d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.c.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0373a c0373a) {
            ((d) c.this).f33839a.f33562b.a();
        }
    };

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f33839a;
        AdTemplate adTemplate = aVar.f33566f;
        com.kwad.sdk.c.c cVar = aVar.l;
        this.f33773c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f33774d);
        com.kwad.sdk.c.c cVar2 = this.f33773c;
        FrameLayout frameLayout = this.f33772b;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f33839a;
        cVar2.a(frameLayout, aVar2.f33568h, adTemplate, aVar2.j, aVar2.f33565e);
        this.f33773c.a(((d) this).f33839a.f33567g);
        this.f33773c.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33772b = (FrameLayout) a(R.id.ksad_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.c.c cVar = this.f33773c;
        if (cVar != null) {
            cVar.g();
        }
    }
}
