package com.kwad.sdk.contentalliance.home.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
/* loaded from: classes5.dex */
public class e extends com.kwad.sdk.contentalliance.home.e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f8988b;
    private SceneImpl c;
    private com.kwad.sdk.core.i.a d;
    private boolean e;
    private com.kwad.sdk.core.i.c f = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.home.b.e.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            if (e.this.e) {
                return;
            }
            e.this.e = true;
            e.this.f();
            e.this.h();
        }
    };

    private void e() {
        Activity m = m();
        if (m == null || !com.kwad.sdk.utils.d.a(m)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8988b.getLayoutParams();
        marginLayoutParams.topMargin += marginLayoutParams.topMargin;
        this.f8988b.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f8988b.c()) {
            return;
        }
        this.f8988b.b();
    }

    private void g() {
        com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.d.class);
        if (dVar != null) {
            dVar.a(o(), this.f9034a.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.e.e(this.c);
    }

    private void p() {
        com.kwad.sdk.core.report.e.f(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f9034a.e;
        this.d = this.f9034a.f.f9042a;
        if (this.d != null) {
            this.d.a(this.f);
        }
        this.f8988b.setVisibility(0);
        this.f8988b.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.e = false;
        this.f8988b.d();
        if (this.d != null) {
            this.d.b(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8988b = (LottieAnimationView) b(R.id.ksad_live_entry_icon);
        this.f8988b.setAnimation(R.raw.ksad_live_home_entry_icon);
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
