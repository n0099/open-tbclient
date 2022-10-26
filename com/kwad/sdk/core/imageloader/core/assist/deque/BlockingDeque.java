package com.kwad.sdk.core.imageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public interface BlockingDeque extends Deque, BlockingQueue {
    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void addFirst(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void addLast(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    Object element();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.lang.Iterable
    Iterator iterator();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(Object obj);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(Object obj, long j, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean offerFirst(Object obj);

    boolean offerFirst(Object obj, long j, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean offerLast(Object obj);

    boolean offerLast(Object obj, long j, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    Object peek();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    Object poll();

    @Override // java.util.concurrent.BlockingQueue
    Object poll(long j, TimeUnit timeUnit);

    Object pollFirst(long j, TimeUnit timeUnit);

    Object pollLast(long j, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void push(Object obj);

    @Override // java.util.concurrent.BlockingQueue
    void put(Object obj);

    void putFirst(Object obj);

    void putLast(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    Object remove();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection
    int size();

    @Override // java.util.concurrent.BlockingQueue
    Object take();

    Object takeFirst();

    Object takeLast();
}
