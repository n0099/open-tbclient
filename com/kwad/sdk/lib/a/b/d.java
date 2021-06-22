package com.kwad.sdk.lib.a.b;

import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class d<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RefreshLayout f36723a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f36724c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f36725d;

    /* renamed from: e  reason: collision with root package name */
    public final RefreshLayout.b f36726e = new RefreshLayout.b() { // from class: com.kwad.sdk.lib.a.b.d.1
        @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
        public void a() {
            if (com.ksad.download.d.b.a(d.this.o())) {
                d.this.f36724c.k();
                return;
            }
            p.a(d.this.o());
            d.this.f36723a.setRefreshing(false);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public f f36727f = new g() { // from class: com.kwad.sdk.lib.a.b.d.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i2, String str) {
            if (z) {
                d.this.f36723a.setRefreshing(false);
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z || d.this.f36725d.i() || z2) {
                return;
            }
            d.this.f36723a.setRefreshing(true);
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (z) {
                if (!d.this.f36725d.i()) {
                    d.this.f36723a.setEnabled(true);
                }
                d.this.f36723a.setRefreshing(false);
            }
        }
    };

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36702b;
        RefreshLayout refreshLayout = callercontext.j;
        this.f36723a = refreshLayout;
        this.f36724c = (com.kwad.sdk.lib.b.c<?, MODEL>) callercontext.f36706g;
        this.f36725d = callercontext.f36707h;
        refreshLayout.setEnabled(false);
        this.f36723a.setNestedScrollingEnabled(true);
        this.f36723a.setOnRefreshListener(this.f36726e);
        this.f36724c.a(this.f36727f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36723a.setOnRefreshListener(null);
        this.f36724c.b(this.f36727f);
    }
}
