package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f6687a;
    private final a b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C1146a<?>> f6688a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.kwad.sdk.glide.load.b.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C1146a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f6689a;

            public C1146a(List<n<Model, ?>> list) {
                this.f6689a = list;
            }
        }

        a() {
        }

        @Nullable
        public <Model> List<n<Model, ?>> a(Class<Model> cls) {
            C1146a<?> c1146a = this.f6688a.get(cls);
            if (c1146a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c1146a.f6689a;
        }

        public void a() {
            this.f6688a.clear();
        }

        public <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f6688a.put(cls, new C1146a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    private p(@NonNull r rVar) {
        this.b = new a();
        this.f6687a = rVar;
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a2) {
        return (Class<A>) a2.getClass();
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> b(@NonNull Class<A> cls) {
        List<n<A, ?>> a2;
        a2 = this.b.a(cls);
        if (a2 == null) {
            a2 = Collections.unmodifiableList(this.f6687a.a(cls));
            this.b.a(cls, a2);
        }
        return a2;
    }

    @NonNull
    public synchronized List<Class<?>> a(@NonNull Class<?> cls) {
        return this.f6687a.b(cls);
    }

    @NonNull
    public <A> List<n<A, ?>> a(@NonNull A a2) {
        List<n<A, ?>> b = b((Class) b(a2));
        int size = b.size();
        boolean z = true;
        List<n<A, ?>> emptyList = Collections.emptyList();
        for (int i = 0; i < size; i++) {
            n<A, ?> nVar = b.get(i);
            if (nVar.a(a2)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(nVar);
            }
        }
        return emptyList;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f6687a.a(cls, cls2, oVar);
        this.b.a();
    }
}
