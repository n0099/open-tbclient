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
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.draw.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f9684b;
    private TextView c;
    private TextView d;
    private TextView e;
    private DrawDownloadProgressBar f;
    private AdTemplate g;
    private AdInfo h;
    @Nullable
    private com.kwad.sdk.core.download.b.b i;
    private ValueAnimator j;
    private int k;
    private int l;
    private int m;
    private KsLogoView n;
    private e o = new f() { // from class: com.kwad.sdk.draw.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= b.this.m * 1000) {
                b.this.f9673a.f.a();
            } else if (j2 >= b.this.l * 1000) {
                b.this.p();
            } else if (j2 >= b.this.k * 1000) {
                b.this.g();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
        }
    };
    private KsAppDownloadListener p = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.draw.b.b.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            b.this.e.setText(com.kwad.sdk.core.response.b.a.w(b.this.h));
            b.this.f.a(com.kwad.sdk.core.response.b.a.w(b.this.h), b.this.f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            b.this.e.setText(com.kwad.sdk.core.response.b.a.a(b.this.g));
            b.this.f.a(com.kwad.sdk.core.response.b.a.a(b.this.g), b.this.f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            b.this.e.setText(com.kwad.sdk.core.response.b.a.w(b.this.h));
            b.this.f.a(com.kwad.sdk.core.response.b.a.w(b.this.h), b.this.f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            b.this.e.setText(com.kwad.sdk.core.response.b.a.b());
            b.this.f.a(com.kwad.sdk.core.response.b.a.b(), b.this.f.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            b.this.e.setText(i + "%");
            b.this.f.a(i + "%", i);
        }
    };

    private void e() {
        this.k = com.kwad.sdk.core.response.b.a.R(this.h);
        this.l = com.kwad.sdk.core.response.b.a.S(this.h);
        this.m = com.kwad.sdk.core.response.b.a.T(this.h);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f9684b.getContext(), this.g, new a.InterfaceC1088a() { // from class: com.kwad.sdk.draw.b.b.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1088a
            public void a() {
                com.kwad.sdk.core.report.b.a(b.this.g, 1, b.this.f9673a.f9675b.getTouchCoords());
                if (b.this.f9673a.f9674a != null) {
                    b.this.f9673a.f9674a.onAdClicked();
                }
            }
        }, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.e.getVisibility() == 0 || this.f.getVisibility() == 0) {
            return;
        }
        this.e.setOnClickListener(this);
        this.e.setVisibility(0);
        this.j = am.a(this.e, 0, ao.a(this.e.getContext(), 44.0f));
        this.j.setInterpolator(new DecelerateInterpolator(2.0f));
        this.j.setDuration(300L);
        this.j.start();
    }

    private void h() {
        if (this.j != null) {
            this.j.removeAllListeners();
            this.j.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f.getVisibility() == 0) {
            return;
        }
        this.f.setOnClickListener(this);
        this.f.setVisibility(0);
        this.e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.g = this.f9673a.c;
        this.h = com.kwad.sdk.core.response.b.c.j(this.g);
        this.i = this.f9673a.d;
        e();
        this.n.a(this.g);
        this.e.setText(com.kwad.sdk.core.response.b.a.w(this.h));
        this.e.setVisibility(8);
        this.f.a(com.kwad.sdk.core.response.b.a.w(this.h), this.f.getMax());
        this.f.setVisibility(8);
        this.f9684b.setVisibility(0);
        this.f9684b.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.y(this.h)) {
            this.c.setText(com.kwad.sdk.core.response.b.a.q(this.h));
            this.c.setVisibility(0);
            if (this.i != null) {
                this.i.a(this.p);
            }
        } else {
            this.c.setVisibility(8);
        }
        this.d.setText(com.kwad.sdk.core.response.b.a.n(this.h));
        this.f9673a.e.a(this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        h();
        if (this.i != null && this.p != null) {
            this.i.b(this.p);
        }
        this.f9673a.e.b(this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9684b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.c = (TextView) b(R.id.ksad_ad_normal_title);
        this.d = (TextView) b(R.id.ksad_ad_normal_des);
        this.n = (KsLogoView) b(R.id.ksad_ad_normal_logo);
        this.e = (TextView) b(R.id.ksad_ad_normal_convert_btn);
        this.f = (DrawDownloadProgressBar) b(R.id.ksad_ad_light_convert_btn);
        this.f.setTextSize(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f9684b) {
            p();
            f();
        } else if (view == this.e) {
            p();
            f();
        } else if (view == this.f) {
            f();
        }
    }
}
