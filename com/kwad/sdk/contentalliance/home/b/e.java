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
    public LottieAnimationView f32671b;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f32672c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32673d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32674e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32675f = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.home.b.e.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            if (e.this.f32674e) {
                return;
            }
            e.this.f32674e = true;
            e.this.f();
            e.this.h();
        }
    };

    private void e() {
        Activity m = m();
        if (m == null || !com.kwad.sdk.utils.d.a(m)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32671b.getLayoutParams();
        int i = marginLayoutParams.topMargin;
        marginLayoutParams.topMargin = i + i;
        this.f32671b.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f32671b.c()) {
            return;
        }
        this.f32671b.b();
    }

    private void g() {
        com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.d.class);
        if (dVar != null) {
            dVar.a(o(), ((com.kwad.sdk.contentalliance.home.e) this).f32769a.f32774e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.e.e(this.f32672c);
    }

    private void p() {
        com.kwad.sdk.core.report.e.f(this.f32672c);
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f32769a;
        this.f32672c = fVar.f32774e;
        com.kwad.sdk.core.i.a aVar = fVar.f32775f.f32789a;
        this.f32673d = aVar;
        if (aVar != null) {
            aVar.a(this.f32675f);
        }
        this.f32671b.setVisibility(0);
        this.f32671b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32674e = false;
        this.f32671b.d();
        com.kwad.sdk.core.i.a aVar = this.f32673d;
        if (aVar != null) {
            aVar.b(this.f32675f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_live_entry_icon);
        this.f32671b = lottieAnimationView;
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
