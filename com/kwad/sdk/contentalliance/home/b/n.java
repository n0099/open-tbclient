package com.kwad.sdk.contentalliance.home.b;

import android.app.Activity;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.d;
import com.kwad.sdk.contentalliance.home.swipe.SwipeLayout;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class n extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: d  reason: collision with root package name */
    public SwipeLayout f33092d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.b f33093e;

    /* renamed from: b  reason: collision with root package name */
    public d.a f33090b = new d.a() { // from class: com.kwad.sdk.contentalliance.home.b.n.1
        @Override // com.kwad.sdk.contentalliance.home.d.a
        public boolean a() {
            return false;
        }

        @Override // com.kwad.sdk.contentalliance.home.d.a
        public void b() {
            com.kwad.sdk.core.d.a.a("SwipeRightExitPresenter", "onRefresh()");
            p.a(n.this.o(), "再按一次返回键退出", 3000L);
            if (n.this.f33093e != null) {
                n.this.f33093e.a(3);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.d.a
        public void c() {
            com.kwad.sdk.core.d.a.a("SwipeRightExitPresenter", "onExit()");
            Activity m = n.this.m();
            if (m != null) {
                m.onBackPressed();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.d f33091c = new com.kwad.sdk.contentalliance.home.d(this.f33090b);

    /* renamed from: f  reason: collision with root package name */
    public SwipeLayout.a f33094f = new SwipeLayout.a() { // from class: com.kwad.sdk.contentalliance.home.b.n.2
        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void a() {
            com.kwad.sdk.core.d.a.a("SwipeRightExitPresenter", "onRightSwiped");
            n.this.f33091c.a();
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void b() {
        }
    };

    private void e() {
        this.f33092d = (SwipeLayout) b(R.id.ksad_swipe);
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        e();
        com.kwad.sdk.contentalliance.home.a.i iVar = ((com.kwad.sdk.contentalliance.home.e) this).f33153a.f33155b;
        if (iVar != null) {
            this.f33093e = iVar.c();
        }
        SwipeLayout swipeLayout = this.f33092d;
        if (swipeLayout != null) {
            swipeLayout.a(this.f33094f);
        }
        this.f33091c.a(((com.kwad.sdk.contentalliance.home.e) this).f33153a.m);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        SwipeLayout swipeLayout = this.f33092d;
        if (swipeLayout == null || !swipeLayout.b(this.f33094f)) {
            return;
        }
        this.f33092d.c(this.f33094f);
    }
}
