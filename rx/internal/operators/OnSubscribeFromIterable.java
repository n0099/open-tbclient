package rx.internal.operators;

import com.baidu.tieba.dnb;
import com.baidu.tieba.imb;
import com.baidu.tieba.kmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.umb;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements imb.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements kmb {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final omb<? super T> o;

        public IterableProducer(omb<? super T> ombVar, Iterator<? extends T> it) {
            this.o = ombVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            omb<? super T> ombVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!ombVar.isUnsubscribed()) {
                try {
                    ombVar.onNext((T) it.next());
                    if (ombVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!ombVar.isUnsubscribed()) {
                                ombVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        umb.f(th, ombVar);
                        return;
                    }
                } catch (Throwable th2) {
                    umb.f(th2, ombVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.kmb
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && dnb.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            omb<? super T> ombVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (ombVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            ombVar.onNext((T) it.next());
                            if (ombVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!ombVar.isUnsubscribed()) {
                                        ombVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                umb.f(th, ombVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            umb.f(th2, ombVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = dnb.g(this, j2);
                        }
                    }
                }
            } while (j != 0);
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.a = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    public void call(omb<? super T> ombVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!ombVar.isUnsubscribed()) {
                if (!hasNext) {
                    ombVar.onCompleted();
                } else {
                    ombVar.f(new IterableProducer(ombVar, it));
                }
            }
        } catch (Throwable th) {
            umb.f(th, ombVar);
        }
    }

    @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((omb) ((omb) obj));
    }
}
