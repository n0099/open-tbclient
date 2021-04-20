package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
/* loaded from: classes6.dex */
public class b<PAGE, MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<PAGE, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f36202a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f36203c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f36204d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<PAGE, MODEL> f36205e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.a.b<PAGE> f36206f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36207g;

    /* renamed from: h  reason: collision with root package name */
    public f f36208h = new g() { // from class: com.kwad.sdk.lib.a.b.b.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (b.this.f36207g && b.this.f36202a.getLayoutManager() == null) {
                b.this.e();
            }
        }
    };

    public b(boolean z) {
        this.f36207g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f36202a.setItemAnimator(null);
        RecyclerView.ItemDecoration b2 = this.f36206f.b(this.f36205e.p());
        if (b2 != null) {
            this.f36202a.addItemDecoration(b2);
        }
        this.f36202a.setLayoutManager(this.f36206f.a(this.f36205e.p()));
        this.f36204d.a(this.f36202a);
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36191b;
        this.f36202a = callercontext.f36194f;
        com.kwad.sdk.lib.b.c<PAGE, MODEL> cVar = callercontext.f36195g;
        this.f36205e = cVar;
        com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> cVar2 = callercontext.f36196h;
        this.f36203c = cVar2;
        this.f36204d = callercontext.i;
        cVar2.a(cVar.g());
        this.f36203c.a((com.kwad.sdk.lib.b.c<?, MODEL>) ((com.kwad.sdk.lib.a.a.a) this).f36191b.f36195g);
        this.f36202a.setAdapter(this.f36204d);
        this.f36206f = ((com.kwad.sdk.lib.a.a.a) this).f36191b.k;
        if (this.f36207g) {
            this.f36205e.a(this.f36208h);
        } else {
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f36207g) {
            this.f36205e.a(this.f36208h);
        }
    }
}
