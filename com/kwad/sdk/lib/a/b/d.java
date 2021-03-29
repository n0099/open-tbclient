package com.kwad.sdk.lib.a.b;

import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class d<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RefreshLayout f35922a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f35923c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f35924d;

    /* renamed from: e  reason: collision with root package name */
    public final RefreshLayout.b f35925e = new RefreshLayout.b() { // from class: com.kwad.sdk.lib.a.b.d.1
        @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
        public void a() {
            if (com.ksad.download.d.b.a(d.this.o())) {
                d.this.f35923c.k();
                return;
            }
            p.a(d.this.o());
            d.this.f35922a.setRefreshing(false);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public f f35926f = new g() { // from class: com.kwad.sdk.lib.a.b.d.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            if (z) {
                d.this.f35922a.setRefreshing(false);
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z || d.this.f35924d.i() || z2) {
                return;
            }
            d.this.f35922a.setRefreshing(true);
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (z) {
                if (!d.this.f35924d.i()) {
                    d.this.f35922a.setEnabled(true);
                }
                d.this.f35922a.setRefreshing(false);
            }
        }
    };

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f35902b;
        RefreshLayout refreshLayout = callercontext.j;
        this.f35922a = refreshLayout;
        this.f35923c = (com.kwad.sdk.lib.b.c<?, MODEL>) callercontext.f35906g;
        this.f35924d = callercontext.f35907h;
        refreshLayout.setEnabled(false);
        this.f35922a.setNestedScrollingEnabled(true);
        this.f35922a.setOnRefreshListener(this.f35925e);
        this.f35923c.a(this.f35926f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35922a.setOnRefreshListener(null);
        this.f35923c.b(this.f35926f);
    }
}
