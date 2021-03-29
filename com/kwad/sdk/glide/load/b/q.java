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
/* loaded from: classes6.dex */
public class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final List<n<Model, Data>> f35341a;

    /* renamed from: b  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f35342b;

    /* loaded from: classes6.dex */
    public static class a<Data> implements com.kwad.sdk.glide.load.a.d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final List<com.kwad.sdk.glide.load.a.d<Data>> f35343a;

        /* renamed from: b  reason: collision with root package name */
        public final Pools.Pool<List<Throwable>> f35344b;

        /* renamed from: c  reason: collision with root package name */
        public int f35345c;

        /* renamed from: d  reason: collision with root package name */
        public Priority f35346d;

        /* renamed from: e  reason: collision with root package name */
        public d.a<? super Data> f35347e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public List<Throwable> f35348f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f35349g;

        public a(@NonNull List<com.kwad.sdk.glide.load.a.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f35344b = pool;
            com.kwad.sdk.glide.g.j.a(list);
            this.f35343a = list;
            this.f35345c = 0;
        }

        private void e() {
            if (this.f35349g) {
                return;
            }
            if (this.f35345c < this.f35343a.size() - 1) {
                this.f35345c++;
                a(this.f35346d, this.f35347e);
                return;
            }
            com.kwad.sdk.glide.g.j.a(this.f35348f);
            this.f35347e.a((Exception) new GlideException("Fetch failed", new ArrayList(this.f35348f)));
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            return this.f35343a.get(0).a();
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            this.f35346d = priority;
            this.f35347e = aVar;
            this.f35348f = this.f35344b.acquire();
            this.f35343a.get(this.f35345c).a(priority, this);
            if (this.f35349g) {
                c();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public void a(@NonNull Exception exc) {
            ((List) com.kwad.sdk.glide.g.j.a(this.f35348f)).add(exc);
            e();
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public void a(@Nullable Data data) {
            if (data != null) {
                this.f35347e.a((d.a<? super Data>) data);
            } else {
                e();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            List<Throwable> list = this.f35348f;
            if (list != null) {
                this.f35344b.release(list);
            }
            this.f35348f = null;
            for (com.kwad.sdk.glide.load.a.d<Data> dVar : this.f35343a) {
                dVar.b();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void c() {
            this.f35349g = true;
            for (com.kwad.sdk.glide.load.a.d<Data> dVar : this.f35343a) {
                dVar.c();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public DataSource d() {
            return this.f35343a.get(0).d();
        }
    }

    public q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f35341a = list;
        this.f35342b = pool;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Model model, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        n.a<Data> a2;
        int size = this.f35341a.size();
        ArrayList arrayList = new ArrayList(size);
        com.kwad.sdk.glide.load.c cVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            n<Model, Data> nVar = this.f35341a.get(i3);
            if (nVar.a(model) && (a2 = nVar.a(model, i, i2, eVar)) != null) {
                cVar = a2.f35334a;
                arrayList.add(a2.f35336c);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new n.a<>(cVar, new a(arrayList, this.f35342b));
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Model model) {
        for (n<Model, Data> nVar : this.f35341a) {
            if (nVar.a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f35341a.toArray()) + '}';
    }
}
