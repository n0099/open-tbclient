package f.a.x.e.d;

import f.a.l;
import f.a.o;
import f.a.r;
import f.a.s;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public final class b<T> extends l<T> {

    /* renamed from: e  reason: collision with root package name */
    public final s<? extends T> f67521e;

    /* loaded from: classes7.dex */
    public static final class a<T> implements r<T>, f.a.t.b {

        /* renamed from: e  reason: collision with root package name */
        public final o<? super T> f67522e;

        /* renamed from: f  reason: collision with root package name */
        public f.a.t.b f67523f;

        public a(o<? super T> oVar) {
            this.f67522e = oVar;
        }

        @Override // f.a.t.b
        public void dispose() {
            this.f67523f.dispose();
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return this.f67523f.isDisposed();
        }

        @Override // f.a.r
        public void onError(Throwable th) {
            this.f67522e.onError(th);
        }

        @Override // f.a.r
        public void onSubscribe(f.a.t.b bVar) {
            if (DisposableHelper.validate(this.f67523f, bVar)) {
                this.f67523f = bVar;
                this.f67522e.onSubscribe(this);
            }
        }

        @Override // f.a.r
        public void onSuccess(T t) {
            this.f67522e.onNext(t);
            this.f67522e.onComplete();
        }
    }

    public b(s<? extends T> sVar) {
        this.f67521e = sVar;
    }

    @Override // f.a.l
    public void b(o<? super T> oVar) {
        this.f67521e.a(new a(oVar));
    }
}
