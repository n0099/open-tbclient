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
    public ViewGroup f34835b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34836c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34837d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34838e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f34839f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f34840g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f34841h;
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
                ((com.kwad.sdk.draw.a.a) bVar).f34811a.f34817f.a();
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
            b.this.f34838e.setText(com.kwad.sdk.core.response.b.a.w(b.this.f34841h));
            b.this.f34839f.a(com.kwad.sdk.core.response.b.a.w(b.this.f34841h), b.this.f34839f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            b.this.f34838e.setText(com.kwad.sdk.core.response.b.a.a(b.this.f34840g));
            b.this.f34839f.a(com.kwad.sdk.core.response.b.a.a(b.this.f34840g), b.this.f34839f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            b.this.f34838e.setText(com.kwad.sdk.core.response.b.a.w(b.this.f34841h));
            b.this.f34839f.a(com.kwad.sdk.core.response.b.a.w(b.this.f34841h), b.this.f34839f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            b.this.f34838e.setText(com.kwad.sdk.core.response.b.a.b());
            b.this.f34839f.a(com.kwad.sdk.core.response.b.a.b(), b.this.f34839f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            TextView textView = b.this.f34838e;
            textView.setText(i + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = b.this.f34839f;
            drawDownloadProgressBar.a(i + "%", i);
        }
    };

    private void e() {
        this.k = com.kwad.sdk.core.response.b.a.R(this.f34841h);
        this.l = com.kwad.sdk.core.response.b.a.S(this.f34841h);
        this.m = com.kwad.sdk.core.response.b.a.T(this.f34841h);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f34835b.getContext(), this.f34840g, new a.InterfaceC0393a() { // from class: com.kwad.sdk.draw.b.b.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                com.kwad.sdk.core.report.b.a(b.this.f34840g, 1, ((com.kwad.sdk.draw.a.a) b.this).f34811a.f34813b.getTouchCoords());
                if (((com.kwad.sdk.draw.a.a) b.this).f34811a.f34812a != null) {
                    ((com.kwad.sdk.draw.a.a) b.this).f34811a.f34812a.onAdClicked();
                }
            }
        }, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f34838e.getVisibility() == 0 || this.f34839f.getVisibility() == 0) {
            return;
        }
        this.f34838e.setOnClickListener(this);
        this.f34838e.setVisibility(0);
        TextView textView = this.f34838e;
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
        if (this.f34839f.getVisibility() == 0) {
            return;
        }
        this.f34839f.setOnClickListener(this);
        this.f34839f.setVisibility(0);
        this.f34838e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f34811a.f34814c;
        this.f34840g = adTemplate;
        this.f34841h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = ((com.kwad.sdk.draw.a.a) this).f34811a.f34815d;
        e();
        this.n.a(this.f34840g);
        this.f34838e.setText(com.kwad.sdk.core.response.b.a.w(this.f34841h));
        this.f34838e.setVisibility(8);
        this.f34839f.a(com.kwad.sdk.core.response.b.a.w(this.f34841h), this.f34839f.getMax());
        this.f34839f.setVisibility(8);
        this.f34835b.setVisibility(0);
        this.f34835b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.y(this.f34841h)) {
            this.f34836c.setText(com.kwad.sdk.core.response.b.a.q(this.f34841h));
            this.f34836c.setVisibility(0);
            com.kwad.sdk.core.download.b.b bVar = this.i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.f34836c.setVisibility(8);
        }
        this.f34837d.setText(com.kwad.sdk.core.response.b.a.n(this.f34841h));
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34816e.a(this.o);
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
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34816e.b(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34835b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.f34836c = (TextView) b(R.id.ksad_ad_normal_title);
        this.f34837d = (TextView) b(R.id.ksad_ad_normal_des);
        this.n = (KsLogoView) b(R.id.ksad_ad_normal_logo);
        this.f34838e = (TextView) b(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) b(R.id.ksad_ad_light_convert_btn);
        this.f34839f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34835b || view == this.f34838e) {
            p();
        } else if (view != this.f34839f) {
            return;
        }
        f();
    }
}
