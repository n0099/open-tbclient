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
    public AdTemplate f36519b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f36520c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f36521d;

    /* renamed from: e  reason: collision with root package name */
    public c f36522e;

    /* renamed from: f  reason: collision with root package name */
    public long f36523f = 0;

    /* renamed from: g  reason: collision with root package name */
    public e f36524g = new f() { // from class: com.kwad.sdk.reward.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.h(a.this.f36519b, ((d) a.this).f36747a.f36509d);
            a.this.f36522e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            a.this.a(j2);
            a.this.f36523f = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            b.a(a.this.f36519b, ((d) a.this).f36747a.f36509d);
            b.g(a.this.f36519b, ((d) a.this).f36747a.f36509d);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            a.this.f36522e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            a.this.f36522e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void f() {
            super.f();
            a.this.f36522e.a();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void g() {
            super.g();
            a.this.f36522e.a();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f36521d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f36521d) {
            if (ceil >= num.intValue()) {
                b.b(this.f36519b, ceil, ((d) this).f36747a.f36509d);
                this.f36521d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f36522e = new c();
        AdTemplate adTemplate = ((d) this).f36747a.f36511f;
        this.f36519b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36520c = j;
        this.f36521d = com.kwad.sdk.core.response.b.a.M(j);
        ((d) this).f36747a.i.a(this.f36524g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36747a.i.b(this.f36524g);
        c.a c2 = this.f36522e.c();
        com.kwad.sdk.core.report.e.a(((d) this).f36747a.f36511f, this.f36523f, c2.b(), c2.a());
    }
}
