package f.b.x.d;

import f.b.o;
import f.b.x.a.e;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public final class a<T> implements o<T> {

    /* renamed from: e  reason: collision with root package name */
    public final e<T> f68631e;

    /* renamed from: f  reason: collision with root package name */
    public f.b.t.b f68632f;

    public a(e<T> eVar) {
        this.f68631e = eVar;
    }

    @Override // f.b.o
    public void onComplete() {
        this.f68631e.c(this.f68632f);
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.f68631e.d(th, this.f68632f);
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.f68631e.e(t, this.f68632f);
    }

    @Override // f.b.o
    public void onSubscribe(f.b.t.b bVar) {
        if (DisposableHelper.validate(this.f68632f, bVar)) {
            this.f68632f = bVar;
            this.f68631e.f(bVar);
        }
    }
}
