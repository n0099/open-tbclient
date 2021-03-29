package com.kwad.sdk.lib.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.widget.recycler.a.b;
import com.kwad.sdk.lib.widget.recycler.b.a;
import com.kwad.sdk.lib.widget.recycler.b.a.C0428a;
import com.kwad.sdk.mvp.Presenter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public abstract class c<Model, CallerContext extends a.C0428a<Model>> extends a<Model, com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext>> {

    /* renamed from: c  reason: collision with root package name */
    public static final ExecutorService f36009c = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());

    /* renamed from: d  reason: collision with root package name */
    public KsFragment f36010d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f36011e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<Presenter> f36012f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, Model> f36013g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.a.d<Model> f36014h;
    public final com.kwad.sdk.lib.widget.recycler.a.e<Model> i;
    public f j;

    public c(KsFragment ksFragment, RecyclerView recyclerView) {
        this.j = new f() { // from class: com.kwad.sdk.lib.widget.recycler.c.1
            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z) {
                if (c.this.f36014h != null) {
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
                if (c.this.f36013g.e()) {
                    return;
                }
                if (c.this.f36014h != null) {
                    c cVar = c.this;
                    cVar.a(cVar.a(z, z2));
                    return;
                }
                c cVar2 = c.this;
                cVar2.a(cVar2.f36013g.g());
                c.this.notifyDataSetChanged();
            }
        };
        this.f36012f = new LinkedHashSet();
        this.f36010d = ksFragment;
        this.f36011e = recyclerView;
        this.i = null;
    }

    public c(KsFragment ksFragment, RecyclerView recyclerView, @NonNull com.kwad.sdk.lib.widget.recycler.a.e<Model> eVar) {
        super(false);
        this.j = new f() { // from class: com.kwad.sdk.lib.widget.recycler.c.1
            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z) {
                if (c.this.f36014h != null) {
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
                if (c.this.f36013g.e()) {
                    return;
                }
                if (c.this.f36014h != null) {
                    c cVar = c.this;
                    cVar.a(cVar.a(z, z2));
                    return;
                }
                c cVar2 = c.this;
                cVar2.a(cVar2.f36013g.g());
                c.this.notifyDataSetChanged();
            }
        };
        this.f36012f = new LinkedHashSet();
        this.f36010d = ksFragment;
        this.f36011e = recyclerView;
        this.i = eVar;
        this.f35971a = new com.kwad.sdk.lib.widget.b(a());
    }

    private List<Model> a() {
        com.kwad.sdk.lib.widget.recycler.a.d<Model> dVar = new com.kwad.sdk.lib.widget.recycler.a.d<>(new com.kwad.sdk.lib.widget.recycler.a.a(this), new b.a(this.i).a(f36009c).a(), this);
        this.f36014h = dVar;
        return new com.kwad.sdk.lib.widget.recycler.a.c(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.f36014h.b(this.f36013g.g());
        } else {
            this.f36014h.a(this.f36013g.g());
        }
    }

    public abstract View a(ViewGroup viewGroup, int i);

    public abstract Presenter a(int i);

    public void a(com.kwad.sdk.lib.b.c<?, Model> cVar) {
        com.kwad.sdk.lib.b.c<?, Model> cVar2 = this.f36013g;
        if (cVar2 != null) {
            cVar2.b(this.j);
        }
        this.f36013g = cVar;
        cVar.a(this.j);
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, Model>, com.kwad.sdk.lib.b.c<?, MODEL> */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, MODEL] */
    public void a(CallerContext callercontext, int i) {
        ?? r0 = this.f35971a.get(i);
        callercontext.f36003d = this.f36010d;
        callercontext.f36004e = this.f36011e;
        callercontext.f36005f = (com.kwad.sdk.lib.b.c<?, Model>) this.f36013g;
        callercontext.f36007h = i;
        callercontext.i = r0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> aVar) {
        super.onViewRecycled(aVar);
        if (aVar != null) {
            View view = aVar.itemView;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> aVar, int i) {
        com.kwad.sdk.core.d.a.a("RecyclerAdapter", "onBindViewHolder position" + i);
        a((c<Model, CallerContext>) aVar.f36002b, i);
        aVar.f36001a.a(aVar.f36002b);
    }

    public boolean a(boolean z, boolean z2) {
        return z;
    }

    public abstract CallerContext b();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> onCreateViewHolder(ViewGroup viewGroup, int i) {
        com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> aVar = new com.kwad.sdk.lib.widget.recycler.b.a<>(a(viewGroup, i), a(i), b());
        this.f36012f.add(aVar.f36001a);
        return aVar;
    }

    public boolean j() {
        com.kwad.sdk.lib.widget.recycler.a.d<Model> dVar = this.f36014h;
        return dVar != null && dVar.f35987a;
    }

    public void k() {
        for (Presenter presenter : this.f36012f) {
            if (presenter != null) {
                presenter.j();
            }
        }
        this.f36012f.clear();
        com.kwad.sdk.lib.b.c<?, Model> cVar = this.f36013g;
        if (cVar != null) {
            cVar.b(this.j);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        k();
    }
}
