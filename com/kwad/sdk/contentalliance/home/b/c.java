package com.kwad.sdk.contentalliance.home.b;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.kwad.sdk.contentalliance.home.d;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public View f33341b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f33342c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f33343d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.b f33344e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.h f33345f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f33346g = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.b(cVar.f33341b);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f33347h = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.home.b.c.2
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 == 4 && keyEvent.getAction() == 1) {
                c.this.k.a();
                return true;
            }
            return false;
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public d.a f33348i = new d.a() { // from class: com.kwad.sdk.contentalliance.home.b.c.3
        @Override // com.kwad.sdk.contentalliance.home.d.a
        public boolean a() {
            if (c.this.f33343d != null) {
                if ((c.this.f33342c == null || c.this.f33342c.getSourceType() == 0) && !c.this.f33343d.b()) {
                    return false;
                }
                c.this.f33343d.c();
                return true;
            }
            return false;
        }

        @Override // com.kwad.sdk.contentalliance.home.d.a
        public void b() {
            com.kwad.sdk.core.d.a.a("HomeBackPresenter", "onRefresh()");
            p.a(c.this.o(), "再按一次返回键退出", 3000L);
            if (c.this.f33344e != null) {
                c.this.f33344e.a(3);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.d.a
        public void c() {
            com.kwad.sdk.core.d.a.a("HomeBackPresenter", "onExit()");
            Activity m = c.this.m();
            if (m != null) {
                m.onBackPressed();
            }
        }
    };
    public com.kwad.sdk.contentalliance.detail.photo.comment.g j = new com.kwad.sdk.contentalliance.detail.photo.comment.g() { // from class: com.kwad.sdk.contentalliance.home.b.c.4
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
        public void b() {
            c cVar = c.this;
            cVar.b(cVar.l());
        }
    };
    public com.kwad.sdk.contentalliance.home.d k = new com.kwad.sdk.contentalliance.home.d(this.f33348i);

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        if (view != null) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnKeyListener(this.f33347h);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33341b = l();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33455a;
        this.f33342c = fVar.f33458c;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f33461f;
        this.f33345f = hVar;
        if (hVar != null) {
            this.f33343d = hVar.f33483g;
            hVar.f33482f.add(this.j);
        }
        com.kwad.sdk.contentalliance.home.a.i iVar = ((com.kwad.sdk.contentalliance.home.e) this).f33455a.f33457b;
        if (iVar != null) {
            this.f33344e = iVar.c();
        }
        View view = this.f33341b;
        if (view != null) {
            b(view);
            this.f33341b.postDelayed(this.f33346g, 1000L);
        }
        this.k.a(((com.kwad.sdk.contentalliance.home.e) this).f33455a.m);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        View view = this.f33341b;
        if (view != null) {
            view.removeCallbacks(this.f33346g);
        }
        com.kwad.sdk.contentalliance.home.h hVar = this.f33345f;
        if (hVar != null) {
            hVar.f33482f.remove(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        View l = l();
        if (l != null) {
            l.setFocusableInTouchMode(false);
            l.setOnKeyListener(null);
        }
    }
}
