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
    public ViewGroup f33144b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33145c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33146d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33147e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f33148f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f33149g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f33150h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33151i;
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
                ((com.kwad.sdk.draw.a.a) bVar).f33120a.f33126f.a();
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
            b.this.f33147e.setText(com.kwad.sdk.core.response.b.a.a());
            b.this.f33148f.a(com.kwad.sdk.core.response.b.a.a(), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            b.this.f33147e.setText(com.kwad.sdk.core.response.b.a.u(b.this.f33150h));
            b.this.f33148f.a(com.kwad.sdk.core.response.b.a.u(b.this.f33150h), b.this.f33148f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            b.this.f33147e.setText(com.kwad.sdk.core.response.b.a.a(b.this.f33149g));
            b.this.f33148f.a(com.kwad.sdk.core.response.b.a.a(b.this.f33149g), b.this.f33148f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            b.this.f33147e.setText(com.kwad.sdk.core.response.b.a.u(b.this.f33150h));
            b.this.f33148f.a(com.kwad.sdk.core.response.b.a.u(b.this.f33150h), b.this.f33148f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            b.this.f33147e.setText(com.kwad.sdk.core.response.b.a.j(b.this.f33150h));
            b.this.f33148f.a(com.kwad.sdk.core.response.b.a.j(b.this.f33150h), b.this.f33148f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            TextView textView = b.this.f33147e;
            textView.setText(i2 + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = b.this.f33148f;
            drawDownloadProgressBar.a(i2 + "%", i2);
        }
    };

    private void a(boolean z) {
        com.kwad.sdk.core.download.b.a.a(this.f33144b.getContext(), this.f33149g, new a.InterfaceC0363a() { // from class: com.kwad.sdk.draw.b.b.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
            public void a() {
                com.kwad.sdk.core.report.b.a(b.this.f33149g, 1, ((com.kwad.sdk.draw.a.a) b.this).f33120a.f33122b.getTouchCoords());
                if (((com.kwad.sdk.draw.a.a) b.this).f33120a.f33121a != null) {
                    ((com.kwad.sdk.draw.a.a) b.this).f33120a.f33121a.onAdClicked();
                }
            }
        }, this.f33151i, z);
    }

    private void e() {
        this.k = com.kwad.sdk.core.response.b.a.N(this.f33150h);
        this.l = com.kwad.sdk.core.response.b.a.O(this.f33150h);
        this.m = com.kwad.sdk.core.response.b.a.P(this.f33150h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f33147e.getVisibility() == 0 || this.f33148f.getVisibility() == 0) {
            return;
        }
        this.f33147e.setOnClickListener(this);
        this.f33147e.setVisibility(0);
        TextView textView = this.f33147e;
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
        if (this.f33148f.getVisibility() == 0) {
            return;
        }
        this.f33148f.setOnClickListener(this);
        this.f33148f.setVisibility(0);
        this.f33147e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f33120a.f33123c;
        this.f33149g = adTemplate;
        this.f33150h = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33151i = ((com.kwad.sdk.draw.a.a) this).f33120a.f33124d;
        e();
        this.n.a(this.f33149g);
        this.f33147e.setText(com.kwad.sdk.core.response.b.a.u(this.f33150h));
        this.f33147e.setVisibility(8);
        this.f33148f.a(com.kwad.sdk.core.response.b.a.u(this.f33150h), this.f33148f.getMax());
        this.f33148f.setVisibility(8);
        this.f33144b.setVisibility(0);
        this.f33144b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.v(this.f33150h)) {
            this.f33145c.setText(com.kwad.sdk.core.response.b.a.o(this.f33150h));
            this.f33145c.setVisibility(0);
            com.kwad.sdk.core.download.b.b bVar = this.f33151i;
            if (bVar != null) {
                bVar.a(this.p);
            }
        } else {
            this.f33145c.setVisibility(8);
        }
        this.f33146d.setText(com.kwad.sdk.core.response.b.a.m(this.f33150h));
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33125e.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33144b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f33145c = (TextView) a(R.id.ksad_ad_normal_title);
        this.f33146d = (TextView) a(R.id.ksad_ad_normal_des);
        this.n = (KsLogoView) a(R.id.ksad_ad_normal_logo);
        this.f33147e = (TextView) a(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) a(R.id.ksad_ad_light_convert_btn);
        this.f33148f = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        KsAppDownloadListener ksAppDownloadListener;
        super.c();
        n();
        com.kwad.sdk.core.download.b.b bVar = this.f33151i;
        if (bVar != null && (ksAppDownloadListener = this.p) != null) {
            bVar.b(ksAppDownloadListener);
        }
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33125e.b(this.o);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33144b) {
            o();
            a(false);
            return;
        }
        if (view == this.f33147e) {
            o();
        } else if (view != this.f33148f) {
            return;
        }
        a(true);
    }
}
