package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes5.dex */
public class g extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.core.i.a f8995b;
    private SlidePlayViewPager c;
    private com.kwad.sdk.contentalliance.home.a.i d;
    private com.kwad.sdk.contentalliance.home.a.d e = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.b.g.1
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            if (NetworkMonitor.a().b() && g.this.f8995b != null && g.this.f8995b.e() && v.c(g.this.o())) {
                g.this.f();
            }
        }
    };
    private NetworkMonitor.a f = new NetworkMonitor.a() { // from class: com.kwad.sdk.contentalliance.home.b.g.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public void a(NetworkMonitor.NetworkState networkState) {
            if (networkState != NetworkMonitor.NetworkState.NETWORK_MOBILE || !NetworkMonitor.a().b() || g.this.c == null || g.this.c.j() || g.this.f8995b == null || !g.this.f8995b.e()) {
                return;
            }
            g.this.f();
        }
    };

    private void e() {
        if (this.f != null) {
            NetworkMonitor.a().b(this.f);
            this.f = null;
        }
        if (this.d != null) {
            this.d.b(this.e);
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        p.a(o(), o().getString(R.string.ksad_network_dataFlow_tip));
        NetworkMonitor.a().c();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.h hVar = this.f9034a.f;
        if (hVar == null) {
            return;
        }
        this.f8995b = hVar.f9042a;
        if (this.f8995b != null) {
            this.d = this.f9034a.f9036b;
            this.c = this.f9034a.c;
            this.d.a(this.e);
            NetworkMonitor.a().a(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        e();
    }
}
