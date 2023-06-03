package com.facebook.imagepipeline.cache;

import java.util.LinkedHashSet;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes9.dex */
public class BoundedLinkedHashSet<E> {
    public LinkedHashSet<E> mLinkedHashSet;
    public int mMaxSize;

    public BoundedLinkedHashSet(int i) {
        this.mLinkedHashSet = new LinkedHashSet<>(i);
        this.mMaxSize = i;
    }

    public synchronized boolean add(E e) {
        if (this.mLinkedHashSet.size() == this.mMaxSize) {
            this.mLinkedHashSet.remove(this.mLinkedHashSet.iterator().next());
        }
        this.mLinkedHashSet.remove(e);
        return this.mLinkedHashSet.add(e);
    }

    public synchronized boolean contains(E e) {
        return this.mLinkedHashSet.contains(e);
    }
}
