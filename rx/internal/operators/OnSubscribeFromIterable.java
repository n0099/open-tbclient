package rx.internal.operators;

import com.baidu.tieba.i2b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.z1b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromIterable<T> implements n1b.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes9.dex */
    public static final class IterableProducer<T> extends AtomicLong implements p1b {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final t1b<? super T> o;

        public IterableProducer(t1b<? super T> t1bVar, Iterator<? extends T> it) {
            this.o = t1bVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            t1b<? super T> t1bVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!t1bVar.isUnsubscribed()) {
                try {
                    t1bVar.onNext((T) it.next());
                    if (t1bVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!t1bVar.isUnsubscribed()) {
                                t1bVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        z1b.f(th, t1bVar);
                        return;
                    }
                } catch (Throwable th2) {
                    z1b.f(th2, t1bVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.p1b
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && i2b.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            t1b<? super T> t1bVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (t1bVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            t1bVar.onNext((T) it.next());
                            if (t1bVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!t1bVar.isUnsubscribed()) {
                                        t1bVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                z1b.f(th, t1bVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            z1b.f(th2, t1bVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = i2b.g(this, j2);
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

    public void call(t1b<? super T> t1bVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!t1bVar.isUnsubscribed()) {
                if (!hasNext) {
                    t1bVar.onCompleted();
                } else {
                    t1bVar.f(new IterableProducer(t1bVar, it));
                }
            }
        } catch (Throwable th) {
            z1b.f(th, t1bVar);
        }
    }

    @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t1b) ((t1b) obj));
    }
}
