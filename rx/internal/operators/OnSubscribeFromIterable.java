package rx.internal.operators;

import com.baidu.tieba.bpb;
import com.baidu.tieba.gob;
import com.baidu.tieba.iob;
import com.baidu.tieba.mob;
import com.baidu.tieba.sob;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements gob.a<T> {
    public final Iterable<? extends T> a;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements iob {
        public static final long serialVersionUID = -8730475647105475802L;
        public final Iterator<? extends T> it;
        public final mob<? super T> o;

        public IterableProducer(mob<? super T> mobVar, Iterator<? extends T> it) {
            this.o = mobVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            mob<? super T> mobVar = this.o;
            Iterator<? extends T> it = this.it;
            while (!mobVar.isUnsubscribed()) {
                try {
                    mobVar.onNext((T) it.next());
                    if (mobVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!mobVar.isUnsubscribed()) {
                                mobVar.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        sob.f(th, mobVar);
                        return;
                    }
                } catch (Throwable th2) {
                    sob.f(th2, mobVar);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.iob
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && bpb.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            mob<? super T> mobVar = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (mobVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            mobVar.onNext((T) it.next());
                            if (mobVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!mobVar.isUnsubscribed()) {
                                        mobVar.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                sob.f(th, mobVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            sob.f(th2, mobVar);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = bpb.g(this, j2);
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

    public void call(mob<? super T> mobVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            boolean hasNext = it.hasNext();
            if (!mobVar.isUnsubscribed()) {
                if (!hasNext) {
                    mobVar.onCompleted();
                } else {
                    mobVar.f(new IterableProducer(mobVar, it));
                }
            }
        } catch (Throwable th) {
            sob.f(th, mobVar);
        }
    }

    @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((mob) ((mob) obj));
    }
}
