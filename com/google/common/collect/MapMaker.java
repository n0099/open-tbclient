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
    public boolean f31963a;

    /* renamed from: b  reason: collision with root package name */
    public int f31964b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f31965c = -1;

    /* renamed from: d  reason: collision with root package name */
    public MapMakerInternalMap.Strength f31966d;

    /* renamed from: e  reason: collision with root package name */
    public MapMakerInternalMap.Strength f31967e;

    /* renamed from: f  reason: collision with root package name */
    public Equivalence<Object> f31968f;

    /* loaded from: classes6.dex */
    public enum Dummy {
        VALUE
    }

    public MapMaker a(int i2) {
        n.y(this.f31965c == -1, "concurrency level was already set to %s", this.f31965c);
        n.d(i2 > 0);
        this.f31965c = i2;
        return this;
    }

    public int b() {
        int i2 = this.f31965c;
        if (i2 == -1) {
            return 4;
        }
        return i2;
    }

    public int c() {
        int i2 = this.f31964b;
        if (i2 == -1) {
            return 16;
        }
        return i2;
    }

    public Equivalence<Object> d() {
        return (Equivalence) j.a(this.f31968f, e().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) j.a(this.f31966d, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) j.a(this.f31967e, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker g(int i2) {
        n.y(this.f31964b == -1, "initial capacity was already set to %s", this.f31964b);
        n.d(i2 >= 0);
        this.f31964b = i2;
        return this;
    }

    public MapMaker h(Equivalence<Object> equivalence) {
        n.A(this.f31968f == null, "key equivalence was already set to %s", this.f31968f);
        n.p(equivalence);
        this.f31968f = equivalence;
        this.f31963a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.f31963a) {
            return new ConcurrentHashMap(c(), 0.75f, b());
        }
        return MapMakerInternalMap.create(this);
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        n.A(this.f31966d == null, "Key strength was already set to %s", this.f31966d);
        n.p(strength);
        this.f31966d = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f31963a = true;
        }
        return this;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        n.A(this.f31967e == null, "Value strength was already set to %s", this.f31967e);
        n.p(strength);
        this.f31967e = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f31963a = true;
        }
        return this;
    }

    public MapMaker l() {
        j(MapMakerInternalMap.Strength.WEAK);
        return this;
    }

    public String toString() {
        j.b b2 = j.b(this);
        int i2 = this.f31964b;
        if (i2 != -1) {
            b2.b("initialCapacity", i2);
        }
        int i3 = this.f31965c;
        if (i3 != -1) {
            b2.b("concurrencyLevel", i3);
        }
        MapMakerInternalMap.Strength strength = this.f31966d;
        if (strength != null) {
            b2.d("keyStrength", a.c(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f31967e;
        if (strength2 != null) {
            b2.d("valueStrength", a.c(strength2.toString()));
        }
        if (this.f31968f != null) {
            b2.h("keyEquivalence");
        }
        return b2.toString();
    }
}
