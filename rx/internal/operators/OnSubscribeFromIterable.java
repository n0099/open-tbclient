package rx.internal.operators;

import com.baidu.tieba.g7c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.t6c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements h6c.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements j6c {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final n6c<? super T> o;

        public IterableProducer(n6c<? super T> n6cVar, Iterator<? extends T> it) {
            this.o = n6cVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            n6c<? super T> n6cVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!n6cVar.isUnsubscribed()) {
                try {
                    n6cVar.onNext((T) it.next());
                    if (n6cVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!n6cVar.isUnsubscribed()) {
                                n6cVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        t6c.f(th, n6cVar);
                        return;
                    }
                } catch (Throwable th2) {
                    t6c.f(th2, n6cVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.j6c
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && g7c.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            n6c<? super T> n6cVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (n6cVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            n6cVar.onNext((T) it.next());
                            if (n6cVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!n6cVar.isUnsubscribed()) {
                                        n6cVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                t6c.f(th, n6cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            t6c.f(th2, n6cVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = g7c.g(this, j2);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v6c
    /* renamed from: a */
    public void call(n6c<? super T> n6cVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!n6cVar.isUnsubscribed()) {
                if (!hasNext) {
                    n6cVar.onCompleted();
                } else {
                    n6cVar.f(new IterableProducer(n6cVar, it));
                }
            }
        } catch (Throwable th) {
            t6c.f(th, n6cVar);
        }
    }
}
