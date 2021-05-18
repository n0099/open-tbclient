package com.squareup.wire2.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes7.dex */
public final class MutableOnWriteList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    public final List<T> immutableList;
    public List<T> mutableList;

    public MutableOnWriteList(List<T> list) {
        this.immutableList = list;
        this.mutableList = list;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.mutableList);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        this.mutableList.add(i2, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        return this.mutableList.get(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i2) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        return this.mutableList.remove(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        return this.mutableList.set(i2, t);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mutableList.size();
    }
}
