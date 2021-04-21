package rx.subjects;

import h.d;
import h.e;
import h.f;
import h.j;
import h.k;
import h.o.a.a;
import h.t.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class PublishSubject<T> extends d<T, T> {

    /* renamed from: f  reason: collision with root package name */
    public final PublishSubjectState<T> f69442f;

    /* loaded from: classes7.dex */
    public static final class PublishSubjectProducer<T> extends AtomicLong implements f, k, e<T> {
        public static final long serialVersionUID = 6451806817170721536L;
        public final j<? super T> actual;
        public final PublishSubjectState<T> parent;
        public long produced;

        public PublishSubjectProducer(PublishSubjectState<T> publishSubjectState, j<? super T> jVar) {
            this.parent = publishSubjectState;
            this.actual = jVar;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // h.e
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onCompleted();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            }
        }

        @Override // h.e
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

        @Override // h.f
        public void request(long j) {
            long j2;
            if (a.h(j)) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j2, a.a(j2, j)));
            }
        }

        @Override // h.k
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class PublishSubjectState<T> extends AtomicReference<PublishSubjectProducer<T>[]> implements d.a<T>, e<T> {
        public static final PublishSubjectProducer[] EMPTY = new PublishSubjectProducer[0];
        public static final PublishSubjectProducer[] TERMINATED = new PublishSubjectProducer[0];
        public static final long serialVersionUID = -7568940796666027140L;
        public Throwable error;

        public PublishSubjectState() {
            lazySet(EMPTY);
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

        @Override // h.n.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        @Override // h.e
        public void onCompleted() {
            for (PublishSubjectProducer<T> publishSubjectProducer : getAndSet(TERMINATED)) {
                publishSubjectProducer.onCompleted();
            }
        }

        @Override // h.e
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
            h.m.a.d(arrayList);
        }

        @Override // h.e
        public void onNext(T t) {
            for (PublishSubjectProducer<T> publishSubjectProducer : get()) {
                publishSubjectProducer.onNext(t);
            }
        }

        public void remove(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer<T>[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            do {
                publishSubjectProducerArr = get();
                if (publishSubjectProducerArr == TERMINATED || publishSubjectProducerArr == EMPTY) {
                    return;
                }
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
            } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
        }

        public void call(j<? super T> jVar) {
            PublishSubjectProducer<T> publishSubjectProducer = new PublishSubjectProducer<>(this, jVar);
            jVar.add(publishSubjectProducer);
            jVar.setProducer(publishSubjectProducer);
            if (add(publishSubjectProducer)) {
                if (publishSubjectProducer.isUnsubscribed()) {
                    remove(publishSubjectProducer);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                jVar.onError(th);
            } else {
                jVar.onCompleted();
            }
        }
    }

    public PublishSubject(PublishSubjectState<T> publishSubjectState) {
        super(publishSubjectState);
        this.f69442f = publishSubjectState;
    }

    public static <T> PublishSubject<T> N() {
        return new PublishSubject<>(new PublishSubjectState());
    }

    @Override // h.e
    public void onCompleted() {
        this.f69442f.onCompleted();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f69442f.onError(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f69442f.onNext(t);
    }
}
