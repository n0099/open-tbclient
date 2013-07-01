package com.google.gson.internal;

import java.util.AbstractCollection;
import java.util.Iterator;
/* loaded from: classes.dex */
final class y extends AbstractCollection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f1665a;

    private y(q qVar) {
        this.f1665a = qVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new z(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i;
        i = this.f1665a.d;
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f1665a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f1665a.clear();
    }
}
