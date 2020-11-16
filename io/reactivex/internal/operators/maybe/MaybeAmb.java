package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class MaybeAmb<T> extends k<T> {
    private final Iterable<? extends o<? extends T>> pOo;
    private final o<? extends T>[] sources;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        int length;
        o<? extends T>[] oVarArr = this.sources;
        if (oVarArr == null) {
            o<? extends T>[] oVarArr2 = new o[8];
            try {
                int i = 0;
                for (o<? extends T> oVar : this.pOo) {
                    if (oVar == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), mVar);
                        return;
                    }
                    if (i == oVarArr2.length) {
                        o<? extends T>[] oVarArr3 = new o[(i >> 2) + i];
                        System.arraycopy(oVarArr2, 0, oVarArr3, 0, i);
                        oVarArr2 = oVarArr3;
                    }
                    int i2 = i + 1;
                    oVarArr2[i] = oVar;
                    i = i2;
                }
                length = i;
                oVarArr = oVarArr2;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                EmptyDisposable.error(th, mVar);
                return;
            }
        } else {
            length = oVarArr.length;
        }
        AmbMaybeObserver ambMaybeObserver = new AmbMaybeObserver(mVar);
        mVar.onSubscribe(ambMaybeObserver);
        for (int i3 = 0; i3 < length; i3++) {
            o<? extends T> oVar2 = oVarArr[i3];
            if (!ambMaybeObserver.isDisposed()) {
                if (oVar2 == null) {
                    ambMaybeObserver.onError(new NullPointerException("One of the MaybeSources is null"));
                    return;
                }
                oVar2.a(ambMaybeObserver);
            } else {
                return;
            }
        }
        if (length == 0) {
            mVar.onComplete();
        }
    }

    /* loaded from: classes5.dex */
    static final class AmbMaybeObserver<T> extends AtomicBoolean implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -7044685185359438206L;
        final m<? super T> actual;
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();

        AmbMaybeObserver(m<? super T> mVar) {
            this.actual = mVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.set.a(bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onSuccess(t);
            }
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.actual.onComplete();
            }
        }
    }
}
