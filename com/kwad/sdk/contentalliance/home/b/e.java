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
    public LottieAnimationView f32670b;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f32671c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32672d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32673e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32674f = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.home.b.e.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            if (e.this.f32673e) {
                return;
            }
            e.this.f32673e = true;
            e.this.f();
            e.this.h();
        }
    };

    private void e() {
        Activity m = m();
        if (m == null || !com.kwad.sdk.utils.d.a(m)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32670b.getLayoutParams();
        int i = marginLayoutParams.topMargin;
        marginLayoutParams.topMargin = i + i;
        this.f32670b.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f32670b.c()) {
            return;
        }
        this.f32670b.b();
    }

    private void g() {
        com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.d.class);
        if (dVar != null) {
            dVar.a(o(), ((com.kwad.sdk.contentalliance.home.e) this).f32768a.f32773e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.e.e(this.f32671c);
    }

    private void p() {
        com.kwad.sdk.core.report.e.f(this.f32671c);
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f32768a;
        this.f32671c = fVar.f32773e;
        com.kwad.sdk.core.i.a aVar = fVar.f32774f.f32788a;
        this.f32672d = aVar;
        if (aVar != null) {
            aVar.a(this.f32674f);
        }
        this.f32670b.setVisibility(0);
        this.f32670b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32673e = false;
        this.f32670b.d();
        com.kwad.sdk.core.i.a aVar = this.f32672d;
        if (aVar != null) {
            aVar.b(this.f32674f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_live_entry_icon);
        this.f32670b = lottieAnimationView;
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
