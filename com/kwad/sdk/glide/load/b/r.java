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
/* loaded from: classes6.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final c f35349a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final n<Object, Object> f35350b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final List<b<?, ?>> f35351c;

    /* renamed from: d  reason: collision with root package name */
    public final c f35352d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<b<?, ?>> f35353e;

    /* renamed from: f  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f35354f;

    /* loaded from: classes6.dex */
    public static class a implements n<Object, Object> {
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

    /* loaded from: classes6.dex */
    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<Data> f35355a;

        /* renamed from: b  reason: collision with root package name */
        public final o<? extends Model, ? extends Data> f35356b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<Model> f35357c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.f35357c = cls;
            this.f35355a = cls2;
            this.f35356b = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35357c.isAssignableFrom(cls);
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f35355a.isAssignableFrom(cls2);
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f35349a);
    }

    @VisibleForTesting
    public r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f35351c = new ArrayList();
        this.f35353e = new HashSet();
        this.f35354f = pool;
        this.f35352d = cVar;
    }

    @NonNull
    public static <Model, Data> n<Model, Data> a() {
        return (n<Model, Data>) f35350b;
    }

    @NonNull
    private <Model, Data> n<Model, Data> a(@NonNull b<?, ?> bVar) {
        return (n) com.kwad.sdk.glide.g.j.a(bVar.f35356b.a(this));
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f35351c;
        list.add(z ? list.size() : 0, bVar);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model, Data> n<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f35351c) {
                if (this.f35353e.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.f35353e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f35353e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f35352d.a(arrayList, this.f35354f);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return a();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f35353e.clear();
            throw th;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model> List<n<Model, ?>> a(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f35351c) {
                if (!this.f35353e.contains(bVar) && bVar.a(cls)) {
                    this.f35353e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f35353e.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f35353e.clear();
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
        for (b<?, ?> bVar : this.f35351c) {
            if (!arrayList.contains(bVar.f35355a) && bVar.a(cls)) {
                arrayList.add(bVar.f35355a);
            }
        }
        return arrayList;
    }
}
