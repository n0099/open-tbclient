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
/* loaded from: classes4.dex */
public class c extends com.kwad.sdk.draw.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56922b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56923c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56924d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56925e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f56926f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f56927g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f56928h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56929i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f56930j;
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
                ((com.kwad.sdk.draw.kwai.a) cVar).a.f56954f.a();
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
            c.this.f56925e.setText(com.kwad.sdk.core.response.a.a.a());
            c.this.f56926f.a(com.kwad.sdk.core.response.a.a.a(), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            c.this.f56925e.setText(com.kwad.sdk.core.response.a.a.A(c.this.f56928h));
            c.this.f56926f.a(com.kwad.sdk.core.response.a.a.A(c.this.f56928h), c.this.f56926f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            c.this.f56925e.setText(com.kwad.sdk.core.response.a.a.a(c.this.f56927g));
            c.this.f56926f.a(com.kwad.sdk.core.response.a.a.a(c.this.f56927g), c.this.f56926f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            c.this.f56925e.setText(com.kwad.sdk.core.response.a.a.A(c.this.f56928h));
            c.this.f56926f.a(com.kwad.sdk.core.response.a.a.A(c.this.f56928h), c.this.f56926f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            c.this.f56925e.setText(com.kwad.sdk.core.response.a.a.m(c.this.f56928h));
            c.this.f56926f.a(com.kwad.sdk.core.response.a.a.m(c.this.f56928h), c.this.f56926f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            TextView textView = c.this.f56925e;
            textView.setText(i2 + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = c.this.f56926f;
            drawDownloadProgressBar.a(i2 + "%", i2);
        }
    };

    private void a(boolean z, int i2) {
        com.kwad.sdk.core.download.a.a.a(new a.C2116a(this.f56922b.getContext()).a(this.f56927g).a(this.f56929i).a(i2).a(z).a(new a.b() { // from class: com.kwad.sdk.draw.a.c.3
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(c.this.f56927g, 1, ((com.kwad.sdk.draw.kwai.a) c.this).a.f56950b.getTouchCoords());
                if (((com.kwad.sdk.draw.kwai.a) c.this).a.a != null) {
                    ((com.kwad.sdk.draw.kwai.a) c.this).a.a.onAdClicked();
                }
            }
        }));
    }

    private void e() {
        this.k = com.kwad.sdk.core.response.a.a.X(this.f56928h);
        this.l = com.kwad.sdk.core.response.a.a.Y(this.f56928h);
        this.m = com.kwad.sdk.core.response.a.a.Z(this.f56928h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f56925e.getVisibility() == 0 || this.f56926f.getVisibility() == 0) {
            return;
        }
        this.f56925e.setOnClickListener(this);
        this.f56925e.setVisibility(0);
        TextView textView = this.f56925e;
        ValueAnimator a = az.a(textView, 0, com.kwad.sdk.a.kwai.a.a(textView.getContext(), 44.0f));
        this.f56930j = a;
        a.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f56930j.setDuration(300L);
        this.f56930j.start();
    }

    private void g() {
        ValueAnimator valueAnimator = this.f56930j;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f56930j.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f56926f.getVisibility() == 0) {
            return;
        }
        this.f56926f.setOnClickListener(this);
        this.f56926f.setVisibility(0);
        this.f56925e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f56951c;
        this.f56927g = adTemplate;
        this.f56928h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f56929i = ((com.kwad.sdk.draw.kwai.a) this).a.f56952d;
        e();
        this.n.a(this.f56927g);
        this.f56925e.setText(com.kwad.sdk.core.response.a.a.A(this.f56928h));
        this.f56925e.setVisibility(8);
        this.f56926f.a(com.kwad.sdk.core.response.a.a.A(this.f56928h), this.f56926f.getMax());
        this.f56926f.setVisibility(8);
        this.f56922b.setVisibility(0);
        this.f56922b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.B(this.f56928h)) {
            this.f56923c.setText(com.kwad.sdk.core.response.a.a.t(this.f56928h));
            this.f56923c.setVisibility(0);
            com.kwad.sdk.core.download.a.b bVar = this.f56929i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.f56923c.setVisibility(8);
        }
        this.f56924d.setText(com.kwad.sdk.core.response.a.a.s(this.f56928h));
        ((com.kwad.sdk.draw.kwai.a) this).a.f56953e.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        KsAppDownloadListener ksAppDownloadListener;
        super.c();
        g();
        com.kwad.sdk.core.download.a.b bVar = this.f56929i;
        if (bVar != null && (ksAppDownloadListener = this.p) != null) {
            bVar.b(ksAppDownloadListener);
        }
        ((com.kwad.sdk.draw.kwai.a) this).a.f56953e.b(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56922b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f56923c = (TextView) a(R.id.ksad_ad_normal_title);
        this.f56924d = (TextView) a(R.id.ksad_ad_normal_des);
        this.n = (KsLogoView) a(R.id.ksad_ad_normal_logo);
        this.f56925e = (TextView) a(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) a(R.id.ksad_ad_light_convert_btn);
        this.f56926f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56922b) {
            h();
            a(false, 2);
            return;
        }
        if (view == this.f56925e) {
            h();
        } else if (view != this.f56926f) {
            return;
        }
        a(true, 1);
    }
}
