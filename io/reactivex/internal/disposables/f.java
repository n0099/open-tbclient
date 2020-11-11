package io.reactivex.internal.disposables;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.u;
/* loaded from: classes17.dex */
public final class f<T> extends c implements io.reactivex.disposables.b {
    final u<? super T> actual;
    volatile boolean cancelled;
    final io.reactivex.internal.queue.a<Object> queue;
    io.reactivex.disposables.b resource;
    volatile io.reactivex.disposables.b s = EmptyDisposable.INSTANCE;

    public f(u<? super T> uVar, io.reactivex.disposables.b bVar, int i) {
        this.actual = uVar;
        this.resource = bVar;
        this.queue = new io.reactivex.internal.queue.a<>(i);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (!this.cancelled) {
            this.cancelled = true;
            eAE();
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        io.reactivex.disposables.b bVar = this.resource;
        return bVar != null ? bVar.isDisposed() : this.cancelled;
    }

    void eAE() {
        io.reactivex.disposables.b bVar = this.resource;
        this.resource = null;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public boolean d(io.reactivex.disposables.b bVar) {
        if (this.cancelled) {
            return false;
        }
        this.queue.offer(this.s, NotificationLite.disposable(bVar));
        drain();
        return true;
    }

    public boolean a(T t, io.reactivex.disposables.b bVar) {
        if (this.cancelled) {
            return false;
        }
        this.queue.offer(bVar, NotificationLite.next(t));
        drain();
        return true;
    }

    public void a(Throwable th, io.reactivex.disposables.b bVar) {
        if (this.cancelled) {
            io.reactivex.e.a.onError(th);
            return;
        }
        this.queue.offer(bVar, NotificationLite.error(th));
        drain();
    }

    public void e(io.reactivex.disposables.b bVar) {
        this.queue.offer(bVar, NotificationLite.complete());
        drain();
    }

    void drain() {
        if (this.wip.getAndIncrement() == 0) {
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            u<? super T> uVar = this.actual;
            int i = 1;
            while (true) {
                Object poll = aVar.poll();
                if (poll != null) {
                    Object poll2 = aVar.poll();
                    if (poll == this.s) {
                        if (NotificationLite.isDisposable(poll2)) {
                            io.reactivex.disposables.b disposable = NotificationLite.getDisposable(poll2);
                            this.s.dispose();
                            if (!this.cancelled) {
                                this.s = disposable;
                            } else {
                                disposable.dispose();
                            }
                        } else if (NotificationLite.isError(poll2)) {
                            aVar.clear();
                            eAE();
                            Throwable error = NotificationLite.getError(poll2);
                            if (!this.cancelled) {
                                this.cancelled = true;
                                uVar.onError(error);
                            } else {
                                io.reactivex.e.a.onError(error);
                            }
                        } else if (NotificationLite.isComplete(poll2)) {
                            aVar.clear();
                            eAE();
                            if (!this.cancelled) {
                                this.cancelled = true;
                                uVar.onComplete();
                            }
                        } else {
                            uVar.onNext((Object) NotificationLite.getValue(poll2));
                        }
                    }
                } else {
                    i = this.wip.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }
}
