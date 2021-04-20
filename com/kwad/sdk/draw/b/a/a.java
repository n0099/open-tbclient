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
    public AdTemplate f34829b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f34830c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f34831d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34832e = false;

    /* renamed from: f  reason: collision with root package name */
    public e f34833f = new f() { // from class: com.kwad.sdk.draw.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.i(a.this.f34829b);
            if (((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            super.a(i, i2);
            if (((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a.onVideoPlayError();
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
            if (!a.this.f34829b.mPvReported && ((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a != null) {
                ((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a.onAdShow();
            }
            if (((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                a.this.f34832e = false;
            }
            b.a(a.this.f34829b, (JSONObject) null);
            b.h(a.this.f34829b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            if (((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
            a.this.f34832e = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f34832e) {
                a.this.f34832e = false;
                if (((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a != null) {
                    try {
                        ((com.kwad.sdk.draw.a.a) a.this).f34811a.f34812a.onVideoPlayResume();
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
        List<Integer> list = this.f34831d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f34831d) {
            if (ceil >= num.intValue()) {
                b.b(this.f34829b, ceil, null);
                this.f34831d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f34811a.f34814c;
        this.f34829b = adTemplate;
        AdInfo j = c.j(adTemplate);
        this.f34830c = j;
        this.f34831d = com.kwad.sdk.core.response.b.a.M(j);
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34816e.a(this.f34833f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34816e.b(this.f34833f);
    }
}
