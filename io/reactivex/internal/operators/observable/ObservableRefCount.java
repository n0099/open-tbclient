package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.x.e.c.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class ObservableRefCount<T> extends a<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final f.a.y.a<? extends T> f68067e;

    /* renamed from: f  reason: collision with root package name */
    public volatile f.a.t.a f68068f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f68069g;

    /* renamed from: h  reason: collision with root package name */
    public final ReentrantLock f68070h;

    /* loaded from: classes7.dex */
    public final class ConnectionObserver extends AtomicReference<b> implements o<T>, b {
        public static final long serialVersionUID = 3813126992133394324L;
        public final f.a.t.a currentBase;
        public final b resource;
        public final o<? super T> subscriber;

        public ConnectionObserver(o<? super T> oVar, f.a.t.a aVar, b bVar) {
            this.subscriber = oVar;
            this.currentBase = aVar;
            this.resource = bVar;
        }

        public void cleanup() {
            ObservableRefCount.this.f68070h.lock();
            try {
                if (ObservableRefCount.this.f68068f == this.currentBase) {
                    f.a.y.a<? extends T> aVar = ObservableRefCount.this.f68067e;
                    ObservableRefCount.this.f68068f.dispose();
                    ObservableRefCount.this.f68068f = new f.a.t.a();
                    ObservableRefCount.this.f68069g.set(0);
                }
            } finally {
                ObservableRefCount.this.f68070h.unlock();
            }
        }

        @Override // f.a.t.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.resource.dispose();
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // f.a.o
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // f.a.o
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // f.a.o
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // f.a.o
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }
}
