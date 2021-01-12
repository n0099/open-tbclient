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
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private AdBaseFrameLayout f8345b;
    private ViewGroup c;
    private AdDownloadProgressBar d;
    private AdDownloadProgressBar e;
    private ValueAnimator f;
    private ValueAnimator g;
    private AdTemplate h;
    private AdInfo i;
    @Nullable
    private com.kwad.sdk.core.download.b.b j;
    private com.kwad.sdk.contentalliance.detail.video.b k;
    private com.kwad.sdk.contentalliance.a.a l = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.s();
            a.this.t();
        }
    };
    private e m = new f() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            a.this.t();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= com.kwad.sdk.core.response.b.b.g(a.this.h)) {
                return;
            }
            if (j2 >= com.kwad.sdk.core.response.b.b.f(a.this.h)) {
                a.this.p();
            } else if (j2 >= com.kwad.sdk.core.response.b.b.e(a.this.h)) {
                a.this.g();
            }
        }
    };
    private KsAppDownloadListener n = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.3
        @Override // com.kwad.sdk.core.download.b.c
        public void a(int i) {
            a.this.d.a(com.kwad.sdk.core.response.b.a.b(a.this.i, i), i);
            a.this.e.a(com.kwad.sdk.core.response.b.a.b(a.this.i, i), i);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            a.this.d.setText(com.kwad.sdk.core.response.b.a.x(a.this.i));
            a.this.e.setText(com.kwad.sdk.core.response.b.a.x(a.this.i));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            a.this.d.setText(com.kwad.sdk.core.response.b.a.a(a.this.h));
            a.this.e.setText(com.kwad.sdk.core.response.b.a.a(a.this.h));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            a.this.d.setText(com.kwad.sdk.core.response.b.a.x(a.this.i));
            a.this.e.setText(com.kwad.sdk.core.response.b.a.x(a.this.i));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            a.this.d.setText(com.kwad.sdk.core.response.b.a.b());
            a.this.e.setText(com.kwad.sdk.core.response.b.a.b());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            a.this.d.a(com.kwad.sdk.core.response.b.a.a(a.this.i, i), i);
            a.this.e.a(com.kwad.sdk.core.response.b.a.a(a.this.i, i), i);
        }
    };

    private void e() {
        this.d.setProgressDrawable(Color.parseColor("#4D36384B"));
        this.d.setTextColor(Color.parseColor("#66FFFFFF"));
        this.d.a(null, null, o().getResources().getDrawable(R.drawable.ksad_btn_arrow_gray), null, ao.a(o(), 2.0f));
    }

    private void f() {
        this.e.setTextColor(Color.parseColor("#CCFFFFFF"));
        this.e.a(null, null, o().getResources().getDrawable(R.drawable.ksad_btn_arrow_light), null, ao.a(o(), 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.d.getVisibility() == 0 || this.e.getVisibility() == 0) {
            return;
        }
        v();
        h();
        this.d.setAlpha(1.0f);
        this.d.setVisibility(0);
        this.d.setOnClickListener(this);
        this.f = am.d(this.c, 0, ao.a(this.c.getContext(), 39.0f));
        this.f.start();
    }

    private void h() {
        if (this.f != null) {
            this.f.removeAllListeners();
            this.f.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.e.getVisibility() == 0) {
            return;
        }
        q();
        this.c.setVisibility(0);
        this.e.setOnClickListener(this);
        this.g = am.a(this.d, this.e);
        this.g.start();
    }

    private void q() {
        if (this.g != null) {
            this.g.removeAllListeners();
            this.g.cancel();
        }
    }

    private void r() {
        h();
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        q();
        this.e.setAlpha(1.0f);
        this.e.setVisibility(8);
        this.c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        h();
        this.d.setAlpha(1.0f);
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.kwad.sdk.core.report.b.a(this.h, 1, this.f8345b.getTouchCoords());
    }

    private void v() {
        com.kwad.sdk.core.report.b.c(this.h, 19, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.h = this.f8393a.j;
        this.i = com.kwad.sdk.core.response.b.c.j(this.h);
        this.j = this.f8393a.o;
        this.k = this.f8393a.m;
        this.d.setText(com.kwad.sdk.core.response.b.a.x(this.i));
        this.d.setVisibility(8);
        this.e.setText(com.kwad.sdk.core.response.b.a.x(this.i));
        this.e.setProgressDrawable(Color.parseColor(com.kwad.sdk.core.response.b.a.X(this.i)));
        this.e.setVisibility(8);
        if (this.j != null) {
            this.j.a(this.n);
        }
        if (this.k != null) {
            this.k.a(this.m);
        }
        this.f8393a.f8403b.add(this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        r();
        if (this.j != null) {
            this.j.b(this.n);
        }
        if (this.k != null) {
            this.k.b(this.m);
        }
        this.f8393a.f8403b.remove(this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8345b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.c = (ViewGroup) b(R.id.ksad_progress_container);
        this.d = (AdDownloadProgressBar) b(R.id.ksad_translate_progress);
        this.e = (AdDownloadProgressBar) b(R.id.ksad_light_progress);
        e();
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.j, true);
        com.kwad.sdk.core.download.b.a.a(this.d.getContext(), this.h, new a.InterfaceC1088a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.4
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1088a
            public void a() {
                a.this.u();
            }
        }, this.j);
    }
}
