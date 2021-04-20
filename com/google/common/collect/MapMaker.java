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
    public boolean f30901a;

    /* renamed from: b  reason: collision with root package name */
    public int f30902b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f30903c = -1;

    /* renamed from: d  reason: collision with root package name */
    public MapMakerInternalMap.Strength f30904d;

    /* renamed from: e  reason: collision with root package name */
    public MapMakerInternalMap.Strength f30905e;

    /* renamed from: f  reason: collision with root package name */
    public Equivalence<Object> f30906f;

    /* loaded from: classes6.dex */
    public enum Dummy {
        VALUE
    }

    public MapMaker a(int i) {
        n.y(this.f30903c == -1, "concurrency level was already set to %s", this.f30903c);
        n.d(i > 0);
        this.f30903c = i;
        return this;
    }

    public int b() {
        int i = this.f30903c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public int c() {
        int i = this.f30902b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public Equivalence<Object> d() {
        return (Equivalence) j.a(this.f30906f, e().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) j.a(this.f30904d, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) j.a(this.f30905e, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker g(int i) {
        n.y(this.f30902b == -1, "initial capacity was already set to %s", this.f30902b);
        n.d(i >= 0);
        this.f30902b = i;
        return this;
    }

    public MapMaker h(Equivalence<Object> equivalence) {
        n.A(this.f30906f == null, "key equivalence was already set to %s", this.f30906f);
        n.p(equivalence);
        this.f30906f = equivalence;
        this.f30901a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.f30901a) {
            return new ConcurrentHashMap(c(), 0.75f, b());
        }
        return MapMakerInternalMap.create(this);
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        n.A(this.f30904d == null, "Key strength was already set to %s", this.f30904d);
        n.p(strength);
        this.f30904d = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f30901a = true;
        }
        return this;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        n.A(this.f30905e == null, "Value strength was already set to %s", this.f30905e);
        n.p(strength);
        this.f30905e = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f30901a = true;
        }
        return this;
    }

    public MapMaker l() {
        j(MapMakerInternalMap.Strength.WEAK);
        return this;
    }

    public String toString() {
        j.b b2 = j.b(this);
        int i = this.f30902b;
        if (i != -1) {
            b2.b("initialCapacity", i);
        }
        int i2 = this.f30903c;
        if (i2 != -1) {
            b2.b("concurrencyLevel", i2);
        }
        MapMakerInternalMap.Strength strength = this.f30904d;
        if (strength != null) {
            b2.d("keyStrength", a.c(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f30905e;
        if (strength2 != null) {
            b2.d("valueStrength", a.c(strength2.toString()));
        }
        if (this.f30906f != null) {
            b2.h("keyEquivalence");
        }
        return b2.toString();
    }
}
