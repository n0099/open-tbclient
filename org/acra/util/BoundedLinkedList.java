package org.acra.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class BoundedLinkedList extends LinkedList {
    private final int maxSize;

    public BoundedLinkedList(int i) {
        this.maxSize = i;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(Object obj) {
        if (size() == this.maxSize) {
            removeFirst();
        }
        return super.add(obj);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        if (size() == this.maxSize) {
            removeFirst();
        }
        super.add(i, obj);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        int size = (size() + collection.size()) - this.maxSize;
        if (size > 0) {
            removeRange(0, size);
        }
        return super.addAll(collection);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addLast(Object obj) {
        add(obj);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }
}
