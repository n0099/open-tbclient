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
    public FrameLayout f59631b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.page.c f59632c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f59633d;

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f59634e;

    /* renamed from: f  reason: collision with root package name */
    public View f59635f;

    /* renamed from: g  reason: collision with root package name */
    public View f59636g;

    /* renamed from: h  reason: collision with root package name */
    public ComplianceTextView f59637h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f59638i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f59639j = false;

    /* renamed from: k  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.video.d f59640k = new e() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            a.this.f59638i = j3;
            a.this.f59639j = j2 - j3 < 800;
        }
    };
    public final f l = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (a.this.f59631b == null || a.this.f59632c == null || !a.this.f59632c.d()) {
                return;
            }
            a.this.f59637h.setVisibility(8);
            a.this.f59631b.setVisibility(0);
            a.this.f59632c.e();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f59633d = ((g) this).a.f59455g;
        if (this.f59632c == null) {
            com.kwad.sdk.core.page.c cVar = new com.kwad.sdk.core.page.c(q(), this.f59633d, 4, false);
            this.f59632c = cVar;
            cVar.a(this);
            this.f59632c.a(new c.C2091c().b(false).a(true).a("").b(com.kwad.sdk.core.response.a.b.i(this.f59633d)).a());
            this.f59631b.addView(this.f59632c.a());
            this.f59635f = this.f59632c.b();
            this.f59636g = this.f59632c.c();
        }
        this.f59638i = 0L;
        this.f59639j = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f59634e = aVar.f59458j;
        aVar.a(this.l);
        ((g) this).a.f59459k.a(this.f59640k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.l);
        ((g) this).a.f59459k.b(this.f59640k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59631b = (FrameLayout) a(R.id.ksad_interactive_landing_page_container);
        this.f59637h = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        com.kwad.sdk.core.page.c cVar = this.f59632c;
        if (cVar != null) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onBackBtnClicked(View view) {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f59450b != null) {
            long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(aVar.f59455g));
            boolean z = true;
            if (p >= 0 && !this.f59639j && this.f59638i < p) {
                z = false;
            }
            if (z) {
                ((g) this).a.f59450b.e();
            }
        }
        ((g) this).a.f59450b.a(false);
        h();
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view) {
    }
}
