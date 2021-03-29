package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
/* loaded from: classes6.dex */
public class b<PAGE, MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<PAGE, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f35913a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f35914c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f35915d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<PAGE, MODEL> f35916e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.a.b<PAGE> f35917f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35918g;

    /* renamed from: h  reason: collision with root package name */
    public f f35919h = new g() { // from class: com.kwad.sdk.lib.a.b.b.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (b.this.f35918g && b.this.f35913a.getLayoutManager() == null) {
                b.this.e();
            }
        }
    };

    public b(boolean z) {
        this.f35918g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f35913a.setItemAnimator(null);
        RecyclerView.ItemDecoration b2 = this.f35917f.b(this.f35916e.p());
        if (b2 != null) {
            this.f35913a.addItemDecoration(b2);
        }
        this.f35913a.setLayoutManager(this.f35917f.a(this.f35916e.p()));
        this.f35915d.a(this.f35913a);
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f35902b;
        this.f35913a = callercontext.f35905f;
        com.kwad.sdk.lib.b.c<PAGE, MODEL> cVar = callercontext.f35906g;
        this.f35916e = cVar;
        com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> cVar2 = callercontext.f35907h;
        this.f35914c = cVar2;
        this.f35915d = callercontext.i;
        cVar2.a(cVar.g());
        this.f35914c.a((com.kwad.sdk.lib.b.c<?, MODEL>) ((com.kwad.sdk.lib.a.a.a) this).f35902b.f35906g);
        this.f35913a.setAdapter(this.f35915d);
        this.f35917f = ((com.kwad.sdk.lib.a.a.a) this).f35902b.k;
        if (this.f35918g) {
            this.f35916e.a(this.f35919h);
        } else {
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f35918g) {
            this.f35916e.a(this.f35919h);
        }
    }
}
