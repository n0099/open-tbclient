package f.b.x.e.d;

import f.b.l;
import f.b.o;
import f.b.r;
import f.b.s;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public final class b<T> extends l<T> {

    /* renamed from: e  reason: collision with root package name */
    public final s<? extends T> f68527e;

    /* loaded from: classes7.dex */
    public static final class a<T> implements r<T>, f.b.t.b {

        /* renamed from: e  reason: collision with root package name */
        public final o<? super T> f68528e;

        /* renamed from: f  reason: collision with root package name */
        public f.b.t.b f68529f;

        public a(o<? super T> oVar) {
            this.f68528e = oVar;
        }

        @Override // f.b.t.b
        public void dispose() {
            this.f68529f.dispose();
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return this.f68529f.isDisposed();
        }

        @Override // f.b.r
        public void onError(Throwable th) {
            this.f68528e.onError(th);
        }

        @Override // f.b.r
        public void onSubscribe(f.b.t.b bVar) {
            if (DisposableHelper.validate(this.f68529f, bVar)) {
                this.f68529f = bVar;
                this.f68528e.onSubscribe(this);
            }
        }

        @Override // f.b.r
        public void onSuccess(T t) {
            this.f68528e.onNext(t);
            this.f68528e.onComplete();
        }
    }

    public b(s<? extends T> sVar) {
        this.f68527e = sVar;
    }

    @Override // f.b.l
    public void b(o<? super T> oVar) {
        this.f68527e.a(new a(oVar));
    }
}
