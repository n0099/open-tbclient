package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
/* loaded from: classes6.dex */
public class b<PAGE, MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<PAGE, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f36297a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f36298c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f36299d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<PAGE, MODEL> f36300e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.a.b<PAGE> f36301f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36302g;

    /* renamed from: h  reason: collision with root package name */
    public f f36303h = new g() { // from class: com.kwad.sdk.lib.a.b.b.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (b.this.f36302g && b.this.f36297a.getLayoutManager() == null) {
                b.this.e();
            }
        }
    };

    public b(boolean z) {
        this.f36302g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f36297a.setItemAnimator(null);
        RecyclerView.ItemDecoration b2 = this.f36301f.b(this.f36300e.p());
        if (b2 != null) {
            this.f36297a.addItemDecoration(b2);
        }
        this.f36297a.setLayoutManager(this.f36301f.a(this.f36300e.p()));
        this.f36299d.a(this.f36297a);
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36286b;
        this.f36297a = callercontext.f36289f;
        com.kwad.sdk.lib.b.c<PAGE, MODEL> cVar = callercontext.f36290g;
        this.f36300e = cVar;
        com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> cVar2 = callercontext.f36291h;
        this.f36298c = cVar2;
        this.f36299d = callercontext.i;
        cVar2.a(cVar.g());
        this.f36298c.a((com.kwad.sdk.lib.b.c<?, MODEL>) ((com.kwad.sdk.lib.a.a.a) this).f36286b.f36290g);
        this.f36297a.setAdapter(this.f36299d);
        this.f36301f = ((com.kwad.sdk.lib.a.a.a) this).f36286b.k;
        if (this.f36302g) {
            this.f36300e.a(this.f36303h);
        } else {
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f36302g) {
            this.f36300e.a(this.f36303h);
        }
    }
}
