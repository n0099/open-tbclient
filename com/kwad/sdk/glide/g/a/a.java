package com.kwad.sdk.glide.g.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final d<Object> f6624a = new d<Object>() { // from class: com.kwad.sdk.glide.g.a.a.1
        @Override // com.kwad.sdk.glide.g.a.a.d
        public void a(@NonNull Object obj) {
        }
    };

    /* renamed from: com.kwad.sdk.glide.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1142a<T> {
        T b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b<T> implements Pools.Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final InterfaceC1142a<T> f6625a;
        private final d<T> b;
        private final Pools.Pool<T> c;

        b(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC1142a<T> interfaceC1142a, @NonNull d<T> dVar) {
            this.c = pool;
            this.f6625a = interfaceC1142a;
            this.b = dVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.c.acquire();
            if (acquire == null) {
                acquire = this.f6625a.b();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
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
            this.b.a(t);
            return this.c.release(t);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        @NonNull
        com.kwad.sdk.glide.g.a.c d();
    }

    /* loaded from: classes3.dex */
    public interface d<T> {
        void a(@NonNull T t);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a() {
        return a(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a(int i) {
        return a(new Pools.SynchronizedPool(i), new InterfaceC1142a<List<T>>() { // from class: com.kwad.sdk.glide.g.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC1142a
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
    public static <T extends c> Pools.Pool<T> a(int i, @NonNull InterfaceC1142a<T> interfaceC1142a) {
        return a(new Pools.SynchronizedPool(i), interfaceC1142a);
    }

    @NonNull
    private static <T extends c> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC1142a<T> interfaceC1142a) {
        return a(pool, interfaceC1142a, b());
    }

    @NonNull
    private static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC1142a<T> interfaceC1142a, @NonNull d<T> dVar) {
        return new b(pool, interfaceC1142a, dVar);
    }

    @NonNull
    private static <T> d<T> b() {
        return (d<T>) f6624a;
    }
}
