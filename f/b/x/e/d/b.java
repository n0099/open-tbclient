package f.b.x.e.d;

import f.b.l;
import f.b.o;
import f.b.r;
import f.b.s;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public final class b<T> extends l<T> {

    /* renamed from: e  reason: collision with root package name */
    public final s<? extends T> f68674e;

    /* loaded from: classes7.dex */
    public static final class a<T> implements r<T>, f.b.t.b {

        /* renamed from: e  reason: collision with root package name */
        public final o<? super T> f68675e;

        /* renamed from: f  reason: collision with root package name */
        public f.b.t.b f68676f;

        public a(o<? super T> oVar) {
            this.f68675e = oVar;
        }

        @Override // f.b.t.b
        public void dispose() {
            this.f68676f.dispose();
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return this.f68676f.isDisposed();
        }

        @Override // f.b.r
        public void onError(Throwable th) {
            this.f68675e.onError(th);
        }

        @Override // f.b.r
        public void onSubscribe(f.b.t.b bVar) {
            if (DisposableHelper.validate(this.f68676f, bVar)) {
                this.f68676f = bVar;
                this.f68675e.onSubscribe(this);
            }
        }

        @Override // f.b.r
        public void onSuccess(T t) {
            this.f68675e.onNext(t);
            this.f68675e.onComplete();
        }
    }

    public b(s<? extends T> sVar) {
        this.f68674e = sVar;
    }

    @Override // f.b.l
    public void b(o<? super T> oVar) {
        this.f68674e.a(new a(oVar));
    }
}
