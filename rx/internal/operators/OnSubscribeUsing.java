package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.d;
/* loaded from: classes5.dex */
public final class OnSubscribeUsing<T, Resource> implements d.a<T> {
    private final rx.functions.b<? super Resource> dispose;
    private final rx.functions.e<Resource> qAh;
    private final rx.functions.f<? super Resource, ? extends rx.d<? extends T>> qAi;
    private final boolean qAj;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public void call(rx.j<? super T> jVar) {
        rx.d<? extends T> b2;
        try {
            Resource call = this.qAh.call();
            DisposeAction disposeAction = new DisposeAction(this.dispose, call);
            jVar.add(disposeAction);
            rx.d<? extends T> call2 = this.qAi.call(call);
            if (this.qAj) {
                b2 = call2.a(disposeAction);
            } else {
                b2 = call2.b(disposeAction);
            }
            b2.a(rx.b.f.d(jVar));
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
        }
    }

    private Throwable f(rx.functions.a aVar) {
        try {
            aVar.call();
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class DisposeAction<Resource> extends AtomicBoolean implements rx.functions.a, rx.k {
        private static final long serialVersionUID = 4262875056400218316L;
        private rx.functions.b<? super Resource> dispose;
        private Resource resource;

        DisposeAction(rx.functions.b<? super Resource> bVar, Resource resource) {
            this.dispose = bVar;
            this.resource = resource;
            lazySet(false);
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: Resource, ? super Resource */
        /* JADX WARN: Type inference failed for: r2v0, types: [Resource, rx.functions.b<? super Resource>] */
        @Override // rx.functions.a
        public void call() {
            ?? r2 = (Resource) false;
            if (compareAndSet(false, true)) {
                try {
                    this.dispose.call((Resource) this.resource);
                } finally {
                    this.resource = null;
                    this.dispose = null;
                }
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.k
        public void unsubscribe() {
            call();
        }
    }
}
