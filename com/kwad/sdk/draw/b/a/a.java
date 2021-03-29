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
    public AdTemplate f34540b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f34541c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f34542d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34543e = false;

    /* renamed from: f  reason: collision with root package name */
    public e f34544f = new f() { // from class: com.kwad.sdk.draw.b.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.i(a.this.f34540b);
            if (((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            super.a(i, i2);
            if (((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a.onVideoPlayError();
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
            if (!a.this.f34540b.mPvReported && ((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a != null) {
                ((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a.onAdShow();
            }
            if (((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                a.this.f34543e = false;
            }
            b.a(a.this.f34540b, (JSONObject) null);
            b.h(a.this.f34540b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            if (((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a != null) {
                try {
                    ((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
            a.this.f34543e = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f34543e) {
                a.this.f34543e = false;
                if (((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a != null) {
                    try {
                        ((com.kwad.sdk.draw.a.a) a.this).f34522a.f34523a.onVideoPlayResume();
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
        List<Integer> list = this.f34542d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f34542d) {
            if (ceil >= num.intValue()) {
                b.b(this.f34540b, ceil, null);
                this.f34542d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f34522a.f34525c;
        this.f34540b = adTemplate;
        AdInfo j = c.j(adTemplate);
        this.f34541c = j;
        this.f34542d = com.kwad.sdk.core.response.b.a.M(j);
        ((com.kwad.sdk.draw.a.a) this).f34522a.f34527e.a(this.f34544f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f34522a.f34527e.b(this.f34544f);
    }
}
