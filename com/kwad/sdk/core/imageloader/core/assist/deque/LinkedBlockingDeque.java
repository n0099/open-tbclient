package com.kwad.sdk.core.imageloader.core.assist.deque;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -387911632671998426L;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacity;
    public transient int count;
    public transient Node<E> first;
    public transient Node<E> last;
    public final ReentrantLock lock;
    public final Condition notEmpty;
    public final Condition notFull;

    /* renamed from: com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public abstract class AbstractItr implements Iterator<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Node<E> lastRet;
        public Node<E> next;
        public E nextItem;
        public final /* synthetic */ LinkedBlockingDeque this$0;

        public AbstractItr(LinkedBlockingDeque linkedBlockingDeque) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedBlockingDeque};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linkedBlockingDeque;
            ReentrantLock reentrantLock = linkedBlockingDeque.lock;
            reentrantLock.lock();
            try {
                Node<E> firstNode = firstNode();
                this.next = firstNode;
                this.nextItem = firstNode == null ? null : firstNode.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        private Node<E> succ(Node<E> node) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(65537, this, node)) != null) {
                return (Node) invokeL.objValue;
            }
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

        public void advance() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ReentrantLock reentrantLock = this.this$0.lock;
                reentrantLock.lock();
                try {
                    Node<E> succ = succ(this.next);
                    this.next = succ;
                    this.nextItem = succ == null ? null : succ.item;
                } finally {
                    reentrantLock.unlock();
                }
            }
        }

        public abstract Node<E> firstNode();

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.next != null : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Node<E> node = this.next;
                if (node != null) {
                    this.lastRet = node;
                    E e2 = this.nextItem;
                    advance();
                    return e2;
                }
                throw new NoSuchElementException();
            }
            return (E) invokeV.objValue;
        }

        public abstract Node<E> nextNode(Node<E> node);

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                Node<E> node = this.lastRet;
                if (node == null) {
                    throw new IllegalStateException();
                }
                this.lastRet = null;
                ReentrantLock reentrantLock = this.this$0.lock;
                reentrantLock.lock();
                try {
                    if (node.item != null) {
                        this.this$0.unlink(node);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class DescendingItr extends LinkedBlockingDeque<E>.AbstractItr {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedBlockingDeque this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DescendingItr(LinkedBlockingDeque linkedBlockingDeque) {
            super(linkedBlockingDeque);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedBlockingDeque};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LinkedBlockingDeque) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linkedBlockingDeque;
        }

        public /* synthetic */ DescendingItr(LinkedBlockingDeque linkedBlockingDeque, AnonymousClass1 anonymousClass1) {
            this(linkedBlockingDeque);
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        public Node<E> firstNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.last : (Node) invokeV.objValue;
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        public Node<E> nextNode(Node<E> node) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, node)) == null) ? node.prev : (Node) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class Itr extends LinkedBlockingDeque<E>.AbstractItr {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedBlockingDeque this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Itr(LinkedBlockingDeque linkedBlockingDeque) {
            super(linkedBlockingDeque);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkedBlockingDeque};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LinkedBlockingDeque) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = linkedBlockingDeque;
        }

        public /* synthetic */ Itr(LinkedBlockingDeque linkedBlockingDeque, AnonymousClass1 anonymousClass1) {
            this(linkedBlockingDeque);
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        public Node<E> firstNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.first : (Node) invokeV.objValue;
        }

        @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        public Node<E> nextNode(Node<E> node) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, node)) == null) ? node.next : (Node) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Node<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public E item;
        public Node<E> next;
        public Node<E> prev;

        public Node(E e2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.item = e2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public LinkedBlockingDeque(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e2 : collection) {
                if (e2 == null) {
                    throw new NullPointerException();
                }
                if (!linkLast(new Node<>(e2))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean linkFirst(Node<E> node) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, node)) == null) {
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
        return invokeL.booleanValue;
    }

    private boolean linkLast(Node<E> node) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, node)) == null) {
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
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65541, this, objectInputStream) != null) {
            return;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            Node<E> node = this.first;
            if (node == null) {
                return null;
            }
            Node<E> node2 = node.next;
            E e2 = node.item;
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
            return e2;
        }
        return (E) invokeV.objValue;
    }

    private E unlinkLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Node<E> node = this.last;
            if (node == null) {
                return null;
            }
            Node<E> node2 = node.prev;
            E e2 = node.item;
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
            return e2;
        }
        return (E) invokeV.objValue;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, objectOutputStream) == null) {
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
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean add(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            addLast(e2);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public void addFirst(E e2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2) == null) && !offerFirst(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public void addLast(E e2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2) == null) && !offerLast(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Iterator<E> descendingIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new DescendingItr(this, null) : (Iterator) invokeV.objValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) ? drainTo(collection, Integer.MAX_VALUE) : invokeL.intValue;
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: E, ? super E */
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, collection, i2)) == null) {
            if (collection != null) {
                if (collection != this) {
                    ReentrantLock reentrantLock = this.lock;
                    reentrantLock.lock();
                    try {
                        int min = Math.min(i2, this.count);
                        for (int i3 = 0; i3 < min; i3++) {
                            collection.add((E) this.first.item);
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
        return invokeLI.intValue;
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E element() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getFirst() : (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E getFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            E peekFirst = peekFirst();
            if (peekFirst != null) {
                return peekFirst;
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E getLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            E peekLast = peekLast();
            if (peekLast != null) {
                return peekLast;
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new Itr(this, null) : (Iterator) invokeV.objValue;
    }

    public boolean offer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, e2)) == null) ? offerLast(e2) : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{e2, Long.valueOf(j2), timeUnit})) == null) ? offerLast(e2, j2, timeUnit) : invokeCommon.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean offerFirst(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, e2)) == null) {
            if (e2 != null) {
                Node<E> node = new Node<>(e2);
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
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public boolean offerFirst(E e2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{e2, Long.valueOf(j2), timeUnit})) == null) {
            if (e2 != null) {
                Node<E> node = new Node<>(e2);
                long nanos = timeUnit.toNanos(j2);
                ReentrantLock reentrantLock = this.lock;
                reentrantLock.lockInterruptibly();
                while (true) {
                    try {
                        if (linkFirst(node)) {
                            z = true;
                            break;
                        } else if (nanos <= 0) {
                            z = false;
                            break;
                        } else {
                            nanos = this.notFull.awaitNanos(nanos);
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                return z;
            }
            throw null;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean offerLast(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, e2)) == null) {
            if (e2 != null) {
                Node<E> node = new Node<>(e2);
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
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public boolean offerLast(E e2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{e2, Long.valueOf(j2), timeUnit})) == null) {
            if (e2 != null) {
                Node<E> node = new Node<>(e2);
                long nanos = timeUnit.toNanos(j2);
                ReentrantLock reentrantLock = this.lock;
                reentrantLock.lockInterruptibly();
                while (true) {
                    try {
                        if (linkLast(node)) {
                            z = true;
                            break;
                        } else if (nanos <= 0) {
                            z = false;
                            break;
                        } else {
                            nanos = this.notFull.awaitNanos(nanos);
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                return z;
            }
            throw null;
        }
        return invokeCommon.booleanValue;
    }

    @Override // java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? peekFirst() : (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E peekFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return this.first == null ? null : this.first.item;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E peekLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return this.last == null ? null : this.last.item;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? pollFirst() : (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048598, this, j2, timeUnit)) == null) ? pollFirst(j2, timeUnit) : (E) invokeJL.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E pollFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return unlinkFirst();
            } finally {
                reentrantLock.unlock();
            }
        }
        return (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public E pollFirst(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJL = interceptable.invokeJL(1048600, this, j2, timeUnit)) != null) {
            return (E) invokeJL.objValue;
        }
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E pollLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return unlinkLast();
            } finally {
                reentrantLock.unlock();
            }
        }
        return (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public E pollLast(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJL = interceptable.invokeJL(1048602, this, j2, timeUnit)) != null) {
            return (E) invokeJL.objValue;
        }
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? removeFirst() : (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public void push(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, e2) == null) {
            addFirst(e2);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, e2) == null) {
            putLast(e2);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public void putFirst(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, e2) == null) {
            if (e2 == null) {
                throw null;
            }
            Node<E> node = new Node<>(e2);
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
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public void putLast(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, e2) == null) {
            if (e2 == null) {
                throw null;
            }
            Node<E> node = new Node<>(e2);
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
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return this.capacity - this.count;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeV.intValue;
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E remove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? removeFirst() : (E) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, obj)) == null) ? removeFirstOccurrence(obj) : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E removeFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            E pollFirst = pollFirst();
            if (pollFirst != null) {
                return pollFirst;
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean removeFirstOccurrence(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, obj)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public E removeLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            E pollLast = pollLast();
            if (pollLast != null) {
                return pollLast;
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public boolean removeLastOccurrence(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, obj)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return this.count;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? takeFirst() : (E) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque
    public E takeFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048617, this)) != null) {
            return (E) invokeV.objValue;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048618, this)) != null) {
            return (E) invokeV.objValue;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                Object[] objArr = new Object[this.count];
                int i2 = 0;
                Node<E> node = this.first;
                while (node != null) {
                    int i3 = i2 + 1;
                    objArr[i2] = node.item;
                    node = node.next;
                    i2 = i3;
                }
                return objArr;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (Object[]) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v10, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, tArr)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (tArr.length < this.count) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count));
                }
                int i2 = 0;
                Node<E> node = this.first;
                while (node != null) {
                    tArr[i2] = node.item;
                    node = node.next;
                    i2++;
                }
                if (tArr.length > i2) {
                    tArr[i2] = null;
                }
                return tArr;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048621, this)) != null) {
            return (String) invokeV.objValue;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
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
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void unlink(Node<E> node) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, node) == null) {
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
}
