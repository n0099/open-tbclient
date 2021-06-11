package com.kwad.sdk.draw.b.a;

import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35191b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f35192c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f35193d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35194e = false;

    /* renamed from: f  reason: collision with root package name */
    public e f35195f = new f() { // from class: com.kwad.sdk.draw.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.i(a.this.f35191b);
            if (((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            super.a(i2, i3);
            if (((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a.onVideoPlayError();
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
            if (!a.this.f35191b.mPvReported && ((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a != null) {
                ((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a.onAdShow();
            }
            if (((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                a.this.f35194e = false;
            }
            b.a(a.this.f35191b, (JSONObject) null);
            b.h(a.this.f35191b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            if (((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
            a.this.f35194e = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f35194e) {
                a.this.f35194e = false;
                if (((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a != null) {
                    try {
                        ((com.kwad.sdk.draw.a.a) a.this).f35173a.f35174a.onVideoPlayResume();
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
        List<Integer> list = this.f35193d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f35193d) {
            if (ceil >= num.intValue()) {
                b.b(this.f35191b, ceil, null);
                this.f35193d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f35173a.f35176c;
        this.f35191b = adTemplate;
        AdInfo j = c.j(adTemplate);
        this.f35192c = j;
        this.f35193d = com.kwad.sdk.core.response.b.a.M(j);
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35178e.a(this.f35195f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35178e.b(this.f35195f);
    }
}
