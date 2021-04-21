package rx.internal.operators;

import h.b;
import h.c;
import h.k;
import h.u.d;
import h.u.e;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableOnSubscribeConcatIterable implements b.f {

    /* renamed from: e  reason: collision with root package name */
    public final Iterable<? extends b> f69306e;

    /* loaded from: classes7.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements c {
        public static final long serialVersionUID = -7965400327305809232L;
        public final c actual;
        public final d sd = new d();
        public final Iterator<? extends b> sources;

        public ConcatInnerSubscriber(c cVar, Iterator<? extends b> it) {
            this.actual = cVar;
            this.sources = it;
        }

        public void next() {
            if (!this.sd.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends b> it = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onCompleted();
                            return;
                        }
                        try {
                            b next = it.next();
                            if (next == null) {
                                this.actual.onError(new NullPointerException("The completable returned is null"));
                                return;
                            }
                            next.j(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            this.actual.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        this.actual.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // h.c
        public void onCompleted() {
            next();
        }

        @Override // h.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            this.sd.a(kVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends b> iterable) {
        this.f69306e = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(c cVar) {
        try {
            Iterator<? extends b> it = this.f69306e.iterator();
            if (it == null) {
                cVar.onSubscribe(e.c());
                cVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(cVar, it);
            cVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            cVar.onSubscribe(e.c());
            cVar.onError(th);
        }
    }
}
