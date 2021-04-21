package f.b.x.a;

import f.b.o;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.NotificationLite;
/* loaded from: classes7.dex */
public final class e<T> extends c implements f.b.t.b {

    /* renamed from: f  reason: collision with root package name */
    public final o<? super T> f68628f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.x.f.a<Object> f68629g;

    /* renamed from: h  reason: collision with root package name */
    public volatile f.b.t.b f68630h = EmptyDisposable.INSTANCE;
    public f.b.t.b i;
    public volatile boolean j;

    public e(o<? super T> oVar, f.b.t.b bVar, int i) {
        this.f68628f = oVar;
        this.i = bVar;
        this.f68629g = new f.b.x.f.a<>(i);
    }

    public void a() {
        f.b.t.b bVar = this.i;
        this.i = null;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public void b() {
        if (this.f68627e.getAndIncrement() != 0) {
            return;
        }
        f.b.x.f.a<Object> aVar = this.f68629g;
        o<? super T> oVar = this.f68628f;
        int i = 1;
        while (true) {
            Object poll = aVar.poll();
            if (poll == null) {
                i = this.f68627e.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object poll2 = aVar.poll();
                if (poll == this.f68630h) {
                    if (NotificationLite.isDisposable(poll2)) {
                        f.b.t.b disposable = NotificationLite.getDisposable(poll2);
                        this.f68630h.dispose();
                        if (!this.j) {
                            this.f68630h = disposable;
                        } else {
                            disposable.dispose();
                        }
                    } else if (NotificationLite.isError(poll2)) {
                        aVar.clear();
                        a();
                        Throwable error = NotificationLite.getError(poll2);
                        if (!this.j) {
                            this.j = true;
                            oVar.onError(error);
                        } else {
                            f.b.a0.a.f(error);
                        }
                    } else if (NotificationLite.isComplete(poll2)) {
                        aVar.clear();
                        a();
                        if (!this.j) {
                            this.j = true;
                            oVar.onComplete();
                        }
                    } else {
                        oVar.onNext((Object) NotificationLite.getValue(poll2));
                    }
                }
            }
        }
    }

    public void c(f.b.t.b bVar) {
        this.f68629g.l(bVar, NotificationLite.complete());
        b();
    }

    public void d(Throwable th, f.b.t.b bVar) {
        if (this.j) {
            f.b.a0.a.f(th);
            return;
        }
        this.f68629g.l(bVar, NotificationLite.error(th));
        b();
    }

    @Override // f.b.t.b
    public void dispose() {
        if (this.j) {
            return;
        }
        this.j = true;
        a();
    }

    public boolean e(T t, f.b.t.b bVar) {
        if (this.j) {
            return false;
        }
        this.f68629g.l(bVar, NotificationLite.next(t));
        b();
        return true;
    }

    public boolean f(f.b.t.b bVar) {
        if (this.j) {
            return false;
        }
        this.f68629g.l(this.f68630h, NotificationLite.disposable(bVar));
        b();
        return true;
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        f.b.t.b bVar = this.i;
        return bVar != null ? bVar.isDisposed() : this.j;
    }
}
