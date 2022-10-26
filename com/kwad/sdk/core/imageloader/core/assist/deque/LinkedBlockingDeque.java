package com.kwad.sdk.core.imageloader.core.assist.deque;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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
/* loaded from: classes7.dex */
public class LinkedBlockingDeque extends AbstractQueue implements BlockingDeque, Serializable {
    public static final long serialVersionUID = -387911632671998426L;
    public final int capacity;
    public transient int count;
    public transient Node first;
    public transient Node last;
    public final ReentrantLock lock;
    public final Condition notEmpty;
    public final Condition notFull;

    /* loaded from: classes7.dex */
    public abstract class AbstractItr implements Iterator {
        public Node lastRet;
        public Node next;
        public Object nextItem;

        public AbstractItr() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                Node firstNode = firstNode();
                this.next = firstNode;
                this.nextItem = firstNode == null ? null : firstNode.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        private Node succ(Node node) {
            while (true) {
                Node nextNode = nextNode(node);
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

        public void advance() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                Node succ = succ(this.next);
                this.next = succ;
                this.nextItem = succ == null ? null : succ.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        public abstract Node firstNode();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            Node node = this.next;
            if (node != null) {
                this.lastRet = node;
                Object obj = this.nextItem;
                advance();
                return obj;
            }
            throw new NoSuchElementException();
        }

        public abstract Node nextNode(Node node);

        @Override // java.util.Iterator
        public void remove() {
            Node node = this.lastRet;
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

    /* loaded from: classes7.dex */
    public class DescendingItr extends AbstractItr {
        public DescendingItr() {
            super();
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        public Node firstNode() {
            return LinkedBlockingDeque.this.last;
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        public Node nextNode(Node node) {
            return node.prev;
        }
    }

    /* loaded from: classes7.dex */
    public class Itr extends AbstractItr {
        public Itr() {
            super();
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        public Node firstNode() {
            return LinkedBlockingDeque.this.first;
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        public Node nextNode(Node node) {
            return node.next;
        }
    }

    /* loaded from: classes7.dex */
    public final class Node {
        public Object item;
        public Node next;
        public Node prev;

        public Node(Object obj) {
            this.item = obj;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
    }

    public LinkedBlockingDeque(Collection collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Object obj : collection) {
                if (obj == null) {
                    throw new NullPointerException();
                }
                if (!linkLast(new Node(obj))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean linkFirst(Node node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node node2 = this.first;
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

    private boolean linkLast(Node node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node node2 = this.last;
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

    private Object unlinkFirst() {
        Node node = this.first;
        if (node == null) {
            return null;
        }
        Node node2 = node.next;
        Object obj = node.item;
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
        return obj;
    }

    private Object unlinkLast() {
        Node node = this.last;
        if (node == null) {
            return null;
        }
        Node node2 = node.prev;
        Object obj = node.item;
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
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (Node node = this.first; node != null; node = node.next) {
                objectOutputStream.writeObject(node.item);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public void addFirst(Object obj) {
        if (!offerFirst(obj)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public void addLast(Object obj) {
        if (!offerLast(obj)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node node = this.first;
            while (node != null) {
                node.item = null;
                Node node2 = node.next;
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
            for (Node node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Iterator descendingIterator() {
        return new DescendingItr();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        if (collection != null) {
            if (collection != this) {
                ReentrantLock reentrantLock = this.lock;
                reentrantLock.lock();
                try {
                    int min = Math.min(i, this.count);
                    for (int i2 = 0; i2 < min; i2++) {
                        collection.add(this.first.item);
                        unlinkFirst();
                    }
                    return min;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object element() {
        return getFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object getFirst() {
        Object peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object getLast() {
        Object peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Iterator iterator() {
        return new Itr();
    }

    public boolean offer(Object obj) {
        return offerLast(obj);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(Object obj, long j, TimeUnit timeUnit) {
        return offerLast(obj, j, timeUnit);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean offerFirst(Object obj) {
        if (obj != null) {
            Node node = new Node(obj);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkFirst(node);
            } finally {
                reentrantLock.unlock();
            }
        }
        throw null;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public boolean offerFirst(Object obj, long j, TimeUnit timeUnit) {
        if (obj != null) {
            Node node = new Node(obj);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (!linkFirst(node)) {
                try {
                    if (nanos <= 0) {
                        reentrantLock.unlock();
                        return false;
                    }
                    nanos = this.notFull.awaitNanos(nanos);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            reentrantLock.unlock();
            return true;
        }
        throw null;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean offerLast(Object obj) {
        if (obj != null) {
            Node node = new Node(obj);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkLast(node);
            } finally {
                reentrantLock.unlock();
            }
        }
        throw null;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public boolean offerLast(Object obj, long j, TimeUnit timeUnit) {
        if (obj != null) {
            Node node = new Node(obj);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (!linkLast(node)) {
                try {
                    if (nanos <= 0) {
                        reentrantLock.unlock();
                        return false;
                    }
                    nanos = this.notFull.awaitNanos(nanos);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            reentrantLock.unlock();
            return true;
        }
        throw null;
    }

    @Override // java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object peek() {
        return peekFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.first == null ? null : this.first.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object poll() {
        return pollFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public Object poll(long j, TimeUnit timeUnit) {
        return pollFirst(j, timeUnit);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public Object pollFirst(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                Object unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public Object pollLast(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                Object unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object pop() {
        return removeFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public void push(Object obj) {
        addFirst(obj);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(Object obj) {
        putLast(obj);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public void putFirst(Object obj) {
        if (obj == null) {
            throw null;
        }
        Node node = new Node(obj);
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
    public void putLast(Object obj) {
        if (obj == null) {
            throw null;
        }
        Node node = new Node(obj);
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
    public Object remove() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object removeFirst() {
        Object pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object removeLast() {
        Object pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node node = this.last; node != null; node = node.prev) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    reentrantLock.unlock();
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
    public Object take() {
        return takeFirst();
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public Object takeFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                Object unlinkFirst = unlinkFirst();
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
    public Object takeLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                Object unlinkLast = unlinkLast();
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
            Node node = this.first;
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

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (objArr.length < this.count) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.count);
            }
            int i = 0;
            Node node = this.first;
            while (node != null) {
                objArr[i] = node.item;
                node = node.next;
                i++;
            }
            if (objArr.length > i) {
                objArr[i] = null;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node node = this.first;
            if (node == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = node.item;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                node = node.next;
                if (node == null) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(',');
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void unlink(Node node) {
        Node node2 = node.prev;
        Node node3 = node.next;
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
