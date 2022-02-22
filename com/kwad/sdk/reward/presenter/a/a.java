package com.kwad.sdk.reward.presenter.a;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.l;
import com.kwad.sdk.reward.presenter.a.kwai.c;
/* loaded from: classes4.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f57563b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f57564c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.e.a f57565d;

    /* renamed from: e  reason: collision with root package name */
    public l.b f57566e = new l.b(null, null) { // from class: com.kwad.sdk.reward.presenter.a.a.1
        @Override // com.kwad.sdk.reward.l.b, com.kwad.sdk.reward.l.a
        public void b() {
            super.b();
            a.this.h();
        }

        @Override // com.kwad.sdk.reward.l.b, com.kwad.sdk.reward.l.a
        public void c() {
            super.c();
            ((g) a.this).a.a(a.this.q(), 15, 1);
        }

        @Override // com.kwad.sdk.reward.l.b, com.kwad.sdk.reward.l.a
        public void d() {
            super.d();
            ((g) a.this).a.a(a.this.q(), 17, 2);
        }
    };

    /* renamed from: com.kwad.sdk.reward.presenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2156a extends com.kwad.sdk.reward.presenter.a {
        public C2156a() {
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int e() {
            return R.id.ksad_blur_end_cover;
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            return 8;
        }
    }

    public a(com.kwad.sdk.core.e.a<?> aVar, AdTemplate adTemplate, boolean z) {
        this.f57564c = adTemplate;
        this.f57565d = aVar;
        this.f57563b = d.j(adTemplate);
        if (z) {
            e();
        } else {
            i();
        }
    }

    private void e() {
        if (com.kwad.sdk.core.response.a.a.an(this.f57563b)) {
            return;
        }
        if (com.kwad.sdk.core.response.a.b.j(this.f57564c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.a());
        }
        c cVar = new c();
        cVar.a(this.f57566e);
        a((Presenter) cVar);
        if (com.kwad.sdk.core.response.a.b.h(this.f57564c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.d());
        }
        a(new C2156a());
        if (com.kwad.sdk.core.response.a.a.aG(this.f57563b) || !com.kwad.sdk.core.response.a.a.q(this.f57563b)) {
            return;
        }
        a(new com.kwad.sdk.reward.presenter.a.kwai.b());
    }

    private void i() {
        c cVar = new c();
        cVar.a(this.f57566e);
        a((Presenter) cVar);
        if (com.kwad.sdk.core.response.a.b.h(this.f57564c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.d());
        }
        if (d.s(this.f57564c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.b());
        }
        if (com.kwad.sdk.core.response.a.b.j(this.f57564c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.a());
        }
    }
}
