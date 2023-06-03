package com.yy.transvod.player.common;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes10.dex */
public class ConcurrentLinkedQueueX<E> extends ConcurrentLinkedQueue<E> {
    public final String tag = ConcurrentLinkedQueueX.class.getSimpleName();
    public Object mLock = new Object();
    public int elementCount = 0;

    public int getElementCount() {
        int i;
        synchronized (this.mLock) {
            i = this.elementCount;
        }
        return i;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public E poll() {
        E e = (E) super.poll();
        if (e != null) {
            synchronized (this.mLock) {
                if (this.elementCount > 0) {
                    this.elementCount--;
                }
            }
        }
        return e;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        boolean add = super.add(e);
        if (add) {
            synchronized (this.mLock) {
                if (this.elementCount < Integer.MAX_VALUE) {
                    this.elementCount++;
                }
            }
        }
        return add;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll = super.addAll(collection);
        if (addAll) {
            int size = collection.size();
            synchronized (this.mLock) {
                for (int i = 0; i < size; i++) {
                    if (this.elementCount >= Integer.MAX_VALUE) {
                        break;
                    }
                    this.elementCount++;
                }
            }
        }
        return addAll;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        boolean remove = super.remove(obj);
        if (remove) {
            synchronized (this.mLock) {
                if (this.elementCount > 0) {
                    this.elementCount--;
                }
            }
        }
        return remove;
    }
}
