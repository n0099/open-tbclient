package rx.internal.operators;

import com.baidu.tieba.iec;
import com.baidu.tieba.ndc;
import com.baidu.tieba.pbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.tac;
import com.baidu.tieba.uac;
import com.baidu.tieba.wec;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements sac.a<T>, tac<T>, zac {
    public static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    public static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    public static final long serialVersionUID = -3741892510772238743L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final a<T> parent;
    public final int prefetch;
    public volatile uac producer;
    public final Queue<T> queue;
    public volatile PublishProducer<T>[] subscribers;

    /* loaded from: classes2.dex */
    public static final class PublishProducer<T> extends AtomicLong implements uac, zac {
        public static final long serialVersionUID = 960704844171597367L;
        public final yac<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(yac<? super T> yacVar, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = yacVar;
            this.parent = onSubscribePublishMulticast;
        }

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return this.once.get();
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    pbc.b(this, j);
                    this.parent.drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> extends yac<T> {
        public final OnSubscribePublishMulticast<T> e;

        public a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.e = onSubscribePublishMulticast;
        }

        @Override // com.baidu.tieba.yac
        public void f(uac uacVar) {
            this.e.setProducer(uacVar);
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            this.e.onError(th);
        }

        @Override // com.baidu.tieba.tac
        public void onNext(T t) {
            this.e.onNext(t);
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            this.e.onCompleted();
        }
    }

    @Override // com.baidu.tieba.zac
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    @Override // com.baidu.tieba.tac
    public void onCompleted() {
        this.done = true;
        drain();
    }

    public yac<T> subscriber() {
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

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i > 0) {
            this.prefetch = i;
            this.delayError = z;
            if (wec.b()) {
                this.queue = new iec(i);
            } else {
                this.queue = new ndc(i);
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

    public void call(yac<? super T> yacVar) {
        PublishProducer<T> publishProducer = new PublishProducer<>(yacVar, this);
        yacVar.b(publishProducer);
        yacVar.f(publishProducer);
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
            yacVar.onError(th);
        } else {
            yacVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.tac
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // com.baidu.tieba.tac
    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    public void setProducer(uac uacVar) {
        this.producer = uacVar;
        uacVar.request(this.prefetch);
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2) {
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
                    } else {
                        int length2 = terminate.length;
                        while (i < length2) {
                            terminate[i].actual.onCompleted();
                            i++;
                        }
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

    public void drain() {
        int i;
        boolean z;
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
                    boolean z2 = this.done;
                    T poll = queue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (checkTerminated(z2, z)) {
                        return;
                    }
                    if (z) {
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
                    uac uacVar = this.producer;
                    if (uacVar != null) {
                        uacVar.request(j2);
                    }
                    for (PublishProducer<T> publishProducer3 : publishProducerArr) {
                        pbc.g(publishProducer3, j2);
                    }
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
    }

    public void remove(PublishProducer<T> publishProducer) {
        PublishProducer[] publishProducerArr;
        PublishProducer<T>[] publishProducerArr2 = this.subscribers;
        if (publishProducerArr2 != TERMINATED && publishProducerArr2 != EMPTY) {
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
    }
}
