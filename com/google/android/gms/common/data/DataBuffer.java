package com.google.android.gms.common.data;

import com.google.android.gms.internal.i;
import com.google.android.gms.internal.k;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class DataBuffer implements Iterable {
    protected final k a;

    public DataBuffer(k kVar) {
        this.a = kVar;
    }

    public int a() {
        return this.a.d();
    }

    public abstract Object b(int i);

    public void b() {
        this.a.f();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new i(this);
    }
}
