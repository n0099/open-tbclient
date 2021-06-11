package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
/* loaded from: classes7.dex */
public class b<PAGE, MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<PAGE, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f36616a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f36617c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f36618d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<PAGE, MODEL> f36619e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.a.b<PAGE> f36620f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36621g;

    /* renamed from: h  reason: collision with root package name */
    public f f36622h = new g() { // from class: com.kwad.sdk.lib.a.b.b.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i2, String str) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (b.this.f36621g && b.this.f36616a.getLayoutManager() == null) {
                b.this.e();
            }
        }
    };

    public b(boolean z) {
        this.f36621g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f36616a.setItemAnimator(null);
        RecyclerView.ItemDecoration b2 = this.f36620f.b(this.f36619e.p());
        if (b2 != null) {
            this.f36616a.addItemDecoration(b2);
        }
        this.f36616a.setLayoutManager(this.f36620f.a(this.f36619e.p()));
        this.f36618d.a(this.f36616a);
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36604b;
        this.f36616a = callercontext.f36607f;
        com.kwad.sdk.lib.b.c<PAGE, MODEL> cVar = callercontext.f36608g;
        this.f36619e = cVar;
        com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> cVar2 = callercontext.f36609h;
        this.f36617c = cVar2;
        this.f36618d = callercontext.f36610i;
        cVar2.a(cVar.g());
        this.f36617c.a((com.kwad.sdk.lib.b.c<?, MODEL>) ((com.kwad.sdk.lib.a.a.a) this).f36604b.f36608g);
        this.f36616a.setAdapter(this.f36618d);
        this.f36620f = ((com.kwad.sdk.lib.a.a.a) this).f36604b.k;
        if (this.f36621g) {
            this.f36619e.a(this.f36622h);
        } else {
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f36621g) {
            this.f36619e.a(this.f36622h);
        }
    }
}
