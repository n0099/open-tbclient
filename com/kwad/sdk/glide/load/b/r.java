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
/* loaded from: classes7.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final c f36131a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final n<Object, Object> f36132b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final List<b<?, ?>> f36133c;

    /* renamed from: d  reason: collision with root package name */
    public final c f36134d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<b<?, ?>> f36135e;

    /* renamed from: f  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f36136f;

    /* loaded from: classes7.dex */
    public static class a implements n<Object, Object> {
        @Override // com.kwad.sdk.glide.load.b.n
        @Nullable
        public n.a<Object> a(@NonNull Object obj, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
            return null;
        }

        @Override // com.kwad.sdk.glide.load.b.n
        public boolean a(@NonNull Object obj) {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<Data> f36137a;

        /* renamed from: b  reason: collision with root package name */
        public final o<? extends Model, ? extends Data> f36138b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<Model> f36139c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.f36139c = cls;
            this.f36137a = cls2;
            this.f36138b = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f36139c.isAssignableFrom(cls);
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f36137a.isAssignableFrom(cls2);
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f36131a);
    }

    @VisibleForTesting
    public r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f36133c = new ArrayList();
        this.f36135e = new HashSet();
        this.f36136f = pool;
        this.f36134d = cVar;
    }

    @NonNull
    public static <Model, Data> n<Model, Data> a() {
        return (n<Model, Data>) f36132b;
    }

    @NonNull
    private <Model, Data> n<Model, Data> a(@NonNull b<?, ?> bVar) {
        return (n) com.kwad.sdk.glide.g.j.a(bVar.f36138b.a(this));
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f36133c;
        list.add(z ? list.size() : 0, bVar);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model, Data> n<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f36133c) {
                if (this.f36135e.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.f36135e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f36135e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f36134d.a(arrayList, this.f36136f);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return a();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f36135e.clear();
            throw th;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model> List<n<Model, ?>> a(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f36133c) {
                if (!this.f36135e.contains(bVar) && bVar.a(cls)) {
                    this.f36135e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f36135e.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f36135e.clear();
            throw th;
        }
        return arrayList;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    @NonNull
    public synchronized List<Class<?>> b(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f36133c) {
            if (!arrayList.contains(bVar.f36137a) && bVar.a(cls)) {
                arrayList.add(bVar.f36137a);
            }
        }
        return arrayList;
    }
}
