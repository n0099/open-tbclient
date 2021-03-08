package com.kwad.sdk.contentalliance.home.b;

import android.app.Activity;
import com.baidu.android.imsdk.internal.IMConnection;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.d;
import com.kwad.sdk.contentalliance.home.swipe.SwipeLayout;
import com.kwad.sdk.utils.p;
/* loaded from: classes3.dex */
public class n extends com.kwad.sdk.contentalliance.home.e {
    private SwipeLayout d;
    private com.kwad.sdk.contentalliance.home.a.b e;
    private d.a b = new d.a() { // from class: com.kwad.sdk.contentalliance.home.b.n.1
        @Override // com.kwad.sdk.contentalliance.home.d.a
        public boolean a() {
            return false;
        }

        @Override // com.kwad.sdk.contentalliance.home.d.a
        public void b() {
            com.kwad.sdk.core.d.a.a("SwipeRightExitPresenter", "onRefresh()");
            p.a(n.this.o(), "再按一次返回键退出", (long) IMConnection.RETRY_DELAY_TIMES);
            if (n.this.e != null) {
                n.this.e.a(3);
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
    private com.kwad.sdk.contentalliance.home.d c = new com.kwad.sdk.contentalliance.home.d(this.b);
    private SwipeLayout.a f = new SwipeLayout.a() { // from class: com.kwad.sdk.contentalliance.home.b.n.2
        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void a() {
            com.kwad.sdk.core.d.a.a("SwipeRightExitPresenter", "onRightSwiped");
            n.this.c.a();
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void b() {
        }
    };

    private void e() {
        this.d = (SwipeLayout) b(R.id.ksad_swipe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        e();
        if (this.f5821a.b != null) {
            this.e = this.f5821a.b.c();
        }
        if (this.d != null) {
            this.d.a(this.f);
        }
        this.c.a(this.f5821a.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        if (this.d == null || !this.d.b(this.f)) {
            return;
        }
        this.d.c(this.f);
    }
}
