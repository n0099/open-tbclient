package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f10102a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10103b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C1123a<?>> f10104a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.kwad.sdk.glide.load.b.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1123a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f10105a;

            public C1123a(List<n<Model, ?>> list) {
                this.f10105a = list;
            }
        }

        a() {
        }

        @Nullable
        public <Model> List<n<Model, ?>> a(Class<Model> cls) {
            C1123a<?> c1123a = this.f10104a.get(cls);
            if (c1123a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c1123a.f10105a;
        }

        public void a() {
            this.f10104a.clear();
        }

        public <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f10104a.put(cls, new C1123a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    private p(@NonNull r rVar) {
        this.f10103b = new a();
        this.f10102a = rVar;
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a2) {
        return (Class<A>) a2.getClass();
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> b(@NonNull Class<A> cls) {
        List<n<A, ?>> a2;
        a2 = this.f10103b.a(cls);
        if (a2 == null) {
            a2 = Collections.unmodifiableList(this.f10102a.a(cls));
            this.f10103b.a(cls, a2);
        }
        return a2;
    }

    @NonNull
    public synchronized List<Class<?>> a(@NonNull Class<?> cls) {
        return this.f10102a.b(cls);
    }

    @NonNull
    public <A> List<n<A, ?>> a(@NonNull A a2) {
        List<n<A, ?>> b2 = b((Class) b(a2));
        int size = b2.size();
        boolean z = true;
        List<n<A, ?>> emptyList = Collections.emptyList();
        for (int i = 0; i < size; i++) {
            n<A, ?> nVar = b2.get(i);
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
        this.f10102a.a(cls, cls2, oVar);
        this.f10103b.a();
    }
}
