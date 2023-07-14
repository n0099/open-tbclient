package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.w1c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements u1c.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements w1c {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final a2c<? super T> o;

        public IterableProducer(a2c<? super T> a2cVar, Iterator<? extends T> it) {
            this.o = a2cVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            a2c<? super T> a2cVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!a2cVar.isUnsubscribed()) {
                try {
                    a2cVar.onNext((T) it.next());
                    if (a2cVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!a2cVar.isUnsubscribed()) {
                                a2cVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        g2c.f(th, a2cVar);
                        return;
                    }
                } catch (Throwable th2) {
                    g2c.f(th2, a2cVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.w1c
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && q2c.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            a2c<? super T> a2cVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (a2cVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            a2cVar.onNext((T) it.next());
                            if (a2cVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!a2cVar.isUnsubscribed()) {
                                        a2cVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                g2c.f(th, a2cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            g2c.f(th2, a2cVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = q2c.g(this, j2);
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

    public void call(a2c<? super T> a2cVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!a2cVar.isUnsubscribed()) {
                if (!hasNext) {
                    a2cVar.onCompleted();
                } else {
                    a2cVar.f(new IterableProducer(a2cVar, it));
                }
            }
        } catch (Throwable th) {
            g2c.f(th, a2cVar);
        }
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }
}
