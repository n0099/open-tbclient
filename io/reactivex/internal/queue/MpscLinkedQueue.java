package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class MpscLinkedQueue<T> implements f<T> {
    private final AtomicReference<LinkedQueueNode<T>> pPc = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> pPd = new AtomicReference<>();

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
        LinkedQueueNode<T> eAO = eAO();
        LinkedQueueNode<T> lvNext2 = eAO.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            b(lvNext2);
            return andNullValue;
        } else if (eAO != eAM()) {
            do {
                lvNext = eAO.lvNext();
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

    LinkedQueueNode<T> eAM() {
        return this.pPc.get();
    }

    LinkedQueueNode<T> a(LinkedQueueNode<T> linkedQueueNode) {
        return this.pPc.getAndSet(linkedQueueNode);
    }

    LinkedQueueNode<T> eAN() {
        return this.pPd.get();
    }

    LinkedQueueNode<T> eAO() {
        return this.pPd.get();
    }

    void b(LinkedQueueNode<T> linkedQueueNode) {
        this.pPd.lazySet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return eAN() == eAM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
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
