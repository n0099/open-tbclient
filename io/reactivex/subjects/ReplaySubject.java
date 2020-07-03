package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.u;
import io.reactivex.v;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ReplaySubject<T> extends b<T> {
    static final ReplayDisposable[] nOM = new ReplayDisposable[0];
    static final ReplayDisposable[] nON = new ReplayDisposable[0];
    private static final Object[] nOj = new Object[0];
    boolean done;
    final a<T> nOL;
    final AtomicReference<ReplayDisposable<T>[]> observers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a<T> {
        void add(T t);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        void replay(ReplayDisposable<T> replayDisposable);
    }

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(uVar, this);
        uVar.onSubscribe(replayDisposable);
        if (!replayDisposable.cancelled) {
            if (a(replayDisposable) && replayDisposable.cancelled) {
                b(replayDisposable);
            } else {
                this.nOL.replay(replayDisposable);
            }
        }
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.done) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        io.reactivex.internal.functions.a.k(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done) {
            a<T> aVar = this.nOL;
            aVar.add(t);
            for (ReplayDisposable<T> replayDisposable : this.observers.get()) {
                aVar.replay(replayDisposable);
            }
        }
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.k(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done) {
            io.reactivex.e.a.onError(th);
            return;
        }
        this.done = true;
        Object error = NotificationLite.error(th);
        a<T> aVar = this.nOL;
        aVar.addFinal(error);
        ReplayDisposable<T>[] bG = bG(error);
        for (ReplayDisposable<T> replayDisposable : bG) {
            aVar.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.u
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            Object complete = NotificationLite.complete();
            a<T> aVar = this.nOL;
            aVar.addFinal(complete);
            ReplayDisposable<T>[] bG = bG(complete);
            for (ReplayDisposable<T> replayDisposable : bG) {
                aVar.replay(replayDisposable);
            }
        }
    }

    boolean a(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        do {
            replayDisposableArr = this.observers.get();
            if (replayDisposableArr == nON) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[length + 1];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
        return true;
    }

    void b(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        do {
            replayDisposableArr = this.observers.get();
            if (replayDisposableArr != nON && replayDisposableArr != nOM) {
                int length = replayDisposableArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (replayDisposableArr[i2] == replayDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        replayDisposableArr2 = nOM;
                    } else {
                        replayDisposableArr2 = new ReplayDisposable[length - 1];
                        System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, i);
                        System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
    }

    ReplayDisposable<T>[] bG(Object obj) {
        return this.nOL.compareAndSet(null, obj) ? this.observers.getAndSet(nON) : nON;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 466549804534799122L;
        final u<? super T> actual;
        volatile boolean cancelled;
        Object index;
        final ReplaySubject<T> state;

        ReplayDisposable(u<? super T> uVar, ReplaySubject<T> replaySubject) {
            this.actual = uVar;
            this.state = replaySubject;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.b(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* loaded from: classes7.dex */
    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        UnboundedReplayBuffer(int i) {
            this.buffer = new ArrayList(io.reactivex.internal.functions.a.bK(i, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void addFinal(Object obj) {
            this.buffer.add(obj);
            this.size++;
            this.done = true;
        }

        public T getValue() {
            int i = this.size;
            if (i != 0) {
                List<Object> list = this.buffer;
                T t = (T) list.get(i - 1);
                if (NotificationLite.isComplete(t) || NotificationLite.isError(t)) {
                    if (i == 1) {
                        return null;
                    }
                    return (T) list.get(i - 2);
                }
                return t;
            }
            return null;
        }

        public T[] getValues(T[] tArr) {
            int i = this.size;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                    return tArr;
                }
                return tArr;
            }
            List<Object> list = this.buffer;
            Object obj = list.get(i - 1);
            if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                    return tArr;
                }
                return tArr;
            }
            int i2 = i;
            Object[] objArr = tArr.length < i2 ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2) : tArr;
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = list.get(i3);
            }
            if (objArr.length > i2) {
                objArr[i2] = null;
            }
            return (T[]) objArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void replay(ReplayDisposable<T> replayDisposable) {
            int i;
            int i2;
            if (replayDisposable.getAndIncrement() == 0) {
                List<Object> list = this.buffer;
                u<? super T> uVar = replayDisposable.actual;
                Integer num = (Integer) replayDisposable.index;
                if (num != null) {
                    i = num.intValue();
                    i2 = 1;
                } else {
                    replayDisposable.index = 0;
                    i = 0;
                    i2 = 1;
                }
                while (!replayDisposable.cancelled) {
                    int i3 = this.size;
                    while (i3 != i) {
                        if (replayDisposable.cancelled) {
                            replayDisposable.index = null;
                            return;
                        }
                        Object obj = list.get(i);
                        if (this.done && i + 1 == i3 && i + 1 == (i3 = this.size)) {
                            if (NotificationLite.isComplete(obj)) {
                                uVar.onComplete();
                            } else {
                                uVar.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        uVar.onNext(obj);
                        i++;
                    }
                    if (i == this.size) {
                        replayDisposable.index = Integer.valueOf(i);
                        i2 = replayDisposable.addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
            }
        }

        public int size() {
            int i = this.size;
            if (i != 0) {
                Object obj = this.buffer.get(i - 1);
                if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                    return i - 1;
                }
                return i;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T t) {
            this.value = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    /* loaded from: classes7.dex */
    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        SizeBoundReplayBuffer(int i) {
            this.maxSize = io.reactivex.internal.functions.a.bK(i, "maxSize");
            Node<Object> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        void trim() {
            if (this.size > this.maxSize) {
                this.size--;
                this.head = this.head.get();
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T t) {
            Node<Object> node = new Node<>(t);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void addFinal(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.lazySet(node);
            this.done = true;
        }

        public T getValue() {
            Node<T> node = this.head;
            Node<Object> node2 = null;
            while (true) {
                Node<T> node3 = node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t = (T) node.value;
            if (t == null) {
                return null;
            }
            return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) node2.value : t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object[]] */
        public T[] getValues(T[] tArr) {
            Node<Object> node = this.head;
            int size = size();
            if (size == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
            } else {
                if (tArr.length < size) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
                }
                Node<T> node2 = node;
                for (int i = 0; i != size; i++) {
                    node2 = node2.get();
                    tArr[i] = node2.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void replay(ReplayDisposable<T> replayDisposable) {
            Node<Object> node;
            int i;
            if (replayDisposable.getAndIncrement() == 0) {
                u<? super T> uVar = replayDisposable.actual;
                Node<T> node2 = (Node) replayDisposable.index;
                if (node2 == null) {
                    node = this.head;
                    i = 1;
                } else {
                    node = node2;
                    i = 1;
                }
                while (!replayDisposable.cancelled) {
                    Node<T> node3 = node.get();
                    if (node3 != null) {
                        Object obj = (T) node3.value;
                        if (this.done && node3.get() == null) {
                            if (NotificationLite.isComplete(obj)) {
                                uVar.onComplete();
                            } else {
                                uVar.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        uVar.onNext(obj);
                        node = node3;
                    } else if (node.get() == null) {
                        replayDisposable.index = node;
                        int addAndGet = replayDisposable.addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    } else {
                        continue;
                    }
                }
                replayDisposable.index = null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
            return r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int size() {
            int i = 0;
            Node<T> node = this.head;
            while (true) {
                Node<Object> node2 = node;
                if (i == Integer.MAX_VALUE) {
                    break;
                }
                node = node2.get();
                if (node == null) {
                    Object obj = node2.value;
                    if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                        return i - 1;
                    }
                } else {
                    i++;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final v scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, v vVar) {
            this.maxSize = io.reactivex.internal.functions.a.bK(i, "maxSize");
            this.maxAge = io.reactivex.internal.functions.a.y(j, "maxAge");
            this.unit = (TimeUnit) io.reactivex.internal.functions.a.k(timeUnit, "unit is null");
            this.scheduler = (v) io.reactivex.internal.functions.a.k(vVar, "scheduler is null");
            TimedNode<Object> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        void trim() {
            if (this.size > this.maxSize) {
                this.size--;
                this.head = this.head.get();
            }
            long a = this.scheduler.a(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<Object> timedNode2 = timedNode;
                timedNode = timedNode2.get();
                if (timedNode == null) {
                    this.head = timedNode2;
                    return;
                } else if (timedNode.time > a) {
                    this.head = timedNode2;
                    return;
                }
            }
        }

        void trimFinal() {
            long a = this.scheduler.a(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<Object> timedNode2 = timedNode;
                timedNode = timedNode2.get();
                if (timedNode.get() == null) {
                    this.head = timedNode2;
                    return;
                } else if (timedNode.time > a) {
                    this.head = timedNode2;
                    return;
                }
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T t) {
            TimedNode<Object> timedNode = new TimedNode<>(t, this.scheduler.a(this.unit));
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void addFinal(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.lazySet(timedNode);
            trimFinal();
            this.done = true;
        }

        public T getValue() {
            T t;
            TimedNode<T> timedNode = this.head;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<T> timedNode3 = timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            if (timedNode.time >= this.scheduler.a(this.unit) - this.maxAge && (t = (T) timedNode.value) != null) {
                return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) timedNode2.value : t;
            }
            return null;
        }

        TimedNode<Object> getHead() {
            TimedNode<Object> timedNode = this.head;
            long a = this.scheduler.a(this.unit) - this.maxAge;
            TimedNode<T> timedNode2 = timedNode;
            for (TimedNode<T> timedNode3 = timedNode.get(); timedNode3 != null && timedNode3.time <= a; timedNode3 = timedNode3.get()) {
                timedNode2 = timedNode3;
            }
            return timedNode2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r6v6 */
        public T[] getValues(T[] tArr) {
            TimedNode<Object> head = getHead();
            int size = size(head);
            if (size == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
            } else {
                if (tArr.length < size) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
                }
                TimedNode<T> timedNode = head;
                for (int i = 0; i != size; i++) {
                    timedNode = timedNode.get();
                    tArr[i] = timedNode.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            }
            return tArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
            if (r1.get() == null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
            r0 = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
            r8.index = r1;
            r0 = r8.addAndGet(-r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
            if (r0 == 0) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
            r2 = r0;
            r0 = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
            return;
         */
        @Override // io.reactivex.subjects.ReplaySubject.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void replay(ReplayDisposable<T> replayDisposable) {
            int i;
            if (replayDisposable.getAndIncrement() == 0) {
                u<? super T> uVar = replayDisposable.actual;
                TimedNode<Object> timedNode = (TimedNode) replayDisposable.index;
                if (timedNode == null) {
                    timedNode = getHead();
                    i = 1;
                } else {
                    i = 1;
                }
                while (!replayDisposable.cancelled) {
                    while (true) {
                        TimedNode<Object> timedNode2 = timedNode;
                        if (replayDisposable.cancelled) {
                            replayDisposable.index = null;
                            return;
                        }
                        timedNode = timedNode2.get();
                        if (timedNode == null) {
                            break;
                        }
                        Object obj = (Object) timedNode.value;
                        if (this.done && timedNode.get() == null) {
                            if (NotificationLite.isComplete(obj)) {
                                uVar.onComplete();
                            } else {
                                uVar.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        uVar.onNext(obj);
                    }
                }
                replayDisposable.index = null;
            }
        }

        public int size() {
            return size(getHead());
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
            return r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int size(TimedNode<Object> timedNode) {
            int i = 0;
            while (true) {
                if (i == Integer.MAX_VALUE) {
                    break;
                }
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    Object obj = timedNode.value;
                    if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                        return i - 1;
                    }
                } else {
                    i++;
                    timedNode = timedNode2;
                }
            }
        }
    }
}
