package com.kwad.sdk.draw.b;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.draw.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34545b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34546c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34547d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34548e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f34549f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f34550g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f34551h;
    @Nullable
    public com.kwad.sdk.core.download.b.b i;
    public ValueAnimator j;
    public int k;
    public int l;
    public int m;
    public KsLogoView n;
    public e o = new f() { // from class: com.kwad.sdk.draw.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            int i = (j2 > (b.this.m * 1000) ? 1 : (j2 == (b.this.m * 1000) ? 0 : -1));
            b bVar = b.this;
            if (i >= 0) {
                ((com.kwad.sdk.draw.a.a) bVar).f34521a.f34527f.a();
                return;
            }
            int i2 = (j2 > (bVar.l * 1000) ? 1 : (j2 == (bVar.l * 1000) ? 0 : -1));
            b bVar2 = b.this;
            if (i2 >= 0) {
                bVar2.p();
            } else if (j2 >= bVar2.k * 1000) {
                b.this.g();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
        }
    };
    public KsAppDownloadListener p = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.draw.b.b.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            b.this.f34548e.setText(com.kwad.sdk.core.response.b.a.w(b.this.f34551h));
            b.this.f34549f.a(com.kwad.sdk.core.response.b.a.w(b.this.f34551h), b.this.f34549f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            b.this.f34548e.setText(com.kwad.sdk.core.response.b.a.a(b.this.f34550g));
            b.this.f34549f.a(com.kwad.sdk.core.response.b.a.a(b.this.f34550g), b.this.f34549f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            b.this.f34548e.setText(com.kwad.sdk.core.response.b.a.w(b.this.f34551h));
            b.this.f34549f.a(com.kwad.sdk.core.response.b.a.w(b.this.f34551h), b.this.f34549f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            b.this.f34548e.setText(com.kwad.sdk.core.response.b.a.b());
            b.this.f34549f.a(com.kwad.sdk.core.response.b.a.b(), b.this.f34549f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            TextView textView = b.this.f34548e;
            textView.setText(i + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = b.this.f34549f;
            drawDownloadProgressBar.a(i + "%", i);
        }
    };

    private void e() {
        this.k = com.kwad.sdk.core.response.b.a.R(this.f34551h);
        this.l = com.kwad.sdk.core.response.b.a.S(this.f34551h);
        this.m = com.kwad.sdk.core.response.b.a.T(this.f34551h);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f34545b.getContext(), this.f34550g, new a.InterfaceC0378a() { // from class: com.kwad.sdk.draw.b.b.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
            public void a() {
                com.kwad.sdk.core.report.b.a(b.this.f34550g, 1, ((com.kwad.sdk.draw.a.a) b.this).f34521a.f34523b.getTouchCoords());
                if (((com.kwad.sdk.draw.a.a) b.this).f34521a.f34522a != null) {
                    ((com.kwad.sdk.draw.a.a) b.this).f34521a.f34522a.onAdClicked();
                }
            }
        }, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f34548e.getVisibility() == 0 || this.f34549f.getVisibility() == 0) {
            return;
        }
        this.f34548e.setOnClickListener(this);
        this.f34548e.setVisibility(0);
        TextView textView = this.f34548e;
        ValueAnimator a2 = am.a(textView, 0, ao.a(textView.getContext(), 44.0f));
        this.j = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.j.setDuration(300L);
        this.j.start();
    }

    private void h() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.j.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f34549f.getVisibility() == 0) {
            return;
        }
        this.f34549f.setOnClickListener(this);
        this.f34549f.setVisibility(0);
        this.f34548e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f34521a.f34524c;
        this.f34550g = adTemplate;
        this.f34551h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = ((com.kwad.sdk.draw.a.a) this).f34521a.f34525d;
        e();
        this.n.a(this.f34550g);
        this.f34548e.setText(com.kwad.sdk.core.response.b.a.w(this.f34551h));
        this.f34548e.setVisibility(8);
        this.f34549f.a(com.kwad.sdk.core.response.b.a.w(this.f34551h), this.f34549f.getMax());
        this.f34549f.setVisibility(8);
        this.f34545b.setVisibility(0);
        this.f34545b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.y(this.f34551h)) {
            this.f34546c.setText(com.kwad.sdk.core.response.b.a.q(this.f34551h));
            this.f34546c.setVisibility(0);
            com.kwad.sdk.core.download.b.b bVar = this.i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.f34546c.setVisibility(8);
        }
        this.f34547d.setText(com.kwad.sdk.core.response.b.a.n(this.f34551h));
        ((com.kwad.sdk.draw.a.a) this).f34521a.f34526e.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        KsAppDownloadListener ksAppDownloadListener;
        super.b_();
        h();
        com.kwad.sdk.core.download.b.b bVar = this.i;
        if (bVar != null && (ksAppDownloadListener = this.p) != null) {
            bVar.b(ksAppDownloadListener);
        }
        ((com.kwad.sdk.draw.a.a) this).f34521a.f34526e.b(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34545b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.f34546c = (TextView) b(R.id.ksad_ad_normal_title);
        this.f34547d = (TextView) b(R.id.ksad_ad_normal_des);
        this.n = (KsLogoView) b(R.id.ksad_ad_normal_logo);
        this.f34548e = (TextView) b(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) b(R.id.ksad_ad_light_convert_btn);
        this.f34549f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34545b || view == this.f34548e) {
            p();
        } else if (view != this.f34549f) {
            return;
        }
        f();
    }
}
