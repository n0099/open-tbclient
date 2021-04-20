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
    public View f32949b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f32950c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f32951d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.b f32952e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.h f32953f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f32954g = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.b(cVar.f32949b);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f32955h = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.home.b.c.2
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                c.this.k.a();
                return true;
            }
            return false;
        }
    };
    public d.a i = new d.a() { // from class: com.kwad.sdk.contentalliance.home.b.c.3
        @Override // com.kwad.sdk.contentalliance.home.d.a
        public boolean a() {
            if (c.this.f32951d != null) {
                if ((c.this.f32950c == null || c.this.f32950c.getSourceType() == 0) && !c.this.f32951d.b()) {
                    return false;
                }
                c.this.f32951d.c();
                return true;
            }
            return false;
        }

        @Override // com.kwad.sdk.contentalliance.home.d.a
        public void b() {
            com.kwad.sdk.core.d.a.a("HomeBackPresenter", "onRefresh()");
            p.a(c.this.o(), "再按一次返回键退出", 3000L);
            if (c.this.f32952e != null) {
                c.this.f32952e.a(3);
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
    public com.kwad.sdk.contentalliance.home.d k = new com.kwad.sdk.contentalliance.home.d(this.i);

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        if (view != null) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnKeyListener(this.f32955h);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32949b = l();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33058a;
        this.f32950c = fVar.f33061c;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f33064f;
        this.f32953f = hVar;
        if (hVar != null) {
            this.f32951d = hVar.f33084g;
            hVar.f33083f.add(this.j);
        }
        com.kwad.sdk.contentalliance.home.a.i iVar = ((com.kwad.sdk.contentalliance.home.e) this).f33058a.f33060b;
        if (iVar != null) {
            this.f32952e = iVar.c();
        }
        View view = this.f32949b;
        if (view != null) {
            b(view);
            this.f32949b.postDelayed(this.f32954g, 1000L);
        }
        this.k.a(((com.kwad.sdk.contentalliance.home.e) this).f33058a.m);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        View view = this.f32949b;
        if (view != null) {
            view.removeCallbacks(this.f32954g);
        }
        com.kwad.sdk.contentalliance.home.h hVar = this.f32953f;
        if (hVar != null) {
            hVar.f33083f.remove(this.j);
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
