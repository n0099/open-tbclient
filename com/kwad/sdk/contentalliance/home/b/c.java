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
    public View f32660b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f32661c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f32662d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.b f32663e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.h f32664f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f32665g = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.b(cVar.f32660b);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f32666h = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.home.b.c.2
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
            if (c.this.f32662d != null) {
                if ((c.this.f32661c == null || c.this.f32661c.getSourceType() == 0) && !c.this.f32662d.b()) {
                    return false;
                }
                c.this.f32662d.c();
                return true;
            }
            return false;
        }

        @Override // com.kwad.sdk.contentalliance.home.d.a
        public void b() {
            com.kwad.sdk.core.d.a.a("HomeBackPresenter", "onRefresh()");
            p.a(c.this.o(), "再按一次返回键退出", 3000L);
            if (c.this.f32663e != null) {
                c.this.f32663e.a(3);
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
            view.setOnKeyListener(this.f32666h);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32660b = l();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f32769a;
        this.f32661c = fVar.f32772c;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f32775f;
        this.f32664f = hVar;
        if (hVar != null) {
            this.f32662d = hVar.f32795g;
            hVar.f32794f.add(this.j);
        }
        com.kwad.sdk.contentalliance.home.a.i iVar = ((com.kwad.sdk.contentalliance.home.e) this).f32769a.f32771b;
        if (iVar != null) {
            this.f32663e = iVar.c();
        }
        View view = this.f32660b;
        if (view != null) {
            b(view);
            this.f32660b.postDelayed(this.f32665g, 1000L);
        }
        this.k.a(((com.kwad.sdk.contentalliance.home.e) this).f32769a.m);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        View view = this.f32660b;
        if (view != null) {
            view.removeCallbacks(this.f32665g);
        }
        com.kwad.sdk.contentalliance.home.h hVar = this.f32664f;
        if (hVar != null) {
            hVar.f32794f.remove(this.j);
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
