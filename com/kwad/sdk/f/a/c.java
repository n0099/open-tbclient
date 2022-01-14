package com.kwad.sdk.f.a;

import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f56804b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f56805c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f56806d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f56807e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56808f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            c.this.a(j3);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            c.this.f56807e = false;
            if (!c.this.f56804b.mPvReported) {
                ((com.kwad.sdk.f.kwai.a) c.this).a.a.a((KsNativeAd) null);
            }
            com.kwad.sdk.core.report.a.a(c.this.f56804b, (JSONObject) null);
            com.kwad.sdk.core.report.a.i(c.this.f56804b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            if (c.this.f56807e) {
                return;
            }
            c.this.f56807e = true;
            com.kwad.sdk.core.report.d.a(c.this.f56804b, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            com.kwad.sdk.core.report.a.j(c.this.f56804b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.f56806d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f56806d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.f56804b, ceil, null);
                this.f56806d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f56859d;
        this.f56804b = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f56805c = j2;
        this.f56806d = com.kwad.sdk.core.response.a.a.S(j2);
        ((com.kwad.sdk.f.kwai.a) this).a.f56861f.a(this.f56808f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f56861f.b(this.f56808f);
    }
}
