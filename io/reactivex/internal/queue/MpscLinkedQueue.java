package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class MpscLinkedQueue<T> implements e<T> {
    private final AtomicReference<LinkedQueueNode<T>> qrl = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> qrm = new AtomicReference<>();

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
        LinkedQueueNode<T> eKj = eKj();
        LinkedQueueNode<T> lvNext2 = eKj.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            b(lvNext2);
            return andNullValue;
        } else if (eKj != eKh()) {
            do {
                lvNext = eKj.lvNext();
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

    LinkedQueueNode<T> eKh() {
        return this.qrl.get();
    }

    LinkedQueueNode<T> a(LinkedQueueNode<T> linkedQueueNode) {
        return this.qrl.getAndSet(linkedQueueNode);
    }

    LinkedQueueNode<T> eKi() {
        return this.qrm.get();
    }

    LinkedQueueNode<T> eKj() {
        return this.qrm.get();
    }

    void b(LinkedQueueNode<T> linkedQueueNode) {
        this.qrm.lazySet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return eKi() == eKh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
