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
/* loaded from: classes7.dex */
public class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final List<n<Model, Data>> f36122a;

    /* renamed from: b  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f36123b;

    /* loaded from: classes7.dex */
    public static class a<Data> implements com.kwad.sdk.glide.load.a.d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final List<com.kwad.sdk.glide.load.a.d<Data>> f36124a;

        /* renamed from: b  reason: collision with root package name */
        public final Pools.Pool<List<Throwable>> f36125b;

        /* renamed from: c  reason: collision with root package name */
        public int f36126c;

        /* renamed from: d  reason: collision with root package name */
        public Priority f36127d;

        /* renamed from: e  reason: collision with root package name */
        public d.a<? super Data> f36128e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public List<Throwable> f36129f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f36130g;

        public a(@NonNull List<com.kwad.sdk.glide.load.a.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f36125b = pool;
            com.kwad.sdk.glide.g.j.a(list);
            this.f36124a = list;
            this.f36126c = 0;
        }

        private void e() {
            if (this.f36130g) {
                return;
            }
            if (this.f36126c < this.f36124a.size() - 1) {
                this.f36126c++;
                a(this.f36127d, this.f36128e);
                return;
            }
            com.kwad.sdk.glide.g.j.a(this.f36129f);
            this.f36128e.a((Exception) new GlideException("Fetch failed", new ArrayList(this.f36129f)));
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            return this.f36124a.get(0).a();
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            this.f36127d = priority;
            this.f36128e = aVar;
            this.f36129f = this.f36125b.acquire();
            this.f36124a.get(this.f36126c).a(priority, this);
            if (this.f36130g) {
                c();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public void a(@NonNull Exception exc) {
            ((List) com.kwad.sdk.glide.g.j.a(this.f36129f)).add(exc);
            e();
        }

        @Override // com.kwad.sdk.glide.load.a.d.a
        public void a(@Nullable Data data) {
            if (data != null) {
                this.f36128e.a((d.a<? super Data>) data);
            } else {
                e();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            List<Throwable> list = this.f36129f;
            if (list != null) {
                this.f36125b.release(list);
            }
            this.f36129f = null;
            for (com.kwad.sdk.glide.load.a.d<Data> dVar : this.f36124a) {
                dVar.b();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void c() {
            this.f36130g = true;
            for (com.kwad.sdk.glide.load.a.d<Data> dVar : this.f36124a) {
                dVar.c();
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public DataSource d() {
            return this.f36124a.get(0).d();
        }
    }

    public q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f36122a = list;
        this.f36123b = pool;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        n.a<Data> a2;
        int size = this.f36122a.size();
        ArrayList arrayList = new ArrayList(size);
        com.kwad.sdk.glide.load.c cVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n<Model, Data> nVar = this.f36122a.get(i4);
            if (nVar.a(model) && (a2 = nVar.a(model, i2, i3, eVar)) != null) {
                cVar = a2.f36115a;
                arrayList.add(a2.f36117c);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new n.a<>(cVar, new a(arrayList, this.f36123b));
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Model model) {
        for (n<Model, Data> nVar : this.f36122a) {
            if (nVar.a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f36122a.toArray()) + '}';
    }
}
