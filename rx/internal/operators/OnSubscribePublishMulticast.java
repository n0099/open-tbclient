package rx.internal.operators;

import h.d;
import h.e;
import h.f;
import h.j;
import h.k;
import h.o.d.j.c;
import h.o.d.k.f0;
import h.o.d.k.r;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements d.a<T>, e<T>, k {
    public static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    public static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    public static final long serialVersionUID = -3741892510772238743L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final a<T> parent;
    public final int prefetch;
    public volatile f producer;
    public final Queue<T> queue;
    public volatile PublishProducer<T>[] subscribers;

    /* loaded from: classes7.dex */
    public static final class PublishProducer<T> extends AtomicLong implements f, k {
        public static final long serialVersionUID = 960704844171597367L;
        public final j<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(j<? super T> jVar, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = jVar;
            this.parent = onSubscribePublishMulticast;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.once.get();
        }

        @Override // h.f
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i != 0) {
                h.o.a.a.b(this, j);
                this.parent.drain();
            }
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class a<T> extends j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final OnSubscribePublishMulticast<T> f68186e;

        public a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f68186e = onSubscribePublishMulticast;
        }

        @Override // h.e
        public void onCompleted() {
            this.f68186e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f68186e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            this.f68186e.onNext(t);
        }

        @Override // h.j
        public void setProducer(f fVar) {
            this.f68186e.setProducer(fVar);
        }
    }

    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i > 0) {
            this.prefetch = i;
            this.delayError = z;
            if (f0.b()) {
                this.queue = new r(i);
            } else {
                this.queue = new c(i);
            }
            this.subscribers = (PublishProducer<T>[]) EMPTY;
            this.parent = new a<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i);
    }

    public boolean add(PublishProducer<T> publishProducer) {
        if (this.subscribers == TERMINATED) {
            return false;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr = this.subscribers;
            if (publishProducerArr == TERMINATED) {
                return false;
            }
            int length = publishProducerArr.length;
            PublishProducer<T>[] publishProducerArr2 = new PublishProducer[length + 1];
            System.arraycopy(publishProducerArr, 0, publishProducerArr2, 0, length);
            publishProducerArr2[length] = publishProducer;
            this.subscribers = publishProducerArr2;
            return true;
        }
    }

    @Override // h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    PublishProducer<T>[] terminate = terminate();
                    int length = terminate.length;
                    while (i < length) {
                        terminate[i].actual.onError(th);
                        i++;
                    }
                    return true;
                } else if (z2) {
                    PublishProducer<T>[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i < length2) {
                        terminate2[i].actual.onCompleted();
                        i++;
                    }
                    return true;
                }
            } else if (z2) {
                PublishProducer<T>[] terminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = terminate3.length;
                    while (i < length3) {
                        terminate3[i].actual.onError(th2);
                        i++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i < length4) {
                        terminate3[i].actual.onCompleted();
                        i++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void drain() {
        int i;
        if (getAndIncrement() != 0) {
            return;
        }
        Queue<T> queue = this.queue;
        int i2 = 0;
        do {
            long j = Long.MAX_VALUE;
            PublishProducer<T>[] publishProducerArr = this.subscribers;
            int length = publishProducerArr.length;
            for (PublishProducer<T> publishProducer : publishProducerArr) {
                j = Math.min(j, publishProducer.get());
            }
            if (length != 0) {
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z = this.done;
                    T poll = queue.poll();
                    boolean z2 = poll == null;
                    if (checkTerminated(z, z2)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                        publishProducer2.actual.onNext(poll);
                    }
                    j2++;
                }
                if (i == 0 && checkTerminated(this.done, queue.isEmpty())) {
                    return;
                }
                if (j2 != 0) {
                    f fVar = this.producer;
                    if (fVar != null) {
                        fVar.request(j2);
                    }
                    for (PublishProducer<T> publishProducer3 : publishProducerArr) {
                        h.o.a.a.g(publishProducer3, j2);
                    }
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    @Override // h.e
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // h.e
    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    public void remove(PublishProducer<T> publishProducer) {
        PublishProducer[] publishProducerArr;
        PublishProducer<T>[] publishProducerArr2 = this.subscribers;
        if (publishProducerArr2 == TERMINATED || publishProducerArr2 == EMPTY) {
            return;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr3 = this.subscribers;
            if (publishProducerArr3 != TERMINATED && publishProducerArr3 != EMPTY) {
                int i = -1;
                int length = publishProducerArr3.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (publishProducerArr3[i2] == publishProducer) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    publishProducerArr = EMPTY;
                } else {
                    PublishProducer[] publishProducerArr4 = new PublishProducer[length - 1];
                    System.arraycopy(publishProducerArr3, 0, publishProducerArr4, 0, i);
                    System.arraycopy(publishProducerArr3, i + 1, publishProducerArr4, i, (length - i) - 1);
                    publishProducerArr = publishProducerArr4;
                }
                this.subscribers = publishProducerArr;
            }
        }
    }

    public void setProducer(f fVar) {
        this.producer = fVar;
        fVar.request(this.prefetch);
    }

    public j<T> subscriber() {
        return this.parent;
    }

    public PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        if (publishProducerArr != TERMINATED) {
            synchronized (this) {
                publishProducerArr = this.subscribers;
                if (publishProducerArr != TERMINATED) {
                    this.subscribers = (PublishProducer<T>[]) TERMINATED;
                }
            }
        }
        return publishProducerArr;
    }

    @Override // h.k
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    public void call(j<? super T> jVar) {
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
}
