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
/* loaded from: classes5.dex */
public class a extends g implements c.a {
    public FrameLayout b;
    public com.kwad.sdk.core.page.c c;
    public AdTemplate d;
    public AdBaseFrameLayout e;
    public View f;
    public View g;
    public ComplianceTextView h;
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
            if (a.this.b == null || a.this.c == null || !a.this.c.d()) {
                return;
            }
            a.this.h.setVisibility(8);
            a.this.b.setVisibility(0);
            a.this.c.e();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = ((g) this).a.g;
        if (this.c == null) {
            com.kwad.sdk.core.page.c cVar = new com.kwad.sdk.core.page.c(q(), this.d, 4, false);
            this.c = cVar;
            cVar.a(this);
            this.c.a(new c.C0312c().b(false).a(true).a("").b(com.kwad.sdk.core.response.a.b.i(this.d)).a());
            this.b.addView(this.c.a());
            this.f = this.c.b();
            this.g = this.c.c();
        }
        this.i = 0L;
        this.j = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.e = aVar.j;
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
        this.b = (FrameLayout) a(R.id.obfuscated_res_0x7f091050);
        this.h = (ComplianceTextView) a(R.id.obfuscated_res_0x7f091013);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        com.kwad.sdk.core.page.c cVar = this.c;
        if (cVar != null) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onBackBtnClicked(View view2) {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.b != null) {
            long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(aVar.g));
            boolean z = true;
            if (p >= 0 && !this.j && this.i < p) {
                z = false;
            }
            if (z) {
                ((g) this).a.b.e();
            }
        }
        ((g) this).a.b.a(false);
        h();
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view2) {
    }
}
