package com.kwad.sdk.a.b;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f32233b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f32234c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f32235d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32236e = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            com.kwad.sdk.core.report.b.i(c.this.f32233b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            c.this.a(j2);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (!c.this.f32233b.mPvReported) {
                ((com.kwad.sdk.a.a.a) c.this).f32206a.f32207a.onAdShow(null);
            }
            com.kwad.sdk.core.report.b.a(c.this.f32233b, (JSONObject) null);
            com.kwad.sdk.core.report.b.h(c.this.f32233b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f32235d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f32235d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.b.b(this.f32233b, ceil, null);
                this.f32235d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f32206a.f32210d;
        this.f32233b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f32234c = j;
        this.f32235d = com.kwad.sdk.core.response.b.a.M(j);
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.a(this.f32236e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.b(this.f32236e);
    }
}
