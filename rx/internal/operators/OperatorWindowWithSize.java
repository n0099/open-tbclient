package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize<T> implements d.b<rx.d<T>, T> {
    final int size;
    final int skip;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        if (this.skip == this.size) {
            a aVar = new a(jVar, this.size);
            jVar.add(aVar.kqC);
            jVar.setProducer(aVar.cLA());
            return aVar;
        } else if (this.skip > this.size) {
            WindowSkip windowSkip = new WindowSkip(jVar, this.size, this.skip);
            jVar.add(windowSkip.kqC);
            jVar.setProducer(windowSkip.cLA());
            return windowSkip;
        } else {
            WindowOverlap windowOverlap = new WindowOverlap(jVar, this.size, this.skip);
            jVar.add(windowOverlap.kqC);
            jVar.setProducer(windowOverlap.cLA());
            return windowOverlap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements rx.functions.a {
        final rx.j<? super rx.d<T>> actual;
        int index;
        rx.subjects.c<T, T> kqD;
        final int size;
        final AtomicInteger wip = new AtomicInteger(1);
        final rx.k kqC = rx.subscriptions.e.l(this);

        public a(rx.j<? super rx.d<T>> jVar, int i) {
            this.actual = jVar;
            this.size = i;
            add(this.kqC);
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            int i = this.index;
            UnicastSubject unicastSubject = this.kqD;
            if (i == 0) {
                this.wip.getAndIncrement();
                unicastSubject = UnicastSubject.a(this.size, this);
                this.kqD = unicastSubject;
                this.actual.onNext(unicastSubject);
            }
            int i2 = i + 1;
            unicastSubject.onNext(t);
            if (i2 == this.size) {
                this.index = 0;
                this.kqD = null;
                unicastSubject.onCompleted();
                return;
            }
            this.index = i2;
        }

        @Override // rx.e
        public void onError(Throwable th) {
            rx.subjects.c<T, T> cVar = this.kqD;
            if (cVar != null) {
                this.kqD = null;
                cVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            rx.subjects.c<T, T> cVar = this.kqD;
            if (cVar != null) {
                this.kqD = null;
                cVar.onCompleted();
            }
            this.actual.onCompleted();
        }

        rx.f cLA() {
            return new rx.f() { // from class: rx.internal.operators.OperatorWindowWithSize.a.1
                @Override // rx.f
                public void request(long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("n >= 0 required but it was " + j);
                    }
                    if (j != 0) {
                        a.this.request(rx.internal.operators.a.w(a.this.size, j));
                    }
                }
            };
        }

        @Override // rx.functions.a
        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class WindowSkip<T> extends rx.j<T> implements rx.functions.a {
        final rx.j<? super rx.d<T>> actual;
        int index;
        rx.subjects.c<T, T> kqD;
        final int size;
        final int skip;
        final AtomicInteger wip = new AtomicInteger(1);
        final rx.k kqC = rx.subscriptions.e.l(this);

        public WindowSkip(rx.j<? super rx.d<T>> jVar, int i, int i2) {
            this.actual = jVar;
            this.size = i;
            this.skip = i2;
            add(this.kqC);
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            int i = this.index;
            UnicastSubject unicastSubject = this.kqD;
            if (i == 0) {
                this.wip.getAndIncrement();
                unicastSubject = UnicastSubject.a(this.size, this);
                this.kqD = unicastSubject;
                this.actual.onNext(unicastSubject);
            }
            int i2 = i + 1;
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
            }
            if (i2 == this.size) {
                this.index = i2;
                this.kqD = null;
                unicastSubject.onCompleted();
            } else if (i2 == this.skip) {
                this.index = 0;
            } else {
                this.index = i2;
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            rx.subjects.c<T, T> cVar = this.kqD;
            if (cVar != null) {
                this.kqD = null;
                cVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            rx.subjects.c<T, T> cVar = this.kqD;
            if (cVar != null) {
                this.kqD = null;
                cVar.onCompleted();
            }
            this.actual.onCompleted();
        }

        rx.f cLA() {
            return new WindowSkipProducer();
        }

        @Override // rx.functions.a
        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class WindowSkipProducer extends AtomicBoolean implements rx.f {
            private static final long serialVersionUID = 4625807964358024108L;

            WindowSkipProducer() {
            }

            @Override // rx.f
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                }
                if (j != 0) {
                    WindowSkip windowSkip = WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        windowSkip.request(rx.internal.operators.a.w(j, windowSkip.skip));
                    } else {
                        windowSkip.request(rx.internal.operators.a.x(rx.internal.operators.a.w(j, windowSkip.size), rx.internal.operators.a.w(windowSkip.skip - windowSkip.size, j - 1)));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class WindowOverlap<T> extends rx.j<T> implements rx.functions.a {
        final rx.j<? super rx.d<T>> actual;
        volatile boolean done;
        Throwable error;
        int index;
        int kqH;
        final Queue<rx.subjects.c<T, T>> queue;
        final int size;
        final int skip;
        final AtomicInteger wip = new AtomicInteger(1);
        final ArrayDeque<rx.subjects.c<T, T>> kqF = new ArrayDeque<>();
        final AtomicInteger kqG = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();
        final rx.k kqC = rx.subscriptions.e.l(this);

        public WindowOverlap(rx.j<? super rx.d<T>> jVar, int i, int i2) {
            this.actual = jVar;
            this.size = i;
            this.skip = i2;
            add(this.kqC);
            request(0L);
            this.queue = new rx.internal.util.atomic.d(((i2 - 1) + i) / i2);
        }

        @Override // rx.e
        public void onNext(T t) {
            int i = this.index;
            ArrayDeque<rx.subjects.c<T, T>> arrayDeque = this.kqF;
            if (i == 0 && !this.actual.isUnsubscribed()) {
                this.wip.getAndIncrement();
                UnicastSubject a = UnicastSubject.a(16, this);
                arrayDeque.offer(a);
                this.queue.offer(a);
                drain();
            }
            Iterator<rx.subjects.c<T, T>> it = this.kqF.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            int i2 = this.kqH + 1;
            if (i2 == this.size) {
                this.kqH = i2 - this.skip;
                rx.subjects.c<T, T> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.onCompleted();
                }
            } else {
                this.kqH = i2;
            }
            int i3 = i + 1;
            if (i3 == this.skip) {
                this.index = 0;
            } else {
                this.index = i3;
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            Iterator<rx.subjects.c<T, T>> it = this.kqF.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.kqF.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.e
        public void onCompleted() {
            Iterator<rx.subjects.c<T, T>> it = this.kqF.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.kqF.clear();
            this.done = true;
            drain();
        }

        rx.f cLA() {
            return new WindowOverlapProducer();
        }

        @Override // rx.functions.a
        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: rx.internal.operators.OperatorWindowWithSize$WindowOverlap<T> */
        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            long j;
            AtomicInteger atomicInteger = this.kqG;
            if (atomicInteger.getAndIncrement() == 0) {
                rx.j<? super rx.d<T>> jVar = this.actual;
                Queue<rx.subjects.c<T, T>> queue = this.queue;
                int i = 1;
                while (true) {
                    int i2 = i;
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        j = j3;
                        if (j == j2) {
                            break;
                        }
                        boolean z = this.done;
                        rx.subjects.c<T, T> poll = queue.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, jVar, queue)) {
                            if (z2) {
                                break;
                            }
                            jVar.onNext(poll);
                            j3 = 1 + j;
                        } else {
                            return;
                        }
                    }
                    if (j != j2 || !a(this.done, queue.isEmpty(), jVar, queue)) {
                        if (j != 0 && j2 != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j);
                        }
                        i = atomicInteger.addAndGet(-i2);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        boolean a(boolean z, boolean z2, rx.j<? super rx.subjects.c<T, T>> jVar, Queue<rx.subjects.c<T, T>> queue) {
            if (jVar.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    queue.clear();
                    jVar.onError(th);
                    return true;
                } else if (z2) {
                    jVar.onCompleted();
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class WindowOverlapProducer extends AtomicBoolean implements rx.f {
            private static final long serialVersionUID = 4625807964358024108L;

            WindowOverlapProducer() {
            }

            @Override // rx.f
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                }
                if (j != 0) {
                    WindowOverlap windowOverlap = WindowOverlap.this;
                    if (!get() && compareAndSet(false, true)) {
                        windowOverlap.request(rx.internal.operators.a.x(rx.internal.operators.a.w(windowOverlap.skip, j - 1), windowOverlap.size));
                    } else {
                        WindowOverlap.this.request(rx.internal.operators.a.w(windowOverlap.skip, j));
                    }
                    rx.internal.operators.a.a(windowOverlap.requested, j);
                    windowOverlap.drain();
                }
            }
        }
    }
}
