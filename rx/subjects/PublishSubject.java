package rx.subjects;

import com.baidu.tieba.a2c;
import com.baidu.tieba.b2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.s6c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.v1c;
import com.baidu.tieba.w1c;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class PublishSubject<T> extends s6c<T, T> {
    public final PublishSubjectState<T> b;

    /* loaded from: classes2.dex */
    public static final class PublishSubjectProducer<T> extends AtomicLong implements w1c, b2c, v1c<T> {
        public static final long serialVersionUID = 6451806817170721536L;
        public final a2c<? super T> actual;
        public final PublishSubjectState<T> parent;
        public long produced;

        public PublishSubjectProducer(PublishSubjectState<T> publishSubjectState, a2c<? super T> a2cVar) {
            this.parent = publishSubjectState;
            this.actual = a2cVar;
        }

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onCompleted();
            }
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            long j = get();
            if (j != Long.MIN_VALUE) {
                long j2 = this.produced;
                if (j != j2) {
                    this.produced = j2 + 1;
                    this.actual.onNext(t);
                    return;
                }
                unsubscribe();
                this.actual.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        @Override // com.baidu.tieba.w1c
        public void request(long j) {
            long j2;
            if (q2c.h(j)) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j2, q2c.a(j2, j)));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class PublishSubjectState<T> extends AtomicReference<PublishSubjectProducer<T>[]> implements u1c.a<T>, v1c<T> {
        public static final PublishSubjectProducer[] EMPTY = new PublishSubjectProducer[0];
        public static final PublishSubjectProducer[] TERMINATED = new PublishSubjectProducer[0];
        public static final long serialVersionUID = -7568940796666027140L;
        public Throwable error;

        public PublishSubjectState() {
            lazySet(EMPTY);
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            for (PublishSubjectProducer<T> publishSubjectProducer : getAndSet(TERMINATED)) {
                publishSubjectProducer.onCompleted();
            }
        }

        public boolean add(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer<T>[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            do {
                publishSubjectProducerArr = get();
                if (publishSubjectProducerArr == TERMINATED) {
                    return false;
                }
                int length = publishSubjectProducerArr.length;
                publishSubjectProducerArr2 = new PublishSubjectProducer[length + 1];
                System.arraycopy(publishSubjectProducerArr, 0, publishSubjectProducerArr2, 0, length);
                publishSubjectProducerArr2[length] = publishSubjectProducer;
            } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
            return true;
        }

        public void call(a2c<? super T> a2cVar) {
            PublishSubjectProducer<T> publishSubjectProducer = new PublishSubjectProducer<>(this, a2cVar);
            a2cVar.b(publishSubjectProducer);
            a2cVar.f(publishSubjectProducer);
            if (add(publishSubjectProducer)) {
                if (publishSubjectProducer.isUnsubscribed()) {
                    remove(publishSubjectProducer);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                a2cVar.onError(th);
            } else {
                a2cVar.onCompleted();
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            this.error = th;
            ArrayList arrayList = null;
            for (PublishSubjectProducer<T> publishSubjectProducer : getAndSet(TERMINATED)) {
                try {
                    publishSubjectProducer.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th2);
                }
            }
            g2c.d(arrayList);
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            for (PublishSubjectProducer<T> publishSubjectProducer : get()) {
                publishSubjectProducer.onNext(t);
            }
        }

        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((a2c) ((a2c) obj));
        }

        public void remove(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer<T>[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            do {
                publishSubjectProducerArr = get();
                if (publishSubjectProducerArr != TERMINATED && publishSubjectProducerArr != EMPTY) {
                    int length = publishSubjectProducerArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (publishSubjectProducerArr[i2] == publishSubjectProducer) {
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
                        publishSubjectProducerArr2 = EMPTY;
                    } else {
                        PublishSubjectProducer[] publishSubjectProducerArr3 = new PublishSubjectProducer[length - 1];
                        System.arraycopy(publishSubjectProducerArr, 0, publishSubjectProducerArr3, 0, i);
                        System.arraycopy(publishSubjectProducerArr, i + 1, publishSubjectProducerArr3, i, (length - i) - 1);
                        publishSubjectProducerArr2 = publishSubjectProducerArr3;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
        }
    }

    public PublishSubject(PublishSubjectState<T> publishSubjectState) {
        super(publishSubjectState);
        this.b = publishSubjectState;
    }

    @Override // com.baidu.tieba.v1c
    public void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // com.baidu.tieba.v1c
    public void onNext(T t) {
        this.b.onNext(t);
    }

    public static <T> PublishSubject<T> Q() {
        return new PublishSubject<>(new PublishSubjectState());
    }

    @Override // com.baidu.tieba.v1c
    public void onCompleted() {
        this.b.onCompleted();
    }
}
