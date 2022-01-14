package com.kwad.sdk.draw.a;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.draw.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56710b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56711c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56712d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56713e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f56714f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f56715g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f56716h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56717i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f56718j;
    public int k;
    public int l;
    public int m;
    public KsLogoView n;
    public com.kwad.sdk.contentalliance.detail.video.d o = new e() { // from class: com.kwad.sdk.draw.a.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            int i2 = (j3 > (c.this.m * 1000) ? 1 : (j3 == (c.this.m * 1000) ? 0 : -1));
            c cVar = c.this;
            if (i2 >= 0) {
                ((com.kwad.sdk.draw.kwai.a) cVar).a.f56742f.a();
                return;
            }
            int i3 = (j3 > (cVar.l * 1000) ? 1 : (j3 == (cVar.l * 1000) ? 0 : -1));
            c cVar2 = c.this;
            if (i3 >= 0) {
                cVar2.h();
            } else if (j3 >= cVar2.k * 1000) {
                c.this.f();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
        }
    };
    public KsAppDownloadListener p = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.draw.a.c.2
        @Override // com.kwad.sdk.core.download.a.c
        public void a(int i2) {
            super.a(i2);
            c.this.f56713e.setText(com.kwad.sdk.core.response.a.a.a());
            c.this.f56714f.a(com.kwad.sdk.core.response.a.a.a(), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            c.this.f56713e.setText(com.kwad.sdk.core.response.a.a.A(c.this.f56716h));
            c.this.f56714f.a(com.kwad.sdk.core.response.a.a.A(c.this.f56716h), c.this.f56714f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            c.this.f56713e.setText(com.kwad.sdk.core.response.a.a.a(c.this.f56715g));
            c.this.f56714f.a(com.kwad.sdk.core.response.a.a.a(c.this.f56715g), c.this.f56714f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            c.this.f56713e.setText(com.kwad.sdk.core.response.a.a.A(c.this.f56716h));
            c.this.f56714f.a(com.kwad.sdk.core.response.a.a.A(c.this.f56716h), c.this.f56714f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            c.this.f56713e.setText(com.kwad.sdk.core.response.a.a.m(c.this.f56716h));
            c.this.f56714f.a(com.kwad.sdk.core.response.a.a.m(c.this.f56716h), c.this.f56714f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            TextView textView = c.this.f56713e;
            textView.setText(i2 + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = c.this.f56714f;
            drawDownloadProgressBar.a(i2 + "%", i2);
        }
    };

    private void a(boolean z, int i2) {
        com.kwad.sdk.core.download.a.a.a(new a.C2100a(this.f56710b.getContext()).a(this.f56715g).a(this.f56717i).a(i2).a(z).a(new a.b() { // from class: com.kwad.sdk.draw.a.c.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(c.this.f56715g, 1, ((com.kwad.sdk.draw.kwai.a) c.this).a.f56738b.getTouchCoords());
                if (((com.kwad.sdk.draw.kwai.a) c.this).a.a != null) {
                    ((com.kwad.sdk.draw.kwai.a) c.this).a.a.onAdClicked();
                }
            }
        }));
    }

    private void e() {
        this.k = com.kwad.sdk.core.response.a.a.X(this.f56716h);
        this.l = com.kwad.sdk.core.response.a.a.Y(this.f56716h);
        this.m = com.kwad.sdk.core.response.a.a.Z(this.f56716h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f56713e.getVisibility() == 0 || this.f56714f.getVisibility() == 0) {
            return;
        }
        this.f56713e.setOnClickListener(this);
        this.f56713e.setVisibility(0);
        TextView textView = this.f56713e;
        ValueAnimator a = az.a(textView, 0, com.kwad.sdk.a.kwai.a.a(textView.getContext(), 44.0f));
        this.f56718j = a;
        a.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f56718j.setDuration(300L);
        this.f56718j.start();
    }

    private void g() {
        ValueAnimator valueAnimator = this.f56718j;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f56718j.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f56714f.getVisibility() == 0) {
            return;
        }
        this.f56714f.setOnClickListener(this);
        this.f56714f.setVisibility(0);
        this.f56713e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f56739c;
        this.f56715g = adTemplate;
        this.f56716h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f56717i = ((com.kwad.sdk.draw.kwai.a) this).a.f56740d;
        e();
        this.n.a(this.f56715g);
        this.f56713e.setText(com.kwad.sdk.core.response.a.a.A(this.f56716h));
        this.f56713e.setVisibility(8);
        this.f56714f.a(com.kwad.sdk.core.response.a.a.A(this.f56716h), this.f56714f.getMax());
        this.f56714f.setVisibility(8);
        this.f56710b.setVisibility(0);
        this.f56710b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.B(this.f56716h)) {
            this.f56711c.setText(com.kwad.sdk.core.response.a.a.t(this.f56716h));
            this.f56711c.setVisibility(0);
            com.kwad.sdk.core.download.a.b bVar = this.f56717i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.f56711c.setVisibility(8);
        }
        this.f56712d.setText(com.kwad.sdk.core.response.a.a.s(this.f56716h));
        ((com.kwad.sdk.draw.kwai.a) this).a.f56741e.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        KsAppDownloadListener ksAppDownloadListener;
        super.c();
        g();
        com.kwad.sdk.core.download.a.b bVar = this.f56717i;
        if (bVar != null && (ksAppDownloadListener = this.p) != null) {
            bVar.b(ksAppDownloadListener);
        }
        ((com.kwad.sdk.draw.kwai.a) this).a.f56741e.b(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56710b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f56711c = (TextView) a(R.id.ksad_ad_normal_title);
        this.f56712d = (TextView) a(R.id.ksad_ad_normal_des);
        this.n = (KsLogoView) a(R.id.ksad_ad_normal_logo);
        this.f56713e = (TextView) a(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) a(R.id.ksad_ad_light_convert_btn);
        this.f56714f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56710b) {
            h();
            a(false, 2);
            return;
        }
        if (view == this.f56713e) {
            h();
        } else if (view != this.f56714f) {
            return;
        }
        a(true, 1);
    }
}
