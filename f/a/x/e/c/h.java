package f.a.x.e.c;

import io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable;
/* loaded from: classes7.dex */
public interface h<T> {
    void complete();

    void error(Throwable th);

    void next(T t);

    void replay(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable);
}
