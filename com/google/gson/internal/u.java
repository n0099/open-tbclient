package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;
/* loaded from: classes.dex */
final class u extends AbstractSet {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f1662a;

    private u(q qVar) {
        this.f1662a = qVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new v(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        int i;
        i = this.f1662a.d;
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f1662a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int i;
        int i2;
        i = this.f1662a.d;
        this.f1662a.remove(obj);
        i2 = this.f1662a.d;
        return i2 != i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f1662a.clear();
    }
}
