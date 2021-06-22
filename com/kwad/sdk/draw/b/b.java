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
    public ViewGroup f35295b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35296c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35297d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35298e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f35299f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f35300g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f35301h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35302i;
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
                ((com.kwad.sdk.draw.a.a) bVar).f35271a.f35277f.a();
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
            b.this.f35298e.setText(com.kwad.sdk.core.response.b.a.w(b.this.f35301h));
            b.this.f35299f.a(com.kwad.sdk.core.response.b.a.w(b.this.f35301h), b.this.f35299f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            b.this.f35298e.setText(com.kwad.sdk.core.response.b.a.a(b.this.f35300g));
            b.this.f35299f.a(com.kwad.sdk.core.response.b.a.a(b.this.f35300g), b.this.f35299f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            b.this.f35298e.setText(com.kwad.sdk.core.response.b.a.w(b.this.f35301h));
            b.this.f35299f.a(com.kwad.sdk.core.response.b.a.w(b.this.f35301h), b.this.f35299f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            b.this.f35298e.setText(com.kwad.sdk.core.response.b.a.b());
            b.this.f35299f.a(com.kwad.sdk.core.response.b.a.b(), b.this.f35299f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            TextView textView = b.this.f35298e;
            textView.setText(i2 + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = b.this.f35299f;
            drawDownloadProgressBar.a(i2 + "%", i2);
        }
    };

    private void e() {
        this.k = com.kwad.sdk.core.response.b.a.R(this.f35301h);
        this.l = com.kwad.sdk.core.response.b.a.S(this.f35301h);
        this.m = com.kwad.sdk.core.response.b.a.T(this.f35301h);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f35295b.getContext(), this.f35300g, new a.InterfaceC0382a() { // from class: com.kwad.sdk.draw.b.b.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                com.kwad.sdk.core.report.b.a(b.this.f35300g, 1, ((com.kwad.sdk.draw.a.a) b.this).f35271a.f35273b.getTouchCoords());
                if (((com.kwad.sdk.draw.a.a) b.this).f35271a.f35272a != null) {
                    ((com.kwad.sdk.draw.a.a) b.this).f35271a.f35272a.onAdClicked();
                }
            }
        }, this.f35302i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f35298e.getVisibility() == 0 || this.f35299f.getVisibility() == 0) {
            return;
        }
        this.f35298e.setOnClickListener(this);
        this.f35298e.setVisibility(0);
        TextView textView = this.f35298e;
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
        if (this.f35299f.getVisibility() == 0) {
            return;
        }
        this.f35299f.setOnClickListener(this);
        this.f35299f.setVisibility(0);
        this.f35298e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f35271a.f35274c;
        this.f35300g = adTemplate;
        this.f35301h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f35302i = ((com.kwad.sdk.draw.a.a) this).f35271a.f35275d;
        e();
        this.n.a(this.f35300g);
        this.f35298e.setText(com.kwad.sdk.core.response.b.a.w(this.f35301h));
        this.f35298e.setVisibility(8);
        this.f35299f.a(com.kwad.sdk.core.response.b.a.w(this.f35301h), this.f35299f.getMax());
        this.f35299f.setVisibility(8);
        this.f35295b.setVisibility(0);
        this.f35295b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.y(this.f35301h)) {
            this.f35296c.setText(com.kwad.sdk.core.response.b.a.q(this.f35301h));
            this.f35296c.setVisibility(0);
            com.kwad.sdk.core.download.b.b bVar = this.f35302i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.f35296c.setVisibility(8);
        }
        this.f35297d.setText(com.kwad.sdk.core.response.b.a.n(this.f35301h));
        ((com.kwad.sdk.draw.a.a) this).f35271a.f35276e.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        KsAppDownloadListener ksAppDownloadListener;
        super.b_();
        h();
        com.kwad.sdk.core.download.b.b bVar = this.f35302i;
        if (bVar != null && (ksAppDownloadListener = this.p) != null) {
            bVar.b(ksAppDownloadListener);
        }
        ((com.kwad.sdk.draw.a.a) this).f35271a.f35276e.b(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35295b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.f35296c = (TextView) b(R.id.ksad_ad_normal_title);
        this.f35297d = (TextView) b(R.id.ksad_ad_normal_des);
        this.n = (KsLogoView) b(R.id.ksad_ad_normal_logo);
        this.f35298e = (TextView) b(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) b(R.id.ksad_ad_light_convert_btn);
        this.f35299f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35295b || view == this.f35298e) {
            p();
        } else if (view != this.f35299f) {
            return;
        }
        f();
    }
}
