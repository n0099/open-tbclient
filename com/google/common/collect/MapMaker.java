package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap;
import d.h.c.a.a;
import d.h.c.a.j;
import d.h.c.a.n;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes6.dex */
public final class MapMaker {

    /* renamed from: a  reason: collision with root package name */
    public boolean f30996a;

    /* renamed from: b  reason: collision with root package name */
    public int f30997b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f30998c = -1;

    /* renamed from: d  reason: collision with root package name */
    public MapMakerInternalMap.Strength f30999d;

    /* renamed from: e  reason: collision with root package name */
    public MapMakerInternalMap.Strength f31000e;

    /* renamed from: f  reason: collision with root package name */
    public Equivalence<Object> f31001f;

    /* loaded from: classes6.dex */
    public enum Dummy {
        VALUE
    }

    public MapMaker a(int i) {
        n.y(this.f30998c == -1, "concurrency level was already set to %s", this.f30998c);
        n.d(i > 0);
        this.f30998c = i;
        return this;
    }

    public int b() {
        int i = this.f30998c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public int c() {
        int i = this.f30997b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public Equivalence<Object> d() {
        return (Equivalence) j.a(this.f31001f, e().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) j.a(this.f30999d, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) j.a(this.f31000e, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker g(int i) {
        n.y(this.f30997b == -1, "initial capacity was already set to %s", this.f30997b);
        n.d(i >= 0);
        this.f30997b = i;
        return this;
    }

    public MapMaker h(Equivalence<Object> equivalence) {
        n.A(this.f31001f == null, "key equivalence was already set to %s", this.f31001f);
        n.p(equivalence);
        this.f31001f = equivalence;
        this.f30996a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.f30996a) {
            return new ConcurrentHashMap(c(), 0.75f, b());
        }
        return MapMakerInternalMap.create(this);
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        n.A(this.f30999d == null, "Key strength was already set to %s", this.f30999d);
        n.p(strength);
        this.f30999d = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f30996a = true;
        }
        return this;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        n.A(this.f31000e == null, "Value strength was already set to %s", this.f31000e);
        n.p(strength);
        this.f31000e = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f30996a = true;
        }
        return this;
    }

    public MapMaker l() {
        j(MapMakerInternalMap.Strength.WEAK);
        return this;
    }

    public String toString() {
        j.b b2 = j.b(this);
        int i = this.f30997b;
        if (i != -1) {
            b2.b("initialCapacity", i);
        }
        int i2 = this.f30998c;
        if (i2 != -1) {
            b2.b("concurrencyLevel", i2);
        }
        MapMakerInternalMap.Strength strength = this.f30999d;
        if (strength != null) {
            b2.d("keyStrength", a.c(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f31000e;
        if (strength2 != null) {
            b2.d("valueStrength", a.c(strength2.toString()));
        }
        if (this.f31001f != null) {
            b2.h("keyEquivalence");
        }
        return b2.toString();
    }
}
