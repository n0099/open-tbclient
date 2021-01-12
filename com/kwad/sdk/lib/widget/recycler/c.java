package com.kwad.sdk.lib.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.widget.recycler.a.b;
import com.kwad.sdk.lib.widget.recycler.b.a;
import com.kwad.sdk.lib.widget.recycler.b.a.C1137a;
import com.kwad.sdk.mvp.Presenter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public abstract class c<Model, CallerContext extends a.C1137a<Model>> extends a<Model, com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext>> {
    private static final ExecutorService c = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
    private KsFragment d;
    private RecyclerView e;
    private final Set<Presenter> f;
    private com.kwad.sdk.lib.b.c<?, Model> g;
    private com.kwad.sdk.lib.widget.recycler.a.d<Model> h;
    private final com.kwad.sdk.lib.widget.recycler.a.e<Model> i;
    private f j;

    public c(KsFragment ksFragment, RecyclerView recyclerView) {
        this.j = new f() { // from class: com.kwad.sdk.lib.widget.recycler.c.1
            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z) {
                if (c.this.h != null) {
                    c.this.a(z);
                } else {
                    c.this.notifyDataSetChanged();
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z, int i, String str) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                if (c.this.g.e()) {
                    return;
                }
                if (c.this.h != null) {
                    c.this.a(c.this.a(z, z2));
                    return;
                }
                c.this.a(c.this.g.g());
                c.this.notifyDataSetChanged();
            }
        };
        this.f = new LinkedHashSet();
        this.d = ksFragment;
        this.e = recyclerView;
        this.i = null;
    }

    public c(KsFragment ksFragment, RecyclerView recyclerView, @NonNull com.kwad.sdk.lib.widget.recycler.a.e<Model> eVar) {
        super(false);
        this.j = new f() { // from class: com.kwad.sdk.lib.widget.recycler.c.1
            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z) {
                if (c.this.h != null) {
                    c.this.a(z);
                } else {
                    c.this.notifyDataSetChanged();
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z, int i, String str) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                if (c.this.g.e()) {
                    return;
                }
                if (c.this.h != null) {
                    c.this.a(c.this.a(z, z2));
                    return;
                }
                c.this.a(c.this.g.g());
                c.this.notifyDataSetChanged();
            }
        };
        this.f = new LinkedHashSet();
        this.d = ksFragment;
        this.e = recyclerView;
        this.i = eVar;
        this.f10434a = new com.kwad.sdk.lib.widget.b(a());
    }

    private List<Model> a() {
        this.h = new com.kwad.sdk.lib.widget.recycler.a.d<>(new com.kwad.sdk.lib.widget.recycler.a.a(this), new b.a(this.i).a(c).a(), this);
        return new com.kwad.sdk.lib.widget.recycler.a.c(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.h.b(this.g.g());
        } else {
            this.h.a(this.g.g());
        }
    }

    protected abstract View a(ViewGroup viewGroup, int i);

    protected abstract Presenter a(int i);

    public void a(com.kwad.sdk.lib.b.c<?, Model> cVar) {
        if (this.g != null) {
            this.g.b(this.j);
        }
        this.g = cVar;
        this.g.a(this.j);
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, Model>, com.kwad.sdk.lib.b.c<?, MODEL> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, MODEL] */
    public void a(CallerContext callercontext, int i) {
        ?? r0 = this.f10434a.get(i);
        callercontext.d = this.d;
        callercontext.e = this.e;
        callercontext.f = (com.kwad.sdk.lib.b.c<?, Model>) this.g;
        callercontext.h = i;
        callercontext.i = r0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> aVar) {
        super.onViewRecycled(aVar);
        if (aVar == null || aVar.itemView != null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> aVar, int i) {
        com.kwad.sdk.core.d.a.a("RecyclerAdapter", "onBindViewHolder position" + i);
        a((c<Model, CallerContext>) aVar.f10451b, i);
        aVar.f10450a.a(aVar.f10451b);
    }

    protected boolean a(boolean z, boolean z2) {
        return z;
    }

    protected abstract CallerContext b();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> onCreateViewHolder(ViewGroup viewGroup, int i) {
        com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> aVar = new com.kwad.sdk.lib.widget.recycler.b.a<>(a(viewGroup, i), a(i), b());
        this.f.add(aVar.f10450a);
        return aVar;
    }

    public boolean j() {
        return this.h != null && this.h.f10443a;
    }

    public void k() {
        for (Presenter presenter : this.f) {
            if (presenter != null) {
                presenter.j();
            }
        }
        this.f.clear();
        if (this.g != null) {
            this.g.b(this.j);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        k();
    }
}
