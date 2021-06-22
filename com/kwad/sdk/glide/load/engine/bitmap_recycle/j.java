package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class j implements com.kwad.sdk.glide.load.engine.bitmap_recycle.b {

    /* renamed from: a  reason: collision with root package name */
    public final h<a, Object> f36269a;

    /* renamed from: b  reason: collision with root package name */
    public final b f36270b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f36271c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.engine.bitmap_recycle.a<?>> f36272d;

    /* renamed from: e  reason: collision with root package name */
    public final int f36273e;

    /* renamed from: f  reason: collision with root package name */
    public int f36274f;

    /* loaded from: classes7.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        public int f36275a;

        /* renamed from: b  reason: collision with root package name */
        public final b f36276b;

        /* renamed from: c  reason: collision with root package name */
        public Class<?> f36277c;

        public a(b bVar) {
            this.f36276b = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f36276b.a(this);
        }

        public void a(int i2, Class<?> cls) {
            this.f36275a = i2;
            this.f36277c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f36275a == aVar.f36275a && this.f36277c == aVar.f36277c;
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.f36275a * 31;
            Class<?> cls = this.f36277c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f36275a + "array=" + this.f36277c + '}';
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends d<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        public a a(int i2, Class<?> cls) {
            a c2 = c();
            c2.a(i2, cls);
            return c2;
        }
    }

    @VisibleForTesting
    public j() {
        this.f36269a = new h<>();
        this.f36270b = new b();
        this.f36271c = new HashMap();
        this.f36272d = new HashMap();
        this.f36273e = 4194304;
    }

    public j(int i2) {
        this.f36269a = new h<>();
        this.f36270b = new b();
        this.f36271c = new HashMap();
        this.f36272d = new HashMap();
        this.f36273e = i2;
    }

    @Nullable
    private <T> T a(a aVar) {
        return (T) this.f36269a.a((h<a, Object>) aVar);
    }

    private <T> T a(a aVar, Class<T> cls) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b2 = b((Class) cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.f36274f -= b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t) * b2.b();
            c(b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(b2.a(), 2)) {
                Log.v(b2.a(), "Allocated " + aVar.f36275a + " bytes");
            }
            return b2.a(aVar.f36275a);
        }
        return t;
    }

    private NavigableMap<Integer, Integer> a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f36271c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f36271c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean a(int i2, Integer num) {
        return num != null && (b() || num.intValue() <= i2 * 8);
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b(Class<T> cls) {
        i iVar = (com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) this.f36272d.get(cls);
        if (iVar == null) {
            if (cls.equals(int[].class)) {
                iVar = new i();
            } else if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            } else {
                iVar = new g();
            }
            this.f36272d.put(cls, iVar);
        }
        return iVar;
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b(T t) {
        return b((Class) t.getClass());
    }

    private boolean b() {
        int i2 = this.f36274f;
        return i2 == 0 || this.f36273e / i2 >= 2;
    }

    private boolean b(int i2) {
        return i2 <= this.f36273e / 2;
    }

    private void c() {
        c(this.f36273e);
    }

    private void c(int i2) {
        while (this.f36274f > i2) {
            Object a2 = this.f36269a.a();
            com.kwad.sdk.glide.g.j.a(a2);
            com.kwad.sdk.glide.load.engine.bitmap_recycle.a b2 = b((j) a2);
            this.f36274f -= b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2) * b2.b();
            c(b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2), a2.getClass());
            if (Log.isLoggable(b2.a(), 2)) {
                Log.v(b2.a(), "evicted: " + b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2));
            }
        }
    }

    private void c(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> a2 = a(cls);
        Integer num = (Integer) a2.get(Integer.valueOf(i2));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
        }
        int intValue = num.intValue();
        Integer valueOf = Integer.valueOf(i2);
        if (intValue == 1) {
            a2.remove(valueOf);
        } else {
            a2.put(valueOf, Integer.valueOf(num.intValue() - 1));
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T a(int i2, Class<T> cls) {
        Integer ceilingKey;
        ceilingKey = a((Class<?>) cls).ceilingKey(Integer.valueOf(i2));
        return (T) a(a(i2, ceilingKey) ? this.f36270b.a(ceilingKey.intValue(), cls) : this.f36270b.a(i2, cls), (Class<Object>) cls);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized void a() {
        c(0);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized void a(int i2) {
        try {
            if (i2 >= 40) {
                a();
            } else if (i2 >= 20 || i2 == 15) {
                c(this.f36273e / 2);
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
            a a3 = this.f36270b.a(a2, cls);
            this.f36269a.a(a3, t);
            NavigableMap<Integer, Integer> a4 = a(cls);
            Integer num = (Integer) a4.get(Integer.valueOf(a3.f36275a));
            Integer valueOf = Integer.valueOf(a3.f36275a);
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            a4.put(valueOf, Integer.valueOf(i2));
            this.f36274f += b3;
            c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    @Deprecated
    public <T> void a(T t, Class<T> cls) {
        a((j) t);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T b(int i2, Class<T> cls) {
        return (T) a(this.f36270b.a(i2, cls), (Class<Object>) cls);
    }
}
