package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class MaybeAmb<T> extends k<T> {
    private final Iterable<? extends o<? extends T>> qnX;
    private final o<? extends T>[] sources;

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        int length;
        Object[] objArr;
        o<? extends T>[] oVarArr = this.sources;
        if (oVarArr == null) {
            o<? extends T>[] oVarArr2 = new o[8];
            try {
                int i = 0;
                o<? extends T>[] oVarArr3 = oVarArr2;
                for (o<? extends T> oVar : this.qnX) {
                    if (oVar == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), mVar);
                        return;
                    }
                    int length2 = oVarArr3.length;
                    o<? extends T>[] oVarArr4 = oVarArr3;
                    if (i == length2) {
                        o<? extends T>[] oVarArr5 = new o[(i >> 2) + i];
                        System.arraycopy(oVarArr3, 0, oVarArr5, 0, i);
                        oVarArr4 = oVarArr5;
                    }
                    int i2 = i + 1;
                    oVarArr4[i] = oVar;
                    i = i2;
                    oVarArr3 = oVarArr4;
                }
                length = i;
                objArr = oVarArr3;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.N(th);
                EmptyDisposable.error(th, mVar);
                return;
            }
        } else {
            length = oVarArr.length;
            objArr = oVarArr;
        }
        AmbMaybeObserver ambMaybeObserver = new AmbMaybeObserver(mVar);
        mVar.onSubscribe(ambMaybeObserver);
        for (int i3 = 0; i3 < length; i3++) {
            o<? extends T> oVar2 = objArr[i3];
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
            io.reactivex.d.a.onError(th);
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
