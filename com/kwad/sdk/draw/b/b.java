package com.kwad.sdk.draw.b;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.draw.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33073b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33074c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33075d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33076e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f33077f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f33078g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f33079h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33080i;
    public ValueAnimator j;
    public int k;
    public int l;
    public int m;
    public KsLogoView n;
    public d o = new e() { // from class: com.kwad.sdk.draw.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            int i2 = (j2 > (b.this.m * 1000) ? 1 : (j2 == (b.this.m * 1000) ? 0 : -1));
            b bVar = b.this;
            if (i2 >= 0) {
                ((com.kwad.sdk.draw.a.a) bVar).f33049a.f33055f.a();
                return;
            }
            int i3 = (j2 > (bVar.l * 1000) ? 1 : (j2 == (bVar.l * 1000) ? 0 : -1));
            b bVar2 = b.this;
            if (i3 >= 0) {
                bVar2.o();
            } else if (j2 >= bVar2.k * 1000) {
                b.this.m();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
        }
    };
    public KsAppDownloadListener p = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.draw.b.b.2
        @Override // com.kwad.sdk.core.download.b.c
        public void a(int i2) {
            super.a(i2);
            b.this.f33076e.setText(com.kwad.sdk.core.response.b.a.a());
            b.this.f33077f.a(com.kwad.sdk.core.response.b.a.a(), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            b.this.f33076e.setText(com.kwad.sdk.core.response.b.a.u(b.this.f33079h));
            b.this.f33077f.a(com.kwad.sdk.core.response.b.a.u(b.this.f33079h), b.this.f33077f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            b.this.f33076e.setText(com.kwad.sdk.core.response.b.a.a(b.this.f33078g));
            b.this.f33077f.a(com.kwad.sdk.core.response.b.a.a(b.this.f33078g), b.this.f33077f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            b.this.f33076e.setText(com.kwad.sdk.core.response.b.a.u(b.this.f33079h));
            b.this.f33077f.a(com.kwad.sdk.core.response.b.a.u(b.this.f33079h), b.this.f33077f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            b.this.f33076e.setText(com.kwad.sdk.core.response.b.a.j(b.this.f33079h));
            b.this.f33077f.a(com.kwad.sdk.core.response.b.a.j(b.this.f33079h), b.this.f33077f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            TextView textView = b.this.f33076e;
            textView.setText(i2 + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = b.this.f33077f;
            drawDownloadProgressBar.a(i2 + "%", i2);
        }
    };

    private void a(boolean z) {
        com.kwad.sdk.core.download.b.a.a(this.f33073b.getContext(), this.f33078g, new a.InterfaceC0364a() { // from class: com.kwad.sdk.draw.b.b.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                com.kwad.sdk.core.report.b.a(b.this.f33078g, 1, ((com.kwad.sdk.draw.a.a) b.this).f33049a.f33051b.getTouchCoords());
                if (((com.kwad.sdk.draw.a.a) b.this).f33049a.f33050a != null) {
                    ((com.kwad.sdk.draw.a.a) b.this).f33049a.f33050a.onAdClicked();
                }
            }
        }, this.f33080i, z);
    }

    private void e() {
        this.k = com.kwad.sdk.core.response.b.a.N(this.f33079h);
        this.l = com.kwad.sdk.core.response.b.a.O(this.f33079h);
        this.m = com.kwad.sdk.core.response.b.a.P(this.f33079h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f33076e.getVisibility() == 0 || this.f33077f.getVisibility() == 0) {
            return;
        }
        this.f33076e.setOnClickListener(this);
        this.f33076e.setVisibility(0);
        TextView textView = this.f33076e;
        ValueAnimator a2 = am.a(textView, 0, an.a(textView.getContext(), 44.0f));
        this.j = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.j.setDuration(300L);
        this.j.start();
    }

    private void n() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.j.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f33077f.getVisibility() == 0) {
            return;
        }
        this.f33077f.setOnClickListener(this);
        this.f33077f.setVisibility(0);
        this.f33076e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f33049a.f33052c;
        this.f33078g = adTemplate;
        this.f33079h = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33080i = ((com.kwad.sdk.draw.a.a) this).f33049a.f33053d;
        e();
        this.n.a(this.f33078g);
        this.f33076e.setText(com.kwad.sdk.core.response.b.a.u(this.f33079h));
        this.f33076e.setVisibility(8);
        this.f33077f.a(com.kwad.sdk.core.response.b.a.u(this.f33079h), this.f33077f.getMax());
        this.f33077f.setVisibility(8);
        this.f33073b.setVisibility(0);
        this.f33073b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.v(this.f33079h)) {
            this.f33074c.setText(com.kwad.sdk.core.response.b.a.o(this.f33079h));
            this.f33074c.setVisibility(0);
            com.kwad.sdk.core.download.b.b bVar = this.f33080i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.f33074c.setVisibility(8);
        }
        this.f33075d.setText(com.kwad.sdk.core.response.b.a.m(this.f33079h));
        ((com.kwad.sdk.draw.a.a) this).f33049a.f33054e.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33073b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f33074c = (TextView) a(R.id.ksad_ad_normal_title);
        this.f33075d = (TextView) a(R.id.ksad_ad_normal_des);
        this.n = (KsLogoView) a(R.id.ksad_ad_normal_logo);
        this.f33076e = (TextView) a(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) a(R.id.ksad_ad_light_convert_btn);
        this.f33077f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        KsAppDownloadListener ksAppDownloadListener;
        super.c();
        n();
        com.kwad.sdk.core.download.b.b bVar = this.f33080i;
        if (bVar != null && (ksAppDownloadListener = this.p) != null) {
            bVar.b(ksAppDownloadListener);
        }
        ((com.kwad.sdk.draw.a.a) this).f33049a.f33054e.b(this.o);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33073b) {
            o();
            a(false);
            return;
        }
        if (view == this.f33076e) {
            o();
        } else if (view != this.f33077f) {
            return;
        }
        a(true);
    }
}
