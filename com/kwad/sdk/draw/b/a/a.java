package com.kwad.sdk.draw.b.a;

import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f34924b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f34925c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f34926d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34927e = false;

    /* renamed from: f  reason: collision with root package name */
    public e f34928f = new f() { // from class: com.kwad.sdk.draw.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.i(a.this.f34924b);
            if (((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            super.a(i, i2);
            if (((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a.onVideoPlayError();
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
            if (!a.this.f34924b.mPvReported && ((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a != null) {
                ((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a.onAdShow();
            }
            if (((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                a.this.f34927e = false;
            }
            b.a(a.this.f34924b, (JSONObject) null);
            b.h(a.this.f34924b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            if (((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
            a.this.f34927e = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f34927e) {
                a.this.f34927e = false;
                if (((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a != null) {
                    try {
                        ((com.kwad.sdk.draw.a.a) a.this).f34906a.f34907a.onVideoPlayResume();
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
        List<Integer> list = this.f34926d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f34926d) {
            if (ceil >= num.intValue()) {
                b.b(this.f34924b, ceil, null);
                this.f34926d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f34906a.f34909c;
        this.f34924b = adTemplate;
        AdInfo j = c.j(adTemplate);
        this.f34925c = j;
        this.f34926d = com.kwad.sdk.core.response.b.a.M(j);
        ((com.kwad.sdk.draw.a.a) this).f34906a.f34911e.a(this.f34928f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f34906a.f34911e.b(this.f34928f);
    }
}
