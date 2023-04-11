package rx.internal.operators;

import com.baidu.tieba.a2b;
import com.baidu.tieba.f1b;
import com.baidu.tieba.h1b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.r1b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromIterable<T> implements f1b.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes9.dex */
    public static final class IterableProducer<T> extends AtomicLong implements h1b {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final l1b<? super T> o;

        public IterableProducer(l1b<? super T> l1bVar, Iterator<? extends T> it) {
            this.o = l1bVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            l1b<? super T> l1bVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!l1bVar.isUnsubscribed()) {
                try {
                    l1bVar.onNext((T) it.next());
                    if (l1bVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!l1bVar.isUnsubscribed()) {
                                l1bVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        r1b.f(th, l1bVar);
                        return;
                    }
                } catch (Throwable th2) {
                    r1b.f(th2, l1bVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.h1b
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && a2b.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            l1b<? super T> l1bVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (l1bVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            l1bVar.onNext((T) it.next());
                            if (l1bVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!l1bVar.isUnsubscribed()) {
                                        l1bVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                r1b.f(th, l1bVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            r1b.f(th2, l1bVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = a2b.g(this, j2);
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

    public void call(l1b<? super T> l1bVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!l1bVar.isUnsubscribed()) {
                if (!hasNext) {
                    l1bVar.onCompleted();
                } else {
                    l1bVar.f(new IterableProducer(l1bVar, it));
                }
            }
        } catch (Throwable th) {
            r1b.f(th, l1bVar);
        }
    }

    @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l1b) ((l1b) obj));
    }
}
