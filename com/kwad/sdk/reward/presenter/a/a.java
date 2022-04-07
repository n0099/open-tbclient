package com.kwad.sdk.reward.presenter.a;

import com.baidu.tieba.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.l;
import com.kwad.sdk.reward.presenter.a.kwai.c;
/* loaded from: classes5.dex */
public class a extends g {
    public AdInfo b;
    public AdTemplate c;
    public com.kwad.sdk.core.e.a d;
    public l.b e = new l.b(null, null) { // from class: com.kwad.sdk.reward.presenter.a.a.1
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
    /* loaded from: classes5.dex */
    public static class C0336a extends com.kwad.sdk.reward.presenter.a {
        public C0336a() {
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int e() {
            return R.id.obfuscated_res_0x7f09103e;
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            return 8;
        }
    }

    public a(com.kwad.sdk.core.e.a<?> aVar, AdTemplate adTemplate, boolean z) {
        this.c = adTemplate;
        this.d = aVar;
        this.b = d.j(adTemplate);
        if (z) {
            e();
        } else {
            i();
        }
    }

    private void e() {
        if (com.kwad.sdk.core.response.a.a.an(this.b)) {
            return;
        }
        if (com.kwad.sdk.core.response.a.b.j(this.c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.a());
        }
        c cVar = new c();
        cVar.a(this.e);
        a((Presenter) cVar);
        if (com.kwad.sdk.core.response.a.b.h(this.c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.d());
        }
        a(new C0336a());
        if (com.kwad.sdk.core.response.a.a.aG(this.b) || !com.kwad.sdk.core.response.a.a.q(this.b)) {
            return;
        }
        a(new com.kwad.sdk.reward.presenter.a.kwai.b());
    }

    private void i() {
        c cVar = new c();
        cVar.a(this.e);
        a((Presenter) cVar);
        if (com.kwad.sdk.core.response.a.b.h(this.c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.d());
        }
        if (d.s(this.c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.b());
        }
        if (com.kwad.sdk.core.response.a.b.j(this.c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.a());
        }
    }
}
