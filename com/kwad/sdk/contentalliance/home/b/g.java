package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32687b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f32688c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.i f32689d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.d f32690e = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.b.g.1
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            if (NetworkMonitor.a().b() && g.this.f32687b != null && g.this.f32687b.e() && v.c(g.this.o())) {
                g.this.f();
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public NetworkMonitor.a f32691f = new NetworkMonitor.a() { // from class: com.kwad.sdk.contentalliance.home.b.g.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public void a(NetworkMonitor.NetworkState networkState) {
            if (networkState != NetworkMonitor.NetworkState.NETWORK_MOBILE || !NetworkMonitor.a().b() || g.this.f32688c == null || g.this.f32688c.j() || g.this.f32687b == null || !g.this.f32687b.e()) {
                return;
            }
            g.this.f();
        }
    };

    private void e() {
        if (this.f32691f != null) {
            NetworkMonitor.a().b(this.f32691f);
            this.f32691f = null;
        }
        com.kwad.sdk.contentalliance.home.a.i iVar = this.f32689d;
        if (iVar != null) {
            iVar.b(this.f32690e);
            this.f32690e = null;
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
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f32768a;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f32774f;
        if (hVar == null) {
            return;
        }
        com.kwad.sdk.core.i.a aVar = hVar.f32788a;
        this.f32687b = aVar;
        if (aVar == null) {
            return;
        }
        com.kwad.sdk.contentalliance.home.a.i iVar = fVar.f32770b;
        this.f32689d = iVar;
        this.f32688c = fVar.f32771c;
        iVar.a(this.f32690e);
        NetworkMonitor.a().a(this.f32691f);
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
