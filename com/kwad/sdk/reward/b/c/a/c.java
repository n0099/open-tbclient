package com.kwad.sdk.reward.b.c.a;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f34527b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.c.c f34528c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f34529d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.c.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0386a c0386a) {
            ((d) c.this).f34594a.f34317b.a();
        }
    };

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f34594a;
        AdTemplate adTemplate = aVar.f34321f;
        com.kwad.sdk.c.c cVar = aVar.l;
        this.f34528c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f34529d);
        com.kwad.sdk.c.c cVar2 = this.f34528c;
        FrameLayout frameLayout = this.f34527b;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f34594a;
        cVar2.a(frameLayout, aVar2.f34323h, adTemplate, aVar2.j, aVar2.f34320e);
        this.f34528c.a(((d) this).f34594a.f34322g);
        this.f34528c.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34527b = (FrameLayout) a(R.id.ksad_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.c.c cVar = this.f34528c;
        if (cVar != null) {
            cVar.g();
        }
    }
}
