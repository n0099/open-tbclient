package com.kwad.sdk.reward.presenter.a.kwai;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes8.dex */
public class a extends g implements c.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f55940b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.page.c f55941c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f55942d;

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f55943e;

    /* renamed from: f  reason: collision with root package name */
    public View f55944f;

    /* renamed from: g  reason: collision with root package name */
    public View f55945g;

    /* renamed from: h  reason: collision with root package name */
    public ComplianceTextView f55946h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f55947i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f55948j = false;
    public final com.kwad.sdk.contentalliance.detail.video.d k = new e() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            a.this.f55947i = j3;
            a.this.f55948j = j2 - j3 < 800;
        }
    };
    public final f l = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (a.this.f55940b == null || a.this.f55941c == null || !a.this.f55941c.d()) {
                return;
            }
            a.this.f55946h.setVisibility(8);
            a.this.f55940b.setVisibility(0);
            a.this.f55941c.e();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f55942d = ((g) this).a.f55769g;
        if (this.f55941c == null) {
            com.kwad.sdk.core.page.c cVar = new com.kwad.sdk.core.page.c(q(), this.f55942d, 4, false);
            this.f55941c = cVar;
            cVar.a(this);
            this.f55941c.a(new c.C2103c().b(false).a(true).a("").b(com.kwad.sdk.core.response.a.b.i(this.f55942d)).a());
            this.f55940b.addView(this.f55941c.a());
            this.f55944f = this.f55941c.b();
            this.f55945g = this.f55941c.c();
        }
        this.f55947i = 0L;
        this.f55948j = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f55943e = aVar.f55772j;
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
        this.f55940b = (FrameLayout) a(R.id.ksad_interactive_landing_page_container);
        this.f55946h = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        com.kwad.sdk.core.page.c cVar = this.f55941c;
        if (cVar != null) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onBackBtnClicked(View view) {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f55764b != null) {
            long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(aVar.f55769g));
            boolean z = true;
            if (p >= 0 && !this.f55948j && this.f55947i < p) {
                z = false;
            }
            if (z) {
                ((g) this).a.f55764b.e();
            }
        }
        ((g) this).a.f55764b.a(false);
        h();
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view) {
    }
}
