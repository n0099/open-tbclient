package io.reactivex.internal.operators.observable;

import f.b.x.e.c.h;
import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class ObservableReplay$BoundedReplayBuffer<T> extends AtomicReference<ObservableReplay$Node> implements h<T> {
    public static final long serialVersionUID = 2346567790059478686L;
    public int size;
    public ObservableReplay$Node tail;

    public ObservableReplay$BoundedReplayBuffer() {
        ObservableReplay$Node observableReplay$Node = new ObservableReplay$Node(null);
        this.tail = observableReplay$Node;
        set(observableReplay$Node);
    }

    public final void addLast(ObservableReplay$Node observableReplay$Node) {
        this.tail.set(observableReplay$Node);
        this.tail = observableReplay$Node;
        this.size++;
    }

    public final void collect(Collection<? super T> collection) {
        ObservableReplay$Node head = getHead();
        while (true) {
            head = head.get();
            if (head == null) {
                return;
            }
            Object leaveTransform = leaveTransform(head.value);
            if (NotificationLite.isComplete(leaveTransform) || NotificationLite.isError(leaveTransform)) {
                return;
            }
            collection.add((Object) NotificationLite.getValue(leaveTransform));
        }
    }

    @Override // f.b.x.e.c.h
    public final void complete() {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.complete())));
        truncateFinal();
    }

    public Object enterTransform(Object obj) {
        return obj;
    }

    @Override // f.b.x.e.c.h
    public final void error(Throwable th) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.error(th))));
        truncateFinal();
    }

    public ObservableReplay$Node getHead() {
        return get();
    }

    public boolean hasCompleted() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isComplete(leaveTransform(obj));
    }

    public boolean hasError() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isError(leaveTransform(obj));
    }

    public Object leaveTransform(Object obj) {
        return obj;
    }

    @Override // f.b.x.e.c.h
    public final void next(T t) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.next(t))));
        truncate();
    }

    public final void removeFirst() {
        this.size--;
        setFirst(get().get());
    }

    public final void removeSome(int i) {
        ObservableReplay$Node observableReplay$Node = get();
        while (i > 0) {
            observableReplay$Node = observableReplay$Node.get();
            i--;
            this.size--;
        }
        setFirst(observableReplay$Node);
    }

    @Override // f.b.x.e.c.h
    public final void replay(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        if (observableReplay$InnerDisposable.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        do {
            ObservableReplay$Node observableReplay$Node = (ObservableReplay$Node) observableReplay$InnerDisposable.index();
            if (observableReplay$Node == null) {
                observableReplay$Node = getHead();
                observableReplay$InnerDisposable.index = observableReplay$Node;
            }
            while (!observableReplay$InnerDisposable.isDisposed()) {
                ObservableReplay$Node observableReplay$Node2 = observableReplay$Node.get();
                if (observableReplay$Node2 != null) {
                    if (NotificationLite.accept(leaveTransform(observableReplay$Node2.value), observableReplay$InnerDisposable.child)) {
                        observableReplay$InnerDisposable.index = null;
                        return;
                    }
                    observableReplay$Node = observableReplay$Node2;
                } else {
                    observableReplay$InnerDisposable.index = observableReplay$Node;
                    i = observableReplay$InnerDisposable.addAndGet(-i);
                }
            }
            return;
        } while (i != 0);
    }

    public final void setFirst(ObservableReplay$Node observableReplay$Node) {
        set(observableReplay$Node);
    }

    public abstract void truncate();

    public void truncateFinal() {
    }
}
