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
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.draw.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35197b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35198c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35199d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35200e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f35201f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f35202g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f35203h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35204i;
    public ValueAnimator j;
    public int k;
    public int l;
    public int m;
    public KsLogoView n;
    public e o = new f() { // from class: com.kwad.sdk.draw.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            int i2 = (j2 > (b.this.m * 1000) ? 1 : (j2 == (b.this.m * 1000) ? 0 : -1));
            b bVar = b.this;
            if (i2 >= 0) {
                ((com.kwad.sdk.draw.a.a) bVar).f35173a.f35179f.a();
                return;
            }
            int i3 = (j2 > (bVar.l * 1000) ? 1 : (j2 == (bVar.l * 1000) ? 0 : -1));
            b bVar2 = b.this;
            if (i3 >= 0) {
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
            b.this.f35200e.setText(com.kwad.sdk.core.response.b.a.w(b.this.f35203h));
            b.this.f35201f.a(com.kwad.sdk.core.response.b.a.w(b.this.f35203h), b.this.f35201f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            b.this.f35200e.setText(com.kwad.sdk.core.response.b.a.a(b.this.f35202g));
            b.this.f35201f.a(com.kwad.sdk.core.response.b.a.a(b.this.f35202g), b.this.f35201f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            b.this.f35200e.setText(com.kwad.sdk.core.response.b.a.w(b.this.f35203h));
            b.this.f35201f.a(com.kwad.sdk.core.response.b.a.w(b.this.f35203h), b.this.f35201f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            b.this.f35200e.setText(com.kwad.sdk.core.response.b.a.b());
            b.this.f35201f.a(com.kwad.sdk.core.response.b.a.b(), b.this.f35201f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            TextView textView = b.this.f35200e;
            textView.setText(i2 + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = b.this.f35201f;
            drawDownloadProgressBar.a(i2 + "%", i2);
        }
    };

    private void e() {
        this.k = com.kwad.sdk.core.response.b.a.R(this.f35203h);
        this.l = com.kwad.sdk.core.response.b.a.S(this.f35203h);
        this.m = com.kwad.sdk.core.response.b.a.T(this.f35203h);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f35197b.getContext(), this.f35202g, new a.InterfaceC0379a() { // from class: com.kwad.sdk.draw.b.b.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                com.kwad.sdk.core.report.b.a(b.this.f35202g, 1, ((com.kwad.sdk.draw.a.a) b.this).f35173a.f35175b.getTouchCoords());
                if (((com.kwad.sdk.draw.a.a) b.this).f35173a.f35174a != null) {
                    ((com.kwad.sdk.draw.a.a) b.this).f35173a.f35174a.onAdClicked();
                }
            }
        }, this.f35204i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f35200e.getVisibility() == 0 || this.f35201f.getVisibility() == 0) {
            return;
        }
        this.f35200e.setOnClickListener(this);
        this.f35200e.setVisibility(0);
        TextView textView = this.f35200e;
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
        if (this.f35201f.getVisibility() == 0) {
            return;
        }
        this.f35201f.setOnClickListener(this);
        this.f35201f.setVisibility(0);
        this.f35200e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f35173a.f35176c;
        this.f35202g = adTemplate;
        this.f35203h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f35204i = ((com.kwad.sdk.draw.a.a) this).f35173a.f35177d;
        e();
        this.n.a(this.f35202g);
        this.f35200e.setText(com.kwad.sdk.core.response.b.a.w(this.f35203h));
        this.f35200e.setVisibility(8);
        this.f35201f.a(com.kwad.sdk.core.response.b.a.w(this.f35203h), this.f35201f.getMax());
        this.f35201f.setVisibility(8);
        this.f35197b.setVisibility(0);
        this.f35197b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.y(this.f35203h)) {
            this.f35198c.setText(com.kwad.sdk.core.response.b.a.q(this.f35203h));
            this.f35198c.setVisibility(0);
            com.kwad.sdk.core.download.b.b bVar = this.f35204i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.f35198c.setVisibility(8);
        }
        this.f35199d.setText(com.kwad.sdk.core.response.b.a.n(this.f35203h));
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35178e.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        KsAppDownloadListener ksAppDownloadListener;
        super.b_();
        h();
        com.kwad.sdk.core.download.b.b bVar = this.f35204i;
        if (bVar != null && (ksAppDownloadListener = this.p) != null) {
            bVar.b(ksAppDownloadListener);
        }
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35178e.b(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35197b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.f35198c = (TextView) b(R.id.ksad_ad_normal_title);
        this.f35199d = (TextView) b(R.id.ksad_ad_normal_des);
        this.n = (KsLogoView) b(R.id.ksad_ad_normal_logo);
        this.f35200e = (TextView) b(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) b(R.id.ksad_ad_light_convert_btn);
        this.f35201f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35197b || view == this.f35200e) {
            p();
        } else if (view != this.f35201f) {
            return;
        }
        f();
    }
}
