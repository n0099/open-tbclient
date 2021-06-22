package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
/* loaded from: classes7.dex */
public class b<PAGE, MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<PAGE, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f36714a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f36715c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f36716d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<PAGE, MODEL> f36717e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.a.b<PAGE> f36718f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36719g;

    /* renamed from: h  reason: collision with root package name */
    public f f36720h = new g() { // from class: com.kwad.sdk.lib.a.b.b.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i2, String str) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (b.this.f36719g && b.this.f36714a.getLayoutManager() == null) {
                b.this.e();
            }
        }
    };

    public b(boolean z) {
        this.f36719g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f36714a.setItemAnimator(null);
        RecyclerView.ItemDecoration b2 = this.f36718f.b(this.f36717e.p());
        if (b2 != null) {
            this.f36714a.addItemDecoration(b2);
        }
        this.f36714a.setLayoutManager(this.f36718f.a(this.f36717e.p()));
        this.f36716d.a(this.f36714a);
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36702b;
        this.f36714a = callercontext.f36705f;
        com.kwad.sdk.lib.b.c<PAGE, MODEL> cVar = callercontext.f36706g;
        this.f36717e = cVar;
        com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> cVar2 = callercontext.f36707h;
        this.f36715c = cVar2;
        this.f36716d = callercontext.f36708i;
        cVar2.a(cVar.g());
        this.f36715c.a((com.kwad.sdk.lib.b.c<?, MODEL>) ((com.kwad.sdk.lib.a.a.a) this).f36702b.f36706g);
        this.f36714a.setAdapter(this.f36716d);
        this.f36718f = ((com.kwad.sdk.lib.a.a.a) this).f36702b.k;
        if (this.f36719g) {
            this.f36717e.a(this.f36720h);
        } else {
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f36719g) {
            this.f36717e.a(this.f36720h);
        }
    }
}
