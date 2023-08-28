package rx.internal.operators;

import com.baidu.tieba.b8c;
import com.baidu.tieba.m8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.v7c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements p7c.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements r7c {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final v7c<? super T> o;

        public IterableProducer(v7c<? super T> v7cVar, Iterator<? extends T> it) {
            this.o = v7cVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            v7c<? super T> v7cVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!v7cVar.isUnsubscribed()) {
                try {
                    v7cVar.onNext((T) it.next());
                    if (v7cVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!v7cVar.isUnsubscribed()) {
                                v7cVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        b8c.f(th, v7cVar);
                        return;
                    }
                } catch (Throwable th2) {
                    b8c.f(th2, v7cVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.r7c
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && m8c.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            v7c<? super T> v7cVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (v7cVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            v7cVar.onNext((T) it.next());
                            if (v7cVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!v7cVar.isUnsubscribed()) {
                                        v7cVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                b8c.f(th, v7cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            b8c.f(th2, v7cVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = m8c.g(this, j2);
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

    public void call(v7c<? super T> v7cVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!v7cVar.isUnsubscribed()) {
                if (!hasNext) {
                    v7cVar.onCompleted();
                } else {
                    v7cVar.f(new IterableProducer(v7cVar, it));
                }
            }
        } catch (Throwable th) {
            b8c.f(th, v7cVar);
        }
    }

    @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((v7c) ((v7c) obj));
    }
}
