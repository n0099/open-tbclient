package org.msgpack.type;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
class o implements Iterator<r> {

    /* renamed from: a  reason: collision with root package name */
    private r[] f2949a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(r[] rVarArr, int i) {
        this.f2949a = rVarArr;
        this.b = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f2949a.length;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: a */
    public r next() {
        if (this.b >= this.f2949a.length) {
            throw new NoSuchElementException();
        }
        r rVar = this.f2949a[this.b];
        this.b += 2;
        return rVar;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
