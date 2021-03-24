package com.kwad.sdk.glide.g.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d<Object> f35202a = new d<Object>() { // from class: com.kwad.sdk.glide.g.a.a.1
        @Override // com.kwad.sdk.glide.g.a.a.d
        public void a(@NonNull Object obj) {
        }
    };

    /* renamed from: com.kwad.sdk.glide.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0409a<T> {
        T b();
    }

    /* loaded from: classes6.dex */
    public static final class b<T> implements Pools.Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        public final InterfaceC0409a<T> f35203a;

        /* renamed from: b  reason: collision with root package name */
        public final d<T> f35204b;

        /* renamed from: c  reason: collision with root package name */
        public final Pools.Pool<T> f35205c;

        public b(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0409a<T> interfaceC0409a, @NonNull d<T> dVar) {
            this.f35205c = pool;
            this.f35203a = interfaceC0409a;
            this.f35204b = dVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f35205c.acquire();
            if (acquire == null) {
                acquire = this.f35203a.b();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof c) {
                ((c) acquire).d().a(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof c) {
                ((c) t).d().a(true);
            }
            this.f35204b.a(t);
            return this.f35205c.release(t);
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        @NonNull
        com.kwad.sdk.glide.g.a.c d();
    }

    /* loaded from: classes6.dex */
    public interface d<T> {
        void a(@NonNull T t);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a() {
        return a(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a(int i) {
        return a(new Pools.SynchronizedPool(i), new InterfaceC0409a<List<T>>() { // from class: com.kwad.sdk.glide.g.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0409a
            @NonNull
            /* renamed from: a */
            public List<T> b() {
                return new ArrayList();
            }
        }, new d<List<T>>() { // from class: com.kwad.sdk.glide.g.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.d
            public void a(@NonNull List<T> list) {
                list.clear();
            }
        });
    }

    @NonNull
    public static <T extends c> Pools.Pool<T> a(int i, @NonNull InterfaceC0409a<T> interfaceC0409a) {
        return a(new Pools.SynchronizedPool(i), interfaceC0409a);
    }

    @NonNull
    public static <T extends c> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0409a<T> interfaceC0409a) {
        return a(pool, interfaceC0409a, b());
    }

    @NonNull
    public static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0409a<T> interfaceC0409a, @NonNull d<T> dVar) {
        return new b(pool, interfaceC0409a, dVar);
    }

    @NonNull
    public static <T> d<T> b() {
        return (d<T>) f35202a;
    }
}
