package rx.internal.operators;

import com.baidu.tieba.k8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
import com.baidu.tieba.z7c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements n7c.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements p7c {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final t7c<? super T> o;

        public IterableProducer(t7c<? super T> t7cVar, Iterator<? extends T> it) {
            this.o = t7cVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            t7c<? super T> t7cVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!t7cVar.isUnsubscribed()) {
                try {
                    t7cVar.onNext((T) it.next());
                    if (t7cVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!t7cVar.isUnsubscribed()) {
                                t7cVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        z7c.f(th, t7cVar);
                        return;
                    }
                } catch (Throwable th2) {
                    z7c.f(th2, t7cVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.p7c
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && k8c.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            t7c<? super T> t7cVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (t7cVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            t7cVar.onNext((T) it.next());
                            if (t7cVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!t7cVar.isUnsubscribed()) {
                                        t7cVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                z7c.f(th, t7cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            z7c.f(th2, t7cVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = k8c.g(this, j2);
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

    public void call(t7c<? super T> t7cVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!t7cVar.isUnsubscribed()) {
                if (!hasNext) {
                    t7cVar.onCompleted();
                } else {
                    t7cVar.f(new IterableProducer(t7cVar, it));
                }
            }
        } catch (Throwable th) {
            z7c.f(th, t7cVar);
        }
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }
}
