package com.kwad.sdk.a.b;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.a.a.a {
    private AdTemplate b;
    private AdInfo c;
    private List<Integer> d;
    private com.kwad.sdk.contentalliance.detail.video.e e = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            com.kwad.sdk.core.report.b.i(c.this.b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            c.this.a(j2);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (!c.this.b.mPvReported) {
                c.this.f5425a.f5426a.onAdShow(null);
            }
            com.kwad.sdk.core.report.b.a(c.this.b, (JSONObject) null);
            com.kwad.sdk.core.report.b.h(c.this.b);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        if (this.d == null || this.d.isEmpty()) {
            return;
        }
        for (Integer num : this.d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.b.b(this.b, ceil, null);
                this.d.remove(num);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b = this.f5425a.d;
        this.c = com.kwad.sdk.core.response.b.c.j(this.b);
        this.d = com.kwad.sdk.core.response.b.a.M(this.c);
        this.f5425a.f.a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f5425a.f.b(this.e);
    }
}
