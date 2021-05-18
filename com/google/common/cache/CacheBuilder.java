package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers;
import com.google.common.cache.LocalCache;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import d.g.c.a.j;
import d.g.c.a.n;
import d.g.c.a.r;
import d.g.c.a.t;
import d.g.c.b.c;
import d.g.c.b.d;
import d.g.c.b.f;
import d.g.c.b.i;
import d.g.c.b.j;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class CacheBuilder<K, V> {
    public static final r<? extends d.g.c.b.b> q = Suppliers.a(new a());
    public static final d r = new d(0, 0, 0, 0, 0, 0);
    public static final t s = new b();
    public static final Logger t = Logger.getLogger(CacheBuilder.class.getName());

    /* renamed from: f  reason: collision with root package name */
    public j<? super K, ? super V> f30876f;

    /* renamed from: g  reason: collision with root package name */
    public LocalCache.Strength f30877g;

    /* renamed from: h  reason: collision with root package name */
    public LocalCache.Strength f30878h;
    public Equivalence<Object> l;
    public Equivalence<Object> m;
    public i<? super K, ? super V> n;
    public t o;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30871a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f30872b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f30873c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f30874d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f30875e = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f30879i = -1;
    public long j = -1;
    public long k = -1;
    public r<? extends d.g.c.b.b> p = q;

    /* loaded from: classes6.dex */
    public enum NullListener implements i<Object, Object> {
        INSTANCE;

        @Override // d.g.c.b.i
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* loaded from: classes6.dex */
    public enum OneWeigher implements j<Object, Object> {
        INSTANCE;

        @Override // d.g.c.b.j
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements d.g.c.b.b {
        @Override // d.g.c.b.b
        public void a(int i2) {
        }

        @Override // d.g.c.b.b
        public void b() {
        }

        @Override // d.g.c.b.b
        public void c(long j) {
        }

        @Override // d.g.c.b.b
        public void d(int i2) {
        }

        @Override // d.g.c.b.b
        public void e(long j) {
        }

        @Override // d.g.c.b.b
        public d f() {
            return CacheBuilder.r;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends t {
        @Override // d.g.c.a.t
        public long a() {
            return 0L;
        }
    }

    public static CacheBuilder<Object, Object> y() {
        return new CacheBuilder<>();
    }

    public CacheBuilder<K, V> A(LocalCache.Strength strength) {
        n.A(this.f30877g == null, "Key strength was already set to %s", this.f30877g);
        n.p(strength);
        this.f30877g = strength;
        return this;
    }

    public CacheBuilder<K, V> B(LocalCache.Strength strength) {
        n.A(this.f30878h == null, "Value strength was already set to %s", this.f30878h);
        n.p(strength);
        this.f30878h = strength;
        return this;
    }

    public CacheBuilder<K, V> C(t tVar) {
        n.w(this.o == null);
        n.p(tVar);
        this.o = tVar;
        return this;
    }

    public CacheBuilder<K, V> D(Equivalence<Object> equivalence) {
        n.A(this.m == null, "value equivalence was already set to %s", this.m);
        n.p(equivalence);
        this.m = equivalence;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.cache.CacheBuilder<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: d.g.c.b.j<? super K1 extends K, ? super V1 extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> E(j<? super K1, ? super V1> jVar) {
        n.w(this.f30876f == null);
        if (this.f30871a) {
            n.z(this.f30874d == -1, "weigher can not be combined with maximum size", this.f30874d);
        }
        n.p(jVar);
        this.f30876f = jVar;
        return this;
    }

    public <K1 extends K, V1 extends V> c<K1, V1> a() {
        d();
        c();
        return new LocalCache.LocalManualCache(this);
    }

    public <K1 extends K, V1 extends V> f<K1, V1> b(CacheLoader<? super K1, V1> cacheLoader) {
        d();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public final void c() {
        n.x(this.k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    public final void d() {
        if (this.f30876f == null) {
            n.x(this.f30875e == -1, "maximumWeight requires weigher");
        } else if (this.f30871a) {
            n.x(this.f30875e != -1, "weigher requires maximumWeight");
        } else if (this.f30875e == -1) {
            t.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public CacheBuilder<K, V> e(int i2) {
        n.y(this.f30873c == -1, "concurrency level was already set to %s", this.f30873c);
        n.d(i2 > 0);
        this.f30873c = i2;
        return this;
    }

    public CacheBuilder<K, V> f(long j, TimeUnit timeUnit) {
        n.z(this.j == -1, "expireAfterAccess was already set to %s ns", this.j);
        n.j(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.j = timeUnit.toNanos(j);
        return this;
    }

    public CacheBuilder<K, V> g(long j, TimeUnit timeUnit) {
        n.z(this.f30879i == -1, "expireAfterWrite was already set to %s ns", this.f30879i);
        n.j(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.f30879i = timeUnit.toNanos(j);
        return this;
    }

    public int h() {
        int i2 = this.f30873c;
        if (i2 == -1) {
            return 4;
        }
        return i2;
    }

    public long i() {
        long j = this.j;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public long j() {
        long j = this.f30879i;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public int k() {
        int i2 = this.f30872b;
        if (i2 == -1) {
            return 16;
        }
        return i2;
    }

    public Equivalence<Object> l() {
        return (Equivalence) d.g.c.a.j.a(this.l, m().defaultEquivalence());
    }

    public LocalCache.Strength m() {
        return (LocalCache.Strength) d.g.c.a.j.a(this.f30877g, LocalCache.Strength.STRONG);
    }

    public long n() {
        if (this.f30879i == 0 || this.j == 0) {
            return 0L;
        }
        return this.f30876f == null ? this.f30874d : this.f30875e;
    }

    public long o() {
        long j = this.k;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public <K1 extends K, V1 extends V> i<K1, V1> p() {
        return (i) d.g.c.a.j.a(this.n, NullListener.INSTANCE);
    }

    public r<? extends d.g.c.b.b> q() {
        return this.p;
    }

    public t r(boolean z) {
        t tVar = this.o;
        return tVar != null ? tVar : z ? t.b() : s;
    }

    public Equivalence<Object> s() {
        return (Equivalence) d.g.c.a.j.a(this.m, t().defaultEquivalence());
    }

    public LocalCache.Strength t() {
        return (LocalCache.Strength) d.g.c.a.j.a(this.f30878h, LocalCache.Strength.STRONG);
    }

    public String toString() {
        j.b b2 = d.g.c.a.j.b(this);
        int i2 = this.f30872b;
        if (i2 != -1) {
            b2.b("initialCapacity", i2);
        }
        int i3 = this.f30873c;
        if (i3 != -1) {
            b2.b("concurrencyLevel", i3);
        }
        long j = this.f30874d;
        if (j != -1) {
            b2.c("maximumSize", j);
        }
        long j2 = this.f30875e;
        if (j2 != -1) {
            b2.c("maximumWeight", j2);
        }
        if (this.f30879i != -1) {
            b2.d("expireAfterWrite", this.f30879i + NotificationStyle.NOTIFICATION_STYLE);
        }
        if (this.j != -1) {
            b2.d("expireAfterAccess", this.j + NotificationStyle.NOTIFICATION_STYLE);
        }
        LocalCache.Strength strength = this.f30877g;
        if (strength != null) {
            b2.d("keyStrength", d.g.c.a.a.c(strength.toString()));
        }
        LocalCache.Strength strength2 = this.f30878h;
        if (strength2 != null) {
            b2.d("valueStrength", d.g.c.a.a.c(strength2.toString()));
        }
        if (this.l != null) {
            b2.h("keyEquivalence");
        }
        if (this.m != null) {
            b2.h("valueEquivalence");
        }
        if (this.n != null) {
            b2.h("removalListener");
        }
        return b2.toString();
    }

    public <K1 extends K, V1 extends V> d.g.c.b.j<K1, V1> u() {
        return (d.g.c.b.j) d.g.c.a.j.a(this.f30876f, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> v(Equivalence<Object> equivalence) {
        n.A(this.l == null, "key equivalence was already set to %s", this.l);
        n.p(equivalence);
        this.l = equivalence;
        return this;
    }

    public CacheBuilder<K, V> w(long j) {
        n.z(this.f30874d == -1, "maximum size was already set to %s", this.f30874d);
        n.z(this.f30875e == -1, "maximum weight was already set to %s", this.f30875e);
        n.x(this.f30876f == null, "maximum size can not be combined with weigher");
        n.e(j >= 0, "maximum size must not be negative");
        this.f30874d = j;
        return this;
    }

    public CacheBuilder<K, V> x(long j) {
        n.z(this.f30875e == -1, "maximum weight was already set to %s", this.f30875e);
        n.z(this.f30874d == -1, "maximum size was already set to %s", this.f30874d);
        this.f30875e = j;
        n.e(j >= 0, "maximum weight must not be negative");
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.cache.CacheBuilder<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: d.g.c.b.i<? super K1 extends K, ? super V1 extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> z(i<? super K1, ? super V1> iVar) {
        n.w(this.n == null);
        n.p(iVar);
        this.n = iVar;
        return this;
    }
}
