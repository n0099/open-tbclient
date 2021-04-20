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
    public static final d<Object> f35492a = new d<Object>() { // from class: com.kwad.sdk.glide.g.a.a.1
        @Override // com.kwad.sdk.glide.g.a.a.d
        public void a(@NonNull Object obj) {
        }
    };

    /* renamed from: com.kwad.sdk.glide.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0424a<T> {
        T b();
    }

    /* loaded from: classes6.dex */
    public static final class b<T> implements Pools.Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        public final InterfaceC0424a<T> f35493a;

        /* renamed from: b  reason: collision with root package name */
        public final d<T> f35494b;

        /* renamed from: c  reason: collision with root package name */
        public final Pools.Pool<T> f35495c;

        public b(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0424a<T> interfaceC0424a, @NonNull d<T> dVar) {
            this.f35495c = pool;
            this.f35493a = interfaceC0424a;
            this.f35494b = dVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f35495c.acquire();
            if (acquire == null) {
                acquire = this.f35493a.b();
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
            this.f35494b.a(t);
            return this.f35495c.release(t);
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
        return a(new Pools.SynchronizedPool(i), new InterfaceC0424a<List<T>>() { // from class: com.kwad.sdk.glide.g.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0424a
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
    public static <T extends c> Pools.Pool<T> a(int i, @NonNull InterfaceC0424a<T> interfaceC0424a) {
        return a(new Pools.SynchronizedPool(i), interfaceC0424a);
    }

    @NonNull
    public static <T extends c> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0424a<T> interfaceC0424a) {
        return a(pool, interfaceC0424a, b());
    }

    @NonNull
    public static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC0424a<T> interfaceC0424a, @NonNull d<T> dVar) {
        return new b(pool, interfaceC0424a, dVar);
    }

    @NonNull
    public static <T> d<T> b() {
        return (d<T>) f35492a;
    }
}
