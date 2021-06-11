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
    public View f33243b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f33244c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f33245d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.b f33246e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.h f33247f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f33248g = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.b(cVar.f33243b);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f33249h = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.home.b.c.2
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
    public d.a f33250i = new d.a() { // from class: com.kwad.sdk.contentalliance.home.b.c.3
        @Override // com.kwad.sdk.contentalliance.home.d.a
        public boolean a() {
            if (c.this.f33245d != null) {
                if ((c.this.f33244c == null || c.this.f33244c.getSourceType() == 0) && !c.this.f33245d.b()) {
                    return false;
                }
                c.this.f33245d.c();
                return true;
            }
            return false;
        }

        @Override // com.kwad.sdk.contentalliance.home.d.a
        public void b() {
            com.kwad.sdk.core.d.a.a("HomeBackPresenter", "onRefresh()");
            p.a(c.this.o(), "再按一次返回键退出", 3000L);
            if (c.this.f33246e != null) {
                c.this.f33246e.a(3);
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
    public com.kwad.sdk.contentalliance.home.d k = new com.kwad.sdk.contentalliance.home.d(this.f33250i);

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        if (view != null) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnKeyListener(this.f33249h);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33243b = l();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33357a;
        this.f33244c = fVar.f33360c;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f33363f;
        this.f33247f = hVar;
        if (hVar != null) {
            this.f33245d = hVar.f33385g;
            hVar.f33384f.add(this.j);
        }
        com.kwad.sdk.contentalliance.home.a.i iVar = ((com.kwad.sdk.contentalliance.home.e) this).f33357a.f33359b;
        if (iVar != null) {
            this.f33246e = iVar.c();
        }
        View view = this.f33243b;
        if (view != null) {
            b(view);
            this.f33243b.postDelayed(this.f33248g, 1000L);
        }
        this.k.a(((com.kwad.sdk.contentalliance.home.e) this).f33357a.m);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        View view = this.f33243b;
        if (view != null) {
            view.removeCallbacks(this.f33248g);
        }
        com.kwad.sdk.contentalliance.home.h hVar = this.f33247f;
        if (hVar != null) {
            hVar.f33384f.remove(this.j);
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
