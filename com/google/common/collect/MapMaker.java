package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap;
import d.g.c.a.a;
import d.g.c.a.j;
import d.g.c.a.n;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes6.dex */
public final class MapMaker {

    /* renamed from: a  reason: collision with root package name */
    public boolean f31137a;

    /* renamed from: b  reason: collision with root package name */
    public int f31138b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f31139c = -1;

    /* renamed from: d  reason: collision with root package name */
    public MapMakerInternalMap.Strength f31140d;

    /* renamed from: e  reason: collision with root package name */
    public MapMakerInternalMap.Strength f31141e;

    /* renamed from: f  reason: collision with root package name */
    public Equivalence<Object> f31142f;

    /* loaded from: classes6.dex */
    public enum Dummy {
        VALUE
    }

    public MapMaker a(int i2) {
        n.y(this.f31139c == -1, "concurrency level was already set to %s", this.f31139c);
        n.d(i2 > 0);
        this.f31139c = i2;
        return this;
    }

    public int b() {
        int i2 = this.f31139c;
        if (i2 == -1) {
            return 4;
        }
        return i2;
    }

    public int c() {
        int i2 = this.f31138b;
        if (i2 == -1) {
            return 16;
        }
        return i2;
    }

    public Equivalence<Object> d() {
        return (Equivalence) j.a(this.f31142f, e().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) j.a(this.f31140d, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) j.a(this.f31141e, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker g(int i2) {
        n.y(this.f31138b == -1, "initial capacity was already set to %s", this.f31138b);
        n.d(i2 >= 0);
        this.f31138b = i2;
        return this;
    }

    public MapMaker h(Equivalence<Object> equivalence) {
        n.A(this.f31142f == null, "key equivalence was already set to %s", this.f31142f);
        n.p(equivalence);
        this.f31142f = equivalence;
        this.f31137a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.f31137a) {
            return new ConcurrentHashMap(c(), 0.75f, b());
        }
        return MapMakerInternalMap.create(this);
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        n.A(this.f31140d == null, "Key strength was already set to %s", this.f31140d);
        n.p(strength);
        this.f31140d = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f31137a = true;
        }
        return this;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        n.A(this.f31141e == null, "Value strength was already set to %s", this.f31141e);
        n.p(strength);
        this.f31141e = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f31137a = true;
        }
        return this;
    }

    public MapMaker l() {
        j(MapMakerInternalMap.Strength.WEAK);
        return this;
    }

    public String toString() {
        j.b b2 = j.b(this);
        int i2 = this.f31138b;
        if (i2 != -1) {
            b2.b("initialCapacity", i2);
        }
        int i3 = this.f31139c;
        if (i3 != -1) {
            b2.b("concurrencyLevel", i3);
        }
        MapMakerInternalMap.Strength strength = this.f31140d;
        if (strength != null) {
            b2.d("keyStrength", a.c(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f31141e;
        if (strength2 != null) {
            b2.d("valueStrength", a.c(strength2.toString()));
        }
        if (this.f31142f != null) {
            b2.h("keyEquivalence");
        }
        return b2.toString();
    }
}
