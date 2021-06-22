package com.kwad.sdk.contentalliance.detail.ad.presenter;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.swipe.SwipeLayout;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.s;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public View f32699b;

    /* renamed from: c  reason: collision with root package name */
    public SwipeLayout f32700c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32701d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32702e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            a.this.f32700c.a(a.this.f32703f);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            if (a.this.f32700c.b(a.this.f32703f)) {
                a.this.f32700c.c(a.this.f32703f);
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public SwipeLayout.a f32703f = new SwipeLayout.a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.2
        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void b() {
            if (!c.af() || com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(a.this.f32701d))) {
                return;
            }
            com.kwad.sdk.core.report.b.a(a.this.f32701d, 12, (s.a) null);
            a.this.e();
        }
    };

    private void a(KsFragment ksFragment) {
        if (this.f32699b != null) {
            return;
        }
        View view = ksFragment.getParentFragment().getView();
        this.f32699b = view;
        this.f32700c = (SwipeLayout) view.findViewById(R.id.ksad_swipe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        AdWebViewActivityProxy.launch(o(), this.f32701d);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        a(((com.kwad.sdk.contentalliance.detail.b) this).f32790a.k);
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a;
        this.f32701d = cVar.j;
        cVar.f32812b.add(this.f32702e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.remove(this.f32702e);
    }
}
