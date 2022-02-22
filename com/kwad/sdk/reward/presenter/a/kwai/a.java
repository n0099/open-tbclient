package com.kwad.sdk.reward.presenter.a.kwai;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes4.dex */
public class a extends g implements c.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f57590b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.page.c f57591c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f57592d;

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f57593e;

    /* renamed from: f  reason: collision with root package name */
    public View f57594f;

    /* renamed from: g  reason: collision with root package name */
    public View f57595g;

    /* renamed from: h  reason: collision with root package name */
    public ComplianceTextView f57596h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f57597i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f57598j = false;
    public final com.kwad.sdk.contentalliance.detail.video.d k = new e() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            a.this.f57597i = j3;
            a.this.f57598j = j2 - j3 < 800;
        }
    };
    public final f l = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (a.this.f57590b == null || a.this.f57591c == null || !a.this.f57591c.d()) {
                return;
            }
            a.this.f57596h.setVisibility(8);
            a.this.f57590b.setVisibility(0);
            a.this.f57591c.e();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f57592d = ((g) this).a.f57419g;
        if (this.f57591c == null) {
            com.kwad.sdk.core.page.c cVar = new com.kwad.sdk.core.page.c(q(), this.f57592d, 4, false);
            this.f57591c = cVar;
            cVar.a(this);
            this.f57591c.a(new c.C2124c().b(false).a(true).a("").b(com.kwad.sdk.core.response.a.b.i(this.f57592d)).a());
            this.f57590b.addView(this.f57591c.a());
            this.f57594f = this.f57591c.b();
            this.f57595g = this.f57591c.c();
        }
        this.f57597i = 0L;
        this.f57598j = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57593e = aVar.f57422j;
        aVar.a(this.l);
        ((g) this).a.k.a(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.l);
        ((g) this).a.k.b(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57590b = (FrameLayout) a(R.id.ksad_interactive_landing_page_container);
        this.f57596h = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        com.kwad.sdk.core.page.c cVar = this.f57591c;
        if (cVar != null) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onBackBtnClicked(View view) {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f57414b != null) {
            long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(aVar.f57419g));
            boolean z = true;
            if (p >= 0 && !this.f57598j && this.f57597i < p) {
                z = false;
            }
            if (z) {
                ((g) this).a.f57414b.e();
            }
        }
        ((g) this).a.f57414b.a(false);
        h();
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view) {
    }
}
