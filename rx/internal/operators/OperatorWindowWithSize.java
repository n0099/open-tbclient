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

    public OperatorWindowWithSize(int i, int i2) {
        this.size = i;
        this.skip = i2;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        if (this.skip == this.size) {
            a aVar = new a(jVar, this.size);
            jVar.add(aVar.iJy);
            jVar.setProducer(aVar.cdn());
            return aVar;
        } else if (this.skip > this.size) {
            WindowSkip windowSkip = new WindowSkip(jVar, this.size, this.skip);
            jVar.add(windowSkip.iJy);
            jVar.setProducer(windowSkip.cdn());
            return windowSkip;
        } else {
            WindowOverlap windowOverlap = new WindowOverlap(jVar, this.size, this.skip);
            jVar.add(windowOverlap.iJy);
            jVar.setProducer(windowOverlap.cdn());
            return windowOverlap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements rx.functions.a {
        final rx.j<? super rx.d<T>> actual;
        rx.subjects.c<T, T> iJz;
        int index;
        final int size;
        final AtomicInteger wip = new AtomicInteger(1);
        final rx.k iJy = rx.subscriptions.e.j(this);

        public a(rx.j<? super rx.d<T>> jVar, int i) {
            this.actual = jVar;
            this.size = i;
            add(this.iJy);
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            int i = this.index;
            UnicastSubject unicastSubject = this.iJz;
            if (i == 0) {
                this.wip.getAndIncrement();
                unicastSubject = UnicastSubject.a(this.size, this);
                this.iJz = unicastSubject;
                this.actual.onNext(unicastSubject);
            }
            int i2 = i + 1;
            unicastSubject.onNext(t);
            if (i2 == this.size) {
                this.index = 0;
                this.iJz = null;
                unicastSubject.onCompleted();
                return;
            }
            this.index = i2;
        }

        @Override // rx.e
        public void onError(Throwable th) {
            rx.subjects.c<T, T> cVar = this.iJz;
            if (cVar != null) {
                this.iJz = null;
                cVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            rx.subjects.c<T, T> cVar = this.iJz;
            if (cVar != null) {
                this.iJz = null;
                cVar.onCompleted();
            }
            this.actual.onCompleted();
        }

        rx.f cdn() {
            return new rx.f() { // from class: rx.internal.operators.OperatorWindowWithSize.a.1
                @Override // rx.f
                public void request(long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("n >= 0 required but it was " + j);
                    }
                    if (j != 0) {
                        a.this.request(rx.internal.operators.a.q(a.this.size, j));
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
        rx.subjects.c<T, T> iJz;
        int index;
        final int size;
        final int skip;
        final AtomicInteger wip = new AtomicInteger(1);
        final rx.k iJy = rx.subscriptions.e.j(this);

        public WindowSkip(rx.j<? super rx.d<T>> jVar, int i, int i2) {
            this.actual = jVar;
            this.size = i;
            this.skip = i2;
            add(this.iJy);
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            int i = this.index;
            UnicastSubject unicastSubject = this.iJz;
            if (i == 0) {
                this.wip.getAndIncrement();
                unicastSubject = UnicastSubject.a(this.size, this);
                this.iJz = unicastSubject;
                this.actual.onNext(unicastSubject);
            }
            int i2 = i + 1;
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
            }
            if (i2 == this.size) {
                this.index = i2;
                this.iJz = null;
                unicastSubject.onCompleted();
            } else if (i2 == this.skip) {
                this.index = 0;
            } else {
                this.index = i2;
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            rx.subjects.c<T, T> cVar = this.iJz;
            if (cVar != null) {
                this.iJz = null;
                cVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            rx.subjects.c<T, T> cVar = this.iJz;
            if (cVar != null) {
                this.iJz = null;
                cVar.onCompleted();
            }
            this.actual.onCompleted();
        }

        rx.f cdn() {
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
                        windowSkip.request(rx.internal.operators.a.q(j, windowSkip.skip));
                    } else {
                        windowSkip.request(rx.internal.operators.a.r(rx.internal.operators.a.q(j, windowSkip.size), rx.internal.operators.a.q(windowSkip.skip - windowSkip.size, j - 1)));
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
        int iJD;
        int index;
        final Queue<rx.subjects.c<T, T>> queue;
        final int size;
        final int skip;
        final AtomicInteger wip = new AtomicInteger(1);
        final ArrayDeque<rx.subjects.c<T, T>> iJB = new ArrayDeque<>();
        final AtomicInteger iJC = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();
        final rx.k iJy = rx.subscriptions.e.j(this);

        public WindowOverlap(rx.j<? super rx.d<T>> jVar, int i, int i2) {
            this.actual = jVar;
            this.size = i;
            this.skip = i2;
            add(this.iJy);
            request(0L);
            this.queue = new rx.internal.util.atomic.d(((i2 - 1) + i) / i2);
        }

        @Override // rx.e
        public void onNext(T t) {
            int i = this.index;
            ArrayDeque<rx.subjects.c<T, T>> arrayDeque = this.iJB;
            if (i == 0 && !this.actual.isUnsubscribed()) {
                this.wip.getAndIncrement();
                UnicastSubject a = UnicastSubject.a(16, this);
                arrayDeque.offer(a);
                this.queue.offer(a);
                drain();
            }
            Iterator<rx.subjects.c<T, T>> it = this.iJB.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            int i2 = this.iJD + 1;
            if (i2 == this.size) {
                this.iJD = i2 - this.skip;
                rx.subjects.c<T, T> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.onCompleted();
                }
            } else {
                this.iJD = i2;
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
            Iterator<rx.subjects.c<T, T>> it = this.iJB.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.iJB.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.e
        public void onCompleted() {
            Iterator<rx.subjects.c<T, T>> it = this.iJB.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.iJB.clear();
            this.done = true;
            drain();
        }

        rx.f cdn() {
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
            AtomicInteger atomicInteger = this.iJC;
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
                        windowOverlap.request(rx.internal.operators.a.r(rx.internal.operators.a.q(windowOverlap.skip, j - 1), windowOverlap.size));
                    } else {
                        WindowOverlap.this.request(rx.internal.operators.a.q(windowOverlap.skip, j));
                    }
                    rx.internal.operators.a.a(windowOverlap.requested, j);
                    windowOverlap.drain();
                }
            }
        }
    }
}
