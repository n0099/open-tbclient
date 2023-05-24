package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.i7b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.u7b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OnSubscribeFromIterable<T> implements i7b.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes10.dex */
    public static final class IterableProducer<T> extends AtomicLong implements k7b {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final o7b<? super T> o;

        public IterableProducer(o7b<? super T> o7bVar, Iterator<? extends T> it) {
            this.o = o7bVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            o7b<? super T> o7bVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!o7bVar.isUnsubscribed()) {
                try {
                    o7bVar.onNext((T) it.next());
                    if (o7bVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!o7bVar.isUnsubscribed()) {
                                o7bVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        u7b.f(th, o7bVar);
                        return;
                    }
                } catch (Throwable th2) {
                    u7b.f(th2, o7bVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.k7b
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && d8b.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            o7b<? super T> o7bVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (o7bVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            o7bVar.onNext((T) it.next());
                            if (o7bVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!o7bVar.isUnsubscribed()) {
                                        o7bVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                u7b.f(th, o7bVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            u7b.f(th2, o7bVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = d8b.g(this, j2);
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

    public void call(o7b<? super T> o7bVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!o7bVar.isUnsubscribed()) {
                if (!hasNext) {
                    o7bVar.onCompleted();
                } else {
                    o7bVar.f(new IterableProducer(o7bVar, it));
                }
            }
        } catch (Throwable th) {
            u7b.f(th, o7bVar);
        }
    }

    @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((o7b) ((o7b) obj));
    }
}
