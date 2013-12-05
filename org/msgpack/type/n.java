package org.msgpack.type;

import java.util.AbstractCollection;
import java.util.Iterator;
/* loaded from: classes.dex */
class n extends AbstractCollection<r> {

    /* renamed from: a  reason: collision with root package name */
    private r[] f3129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(r[] rVarArr) {
        this.f3129a = rVarArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f3129a.length / 2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<r> iterator() {
        return new o(this.f3129a, 1);
    }
}
