package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.a.ae;
/* loaded from: classes6.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements d.a<T>, rx.e<T>, rx.k {
    static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final a<T> parent;
    final int prefetch;
    volatile rx.f producer;
    final Queue<T> queue;
    volatile PublishProducer<T>[] subscribers;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i <= 0) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i);
        }
        this.prefetch = i;
        this.delayError = z;
        if (ae.dON()) {
            this.queue = new rx.internal.util.a.q(i);
        } else {
            this.queue = new rx.internal.util.atomic.c(i);
        }
        this.subscribers = EMPTY;
        this.parent = new a<>(this);
    }

    public void call(rx.j<? super T> jVar) {
        PublishProducer<T> publishProducer = new PublishProducer<>(jVar, this);
        jVar.add(publishProducer);
        jVar.setProducer(publishProducer);
        if (add(publishProducer)) {
            if (publishProducer.isUnsubscribed()) {
                remove(publishProducer);
                return;
            } else {
                drain();
                return;
            }
        }
        Throwable th = this.error;
        if (th != null) {
            jVar.onError(th);
        } else {
            jVar.onCompleted();
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.e
    public void onCompleted() {
        this.done = true;
        drain();
    }

    void setProducer(rx.f fVar) {
        this.producer = fVar;
        fVar.request(this.prefetch);
    }

    void drain() {
        if (getAndIncrement() == 0) {
            Queue<T> queue = this.queue;
            int i = 0;
            do {
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                int length = publishProducerArr.length;
                int length2 = publishProducerArr.length;
                long j = Long.MAX_VALUE;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    j = Math.min(j, publishProducerArr[i2].get());
                }
                if (length != 0) {
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        T poll = queue.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2)) {
                            if (z2) {
                                break;
                            }
                            for (PublishProducer<T> publishProducer : publishProducerArr) {
                                publishProducer.actual.onNext(poll);
                            }
                            j2 = 1 + j2;
                        } else {
                            return;
                        }
                    }
                    if (j2 != j || !checkTerminated(this.done, queue.isEmpty())) {
                        if (j2 != 0) {
                            rx.f fVar = this.producer;
                            if (fVar != null) {
                                fVar.request(j2);
                            }
                            for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                                rx.internal.operators.a.c(publishProducer2, j2);
                            }
                        }
                    } else {
                        return;
                    }
                }
                i = addAndGet(-i);
            } while (i != 0);
        }
    }

    boolean checkTerminated(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (this.delayError) {
                if (z2) {
                    PublishProducer<T>[] terminate = terminate();
                    Throwable th = this.error;
                    if (th != null) {
                        int length = terminate.length;
                        while (i < length) {
                            terminate[i].actual.onError(th);
                            i++;
                        }
                        return true;
                    }
                    int length2 = terminate.length;
                    while (i < length2) {
                        terminate[i].actual.onCompleted();
                        i++;
                    }
                    return true;
                }
            } else {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    PublishProducer<T>[] terminate2 = terminate();
                    int length3 = terminate2.length;
                    while (i < length3) {
                        terminate2[i].actual.onError(th2);
                        i++;
                    }
                    return true;
                } else if (z2) {
                    PublishProducer<T>[] terminate3 = terminate();
                    int length4 = terminate3.length;
                    while (i < length4) {
                        terminate3[i].actual.onCompleted();
                        i++;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr;
        PublishProducer<T>[] publishProducerArr2 = this.subscribers;
        if (publishProducerArr2 != TERMINATED) {
            synchronized (this) {
                publishProducerArr = this.subscribers;
                if (publishProducerArr != TERMINATED) {
                    this.subscribers = TERMINATED;
                }
            }
            return publishProducerArr;
        }
        return publishProducerArr2;
    }

    boolean add(PublishProducer<T> publishProducer) {
        boolean z = false;
        if (this.subscribers != TERMINATED) {
            synchronized (this) {
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                if (publishProducerArr != TERMINATED) {
                    int length = publishProducerArr.length;
                    PublishProducer<T>[] publishProducerArr2 = new PublishProducer[length + 1];
                    System.arraycopy(publishProducerArr, 0, publishProducerArr2, 0, length);
                    publishProducerArr2[length] = publishProducer;
                    this.subscribers = publishProducerArr2;
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    void remove(PublishProducer<T> publishProducer) {
        PublishProducer<?>[] publishProducerArr;
        int i = 0;
        PublishProducer<T>[] publishProducerArr2 = this.subscribers;
        if (publishProducerArr2 != TERMINATED && publishProducerArr2 != EMPTY) {
            synchronized (this) {
                PublishProducer<T>[] publishProducerArr3 = this.subscribers;
                if (publishProducerArr3 != TERMINATED && publishProducerArr3 != EMPTY) {
                    int i2 = -1;
                    int length = publishProducerArr3.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (publishProducerArr3[i] == publishProducer) {
                            i2 = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            publishProducerArr = EMPTY;
                        } else {
                            publishProducerArr = new PublishProducer[length - 1];
                            System.arraycopy(publishProducerArr3, 0, publishProducerArr, 0, i2);
                            System.arraycopy(publishProducerArr3, i2 + 1, publishProducerArr, i2, (length - i2) - 1);
                        }
                        this.subscribers = publishProducerArr;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> {
        final OnSubscribePublishMulticast<T> nOF;

        public a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.nOF = onSubscribePublishMulticast;
        }

        @Override // rx.e
        public void onNext(T t) {
            this.nOF.onNext(t);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.nOF.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.nOF.onCompleted();
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.nOF.setProducer(fVar);
        }
    }

    public rx.j<T> subscriber() {
        return this.parent;
    }

    @Override // rx.k
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class PublishProducer<T> extends AtomicLong implements rx.f, rx.k {
        private static final long serialVersionUID = 960704844171597367L;
        final rx.j<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(rx.j<? super T> jVar, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = jVar;
            this.parent = onSubscribePublishMulticast;
        }

        @Override // rx.f
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            if (j != 0) {
                rx.internal.operators.a.e(this, j);
                this.parent.drain();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.once.get();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }
}
