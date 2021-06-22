package com.kwad.sdk.contentalliance.home.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.contentalliance.home.e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f33353b;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f33354c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33355d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33356e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33357f = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.home.b.e.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            if (e.this.f33356e) {
                return;
            }
            e.this.f33356e = true;
            e.this.f();
            e.this.h();
        }
    };

    private void e() {
        Activity m = m();
        if (m == null || !com.kwad.sdk.utils.d.a(m)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33353b.getLayoutParams();
        int i2 = marginLayoutParams.topMargin;
        marginLayoutParams.topMargin = i2 + i2;
        this.f33353b.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f33353b.c()) {
            return;
        }
        this.f33353b.b();
    }

    private void g() {
        com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.d.class);
        if (dVar != null) {
            dVar.a(o(), ((com.kwad.sdk.contentalliance.home.e) this).f33455a.f33460e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.e.e(this.f33354c);
    }

    private void p() {
        com.kwad.sdk.core.report.e.f(this.f33354c);
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33455a;
        this.f33354c = fVar.f33460e;
        com.kwad.sdk.core.i.a aVar = fVar.f33461f.f33477a;
        this.f33355d = aVar;
        if (aVar != null) {
            aVar.a(this.f33357f);
        }
        this.f33353b.setVisibility(0);
        this.f33353b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33356e = false;
        this.f33353b.d();
        com.kwad.sdk.core.i.a aVar = this.f33355d;
        if (aVar != null) {
            aVar.b(this.f33357f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_live_entry_icon);
        this.f33353b = lottieAnimationView;
        lottieAnimationView.setAnimation(R.raw.ksad_live_home_entry_icon);
        e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.a()) {
            return;
        }
        g();
        p();
    }
}
