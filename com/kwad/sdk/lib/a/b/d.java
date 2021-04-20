package com.kwad.sdk.lib.a.b;

import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class d<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RefreshLayout f36211a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f36212c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f36213d;

    /* renamed from: e  reason: collision with root package name */
    public final RefreshLayout.b f36214e = new RefreshLayout.b() { // from class: com.kwad.sdk.lib.a.b.d.1
        @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
        public void a() {
            if (com.ksad.download.d.b.a(d.this.o())) {
                d.this.f36212c.k();
                return;
            }
            p.a(d.this.o());
            d.this.f36211a.setRefreshing(false);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public f f36215f = new g() { // from class: com.kwad.sdk.lib.a.b.d.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            if (z) {
                d.this.f36211a.setRefreshing(false);
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z || d.this.f36213d.i() || z2) {
                return;
            }
            d.this.f36211a.setRefreshing(true);
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (z) {
                if (!d.this.f36213d.i()) {
                    d.this.f36211a.setEnabled(true);
                }
                d.this.f36211a.setRefreshing(false);
            }
        }
    };

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36191b;
        RefreshLayout refreshLayout = callercontext.j;
        this.f36211a = refreshLayout;
        this.f36212c = (com.kwad.sdk.lib.b.c<?, MODEL>) callercontext.f36195g;
        this.f36213d = callercontext.f36196h;
        refreshLayout.setEnabled(false);
        this.f36211a.setNestedScrollingEnabled(true);
        this.f36211a.setOnRefreshListener(this.f36214e);
        this.f36212c.a(this.f36215f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36211a.setOnRefreshListener(null);
        this.f36212c.b(this.f36215f);
    }
}
