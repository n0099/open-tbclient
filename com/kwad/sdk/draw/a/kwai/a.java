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
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f40343b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f40344c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f40345d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40346e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f40347f = false;

    /* renamed from: g  reason: collision with root package name */
    public k f40348g = new k() { // from class: com.kwad.sdk.draw.a.kwai.a.1
        @Override // com.kwad.sdk.widget.k
        public void a() {
            m.c(a.this.f40343b);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public d f40349h = new e() { // from class: com.kwad.sdk.draw.a.kwai.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            super.a(i, i2);
            if (((com.kwad.sdk.draw.kwai.a) a.this).a.a != null) {
                try {
                    ((com.kwad.sdk.draw.kwai.a) a.this).a.a.onVideoPlayError();
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
            a.this.f40347f = false;
            if (!a.this.f40343b.mPvReported && ((com.kwad.sdk.draw.kwai.a) a.this).a.a != null) {
                ((com.kwad.sdk.draw.kwai.a) a.this).a.a.onAdShow();
            }
            if (((com.kwad.sdk.draw.kwai.a) a.this).a.a != null) {
                try {
                    ((com.kwad.sdk.draw.kwai.a) a.this).a.a.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                a.this.f40346e = false;
            }
            com.kwad.sdk.core.report.a.a(a.this.f40343b, (JSONObject) null);
            com.kwad.sdk.core.report.a.i(a.this.f40343b);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            if (!a.this.f40346e) {
                if (a.this.f40347f) {
                    return;
                }
                a.this.f40347f = true;
                com.kwad.sdk.core.report.d.a(a.this.f40343b, System.currentTimeMillis(), 1);
                return;
            }
            a.this.f40346e = false;
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
            a.this.f40346e = true;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            com.kwad.sdk.core.report.a.j(a.this.f40343b);
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
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f40345d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f40345d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.f40343b, ceil, null);
                this.f40345d.remove(num);
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
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f40360c;
        this.f40343b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f40344c = j;
        this.f40345d = com.kwad.sdk.core.response.a.a.S(j);
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.a(this.f40349h);
        a(this.f40348g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.b(this.f40349h);
        a((k) null);
    }
}
