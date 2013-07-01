package com.google.gson.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
abstract class x implements Iterator {
    w b;
    w c;
    final /* synthetic */ q d;

    private x(q qVar) {
        w wVar;
        this.d = qVar;
        wVar = this.d.f1659a;
        this.b = wVar.e;
        this.c = null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        w wVar;
        w wVar2 = this.b;
        wVar = this.d.f1659a;
        return wVar2 != wVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w b() {
        w wVar;
        w wVar2 = this.b;
        wVar = this.d.f1659a;
        if (wVar2 == wVar) {
            throw new NoSuchElementException();
        }
        this.b = wVar2.e;
        this.c = wVar2;
        return wVar2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.c == null) {
            throw new IllegalStateException();
        }
        this.d.remove(this.c.f1664a);
        this.c = null;
    }
}
