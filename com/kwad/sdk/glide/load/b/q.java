package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f6690a;
    private final Pools.Pool<List<Throwable>> b;

    /* loaded from: classes3.dex */
    static class a<Data> implements com.kwad.sdk.glide.load.a.d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.kwad.sdk.glide.load.a.d<Data>> f6691a;
        private final Pools.Pool<List<Throwable>> b;
        private int c;
        private Priority d;
        private d.a<? super Data> e;
        @Nullable
        private List<Throwable> f;
        private boolean g;

        a(@NonNull List<com.kwad.sdk.glide.load.a.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.b = pool;
            com.kwad.sdk.glide.g.j.a(list);
            this.f6691a = list;
            this.c = 0;
        }

        private void e() {
            if (this.g) {
                return;
            }
            if (this.c < this.f6691a.size() - 1) {
                this.c++;
                a(this.d, this.e);
                return;
            }
            com.kwad.sdk.glide.g.j.a(this.f);
            this.e.a((Exception) new GlideException("Fetch failed", new ArrayList(this.f)));
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            return this.f6691a.get(0).a();
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            this.d = priority;
            this.e = aVar;
            this.f = this.b.acquire();
            this.f6691a.get(this.c).a(priority, this);
            if (this.g) {
                c();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public void a(@NonNull Exception exc) {
            ((List) com.kwad.sdk.glide.g.j.a(this.f)).add(exc);
            e();
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public void a(@Nullable Data data) {
            if (data != null) {
                this.e.a((d.a<? super Data>) data);
            } else {
                e();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            if (this.f != null) {
                this.b.release(this.f);
            }
            this.f = null;
            for (com.kwad.sdk.glide.load.a.d<Data> dVar : this.f6691a) {
                dVar.b();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void c() {
            this.g = true;
            for (com.kwad.sdk.glide.load.a.d<Data> dVar : this.f6691a) {
                dVar.c();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public DataSource d() {
            return this.f6691a.get(0).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f6690a = list;
        this.b = pool;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Model model, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        com.kwad.sdk.glide.load.c cVar;
        n.a<Data> a2;
        int size = this.f6690a.size();
        ArrayList arrayList = new ArrayList(size);
        int i3 = 0;
        com.kwad.sdk.glide.load.c cVar2 = null;
        while (i3 < size) {
            n<Model, Data> nVar = this.f6690a.get(i3);
            if (!nVar.a(model) || (a2 = nVar.a(model, i, i2, eVar)) == null) {
                cVar = cVar2;
            } else {
                cVar = a2.f6686a;
                arrayList.add(a2.c);
            }
            i3++;
            cVar2 = cVar;
        }
        if (arrayList.isEmpty() || cVar2 == null) {
            return null;
        }
        return new n.a<>(cVar2, new a(arrayList, this.b));
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Model model) {
        for (n<Model, Data> nVar : this.f6690a) {
            if (nVar.a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f6690a.toArray()) + '}';
    }
}
