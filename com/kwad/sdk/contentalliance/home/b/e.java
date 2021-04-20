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
    public LottieAnimationView f32960b;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f32961c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32962d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32963e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32964f = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.home.b.e.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            if (e.this.f32963e) {
                return;
            }
            e.this.f32963e = true;
            e.this.f();
            e.this.h();
        }
    };

    private void e() {
        Activity m = m();
        if (m == null || !com.kwad.sdk.utils.d.a(m)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32960b.getLayoutParams();
        int i = marginLayoutParams.topMargin;
        marginLayoutParams.topMargin = i + i;
        this.f32960b.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f32960b.c()) {
            return;
        }
        this.f32960b.b();
    }

    private void g() {
        com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.d.class);
        if (dVar != null) {
            dVar.a(o(), ((com.kwad.sdk.contentalliance.home.e) this).f33058a.f33063e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.e.e(this.f32961c);
    }

    private void p() {
        com.kwad.sdk.core.report.e.f(this.f32961c);
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33058a;
        this.f32961c = fVar.f33063e;
        com.kwad.sdk.core.i.a aVar = fVar.f33064f.f33078a;
        this.f32962d = aVar;
        if (aVar != null) {
            aVar.a(this.f32964f);
        }
        this.f32960b.setVisibility(0);
        this.f32960b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32963e = false;
        this.f32960b.d();
        com.kwad.sdk.core.i.a aVar = this.f32962d;
        if (aVar != null) {
            aVar.b(this.f32964f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_live_entry_icon);
        this.f32960b = lottieAnimationView;
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
