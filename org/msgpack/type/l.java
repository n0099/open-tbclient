package org.msgpack.type;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.msgpack.util.android.PortedImmutableEntry;
/* loaded from: classes.dex */
class l implements Iterator<Map.Entry<r, r>> {
    private static final boolean c;

    /* renamed from: a  reason: collision with root package name */
    private r[] f2914a;
    private int b = 0;

    static {
        try {
            Class.forName("java.util.AbstractMap.SimpleImmutableEntry");
            c = true;
        } catch (ClassNotFoundException e) {
            c = false;
        } catch (Throwable th) {
            c = true;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(r[] rVarArr) {
        this.f2914a = rVarArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f2914a.length;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: a */
    public Map.Entry<r, r> next() {
        Map.Entry<r, r> portedImmutableEntry;
        if (this.b >= this.f2914a.length) {
            throw new NoSuchElementException();
        }
        r rVar = this.f2914a[this.b];
        r rVar2 = this.f2914a[this.b + 1];
        if (c) {
            portedImmutableEntry = new AbstractMap.SimpleImmutableEntry<>(rVar, rVar2);
        } else {
            portedImmutableEntry = new PortedImmutableEntry<>(rVar, rVar2);
        }
        this.b += 2;
        return portedImmutableEntry;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
