package f.a.x.e.d;

import f.a.l;
import f.a.o;
import f.a.r;
import f.a.s;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public final class b<T> extends l<T> {

    /* renamed from: e  reason: collision with root package name */
    public final s<? extends T> f67516e;

    /* loaded from: classes7.dex */
    public static final class a<T> implements r<T>, f.a.t.b {

        /* renamed from: e  reason: collision with root package name */
        public final o<? super T> f67517e;

        /* renamed from: f  reason: collision with root package name */
        public f.a.t.b f67518f;

        public a(o<? super T> oVar) {
            this.f67517e = oVar;
        }

        @Override // f.a.t.b
        public void dispose() {
            this.f67518f.dispose();
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return this.f67518f.isDisposed();
        }

        @Override // f.a.r
        public void onError(Throwable th) {
            this.f67517e.onError(th);
        }

        @Override // f.a.r
        public void onSubscribe(f.a.t.b bVar) {
            if (DisposableHelper.validate(this.f67518f, bVar)) {
                this.f67518f = bVar;
                this.f67517e.onSubscribe(this);
            }
        }

        @Override // f.a.r
        public void onSuccess(T t) {
            this.f67517e.onNext(t);
            this.f67517e.onComplete();
        }
    }

    public b(s<? extends T> sVar) {
        this.f67516e = sVar;
    }

    @Override // f.a.l
    public void b(o<? super T> oVar) {
        this.f67516e.a(new a(oVar));
    }
}
