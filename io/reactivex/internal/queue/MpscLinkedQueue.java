package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class MpscLinkedQueue<T> implements e<T> {
    private final AtomicReference<LinkedQueueNode<T>> pHv = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> pHw = new AtomicReference<>();

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        b(linkedQueueNode);
        a(linkedQueueNode);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
        a(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        LinkedQueueNode<T> lvNext;
        LinkedQueueNode<T> eDh = eDh();
        LinkedQueueNode<T> lvNext2 = eDh.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            b(lvNext2);
            return andNullValue;
        } else if (eDh != eDf()) {
            do {
                lvNext = eDh.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            b(lvNext);
            return andNullValue2;
        } else {
            return null;
        }
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    LinkedQueueNode<T> eDf() {
        return this.pHv.get();
    }

    LinkedQueueNode<T> a(LinkedQueueNode<T> linkedQueueNode) {
        return this.pHv.getAndSet(linkedQueueNode);
    }

    LinkedQueueNode<T> eDg() {
        return this.pHw.get();
    }

    LinkedQueueNode<T> eDh() {
        return this.pHw.get();
    }

    void b(LinkedQueueNode<T> linkedQueueNode) {
        this.pHw.lazySet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return eDg() == eDf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E e) {
            spValue(e);
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public void spValue(E e) {
            this.value = e;
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }
    }
}
