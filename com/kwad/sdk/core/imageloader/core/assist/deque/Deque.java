package com.kwad.sdk.core.imageloader.core.assist.deque;

import java.util.Iterator;
import java.util.Queue;
/* loaded from: classes7.dex */
public interface Deque extends Queue {
    @Override // java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(Object obj);

    void addFirst(Object obj);

    void addLast(Object obj);

    @Override // java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    Iterator descendingIterator();

    @Override // java.util.Queue
    Object element();

    Object getFirst();

    Object getLast();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator iterator();

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(Object obj);

    boolean offerFirst(Object obj);

    boolean offerLast(Object obj);

    @Override // java.util.Queue
    Object peek();

    Object peekFirst();

    Object peekLast();

    @Override // java.util.Queue
    Object poll();

    Object pollFirst();

    Object pollLast();

    Object pop();

    void push(Object obj);

    @Override // java.util.Queue
    Object remove();

    @Override // java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    Object removeFirst();

    boolean removeFirstOccurrence(Object obj);

    Object removeLast();

    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection
    int size();
}
