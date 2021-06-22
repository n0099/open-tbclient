package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.d.e;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class k extends a<e> {

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f33057d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.d.e f33058e;

    private void h() {
        com.kwad.sdk.contentalliance.detail.photo.d.e eVar = this.f33058e;
        if (eVar != null) {
            eVar.dismiss();
        }
        SlidePlayViewPager slidePlayViewPager = this.f33057d;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.a(true, 2);
        }
    }

    private void p() {
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a;
        com.kwad.sdk.contentalliance.detail.photo.d.d dVar = new com.kwad.sdk.contentalliance.detail.photo.d.d(cVar.j, cVar.f32819i);
        com.kwad.sdk.contentalliance.detail.photo.d.e eVar = this.f33058e;
        if (eVar == null || !eVar.isShowing()) {
            com.kwad.sdk.contentalliance.detail.photo.d.e eVar2 = new com.kwad.sdk.contentalliance.detail.photo.d.e(o(), dVar);
            this.f33058e = eVar2;
            eVar2.a(new e.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.k.1
                @Override // com.kwad.sdk.contentalliance.detail.photo.d.e.a
                public void a() {
                    ((com.kwad.sdk.contentalliance.detail.b) k.this).f32790a.n = true;
                    k.this.f33057d.a(false, 3);
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.d.e.a
                public void b() {
                    ((com.kwad.sdk.contentalliance.detail.b) k.this).f32790a.n = false;
                    k.this.f33057d.a(true, 3);
                }
            });
            this.f33058e.show();
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((e) ((a) this).f33029b).setOnClickListener(this);
        this.f33057d = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.l;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        h();
    }

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
        if (com.kwad.sdk.core.response.b.c.c(((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j)) {
            p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        } else {
            p();
        }
        com.kwad.sdk.core.report.e.c(((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j);
    }
}
