package rx.internal.operators;

import com.baidu.tieba.a1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.y0c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements y0c.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements a1c {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final e1c<? super T> o;

        public IterableProducer(e1c<? super T> e1cVar, Iterator<? extends T> it) {
            this.o = e1cVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            e1c<? super T> e1cVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!e1cVar.isUnsubscribed()) {
                try {
                    e1cVar.onNext((T) it.next());
                    if (e1cVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!e1cVar.isUnsubscribed()) {
                                e1cVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        k1c.f(th, e1cVar);
                        return;
                    }
                } catch (Throwable th2) {
                    k1c.f(th2, e1cVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.a1c
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && u1c.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            e1c<? super T> e1cVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (e1cVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            e1cVar.onNext((T) it.next());
                            if (e1cVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!e1cVar.isUnsubscribed()) {
                                        e1cVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                k1c.f(th, e1cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            k1c.f(th2, e1cVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = u1c.g(this, j2);
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

    public void call(e1c<? super T> e1cVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!e1cVar.isUnsubscribed()) {
                if (!hasNext) {
                    e1cVar.onCompleted();
                } else {
                    e1cVar.f(new IterableProducer(e1cVar, it));
                }
            }
        } catch (Throwable th) {
            k1c.f(th, e1cVar);
        }
    }

    @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((e1c) ((e1c) obj));
    }
}
