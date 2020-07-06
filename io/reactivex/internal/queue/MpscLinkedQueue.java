package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MpscLinkedQueue<T> implements f<T> {
    private final AtomicReference<LinkedQueueNode<T>> nMp = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> nMq = new AtomicReference<>();

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
        LinkedQueueNode<T> dPJ = dPJ();
        LinkedQueueNode<T> lvNext2 = dPJ.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            b(lvNext2);
            return andNullValue;
        } else if (dPJ != dPH()) {
            do {
                lvNext = dPJ.lvNext();
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

    LinkedQueueNode<T> dPH() {
        return this.nMp.get();
    }

    LinkedQueueNode<T> a(LinkedQueueNode<T> linkedQueueNode) {
        return this.nMp.getAndSet(linkedQueueNode);
    }

    LinkedQueueNode<T> dPI() {
        return this.nMq.get();
    }

    LinkedQueueNode<T> dPJ() {
        return this.nMq.get();
    }

    void b(LinkedQueueNode<T> linkedQueueNode) {
        this.nMq.lazySet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dPI() == dPH();
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
