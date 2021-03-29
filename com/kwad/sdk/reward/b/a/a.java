package com.kwad.sdk.reward.b.a;

import com.kwad.sdk.contentalliance.detail.a.c.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f36230b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f36231c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f36232d;

    /* renamed from: e  reason: collision with root package name */
    public c f36233e;

    /* renamed from: f  reason: collision with root package name */
    public long f36234f = 0;

    /* renamed from: g  reason: collision with root package name */
    public e f36235g = new f() { // from class: com.kwad.sdk.reward.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.h(a.this.f36230b, ((d) a.this).f36458a.f36220d);
            a.this.f36233e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            a.this.a(j2);
            a.this.f36234f = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            b.a(a.this.f36230b, ((d) a.this).f36458a.f36220d);
            b.g(a.this.f36230b, ((d) a.this).f36458a.f36220d);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            a.this.f36233e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            a.this.f36233e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void f() {
            super.f();
            a.this.f36233e.a();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void g() {
            super.g();
            a.this.f36233e.a();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f36232d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f36232d) {
            if (ceil >= num.intValue()) {
                b.b(this.f36230b, ceil, ((d) this).f36458a.f36220d);
                this.f36232d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f36233e = new c();
        AdTemplate adTemplate = ((d) this).f36458a.f36222f;
        this.f36230b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36231c = j;
        this.f36232d = com.kwad.sdk.core.response.b.a.M(j);
        ((d) this).f36458a.i.a(this.f36235g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36458a.i.b(this.f36235g);
        c.a c2 = this.f36233e.c();
        com.kwad.sdk.core.report.e.a(((d) this).f36458a.f36222f, this.f36234f, c2.b(), c2.a());
    }
}
