package com.squareup.wire2.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes19.dex */
final class ImmutableList<T> extends AbstractList<T> implements Serializable, RandomAccess {
    private final ArrayList<T> list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList(List<T> list) {
        this.list = new ArrayList<>(list);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.list.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.list.toArray();
    }

    private Object writeReplace() throws ObjectStreamException {
        return Collections.unmodifiableList(this.list);
    }
}
