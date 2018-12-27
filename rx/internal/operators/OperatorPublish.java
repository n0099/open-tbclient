package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorPublish<T> extends rx.observables.c<T> {
    final rx.d<? extends T> iEP;
    final AtomicReference<a<T>> iJP;

    public static <T> rx.observables.c<T> k(rx.d<? extends T> dVar) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorPublish(new d.a<T>() { // from class: rx.internal.operators.OperatorPublish.1
            @Override // rx.functions.b
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((rx.j) ((rx.j) obj));
            }

            public void call(rx.j<? super T> jVar) {
                while (true) {
                    a aVar = (a) atomicReference.get();
                    if (aVar == null || aVar.isUnsubscribed()) {
                        a aVar2 = new a(atomicReference);
                        aVar2.init();
                        if (atomicReference.compareAndSet(aVar, aVar2)) {
                            aVar = aVar2;
                        } else {
                            continue;
                        }
                    }
                    InnerProducer<T> innerProducer = new InnerProducer<>(aVar, jVar);
                    if (aVar.a(innerProducer)) {
                        jVar.add(innerProducer);
                        jVar.setProducer(innerProducer);
                        return;
                    }
                }
            }
        }, dVar, atomicReference);
    }

    public static <T, R> rx.d<R> c(rx.d<? extends T> dVar, rx.functions.f<? super rx.d<T>, ? extends rx.d<R>> fVar) {
        return a(dVar, fVar, false);
    }

    public static <T, R> rx.d<R> a(final rx.d<? extends T> dVar, final rx.functions.f<? super rx.d<T>, ? extends rx.d<R>> fVar, final boolean z) {
        return create(new d.a<R>() { // from class: rx.internal.operators.OperatorPublish.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.d */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.functions.b
            public void call(final rx.j<? super R> jVar) {
                final OnSubscribePublishMulticast onSubscribePublishMulticast = new OnSubscribePublishMulticast(rx.internal.util.h.SIZE, z);
                rx.k kVar = new rx.j<R>() { // from class: rx.internal.operators.OperatorPublish.2.1
                    @Override // rx.e
                    public void onNext(R r) {
                        jVar.onNext(r);
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        onSubscribePublishMulticast.unsubscribe();
                        jVar.onError(th);
                    }

                    @Override // rx.e
                    public void onCompleted() {
                        onSubscribePublishMulticast.unsubscribe();
                        jVar.onCompleted();
                    }

                    @Override // rx.j
                    public void setProducer(rx.f fVar2) {
                        jVar.setProducer(fVar2);
                    }
                };
                jVar.add(onSubscribePublishMulticast);
                jVar.add(kVar);
                ((rx.d) fVar.call(rx.d.create(onSubscribePublishMulticast))).unsafeSubscribe(kVar);
                dVar.unsafeSubscribe(onSubscribePublishMulticast.subscriber());
            }
        });
    }

    private OperatorPublish(d.a<T> aVar, rx.d<? extends T> dVar, AtomicReference<a<T>> atomicReference) {
        super(aVar);
        this.iEP = dVar;
        this.iJP = atomicReference;
    }

    @Override // rx.observables.c
    public void c(rx.functions.b<? super rx.k> bVar) {
        a<T> aVar;
        while (true) {
            aVar = this.iJP.get();
            if (aVar != null && !aVar.isUnsubscribed()) {
                break;
            }
            a<T> aVar2 = new a<>(this.iJP);
            aVar2.init();
            if (this.iJP.compareAndSet(aVar, aVar2)) {
                aVar = aVar2;
                break;
            }
        }
        boolean z = !aVar.iJZ.get() && aVar.iJZ.compareAndSet(false, true);
        bVar.call(aVar);
        if (z) {
            this.iEP.unsafeSubscribe(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements rx.k {
        static final InnerProducer[] iJW = new InnerProducer[0];
        static final InnerProducer[] iJX = new InnerProducer[0];
        boolean emitting;
        final AtomicReference<a<T>> iJP;
        volatile Object iJV;
        final AtomicReference<InnerProducer[]> iJY;
        final AtomicBoolean iJZ;
        boolean missed;
        final Queue<Object> queue;

        public a(AtomicReference<a<T>> atomicReference) {
            this.queue = rx.internal.util.a.ae.cfw() ? new rx.internal.util.a.q<>(rx.internal.util.h.SIZE) : new rx.internal.util.atomic.c<>(rx.internal.util.h.SIZE);
            this.iJY = new AtomicReference<>(iJW);
            this.iJP = atomicReference;
            this.iJZ = new AtomicBoolean();
        }

        void init() {
            add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.OperatorPublish.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.iJY.getAndSet(a.iJX);
                    a.this.iJP.compareAndSet(a.this, null);
                }
            }));
        }

        @Override // rx.j
        public void onStart() {
            request(rx.internal.util.h.SIZE);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.aY(t))) {
                onError(new MissingBackpressureException());
            } else {
                cdU();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.iJV == null) {
                this.iJV = NotificationLite.M(th);
                cdU();
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (this.iJV == null) {
                this.iJV = NotificationLite.cdX();
                cdU();
            }
        }

        boolean a(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            if (innerProducer == null) {
                throw new NullPointerException();
            }
            do {
                innerProducerArr = this.iJY.get();
                if (innerProducerArr == iJX) {
                    return false;
                }
                int length = innerProducerArr.length;
                innerProducerArr2 = new InnerProducer[length + 1];
                System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, length);
                innerProducerArr2[length] = innerProducer;
            } while (!this.iJY.compareAndSet(innerProducerArr, innerProducerArr2));
            return true;
        }

        void b(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            do {
                innerProducerArr = this.iJY.get();
                if (innerProducerArr != iJW && innerProducerArr != iJX) {
                    int i = -1;
                    int length = innerProducerArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerProducerArr[i2].equals(innerProducer)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerProducerArr2 = iJW;
                        } else {
                            innerProducerArr2 = new InnerProducer[length - 1];
                            System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, i);
                            System.arraycopy(innerProducerArr, i + 1, innerProducerArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.iJY.compareAndSet(innerProducerArr, innerProducerArr2));
        }

        boolean f(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (NotificationLite.aZ(obj)) {
                    if (z) {
                        this.iJP.compareAndSet(this, null);
                        try {
                            InnerProducer[] andSet = this.iJY.getAndSet(iJX);
                            int length = andSet.length;
                            while (i < length) {
                                andSet[i].child.onCompleted();
                                i++;
                            }
                            return true;
                        } finally {
                        }
                    }
                } else {
                    Throwable bc = NotificationLite.bc(obj);
                    this.iJP.compareAndSet(this, null);
                    try {
                        InnerProducer[] andSet2 = this.iJY.getAndSet(iJX);
                        int length2 = andSet2.length;
                        while (i < length2) {
                            andSet2[i].child.onError(bc);
                            i++;
                        }
                        return true;
                    } finally {
                    }
                }
            }
            return false;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x00da */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Queue, java.util.Queue<java.lang.Object>] */
        /* JADX WARN: Type inference failed for: r3v13, types: [int] */
        void cdU() {
            int i;
            boolean z;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                boolean z2 = false;
                while (true) {
                    try {
                        Object obj = this.iJV;
                        ?? r3 = this.queue;
                        boolean isEmpty = r3.isEmpty();
                        boolean z3 = r3;
                        if (!f(obj, isEmpty)) {
                            try {
                                if (!isEmpty) {
                                    InnerProducer[] innerProducerArr = this.iJY.get();
                                    int length = innerProducerArr.length;
                                    int i2 = 0;
                                    long j = Long.MAX_VALUE;
                                    for (InnerProducer innerProducer : innerProducerArr) {
                                        long j2 = innerProducer.get();
                                        if (j2 >= 0) {
                                            j = Math.min(j, j2);
                                        } else if (j2 == Long.MIN_VALUE) {
                                            i2++;
                                        }
                                    }
                                    if (length != i2) {
                                        int i3 = 0;
                                        while (true) {
                                            i = i3;
                                            boolean z4 = isEmpty;
                                            if (i >= j) {
                                                z = z4;
                                                break;
                                            }
                                            Object obj2 = this.iJV;
                                            Object poll = this.queue.poll();
                                            isEmpty = poll == null;
                                            if (!f(obj2, isEmpty)) {
                                                if (isEmpty) {
                                                    z = isEmpty;
                                                    break;
                                                }
                                                Object bb = NotificationLite.bb(poll);
                                                for (InnerProducer innerProducer2 : innerProducerArr) {
                                                    if (innerProducer2.get() > 0) {
                                                        innerProducer2.child.onNext(bb);
                                                        innerProducer2.produced(1L);
                                                    }
                                                }
                                                i3 = i + 1;
                                            } else {
                                                return;
                                            }
                                        }
                                        if (i > 0) {
                                            request(i);
                                        }
                                        ?? r32 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                                        z3 = r32;
                                        z3 = r32;
                                        if (r32 != 0 && !z) {
                                        }
                                    } else if (!f(this.iJV, this.queue.poll() == null)) {
                                        request(1L);
                                    } else {
                                        return;
                                    }
                                }
                                synchronized (this) {
                                    try {
                                        if (!this.missed) {
                                            this.emitting = false;
                                            return;
                                        }
                                        this.missed = false;
                                    } catch (Throwable th) {
                                        th = th;
                                        z3 = false;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = z3;
                                if (!z2) {
                                    synchronized (this) {
                                        this.emitting = false;
                                    }
                                }
                                throw th;
                            }
                        }
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class InnerProducer<T> extends AtomicLong implements rx.f, rx.k {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final rx.j<? super T> child;
        final a<T> parent;

        public InnerProducer(a<T> aVar, rx.j<? super T> jVar) {
            this.parent = aVar;
            this.child = jVar;
            lazySet(NOT_REQUESTED);
        }

        @Override // rx.f
        public void request(long j) {
            long j2;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 < 0 || j != 0) {
                            if (j2 == NOT_REQUESTED) {
                                j3 = j;
                            } else {
                                j3 = j2 + j;
                                if (j3 < 0) {
                                    j3 = Long.MAX_VALUE;
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.cdU();
            }
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j2 = get();
                if (j2 == NOT_REQUESTED) {
                    throw new IllegalStateException("Produced without request");
                }
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.b(this);
                this.parent.cdU();
            }
        }
    }
}
