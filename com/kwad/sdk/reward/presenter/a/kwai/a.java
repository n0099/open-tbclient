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
/* loaded from: classes7.dex */
public class a extends g implements c.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f40902b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.page.c f40903c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f40904d;

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f40905e;

    /* renamed from: f  reason: collision with root package name */
    public View f40906f;

    /* renamed from: g  reason: collision with root package name */
    public View f40907g;

    /* renamed from: h  reason: collision with root package name */
    public ComplianceTextView f40908h;
    public volatile long i = 0;
    public volatile boolean j = false;
    public final com.kwad.sdk.contentalliance.detail.video.d k = new e() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            super.a(j, j2);
            a.this.i = j2;
            a.this.j = j - j2 < 800;
        }
    };
    public final f l = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (a.this.f40902b == null || a.this.f40903c == null || !a.this.f40903c.d()) {
                return;
            }
            a.this.f40908h.setVisibility(8);
            a.this.f40902b.setVisibility(0);
            a.this.f40903c.e();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40904d = ((g) this).a.f40747g;
        if (this.f40903c == null) {
            com.kwad.sdk.core.page.c cVar = new com.kwad.sdk.core.page.c(q(), this.f40904d, 4, false);
            this.f40903c = cVar;
            cVar.a(this);
            this.f40903c.a(new c.C1964c().b(false).a(true).a("").b(com.kwad.sdk.core.response.a.b.i(this.f40904d)).a());
            this.f40902b.addView(this.f40903c.a());
            this.f40906f = this.f40903c.b();
            this.f40907g = this.f40903c.c();
        }
        this.i = 0L;
        this.j = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f40905e = aVar.j;
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
        this.f40902b = (FrameLayout) a(R.id.obfuscated_res_0x7f091095);
        this.f40908h = (ComplianceTextView) a(R.id.obfuscated_res_0x7f091058);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        com.kwad.sdk.core.page.c cVar = this.f40903c;
        if (cVar != null) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onBackBtnClicked(View view) {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f40742b != null) {
            long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(aVar.f40747g));
            boolean z = true;
            if (p >= 0 && !this.j && this.i < p) {
                z = false;
            }
            if (z) {
                ((g) this).a.f40742b.e();
            }
        }
        ((g) this).a.f40742b.a(false);
        h();
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view) {
    }
}
