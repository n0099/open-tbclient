package io.reactivex.internal.operators.observable;

import io.reactivex.c.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableReplay<T> extends io.reactivex.d.a<T> implements io.reactivex.disposables.b {
    static final a nxv = new c();
    final AtomicReference<ReplayObserver<T>> current;
    final t<T> nxo;
    final a<T> nxu;
    final t<T> source;

    /* loaded from: classes5.dex */
    interface a<T> {
        b<T> dIf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface b<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerDisposable<T> innerDisposable);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.current.lazySet(null);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        ReplayObserver<T> replayObserver = this.current.get();
        return replayObserver == null || replayObserver.isDisposed();
    }

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.nxo.subscribe(uVar);
    }

    @Override // io.reactivex.d.a
    public void c(g<? super io.reactivex.disposables.b> gVar) {
        ReplayObserver<T> replayObserver;
        while (true) {
            replayObserver = this.current.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.nxu.dIf());
            if (this.current.compareAndSet(replayObserver, replayObserver2)) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z = !replayObserver.shouldConnect.get() && replayObserver.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(replayObserver);
            if (z) {
                this.source.subscribe(replayObserver);
            }
        } catch (Throwable th) {
            if (z) {
                replayObserver.shouldConnect.compareAndSet(true, false);
            }
            io.reactivex.exceptions.a.I(th);
            throw ExceptionHelper.K(th);
        }
    }

    /* loaded from: classes5.dex */
    static final class ReplayObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T> {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;
        final b<T> buffer;
        boolean done;
        final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplayObserver(b<T> bVar) {
            this.buffer = bVar;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerDisposableArr[i2].equals(innerDisposable)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = EMPTY;
                        } else {
                            innerDisposableArr2 = new InnerDisposable[length - 1];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i);
                            System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                replay();
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(th);
                replayFinal();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                replayFinal();
            }
        }

        void replay() {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                this.buffer.replay(innerDisposable);
            }
        }

        void replayFinal() {
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerDisposable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InnerDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final u<? super T> child;
        Object index;
        final ReplayObserver<T> parent;

        InnerDisposable(ReplayObserver<T> replayObserver, u<? super T> uVar) {
            this.parent = replayObserver;
            this.child = uVar;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.remove(this);
            }
        }

        <U> U index() {
            return (U) this.index;
        }
    }

    /* loaded from: classes5.dex */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements b<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                u<? super T> uVar = innerDisposable.child;
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (!innerDisposable.isDisposed()) {
                        int i3 = this.size;
                        Integer num = (Integer) innerDisposable.index();
                        int intValue = num != null ? num.intValue() : 0;
                        while (intValue < i3) {
                            if (!NotificationLite.accept(get(intValue), uVar) && !innerDisposable.isDisposed()) {
                                intValue++;
                            } else {
                                return;
                            }
                        }
                        innerDisposable.index = Integer.valueOf(intValue);
                        i = innerDisposable.addAndGet(-i2);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        Node(Object obj) {
            this.value = obj;
        }
    }

    /* loaded from: classes5.dex */
    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements b<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        Node tail;

        abstract void truncate();

        BoundedReplayBuffer() {
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        final void removeFirst() {
            this.size--;
            setFirst(get().get());
        }

        final void trimHead() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        final void removeSome(int i) {
            Node node = get();
            while (i > 0) {
                node = node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        final void setFirst(Node node) {
            set(node);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public final void next(T t) {
            addLast(new Node(enterTransform(NotificationLite.next(t))));
            truncate();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public final void error(Throwable th) {
            addLast(new Node(enterTransform(NotificationLite.error(th))));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        public final void complete() {
            addLast(new Node(enterTransform(NotificationLite.complete())));
            truncateFinal();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
            r5.index = r2;
            r0 = r5.addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
            if (r0 == 0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                int i = 1;
                while (true) {
                    int i2 = i;
                    Node node = (Node) innerDisposable.index();
                    if (node == null) {
                        node = getHead();
                        innerDisposable.index = node;
                    }
                    while (true) {
                        Node node2 = node;
                        if (!innerDisposable.isDisposed()) {
                            node = node2.get();
                            if (node == null) {
                                break;
                            } else if (NotificationLite.accept(leaveTransform(node.value), innerDisposable.child)) {
                                innerDisposable.index = null;
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        void truncateFinal() {
            trimHead();
        }

        final void collect(Collection<? super T> collection) {
            Node head = getHead();
            while (true) {
                head = head.get();
                if (head != null) {
                    Object leaveTransform = leaveTransform(head.value);
                    if (!NotificationLite.isComplete(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                        collection.add((Object) NotificationLite.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        boolean hasError() {
            return this.tail.value != null && NotificationLite.isError(leaveTransform(this.tail.value));
        }

        boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.isComplete(leaveTransform(this.tail.value));
        }

        Node getHead() {
            return get();
        }
    }

    /* loaded from: classes5.dex */
    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final v scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, v vVar) {
            this.scheduler = vVar;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object enterTransform(Object obj) {
            return new io.reactivex.f.b(obj, this.scheduler.a(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object leaveTransform(Object obj) {
            return ((io.reactivex.f.b) obj).dIF();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void truncate() {
            long a = this.scheduler.a(this.unit) - this.maxAge;
            Node node = (Node) get();
            Node node2 = node;
            int i = 0;
            Node node3 = node.get();
            while (node3 != null) {
                if (this.size > this.limit) {
                    i++;
                    this.size--;
                    node2 = node3;
                    node3 = node3.get();
                } else if (((io.reactivex.f.b) node3.value).XG() > a) {
                    break;
                } else {
                    i++;
                    this.size--;
                    node2 = node3;
                    node3 = node3.get();
                }
            }
            if (i != 0) {
                setFirst(node2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void truncateFinal() {
            long a = this.scheduler.a(this.unit) - this.maxAge;
            Node node = (Node) get();
            Node node2 = node;
            int i = 0;
            for (Node node3 = node.get(); node3 != null && this.size > 1 && ((io.reactivex.f.b) node3.value).XG() <= a; node3 = node3.get()) {
                i++;
                this.size--;
                node2 = node3;
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Node getHead() {
            long a = this.scheduler.a(this.unit) - this.maxAge;
            Node node = (Node) get();
            Node node2 = node;
            for (Node node3 = node.get(); node3 != null; node3 = node3.get()) {
                io.reactivex.f.b bVar = (io.reactivex.f.b) node3.value;
                if (NotificationLite.isComplete(bVar.dIF()) || NotificationLite.isError(bVar.dIF()) || bVar.XG() > a) {
                    break;
                }
                node2 = node3;
            }
            return node2;
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements a<Object> {
        c() {
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public b<Object> dIf() {
            return new UnboundedReplayBuffer(16);
        }
    }
}
