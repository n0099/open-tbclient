package com.kwad.sdk.contentalliance.detail.ad.presenter.b;

import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private AdTemplate f8368b;
    private AdInfo c;
    private List<Integer> d;
    private e e = new f() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.b.1
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
            com.kwad.sdk.core.report.b.a(b.this.f8368b, (JSONObject) null);
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
                com.kwad.sdk.core.report.b.b(this.f8368b, ceil, null);
                this.d.remove(num);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.h(this.f8368b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.b.i(this.f8368b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8368b = this.f8393a.j;
        this.c = c.j(this.f8368b);
        this.d = com.kwad.sdk.core.response.b.a.M(this.c);
        if (this.f8393a.m != null) {
            this.f8393a.m.a(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f8393a.m != null) {
            this.f8393a.m.b(this.e);
        }
    }
}
