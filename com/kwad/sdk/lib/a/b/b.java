package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
/* loaded from: classes6.dex */
public class b<PAGE, MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<PAGE, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f35912a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f35913c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f35914d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<PAGE, MODEL> f35915e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.a.b<PAGE> f35916f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35917g;

    /* renamed from: h  reason: collision with root package name */
    public f f35918h = new g() { // from class: com.kwad.sdk.lib.a.b.b.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (b.this.f35917g && b.this.f35912a.getLayoutManager() == null) {
                b.this.e();
            }
        }
    };

    public b(boolean z) {
        this.f35917g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f35912a.setItemAnimator(null);
        RecyclerView.ItemDecoration b2 = this.f35916f.b(this.f35915e.p());
        if (b2 != null) {
            this.f35912a.addItemDecoration(b2);
        }
        this.f35912a.setLayoutManager(this.f35916f.a(this.f35915e.p()));
        this.f35914d.a(this.f35912a);
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f35901b;
        this.f35912a = callercontext.f35904f;
        com.kwad.sdk.lib.b.c<PAGE, MODEL> cVar = callercontext.f35905g;
        this.f35915e = cVar;
        com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> cVar2 = callercontext.f35906h;
        this.f35913c = cVar2;
        this.f35914d = callercontext.i;
        cVar2.a(cVar.g());
        this.f35913c.a((com.kwad.sdk.lib.b.c<?, MODEL>) ((com.kwad.sdk.lib.a.a.a) this).f35901b.f35905g);
        this.f35912a.setAdapter(this.f35914d);
        this.f35916f = ((com.kwad.sdk.lib.a.a.a) this).f35901b.k;
        if (this.f35917g) {
            this.f35915e.a(this.f35918h);
        } else {
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f35917g) {
            this.f35915e.a(this.f35918h);
        }
    }
}
