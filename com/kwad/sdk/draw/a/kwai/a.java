package com.kwad.sdk.draw.a.kwai;

import android.view.View;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.widget.k;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f56767b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f56768c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f56769d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56770e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f56771f = false;

    /* renamed from: g  reason: collision with root package name */
    public k f56772g = new k() { // from class: com.kwad.sdk.draw.a.kwai.a.1
        @Override // com.kwad.sdk.widget.k
        public void a() {
            m.c(a.this.f56767b);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public d f56773h = new e() { // from class: com.kwad.sdk.draw.a.kwai.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            super.a(i2, i3);
            if (((com.kwad.sdk.draw.kwai.a) a.this).a.a != null) {
                try {
                    ((com.kwad.sdk.draw.kwai.a) a.this).a.a.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            a.this.a(j3);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            a.this.f56771f = false;
            if (!a.this.f56767b.mPvReported && ((com.kwad.sdk.draw.kwai.a) a.this).a.a != null) {
                ((com.kwad.sdk.draw.kwai.a) a.this).a.a.onAdShow();
            }
            if (((com.kwad.sdk.draw.kwai.a) a.this).a.a != null) {
                try {
                    ((com.kwad.sdk.draw.kwai.a) a.this).a.a.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                a.this.f56770e = false;
            }
            com.kwad.sdk.core.report.a.a(a.this.f56767b, (JSONObject) null);
            com.kwad.sdk.core.report.a.i(a.this.f56767b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (!a.this.f56770e) {
                if (a.this.f56771f) {
                    return;
                }
                a.this.f56771f = true;
                com.kwad.sdk.core.report.d.a(a.this.f56767b, System.currentTimeMillis(), 1);
                return;
            }
            a.this.f56770e = false;
            if (((com.kwad.sdk.draw.kwai.a) a.this).a.a != null) {
                try {
                    ((com.kwad.sdk.draw.kwai.a) a.this).a.a.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            if (((com.kwad.sdk.draw.kwai.a) a.this).a.a != null) {
                try {
                    ((com.kwad.sdk.draw.kwai.a) a.this).a.a.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
            a.this.f56770e = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            com.kwad.sdk.core.report.a.j(a.this.f56767b);
            if (((com.kwad.sdk.draw.kwai.a) a.this).a.a != null) {
                try {
                    ((com.kwad.sdk.draw.kwai.a) a.this).a.a.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.f56769d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f56769d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.f56767b, ceil, null);
                this.f56769d.remove(num);
                return;
            }
        }
    }

    private void a(k kVar) {
        View m = m();
        if (m instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) m).setVisibleListener(kVar);
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f56784c;
        this.f56767b = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f56768c = j2;
        this.f56769d = com.kwad.sdk.core.response.a.a.S(j2);
        ((com.kwad.sdk.draw.kwai.a) this).a.f56786e.a(this.f56773h);
        a(this.f56772g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f56786e.b(this.f56773h);
        a((k) null);
    }
}
