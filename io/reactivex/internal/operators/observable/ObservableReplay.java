package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, Disposable {
    public static final BufferSupplier DEFAULT_UNBOUNDED_FACTORY = new UnBoundedFactory();
    public final BufferSupplier<T> bufferFactory;
    public final AtomicReference<ReplayObserver<T>> current;
    public final ObservableSource<T> onSubscribe;
    public final ObservableSource<T> source;

    /* loaded from: classes7.dex */
    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        public static final long serialVersionUID = 2346567790059478686L;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(Collection<? super T> collection) {
            Node head = getHead();
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void complete() {
            addLast(new Node(enterTransform(NotificationLite.complete())));
            truncateFinal();
        }

        public Object enterTransform(Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void error(Throwable th) {
            addLast(new Node(enterTransform(NotificationLite.error(th))));
            truncateFinal();
        }

        public Node getHead() {
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void next(T t) {
            addLast(new Node(enterTransform(NotificationLite.next(t))));
            truncate();
        }

        public final void removeFirst() {
            this.size--;
            setFirst(get().get());
        }

        public final void removeSome(int i2) {
            Node node = get();
            while (i2 > 0) {
                node = node.get();
                i2--;
                this.size--;
            }
            setFirst(node);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int i2 = 1;
            do {
                Node node = (Node) innerDisposable.index();
                if (node == null) {
                    node = getHead();
                    innerDisposable.index = node;
                }
                while (!innerDisposable.isDisposed()) {
                    Node node2 = node.get();
                    if (node2 != null) {
                        if (NotificationLite.accept(leaveTransform(node2.value), innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        }
                        node = node2;
                    } else {
                        innerDisposable.index = node;
                        i2 = innerDisposable.addAndGet(-i2);
                    }
                }
                return;
            } while (i2 != 0);
        }

        public final void setFirst(Node node) {
            set(node);
        }

        public final void trimHead() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public abstract void truncate();

        public void truncateFinal() {
            trimHead();
        }
    }

    /* loaded from: classes7.dex */
    public interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    /* loaded from: classes7.dex */
    public static final class DisposeConsumer<R> implements Consumer<Disposable> {
        public final ObserverResourceWrapper<R> srw;

        public DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.srw = observerResourceWrapper;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            this.srw.setResource(disposable);
        }
    }

    /* loaded from: classes7.dex */
    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = 2728361546769921047L;
        public volatile boolean cancelled;
        public final Observer<? super T> child;
        public Object index;
        public final ReplayObserver<T> parent;

        public InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.parent = replayObserver;
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.parent.remove(this);
        }

        public <U> U index() {
            return (U) this.index;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* loaded from: classes7.dex */
    public static final class MulticastReplay<R, U> extends Observable<R> {
        public final Callable<? extends ConnectableObservable<U>> connectableFactory;
        public final Function<? super Observable<U>, ? extends ObservableSource<R>> selector;

        public MulticastReplay(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.connectableFactory = callable;
            this.selector = function;
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super R> observer) {
            try {
                ConnectableObservable connectableObservable = (ConnectableObservable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned a null ConnectableObservable");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(connectableObservable), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.connect(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class Node extends AtomicReference<Node> {
        public static final long serialVersionUID = 245354315435971818L;
        public final Object value;

        public Node(Object obj) {
            this.value = obj;
        }
    }

    /* loaded from: classes7.dex */
    public static final class Replay<T> extends ConnectableObservable<T> {
        public final ConnectableObservable<T> co;
        public final Observable<T> observable;

        public Replay(ConnectableObservable<T> connectableObservable, Observable<T> observable) {
            this.co = connectableObservable;
            this.observable = observable;
        }

        @Override // io.reactivex.observables.ConnectableObservable
        public void connect(Consumer<? super Disposable> consumer) {
            this.co.connect(consumer);
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super T> observer) {
            this.observable.subscribe(observer);
        }
    }

    /* loaded from: classes7.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerDisposable<T> innerDisposable);
    }

    /* loaded from: classes7.dex */
    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {
        public final int bufferSize;

        public ReplayBufferSupplier(int i2) {
            this.bufferSize = i2;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        public static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        public static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        public static final long serialVersionUID = -533785617179540163L;
        public final ReplayBuffer<T> buffer;
        public boolean done;
        public final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplayObserver(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        public boolean add(InnerDisposable<T> innerDisposable) {
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            replayFinal();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(th);
                replayFinal();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            replay();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                replay();
            }
        }

        public void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (innerDisposableArr[i3].equals(innerDisposable)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = EMPTY;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i2);
                    System.arraycopy(innerDisposableArr, i2 + 1, innerDisposableArr3, i2, (length - i2) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        public void replay() {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                this.buffer.replay(innerDisposable);
            }
        }

        public void replayFinal() {
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerDisposable);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class ReplaySource<T> implements ObservableSource<T> {
        public final BufferSupplier<T> bufferFactory;
        public final AtomicReference<ReplayObserver<T>> curr;

        public ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            this.curr = atomicReference;
            this.bufferFactory = bufferSupplier;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            ReplayObserver<T> replayObserver;
            while (true) {
                replayObserver = this.curr.get();
                if (replayObserver != null) {
                    break;
                }
                ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.bufferFactory.call());
                if (this.curr.compareAndSet(null, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(replayObserver, observer);
            observer.onSubscribe(innerDisposable);
            replayObserver.add(innerDisposable);
            if (innerDisposable.isDisposed()) {
                replayObserver.remove(innerDisposable);
            } else {
                replayObserver.buffer.replay(innerDisposable);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {
        public final int bufferSize;
        public final long maxAge;
        public final Scheduler scheduler;
        public final TimeUnit unit;

        public ScheduledReplaySupplier(int i2, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.bufferSize = i2;
            this.maxAge = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
        }
    }

    /* loaded from: classes7.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAge;
        public final Scheduler scheduler;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i2, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.scheduler = scheduler;
            this.limit = i2;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            return new Timed(obj, this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Node getHead() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    Timed timed = (Timed) node2.value;
                    if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                        break;
                    }
                    node3 = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            return ((Timed) obj).value();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i2 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i3 = this.size;
                    if (i3 > this.limit) {
                        i2++;
                        this.size = i3 - 1;
                        node3 = node2.get();
                    } else if (((Timed) node2.value).time() > now) {
                        break;
                    } else {
                        i2++;
                        this.size--;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                setFirst(node);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void truncateFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node = get();
            Node node2 = node.get();
            int i2 = 0;
            while (true) {
                Node node3 = node2;
                Node node4 = node;
                node = node3;
                if (node == null || this.size <= 1 || ((Timed) node.value).time() > now) {
                    break;
                }
                i2++;
                this.size--;
                node2 = node.get();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public SizeBoundReplayBuffer(int i2) {
            this.limit = i2;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class UnBoundedFactory implements BufferSupplier<Object> {
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* loaded from: classes7.dex */
    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        public static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i2) {
            super(i2);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = innerDisposable.child;
            int i2 = 1;
            while (!innerDisposable.isDisposed()) {
                int i3 = this.size;
                Integer num = (Integer) innerDisposable.index();
                int intValue = num != null ? num.intValue() : 0;
                while (intValue < i3) {
                    if (NotificationLite.accept(get(intValue), observer) || innerDisposable.isDisposed()) {
                        return;
                    }
                    intValue++;
                }
                innerDisposable.index = Integer.valueOf(intValue);
                i2 = innerDisposable.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }

    public ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
        this.bufferFactory = bufferSupplier;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return createFrom(observableSource);
        }
        return create(observableSource, new ReplayBufferSupplier(i2));
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> observableSource) {
        return create(observableSource, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <U, R> Observable<R> multicastSelector(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.onAssembly(new MulticastReplay(callable, function));
    }

    public static <T> ConnectableObservable<T> observeOn(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly((ConnectableObservable) new Replay(connectableObservable, connectableObservable.observeOn(scheduler)));
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        ReplayObserver<T> replayObserver;
        while (true) {
            replayObserver = this.current.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.bufferFactory.call());
            if (this.current.compareAndSet(replayObserver, replayObserver2)) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z = !replayObserver.shouldConnect.get() && replayObserver.shouldConnect.compareAndSet(false, true);
        try {
            consumer.accept(replayObserver);
            if (z) {
                this.source.subscribe(replayObserver);
            }
        } catch (Throwable th) {
            if (z) {
                replayObserver.shouldConnect.compareAndSet(true, false);
            }
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.current.lazySet(null);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        ReplayObserver<T> replayObserver = this.current.get();
        return replayObserver == null || replayObserver.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return create(observableSource, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i2) {
        return create(observableSource, new ScheduledReplaySupplier(i2, j, timeUnit, scheduler));
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }
}
