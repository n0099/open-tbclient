package com.kwad.sdk.reward.b.a;

import com.kwad.sdk.contentalliance.detail.a.c.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f37062b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f37063c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f37064d;

    /* renamed from: e  reason: collision with root package name */
    public c f37065e;

    /* renamed from: f  reason: collision with root package name */
    public long f37066f = 0;

    /* renamed from: g  reason: collision with root package name */
    public e f37067g = new f() { // from class: com.kwad.sdk.reward.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.h(a.this.f37062b, ((d) a.this).f37299a.f37051d);
            a.this.f37065e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            a.this.a(j2);
            a.this.f37066f = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            b.a(a.this.f37062b, ((d) a.this).f37299a.f37051d);
            b.g(a.this.f37062b, ((d) a.this).f37299a.f37051d);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            a.this.f37065e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            a.this.f37065e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void f() {
            super.f();
            a.this.f37065e.a();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void g() {
            super.g();
            a.this.f37065e.a();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f37064d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f37064d) {
            if (ceil >= num.intValue()) {
                b.b(this.f37062b, ceil, ((d) this).f37299a.f37051d);
                this.f37064d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f37065e = new c();
        AdTemplate adTemplate = ((d) this).f37299a.f37053f;
        this.f37062b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37063c = j;
        this.f37064d = com.kwad.sdk.core.response.b.a.M(j);
        ((d) this).f37299a.f37056i.a(this.f37067g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f37299a.f37056i.b(this.f37067g);
        c.a c2 = this.f37065e.c();
        com.kwad.sdk.core.report.e.a(((d) this).f37299a.f37053f, this.f37066f, c2.b(), c2.a());
    }
}
