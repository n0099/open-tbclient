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
/* loaded from: classes3.dex */
public class a extends g implements c.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f57423b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.page.c f57424c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f57425d;

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f57426e;

    /* renamed from: f  reason: collision with root package name */
    public View f57427f;

    /* renamed from: g  reason: collision with root package name */
    public View f57428g;

    /* renamed from: h  reason: collision with root package name */
    public ComplianceTextView f57429h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f57430i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f57431j = false;
    public final com.kwad.sdk.contentalliance.detail.video.d k = new e() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            a.this.f57430i = j3;
            a.this.f57431j = j2 - j3 < 800;
        }
    };
    public final f l = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (a.this.f57423b == null || a.this.f57424c == null || !a.this.f57424c.d()) {
                return;
            }
            a.this.f57429h.setVisibility(8);
            a.this.f57423b.setVisibility(0);
            a.this.f57424c.e();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f57425d = ((g) this).a.f57252g;
        if (this.f57424c == null) {
            com.kwad.sdk.core.page.c cVar = new com.kwad.sdk.core.page.c(q(), this.f57425d, 4, false);
            this.f57424c = cVar;
            cVar.a(this);
            this.f57424c.a(new c.C2114c().b(false).a(true).a("").b(com.kwad.sdk.core.response.a.b.i(this.f57425d)).a());
            this.f57423b.addView(this.f57424c.a());
            this.f57427f = this.f57424c.b();
            this.f57428g = this.f57424c.c();
        }
        this.f57430i = 0L;
        this.f57431j = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57426e = aVar.f57255j;
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
        this.f57423b = (FrameLayout) a(R.id.ksad_interactive_landing_page_container);
        this.f57429h = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        com.kwad.sdk.core.page.c cVar = this.f57424c;
        if (cVar != null) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onBackBtnClicked(View view) {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f57247b != null) {
            long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(aVar.f57252g));
            boolean z = true;
            if (p >= 0 && !this.f57431j && this.f57430i < p) {
                z = false;
            }
            if (z) {
                ((g) this).a.f57247b.e();
            }
        }
        ((g) this).a.f57247b.a(false);
        h();
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view) {
    }
}
