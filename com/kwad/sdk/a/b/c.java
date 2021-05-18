package com.kwad.sdk.a.b;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f31728b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f31729c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f31730d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31731e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            c.this.a(j2);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            if (!c.this.f31728b.mPvReported) {
                ((com.kwad.sdk.a.a.a) c.this).f31701a.f31702a.onAdShow(null);
            }
            com.kwad.sdk.core.report.b.a(c.this.f31728b, (JSONObject) null);
            com.kwad.sdk.core.report.b.h(c.this.f31728b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            com.kwad.sdk.core.report.b.i(c.this.f31728b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f31730d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f31730d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.b.b(this.f31728b, ceil, null);
                this.f31730d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31701a.f31705d;
        this.f31728b = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f31729c = g2;
        this.f31730d = com.kwad.sdk.core.response.b.a.I(g2);
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.a(this.f31731e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.b(this.f31731e);
    }
}
