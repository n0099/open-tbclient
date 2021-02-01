package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class SingleAmb<T> extends w<T> {
    private final Iterable<? extends aa<? extends T>> qnX;
    private final aa<? extends T>[] qqb;

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        int length;
        Object[] objArr;
        aa<? extends T>[] aaVarArr = this.qqb;
        if (aaVarArr == null) {
            aa<? extends T>[] aaVarArr2 = new aa[8];
            try {
                int i = 0;
                aa<? extends T>[] aaVarArr3 = aaVarArr2;
                for (aa<? extends T> aaVar : this.qnX) {
                    if (aaVar == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), yVar);
                        return;
                    }
                    int length2 = aaVarArr3.length;
                    aa<? extends T>[] aaVarArr4 = aaVarArr3;
                    if (i == length2) {
                        aa<? extends T>[] aaVarArr5 = new aa[(i >> 2) + i];
                        System.arraycopy(aaVarArr3, 0, aaVarArr5, 0, i);
                        aaVarArr4 = aaVarArr5;
                    }
                    int i2 = i + 1;
                    aaVarArr4[i] = aaVar;
                    i = i2;
                    aaVarArr3 = aaVarArr4;
                }
                length = i;
                objArr = aaVarArr3;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.N(th);
                EmptyDisposable.error(th, yVar);
                return;
            }
        } else {
            length = aaVarArr.length;
            objArr = aaVarArr;
        }
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        AmbSingleObserver ambSingleObserver = new AmbSingleObserver(yVar, aVar);
        yVar.onSubscribe(aVar);
        for (int i3 = 0; i3 < length; i3++) {
            aa<? extends T> aaVar2 = objArr[i3];
            if (!ambSingleObserver.get()) {
                if (aaVar2 == null) {
                    aVar.dispose();
                    NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                    if (ambSingleObserver.compareAndSet(false, true)) {
                        yVar.onError(nullPointerException);
                        return;
                    } else {
                        io.reactivex.d.a.onError(nullPointerException);
                        return;
                    }
                }
                aaVar2.a(ambSingleObserver);
            } else {
                return;
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class AmbSingleObserver<T> extends AtomicBoolean implements y<T> {
        private static final long serialVersionUID = -1944085461036028108L;
        final y<? super T> s;
        final io.reactivex.disposables.a set;

        AmbSingleObserver(y<? super T> yVar, io.reactivex.disposables.a aVar) {
            this.s = yVar;
            this.set = aVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.set.a(bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onSuccess(t);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onError(th);
                return;
            }
            io.reactivex.d.a.onError(th);
        }
    }
}
