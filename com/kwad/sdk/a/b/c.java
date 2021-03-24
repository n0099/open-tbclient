package com.kwad.sdk.a.b;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f31690b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f31691c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f31692d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31693e = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            com.kwad.sdk.core.report.b.i(c.this.f31690b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            c.this.a(j2);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (!c.this.f31690b.mPvReported) {
                ((com.kwad.sdk.a.a.a) c.this).f31664a.f31665a.onAdShow(null);
            }
            com.kwad.sdk.core.report.b.a(c.this.f31690b, (JSONObject) null);
            com.kwad.sdk.core.report.b.h(c.this.f31690b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f31692d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f31692d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.b.b(this.f31690b, ceil, null);
                this.f31692d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31664a.f31668d;
        this.f31690b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f31691c = j;
        this.f31692d = com.kwad.sdk.core.response.b.a.M(j);
        ((com.kwad.sdk.a.a.a) this).f31664a.f31670f.a(this.f31693e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31664a.f31670f.b(this.f31693e);
    }
}
