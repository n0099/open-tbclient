package org.msgpack.type;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
class k extends AbstractSet<Map.Entry<r, r>> {

    /* renamed from: a  reason: collision with root package name */
    private r[] f3126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(r[] rVarArr) {
        this.f3126a = rVarArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f3126a.length / 2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<r, r>> iterator() {
        return new l(this.f3126a);
    }
}
