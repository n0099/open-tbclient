package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.t7b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OnSubscribeFromIterable<T> implements h7b.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes10.dex */
    public static final class IterableProducer<T> extends AtomicLong implements j7b {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final n7b<? super T> o;

        public IterableProducer(n7b<? super T> n7bVar, Iterator<? extends T> it) {
            this.o = n7bVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            n7b<? super T> n7bVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!n7bVar.isUnsubscribed()) {
                try {
                    n7bVar.onNext((T) it.next());
                    if (n7bVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!n7bVar.isUnsubscribed()) {
                                n7bVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        t7b.f(th, n7bVar);
                        return;
                    }
                } catch (Throwable th2) {
                    t7b.f(th2, n7bVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.j7b
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && c8b.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            n7b<? super T> n7bVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (n7bVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            n7bVar.onNext((T) it.next());
                            if (n7bVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!n7bVar.isUnsubscribed()) {
                                        n7bVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                t7b.f(th, n7bVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            t7b.f(th2, n7bVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = c8b.g(this, j2);
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

    public void call(n7b<? super T> n7bVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!n7bVar.isUnsubscribed()) {
                if (!hasNext) {
                    n7bVar.onCompleted();
                } else {
                    n7bVar.f(new IterableProducer(n7bVar, it));
                }
            }
        } catch (Throwable th) {
            t7b.f(th, n7bVar);
        }
    }

    @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((n7b) ((n7b) obj));
    }
}
