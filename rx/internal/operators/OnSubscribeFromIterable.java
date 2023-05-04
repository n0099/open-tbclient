package rx.internal.operators;

import com.baidu.tieba.e6b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.v5b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromIterable<T> implements j5b.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes9.dex */
    public static final class IterableProducer<T> extends AtomicLong implements l5b {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final p5b<? super T> o;

        public IterableProducer(p5b<? super T> p5bVar, Iterator<? extends T> it) {
            this.o = p5bVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            p5b<? super T> p5bVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!p5bVar.isUnsubscribed()) {
                try {
                    p5bVar.onNext((T) it.next());
                    if (p5bVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!p5bVar.isUnsubscribed()) {
                                p5bVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        v5b.f(th, p5bVar);
                        return;
                    }
                } catch (Throwable th2) {
                    v5b.f(th2, p5bVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.l5b
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && e6b.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            p5b<? super T> p5bVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (p5bVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            p5bVar.onNext((T) it.next());
                            if (p5bVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!p5bVar.isUnsubscribed()) {
                                        p5bVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                v5b.f(th, p5bVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            v5b.f(th2, p5bVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = e6b.g(this, j2);
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

    public void call(p5b<? super T> p5bVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!p5bVar.isUnsubscribed()) {
                if (!hasNext) {
                    p5bVar.onCompleted();
                } else {
                    p5bVar.f(new IterableProducer(p5bVar, it));
                }
            }
        } catch (Throwable th) {
            v5b.f(th, p5bVar);
        }
    }

    @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((p5b) ((p5b) obj));
    }
}
