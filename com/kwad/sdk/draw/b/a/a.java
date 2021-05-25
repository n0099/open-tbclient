package com.kwad.sdk.draw.b.a;

import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f33067b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f33068c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f33069d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33070e = false;

    /* renamed from: f  reason: collision with root package name */
    public d f33071f = new e() { // from class: com.kwad.sdk.draw.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            super.a(i2, i3);
            if (((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            a.this.a(j2);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            if (!a.this.f33067b.mPvReported && ((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a != null) {
                ((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a.onAdShow();
            }
            if (((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                a.this.f33070e = false;
            }
            b.a(a.this.f33067b, (JSONObject) null);
            b.h(a.this.f33067b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (a.this.f33070e) {
                a.this.f33070e = false;
                if (((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a != null) {
                    try {
                        ((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a.onVideoPlayResume();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.a.b(th);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            if (((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
            a.this.f33070e = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            b.i(a.this.f33067b);
            if (((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f33049a.f33050a.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f33069d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f33069d) {
            if (ceil >= num.intValue()) {
                b.b(this.f33067b, ceil, null);
                this.f33069d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f33049a.f33052c;
        this.f33067b = adTemplate;
        AdInfo g2 = c.g(adTemplate);
        this.f33068c = g2;
        this.f33069d = com.kwad.sdk.core.response.b.a.I(g2);
        ((com.kwad.sdk.draw.a.a) this).f33049a.f33054e.a(this.f33071f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.a.a) this).f33049a.f33054e.b(this.f33071f);
    }
}
