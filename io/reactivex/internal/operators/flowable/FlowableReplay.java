package io.reactivex.internal.operators.flowable;

import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.j;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes6.dex */
public final class FlowableReplay<T> extends io.reactivex.a.a<T> implements io.reactivex.disposables.b {
    static final Callable qpH = new a();
    final AtomicReference<ReplaySubscriber<T>> current;
    final g<T> qoY;
    final Callable<? extends b<T>> qpG;
    final org.a.b<T> qpu;

    /* loaded from: classes6.dex */
    interface b<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerSubscription<T> innerSubscription);
    }

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.qpu.subscribe(cVar);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.current.lazySet(null);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        ReplaySubscriber<T> replaySubscriber = this.current.get();
        return replaySubscriber == null || replaySubscriber.isDisposed();
    }

    @Override // io.reactivex.a.a
    public void a(io.reactivex.b.g<? super io.reactivex.disposables.b> gVar) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.qpG.call());
                if (this.current.compareAndSet(replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                io.reactivex.exceptions.a.N(th);
                RuntimeException P = ExceptionHelper.P(th);
            }
        }
        boolean z = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(replaySubscriber);
            if (z) {
                this.qoY.a((j) replaySubscriber);
            }
        } catch (Throwable th) {
            if (z) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            throw ExceptionHelper.P(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ReplaySubscriber<T> extends AtomicReference<d> implements io.reactivex.disposables.b, j<T> {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final b<T> buffer;
        boolean done;
        long maxChildRequested;
        long maxUpstreamRequested;
        final AtomicInteger management = new AtomicInteger();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplaySubscriber(b<T> bVar) {
            this.buffer = bVar;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.subscribers.set(TERMINATED);
            SubscriptionHelper.cancel(this);
        }

        boolean add(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            if (innerSubscription == null) {
                throw new NullPointerException();
            }
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        void remove(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerSubscriptionArr[i2].equals(innerSubscription)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerSubscriptionArr2 = EMPTY;
                        } else {
                            innerSubscriptionArr2 = new InnerSubscription[length - 1];
                            System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, i);
                            System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                manageRequests();
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(th);
                for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(innerSubscription);
                }
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        void manageRequests() {
            if (this.management.getAndIncrement() == 0) {
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (!isDisposed()) {
                        InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                        long j = this.maxChildRequested;
                        long j2 = j;
                        for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                            j2 = Math.max(j2, innerSubscription.totalRequested.get());
                        }
                        long j3 = this.maxUpstreamRequested;
                        d dVar = get();
                        long j4 = j2 - j;
                        if (j4 != 0) {
                            this.maxChildRequested = j2;
                            if (dVar != null) {
                                if (j3 != 0) {
                                    this.maxUpstreamRequested = 0L;
                                    dVar.request(j3 + j4);
                                } else {
                                    dVar.request(j4);
                                }
                            } else {
                                long j5 = j3 + j4;
                                if (j5 < 0) {
                                    j5 = Long.MAX_VALUE;
                                }
                                this.maxUpstreamRequested = j5;
                            }
                        } else if (j3 != 0 && dVar != null) {
                            this.maxUpstreamRequested = 0L;
                            dVar.request(j3);
                        }
                        i = this.management.addAndGet(-i2);
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
    /* loaded from: classes6.dex */
    public static final class InnerSubscription<T> extends AtomicLong implements io.reactivex.disposables.b, d {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final org.a.c<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        InnerSubscription(ReplaySubscriber<T> replaySubscriber, org.a.c<? super T> cVar) {
            this.parent = replaySubscriber;
            this.child = cVar;
        }

        @Override // org.a.d
        public void request(long j) {
            long j2;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 >= 0 && j == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, io.reactivex.internal.util.b.X(j2, j)));
                io.reactivex.internal.util.b.a(this.totalRequested, j);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }

        public long produced(long j) {
            return io.reactivex.internal.util.b.d(this, j);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.a.d
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
            }
        }

        <U> U index() {
            return (U) this.index;
        }
    }

    /* loaded from: classes6.dex */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements b<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public void replay(InnerSubscription<T> innerSubscription) {
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                org.a.c<? super T> cVar = innerSubscription.child;
                while (!innerSubscription.isDisposed()) {
                    int i = this.size;
                    Integer num = (Integer) innerSubscription.index();
                    int intValue = num != null ? num.intValue() : 0;
                    long j = innerSubscription.get();
                    long j2 = 0;
                    long j3 = j;
                    int i2 = intValue;
                    while (j3 != 0 && i2 < i) {
                        Object obj = get(i2);
                        try {
                            if (!NotificationLite.accept(obj, cVar) && !innerSubscription.isDisposed()) {
                                i2++;
                                j3--;
                                j2 = 1 + j2;
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.N(th);
                            innerSubscription.dispose();
                            if (!NotificationLite.isError(obj) && !NotificationLite.isComplete(obj)) {
                                cVar.onError(th);
                                return;
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerSubscription.index = Integer.valueOf(i2);
                        if (j != Long.MAX_VALUE) {
                            innerSubscription.produced(j2);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    /* loaded from: classes6.dex */
    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements b<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        final void removeFirst() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(node);
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

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.complete());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.b
        public final void replay(InnerSubscription<T> innerSubscription) {
            Node node;
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                while (!innerSubscription.isDisposed()) {
                    long j = innerSubscription.get();
                    boolean z = j == Long.MAX_VALUE;
                    long j2 = 0;
                    Node node2 = (Node) innerSubscription.index();
                    if (node2 == null) {
                        node2 = getHead();
                        innerSubscription.index = node2;
                        io.reactivex.internal.util.b.a(innerSubscription.totalRequested, node2.index);
                    }
                    while (true) {
                        node = node2;
                        if (j == 0 || (node2 = node.get()) == null) {
                            break;
                        }
                        Object leaveTransform = leaveTransform(node2.value);
                        try {
                            if (NotificationLite.accept(leaveTransform, innerSubscription.child)) {
                                innerSubscription.index = null;
                                return;
                            }
                            j2++;
                            j--;
                            if (innerSubscription.isDisposed()) {
                                return;
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.N(th);
                            innerSubscription.index = null;
                            innerSubscription.dispose();
                            if (!NotificationLite.isError(leaveTransform) && !NotificationLite.isComplete(leaveTransform)) {
                                innerSubscription.child.onError(th);
                                return;
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerSubscription.index = node;
                        if (!z) {
                            innerSubscription.produced(j2);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
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

        void truncate() {
        }

        void truncateFinal() {
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

    /* loaded from: classes6.dex */
    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object enterTransform(Object obj) {
            return new io.reactivex.e.b(obj, this.scheduler.b(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object leaveTransform(Object obj) {
            return ((io.reactivex.e.b) obj).eKC();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            long b = this.scheduler.b(this.unit) - this.maxAge;
            Node node = (Node) get();
            int i = 0;
            Node node2 = node.get();
            Node node3 = node;
            while (node2 != null) {
                if (this.size > this.limit) {
                    this.size--;
                    i++;
                    node3 = node2;
                    node2 = node2.get();
                } else if (((io.reactivex.e.b) node2.value).aEi() > b) {
                    break;
                } else {
                    this.size--;
                    i++;
                    node3 = node2;
                    node2 = node2.get();
                }
            }
            if (i != 0) {
                setFirst(node3);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
            setFirst(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void truncateFinal() {
            long b = this.scheduler.b(this.unit) - this.maxAge;
            Node node = (Node) get();
            int i = 0;
            Node node2 = node;
            for (Node node3 = node.get(); node3 != null && this.size > 1 && ((io.reactivex.e.b) node3.value).aEi() <= b; node3 = node3.get()) {
                this.size--;
                i++;
                node2 = node3;
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Node getHead() {
            long b = this.scheduler.b(this.unit) - this.maxAge;
            Node node = (Node) get();
            Node node2 = node;
            for (Node node3 = node.get(); node3 != null; node3 = node3.get()) {
                io.reactivex.e.b bVar = (io.reactivex.e.b) node3.value;
                if (NotificationLite.isComplete(bVar.eKC()) || NotificationLite.isError(bVar.eKC()) || bVar.aEi() > b) {
                    break;
                }
                node2 = node3;
            }
            return node2;
        }
    }

    /* loaded from: classes6.dex */
    static final class a implements Callable<Object> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }
}
