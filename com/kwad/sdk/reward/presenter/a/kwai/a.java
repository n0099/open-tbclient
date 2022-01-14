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
    public FrameLayout f57378b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.page.c f57379c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f57380d;

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f57381e;

    /* renamed from: f  reason: collision with root package name */
    public View f57382f;

    /* renamed from: g  reason: collision with root package name */
    public View f57383g;

    /* renamed from: h  reason: collision with root package name */
    public ComplianceTextView f57384h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f57385i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f57386j = false;
    public final com.kwad.sdk.contentalliance.detail.video.d k = new e() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            a.this.f57385i = j3;
            a.this.f57386j = j2 - j3 < 800;
        }
    };
    public final f l = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (a.this.f57378b == null || a.this.f57379c == null || !a.this.f57379c.d()) {
                return;
            }
            a.this.f57384h.setVisibility(8);
            a.this.f57378b.setVisibility(0);
            a.this.f57379c.e();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f57380d = ((g) this).a.f57207g;
        if (this.f57379c == null) {
            com.kwad.sdk.core.page.c cVar = new com.kwad.sdk.core.page.c(q(), this.f57380d, 4, false);
            this.f57379c = cVar;
            cVar.a(this);
            this.f57379c.a(new c.C2108c().b(false).a(true).a("").b(com.kwad.sdk.core.response.a.b.i(this.f57380d)).a());
            this.f57378b.addView(this.f57379c.a());
            this.f57382f = this.f57379c.b();
            this.f57383g = this.f57379c.c();
        }
        this.f57385i = 0L;
        this.f57386j = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57381e = aVar.f57210j;
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
        this.f57378b = (FrameLayout) a(R.id.ksad_interactive_landing_page_container);
        this.f57384h = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        com.kwad.sdk.core.page.c cVar = this.f57379c;
        if (cVar != null) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onBackBtnClicked(View view) {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f57202b != null) {
            long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(aVar.f57207g));
            boolean z = true;
            if (p >= 0 && !this.f57386j && this.f57385i < p) {
                z = false;
            }
            if (z) {
                ((g) this).a.f57202b.e();
            }
        }
        ((g) this).a.f57202b.a(false);
        h();
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view) {
    }
}
