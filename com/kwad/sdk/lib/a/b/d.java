package com.kwad.sdk.lib.a.b;

import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.p;
/* loaded from: classes5.dex */
public class d<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    private RefreshLayout f10711a;
    private com.kwad.sdk.lib.b.c<?, MODEL> c;
    private com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> d;
    private final RefreshLayout.b e = new RefreshLayout.b() { // from class: com.kwad.sdk.lib.a.b.d.1
        @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
        public void a() {
            if (com.ksad.download.d.b.a(d.this.o())) {
                d.this.c.k();
                return;
            }
            p.a(d.this.o());
            d.this.f10711a.setRefreshing(false);
        }
    };
    private f f = new g() { // from class: com.kwad.sdk.lib.a.b.d.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            if (z) {
                d.this.f10711a.setRefreshing(false);
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z || d.this.d.i() || z2) {
                return;
            }
            d.this.f10711a.setRefreshing(true);
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (z) {
                if (!d.this.d.i()) {
                    d.this.f10711a.setEnabled(true);
                }
                d.this.f10711a.setRefreshing(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10711a = this.f10705b.j;
        this.c = (com.kwad.sdk.lib.b.c<?, MODEL>) this.f10705b.g;
        this.d = this.f10705b.h;
        this.f10711a.setEnabled(false);
        this.f10711a.setNestedScrollingEnabled(true);
        this.f10711a.setOnRefreshListener(this.e);
        this.c.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10711a.setOnRefreshListener(null);
        this.c.b(this.f);
    }
}
