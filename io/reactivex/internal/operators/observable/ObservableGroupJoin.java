package io.reactivex.internal.operators.observable;

import io.reactivex.b.c;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.q;
import io.reactivex.subjects.UnicastSubject;
import io.reactivex.t;
import io.reactivex.u;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends io.reactivex.internal.operators.observable.a<TLeft, R> {
    final h<? super TLeft, ? extends t<TLeftEnd>> leftEnd;
    final t<? extends TRight> other;
    final c<? super TLeft, ? super q<TRight>, ? extends R> resultSelector;
    final h<? super TRight, ? extends t<TRightEnd>> rightEnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a {
        void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver);

        void innerCloseError(Throwable th);

        void innerComplete(LeftRightObserver leftRightObserver);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(uVar, this.leftEnd, this.rightEnd, this.resultSelector);
        uVar.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.disposables.a(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.disposables.a(leftRightObserver2);
        this.source.subscribe(leftRightObserver);
        this.other.subscribe(leftRightObserver2);
    }

    /* loaded from: classes5.dex */
    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements io.reactivex.disposables.b, a {
        private static final long serialVersionUID = -6071216598687999801L;
        final u<? super R> actual;
        volatile boolean cancelled;
        final h<? super TLeft, ? extends t<TLeftEnd>> leftEnd;
        int leftIndex;
        final c<? super TLeft, ? super q<TRight>, ? extends R> resultSelector;
        final h<? super TRight, ? extends t<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final io.reactivex.disposables.a disposables = new io.reactivex.disposables.a();
        final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>(q.eKm());
        final Map<Integer, UnicastSubject<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        GroupJoinDisposable(u<? super R> uVar, h<? super TLeft, ? extends t<TLeftEnd>> hVar, h<? super TRight, ? extends t<TRightEnd>> hVar2, c<? super TLeft, ? super q<TRight>, ? extends R> cVar) {
            this.actual = uVar;
            this.leftEnd = hVar;
            this.rightEnd = hVar2;
            this.resultSelector = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void errorAll(u<?> uVar) {
            Throwable terminate = ExceptionHelper.terminate(this.error);
            for (UnicastSubject<TRight> unicastSubject : this.lefts.values()) {
                unicastSubject.onError(terminate);
            }
            this.lefts.clear();
            this.rights.clear();
            uVar.onError(terminate);
        }

        void fail(Throwable th, u<?> uVar, io.reactivex.internal.queue.a<?> aVar) {
            io.reactivex.exceptions.a.N(th);
            ExceptionHelper.addThrowable(this.error, th);
            aVar.clear();
            cancelAll();
            errorAll(uVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v29, resolved type: java.util.Map<java.lang.Integer, TRight> */
        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.internal.queue.a<?> aVar = this.queue;
                u<? super R> uVar = this.actual;
                int i = 1;
                while (!this.cancelled) {
                    if (this.error.get() != null) {
                        aVar.clear();
                        cancelAll();
                        errorAll(uVar);
                        return;
                    }
                    boolean z = this.active.get() == 0;
                    Integer num = (Integer) aVar.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        for (UnicastSubject<TRight> unicastSubject : this.lefts.values()) {
                            unicastSubject.onComplete();
                        }
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        uVar.onComplete();
                        return;
                    } else if (!z2) {
                        Object poll = aVar.poll();
                        if (num == LEFT_VALUE) {
                            UnicastSubject<TRight> eKX = UnicastSubject.eKX();
                            int i2 = this.leftIndex;
                            this.leftIndex = i2 + 1;
                            this.lefts.put(Integer.valueOf(i2), eKX);
                            try {
                                t tVar = (t) io.reactivex.internal.functions.a.m(this.leftEnd.apply(poll), "The leftEnd returned a null ObservableSource");
                                LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i2);
                                this.disposables.a(leftRightEndObserver);
                                tVar.subscribe(leftRightEndObserver);
                                if (this.error.get() != null) {
                                    aVar.clear();
                                    cancelAll();
                                    errorAll(uVar);
                                    return;
                                }
                                try {
                                    uVar.onNext((Object) io.reactivex.internal.functions.a.m(this.resultSelector.apply(poll, eKX), "The resultSelector returned a null value"));
                                    for (TRight tright : this.rights.values()) {
                                        eKX.onNext(tright);
                                    }
                                } catch (Throwable th) {
                                    fail(th, uVar, aVar);
                                    return;
                                }
                            } catch (Throwable th2) {
                                fail(th2, uVar, aVar);
                                return;
                            }
                        } else if (num == RIGHT_VALUE) {
                            int i3 = this.rightIndex;
                            this.rightIndex = i3 + 1;
                            this.rights.put(Integer.valueOf(i3), poll);
                            try {
                                t tVar2 = (t) io.reactivex.internal.functions.a.m(this.rightEnd.apply(poll), "The rightEnd returned a null ObservableSource");
                                LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i3);
                                this.disposables.a(leftRightEndObserver2);
                                tVar2.subscribe(leftRightEndObserver2);
                                if (this.error.get() != null) {
                                    aVar.clear();
                                    cancelAll();
                                    errorAll(uVar);
                                    return;
                                }
                                for (UnicastSubject<TRight> unicastSubject2 : this.lefts.values()) {
                                    unicastSubject2.onNext(poll);
                                }
                            } catch (Throwable th3) {
                                fail(th3, uVar, aVar);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) poll;
                            UnicastSubject<TRight> remove = this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                            this.disposables.b(leftRightEndObserver3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else if (num == RIGHT_CLOSE) {
                            LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) poll;
                            this.rights.remove(Integer.valueOf(leftRightEndObserver4.index));
                            this.disposables.b(leftRightEndObserver4);
                        }
                    } else {
                        int addAndGet = addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    }
                }
                aVar.clear();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.error, th)) {
                this.active.decrementAndGet();
                drain();
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerComplete(LeftRightObserver leftRightObserver) {
            this.disposables.c(leftRightObserver);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndObserver);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerCloseError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.error, th)) {
                drain();
            } else {
                io.reactivex.d.a.onError(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class LeftRightObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<Object> {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final a parent;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightObserver(a aVar, boolean z) {
            this.parent = aVar;
            this.isLeft = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.parent.innerComplete(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class LeftRightEndObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<Object> {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final a parent;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightEndObserver(a aVar, boolean z, int i) {
            this.parent = aVar;
            this.isLeft = z;
            this.index = i;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }
    }
}
