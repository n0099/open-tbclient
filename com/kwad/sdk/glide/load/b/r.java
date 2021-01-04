package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.load.b.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final c f10409a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final n<Object, Object> f10410b = new a();
    private final List<b<?, ?>> c;
    private final c d;
    private final Set<b<?, ?>> e;
    private final Pools.Pool<List<Throwable>> f;

    /* loaded from: classes5.dex */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // com.kwad.sdk.glide.load.b.n
        @Nullable
        public n.a<Object> a(@NonNull Object obj, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
            return null;
        }

        @Override // com.kwad.sdk.glide.load.b.n
        public boolean a(@NonNull Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        final Class<Data> f10411a;

        /* renamed from: b  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f10412b;
        private final Class<Model> c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.c = cls;
            this.f10411a = cls2;
            this.f10412b = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.c.isAssignableFrom(cls);
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f10411a.isAssignableFrom(cls2);
        }
    }

    /* loaded from: classes5.dex */
    static class c {
        c() {
        }

        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f10409a);
    }

    @VisibleForTesting
    r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.c = new ArrayList();
        this.e = new HashSet();
        this.f = pool;
        this.d = cVar;
    }

    @NonNull
    private static <Model, Data> n<Model, Data> a() {
        return (n<Model, Data>) f10410b;
    }

    @NonNull
    private <Model, Data> n<Model, Data> a(@NonNull b<?, ?> bVar) {
        return (n) com.kwad.sdk.glide.g.j.a(bVar.f10412b.a(this));
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z) {
        this.c.add(z ? this.c.size() : 0, new b<>(cls, cls2, oVar));
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model, Data> n<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        n<Model, Data> a2;
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.c) {
                if (this.e.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.e.add(bVar);
                    arrayList.add(a(bVar));
                    this.e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                a2 = this.d.a(arrayList, this.f);
            } else if (arrayList.size() == 1) {
                a2 = (n) arrayList.get(0);
            } else if (!z) {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            } else {
                a2 = a();
            }
        } catch (Throwable th) {
            this.e.clear();
            throw th;
        }
        return a2;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model> List<n<Model, ?>> a(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.c) {
                if (!this.e.contains(bVar) && bVar.a(cls)) {
                    this.e.add(bVar);
                    arrayList.add(a(bVar));
                    this.e.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.e.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized List<Class<?>> b(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.c) {
            if (!arrayList.contains(bVar.f10411a) && bVar.a(cls)) {
                arrayList.add(bVar.f10411a);
            }
        }
        return arrayList;
    }
}
