package com.squareup.wire2.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes6.dex */
public final class ImmutableList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    public final ArrayList<T> list;

    public ImmutableList(List<T> list) {
        this.list = new ArrayList<>(list);
    }

    private Object writeReplace() throws ObjectStreamException {
        return Collections.unmodifiableList(this.list);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        return this.list.get(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.list.toArray();
    }
}
