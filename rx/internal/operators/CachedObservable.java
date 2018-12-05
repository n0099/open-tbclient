package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
/* loaded from: classes2.dex */
public final class CachedObservable<T> extends rx.d<T> {
    private final a<T> state;

    public static <T> CachedObservable<T> b(rx.d<? extends T> dVar) {
        return a(dVar, 16);
    }

    public static <T> CachedObservable<T> a(rx.d<? extends T> dVar, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required");
        }
        a aVar = new a(dVar, i);
        return new CachedObservable<>(new CachedSubscribe(aVar), aVar);
    }

    private CachedObservable(d.a<T> aVar, a<T> aVar2) {
        super(aVar);
        this.state = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.internal.util.d implements rx.e<T> {
        static final ReplayProducer<?>[] iBI = new ReplayProducer[0];
        final rx.d<? extends T> iBF;
        final rx.subscriptions.d iBG;
        volatile ReplayProducer<?>[] iBH;
        volatile boolean iBJ;
        boolean iBK;

        public a(rx.d<? extends T> dVar, int i) {
            super(i);
            this.iBF = dVar;
            this.iBH = iBI;
            this.iBG = new rx.subscriptions.d();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.internal.operators.CachedObservable$ReplayProducer<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(ReplayProducer<T> replayProducer) {
            synchronized (this.iBG) {
                ReplayProducer<?>[] replayProducerArr = this.iBH;
                int length = replayProducerArr.length;
                ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[length + 1];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
                this.iBH = replayProducerArr2;
            }
        }

        public void b(ReplayProducer<T> replayProducer) {
            int i = 0;
            synchronized (this.iBG) {
                ReplayProducer<?>[] replayProducerArr = this.iBH;
                int length = replayProducerArr.length;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (replayProducerArr[i].equals(replayProducer)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        this.iBH = iBI;
                        return;
                    }
                    ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[length - 1];
                    System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, i);
                    System.arraycopy(replayProducerArr, i + 1, replayProducerArr2, i, (length - i) - 1);
                    this.iBH = replayProducerArr2;
                }
            }
        }

        public void connect() {
            rx.j<T> jVar = new rx.j<T>() { // from class: rx.internal.operators.CachedObservable.a.1
                @Override // rx.e
                public void onNext(T t) {
                    a.this.onNext(t);
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    a.this.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    a.this.onCompleted();
                }
            };
            this.iBG.g(jVar);
            this.iBF.unsafeSubscribe(jVar);
            this.iBJ = true;
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.iBK) {
                add(NotificationLite.aY(t));
                cde();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.iBK) {
                this.iBK = true;
                add(NotificationLite.M(th));
                this.iBG.unsubscribe();
                cde();
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iBK) {
                this.iBK = true;
                add(NotificationLite.cdh());
                this.iBG.unsubscribe();
                cde();
            }
        }

        void cde() {
            for (ReplayProducer<?> replayProducer : this.iBH) {
                replayProducer.replay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class CachedSubscribe<T> extends AtomicBoolean implements d.a<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        final a<T> state;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public CachedSubscribe(a<T> aVar) {
            this.state = aVar;
        }

        public void call(rx.j<? super T> jVar) {
            ReplayProducer<T> replayProducer = new ReplayProducer<>(jVar, this.state);
            this.state.a(replayProducer);
            jVar.add(replayProducer);
            jVar.setProducer(replayProducer);
            if (!get() && compareAndSet(false, true)) {
                this.state.connect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ReplayProducer<T> extends AtomicLong implements rx.f, rx.k {
        private static final long serialVersionUID = -2557562030197141021L;
        final rx.j<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        boolean emitting;
        int index;
        boolean missed;
        final a<T> state;

        public ReplayProducer(rx.j<? super T> jVar, a<T> aVar) {
            this.child = jVar;
            this.state = aVar;
        }

        @Override // rx.f
        public void request(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 >= 0) {
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = Long.MAX_VALUE;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(j2, j3));
            replay();
        }

        public long produced(long j) {
            return addAndGet(-j);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (get() >= 0 && getAndSet(-1L) >= 0) {
                this.state.b(this);
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        public void replay() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                try {
                    rx.j<? super T> jVar = this.child;
                    while (true) {
                        long j = get();
                        if (j >= 0) {
                            int size = this.state.size();
                            if (size != 0) {
                                Object[] objArr = this.currentBuffer;
                                if (objArr == null) {
                                    objArr = this.state.cem();
                                    this.currentBuffer = objArr;
                                }
                                int length = objArr.length - 1;
                                int i = this.index;
                                int i2 = this.currentIndexInBuffer;
                                if (j == 0) {
                                    Object obj = objArr[i2];
                                    if (NotificationLite.aZ(obj)) {
                                        jVar.onCompleted();
                                        unsubscribe();
                                        return;
                                    } else if (NotificationLite.ba(obj)) {
                                        jVar.onError(NotificationLite.bc(obj));
                                        unsubscribe();
                                        return;
                                    }
                                } else if (j > 0) {
                                    int i3 = i;
                                    int i4 = 0;
                                    int i5 = i2;
                                    Object[] objArr2 = objArr;
                                    while (i3 < size && j > 0) {
                                        if (!jVar.isUnsubscribed()) {
                                            if (i5 == length) {
                                                objArr2 = (Object[]) objArr2[length];
                                                i5 = 0;
                                            }
                                            if (NotificationLite.a(jVar, objArr2[i5])) {
                                                unsubscribe();
                                                return;
                                            }
                                            i3++;
                                            j--;
                                            i4++;
                                            i5++;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (!jVar.isUnsubscribed()) {
                                        this.index = i3;
                                        this.currentIndexInBuffer = i5;
                                        this.currentBuffer = objArr2;
                                        produced(i4);
                                    } else {
                                        return;
                                    }
                                }
                            }
                            synchronized (this) {
                                if (!this.missed) {
                                    this.emitting = false;
                                    return;
                                }
                                this.missed = false;
                            }
                        } else {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    if (0 == 0) {
                        synchronized (this) {
                            this.emitting = false;
                        }
                    }
                    throw th;
                }
            }
        }
    }
}
