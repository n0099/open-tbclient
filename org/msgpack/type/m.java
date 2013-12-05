package org.msgpack.type;

import java.util.AbstractSet;
import java.util.Iterator;
/* loaded from: classes.dex */
class m extends AbstractSet<r> {

    /* renamed from: a  reason: collision with root package name */
    private r[] f3128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r[] rVarArr) {
        this.f3128a = rVarArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f3128a.length / 2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<r> iterator() {
        return new o(this.f3128a, 0);
    }
}
