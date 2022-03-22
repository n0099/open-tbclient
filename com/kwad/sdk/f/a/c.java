package com.kwad.sdk.f.a;

import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f40420b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f40421c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f40422d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f40423e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40424f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            c.this.a(j2);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            c.this.f40423e = false;
            if (!c.this.f40420b.mPvReported) {
                ((com.kwad.sdk.f.kwai.a) c.this).a.a.a((KsNativeAd) null);
            }
            com.kwad.sdk.core.report.a.a(c.this.f40420b, (JSONObject) null);
            com.kwad.sdk.core.report.a.i(c.this.f40420b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            if (c.this.f40423e) {
                return;
            }
            c.this.f40423e = true;
            com.kwad.sdk.core.report.d.a(c.this.f40420b, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            com.kwad.sdk.core.report.a.j(c.this.f40420b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f40422d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f40422d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.f40420b, ceil, null);
                this.f40422d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f40469d;
        this.f40420b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f40421c = j;
        this.f40422d = com.kwad.sdk.core.response.a.a.S(j);
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.a(this.f40424f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.b(this.f40424f);
    }
}
