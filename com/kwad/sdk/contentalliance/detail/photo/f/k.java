package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.d.e;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.utils.p;
/* loaded from: classes3.dex */
public class k extends a<e> {
    private SlidePlayViewPager d;
    private com.kwad.sdk.contentalliance.detail.photo.d.e e;

    private void h() {
        if (this.e != null) {
            this.e.dismiss();
        }
        if (this.d != null) {
            this.d.a(true, 2);
        }
    }

    private void p() {
        com.kwad.sdk.contentalliance.detail.photo.d.d dVar = new com.kwad.sdk.contentalliance.detail.photo.d.d(this.f8395a.j, this.f8395a.i);
        if (this.e == null || !this.e.isShowing()) {
            this.e = new com.kwad.sdk.contentalliance.detail.photo.d.e(o(), dVar);
            this.e.a(new e.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.k.1
                @Override // com.kwad.sdk.contentalliance.detail.photo.d.e.a
                public void a() {
                    k.this.f8395a.n = true;
                    k.this.d.a(false, 3);
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.d.e.a
                public void b() {
                    k.this.f8395a.n = false;
                    k.this.d.a(true, 3);
                }
            });
            this.e.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((e) this.f8516b).setOnClickListener(this);
        this.d = this.f8395a.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public e g() {
        return new e(o());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f8395a.j)) {
            p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        } else {
            p();
        }
        com.kwad.sdk.core.report.e.c(this.f8395a.j);
    }
}
