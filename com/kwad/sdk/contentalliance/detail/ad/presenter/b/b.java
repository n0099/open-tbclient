package com.kwad.sdk.contentalliance.detail.ad.presenter.b;

import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f32383b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f32384c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f32385d;

    /* renamed from: e  reason: collision with root package name */
    public e f32386e = new f() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.this.f();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            b.this.a(j2);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            b.this.e();
            com.kwad.sdk.core.report.b.a(b.this.f32383b, (JSONObject) null);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f32385d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f32385d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.b.b(this.f32383b, ceil, null);
                this.f32385d.remove(num);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.h(this.f32383b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.b.i(this.f32383b);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j;
        this.f32383b = adTemplate;
        AdInfo j = c.j(adTemplate);
        this.f32384c = j;
        this.f32385d = com.kwad.sdk.core.response.b.a.M(j);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.m;
        if (bVar != null) {
            bVar.a(this.f32386e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.m;
        if (bVar != null) {
            bVar.b(this.f32386e);
        }
    }
}
