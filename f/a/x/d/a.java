package f.a.x.d;

import f.a.o;
import f.a.x.a.e;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public final class a<T> implements o<T> {

    /* renamed from: e  reason: collision with root package name */
    public final e<T> f67478e;

    /* renamed from: f  reason: collision with root package name */
    public f.a.t.b f67479f;

    public a(e<T> eVar) {
        this.f67478e = eVar;
    }

    @Override // f.a.o
    public void onComplete() {
        this.f67478e.c(this.f67479f);
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.f67478e.d(th, this.f67479f);
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.f67478e.e(t, this.f67479f);
    }

    @Override // f.a.o
    public void onSubscribe(f.a.t.b bVar) {
        if (DisposableHelper.validate(this.f67479f, bVar)) {
            this.f67479f = bVar;
            this.f67478e.f(bVar);
        }
    }
}
