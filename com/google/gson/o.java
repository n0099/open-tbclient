package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class o extends r implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    private final List f1671a = new ArrayList();

    public void a(r rVar) {
        if (rVar == null) {
            rVar = s.f1672a;
        }
        this.f1671a.add(rVar);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f1671a.iterator();
    }

    @Override // com.google.gson.r
    public Number a() {
        if (this.f1671a.size() == 1) {
            return ((r) this.f1671a.get(0)).a();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.r
    public String b() {
        if (this.f1671a.size() == 1) {
            return ((r) this.f1671a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.r
    public double c() {
        if (this.f1671a.size() == 1) {
            return ((r) this.f1671a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.r
    public long d() {
        if (this.f1671a.size() == 1) {
            return ((r) this.f1671a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.r
    public int e() {
        if (this.f1671a.size() == 1) {
            return ((r) this.f1671a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.r
    public boolean f() {
        if (this.f1671a.size() == 1) {
            return ((r) this.f1671a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f1671a.equals(this.f1671a));
    }

    public int hashCode() {
        return this.f1671a.hashCode();
    }
}
