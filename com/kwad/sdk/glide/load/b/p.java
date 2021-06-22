package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final r f36118a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36119b;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Class<?>, C0417a<?>> f36120a = new HashMap();

        /* renamed from: com.kwad.sdk.glide.load.b.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0417a<Model> {

            /* renamed from: a  reason: collision with root package name */
            public final List<n<Model, ?>> f36121a;

            public C0417a(List<n<Model, ?>> list) {
                this.f36121a = list;
            }
        }

        @Nullable
        public <Model> List<n<Model, ?>> a(Class<Model> cls) {
            C0417a<?> c0417a = this.f36120a.get(cls);
            if (c0417a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0417a.f36121a;
        }

        public void a() {
            this.f36120a.clear();
        }

        public <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f36120a.put(cls, new C0417a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    public p(@NonNull r rVar) {
        this.f36119b = new a();
        this.f36118a = rVar;
    }

    @NonNull
    public static <A> Class<A> b(@NonNull A a2) {
        return (Class<A>) a2.getClass();
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> b(@NonNull Class<A> cls) {
        List<n<A, ?>> a2;
        a2 = this.f36119b.a(cls);
        if (a2 == null) {
            a2 = Collections.unmodifiableList(this.f36118a.a(cls));
            this.f36119b.a(cls, a2);
        }
        return a2;
    }

    @NonNull
    public synchronized List<Class<?>> a(@NonNull Class<?> cls) {
        return this.f36118a.b(cls);
    }

    @NonNull
    public <A> List<n<A, ?>> a(@NonNull A a2) {
        List<n<A, ?>> b2 = b((Class) b(a2));
        int size = b2.size();
        List<n<A, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i2 = 0; i2 < size; i2++) {
            n<A, ?> nVar = b2.get(i2);
            if (nVar.a(a2)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i2);
                    z = false;
                }
                emptyList.add(nVar);
            }
        }
        return emptyList;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f36118a.a(cls, cls2, oVar);
        this.f36119b.a();
    }
}
