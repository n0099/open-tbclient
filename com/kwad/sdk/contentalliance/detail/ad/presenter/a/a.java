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
    public AdBaseFrameLayout f32342b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32343c;

    /* renamed from: d  reason: collision with root package name */
    public AdDownloadProgressBar f32344d;

    /* renamed from: e  reason: collision with root package name */
    public AdDownloadProgressBar f32345e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f32346f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f32347g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f32348h;
    public AdInfo i;
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
            if (j2 >= com.kwad.sdk.core.response.b.b.g(a.this.f32348h)) {
                return;
            }
            int i = (j2 > com.kwad.sdk.core.response.b.b.f(a.this.f32348h) ? 1 : (j2 == com.kwad.sdk.core.response.b.b.f(a.this.f32348h) ? 0 : -1));
            a aVar = a.this;
            if (i >= 0) {
                aVar.p();
            } else if (j2 >= com.kwad.sdk.core.response.b.b.e(aVar.f32348h)) {
                a.this.g();
            }
        }
    };
    public KsAppDownloadListener n = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.3
        @Override // com.kwad.sdk.core.download.b.c
        public void a(int i) {
            float f2 = i;
            a.this.f32344d.a(com.kwad.sdk.core.response.b.a.b(a.this.i, i), f2);
            a.this.f32345e.a(com.kwad.sdk.core.response.b.a.b(a.this.i, i), f2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            a.this.f32344d.setText(com.kwad.sdk.core.response.b.a.x(a.this.i));
            a.this.f32345e.setText(com.kwad.sdk.core.response.b.a.x(a.this.i));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            a.this.f32344d.setText(com.kwad.sdk.core.response.b.a.a(a.this.f32348h));
            a.this.f32345e.setText(com.kwad.sdk.core.response.b.a.a(a.this.f32348h));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            a.this.f32344d.setText(com.kwad.sdk.core.response.b.a.x(a.this.i));
            a.this.f32345e.setText(com.kwad.sdk.core.response.b.a.x(a.this.i));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            a.this.f32344d.setText(com.kwad.sdk.core.response.b.a.b());
            a.this.f32345e.setText(com.kwad.sdk.core.response.b.a.b());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            float f2 = i;
            a.this.f32344d.a(com.kwad.sdk.core.response.b.a.a(a.this.i, i), f2);
            a.this.f32345e.a(com.kwad.sdk.core.response.b.a.a(a.this.i, i), f2);
        }
    };

    private void e() {
        this.f32344d.setProgressDrawable(Color.parseColor("#4D36384B"));
        this.f32344d.setTextColor(Color.parseColor("#66FFFFFF"));
        this.f32344d.a(null, null, o().getResources().getDrawable(R.drawable.ksad_btn_arrow_gray), null, ao.a(o(), 2.0f));
    }

    private void f() {
        this.f32345e.setTextColor(Color.parseColor("#CCFFFFFF"));
        this.f32345e.a(null, null, o().getResources().getDrawable(R.drawable.ksad_btn_arrow_light), null, ao.a(o(), 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f32344d.getVisibility() == 0 || this.f32345e.getVisibility() == 0) {
            return;
        }
        v();
        h();
        this.f32344d.setAlpha(1.0f);
        this.f32344d.setVisibility(0);
        this.f32344d.setOnClickListener(this);
        ViewGroup viewGroup = this.f32343c;
        ValueAnimator d2 = am.d(viewGroup, 0, ao.a(viewGroup.getContext(), 39.0f));
        this.f32346f = d2;
        d2.start();
    }

    private void h() {
        ValueAnimator valueAnimator = this.f32346f;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f32346f.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f32345e.getVisibility() == 0) {
            return;
        }
        q();
        this.f32343c.setVisibility(0);
        this.f32345e.setOnClickListener(this);
        ValueAnimator a2 = am.a(this.f32344d, this.f32345e);
        this.f32347g = a2;
        a2.start();
    }

    private void q() {
        ValueAnimator valueAnimator = this.f32347g;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f32347g.cancel();
        }
    }

    private void r() {
        h();
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        q();
        this.f32345e.setAlpha(1.0f);
        this.f32345e.setVisibility(8);
        this.f32343c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        h();
        this.f32344d.setAlpha(1.0f);
        this.f32344d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.kwad.sdk.core.report.b.a(this.f32348h, 1, this.f32342b.getTouchCoords());
    }

    private void v() {
        com.kwad.sdk.core.report.b.c(this.f32348h, 19, null);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j;
        this.f32348h = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = j;
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a;
        this.j = cVar.o;
        this.k = cVar.m;
        this.f32344d.setText(com.kwad.sdk.core.response.b.a.x(j));
        this.f32344d.setVisibility(8);
        this.f32345e.setText(com.kwad.sdk.core.response.b.a.x(this.i));
        this.f32345e.setProgressDrawable(Color.parseColor(com.kwad.sdk.core.response.b.a.X(this.i)));
        this.f32345e.setVisibility(8);
        com.kwad.sdk.core.download.b.b bVar = this.j;
        if (bVar != null) {
            bVar.a(this.n);
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(this.m);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.add(this.l);
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
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.remove(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32342b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32343c = (ViewGroup) b(R.id.ksad_progress_container);
        this.f32344d = (AdDownloadProgressBar) b(R.id.ksad_translate_progress);
        this.f32345e = (AdDownloadProgressBar) b(R.id.ksad_light_progress);
        e();
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.j, true);
        com.kwad.sdk.core.download.b.a.a(this.f32344d.getContext(), this.f32348h, new a.InterfaceC0393a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.4
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                a.this.u();
            }
        }, this.j);
    }
}
