package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public final class j implements com.kwad.sdk.glide.load.engine.bitmap_recycle.b {

    /* renamed from: a  reason: collision with root package name */
    public final h<a, Object> f35774a;

    /* renamed from: b  reason: collision with root package name */
    public final b f35775b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f35776c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.engine.bitmap_recycle.a<?>> f35777d;

    /* renamed from: e  reason: collision with root package name */
    public final int f35778e;

    /* renamed from: f  reason: collision with root package name */
    public int f35779f;

    /* loaded from: classes6.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        public int f35780a;

        /* renamed from: b  reason: collision with root package name */
        public final b f35781b;

        /* renamed from: c  reason: collision with root package name */
        public Class<?> f35782c;

        public a(b bVar) {
            this.f35781b = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f35781b.a(this);
        }

        public void a(int i, Class<?> cls) {
            this.f35780a = i;
            this.f35782c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f35780a == aVar.f35780a && this.f35782c == aVar.f35782c;
            }
            return false;
        }

        public int hashCode() {
            int i = this.f35780a * 31;
            Class<?> cls = this.f35782c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f35780a + "array=" + this.f35782c + '}';
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends d<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        public a a(int i, Class<?> cls) {
            a c2 = c();
            c2.a(i, cls);
            return c2;
        }
    }

    @VisibleForTesting
    public j() {
        this.f35774a = new h<>();
        this.f35775b = new b();
        this.f35776c = new HashMap();
        this.f35777d = new HashMap();
        this.f35778e = 4194304;
    }

    public j(int i) {
        this.f35774a = new h<>();
        this.f35775b = new b();
        this.f35776c = new HashMap();
        this.f35777d = new HashMap();
        this.f35778e = i;
    }

    @Nullable
    private <T> T a(a aVar) {
        return (T) this.f35774a.a((h<a, Object>) aVar);
    }

    private <T> T a(a aVar, Class<T> cls) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b2 = b((Class) cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.f35779f -= b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t) * b2.b();
            c(b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(b2.a(), 2)) {
                Log.v(b2.a(), "Allocated " + aVar.f35780a + " bytes");
            }
            return b2.a(aVar.f35780a);
        }
        return t;
    }

    private NavigableMap<Integer, Integer> a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f35776c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f35776c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean a(int i, Integer num) {
        return num != null && (b() || num.intValue() <= i * 8);
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b(Class<T> cls) {
        i iVar = (com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) this.f35777d.get(cls);
        if (iVar == null) {
            if (cls.equals(int[].class)) {
                iVar = new i();
            } else if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            } else {
                iVar = new g();
            }
            this.f35777d.put(cls, iVar);
        }
        return iVar;
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b(T t) {
        return b((Class) t.getClass());
    }

    private boolean b() {
        int i = this.f35779f;
        return i == 0 || this.f35778e / i >= 2;
    }

    private boolean b(int i) {
        return i <= this.f35778e / 2;
    }

    private void c() {
        c(this.f35778e);
    }

    private void c(int i) {
        while (this.f35779f > i) {
            Object a2 = this.f35774a.a();
            com.kwad.sdk.glide.g.j.a(a2);
            com.kwad.sdk.glide.load.engine.bitmap_recycle.a b2 = b((j) a2);
            this.f35779f -= b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2) * b2.b();
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
        int intValue = num.intValue();
        Integer valueOf = Integer.valueOf(i);
        if (intValue == 1) {
            a2.remove(valueOf);
        } else {
            a2.put(valueOf, Integer.valueOf(num.intValue() - 1));
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T a(int i, Class<T> cls) {
        Integer ceilingKey;
        ceilingKey = a((Class<?>) cls).ceilingKey(Integer.valueOf(i));
        return (T) a(a(i, ceilingKey) ? this.f35775b.a(ceilingKey.intValue(), cls) : this.f35775b.a(i, cls), (Class<Object>) cls);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized void a() {
        c(0);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized void a(int i) {
        try {
            if (i >= 40) {
                a();
            } else if (i >= 20 || i == 15) {
                c(this.f35778e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> void a(T t) {
        Class<?> cls = t.getClass();
        com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b2 = b((Class) cls);
        int a2 = b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t);
        int b3 = b2.b() * a2;
        if (b(b3)) {
            a a3 = this.f35775b.a(a2, cls);
            this.f35774a.a(a3, t);
            NavigableMap<Integer, Integer> a4 = a(cls);
            Integer num = (Integer) a4.get(Integer.valueOf(a3.f35780a));
            Integer valueOf = Integer.valueOf(a3.f35780a);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            a4.put(valueOf, Integer.valueOf(i));
            this.f35779f += b3;
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
        return (T) a(this.f35775b.a(i, cls), (Class<Object>) cls);
    }
}
