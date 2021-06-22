package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33371b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f33372c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.i f33373d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.d f33374e = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.b.g.1
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i2) {
            if (NetworkMonitor.a().b() && g.this.f33371b != null && g.this.f33371b.e() && v.c(g.this.o())) {
                g.this.f();
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public NetworkMonitor.a f33375f = new NetworkMonitor.a() { // from class: com.kwad.sdk.contentalliance.home.b.g.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public void a(NetworkMonitor.NetworkState networkState) {
            if (networkState != NetworkMonitor.NetworkState.NETWORK_MOBILE || !NetworkMonitor.a().b() || g.this.f33372c == null || g.this.f33372c.j() || g.this.f33371b == null || !g.this.f33371b.e()) {
                return;
            }
            g.this.f();
        }
    };

    private void e() {
        if (this.f33375f != null) {
            NetworkMonitor.a().b(this.f33375f);
            this.f33375f = null;
        }
        com.kwad.sdk.contentalliance.home.a.i iVar = this.f33373d;
        if (iVar != null) {
            iVar.b(this.f33374e);
            this.f33374e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        p.a(o(), o().getString(R.string.ksad_network_dataFlow_tip));
        NetworkMonitor.a().c();
        e();
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33455a;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f33461f;
        if (hVar == null) {
            return;
        }
        com.kwad.sdk.core.i.a aVar = hVar.f33477a;
        this.f33371b = aVar;
        if (aVar == null) {
            return;
        }
        com.kwad.sdk.contentalliance.home.a.i iVar = fVar.f33457b;
        this.f33373d = iVar;
        this.f33372c = fVar.f33458c;
        iVar.a(this.f33374e);
        NetworkMonitor.a().a(this.f33375f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        e();
    }
}
