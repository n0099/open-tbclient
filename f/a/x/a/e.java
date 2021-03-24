package f.a.x.a;

import f.a.o;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.NotificationLite;
/* loaded from: classes7.dex */
public final class e<T> extends c implements f.a.t.b {

    /* renamed from: f  reason: collision with root package name */
    public final o<? super T> f67470f;

    /* renamed from: g  reason: collision with root package name */
    public final f.a.x.f.a<Object> f67471g;

    /* renamed from: h  reason: collision with root package name */
    public volatile f.a.t.b f67472h = EmptyDisposable.INSTANCE;
    public f.a.t.b i;
    public volatile boolean j;

    public e(o<? super T> oVar, f.a.t.b bVar, int i) {
        this.f67470f = oVar;
        this.i = bVar;
        this.f67471g = new f.a.x.f.a<>(i);
    }

    public void a() {
        f.a.t.b bVar = this.i;
        this.i = null;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public void b() {
        if (this.f67469e.getAndIncrement() != 0) {
            return;
        }
        f.a.x.f.a<Object> aVar = this.f67471g;
        o<? super T> oVar = this.f67470f;
        int i = 1;
        while (true) {
            Object poll = aVar.poll();
            if (poll == null) {
                i = this.f67469e.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object poll2 = aVar.poll();
                if (poll == this.f67472h) {
                    if (NotificationLite.isDisposable(poll2)) {
                        f.a.t.b disposable = NotificationLite.getDisposable(poll2);
                        this.f67472h.dispose();
                        if (!this.j) {
                            this.f67472h = disposable;
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
                            f.a.a0.a.f(error);
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

    public void c(f.a.t.b bVar) {
        this.f67471g.l(bVar, NotificationLite.complete());
        b();
    }

    public void d(Throwable th, f.a.t.b bVar) {
        if (this.j) {
            f.a.a0.a.f(th);
            return;
        }
        this.f67471g.l(bVar, NotificationLite.error(th));
        b();
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.j) {
            return;
        }
        this.j = true;
        a();
    }

    public boolean e(T t, f.a.t.b bVar) {
        if (this.j) {
            return false;
        }
        this.f67471g.l(bVar, NotificationLite.next(t));
        b();
        return true;
    }

    public boolean f(f.a.t.b bVar) {
        if (this.j) {
            return false;
        }
        this.f67471g.l(this.f67472h, NotificationLite.disposable(bVar));
        b();
        return true;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        f.a.t.b bVar = this.i;
        return bVar != null ? bVar.isDisposed() : this.j;
    }
}
