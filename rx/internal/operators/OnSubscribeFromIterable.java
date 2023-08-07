package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.j1c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.x0c;
import com.baidu.tieba.z0c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements x0c.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements z0c {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final d1c<? super T> o;

        public IterableProducer(d1c<? super T> d1cVar, Iterator<? extends T> it) {
            this.o = d1cVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            d1c<? super T> d1cVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!d1cVar.isUnsubscribed()) {
                try {
                    d1cVar.onNext((T) it.next());
                    if (d1cVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!d1cVar.isUnsubscribed()) {
                                d1cVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        j1c.f(th, d1cVar);
                        return;
                    }
                } catch (Throwable th2) {
                    j1c.f(th2, d1cVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.z0c
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && t1c.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            d1c<? super T> d1cVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (d1cVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            d1cVar.onNext((T) it.next());
                            if (d1cVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!d1cVar.isUnsubscribed()) {
                                        d1cVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                j1c.f(th, d1cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            j1c.f(th2, d1cVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = t1c.g(this, j2);
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

    public void call(d1c<? super T> d1cVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!d1cVar.isUnsubscribed()) {
                if (!hasNext) {
                    d1cVar.onCompleted();
                } else {
                    d1cVar.f(new IterableProducer(d1cVar, it));
                }
            }
        } catch (Throwable th) {
            j1c.f(th, d1cVar);
        }
    }

    @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((d1c) ((d1c) obj));
    }
}
