package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public final class j implements com.kwad.sdk.glide.load.engine.bitmap_recycle.b {

    /* renamed from: a  reason: collision with root package name */
    private final h<a, Object> f10196a;

    /* renamed from: b  reason: collision with root package name */
    private final b f10197b;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> c;
    private final Map<Class<?>, com.kwad.sdk.glide.load.engine.bitmap_recycle.a<?>> d;
    private final int e;
    private int f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f10198a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10199b;
        private Class<?> c;

        a(b bVar) {
            this.f10199b = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f10199b.a(this);
        }

        void a(int i, Class<?> cls) {
            this.f10198a = i;
            this.c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f10198a == aVar.f10198a && this.c == aVar.c;
            }
            return false;
        }

        public int hashCode() {
            return (this.c != null ? this.c.hashCode() : 0) + (this.f10198a * 31);
        }

        public String toString() {
            return "Key{size=" + this.f10198a + "array=" + this.c + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b extends d<a> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        a a(int i, Class<?> cls) {
            a c = c();
            c.a(i, cls);
            return c;
        }
    }

    @VisibleForTesting
    public j() {
        this.f10196a = new h<>();
        this.f10197b = new b();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = 4194304;
    }

    public j(int i) {
        this.f10196a = new h<>();
        this.f10197b = new b();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = i;
    }

    @Nullable
    private <T> T a(a aVar) {
        return (T) this.f10196a.a((h<a, Object>) aVar);
    }

    private <T> T a(a aVar, Class<T> cls) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b2 = b((Class) cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.f -= b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t) * b2.b();
            c(b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(b2.a(), 2)) {
                Log.v(b2.a(), "Allocated " + aVar.f10198a + " bytes");
            }
            return b2.a(aVar.f10198a);
        }
        return t;
    }

    private NavigableMap<Integer, Integer> a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean a(int i, Integer num) {
        return num != null && (b() || num.intValue() <= i * 8);
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b(Class<T> cls) {
        i iVar = (com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) this.d.get(cls);
        if (iVar == null) {
            if (cls.equals(int[].class)) {
                iVar = new i();
            } else if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            } else {
                iVar = new g();
            }
            this.d.put(cls, iVar);
        }
        return iVar;
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b(T t) {
        return b((Class) t.getClass());
    }

    private boolean b() {
        return this.f == 0 || this.e / this.f >= 2;
    }

    private boolean b(int i) {
        return i <= this.e / 2;
    }

    private void c() {
        c(this.e);
    }

    private void c(int i) {
        while (this.f > i) {
            Object a2 = this.f10196a.a();
            com.kwad.sdk.glide.g.j.a(a2);
            com.kwad.sdk.glide.load.engine.bitmap_recycle.a b2 = b((j) a2);
            this.f -= b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2) * b2.b();
            c(b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2), a2.getClass());
            if (Log.isLoggable(b2.a(), 2)) {
                Log.v(b2.a(), "evicted: " + b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2));
            }
        }
    }

    private void c(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> a2 = a(cls);
        Integer num = (Integer) a2.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        }
        if (num.intValue() == 1) {
            a2.remove(Integer.valueOf(i));
        } else {
            a2.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T a(int i, Class<T> cls) {
        Integer ceilingKey;
        ceilingKey = a((Class<?>) cls).ceilingKey(Integer.valueOf(i));
        return (T) a(a(i, ceilingKey) ? this.f10197b.a(ceilingKey.intValue(), cls) : this.f10197b.a(i, cls), (Class<Object>) cls);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized void a() {
        c(0);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized void a(int i) {
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            c(this.e / 2);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> void a(T t) {
        Class<?> cls = t.getClass();
        com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b2 = b((Class) cls);
        int a2 = b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t);
        int b3 = b2.b() * a2;
        if (b(b3)) {
            a a3 = this.f10197b.a(a2, cls);
            this.f10196a.a(a3, t);
            NavigableMap<Integer, Integer> a4 = a(cls);
            Integer num = (Integer) a4.get(Integer.valueOf(a3.f10198a));
            a4.put(Integer.valueOf(a3.f10198a), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
            this.f += b3;
            c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    @Deprecated
    public <T> void a(T t, Class<T> cls) {
        a((j) t);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T b(int i, Class<T> cls) {
        return (T) a(this.f10197b.a(i, cls), (Class<Object>) cls);
    }
}
