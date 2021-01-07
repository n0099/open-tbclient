package com.kwad.sdk.contentalliance.home.b;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.IMConnection;
import com.kwad.sdk.contentalliance.home.d;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.utils.p;
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    private View f8983b;
    private SlidePlayViewPager c;
    private com.kwad.sdk.contentalliance.home.swipe.c d;
    private com.kwad.sdk.contentalliance.home.a.b e;
    private com.kwad.sdk.contentalliance.home.h f;
    private Runnable g = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.b(c.this.f8983b);
        }
    };
    private View.OnKeyListener h = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.home.b.c.2
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                c.this.k.a();
                return true;
            }
            return false;
        }
    };
    private d.a i = new d.a() { // from class: com.kwad.sdk.contentalliance.home.b.c.3
        @Override // com.kwad.sdk.contentalliance.home.d.a
        public boolean a() {
            if (c.this.d == null || ((c.this.c == null || c.this.c.getSourceType() == 0) && !c.this.d.b())) {
                return false;
            }
            c.this.d.c();
            return true;
        }

        @Override // com.kwad.sdk.contentalliance.home.d.a
        public void b() {
            com.kwad.sdk.core.d.a.a("HomeBackPresenter", "onRefresh()");
            p.a(c.this.o(), "再按一次返回键退出", (long) IMConnection.RETRY_DELAY_TIMES);
            if (c.this.e != null) {
                c.this.e.a(3);
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
    private com.kwad.sdk.contentalliance.detail.photo.comment.g j = new com.kwad.sdk.contentalliance.detail.photo.comment.g() { // from class: com.kwad.sdk.contentalliance.home.b.c.4
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
        public void b() {
            c.this.b(c.this.l());
        }
    };
    private com.kwad.sdk.contentalliance.home.d k = new com.kwad.sdk.contentalliance.home.d(this.i);

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        if (view != null) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnKeyListener(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8983b = l();
        this.c = this.f9034a.c;
        this.f = this.f9034a.f;
        if (this.f != null) {
            this.d = this.f.g;
            this.f.f.add(this.j);
        }
        if (this.f9034a.f9036b != null) {
            this.e = this.f9034a.f9036b.c();
        }
        if (this.f8983b != null) {
            b(this.f8983b);
            this.f8983b.postDelayed(this.g, 1000L);
        }
        this.k.a(this.f9034a.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f8983b != null) {
            this.f8983b.removeCallbacks(this.g);
        }
        if (this.f != null) {
            this.f.f.remove(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
