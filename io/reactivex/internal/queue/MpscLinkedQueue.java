package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MpscLinkedQueue<T> implements f<T> {
    private final AtomicReference<LinkedQueueNode<T>> nUZ = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> nVa = new AtomicReference<>();

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        b(linkedQueueNode);
        a(linkedQueueNode);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
        a(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        LinkedQueueNode<T> lvNext;
        LinkedQueueNode<T> dTg = dTg();
        LinkedQueueNode<T> lvNext2 = dTg.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            b(lvNext2);
            return andNullValue;
        } else if (dTg != dTe()) {
            do {
                lvNext = dTg.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            b(lvNext);
            return andNullValue2;
        } else {
            return null;
        }
    }

    @Override // io.reactivex.internal.a.g
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    LinkedQueueNode<T> dTe() {
        return this.nUZ.get();
    }

    LinkedQueueNode<T> a(LinkedQueueNode<T> linkedQueueNode) {
        return this.nUZ.getAndSet(linkedQueueNode);
    }

    LinkedQueueNode<T> dTf() {
        return this.nVa.get();
    }

    LinkedQueueNode<T> dTg() {
        return this.nVa.get();
    }

    void b(LinkedQueueNode<T> linkedQueueNode) {
        this.nVa.lazySet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dTf() == dTe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
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
