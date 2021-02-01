package com.kwad.sdk.contentalliance.detail.ad.presenter;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.swipe.SwipeLayout;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.s;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private View f8344b;
    private SwipeLayout c;
    private AdTemplate d;
    private com.kwad.sdk.contentalliance.a.a e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            a.this.c.a(a.this.f);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            if (a.this.c.b(a.this.f)) {
                a.this.c.c(a.this.f);
            }
        }
    };
    private SwipeLayout.a f = new SwipeLayout.a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.2
        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void b() {
            if (!c.af() || com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(a.this.d))) {
                return;
            }
            com.kwad.sdk.core.report.b.a(a.this.d, 12, (s.a) null);
            a.this.e();
        }
    };

    private void a(KsFragment ksFragment) {
        if (this.f8344b != null) {
            return;
        }
        this.f8344b = ksFragment.getParentFragment().getView();
        this.c = (SwipeLayout) this.f8344b.findViewById(R.id.ksad_swipe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        AdWebViewActivityProxy.launch(o(), this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        a(this.f8395a.k);
        this.d = this.f8395a.j;
        this.f8395a.f8405b.add(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        this.f8395a.f8405b.remove(this.e);
    }
}
