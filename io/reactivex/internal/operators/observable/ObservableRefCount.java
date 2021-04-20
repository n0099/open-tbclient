package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import f.b.x.e.c.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class ObservableRefCount<T> extends a<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final f.b.y.a<? extends T> f69073e;

    /* renamed from: f  reason: collision with root package name */
    public volatile f.b.t.a f69074f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f69075g;

    /* renamed from: h  reason: collision with root package name */
    public final ReentrantLock f69076h;

    /* loaded from: classes7.dex */
    public final class ConnectionObserver extends AtomicReference<b> implements o<T>, b {
        public static final long serialVersionUID = 3813126992133394324L;
        public final f.b.t.a currentBase;
        public final b resource;
        public final o<? super T> subscriber;

        public ConnectionObserver(o<? super T> oVar, f.b.t.a aVar, b bVar) {
            this.subscriber = oVar;
            this.currentBase = aVar;
            this.resource = bVar;
        }

        public void cleanup() {
            ObservableRefCount.this.f69076h.lock();
            try {
                if (ObservableRefCount.this.f69074f == this.currentBase) {
                    f.b.y.a<? extends T> aVar = ObservableRefCount.this.f69073e;
                    ObservableRefCount.this.f69074f.dispose();
                    ObservableRefCount.this.f69074f = new f.b.t.a();
                    ObservableRefCount.this.f69075g.set(0);
                }
            } finally {
                ObservableRefCount.this.f69076h.unlock();
            }
        }

        @Override // f.b.t.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.resource.dispose();
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // f.b.o
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // f.b.o
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // f.b.o
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // f.b.o
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }
}
