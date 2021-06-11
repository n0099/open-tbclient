package com.kwad.sdk.contentalliance.detail.ad.presenter.a;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.view.AdDownloadProgressBar;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f32608b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32609c;

    /* renamed from: d  reason: collision with root package name */
    public AdDownloadProgressBar f32610d;

    /* renamed from: e  reason: collision with root package name */
    public AdDownloadProgressBar f32611e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f32612f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f32613g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f32614h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f32615i;
    @Nullable
    public com.kwad.sdk.core.download.b.b j;
    public com.kwad.sdk.contentalliance.detail.video.b k;
    public com.kwad.sdk.contentalliance.a.a l = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.s();
            a.this.t();
        }
    };
    public e m = new f() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            a.this.t();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= com.kwad.sdk.core.response.b.b.g(a.this.f32614h)) {
                return;
            }
            int i2 = (j2 > com.kwad.sdk.core.response.b.b.f(a.this.f32614h) ? 1 : (j2 == com.kwad.sdk.core.response.b.b.f(a.this.f32614h) ? 0 : -1));
            a aVar = a.this;
            if (i2 >= 0) {
                aVar.p();
            } else if (j2 >= com.kwad.sdk.core.response.b.b.e(aVar.f32614h)) {
                a.this.g();
            }
        }
    };
    public KsAppDownloadListener n = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.3
        @Override // com.kwad.sdk.core.download.b.c
        public void a(int i2) {
            float f2 = i2;
            a.this.f32610d.a(com.kwad.sdk.core.response.b.a.b(a.this.f32615i, i2), f2);
            a.this.f32611e.a(com.kwad.sdk.core.response.b.a.b(a.this.f32615i, i2), f2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            a.this.f32610d.setText(com.kwad.sdk.core.response.b.a.x(a.this.f32615i));
            a.this.f32611e.setText(com.kwad.sdk.core.response.b.a.x(a.this.f32615i));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            a.this.f32610d.setText(com.kwad.sdk.core.response.b.a.a(a.this.f32614h));
            a.this.f32611e.setText(com.kwad.sdk.core.response.b.a.a(a.this.f32614h));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            a.this.f32610d.setText(com.kwad.sdk.core.response.b.a.x(a.this.f32615i));
            a.this.f32611e.setText(com.kwad.sdk.core.response.b.a.x(a.this.f32615i));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            a.this.f32610d.setText(com.kwad.sdk.core.response.b.a.b());
            a.this.f32611e.setText(com.kwad.sdk.core.response.b.a.b());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            float f2 = i2;
            a.this.f32610d.a(com.kwad.sdk.core.response.b.a.a(a.this.f32615i, i2), f2);
            a.this.f32611e.a(com.kwad.sdk.core.response.b.a.a(a.this.f32615i, i2), f2);
        }
    };

    private void e() {
        this.f32610d.setProgressDrawable(Color.parseColor("#4D36384B"));
        this.f32610d.setTextColor(Color.parseColor("#66FFFFFF"));
        this.f32610d.a(null, null, o().getResources().getDrawable(R.drawable.ksad_btn_arrow_gray), null, ao.a(o(), 2.0f));
    }

    private void f() {
        this.f32611e.setTextColor(Color.parseColor("#CCFFFFFF"));
        this.f32611e.a(null, null, o().getResources().getDrawable(R.drawable.ksad_btn_arrow_light), null, ao.a(o(), 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f32610d.getVisibility() == 0 || this.f32611e.getVisibility() == 0) {
            return;
        }
        v();
        h();
        this.f32610d.setAlpha(1.0f);
        this.f32610d.setVisibility(0);
        this.f32610d.setOnClickListener(this);
        ViewGroup viewGroup = this.f32609c;
        ValueAnimator d2 = am.d(viewGroup, 0, ao.a(viewGroup.getContext(), 39.0f));
        this.f32612f = d2;
        d2.start();
    }

    private void h() {
        ValueAnimator valueAnimator = this.f32612f;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f32612f.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f32611e.getVisibility() == 0) {
            return;
        }
        q();
        this.f32609c.setVisibility(0);
        this.f32611e.setOnClickListener(this);
        ValueAnimator a2 = am.a(this.f32610d, this.f32611e);
        this.f32613g = a2;
        a2.start();
    }

    private void q() {
        ValueAnimator valueAnimator = this.f32613g;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f32613g.cancel();
        }
    }

    private void r() {
        h();
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        q();
        this.f32611e.setAlpha(1.0f);
        this.f32611e.setVisibility(8);
        this.f32609c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        h();
        this.f32610d.setAlpha(1.0f);
        this.f32610d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.kwad.sdk.core.report.b.a(this.f32614h, 1, this.f32608b.getTouchCoords());
    }

    private void v() {
        com.kwad.sdk.core.report.b.c(this.f32614h, 19, null);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j;
        this.f32614h = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f32615i = j;
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        this.j = cVar.o;
        this.k = cVar.m;
        this.f32610d.setText(com.kwad.sdk.core.response.b.a.x(j));
        this.f32610d.setVisibility(8);
        this.f32611e.setText(com.kwad.sdk.core.response.b.a.x(this.f32615i));
        this.f32611e.setProgressDrawable(Color.parseColor(com.kwad.sdk.core.response.b.a.X(this.f32615i)));
        this.f32611e.setVisibility(8);
        com.kwad.sdk.core.download.b.b bVar = this.j;
        if (bVar != null) {
            bVar.a(this.n);
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(this.m);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.add(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        r();
        com.kwad.sdk.core.download.b.b bVar = this.j;
        if (bVar != null) {
            bVar.b(this.n);
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.b(this.m);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.remove(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32608b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32609c = (ViewGroup) b(R.id.ksad_progress_container);
        this.f32610d = (AdDownloadProgressBar) b(R.id.ksad_translate_progress);
        this.f32611e = (AdDownloadProgressBar) b(R.id.ksad_light_progress);
        e();
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.j, true);
        com.kwad.sdk.core.download.b.a.a(this.f32610d.getContext(), this.f32614h, new a.InterfaceC0379a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.4
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                a.this.u();
            }
        }, this.j);
    }
}
