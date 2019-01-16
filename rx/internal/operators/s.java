package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.d;
/* loaded from: classes2.dex */
public final class s<T> implements d.a<T> {
    volatile rx.subscriptions.b iHQ = new rx.subscriptions.b();
    final AtomicInteger iHR = new AtomicInteger(0);
    final ReentrantLock lock = new ReentrantLock();
    private final rx.observables.c<? extends T> source;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public s(rx.observables.c<? extends T> cVar) {
        this.source = cVar;
    }

    public void call(rx.j<? super T> jVar) {
        boolean z;
        this.lock.lock();
        if (this.iHR.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.source.c(a(jVar, atomicBoolean));
                if (z) {
                    return;
                }
                return;
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            a(jVar, this.iHQ);
        } finally {
            this.lock.unlock();
        }
    }

    private rx.functions.b<rx.k> a(final rx.j<? super T> jVar, final AtomicBoolean atomicBoolean) {
        return new rx.functions.b<rx.k>() { // from class: rx.internal.operators.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(rx.k kVar) {
                try {
                    s.this.iHQ.add(kVar);
                    s.this.a(jVar, s.this.iHQ);
                } finally {
                    s.this.lock.unlock();
                    atomicBoolean.set(false);
                }
            }
        };
    }

    void a(final rx.j<? super T> jVar, final rx.subscriptions.b bVar) {
        jVar.add(a(bVar));
        this.source.unsafeSubscribe(new rx.j<T>(jVar) { // from class: rx.internal.operators.s.2
            @Override // rx.e
            public void onError(Throwable th) {
                cleanup();
                jVar.onError(th);
            }

            @Override // rx.e
            public void onNext(T t) {
                jVar.onNext(t);
            }

            @Override // rx.e
            public void onCompleted() {
                cleanup();
                jVar.onCompleted();
            }

            void cleanup() {
                s.this.lock.lock();
                try {
                    if (s.this.iHQ == bVar) {
                        s.this.iHQ.unsubscribe();
                        s.this.iHQ = new rx.subscriptions.b();
                        s.this.iHR.set(0);
                    }
                } finally {
                    s.this.lock.unlock();
                }
            }
        });
    }

    private rx.k a(final rx.subscriptions.b bVar) {
        return rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.s.3
            @Override // rx.functions.a
            public void call() {
                s.this.lock.lock();
                try {
                    if (s.this.iHQ == bVar && s.this.iHR.decrementAndGet() == 0) {
                        s.this.iHQ.unsubscribe();
                        s.this.iHQ = new rx.subscriptions.b();
                    }
                } finally {
                    s.this.lock.unlock();
                }
            }
        });
    }
}
