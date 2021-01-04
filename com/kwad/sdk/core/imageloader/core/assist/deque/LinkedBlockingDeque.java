package com.kwad.sdk.core.imageloader.core.assist.deque;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient Node<E> first;
    transient Node<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* loaded from: classes5.dex */
    private abstract class AbstractItr implements Iterator<E> {
        private Node<E> lastRet;
        Node<E> next;
        E nextItem;

        AbstractItr() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.next = firstNode();
                this.nextItem = this.next == null ? null : this.next.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        private Node<E> succ(Node<E> node) {
            while (true) {
                Node<E> nextNode = nextNode(node);
                if (nextNode == null) {
                    return null;
                }
                if (nextNode.item != null) {
                    return nextNode;
                }
                if (nextNode == node) {
                    return firstNode();
                }
                node = nextNode;
            }
        }

        void advance() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.next = succ(this.next);
                this.nextItem = this.next == null ? null : this.next.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        abstract Node<E> firstNode();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            this.lastRet = this.next;
            E e = this.nextItem;
            advance();
            return e;
        }

        abstract Node<E> nextNode(Node<E> node);

        @Override // java.util.Iterator
        public void remove() {
            Node<E> node = this.lastRet;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.lastRet = null;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                if (node.item != null) {
                    LinkedBlockingDeque.this.unlink(node);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* loaded from: classes5.dex */
    private class DescendingItr extends LinkedBlockingDeque<E>.AbstractItr {
        private DescendingItr() {
            super();
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return LinkedBlockingDeque.this.last;
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return node.prev;
        }
    }

    /* loaded from: classes5.dex */
    private class Itr extends LinkedBlockingDeque<E>.AbstractItr {
        private Itr() {
            super();
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return LinkedBlockingDeque.this.first;
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return node.next;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E e) {
            this.item = e;
        }
    }

    public LinkedBlockingDeque() {
        this((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public LinkedBlockingDeque(int i) {
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e : collection) {
                if (e == null) {
                    throw new NullPointerException();
                }
                if (!linkLast(new Node<>(e))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean linkFirst(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.first;
        node.next = node2;
        this.first = node;
        if (this.last == null) {
            this.last = node;
        } else {
            node2.prev = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.last;
        node.prev = node2;
        this.last = node;
        if (this.first == null) {
            this.first = node;
        } else {
            node2.next = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            add(readObject);
        }
    }

    private E unlinkFirst() {
        Node<E> node = this.first;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.next;
        E e = node.item;
        node.item = null;
        node.next = node;
        this.first = node2;
        if (node2 == null) {
            this.last = null;
        } else {
            node2.prev = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E unlinkLast() {
        Node<E> node = this.last;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.prev;
        E e = node.item;
        node.item = null;
        node.prev = node;
        this.last = node2;
        if (node2 == null) {
            this.first = null;
        } else {
            node2.next = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (Node<E> node = this.first; node != null; node = node.next) {
                objectOutputStream.writeObject(node.item);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            while (node != null) {
                node.item = null;
                Node<E> node2 = node.next;
                node.prev = null;
                node.next = null;
                node = node2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: E, ? super E */
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int min = Math.min(i, this.count);
            for (int i2 = 0; i2 < min; i2++) {
                collection.add((E) this.first.item);
                unlinkFirst();
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E element() {
        return getFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst == null) {
            throw new NoSuchElementException();
        }
        return peekFirst;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E getLast() {
        E peekLast = peekLast();
        if (peekLast == null) {
            throw new NoSuchElementException();
        }
        return peekLast;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Iterator<E> iterator() {
        return new Itr();
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return offerLast(e, j, timeUnit);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean offerFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkFirst(node);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public boolean offerFirst(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!linkFirst(node)) {
            try {
                if (nanos <= 0) {
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean offerLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkLast(node);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public boolean offerLast(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!linkLast(node)) {
            try {
                if (nanos <= 0) {
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return true;
    }

    @Override // java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E peek() {
        return peekFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.first == null ? null : this.first.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E poll() {
        return pollFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) {
        return pollFirst(j, timeUnit);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public E pollFirst(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = nanos;
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                if (j2 <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(j2);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public E pollLast(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = nanos;
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                if (j2 <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(j2);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public void push(E e) {
        addFirst(e);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e) {
        putLast(e);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public void putFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkFirst(node)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public void putLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkLast(node)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst == null) {
            throw new NoSuchElementException();
        }
        return pollFirst;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast == null) {
            throw new NoSuchElementException();
        }
        return pollLast;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.last; node != null; node = node.prev) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() {
        return takeFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public E takeFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public E takeLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            Node<E> node = this.first;
            while (node != null) {
                int i2 = i + 1;
                objArr[i] = node.item;
                node = node.next;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count);
            }
            int i = 0;
            Node<E> node = this.first;
            while (node != null) {
                tArr[i] = node.item;
                node = node.next;
                i++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String sb;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            if (node == null) {
                sb = "[]";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('[');
                while (true) {
                    Node<E> node2 = node;
                    Object obj = node2.item;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    sb2.append(obj);
                    node = node2.next;
                    if (node == null) {
                        break;
                    }
                    sb2.append(',').append(' ');
                }
                sb = sb2.append(']').toString();
            }
            return sb;
        } finally {
            reentrantLock.unlock();
        }
    }

    void unlink(Node<E> node) {
        Node<E> node2 = node.prev;
        Node<E> node3 = node.next;
        if (node2 == null) {
            unlinkFirst();
        } else if (node3 == null) {
            unlinkLast();
        } else {
            node2.next = node3;
            node3.prev = node2;
            node.item = null;
            this.count--;
            this.notFull.signal();
        }
    }
}
