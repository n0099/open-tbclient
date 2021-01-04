package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import java.util.List;
/* loaded from: classes5.dex */
public class b<PAGE, MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<PAGE, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f10707a;
    private com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> c;
    private com.kwad.sdk.lib.widget.recycler.d d;
    private com.kwad.sdk.lib.b.c<PAGE, MODEL> e;
    private com.kwad.sdk.lib.a.b<PAGE> f;
    private boolean g;
    private f h = new g() { // from class: com.kwad.sdk.lib.a.b.b.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            if (b.this.g && b.this.f10707a.getLayoutManager() == null) {
                b.this.e();
            }
        }
    };

    public b(boolean z) {
        this.g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f10707a.setItemAnimator(null);
        RecyclerView.ItemDecoration b2 = this.f.b(this.e.p());
        if (b2 != null) {
            this.f10707a.addItemDecoration(b2);
        }
        this.f10707a.setLayoutManager(this.f.a(this.e.p()));
        this.d.a(this.f10707a);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: java.util.List<MODEL>, java.util.List<M> */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10707a = this.f10704b.f;
        this.e = this.f10704b.g;
        this.c = this.f10704b.h;
        this.d = this.f10704b.i;
        this.c.a((List<MODEL>) this.e.g());
        this.c.a((com.kwad.sdk.lib.b.c<?, MODEL>) this.f10704b.g);
        this.f10707a.setAdapter(this.d);
        this.f = this.f10704b.k;
        if (this.g) {
            this.e.a(this.h);
        } else {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.g) {
            this.e.a(this.h);
        }
    }
}
