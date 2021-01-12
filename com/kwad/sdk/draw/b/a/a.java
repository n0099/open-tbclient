package com.kwad.sdk.draw.b.a;

import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    private AdTemplate f9682b;
    private AdInfo c;
    private List<Integer> d;
    private boolean e = false;
    private e f = new f() { // from class: com.kwad.sdk.draw.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.i(a.this.f9682b);
            if (a.this.f9673a.f9674a != null) {
                try {
                    a.this.f9673a.f9674a.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            super.a(i, i2);
            if (a.this.f9673a.f9674a != null) {
                try {
                    a.this.f9673a.f9674a.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            a.this.a(j2);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (!a.this.f9682b.mPvReported && a.this.f9673a.f9674a != null) {
                a.this.f9673a.f9674a.onAdShow();
            }
            if (a.this.f9673a.f9674a != null) {
                try {
                    a.this.f9673a.f9674a.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                a.this.e = false;
            }
            b.a(a.this.f9682b, (JSONObject) null);
            b.h(a.this.f9682b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            if (a.this.f9673a.f9674a != null) {
                try {
                    a.this.f9673a.f9674a.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
            a.this.e = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.e) {
                a.this.e = false;
                if (a.this.f9673a.f9674a != null) {
                    try {
                        a.this.f9673a.f9674a.onVideoPlayResume();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.a.b(th);
                    }
                }
            }
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
                b.b(this.f9682b, ceil, null);
                this.d.remove(num);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f9682b = this.f9673a.c;
        this.c = c.j(this.f9682b);
        this.d = com.kwad.sdk.core.response.b.a.M(this.c);
        this.f9673a.e.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9673a.e.b(this.f);
    }
}
