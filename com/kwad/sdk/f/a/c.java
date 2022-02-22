package com.kwad.sdk.f.a;

import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57016b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f57017c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f57018d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f57019e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f57020f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            c.this.a(j3);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            c.this.f57019e = false;
            if (!c.this.f57016b.mPvReported) {
                ((com.kwad.sdk.f.kwai.a) c.this).a.a.a((KsNativeAd) null);
            }
            com.kwad.sdk.core.report.a.a(c.this.f57016b, (JSONObject) null);
            com.kwad.sdk.core.report.a.i(c.this.f57016b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            if (c.this.f57019e) {
                return;
            }
            c.this.f57019e = true;
            com.kwad.sdk.core.report.d.a(c.this.f57016b, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            com.kwad.sdk.core.report.a.j(c.this.f57016b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.f57018d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f57018d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.f57016b, ceil, null);
                this.f57018d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f57071d;
        this.f57016b = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57017c = j2;
        this.f57018d = com.kwad.sdk.core.response.a.a.S(j2);
        ((com.kwad.sdk.f.kwai.a) this).a.f57073f.a(this.f57020f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f57073f.b(this.f57020f);
    }
}
