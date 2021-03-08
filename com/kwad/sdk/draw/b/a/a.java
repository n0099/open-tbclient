package com.kwad.sdk.draw.b.a;

import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.draw.a.a {
    private AdTemplate b;
    private AdInfo c;
    private List<Integer> d;
    private boolean e = false;
    private e f = new f() { // from class: com.kwad.sdk.draw.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.i(a.this.b);
            if (a.this.f6403a.f6404a != null) {
                try {
                    a.this.f6403a.f6404a.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            super.a(i, i2);
            if (a.this.f6403a.f6404a != null) {
                try {
                    a.this.f6403a.f6404a.onVideoPlayError();
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
            if (!a.this.b.mPvReported && a.this.f6403a.f6404a != null) {
                a.this.f6403a.f6404a.onAdShow();
            }
            if (a.this.f6403a.f6404a != null) {
                try {
                    a.this.f6403a.f6404a.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                a.this.e = false;
            }
            b.a(a.this.b, (JSONObject) null);
            b.h(a.this.b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            if (a.this.f6403a.f6404a != null) {
                try {
                    a.this.f6403a.f6404a.onVideoPlayPause();
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
                if (a.this.f6403a.f6404a != null) {
                    try {
                        a.this.f6403a.f6404a.onVideoPlayResume();
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
                b.b(this.b, ceil, null);
                this.d.remove(num);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b = this.f6403a.c;
        this.c = c.j(this.b);
        this.d = com.kwad.sdk.core.response.b.a.M(this.c);
        this.f6403a.e.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f6403a.e.b(this.f);
    }
}
